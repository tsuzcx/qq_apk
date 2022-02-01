package com.tencent.ark.open.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.Logger;
import com.tencent.ark.ark;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.ArkAppInfo.AppDesc;
import com.tencent.ark.open.ArkAppInfo.AppDownloadInfo;
import com.tencent.ark.open.delegate.ArkDelegateManager;
import com.tencent.ark.open.delegate.IArkDelegateNet;
import com.tencent.ark.open.delegate.IArkDelegateSSO;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkAppCGIMgr
{
  public static final int AppUpdateState_NeedUpdate = 1;
  public static final int AppUpdateState_NoUpdate = 2;
  public static final int AppUpdateState_None = 0;
  public static final int AppUpdateState_Offline = 3;
  private static final int DEFAULT_UPDATE_APP_INTERVAL = 300;
  private static final ArkEnvironmentManager ENV = ;
  private static final int MIN_UPDATE_APP_INTERVAL = 60;
  private static final int QUERY_APP_INFO_LIMIT;
  private static final String TAG = "ArkApp.ArkAppCGIMgr";
  private static PublicKey mAppPackagePubKey;
  private final ArrayList<ArkAppCGIMgr.QueryTask> mTaskList = new ArrayList();
  
  static
  {
    int i;
    if (ArkEnvironmentManager.getInstance().getDebugFlag()) {
      i = 2;
    } else {
      i = 10;
    }
    QUERY_APP_INFO_LIMIT = i;
  }
  
  private static String getAppUpdateReqString(ArrayList<ArkAppCGIMgr.AppNameVersion> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return null;
      }
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("os", "android");
        localJSONObject1.put("platformVer", ark.arkGetPlatformVersion());
        localJSONObject1.put("minPlatformVer", ark.arkGetMinPlatformVersion());
        JSONArray localJSONArray = new JSONArray();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          ArkAppCGIMgr.AppNameVersion localAppNameVersion = (ArkAppCGIMgr.AppNameVersion)paramArrayList.next();
          if (!TextUtils.isEmpty(localAppNameVersion.appName))
          {
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("app", localAppNameVersion.appName);
            boolean bool = TextUtils.isEmpty(localAppNameVersion.appVersion);
            if (bool) {
              localJSONObject2.put("ver", "0.0.0.0");
            } else {
              localJSONObject2.put("ver", localAppNameVersion.appVersion);
            }
            if (!TextUtils.isEmpty(localAppNameVersion.expectAppVersion)) {
              localJSONObject2.put("expectVersion", localAppNameVersion.expectAppVersion);
            }
            localJSONObject2.put("cfgver", ArkAppConfigMgr.getInstance().getAppConfigVersion(localAppNameVersion.appName));
            localJSONArray.put(localJSONObject2);
          }
        }
        localJSONObject1.put("apps", localJSONArray);
        localJSONObject1.put("qqVer", ArkEnvironmentManager.getInstance().getQQVersion());
        localJSONObject1.put("supportTemplate", 0);
        paramArrayList = localJSONObject1.toString();
        return paramArrayList;
      }
      catch (JSONException paramArrayList)
      {
        Logger.logI("ArkApp.ArkAppCGIMgr", String.format("getAppUpdateReqString, exception: %s", new Object[] { paramArrayList.getMessage() }));
      }
    }
    return null;
  }
  
  private static PublicKey getArkAppPackagePubliceKey()
  {
    try
    {
      if (mAppPackagePubKey != null)
      {
        localObject1 = mAppPackagePubKey;
        return localObject1;
      }
      Object localObject1 = new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDEm0juTTzu7HrGYmuzivAGFHszLkHfJjcy0+yzNRTaSfoH0Xqcdy2766NJxfVmxKpC69IpPXcElY7ywJ/0jwO40pQ+cQDc5buM9T7SWZYGZ1k4eKSAJR31jf5i6xTgKxhN2gLMMBboKs0DYH77cdEOI4/yXhX0HdctT3ZR6YIq3QIDAQAB", 0));
      try
      {
        mAppPackagePubKey = KeyFactory.getInstance("RSA").generatePublic((KeySpec)localObject1);
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("generatePublic fail, Exception:");
        localStringBuilder.append(localException.getMessage());
        Logger.logI("ArkApp.ArkAppCGIMgr", localStringBuilder.toString());
      }
      PublicKey localPublicKey = mAppPackagePubKey;
      return localPublicKey;
    }
    finally {}
  }
  
  public static ArkAppCGIMgr getInstance()
  {
    return ArkAppCGIMgr.Holder.gInstance;
  }
  
  private boolean mergeRequestByUrl(String paramString, Object paramObject, ArkAppCGIMgr.ArkAppCGICallback paramArkAppCGICallback)
  {
    synchronized (this.mTaskList)
    {
      Iterator localIterator = this.mTaskList.iterator();
      while (localIterator.hasNext())
      {
        ArkAppCGIMgr.QueryTask localQueryTask = (ArkAppCGIMgr.QueryTask)localIterator.next();
        if (localQueryTask.url.equalsIgnoreCase(paramString))
        {
          localQueryTask.userdata.add(paramObject);
          localQueryTask.callback.add(paramArkAppCGICallback);
          return true;
        }
      }
      return false;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  protected static void onDownloadAppPackage(ArkAppCGIMgr.QueryTask_DownloadAppPackage paramQueryTask_DownloadAppPackage, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if (!paramBoolean)
    {
      Logger.logI("ArkApp.ArkAppCGIMgr", String.format("onDownloadAppPackage: net fail, url=%s", new Object[] { paramQueryTask_DownloadAppPackage.url }));
    }
    else
    {
      if ((paramQueryTask_DownloadAppPackage.appSign != null) && (verifyAppPackage(paramArrayOfByte, paramQueryTask_DownloadAppPackage.appSign))) {
        break label74;
      }
      Logger.logI("ArkApp.ArkAppCGIMgr", String.format("onDownloadAppPackage: verifyAppPackage fail, url=%s", new Object[] { paramQueryTask_DownloadAppPackage.url }));
    }
    paramArrayOfByte = null;
    label74:
    int i = 0;
    while (i < paramQueryTask_DownloadAppPackage.callback.size())
    {
      Object localObject = paramQueryTask_DownloadAppPackage.userdata.get(i);
      ArkAppCGIMgr.ArkAppCGICallback localArkAppCGICallback = (ArkAppCGIMgr.ArkAppCGICallback)paramQueryTask_DownloadAppPackage.callback.get(i);
      if (localArkAppCGICallback != null)
      {
        if (paramArrayOfByte != null) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        localArkAppCGICallback.onDownloadAppPackage(paramBoolean, paramArrayOfByte, localObject);
      }
      i += 1;
    }
  }
  
  private void onHttpRequestResult(ArkAppCGIMgr.QueryTask paramQueryTask, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    new Handler(Looper.getMainLooper()).post(new ArkAppCGIMgr.6(this, paramQueryTask, paramBoolean, paramArrayOfByte));
  }
  
  private ArkAppCGIMgr.QueryAppInfoByAppNameBatchResult parserReply_queryAppInfoByAppNameBatch(String paramString)
  {
    if (ArkEnvironmentManager.getInstance().getDebugFlag()) {
      Logger.logI("ArkApp.ArkAppCGIMgr", String.format("ArkTemp.ArkSafe.parserReply_queryAppInfoByAppNameBatch,config=%s", new Object[] { paramString }));
    }
    ArkAppCGIMgr.QueryAppInfoByAppNameBatchResult localQueryAppInfoByAppNameBatchResult = new ArkAppCGIMgr.QueryAppInfoByAppNameBatchResult();
    localQueryAppInfoByAppNameBatchResult.updateInterval = 0;
    if (paramString == null)
    {
      Logger.logI("ArkApp.ArkAppCGIMgr", "parserReply_queryAppInfoByAppNameBatch, data is empty");
      return localQueryAppInfoByAppNameBatchResult;
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString).optJSONObject("data");
        if (paramString == null)
        {
          Logger.logI("ArkApp.ArkAppCGIMgr", "parserReply_queryAppInfoByAppNameBatch, 'data' not found");
          return localQueryAppInfoByAppNameBatchResult;
        }
        localQueryAppInfoByAppNameBatchResult.updateInterval = paramString.optInt("updateInterval", 300);
        localQueryAppInfoByAppNameBatchResult.updateInterval = Math.max(60, localQueryAppInfoByAppNameBatchResult.updateInterval);
        paramString = paramString.optJSONArray("apps");
        if (paramString != null) {
          break label633;
        }
        return localQueryAppInfoByAppNameBatchResult;
      }
      catch (JSONException paramString)
      {
        Object localObject1;
        String str1;
        int j;
        Object localObject2;
        ArkAppCGIMgr.QueryAppInfoResult localQueryAppInfoResult;
        String str2;
        String str3;
        Logger.logI("ArkApp.ArkAppCGIMgr", String.format("ArkTemp.parserReply_queryAppInfoByAppNameBatch, exception: %s", new Object[] { paramString.getMessage() }));
      }
      if (i < paramString.length())
      {
        localObject1 = paramString.optJSONObject(i);
        if (localObject1 != null)
        {
          str1 = ((JSONObject)localObject1).optString("app");
          if (TextUtils.isEmpty(str1))
          {
            Logger.logI("ArkApp.ArkAppCGIMgr", "parserReply_queryAppInfoByAppNameBatch, 'app' not found");
          }
          else
          {
            j = ((JSONObject)localObject1).optInt("ret", -1);
            localObject2 = ((JSONObject)localObject1).optString("msg", "");
            if (j != 0)
            {
              localQueryAppInfoResult = new ArkAppCGIMgr.QueryAppInfoResult();
              localQueryAppInfoResult.retCode = j;
              localQueryAppInfoResult.msg = ((String)localObject2);
              localQueryAppInfoResult.info = null;
              localQueryAppInfoByAppNameBatchResult.resultList.put(str1, localQueryAppInfoResult);
            }
            else
            {
              localQueryAppInfoResult = new ArkAppCGIMgr.QueryAppInfoResult();
              localQueryAppInfoResult.retCode = 0;
              localQueryAppInfoResult.msg = ((String)localObject2);
              localQueryAppInfoResult.info = new ArkAppInfo.AppDownloadInfo();
              localQueryAppInfoResult.info.desc = new ArkAppInfo.AppDesc();
              localObject2 = ((JSONObject)localObject1).optJSONObject("config");
              if (localObject2 != null) {
                localQueryAppInfoResult.info.config = ArkAppConfigMgr.convertJsonToConfig((JSONObject)localObject2);
              }
              localQueryAppInfoResult.state = ((JSONObject)localObject1).optInt("state", 0);
              if (localQueryAppInfoResult.state == 0)
              {
                Logger.logI("ArkApp.ArkAppCGIMgr", "ArkTemp.parserReply_queryAppInfoByAppNameBatch, invalid 'state'");
                localQueryAppInfoResult.retCode = -1;
                localQueryAppInfoByAppNameBatchResult.resultList.put(str1, localQueryAppInfoResult);
              }
              else
              {
                if (localQueryAppInfoResult.state == 1)
                {
                  localObject2 = ((JSONObject)localObject1).optString("ver", null);
                  str2 = ((JSONObject)localObject1).optString("url", null);
                  str3 = ((JSONObject)localObject1).optString("sign", null);
                  j = ((JSONObject)localObject1).optInt("updatePeriod", 0);
                  if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)))
                  {
                    localObject1 = Base64.decode(str3, 0);
                    if ((localObject1 != null) && (localObject1.length != 0))
                    {
                      localQueryAppInfoResult.info.downloadUrl = str2;
                      localQueryAppInfoResult.info.sign = ((byte[])localObject1);
                      localQueryAppInfoResult.info.updatePeriodByMinutes = j;
                      localQueryAppInfoResult.info.desc.name = str1;
                      localQueryAppInfoResult.info.desc.version = ((String)localObject2);
                    }
                    else
                    {
                      Logger.logI("ArkApp.ArkAppCGIMgr", String.format("ArkTemp.parserReply_queryAppInfoByAppNameBatch, invalid sign, app=%s", new Object[] { str1 }));
                      continue;
                    }
                  }
                  else
                  {
                    Logger.logI("ArkApp.ArkAppCGIMgr", String.format("ArkTemp.parserReply_queryAppInfoByAppNameBatch, invalid app info, app=%s", new Object[] { str1 }));
                    continue;
                  }
                }
                localQueryAppInfoByAppNameBatchResult.resultList.put(str1, localQueryAppInfoResult);
              }
            }
          }
        }
        i += 1;
      }
      else
      {
        return localQueryAppInfoByAppNameBatchResult;
        label633:
        i = 0;
      }
    }
  }
  
  private void runTask(ArkAppCGIMgr.QueryTask paramQueryTask, ArkAppCGIMgr.ITaskHttpResult arg2)
  {
    paramQueryTask.onParseReply = ???;
    synchronized (this.mTaskList)
    {
      this.mTaskList.add(paramQueryTask);
      ArkDispatchTask.getInstance().postToArkThread(new ArkAppCGIMgr.5(this, paramQueryTask));
      return;
    }
  }
  
  /* Error */
  public static boolean verifyAppPackage(java.io.File paramFile, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aload 6
    //   8: astore 5
    //   10: aload_0
    //   11: invokevirtual 462	java/io/File:exists	()Z
    //   14: ifne +5 -> 19
    //   17: iconst_0
    //   18: ireturn
    //   19: aload 6
    //   21: astore 5
    //   23: new 464	java/io/BufferedInputStream
    //   26: dup
    //   27: new 466	java/io/FileInputStream
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 469	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   35: invokespecial 472	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   38: astore 6
    //   40: aload_0
    //   41: invokevirtual 475	java/io/File:length	()J
    //   44: l2i
    //   45: newarray byte
    //   47: astore_0
    //   48: aload 6
    //   50: aload_0
    //   51: invokevirtual 479	java/io/BufferedInputStream:read	([B)I
    //   54: istore_2
    //   55: aload_0
    //   56: arraylength
    //   57: istore_3
    //   58: iload_2
    //   59: iload_3
    //   60: if_icmpeq +47 -> 107
    //   63: aload 6
    //   65: invokevirtual 482	java/io/BufferedInputStream:close	()V
    //   68: iconst_0
    //   69: ireturn
    //   70: astore_0
    //   71: new 224	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   78: astore_1
    //   79: aload_1
    //   80: ldc_w 484
    //   83: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload_1
    //   88: aload_0
    //   89: invokevirtual 232	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   92: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: ldc 24
    //   98: aload_1
    //   99: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 190	com/tencent/ark/Logger:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: iconst_0
    //   106: ireturn
    //   107: aload_0
    //   108: aload_1
    //   109: invokestatic 276	com/tencent/ark/open/internal/ArkAppCGIMgr:verifyAppPackage	([B[B)Z
    //   112: istore 4
    //   114: aload 6
    //   116: invokevirtual 482	java/io/BufferedInputStream:close	()V
    //   119: iload 4
    //   121: ireturn
    //   122: astore_0
    //   123: new 224	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   130: astore_1
    //   131: aload_1
    //   132: ldc_w 484
    //   135: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload_1
    //   140: aload_0
    //   141: invokevirtual 232	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   144: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: ldc 24
    //   150: aload_1
    //   151: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 190	com/tencent/ark/Logger:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: iload 4
    //   159: ireturn
    //   160: astore_0
    //   161: aload 6
    //   163: astore 5
    //   165: goto +115 -> 280
    //   168: astore_1
    //   169: aload 6
    //   171: astore_0
    //   172: goto +11 -> 183
    //   175: astore_0
    //   176: goto +104 -> 280
    //   179: astore_1
    //   180: aload 7
    //   182: astore_0
    //   183: aload_0
    //   184: astore 5
    //   186: new 224	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   193: astore 6
    //   195: aload_0
    //   196: astore 5
    //   198: aload 6
    //   200: ldc_w 486
    //   203: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload_0
    //   208: astore 5
    //   210: aload 6
    //   212: aload_1
    //   213: invokevirtual 232	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   216: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload_0
    //   221: astore 5
    //   223: ldc 24
    //   225: aload 6
    //   227: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 190	com/tencent/ark/Logger:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   233: aload_0
    //   234: ifnull +44 -> 278
    //   237: aload_0
    //   238: invokevirtual 482	java/io/BufferedInputStream:close	()V
    //   241: iconst_1
    //   242: ireturn
    //   243: astore_0
    //   244: new 224	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   251: astore_1
    //   252: aload_1
    //   253: ldc_w 484
    //   256: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload_1
    //   261: aload_0
    //   262: invokevirtual 232	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   265: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: ldc 24
    //   271: aload_1
    //   272: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokestatic 190	com/tencent/ark/Logger:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   278: iconst_1
    //   279: ireturn
    //   280: aload 5
    //   282: ifnull +50 -> 332
    //   285: aload 5
    //   287: invokevirtual 482	java/io/BufferedInputStream:close	()V
    //   290: goto +42 -> 332
    //   293: astore_1
    //   294: new 224	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   301: astore 5
    //   303: aload 5
    //   305: ldc_w 484
    //   308: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload 5
    //   314: aload_1
    //   315: invokevirtual 232	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   318: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: ldc 24
    //   324: aload 5
    //   326: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: invokestatic 190	com/tencent/ark/Logger:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   332: aload_0
    //   333: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	paramFile	java.io.File
    //   0	334	1	paramArrayOfByte	byte[]
    //   54	7	2	i	int
    //   57	4	3	j	int
    //   112	46	4	bool	boolean
    //   8	317	5	localObject1	Object
    //   4	222	6	localObject2	Object
    //   1	180	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   63	68	70	java/lang/Exception
    //   114	119	122	java/lang/Exception
    //   40	58	160	finally
    //   107	114	160	finally
    //   40	58	168	java/lang/Exception
    //   107	114	168	java/lang/Exception
    //   10	17	175	finally
    //   23	40	175	finally
    //   186	195	175	finally
    //   198	207	175	finally
    //   210	220	175	finally
    //   223	233	175	finally
    //   10	17	179	java/lang/Exception
    //   23	40	179	java/lang/Exception
    //   237	241	243	java/lang/Exception
    //   285	290	293	java/lang/Exception
  }
  
  static boolean verifyAppPackage(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 == null) {
      return false;
    }
    PublicKey localPublicKey = getArkAppPackagePubliceKey();
    if (localPublicKey == null) {
      return true;
    }
    try
    {
      Signature localSignature = Signature.getInstance("SHA1withRSA");
      localSignature.initVerify(localPublicKey);
      localSignature.update(paramArrayOfByte1);
      boolean bool = localSignature.verify(paramArrayOfByte2);
      paramArrayOfByte1 = new StringBuilder();
      paramArrayOfByte1.append("verifyAppPackage, verify result is ");
      paramArrayOfByte1.append(bool);
      Logger.logI("ArkApp.ArkAppCGIMgr", paramArrayOfByte1.toString());
      return bool;
    }
    catch (Exception paramArrayOfByte1)
    {
      paramArrayOfByte2 = new StringBuilder();
      paramArrayOfByte2.append("verifyAppPackage, verify Exception:");
      paramArrayOfByte2.append(paramArrayOfByte1.getMessage());
      Logger.logI("ArkApp.ArkAppCGIMgr", paramArrayOfByte2.toString());
    }
    return true;
  }
  
  public void downloadAppIcon(String paramString, Object paramObject, ArkAppCGIMgr.ArkAppCGICallback paramArkAppCGICallback)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramArkAppCGICallback != null))
    {
      Logger.logI("ArkApp.ArkAppCGIMgr", String.format("ArkSafe.downloadAppIcon:url=%s", new Object[] { paramString }));
      ArkAppCGIMgr.QueryTask localQueryTask = new ArkAppCGIMgr.QueryTask(null);
      localQueryTask.url = paramString;
      localQueryTask.callback.add(paramArkAppCGICallback);
      localQueryTask.userdata.add(paramObject);
      runTask(localQueryTask, new ArkAppCGIMgr.7(this));
    }
  }
  
  public void downloadAppPackage(String paramString, byte[] paramArrayOfByte, Object paramObject, ArkAppCGIMgr.ArkAppCGICallback paramArkAppCGICallback)
  {
    if (mergeRequestByUrl(paramString, paramObject, paramArkAppCGICallback)) {
      return;
    }
    ArkAppCGIMgr.QueryTask_DownloadAppPackage localQueryTask_DownloadAppPackage = new ArkAppCGIMgr.QueryTask_DownloadAppPackage(null);
    localQueryTask_DownloadAppPackage.url = paramString;
    localQueryTask_DownloadAppPackage.appSign = paramArrayOfByte;
    localQueryTask_DownloadAppPackage.userdata.add(paramObject);
    localQueryTask_DownloadAppPackage.callback.add(paramArkAppCGICallback);
    runTask(localQueryTask_DownloadAppPackage, new ArkAppCGIMgr.4(this));
  }
  
  public void queryAppInfoByAppName(ArrayList<ArkAppCGIMgr.AppNameVersion> paramArrayList, ArkAppCGIMgr.ArkAppCGICallback paramArkAppCGICallback)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      paramArrayList = getAppUpdateReqString(paramArrayList);
      if (TextUtils.isEmpty(paramArrayList))
      {
        Logger.logI("ArkApp.ArkAppCGIMgr", "queryAppInfoByAppNameBatch, request string is empty");
        return;
      }
      Logger.logI("ArkApp.ArkAppCGIMgr", String.format("queryAppInfoByAppNameBatch, request, req=%s", new Object[] { paramArrayList }));
      sendQueryAppInfoRequest(paramArrayList, new ArkAppCGIMgr.1(this, paramArkAppCGICallback));
    }
  }
  
  void sendQueryAppInfoRequest(String paramString, ArkAppCGIMgr.IQueryAppInfoRequestCallback paramIQueryAppInfoRequestCallback)
  {
    if (sendQueryAppInfoRequestBySSO(paramString, paramIQueryAppInfoRequestCallback)) {
      return;
    }
    if (sendQueryAppInfoRequestByHTTP(paramString, paramIQueryAppInfoRequestCallback)) {
      return;
    }
    paramIQueryAppInfoRequestCallback.onResult(null);
  }
  
  boolean sendQueryAppInfoRequestByHTTP(String paramString, ArkAppCGIMgr.IQueryAppInfoRequestCallback paramIQueryAppInfoRequestCallback)
  {
    IArkDelegateNet localIArkDelegateNet = ArkDelegateManager.getInstance().getNetDelegate();
    if (localIArkDelegateNet == null) {
      return false;
    }
    localIArkDelegateNet.post("https://cgi.ark.qq.com/proxy/apps", null, paramString.getBytes(StandardCharsets.UTF_8), new ArkAppCGIMgr.3(this, paramIQueryAppInfoRequestCallback));
    return true;
  }
  
  boolean sendQueryAppInfoRequestBySSO(String paramString, ArkAppCGIMgr.IQueryAppInfoRequestCallback paramIQueryAppInfoRequestCallback)
  {
    IArkDelegateSSO localIArkDelegateSSO = ArkDelegateManager.getInstance().getSSODelegate();
    if (localIArkDelegateSSO == null) {
      return false;
    }
    localIArkDelegateSSO.send("ArkAppInfo.QueryAppInfo", paramString, 10000, new ArkAppCGIMgr.2(this, paramIQueryAppInfoRequestCallback));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.internal.ArkAppCGIMgr
 * JD-Core Version:    0.7.0.1
 */