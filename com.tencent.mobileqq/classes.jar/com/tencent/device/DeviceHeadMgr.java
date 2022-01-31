package com.tencent.device;

import ajed;
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
import axvl;
import azvq;
import azzu;
import bacm;
import bbtm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.File;
import java.util.HashMap;
import mpw;
import mqq.app.AppRuntime;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import xrh;

@SuppressLint({"UseSparseArrays"})
public class DeviceHeadMgr
{
  private static final String PREF_NAME = "sd_http_lastmodify";
  private static final String TAG = "SDHeadImage";
  protected static final String URI_DEVICE_ICON_FORMAT = "http://i.gtimg.cn/open/device_icon/%s/%s/%s/%s/%s.png";
  protected static final String URI_DEVICE_ICON_FORMAT_SHORTCUT = "http://i.gtimg.cn/open/device_icon/%s/%s/%s/%s/%s_mark.png";
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
      return String.format("http://i.gtimg.cn/open/device_icon/%s/%s/%s/%s/%s.png", new Object[] { str.substring(0, 2), str.substring(2, 4), str.substring(4, 6), str.substring(6, 8), paramString });
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
    return bbtm.a().a().getSharedPreferences("sd_http_lastmodify", 0).getString(paramString, "");
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
      return String.format("http://i.gtimg.cn/open/device_icon/%s/%s/%s/%s/%s_mark.png", new Object[] { str.substring(0, 2), str.substring(2, 4), str.substring(4, 6), str.substring(6, 8), paramString });
    }
  }
  
  private void init()
  {
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    try
    {
      localSchemeRegistry.register(new Scheme("https", new axvl(DeviceHeadMgr.class.getSimpleName()), 443));
      label56:
      BasicHttpParams localBasicHttpParams = new BasicHttpParams();
      ConnManagerParams.setTimeout(localBasicHttpParams, 3000L);
      HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 30000);
      HttpConnectionParams.setSoTimeout(localBasicHttpParams, 30000);
      this.sHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(new BasicHttpParams(), localSchemeRegistry), null);
      mpw.a(this.mStrCachePath);
      if (azzu.a()) {}
      for (this.mStrCachePath = ajed.bE;; this.mStrCachePath = "/data/data/com.tencent.mobileqq/files/head/_dhd/")
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
    SharedPreferences.Editor localEditor = bbtm.a().a().getSharedPreferences("sd_http_lastmodify", 0).edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }
  
  /* Error */
  public void downloadImage(String arg1, String paramString2, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload 4
    //   2: ifeq +38 -> 40
    //   5: iload_3
    //   6: invokestatic 235	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   9: invokestatic 237	com/tencent/device/DeviceHeadMgr:getLogoIconUrl	(Ljava/lang/String;)Ljava/lang/String;
    //   12: astore_1
    //   13: new 38	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   20: aload_0
    //   21: getfield 62	com/tencent/device/DeviceHeadMgr:mStrCachePath	Ljava/lang/String;
    //   24: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: iload_3
    //   28: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: ldc 242
    //   33: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: astore_2
    //   40: invokestatic 248	java/lang/System:currentTimeMillis	()J
    //   43: lstore 7
    //   45: new 47	java/io/File
    //   48: dup
    //   49: aload_2
    //   50: invokespecial 249	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: astore 12
    //   55: aload 12
    //   57: ifnull +442 -> 499
    //   60: aload 12
    //   62: invokevirtual 252	java/io/File:exists	()Z
    //   65: ifeq +434 -> 499
    //   68: iconst_1
    //   69: istore 5
    //   71: aload 12
    //   73: invokevirtual 255	java/io/File:getParentFile	()Ljava/io/File;
    //   76: astore_2
    //   77: aload_2
    //   78: ifnull +15 -> 93
    //   81: aload_2
    //   82: invokevirtual 252	java/io/File:exists	()Z
    //   85: ifne +8 -> 93
    //   88: aload_2
    //   89: invokevirtual 258	java/io/File:mkdirs	()Z
    //   92: pop
    //   93: ldc 73
    //   95: astore_2
    //   96: new 260	org/apache/http/client/methods/HttpGet
    //   99: dup
    //   100: aload_1
    //   101: invokespecial 261	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   104: astore 11
    //   106: iload 5
    //   108: ifeq +21 -> 129
    //   111: aload_0
    //   112: aload_1
    //   113: invokestatic 266	com/tencent/image/Utils:Crc64String	(Ljava/lang/String;)Ljava/lang/String;
    //   116: invokespecial 268	com/tencent/device/DeviceHeadMgr:getLastModified	(Ljava/lang/String;)Ljava/lang/String;
    //   119: astore_2
    //   120: aload 11
    //   122: ldc_w 270
    //   125: aload_2
    //   126: invokevirtual 273	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +29 -> 161
    //   135: ldc 14
    //   137: iconst_2
    //   138: new 38	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   145: ldc_w 280
    //   148: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_2
    //   152: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 284	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   161: aload_0
    //   162: getfield 189	com/tencent/device/DeviceHeadMgr:sHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   165: aload 11
    //   167: invokevirtual 288	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   170: astore_2
    //   171: aload_2
    //   172: invokeinterface 294 1 0
    //   177: invokeinterface 299 1 0
    //   182: istore 6
    //   184: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   187: ifeq +30 -> 217
    //   190: ldc 14
    //   192: iconst_2
    //   193: new 38	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   200: ldc_w 301
    //   203: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: iload 6
    //   208: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   211: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 284	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   217: aload_2
    //   218: invokeinterface 305 1 0
    //   223: astore 13
    //   225: iload 6
    //   227: sipush 200
    //   230: if_icmpne +173 -> 403
    //   233: iload 5
    //   235: ifeq +9 -> 244
    //   238: aload 12
    //   240: invokevirtual 308	java/io/File:delete	()Z
    //   243: pop
    //   244: new 310	java/io/BufferedOutputStream
    //   247: dup
    //   248: new 312	java/io/FileOutputStream
    //   251: dup
    //   252: aload 12
    //   254: invokespecial 315	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   257: invokespecial 318	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   260: astore 14
    //   262: aload 13
    //   264: aload 14
    //   266: invokeinterface 323 2 0
    //   271: aload 14
    //   273: invokevirtual 328	java/io/OutputStream:flush	()V
    //   276: aload 12
    //   278: invokevirtual 330	java/io/File:length	()J
    //   281: lstore 9
    //   283: aload_2
    //   284: ldc_w 332
    //   287: invokeinterface 335 2 0
    //   292: ifeq +27 -> 319
    //   295: aload_2
    //   296: ldc_w 332
    //   299: invokeinterface 339 2 0
    //   304: invokeinterface 344 1 0
    //   309: astore_2
    //   310: aload_0
    //   311: aload_1
    //   312: invokestatic 266	com/tencent/image/Utils:Crc64String	(Ljava/lang/String;)Ljava/lang/String;
    //   315: aload_2
    //   316: invokespecial 346	com/tencent/device/DeviceHeadMgr:saveLastModified	(Ljava/lang/String;Ljava/lang/String;)V
    //   319: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq +55 -> 377
    //   325: ldc 14
    //   327: iconst_2
    //   328: new 38	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   335: ldc_w 348
    //   338: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokestatic 248	java/lang/System:currentTimeMillis	()J
    //   344: lload 7
    //   346: lsub
    //   347: invokevirtual 351	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   350: ldc_w 353
    //   353: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: lload 9
    //   358: invokevirtual 351	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   361: ldc_w 355
    //   364: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload_1
    //   368: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokestatic 358	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   377: iload 4
    //   379: ifeq +54 -> 433
    //   382: aload_0
    //   383: getfield 213	com/tencent/device/DeviceHeadMgr:mDeviceOriginalHeadMap	Ljava/util/HashMap;
    //   386: astore_1
    //   387: aload_1
    //   388: monitorenter
    //   389: aload_0
    //   390: getfield 213	com/tencent/device/DeviceHeadMgr:mDeviceOriginalHeadMap	Ljava/util/HashMap;
    //   393: iload_3
    //   394: invokestatic 363	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   397: invokevirtual 367	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   400: pop
    //   401: aload_1
    //   402: monitorexit
    //   403: aload 11
    //   405: invokevirtual 370	org/apache/http/client/methods/HttpGet:abort	()V
    //   408: return
    //   409: astore_2
    //   410: aload_1
    //   411: monitorexit
    //   412: aload_2
    //   413: athrow
    //   414: astore_1
    //   415: aload_1
    //   416: invokevirtual 373	java/lang/Exception:printStackTrace	()V
    //   419: goto -16 -> 403
    //   422: astore_1
    //   423: aload_1
    //   424: invokevirtual 373	java/lang/Exception:printStackTrace	()V
    //   427: aload 11
    //   429: invokevirtual 370	org/apache/http/client/methods/HttpGet:abort	()V
    //   432: return
    //   433: aload_0
    //   434: getfield 206	com/tencent/device/DeviceHeadMgr:mDeviceHeadMap	Ljava/util/HashMap;
    //   437: astore_1
    //   438: aload_1
    //   439: monitorenter
    //   440: aload_0
    //   441: getfield 206	com/tencent/device/DeviceHeadMgr:mDeviceHeadMap	Ljava/util/HashMap;
    //   444: iload_3
    //   445: invokestatic 363	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   448: invokevirtual 367	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   451: pop
    //   452: aload_1
    //   453: monitorexit
    //   454: new 375	android/content/Intent
    //   457: dup
    //   458: ldc_w 377
    //   461: invokespecial 378	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   464: astore_1
    //   465: aload_1
    //   466: ldc_w 380
    //   469: iload_3
    //   470: invokevirtual 384	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   473: pop
    //   474: invokestatic 390	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   477: aload_1
    //   478: invokevirtual 394	com/tencent/common/app/BaseApplicationImpl:sendBroadcast	(Landroid/content/Intent;)V
    //   481: goto -78 -> 403
    //   484: astore_1
    //   485: aload 11
    //   487: invokevirtual 370	org/apache/http/client/methods/HttpGet:abort	()V
    //   490: aload_1
    //   491: athrow
    //   492: astore_2
    //   493: aload_1
    //   494: monitorexit
    //   495: aload_2
    //   496: athrow
    //   497: astore_1
    //   498: return
    //   499: iconst_0
    //   500: istore 5
    //   502: goto -431 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	505	0	this	DeviceHeadMgr
    //   0	505	2	paramString2	String
    //   0	505	3	paramInt	int
    //   0	505	4	paramBoolean	boolean
    //   69	432	5	i	int
    //   182	49	6	j	int
    //   43	302	7	l1	long
    //   281	76	9	l2	long
    //   104	382	11	localHttpGet	org.apache.http.client.methods.HttpGet
    //   53	224	12	localFile	File
    //   223	40	13	localHttpEntity	org.apache.http.HttpEntity
    //   260	12	14	localBufferedOutputStream	java.io.BufferedOutputStream
    // Exception table:
    //   from	to	target	type
    //   389	403	409	finally
    //   410	412	409	finally
    //   244	319	414	java/lang/Exception
    //   319	377	414	java/lang/Exception
    //   382	389	414	java/lang/Exception
    //   412	414	414	java/lang/Exception
    //   433	440	414	java/lang/Exception
    //   454	481	414	java/lang/Exception
    //   495	497	414	java/lang/Exception
    //   161	217	422	java/lang/Exception
    //   217	225	422	java/lang/Exception
    //   238	244	422	java/lang/Exception
    //   415	419	422	java/lang/Exception
    //   161	217	484	finally
    //   217	225	484	finally
    //   238	244	484	finally
    //   244	319	484	finally
    //   319	377	484	finally
    //   382	389	484	finally
    //   412	414	484	finally
    //   415	419	484	finally
    //   423	427	484	finally
    //   433	440	484	finally
    //   454	481	484	finally
    //   495	497	484	finally
    //   440	454	492	finally
    //   493	495	492	finally
    //   71	77	497	java/lang/Exception
    //   81	93	497	java/lang/Exception
  }
  
  public Bitmap getDeviceHeadByDin(String paramString)
  {
    paramString = ((xrh)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(51)).a(Long.parseLong(paramString));
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
        ??? = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), 2130839269);
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
      Bitmap localBitmap1 = azvq.a(str);
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if (!this.mDownedDevicePid.containsKey(Integer.valueOf(paramInt)))
      {
        if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)))
        {
          ((QQAppInterface)localAppRuntime).a(new DeviceHeadMgr.1(this, (String)???, str, paramInt));
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
        localBitmap1 = QQAppInterface.a(localBitmap1, 50, 50);
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
          return azvq.a(BaseApplication.getContext().getResources(), 2130839269);
          new Thread(new DeviceHeadMgr.2(this, (String)???, str, paramInt)).start();
          break;
          localBitmap1 = bacm.c(localBitmap1, 50, 50);
        }
      }
    }
    return ???;
  }
  
  public Drawable getDeviceHeadDrawableByDin(String paramString)
  {
    if (ajed.y.equals(paramString))
    {
      paramString = azvq.a(BaseApplication.getContext().getResources(), 2130839271);
      return new BitmapDrawable(BaseApplication.getContext().getResources(), paramString);
    }
    long l = Long.parseLong(paramString);
    DeviceInfo localDeviceInfo = ((xrh)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(51)).a(Long.valueOf(l).longValue());
    Bitmap localBitmap = null;
    if (localDeviceInfo != null)
    {
      localBitmap = getDeviceHeadByPID(localDeviceInfo.productId);
      if (isLostQfindDevice(paramString))
      {
        paramString = BaseApplication.getContext().getResources().getDrawable(2130839268);
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
    return azvq.a(this.mStrCachePath + paramInt);
  }
  
  public Bitmap getDeviceWithLogoByPid(int paramInt)
  {
    if (paramInt == 9971) {
      ??? = azvq.a(BaseApplication.getContext().getResources(), 2130839272);
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
        localBitmap = azvq.a(this.mStrCachePath + String.valueOf(paramInt) + "_mark");
        ??? = localBitmap;
        if (localBitmap != null) {
          continue;
        }
        localBitmap = getDeviceHeadByPID(paramInt);
        ??? = localBitmap;
        if (localBitmap != null) {
          continue;
        }
        return azvq.a(BaseApplication.getContext().getResources(), 2130839269);
      }
    }
  }
  
  public boolean isLostQfindDevice(String paramString)
  {
    return ((xrh)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(51)).a(Long.parseLong(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.DeviceHeadMgr
 * JD-Core Version:    0.7.0.1
 */