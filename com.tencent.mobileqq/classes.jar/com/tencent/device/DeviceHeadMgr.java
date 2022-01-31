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
  protected static final String URI_DEVICE_ICON_FORMAT = "http://i.gtimg.cn/open/device_icon/%s/%s/%s/%s/%s.png";
  protected static final String URI_DEVICE_ICON_FORMAT_SHORTCUT = "http://i.gtimg.cn/open/device_icon/%s/%s/%s/%s/%s_mark.png";
  private static DeviceHeadMgr instance;
  private HashMap mDeviceHeadMap;
  private HashMap mDeviceOriginalHeadMap;
  private HashMap mDownedDevicePid;
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
    return CommonDataAdapter.a().a().getSharedPreferences("sd_http_lastmodify", 0).getString(paramString, "");
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
      localSchemeRegistry.register(new Scheme("https", new TlsSniSocketFactory(DeviceHeadMgr.class.getSimpleName()), 443));
      label56:
      BasicHttpParams localBasicHttpParams = new BasicHttpParams();
      ConnManagerParams.setTimeout(localBasicHttpParams, 3000L);
      HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 30000);
      HttpConnectionParams.setSoTimeout(localBasicHttpParams, 30000);
      this.sHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(new BasicHttpParams(), localSchemeRegistry), null);
      Util.a(this.mStrCachePath);
      if (SystemUtil.a()) {}
      for (this.mStrCachePath = AppConstants.cb;; this.mStrCachePath = "/data/data/com.tencent.mobileqq/files/head/_dhd/")
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
    SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("sd_http_lastmodify", 0).edit();
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
    //   6: invokestatic 232	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   9: invokestatic 234	com/tencent/device/DeviceHeadMgr:getLogoIconUrl	(Ljava/lang/String;)Ljava/lang/String;
    //   12: astore_1
    //   13: new 35	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   20: aload_0
    //   21: getfield 59	com/tencent/device/DeviceHeadMgr:mStrCachePath	Ljava/lang/String;
    //   24: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: iload_3
    //   28: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: ldc 239
    //   33: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: astore_2
    //   40: invokestatic 245	java/lang/System:currentTimeMillis	()J
    //   43: lstore 7
    //   45: new 44	java/io/File
    //   48: dup
    //   49: aload_2
    //   50: invokespecial 246	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: astore 12
    //   55: aload 12
    //   57: ifnull +442 -> 499
    //   60: aload 12
    //   62: invokevirtual 249	java/io/File:exists	()Z
    //   65: ifeq +434 -> 499
    //   68: iconst_1
    //   69: istore 5
    //   71: aload 12
    //   73: invokevirtual 252	java/io/File:getParentFile	()Ljava/io/File;
    //   76: astore_2
    //   77: aload_2
    //   78: ifnull +15 -> 93
    //   81: aload_2
    //   82: invokevirtual 249	java/io/File:exists	()Z
    //   85: ifne +8 -> 93
    //   88: aload_2
    //   89: invokevirtual 255	java/io/File:mkdirs	()Z
    //   92: pop
    //   93: ldc 70
    //   95: astore_2
    //   96: new 257	org/apache/http/client/methods/HttpGet
    //   99: dup
    //   100: aload_1
    //   101: invokespecial 258	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   104: astore 11
    //   106: iload 5
    //   108: ifeq +21 -> 129
    //   111: aload_0
    //   112: aload_1
    //   113: invokestatic 263	com/tencent/image/Utils:Crc64String	(Ljava/lang/String;)Ljava/lang/String;
    //   116: invokespecial 265	com/tencent/device/DeviceHeadMgr:getLastModified	(Ljava/lang/String;)Ljava/lang/String;
    //   119: astore_2
    //   120: aload 11
    //   122: ldc_w 267
    //   125: aload_2
    //   126: invokevirtual 270	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +29 -> 161
    //   135: ldc 14
    //   137: iconst_2
    //   138: new 35	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   145: ldc_w 277
    //   148: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_2
    //   152: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 281	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   161: aload_0
    //   162: getfield 186	com/tencent/device/DeviceHeadMgr:sHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   165: aload 11
    //   167: invokevirtual 285	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   170: astore_2
    //   171: aload_2
    //   172: invokeinterface 291 1 0
    //   177: invokeinterface 296 1 0
    //   182: istore 6
    //   184: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   187: ifeq +30 -> 217
    //   190: ldc 14
    //   192: iconst_2
    //   193: new 35	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   200: ldc_w 298
    //   203: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: iload 6
    //   208: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   211: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 281	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   217: aload_2
    //   218: invokeinterface 302 1 0
    //   223: astore 13
    //   225: iload 6
    //   227: sipush 200
    //   230: if_icmpne +173 -> 403
    //   233: iload 5
    //   235: ifeq +9 -> 244
    //   238: aload 12
    //   240: invokevirtual 305	java/io/File:delete	()Z
    //   243: pop
    //   244: new 307	java/io/BufferedOutputStream
    //   247: dup
    //   248: new 309	java/io/FileOutputStream
    //   251: dup
    //   252: aload 12
    //   254: invokespecial 312	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   257: invokespecial 315	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   260: astore 14
    //   262: aload 13
    //   264: aload 14
    //   266: invokeinterface 320 2 0
    //   271: aload 14
    //   273: invokevirtual 325	java/io/OutputStream:flush	()V
    //   276: aload 12
    //   278: invokevirtual 327	java/io/File:length	()J
    //   281: lstore 9
    //   283: aload_2
    //   284: ldc_w 329
    //   287: invokeinterface 332 2 0
    //   292: ifeq +27 -> 319
    //   295: aload_2
    //   296: ldc_w 329
    //   299: invokeinterface 336 2 0
    //   304: invokeinterface 341 1 0
    //   309: astore_2
    //   310: aload_0
    //   311: aload_1
    //   312: invokestatic 263	com/tencent/image/Utils:Crc64String	(Ljava/lang/String;)Ljava/lang/String;
    //   315: aload_2
    //   316: invokespecial 343	com/tencent/device/DeviceHeadMgr:saveLastModified	(Ljava/lang/String;Ljava/lang/String;)V
    //   319: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq +55 -> 377
    //   325: ldc 14
    //   327: iconst_2
    //   328: new 35	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   335: ldc_w 345
    //   338: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokestatic 245	java/lang/System:currentTimeMillis	()J
    //   344: lload 7
    //   346: lsub
    //   347: invokevirtual 348	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   350: ldc_w 350
    //   353: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: lload 9
    //   358: invokevirtual 348	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   361: ldc_w 352
    //   364: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload_1
    //   368: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokestatic 355	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   377: iload 4
    //   379: ifeq +54 -> 433
    //   382: aload_0
    //   383: getfield 210	com/tencent/device/DeviceHeadMgr:mDeviceOriginalHeadMap	Ljava/util/HashMap;
    //   386: astore_1
    //   387: aload_1
    //   388: monitorenter
    //   389: aload_0
    //   390: getfield 210	com/tencent/device/DeviceHeadMgr:mDeviceOriginalHeadMap	Ljava/util/HashMap;
    //   393: iload_3
    //   394: invokestatic 360	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   397: invokevirtual 364	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   400: pop
    //   401: aload_1
    //   402: monitorexit
    //   403: aload 11
    //   405: invokevirtual 367	org/apache/http/client/methods/HttpGet:abort	()V
    //   408: return
    //   409: astore_2
    //   410: aload_1
    //   411: monitorexit
    //   412: aload_2
    //   413: athrow
    //   414: astore_1
    //   415: aload_1
    //   416: invokevirtual 370	java/lang/Exception:printStackTrace	()V
    //   419: goto -16 -> 403
    //   422: astore_1
    //   423: aload_1
    //   424: invokevirtual 370	java/lang/Exception:printStackTrace	()V
    //   427: aload 11
    //   429: invokevirtual 367	org/apache/http/client/methods/HttpGet:abort	()V
    //   432: return
    //   433: aload_0
    //   434: getfield 203	com/tencent/device/DeviceHeadMgr:mDeviceHeadMap	Ljava/util/HashMap;
    //   437: astore_1
    //   438: aload_1
    //   439: monitorenter
    //   440: aload_0
    //   441: getfield 203	com/tencent/device/DeviceHeadMgr:mDeviceHeadMap	Ljava/util/HashMap;
    //   444: iload_3
    //   445: invokestatic 360	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   448: invokevirtual 364	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   451: pop
    //   452: aload_1
    //   453: monitorexit
    //   454: new 372	android/content/Intent
    //   457: dup
    //   458: ldc_w 374
    //   461: invokespecial 375	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   464: astore_1
    //   465: aload_1
    //   466: ldc_w 377
    //   469: iload_3
    //   470: invokevirtual 381	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   473: pop
    //   474: invokestatic 387	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   477: aload_1
    //   478: invokevirtual 391	com/tencent/common/app/BaseApplicationImpl:sendBroadcast	(Landroid/content/Intent;)V
    //   481: goto -78 -> 403
    //   484: astore_1
    //   485: aload 11
    //   487: invokevirtual 367	org/apache/http/client/methods/HttpGet:abort	()V
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
    paramString = ((SmartDeviceProxyMgr)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(51)).a(Long.parseLong(paramString));
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
        ??? = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), 2130838730);
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
      Bitmap localBitmap1 = BitmapManager.a(str);
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
          break label312;
        }
        if ((localAppRuntime == null) || (!(localAppRuntime instanceof QQAppInterface))) {
          break label295;
        }
        localBitmap1 = ((QQAppInterface)localAppRuntime).a(localBitmap1, 50, 50);
      }
      label295:
      label312:
      for (;;)
      {
        synchronized (this.mDeviceHeadMap)
        {
          this.mDeviceHeadMap.put(Integer.valueOf(paramInt), localBitmap1);
          ??? = localBitmap1;
          if (localBitmap1 != null) {
            return ???;
          }
          return BitmapManager.a(BaseApplication.getContext().getResources(), 2130838730);
          new Thread(new DeviceHeadMgr.2(this, (String)???, str, paramInt)).start();
          break;
          localBitmap1 = ImageUtil.c(localBitmap1, 50, 50);
        }
      }
    }
    return ???;
  }
  
  public Drawable getDeviceHeadDrawableByDin(String paramString)
  {
    if (AppConstants.x.equals(paramString))
    {
      paramString = BitmapManager.a(BaseApplication.getContext().getResources(), 2130838732);
      return new BitmapDrawable(BaseApplication.getContext().getResources(), paramString);
    }
    long l = Long.parseLong(paramString);
    DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(51)).a(Long.valueOf(l).longValue());
    Bitmap localBitmap = null;
    if (localDeviceInfo != null)
    {
      localBitmap = getDeviceHeadByPID(localDeviceInfo.productId);
      if (isLostQfindDevice(paramString))
      {
        paramString = BaseApplication.getContext().getResources().getDrawable(2130838729);
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
    return BitmapManager.a(this.mStrCachePath + paramInt);
  }
  
  public Bitmap getDeviceWithLogoByPid(int paramInt)
  {
    if (paramInt == 9971) {
      ??? = BitmapManager.a(BaseApplication.getContext().getResources(), 2130838733);
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
        localBitmap = BitmapManager.a(this.mStrCachePath + String.valueOf(paramInt) + "_mark");
        ??? = localBitmap;
        if (localBitmap != null) {
          continue;
        }
        localBitmap = getDeviceHeadByPID(paramInt);
        ??? = localBitmap;
        if (localBitmap != null) {
          continue;
        }
        return BitmapManager.a(BaseApplication.getContext().getResources(), 2130838730);
      }
    }
  }
  
  public boolean isLostQfindDevice(String paramString)
  {
    return ((SmartDeviceProxyMgr)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(51)).a(Long.parseLong(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.DeviceHeadMgr
 * JD-Core Version:    0.7.0.1
 */