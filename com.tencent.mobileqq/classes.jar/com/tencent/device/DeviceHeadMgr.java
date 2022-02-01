package com.tencent.device;

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
import com.tencent.biz.common.util.Util;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.TlsSniSocketFactory;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime;
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
  private String mStrCachePath;
  private DefaultHttpClient sHttpClient;
  
  public DeviceHeadMgr()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    localStringBuilder.append("/devicehead/");
    this.mStrCachePath = localStringBuilder.toString();
  }
  
  public static String getDeviceHeadUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (paramString.length() < 8)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("00000000");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = paramString;
    }
    Object localObject = ((String)localObject).substring(((String)localObject).length() - 8);
    return String.format("https://i.gtimg.cn/open/device_icon/%s/%s/%s/%s/%s.png", new Object[] { ((String)localObject).substring(0, 2), ((String)localObject).substring(2, 4), ((String)localObject).substring(4, 6), ((String)localObject).substring(6, 8), paramString });
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
    return CommonDataAdapter.a().b().getSharedPreferences("sd_http_lastmodify", 0).getString(paramString, "");
  }
  
  public static String getLogoIconUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (paramString.length() < 8)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("00000000");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = paramString;
    }
    Object localObject = ((String)localObject).substring(((String)localObject).length() - 8);
    return String.format("https://i.gtimg.cn/open/device_icon/%s/%s/%s/%s/%s_mark.png", new Object[] { ((String)localObject).substring(0, 2), ((String)localObject).substring(2, 4), ((String)localObject).substring(4, 6), ((String)localObject).substring(6, 8), paramString });
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
      Util.a(this.mStrCachePath);
      if (SystemUtil.a()) {
        this.mStrCachePath = AppConstants.DEVICE_HEAD_PATH;
      } else {
        this.mStrCachePath = "/data/data/com.tencent.mobileqq/files/head/_dhd/";
      }
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
    catch (Exception localException)
    {
      break label56;
    }
  }
  
  private void saveLastModified(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = CommonDataAdapter.a().b().getSharedPreferences("sd_http_lastmodify", 0).edit();
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
    //   5: ifeq +47 -> 52
    //   8: iload_3
    //   9: invokestatic 237	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   12: invokestatic 239	com/tencent/device/DeviceHeadMgr:getLogoIconUrl	(Ljava/lang/String;)Ljava/lang/String;
    //   15: astore 11
    //   17: new 40	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   24: astore_1
    //   25: aload_1
    //   26: aload_0
    //   27: getfield 64	com/tencent/device/DeviceHeadMgr:mStrCachePath	Ljava/lang/String;
    //   30: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload_1
    //   35: iload_3
    //   36: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_1
    //   41: ldc 244
    //   43: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload_1
    //   48: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore_2
    //   52: invokestatic 250	java/lang/System:currentTimeMillis	()J
    //   55: lstore 7
    //   57: iconst_0
    //   58: istore 5
    //   60: new 49	java/io/File
    //   63: dup
    //   64: aload_2
    //   65: invokespecial 251	java/io/File:<init>	(Ljava/lang/String;)V
    //   68: astore 14
    //   70: aload 14
    //   72: invokevirtual 254	java/io/File:exists	()Z
    //   75: ifeq +6 -> 81
    //   78: iconst_1
    //   79: istore 5
    //   81: aload 14
    //   83: invokevirtual 257	java/io/File:getParentFile	()Ljava/io/File;
    //   86: astore_1
    //   87: aload_1
    //   88: ifnull +15 -> 103
    //   91: aload_1
    //   92: invokevirtual 254	java/io/File:exists	()Z
    //   95: ifne +8 -> 103
    //   98: aload_1
    //   99: invokevirtual 260	java/io/File:mkdirs	()Z
    //   102: pop
    //   103: new 262	org/apache/http/client/methods/HttpGet
    //   106: dup
    //   107: aload 11
    //   109: invokespecial 263	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   112: astore 13
    //   114: iload 5
    //   116: ifeq +25 -> 141
    //   119: aload_0
    //   120: aload 11
    //   122: invokestatic 268	com/tencent/image/Utils:Crc64String	(Ljava/lang/String;)Ljava/lang/String;
    //   125: invokespecial 270	com/tencent/device/DeviceHeadMgr:getLastModified	(Ljava/lang/String;)Ljava/lang/String;
    //   128: astore_1
    //   129: aload 13
    //   131: ldc_w 272
    //   134: aload_1
    //   135: invokevirtual 275	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: goto +6 -> 144
    //   141: ldc 74
    //   143: astore_1
    //   144: invokestatic 280	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +35 -> 182
    //   150: new 40	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   157: astore_2
    //   158: aload_2
    //   159: ldc_w 282
    //   162: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload_2
    //   167: aload_1
    //   168: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: ldc 14
    //   174: iconst_2
    //   175: aload_2
    //   176: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 286	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: aload_0
    //   183: getfield 191	com/tencent/device/DeviceHeadMgr:sHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   186: aload 13
    //   188: invokevirtual 290	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   191: astore 15
    //   193: aload 15
    //   195: invokeinterface 296 1 0
    //   200: invokeinterface 301 1 0
    //   205: istore 6
    //   207: invokestatic 280	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   210: ifeq +36 -> 246
    //   213: new 40	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   220: astore_1
    //   221: aload_1
    //   222: ldc_w 303
    //   225: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload_1
    //   230: iload 6
    //   232: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: ldc 14
    //   238: iconst_2
    //   239: aload_1
    //   240: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 286	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   246: aload 15
    //   248: invokeinterface 307 1 0
    //   253: astore 16
    //   255: iload 6
    //   257: sipush 200
    //   260: if_icmpne +326 -> 586
    //   263: iload 5
    //   265: ifeq +9 -> 274
    //   268: aload 14
    //   270: invokevirtual 310	java/io/File:delete	()Z
    //   273: pop
    //   274: aconst_null
    //   275: astore 12
    //   277: aconst_null
    //   278: astore_1
    //   279: new 312	java/io/BufferedOutputStream
    //   282: dup
    //   283: new 314	java/io/FileOutputStream
    //   286: dup
    //   287: aload 14
    //   289: invokespecial 317	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   292: invokespecial 320	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   295: astore_2
    //   296: aload 16
    //   298: aload_2
    //   299: invokeinterface 325 2 0
    //   304: aload_2
    //   305: invokevirtual 330	java/io/OutputStream:flush	()V
    //   308: aload 14
    //   310: invokevirtual 332	java/io/File:length	()J
    //   313: lstore 9
    //   315: aload 15
    //   317: ldc_w 334
    //   320: invokeinterface 337 2 0
    //   325: ifeq +29 -> 354
    //   328: aload 15
    //   330: ldc_w 334
    //   333: invokeinterface 341 2 0
    //   338: invokeinterface 346 1 0
    //   343: astore_1
    //   344: aload_0
    //   345: aload 11
    //   347: invokestatic 268	com/tencent/image/Utils:Crc64String	(Ljava/lang/String;)Ljava/lang/String;
    //   350: aload_1
    //   351: invokespecial 348	com/tencent/device/DeviceHeadMgr:saveLastModified	(Ljava/lang/String;Ljava/lang/String;)V
    //   354: invokestatic 280	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   357: ifeq +70 -> 427
    //   360: new 40	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   367: astore_1
    //   368: aload_1
    //   369: ldc_w 350
    //   372: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload_1
    //   377: invokestatic 250	java/lang/System:currentTimeMillis	()J
    //   380: lload 7
    //   382: lsub
    //   383: invokevirtual 353	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   386: pop
    //   387: aload_1
    //   388: ldc_w 355
    //   391: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: pop
    //   395: aload_1
    //   396: lload 9
    //   398: invokevirtual 353	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload_1
    //   403: ldc_w 357
    //   406: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: aload_1
    //   411: aload 11
    //   413: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: ldc 14
    //   419: iconst_2
    //   420: aload_1
    //   421: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   424: invokestatic 360	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   427: iload 4
    //   429: ifeq +34 -> 463
    //   432: aload_0
    //   433: getfield 217	com/tencent/device/DeviceHeadMgr:mDeviceOriginalHeadMap	Ljava/util/HashMap;
    //   436: astore_1
    //   437: aload_1
    //   438: monitorenter
    //   439: aload_0
    //   440: getfield 217	com/tencent/device/DeviceHeadMgr:mDeviceOriginalHeadMap	Ljava/util/HashMap;
    //   443: iload_3
    //   444: invokestatic 365	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   447: invokevirtual 369	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   450: pop
    //   451: aload_1
    //   452: monitorexit
    //   453: goto +58 -> 511
    //   456: astore 11
    //   458: aload_1
    //   459: monitorexit
    //   460: aload 11
    //   462: athrow
    //   463: aload_0
    //   464: getfield 210	com/tencent/device/DeviceHeadMgr:mDeviceHeadMap	Ljava/util/HashMap;
    //   467: astore_1
    //   468: aload_1
    //   469: monitorenter
    //   470: aload_0
    //   471: getfield 210	com/tencent/device/DeviceHeadMgr:mDeviceHeadMap	Ljava/util/HashMap;
    //   474: iload_3
    //   475: invokestatic 365	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   478: invokevirtual 369	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   481: pop
    //   482: aload_1
    //   483: monitorexit
    //   484: new 371	android/content/Intent
    //   487: dup
    //   488: ldc_w 373
    //   491: invokespecial 374	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   494: astore_1
    //   495: aload_1
    //   496: ldc_w 376
    //   499: iload_3
    //   500: invokevirtual 380	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   503: pop
    //   504: invokestatic 386	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   507: aload_1
    //   508: invokevirtual 390	com/tencent/common/app/BaseApplicationImpl:sendBroadcast	(Landroid/content/Intent;)V
    //   511: aload_2
    //   512: invokevirtual 393	java/io/OutputStream:close	()V
    //   515: goto +71 -> 586
    //   518: astore 11
    //   520: aload_1
    //   521: monitorexit
    //   522: aload 11
    //   524: athrow
    //   525: astore_1
    //   526: goto +41 -> 567
    //   529: astore 11
    //   531: goto +18 -> 549
    //   534: astore 11
    //   536: aload_1
    //   537: astore_2
    //   538: aload 11
    //   540: astore_1
    //   541: goto +26 -> 567
    //   544: astore 11
    //   546: aload 12
    //   548: astore_2
    //   549: aload_2
    //   550: astore_1
    //   551: aload 11
    //   553: invokevirtual 396	java/lang/Exception:printStackTrace	()V
    //   556: aload_2
    //   557: ifnull +29 -> 586
    //   560: aload_2
    //   561: invokevirtual 393	java/io/OutputStream:close	()V
    //   564: goto +22 -> 586
    //   567: aload_2
    //   568: ifnull +7 -> 575
    //   571: aload_2
    //   572: invokevirtual 393	java/io/OutputStream:close	()V
    //   575: aload_1
    //   576: athrow
    //   577: astore_1
    //   578: goto +14 -> 592
    //   581: astore_1
    //   582: aload_1
    //   583: invokevirtual 396	java/lang/Exception:printStackTrace	()V
    //   586: aload 13
    //   588: invokevirtual 399	org/apache/http/client/methods/HttpGet:abort	()V
    //   591: return
    //   592: aload 13
    //   594: invokevirtual 399	org/apache/http/client/methods/HttpGet:abort	()V
    //   597: aload_1
    //   598: athrow
    //   599: astore_1
    //   600: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	601	0	this	DeviceHeadMgr
    //   0	601	1	paramString1	String
    //   0	601	2	paramString2	String
    //   0	601	3	paramInt	int
    //   0	601	4	paramBoolean	boolean
    //   58	206	5	i	int
    //   205	56	6	j	int
    //   55	326	7	l1	long
    //   313	84	9	l2	long
    //   1	411	11	str	String
    //   456	5	11	localObject1	Object
    //   518	5	11	localObject2	Object
    //   529	1	11	localException1	Exception
    //   534	5	11	localObject3	Object
    //   544	8	11	localException2	Exception
    //   275	272	12	localObject4	Object
    //   112	481	13	localHttpGet	org.apache.http.client.methods.HttpGet
    //   68	241	14	localFile	File
    //   191	138	15	localHttpResponse	org.apache.http.HttpResponse
    //   253	44	16	localHttpEntity	org.apache.http.HttpEntity
    // Exception table:
    //   from	to	target	type
    //   439	453	456	finally
    //   458	460	456	finally
    //   470	484	518	finally
    //   520	522	518	finally
    //   296	354	525	finally
    //   354	427	525	finally
    //   432	439	525	finally
    //   460	463	525	finally
    //   463	470	525	finally
    //   484	511	525	finally
    //   522	525	525	finally
    //   296	354	529	java/lang/Exception
    //   354	427	529	java/lang/Exception
    //   432	439	529	java/lang/Exception
    //   460	463	529	java/lang/Exception
    //   463	470	529	java/lang/Exception
    //   484	511	529	java/lang/Exception
    //   522	525	529	java/lang/Exception
    //   279	296	534	finally
    //   551	556	534	finally
    //   279	296	544	java/lang/Exception
    //   182	246	577	finally
    //   246	255	577	finally
    //   268	274	577	finally
    //   511	515	577	finally
    //   560	564	577	finally
    //   571	575	577	finally
    //   575	577	577	finally
    //   582	586	577	finally
    //   182	246	581	java/lang/Exception
    //   246	255	581	java/lang/Exception
    //   268	274	581	java/lang/Exception
    //   511	515	581	java/lang/Exception
    //   560	564	581	java/lang/Exception
    //   571	575	581	java/lang/Exception
    //   575	577	581	java/lang/Exception
    //   81	87	599	java/lang/Exception
    //   91	103	599	java/lang/Exception
  }
  
  public Bitmap getDeviceHeadByDin(String paramString)
  {
    paramString = ((SmartDeviceProxyMgr)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).g(Long.parseLong(paramString));
    if (paramString == null) {
      return getDeviceHeadByPID(0);
    }
    return getDeviceHeadByPID(paramString.productId);
  }
  
  public Bitmap getDeviceHeadByPID(int paramInt)
  {
    synchronized (this.mDeviceHeadMap)
    {
      ??? = (Bitmap)this.mDeviceHeadMap.get(Integer.valueOf(paramInt));
      if (??? != null) {
        return ???;
      }
      ??? = String.valueOf(paramInt);
      ??? = new StringBuilder();
      ((StringBuilder)???).append(this.mStrCachePath);
      ((StringBuilder)???).append((String)???);
      String str = ((StringBuilder)???).toString();
      if (TextUtils.isEmpty((CharSequence)???))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SDHeadImage", 2, "productid is not valid");
        }
        try
        {
          ??? = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), 2130839777);
          return ???;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SDHeadImage", 2, "getDeviceHeadByPID BitmapFactory.decodeResource", localOutOfMemoryError);
          }
          return null;
        }
      }
      ??? = BitmapManager.a(str);
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if (!this.mDownedDevicePid.containsKey(Integer.valueOf(paramInt)))
      {
        if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
          ((QQAppInterface)localAppRuntime).execute(new DeviceHeadMgr.1(this, localOutOfMemoryError, str, paramInt));
        } else {
          new Thread(new DeviceHeadMgr.2(this, localOutOfMemoryError, str, paramInt)).start();
        }
        this.mDownedDevicePid.put(Integer.valueOf(paramInt), Integer.valueOf(0));
      }
      Object localObject2 = ???;
      if (??? != null)
      {
        if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)))
        {
          localObject2 = (QQAppInterface)localAppRuntime;
          localObject2 = QQAppInterface.getCircleFaceBitmap((Bitmap)???, 50, 50);
        }
        else
        {
          localObject2 = ImageUtil.c((Bitmap)???, 50, 50);
        }
        synchronized (this.mDeviceHeadMap)
        {
          this.mDeviceHeadMap.put(Integer.valueOf(paramInt), localObject2);
        }
      }
      ??? = localObject3;
      if (localObject3 == null) {
        ??? = BitmapManager.a(BaseApplication.getContext().getResources(), 2130839777);
      }
      return ???;
    }
  }
  
  public Drawable getDeviceHeadDrawableByDin(String paramString)
  {
    if (AppConstants.SMARTDEVICE_SEARCH_UIN.equals(paramString))
    {
      paramString = BitmapManager.a(BaseApplication.getContext().getResources(), 2130839779);
      return new BitmapDrawable(BaseApplication.getContext().getResources(), paramString);
    }
    long l = Long.parseLong(paramString);
    Object localObject2 = ((SmartDeviceProxyMgr)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).g(Long.valueOf(l).longValue());
    Object localObject1 = null;
    if (localObject2 != null)
    {
      localObject2 = getDeviceHeadByPID(((DeviceInfo)localObject2).productId);
      localObject1 = localObject2;
      if (isLostQfindDevice(paramString))
      {
        paramString = BaseApplication.getContext().getResources().getDrawable(2130839776);
        if ((paramString instanceof SkinnableBitmapDrawable)) {
          ((SkinnableBitmapDrawable)paramString).setGravity(119);
        }
        if ((paramString instanceof BitmapDrawable)) {
          ((BitmapDrawable)paramString).setGravity(119);
        }
        return new LayerDrawable(new Drawable[] { new BitmapDrawable(BaseApplication.getContext().getResources(), (Bitmap)localObject2), paramString });
      }
    }
    paramString = localObject1;
    if (localObject1 == null) {
      paramString = getDeviceHeadByPID(0);
    }
    return new BitmapDrawable(BaseApplication.getContext().getResources(), paramString);
  }
  
  public Bitmap getDeviceHeadSD(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mStrCachePath);
    localStringBuilder.append(paramInt);
    return BitmapManager.a(localStringBuilder.toString());
  }
  
  public Bitmap getDeviceWithLogoByPid(int paramInt)
  {
    if (paramInt == 9971) {
      return BitmapManager.a(BaseApplication.getContext().getResources(), 2130839780);
    }
    synchronized (this.mDeviceOriginalHeadMap)
    {
      Bitmap localBitmap = (Bitmap)this.mDeviceOriginalHeadMap.get(Integer.valueOf(paramInt));
      if (localBitmap != null) {
        return localBitmap;
      }
      ??? = new StringBuilder();
      ((StringBuilder)???).append(this.mStrCachePath);
      ((StringBuilder)???).append(String.valueOf(paramInt));
      ((StringBuilder)???).append("_mark");
      localBitmap = BitmapManager.a(((StringBuilder)???).toString());
      ??? = localBitmap;
      if (localBitmap == null)
      {
        ??? = getDeviceHeadByPID(paramInt);
        if (??? != null) {
          return ???;
        }
        ??? = BitmapManager.a(BaseApplication.getContext().getResources(), 2130839777);
      }
      return ???;
    }
  }
  
  public boolean isLostQfindDevice(String paramString)
  {
    return ((SmartDeviceProxyMgr)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.DeviceHeadMgr
 * JD-Core Version:    0.7.0.1
 */