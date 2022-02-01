package com.tencent.hippy.qq.api.impl;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.hippy.qq.api.IPatchBundleDataHandler;
import com.tencent.hippy.qq.app.OnMainBundleLoadListener;
import com.tencent.hippy.qq.patchbundle.PatchBundleConfig;
import com.tencent.hippy.qq.patchbundle.PatchBundleConfig.BundleConfigItem;
import com.tencent.hippy.qq.patchbundle.PatchBundleConfig.SSOListConfig;
import com.tencent.hippy.qq.patchbundle.PatchBundleConfig.SubBundleConfig;
import com.tencent.hippy.qq.patchbundle.PatchBundleTask;
import com.tencent.hippy.qq.patchbundle.PatchUtils;
import com.tencent.hippy.qq.update.UpdateSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class PatchBundleDataHandlerImpl
  implements IPatchBundleDataHandler
{
  private static final String PATCH_CONFIG_URL = "https://qqtuan.qq.com/boodo/boodo-comic/latest/hippy-bundle-manifest.android.json";
  private static final String TAG = "PatchBundleDataHandlerImpl";
  private static SparseArray<HashSet<String>> sLoadedBundlePaths = new SparseArray();
  private static boolean sUpdated;
  private PatchBundleConfig mBundleConfig = PatchBundleConfig.getConfig();
  
  private static void doPromiseCallback(Promise paramPromise, int paramInt, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("code", paramInt);
      localJSONObject.put("message", paramString);
      doPromiseCallback(paramPromise, localJSONObject);
      return;
    }
    catch (Exception paramPromise)
    {
      QLog.e("PatchBundleDataHandlerImpl", 1, "doPromiseCallback", paramPromise);
      return;
    }
    catch (JSONException paramPromise)
    {
      QLog.e("PatchBundleDataHandlerImpl", 1, "doPromiseCallback", paramPromise);
    }
  }
  
  private static void doPromiseCallback(Promise paramPromise, JSONObject paramJSONObject)
  {
    if ((paramPromise != null) && (paramPromise.isCallback()))
    {
      Object localObject = new HippyMap();
      ((HippyMap)localObject).pushJSONObject(paramJSONObject);
      paramPromise.resolve(localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doPromiseCallback promise:");
        ((StringBuilder)localObject).append(paramPromise.getCallId());
        ((StringBuilder)localObject).append(" jsonObject:");
        ((StringBuilder)localObject).append(paramJSONObject);
        QLog.d("PatchBundleDataHandlerImpl", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  /* Error */
  private void downloadPatchConfig(PatchBundleDataHandlerImpl.OnDownloadListener paramOnDownloadListener)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 5
    //   9: iconst_m1
    //   10: istore_3
    //   11: new 141	java/net/URL
    //   14: dup
    //   15: ldc 10
    //   17: invokespecial 144	java/net/URL:<init>	(Ljava/lang/String;)V
    //   20: invokevirtual 148	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   23: checkcast 150	java/net/HttpURLConnection
    //   26: astore 8
    //   28: aload 8
    //   30: iconst_1
    //   31: invokevirtual 154	java/net/HttpURLConnection:setDoInput	(Z)V
    //   34: aload 8
    //   36: invokevirtual 158	java/net/HttpURLConnection:getResponseCode	()I
    //   39: istore_2
    //   40: new 114	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   47: astore 9
    //   49: aload 9
    //   51: ldc 160
    //   53: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 9
    //   59: iload_2
    //   60: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: ldc 13
    //   66: iconst_1
    //   67: aload 9
    //   69: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 166	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: iload_2
    //   76: sipush 304
    //   79: if_icmpne +24 -> 103
    //   82: ldc 13
    //   84: iconst_1
    //   85: ldc 168
    //   87: invokestatic 166	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: aload_1
    //   91: ifnull +11 -> 102
    //   94: aload_1
    //   95: iload_2
    //   96: iconst_0
    //   97: invokeinterface 174 3 0
    //   102: return
    //   103: iload_2
    //   104: sipush 200
    //   107: if_icmpne +138 -> 245
    //   110: aload 8
    //   112: invokevirtual 178	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   115: astore 5
    //   117: new 180	java/io/FileOutputStream
    //   120: dup
    //   121: invokestatic 185	com/tencent/hippy/qq/patchbundle/PatchUtils:getConfigFilePath	()Ljava/lang/String;
    //   124: invokespecial 186	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   127: astore 8
    //   129: sipush 4096
    //   132: newarray byte
    //   134: astore 6
    //   136: aload 5
    //   138: aload 6
    //   140: invokevirtual 192	java/io/InputStream:read	([B)I
    //   143: istore 4
    //   145: iload 4
    //   147: iconst_m1
    //   148: if_icmpeq +16 -> 164
    //   151: aload 8
    //   153: aload 6
    //   155: iconst_0
    //   156: iload 4
    //   158: invokevirtual 196	java/io/FileOutputStream:write	([BII)V
    //   161: goto -25 -> 136
    //   164: aload 5
    //   166: invokevirtual 199	java/io/InputStream:close	()V
    //   169: aload 8
    //   171: invokevirtual 200	java/io/FileOutputStream:close	()V
    //   174: iconst_0
    //   175: istore_3
    //   176: goto +72 -> 248
    //   179: astore 6
    //   181: aload 5
    //   183: astore 7
    //   185: aload 6
    //   187: astore 5
    //   189: aload 8
    //   191: astore 6
    //   193: goto +254 -> 447
    //   196: astore 6
    //   198: aload 5
    //   200: astore 7
    //   202: aload 8
    //   204: astore 5
    //   206: goto +152 -> 358
    //   209: astore 6
    //   211: aconst_null
    //   212: astore 8
    //   214: aload 5
    //   216: astore 7
    //   218: aload 6
    //   220: astore 5
    //   222: aload 8
    //   224: astore 6
    //   226: goto +221 -> 447
    //   229: astore 6
    //   231: aconst_null
    //   232: astore 8
    //   234: aload 5
    //   236: astore 7
    //   238: aload 8
    //   240: astore 5
    //   242: goto +116 -> 358
    //   245: aconst_null
    //   246: astore 8
    //   248: aload 5
    //   250: ifnull +25 -> 275
    //   253: aload 5
    //   255: invokevirtual 199	java/io/InputStream:close	()V
    //   258: goto +17 -> 275
    //   261: astore 5
    //   263: ldc 13
    //   265: iconst_1
    //   266: aload 5
    //   268: iconst_0
    //   269: anewarray 4	java/lang/Object
    //   272: invokestatic 203	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   275: aload 8
    //   277: ifnull +25 -> 302
    //   280: aload 8
    //   282: invokevirtual 200	java/io/FileOutputStream:close	()V
    //   285: goto +17 -> 302
    //   288: astore 5
    //   290: ldc 13
    //   292: iconst_1
    //   293: aload 5
    //   295: iconst_0
    //   296: anewarray 4	java/lang/Object
    //   299: invokestatic 203	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   302: aload_1
    //   303: ifnull +133 -> 436
    //   306: goto +122 -> 428
    //   309: astore 5
    //   311: aconst_null
    //   312: astore 8
    //   314: aload 6
    //   316: astore 7
    //   318: aload 8
    //   320: astore 6
    //   322: goto +125 -> 447
    //   325: astore 6
    //   327: aconst_null
    //   328: astore 5
    //   330: goto +28 -> 358
    //   333: astore 5
    //   335: aconst_null
    //   336: astore 8
    //   338: iconst_m1
    //   339: istore_2
    //   340: aload 6
    //   342: astore 7
    //   344: aload 8
    //   346: astore 6
    //   348: goto +99 -> 447
    //   351: astore 6
    //   353: aconst_null
    //   354: astore 5
    //   356: iconst_m1
    //   357: istore_2
    //   358: ldc 13
    //   360: iconst_1
    //   361: aload 6
    //   363: iconst_0
    //   364: anewarray 4	java/lang/Object
    //   367: invokestatic 203	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   370: aload 7
    //   372: ifnull +25 -> 397
    //   375: aload 7
    //   377: invokevirtual 199	java/io/InputStream:close	()V
    //   380: goto +17 -> 397
    //   383: astore 6
    //   385: ldc 13
    //   387: iconst_1
    //   388: aload 6
    //   390: iconst_0
    //   391: anewarray 4	java/lang/Object
    //   394: invokestatic 203	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   397: aload 5
    //   399: ifnull +25 -> 424
    //   402: aload 5
    //   404: invokevirtual 200	java/io/FileOutputStream:close	()V
    //   407: goto +17 -> 424
    //   410: astore 5
    //   412: ldc 13
    //   414: iconst_1
    //   415: aload 5
    //   417: iconst_0
    //   418: anewarray 4	java/lang/Object
    //   421: invokestatic 203	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   424: aload_1
    //   425: ifnull +11 -> 436
    //   428: aload_1
    //   429: iload_2
    //   430: iload_3
    //   431: invokeinterface 174 3 0
    //   436: return
    //   437: astore 8
    //   439: aload 5
    //   441: astore 6
    //   443: aload 8
    //   445: astore 5
    //   447: aload 7
    //   449: ifnull +25 -> 474
    //   452: aload 7
    //   454: invokevirtual 199	java/io/InputStream:close	()V
    //   457: goto +17 -> 474
    //   460: astore 7
    //   462: ldc 13
    //   464: iconst_1
    //   465: aload 7
    //   467: iconst_0
    //   468: anewarray 4	java/lang/Object
    //   471: invokestatic 203	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   474: aload 6
    //   476: ifnull +25 -> 501
    //   479: aload 6
    //   481: invokevirtual 200	java/io/FileOutputStream:close	()V
    //   484: goto +17 -> 501
    //   487: astore 6
    //   489: ldc 13
    //   491: iconst_1
    //   492: aload 6
    //   494: iconst_0
    //   495: anewarray 4	java/lang/Object
    //   498: invokestatic 203	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   501: aload_1
    //   502: ifnull +11 -> 513
    //   505: aload_1
    //   506: iload_2
    //   507: iconst_m1
    //   508: invokeinterface 174 3 0
    //   513: goto +6 -> 519
    //   516: aload 5
    //   518: athrow
    //   519: goto -3 -> 516
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	522	0	this	PatchBundleDataHandlerImpl
    //   0	522	1	paramOnDownloadListener	PatchBundleDataHandlerImpl.OnDownloadListener
    //   39	468	2	i	int
    //   10	421	3	j	int
    //   143	14	4	k	int
    //   7	247	5	localObject1	Object
    //   261	6	5	localIOException1	java.io.IOException
    //   288	6	5	localIOException2	java.io.IOException
    //   309	1	5	localObject2	Object
    //   328	1	5	localObject3	Object
    //   333	1	5	localObject4	Object
    //   354	49	5	localObject5	Object
    //   410	30	5	localIOException3	java.io.IOException
    //   445	72	5	localObject6	Object
    //   4	150	6	arrayOfByte	byte[]
    //   179	7	6	localObject7	Object
    //   191	1	6	localObject8	Object
    //   196	1	6	localException1	Exception
    //   209	10	6	localObject9	Object
    //   224	1	6	localObject10	Object
    //   229	86	6	localException2	Exception
    //   320	1	6	localObject11	Object
    //   325	16	6	localException3	Exception
    //   346	1	6	localObject12	Object
    //   351	11	6	localException4	Exception
    //   383	6	6	localIOException4	java.io.IOException
    //   441	39	6	localObject13	Object
    //   487	6	6	localIOException5	java.io.IOException
    //   1	452	7	localObject14	Object
    //   460	6	7	localIOException6	java.io.IOException
    //   26	319	8	localObject15	Object
    //   437	7	8	localObject16	Object
    //   47	21	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   129	136	179	finally
    //   136	145	179	finally
    //   151	161	179	finally
    //   164	174	179	finally
    //   129	136	196	java/lang/Exception
    //   136	145	196	java/lang/Exception
    //   151	161	196	java/lang/Exception
    //   164	174	196	java/lang/Exception
    //   117	129	209	finally
    //   117	129	229	java/lang/Exception
    //   253	258	261	java/io/IOException
    //   280	285	288	java/io/IOException
    //   40	75	309	finally
    //   82	90	309	finally
    //   110	117	309	finally
    //   40	75	325	java/lang/Exception
    //   82	90	325	java/lang/Exception
    //   110	117	325	java/lang/Exception
    //   11	40	333	finally
    //   11	40	351	java/lang/Exception
    //   375	380	383	java/io/IOException
    //   402	407	410	java/io/IOException
    //   358	370	437	finally
    //   452	457	460	java/io/IOException
    //   479	484	487	java/io/IOException
  }
  
  public static PatchBundleConfig getBundleConfig()
  {
    return PatchBundleConfig.getConfig();
  }
  
  private void loadJsBundle(HippyEngineContext paramHippyEngineContext, int paramInt, File paramFile, Promise paramPromise)
  {
    ThreadManagerV2.postImmediately(new PatchBundleDataHandlerImpl.8(this, paramHippyEngineContext, paramFile, paramPromise, paramInt), null, false);
  }
  
  public static void onHippyTaskDestroy(HippyEngineContext paramHippyEngineContext)
  {
    if (paramHippyEngineContext != null) {
      sLoadedBundlePaths.remove(paramHippyEngineContext.hashCode());
    }
  }
  
  public static void promiseSSOData(Promise paramPromise, int paramInt, String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("code", paramInt);
      localJSONObject.put("message", paramString1);
      localJSONObject.put("data", paramString2);
      doPromiseCallback(paramPromise, localJSONObject);
      return;
    }
    catch (Exception paramPromise)
    {
      QLog.e("PatchBundleDataHandlerImpl", 1, "promiseSSOData ", paramPromise);
      return;
    }
    catch (JSONException paramPromise)
    {
      QLog.e("PatchBundleDataHandlerImpl", 1, "promiseSSOData ", paramPromise);
    }
  }
  
  public OnMainBundleLoadListener checkCreateHippyListener(String paramString)
  {
    if (!this.mBundleConfig.getSubBundleConfig().containsKey(paramString)) {
      return null;
    }
    return new PatchBundleTask(paramString);
  }
  
  public void checkDownloadConfigAsync(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("PatchBundleDataHandlerImpl", 2, "checkDownloadConfig");
    }
    Object localObject = MobileQQ.sMobileQQ;
    localObject = MobileQQ.getContext().getSharedPreferences("patchBundleSp", 4);
    long l2 = ((SharedPreferences)localObject).getLong("last_check_config_ts", 0L);
    boolean bool = sUpdated;
    int i;
    if (System.currentTimeMillis() - l2 > 1800000L) {
      i = 1;
    } else {
      i = bool ^ true;
    }
    localObject = new PatchBundleDataHandlerImpl.1(this, (SharedPreferences)localObject, paramBoolean1, paramBoolean2, l1);
    if (i != 0)
    {
      ThreadManagerV2.excute(new PatchBundleDataHandlerImpl.2(this, (PatchBundleDataHandlerImpl.OnDownloadListener)localObject), 128, null, false);
      return;
    }
    ThreadManagerV2.excute(new PatchBundleDataHandlerImpl.3(this, (PatchBundleDataHandlerImpl.OnDownloadListener)localObject), 64, null, false);
  }
  
  public JSONObject checkWrapSSOData(JSONObject paramJSONObject, String paramString)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    if (TextUtils.isEmpty(paramString)) {
      return localJSONObject;
    }
    paramJSONObject = getBundleConfig();
    if (!paramJSONObject.isSwitchOpen())
    {
      QLog.i("PatchBundleDataHandlerImpl", 1, "checkWrapSSOData !patchBundleConfig.isSwitchOpen()");
      return localJSONObject;
    }
    paramJSONObject = (PatchBundleConfig.SubBundleConfig)paramJSONObject.getSubBundleConfig().get(paramString);
    if ((paramJSONObject != null) && (!paramJSONObject.mSubConfigs.isEmpty()))
    {
      int i = UpdateSetting.getInstance().getModuleVersion(paramString);
      if (!paramJSONObject.mSupportVersions.contains(String.valueOf(i)))
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("checkWrapSSOData no support version:");
        paramJSONObject.append(i);
        QLog.i("PatchBundleDataHandlerImpl", 1, paramJSONObject.toString());
        return localJSONObject;
      }
      if (paramJSONObject != null)
      {
        paramString = (PatchBundleConfig.BundleConfigItem)paramJSONObject.mSubConfigs.get(paramString);
        if (paramString != null) {
          try
          {
            paramJSONObject = new JSONObject();
            paramString = paramString.mSSOList.iterator();
            while (paramString.hasNext())
            {
              PatchBundleConfig.SSOListConfig localSSOListConfig = (PatchBundleConfig.SSOListConfig)paramString.next();
              if (!TextUtils.isEmpty(localSSOListConfig.mRsp)) {
                paramJSONObject.put(localSSOListConfig.mKey, localSSOListConfig.mRsp);
              }
            }
            localJSONObject.put("ssoDataList", paramJSONObject);
          }
          catch (JSONException paramJSONObject)
          {
            QLog.e("PatchBundleDataHandlerImpl", 1, paramJSONObject, new Object[0]);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PatchBundleDataHandlerImpl", 2, new Object[] { "patch initJson:", localJSONObject });
      }
      return localJSONObject;
    }
    QLog.i("PatchBundleDataHandlerImpl", 1, "checkWrapSSOData no need patch bundle");
    return localJSONObject;
  }
  
  public void getSSOListData(HippyMap paramHippyMap, Promise paramPromise)
  {
    String str = paramHippyMap.getString("id");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getSSOListData data:");
    ((StringBuilder)localObject).append(paramHippyMap);
    QLog.i("PatchBundleDataHandlerImpl", 1, ((StringBuilder)localObject).toString());
    localObject = getSSoListConfig(str);
    if (localObject == null)
    {
      localObject = new PatchBundleConfig.SSOListConfig();
      ((PatchBundleConfig.SSOListConfig)localObject).mType = paramHippyMap.getString("type");
      ((PatchBundleConfig.SSOListConfig)localObject).mKey = paramHippyMap.getString("id");
      ((PatchBundleConfig.SSOListConfig)localObject).mCmd = paramHippyMap.getString("cmd");
      ((PatchBundleConfig.SSOListConfig)localObject).mMethod = paramHippyMap.getString("method");
      ((PatchBundleConfig.SSOListConfig)localObject).mNeedCookie = paramHippyMap.getBoolean("needCookie");
      ((PatchBundleConfig.SSOListConfig)localObject).mParam = paramHippyMap.getString("param");
      paramHippyMap = (HippyMap)localObject;
    }
    else
    {
      paramHippyMap = new StringBuilder();
      paramHippyMap.append("use prefetch sso data id:");
      paramHippyMap.append(str);
      QLog.i("PatchBundleDataHandlerImpl", 1, paramHippyMap.toString());
      paramHippyMap = (HippyMap)localObject;
    }
    paramHippyMap.loadCache();
    int i;
    if (!TextUtils.isEmpty(paramHippyMap.mRsp)) {
      i = paramHippyMap.mRsp.hashCode();
    } else {
      i = 0;
    }
    if (!TextUtils.isEmpty(paramHippyMap.mRsp)) {
      promiseSSOData(paramPromise, 0, "ok", paramHippyMap.mRsp);
    }
    paramHippyMap.handleSSOConfigData(new PatchBundleDataHandlerImpl.5(this, i, paramPromise));
  }
  
  public PatchBundleConfig.SSOListConfig getSSoListConfig(String paramString)
  {
    Iterator localIterator1 = this.mBundleConfig.getSubBundleConfig().values().iterator();
    label16:
    if (localIterator1.hasNext())
    {
      label74:
      PatchBundleConfig.SSOListConfig localSSOListConfig;
      do
      {
        Iterator localIterator2 = ((PatchBundleConfig.SubBundleConfig)localIterator1.next()).mSubConfigs.values().iterator();
        break label74;
        if (!localIterator2.hasNext()) {
          break label16;
        }
        Iterator localIterator3 = ((PatchBundleConfig.BundleConfigItem)localIterator2.next()).mSSOList.iterator();
        if (!localIterator3.hasNext()) {
          break;
        }
        localSSOListConfig = (PatchBundleConfig.SSOListConfig)localIterator3.next();
      } while (!paramString.equals(localSSOListConfig.mKey));
      return localSSOListConfig;
    }
    return null;
  }
  
  public boolean isRunPatch(HippyEngineContext paramHippyEngineContext)
  {
    return PatchBundleTask.isRunPatch(paramHippyEngineContext);
  }
  
  public void loadPatchFromUrl(HippyEngineContext paramHippyEngineContext, String paramString, int paramInt, Promise paramPromise)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject1 = PatchBundleTask.getPatchTask(paramHippyEngineContext);
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PatchBundleDataHandlerImpl", 2, new Object[] { "loadPatchFromUrl from patchBundleTask url:", paramString });
        }
        ((PatchBundleTask)localObject1).patchBundleLoop(paramString, new PatchBundleDataHandlerImpl.6(this, paramPromise));
        return;
      }
      localObject1 = new File(PatchUtils.getBundleFilePath(paramString));
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("loadPatchFromUrl direct from url dstFile:");
        ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
        QLog.d("PatchBundleDataHandlerImpl", 2, ((StringBuilder)localObject2).toString());
      }
      if ((((File)localObject1).exists()) && (((File)localObject1).length() > 0L))
      {
        loadJsBundle(paramHippyEngineContext, paramInt, (File)localObject1, paramPromise);
        return;
      }
      Object localObject2 = ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).getDownloader(5);
      if (localObject2 == null)
      {
        QLog.e("PatchBundleDataHandlerImpl", 1, "loadPatchFromUrl checkDownloadBundle downloaderFactory == null");
        doPromiseCallback(paramPromise, -1, "downloaderFactory == null");
        return;
      }
      DownloadTask localDownloadTask = new DownloadTask(paramString, (File)localObject1);
      localDownloadTask.p = true;
      localDownloadTask.n = false;
      localDownloadTask.f = "hippy_patch";
      localDownloadTask.b = 1;
      localDownloadTask.r = true;
      ((DownloaderInterface)localObject2).startDownload(localDownloadTask, new PatchBundleDataHandlerImpl.7(this, (File)localObject1, paramHippyEngineContext, paramInt, paramPromise, paramString), null);
      return;
    }
    doPromiseCallback(paramPromise, -1, "url == null");
  }
  
  public void onAppAsyncStepStart()
  {
    checkDownloadConfigAsync(true, false);
    new PatchBundleDataHandlerImpl.4(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.api.impl.PatchBundleDataHandlerImpl
 * JD-Core Version:    0.7.0.1
 */