package com.tencent.device;

import abgm;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Environment;
import android.text.TextUtils;
import bgyo;
import bheg;
import bizw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.TlsSniSocketFactory;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime;
import nwo;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

@SuppressLint({"UseSparseArrays"})
public class DeviceHeadMgr
{
  private static final String PREF_NAME = "sd_http_lastmodify";
  private static final String TAG = "SDHeadImage";
  protected static final String URI_DEVICE_ICON_FORMAT = "https://i.gtimg.cn/open/device_icon/%s/%s/%s/%s/%s.png";
  protected static final String URI_DEVICE_ICON_FORMAT_SHORTCUT = "https://i.gtimg.cn/open/device_icon/%s/%s/%s/%s/%s_mark.png";
  private static DeviceHeadMgr instance;
  private HashMap<Integer, Object> mDeviceHeadMap;
  private HashMap<Integer, Bitmap> mDeviceOriginalHeadMap;
  private HashMap<Integer, Integer> mDownedDevicePid;
  private String mStrCachePath = Environment.getExternalStorageDirectory().getPath() + "/devicehead/";
  private DefaultHttpClient sHttpClient;
  
  public static String getDeviceHeadUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (paramString.length() < 8) {}
    for (String str = "00000000" + paramString;; str = paramString)
    {
      str = str.substring(str.length() - 8);
      return String.format("https://i.gtimg.cn/open/device_icon/%s/%s/%s/%s/%s.png", new Object[] { str.substring(0, 2), str.substring(2, 4), str.substring(4, 6), str.substring(6, 8), paramString });
    }
  }
  
  public static DeviceHeadMgr getInstance()
  {
    if (instance == null)
    {
      instance = new DeviceHeadMgr();
      instance.init();
    }
    return instance;
  }
  
  private String getLastModified(String paramString)
  {
    return bizw.a().a().getSharedPreferences("sd_http_lastmodify", 0).getString(paramString, "");
  }
  
  public static String getLogoIconUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (paramString.length() < 8) {}
    for (String str = "00000000" + paramString;; str = paramString)
    {
      str = str.substring(str.length() - 8);
      return String.format("https://i.gtimg.cn/open/device_icon/%s/%s/%s/%s/%s_mark.png", new Object[] { str.substring(0, 2), str.substring(2, 4), str.substring(4, 6), str.substring(6, 8), paramString });
    }
  }
  
  private void init()
  {
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    try
    {
      localSchemeRegistry.register(new Scheme("https", new TlsSniSocketFactory(DeviceHeadMgr.class.getSimpleName()), 443));
      label56:
      BasicHttpParams localBasicHttpParams = new BasicHttpParams();
      ConnManagerParams.setTimeout(localBasicHttpParams, 3000L);
      HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 30000);
      HttpConnectionParams.setSoTimeout(localBasicHttpParams, 30000);
      this.sHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(new BasicHttpParams(), localSchemeRegistry), null);
      nwo.a(this.mStrCachePath);
      if (SystemUtil.isExistSDCard()) {}
      for (this.mStrCachePath = AppConstants.DEVICE_HEAD_PATH;; this.mStrCachePath = "/data/data/com.tencent.mobileqq/files/head/_dhd/")
      {
        if (this.mDeviceHeadMap == null) {
          this.mDeviceHeadMap = new HashMap();
        }
        if (this.mDownedDevicePid == null) {
          this.mDownedDevicePid = new HashMap();
        }
        if (this.mDeviceOriginalHeadMap == null) {
          this.mDeviceOriginalHeadMap = new HashMap();
        }
        return;
      }
    }
    catch (Exception localException)
    {
      break label56;
    }
  }
  
  private void saveLastModified(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = bizw.a().a().getSharedPreferences("sd_http_lastmodify", 0).edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }
  
  /* Error */
  public void downloadImage(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore 11
    //   3: iload 4
    //   5: ifeq +39 -> 44
    //   8: iload_3
    //   9: invokestatic 236	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   12: invokestatic 238	com/tencent/device/DeviceHeadMgr:getLogoIconUrl	(Ljava/lang/String;)Ljava/lang/String;
    //   15: astore 11
    //   17: new 38	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   24: aload_0
    //   25: getfield 62	com/tencent/device/DeviceHeadMgr:mStrCachePath	Ljava/lang/String;
    //   28: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: iload_3
    //   32: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: ldc 243
    //   37: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: astore_2
    //   44: invokestatic 249	java/lang/System:currentTimeMillis	()J
    //   47: lstore 7
    //   49: new 47	java/io/File
    //   52: dup
    //   53: aload_2
    //   54: invokespecial 250	java/io/File:<init>	(Ljava/lang/String;)V
    //   57: astore 13
    //   59: aload 13
    //   61: ifnull +549 -> 610
    //   64: aload 13
    //   66: invokevirtual 253	java/io/File:exists	()Z
    //   69: ifeq +541 -> 610
    //   72: iconst_1
    //   73: istore 5
    //   75: aload 13
    //   77: invokevirtual 256	java/io/File:getParentFile	()Ljava/io/File;
    //   80: astore_1
    //   81: aload_1
    //   82: ifnull +15 -> 97
    //   85: aload_1
    //   86: invokevirtual 253	java/io/File:exists	()Z
    //   89: ifne +8 -> 97
    //   92: aload_1
    //   93: invokevirtual 259	java/io/File:mkdirs	()Z
    //   96: pop
    //   97: ldc 73
    //   99: astore_1
    //   100: new 261	org/apache/http/client/methods/HttpGet
    //   103: dup
    //   104: aload 11
    //   106: invokespecial 262	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   109: astore 12
    //   111: iload 5
    //   113: ifeq +22 -> 135
    //   116: aload_0
    //   117: aload 11
    //   119: invokestatic 267	com/tencent/image/Utils:Crc64String	(Ljava/lang/String;)Ljava/lang/String;
    //   122: invokespecial 269	com/tencent/device/DeviceHeadMgr:getLastModified	(Ljava/lang/String;)Ljava/lang/String;
    //   125: astore_1
    //   126: aload 12
    //   128: ldc_w 271
    //   131: aload_1
    //   132: invokevirtual 274	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: invokestatic 279	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   138: ifeq +29 -> 167
    //   141: ldc 14
    //   143: iconst_2
    //   144: new 38	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   151: ldc_w 281
    //   154: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_1
    //   158: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 285	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   167: aload_0
    //   168: getfield 189	com/tencent/device/DeviceHeadMgr:sHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   171: aload 12
    //   173: invokevirtual 289	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   176: astore 14
    //   178: aload 14
    //   180: invokeinterface 295 1 0
    //   185: invokeinterface 300 1 0
    //   190: istore 6
    //   192: invokestatic 279	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq +30 -> 225
    //   198: ldc 14
    //   200: iconst_2
    //   201: new 38	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   208: ldc_w 302
    //   211: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: iload 6
    //   216: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   219: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 285	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: aload 14
    //   227: invokeinterface 306 1 0
    //   232: astore 15
    //   234: iload 6
    //   236: sipush 200
    //   239: if_icmpne +207 -> 446
    //   242: iload 5
    //   244: ifeq +9 -> 253
    //   247: aload 13
    //   249: invokevirtual 309	java/io/File:delete	()Z
    //   252: pop
    //   253: new 311	java/io/BufferedOutputStream
    //   256: dup
    //   257: new 313	java/io/FileOutputStream
    //   260: dup
    //   261: aload 13
    //   263: invokespecial 316	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   266: invokespecial 319	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   269: astore_2
    //   270: aload_2
    //   271: astore_1
    //   272: aload 15
    //   274: aload_2
    //   275: invokeinterface 324 2 0
    //   280: aload_2
    //   281: astore_1
    //   282: aload_2
    //   283: invokevirtual 329	java/io/OutputStream:flush	()V
    //   286: aload_2
    //   287: astore_1
    //   288: aload 13
    //   290: invokevirtual 331	java/io/File:length	()J
    //   293: lstore 9
    //   295: aload_2
    //   296: astore_1
    //   297: aload 14
    //   299: ldc_w 333
    //   302: invokeinterface 336 2 0
    //   307: ifeq +35 -> 342
    //   310: aload_2
    //   311: astore_1
    //   312: aload 14
    //   314: ldc_w 333
    //   317: invokeinterface 340 2 0
    //   322: invokeinterface 345 1 0
    //   327: astore 13
    //   329: aload_2
    //   330: astore_1
    //   331: aload_0
    //   332: aload 11
    //   334: invokestatic 267	com/tencent/image/Utils:Crc64String	(Ljava/lang/String;)Ljava/lang/String;
    //   337: aload 13
    //   339: invokespecial 347	com/tencent/device/DeviceHeadMgr:saveLastModified	(Ljava/lang/String;Ljava/lang/String;)V
    //   342: aload_2
    //   343: astore_1
    //   344: invokestatic 279	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq +58 -> 405
    //   350: aload_2
    //   351: astore_1
    //   352: ldc 14
    //   354: iconst_2
    //   355: new 38	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   362: ldc_w 349
    //   365: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: invokestatic 249	java/lang/System:currentTimeMillis	()J
    //   371: lload 7
    //   373: lsub
    //   374: invokevirtual 352	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   377: ldc_w 354
    //   380: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: lload 9
    //   385: invokevirtual 352	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   388: ldc_w 356
    //   391: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: aload 11
    //   396: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: invokestatic 359	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   405: iload 4
    //   407: ifeq +86 -> 493
    //   410: aload_2
    //   411: astore_1
    //   412: aload_0
    //   413: getfield 214	com/tencent/device/DeviceHeadMgr:mDeviceOriginalHeadMap	Ljava/util/HashMap;
    //   416: astore 11
    //   418: aload_2
    //   419: astore_1
    //   420: aload 11
    //   422: monitorenter
    //   423: aload_0
    //   424: getfield 214	com/tencent/device/DeviceHeadMgr:mDeviceOriginalHeadMap	Ljava/util/HashMap;
    //   427: iload_3
    //   428: invokestatic 364	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   431: invokevirtual 368	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   434: pop
    //   435: aload 11
    //   437: monitorexit
    //   438: aload_2
    //   439: ifnull +7 -> 446
    //   442: aload_2
    //   443: invokevirtual 371	java/io/OutputStream:close	()V
    //   446: aload 12
    //   448: invokevirtual 374	org/apache/http/client/methods/HttpGet:abort	()V
    //   451: return
    //   452: astore 13
    //   454: aload 11
    //   456: monitorexit
    //   457: aload_2
    //   458: astore_1
    //   459: aload 13
    //   461: athrow
    //   462: astore 11
    //   464: aload_2
    //   465: astore_1
    //   466: aload 11
    //   468: invokevirtual 377	java/lang/Exception:printStackTrace	()V
    //   471: aload_2
    //   472: ifnull -26 -> 446
    //   475: aload_2
    //   476: invokevirtual 371	java/io/OutputStream:close	()V
    //   479: goto -33 -> 446
    //   482: astore_1
    //   483: aload_1
    //   484: invokevirtual 377	java/lang/Exception:printStackTrace	()V
    //   487: aload 12
    //   489: invokevirtual 374	org/apache/http/client/methods/HttpGet:abort	()V
    //   492: return
    //   493: aload_2
    //   494: astore_1
    //   495: aload_0
    //   496: getfield 207	com/tencent/device/DeviceHeadMgr:mDeviceHeadMap	Ljava/util/HashMap;
    //   499: astore 11
    //   501: aload_2
    //   502: astore_1
    //   503: aload 11
    //   505: monitorenter
    //   506: aload_0
    //   507: getfield 207	com/tencent/device/DeviceHeadMgr:mDeviceHeadMap	Ljava/util/HashMap;
    //   510: iload_3
    //   511: invokestatic 364	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   514: invokevirtual 368	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   517: pop
    //   518: aload 11
    //   520: monitorexit
    //   521: aload_2
    //   522: astore_1
    //   523: new 379	android/content/Intent
    //   526: dup
    //   527: ldc_w 381
    //   530: invokespecial 382	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   533: astore 11
    //   535: aload_2
    //   536: astore_1
    //   537: aload 11
    //   539: ldc_w 384
    //   542: iload_3
    //   543: invokevirtual 388	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   546: pop
    //   547: aload_2
    //   548: astore_1
    //   549: invokestatic 394	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   552: aload 11
    //   554: invokevirtual 398	com/tencent/common/app/BaseApplicationImpl:sendBroadcast	(Landroid/content/Intent;)V
    //   557: goto -119 -> 438
    //   560: astore 11
    //   562: aload_1
    //   563: astore_2
    //   564: aload 11
    //   566: astore_1
    //   567: aload_2
    //   568: ifnull +7 -> 575
    //   571: aload_2
    //   572: invokevirtual 371	java/io/OutputStream:close	()V
    //   575: aload_1
    //   576: athrow
    //   577: astore_1
    //   578: aload 12
    //   580: invokevirtual 374	org/apache/http/client/methods/HttpGet:abort	()V
    //   583: aload_1
    //   584: athrow
    //   585: astore 13
    //   587: aload 11
    //   589: monitorexit
    //   590: aload_2
    //   591: astore_1
    //   592: aload 13
    //   594: athrow
    //   595: astore_1
    //   596: aconst_null
    //   597: astore_2
    //   598: goto -31 -> 567
    //   601: astore 11
    //   603: aconst_null
    //   604: astore_2
    //   605: goto -141 -> 464
    //   608: astore_1
    //   609: return
    //   610: iconst_0
    //   611: istore 5
    //   613: goto -538 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	616	0	this	DeviceHeadMgr
    //   0	616	1	paramString1	String
    //   0	616	2	paramString2	String
    //   0	616	3	paramInt	int
    //   0	616	4	paramBoolean	boolean
    //   73	539	5	i	int
    //   190	50	6	j	int
    //   47	325	7	l1	long
    //   293	91	9	l2	long
    //   1	454	11	localObject1	Object
    //   462	5	11	localException1	Exception
    //   499	54	11	localObject2	Object
    //   560	28	11	localObject3	Object
    //   601	1	11	localException2	Exception
    //   109	470	12	localHttpGet	org.apache.http.client.methods.HttpGet
    //   57	281	13	localObject4	Object
    //   452	8	13	localObject5	Object
    //   585	8	13	localObject6	Object
    //   176	137	14	localHttpResponse	org.apache.http.HttpResponse
    //   232	41	15	localHttpEntity	org.apache.http.HttpEntity
    // Exception table:
    //   from	to	target	type
    //   423	438	452	finally
    //   454	457	452	finally
    //   272	280	462	java/lang/Exception
    //   282	286	462	java/lang/Exception
    //   288	295	462	java/lang/Exception
    //   297	310	462	java/lang/Exception
    //   312	329	462	java/lang/Exception
    //   331	342	462	java/lang/Exception
    //   344	350	462	java/lang/Exception
    //   352	405	462	java/lang/Exception
    //   412	418	462	java/lang/Exception
    //   420	423	462	java/lang/Exception
    //   459	462	462	java/lang/Exception
    //   495	501	462	java/lang/Exception
    //   503	506	462	java/lang/Exception
    //   523	535	462	java/lang/Exception
    //   537	547	462	java/lang/Exception
    //   549	557	462	java/lang/Exception
    //   592	595	462	java/lang/Exception
    //   167	225	482	java/lang/Exception
    //   225	234	482	java/lang/Exception
    //   247	253	482	java/lang/Exception
    //   442	446	482	java/lang/Exception
    //   475	479	482	java/lang/Exception
    //   571	575	482	java/lang/Exception
    //   575	577	482	java/lang/Exception
    //   272	280	560	finally
    //   282	286	560	finally
    //   288	295	560	finally
    //   297	310	560	finally
    //   312	329	560	finally
    //   331	342	560	finally
    //   344	350	560	finally
    //   352	405	560	finally
    //   412	418	560	finally
    //   420	423	560	finally
    //   459	462	560	finally
    //   466	471	560	finally
    //   495	501	560	finally
    //   503	506	560	finally
    //   523	535	560	finally
    //   537	547	560	finally
    //   549	557	560	finally
    //   592	595	560	finally
    //   167	225	577	finally
    //   225	234	577	finally
    //   247	253	577	finally
    //   442	446	577	finally
    //   475	479	577	finally
    //   483	487	577	finally
    //   571	575	577	finally
    //   575	577	577	finally
    //   506	521	585	finally
    //   587	590	585	finally
    //   253	270	595	finally
    //   253	270	601	java/lang/Exception
    //   75	81	608	java/lang/Exception
    //   85	97	608	java/lang/Exception
  }
  
  public Bitmap getDeviceHeadByDin(String paramString)
  {
    paramString = ((abgm)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(paramString));
    if (paramString == null) {
      return getDeviceHeadByPID(0);
    }
    return getDeviceHeadByPID(paramString.productId);
  }
  
  public Bitmap getDeviceHeadByPID(int paramInt)
  {
    synchronized (this.mDeviceHeadMap)
    {
      Bitmap localBitmap2 = (Bitmap)this.mDeviceHeadMap.get(Integer.valueOf(paramInt));
      if (localBitmap2 != null) {
        return localBitmap2;
      }
    }
    ??? = String.valueOf(paramInt);
    String str = this.mStrCachePath + (String)???;
    if (TextUtils.isEmpty((CharSequence)???))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SDHeadImage", 2, "productid is not valid");
      }
      try
      {
        ??? = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), 2130839627);
        return ???;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        ??? = null;
        if (!QLog.isColorLevel()) {
          return ???;
        }
      }
      QLog.d("SDHeadImage", 2, "getDeviceHeadByPID BitmapFactory.decodeResource", localOutOfMemoryError);
      return null;
    }
    else
    {
      Bitmap localBitmap1 = bgyo.a(str);
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if (!this.mDownedDevicePid.containsKey(Integer.valueOf(paramInt)))
      {
        if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)))
        {
          ((QQAppInterface)localAppRuntime).execute(new DeviceHeadMgr.1(this, (String)???, str, paramInt));
          this.mDownedDevicePid.put(Integer.valueOf(paramInt), Integer.valueOf(0));
        }
      }
      else
      {
        if (localBitmap1 == null) {
          break label313;
        }
        if ((localAppRuntime == null) || (!(localAppRuntime instanceof QQAppInterface))) {
          break label296;
        }
        ??? = (QQAppInterface)localAppRuntime;
        localBitmap1 = QQAppInterface.getCircleFaceBitmap(localBitmap1, 50, 50);
      }
      label296:
      label313:
      for (;;)
      {
        synchronized (this.mDeviceHeadMap)
        {
          this.mDeviceHeadMap.put(Integer.valueOf(paramInt), localBitmap1);
          ??? = localBitmap1;
          if (localBitmap1 != null) {
            return ???;
          }
          return bgyo.a(BaseApplication.getContext().getResources(), 2130839627);
          new Thread(new DeviceHeadMgr.2(this, (String)???, str, paramInt)).start();
          break;
          localBitmap1 = bheg.c(localBitmap1, 50, 50);
        }
      }
    }
    return ???;
  }
  
  public Drawable getDeviceHeadDrawableByDin(String paramString)
  {
    if (AppConstants.SMARTDEVICE_SEARCH_UIN.equals(paramString))
    {
      paramString = bgyo.a(BaseApplication.getContext().getResources(), 2130839629);
      return new BitmapDrawable(BaseApplication.getContext().getResources(), paramString);
    }
    long l = Long.parseLong(paramString);
    DeviceInfo localDeviceInfo = ((abgm)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.valueOf(l).longValue());
    Bitmap localBitmap = null;
    if (localDeviceInfo != null)
    {
      localBitmap = getDeviceHeadByPID(localDeviceInfo.productId);
      if (isLostQfindDevice(paramString))
      {
        paramString = BaseApplication.getContext().getResources().getDrawable(2130839626);
        if ((paramString instanceof SkinnableBitmapDrawable)) {
          ((SkinnableBitmapDrawable)paramString).setGravity(119);
        }
        if ((paramString instanceof BitmapDrawable)) {
          ((BitmapDrawable)paramString).setGravity(119);
        }
        return new LayerDrawable(new Drawable[] { new BitmapDrawable(BaseApplication.getContext().getResources(), localBitmap), paramString });
      }
    }
    paramString = localBitmap;
    if (localBitmap == null) {
      paramString = getDeviceHeadByPID(0);
    }
    return new BitmapDrawable(BaseApplication.getContext().getResources(), paramString);
  }
  
  public Bitmap getDeviceHeadSD(int paramInt)
  {
    return bgyo.a(this.mStrCachePath + paramInt);
  }
  
  public Bitmap getDeviceWithLogoByPid(int paramInt)
  {
    if (paramInt == 9971) {
      ??? = bgyo.a(BaseApplication.getContext().getResources(), 2130839630);
    }
    for (;;)
    {
      return ???;
      synchronized (this.mDeviceOriginalHeadMap)
      {
        Bitmap localBitmap = (Bitmap)this.mDeviceOriginalHeadMap.get(Integer.valueOf(paramInt));
        ??? = localBitmap;
        if (localBitmap != null) {
          continue;
        }
        localBitmap = bgyo.a(this.mStrCachePath + String.valueOf(paramInt) + "_mark");
        ??? = localBitmap;
        if (localBitmap != null) {
          continue;
        }
        localBitmap = getDeviceHeadByPID(paramInt);
        ??? = localBitmap;
        if (localBitmap != null) {
          continue;
        }
        return bgyo.a(BaseApplication.getContext().getResources(), 2130839627);
      }
    }
  }
  
  public boolean isLostQfindDevice(String paramString)
  {
    return ((abgm)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.device.DeviceHeadMgr
 * JD-Core Version:    0.7.0.1
 */