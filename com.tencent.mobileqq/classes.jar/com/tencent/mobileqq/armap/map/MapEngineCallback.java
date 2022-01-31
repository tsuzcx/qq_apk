package com.tencent.mobileqq.armap.map;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.Typeface;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.qq.im.poi.LbsPackManager;
import com.qq.im.poi.LbsPackMapPoiPackServlet;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.ARMapDownloader;
import com.tencent.mobileqq.armap.ARMapDownloader.DownloadListener;
import com.tencent.mobileqq.armap.ARMapManager;
import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.mobileqq.armap.ArMapObserver;
import com.tencent.mobileqq.armap.ArMapUtil;
import com.tencent.mobileqq.armap.JNIPOIRequestParam;
import com.tencent.mobileqq.armap.NonMainAppHeadLoader;
import com.tencent.mobileqq.armap.NonMainAppHeadLoader.FaceObserver;
import com.tencent.mobileqq.armap.test.MapTestHelper;
import com.tencent.mobileqq.armap.utils.ARResUtil;
import com.tencent.mobileqq.armap.utils.MapLog;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;

public class MapEngineCallback
  implements Handler.Callback, ARMapDownloader.DownloadListener
{
  public static final int CB_TYPE_CAL_TEXT_SIZE = 2;
  public static final int CB_TYPE_DOWNLOAD = 3;
  public static final int CB_TYPE_DRAW_TEXT = 1;
  public static final int CB_TYPE_GET_C2C_POILIST = 11;
  public static final int CB_TYPE_GET_FRIEND_ICON_PATH = 12;
  public static final int CB_TYPE_GET_HEAD_ICON_PATH = 7;
  public static final int CB_TYPE_GET_POILIST = 6;
  public static final int CB_TYPE_GET_UIN = 9;
  public static final int CB_TYPE_LOAD_IMG = 4;
  public static final int CB_TYPE_SERVER_TIME = 10;
  public static final int CB_TYPE_WRITE_FILE = 5;
  public static final int DEFAULT_SERVER_TIME = 1483203661;
  public static final int MSG_MAPDOWNLOAD_TIMEOUT = 1;
  public static final String PIN_HEAD_NAME = "myPinHead.png";
  private static final String TAG = "MapEngineCallback";
  public static final int TEXT_BITMAP_HEIGHT = 400;
  public static final int TEXT_BITMAP_WIDTH = 800;
  public static int testServerTime = 1483203661;
  public ARMapDownloader mARMapDownloader;
  protected ARMapActivity mActivity;
  public ArMapInterface mApp;
  ArMapObserver mArmapObserver = new MapEngineCallback.1(this);
  String mCommonDir = "";
  float mDensity;
  NonMainAppHeadLoader.FaceObserver mFaceObser = new MapEngineCallback.2(this);
  String mMapConfigDir = "";
  String mMapDaySkinDir = "";
  int mMapDayStyle;
  String mMapNightSkinDir = "";
  int mMapNightStyle;
  long mNativePOIMangerHandle;
  boolean mNeedReloadHead = false;
  String mOpenBoxDir = "";
  String mSkySkinDir = "";
  Handler mSubHandler;
  public Bitmap mTextBitmapBuffer;
  public MapEngineCallback.TextBitmapInfo mTextBitmapInfo;
  public Canvas mTextCanvas;
  public Paint mTextPaint;
  float mTextScale = 2.0F;
  public PointF mTextSizeBuffer;
  String mTreeDir = "";
  private Handler mUIHandler;
  String[] preloadMapFiles;
  
  public MapEngineCallback(ARMapActivity paramARMapActivity, ArMapInterface paramArMapInterface, Handler paramHandler)
  {
    this.mActivity = paramARMapActivity;
    this.mUIHandler = paramHandler;
    this.mDensity = this.mActivity.getResources().getDisplayMetrics().density;
    this.mTextBitmapBuffer = Bitmap.createBitmap(800, 400, Bitmap.Config.ALPHA_8);
    this.mTextSizeBuffer = new PointF();
    this.mTextBitmapInfo = new MapEngineCallback.TextBitmapInfo();
    this.mApp = paramArMapInterface;
    this.mApp.a.a(this.mFaceObser);
    this.mApp.a.a(this.mApp.getCurrentAccountUin(), true);
    this.mApp.addObserver(this.mArmapObserver);
    this.mSubHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  public static String getHeadPngDirPath()
  {
    Object localObject2 = Environment.getExternalStorageDirectory().getPath();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "/sdcard/";
    }
    localObject2 = localObject1;
    if (!((String)localObject1).endsWith("/")) {
      localObject2 = (String)localObject1 + "/";
    }
    localObject1 = (String)localObject2 + "Tencent/MobileQQ/AR_MAP/";
    try
    {
      localObject2 = new File((String)localObject1);
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdirs();
      }
      return localObject1;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MapEngineCallback", 2, "getHeadPngDirPath e:", localException);
    }
    return localObject1;
  }
  
  public static String getRootPath()
  {
    Object localObject2 = Environment.getExternalStorageDirectory().getPath();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "/sdcard/";
    }
    localObject2 = localObject1;
    if (!((String)localObject1).endsWith("/")) {
      localObject2 = (String)localObject1 + "/";
    }
    localObject1 = (String)localObject2 + "tencent_map/";
    try
    {
      localObject2 = new File((String)localObject1);
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdirs();
      }
      return localObject1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localObject1;
  }
  
  public static Bitmap mergeBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    int i = paramBitmap1.getWidth() - 38 - 8;
    float f1 = i * 1.0F / paramBitmap2.getWidth();
    float f2 = i * 1.0F / paramBitmap2.getHeight();
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(f1, f2);
    localMatrix.postTranslate(23.0F, 6.0F);
    paramBitmap1 = paramBitmap1.copy(Bitmap.Config.ARGB_8888, true);
    new Canvas(paramBitmap1).drawBitmap(paramBitmap2, localMatrix, new Paint());
    return paramBitmap1;
  }
  
  public static native void setMapEngineParam(float paramFloat1, float paramFloat2, String paramString1, String paramString2, String paramString3, Object paramObject, String paramString4, String paramString5, int paramInt1, int paramInt2, String[] paramArrayOfString);
  
  public static native void updateC2CPOIList(boolean paramBoolean, byte[] paramArrayOfByte, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6);
  
  public static native void updatePOIList(boolean paramBoolean, byte[] paramArrayOfByte, long paramLong1, long paramLong2);
  
  public static native void writeMapDownloadData(String paramString, byte[] paramArrayOfByte, int paramInt);
  
  public PointF calTextSize(String paramString, int paramInt)
  {
    initTextPaint(paramInt);
    float f = this.mTextPaint.measureText(paramString);
    if (this.mTextSizeBuffer == null) {
      this.mTextSizeBuffer = new PointF();
    }
    this.mTextSizeBuffer.x = (f + 1.0F);
    this.mTextSizeBuffer.y = (paramInt + 2);
    return this.mTextSizeBuffer;
  }
  
  public Object callback(int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte, Object paramObject)
  {
    if (MapLog.isLoggable(1)) {
      MapLog.i("MapEngineCallback", 4, "callback, what=%d, arg1=%d, arg2=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    switch (paramInt1)
    {
    case 8: 
    default: 
      return null;
    case 1: 
      return drawText(paramInt2, str, paramArrayOfByte);
    case 2: 
      return calTextSize(str, paramInt2);
    case 3: 
      download(str);
      return null;
    case 4: 
      paramString = loadImg(str);
      paramArrayOfByte = new MapEngineCallback.IconImageInfo();
      paramArrayOfByte.bitmap = paramString;
      return paramArrayOfByte;
    case 5: 
      writeFile(str, paramArrayOfByte);
      return null;
    case 6: 
      if (!(paramObject instanceof JNIPOIRequestParam)) {
        break;
      }
    }
    for (paramString = (JNIPOIRequestParam)paramObject;; paramString = null)
    {
      if (paramString == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("MapEngineCallback", 2, "CB_TYPE_GET_POILIST JNIPOIRequestParam is null");
        return null;
      }
      ThreadManager.post(new MapEngineCallback.3(this, paramString), 5, null, false);
      return null;
      paramArrayOfByte = null;
      if ((paramObject instanceof JNIPOIRequestParam)) {
        paramArrayOfByte = (JNIPOIRequestParam)paramObject;
      }
      if (paramArrayOfByte == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("MapEngineCallback", 2, "CB_TYPE_GET_POILIST JNIPOIRequestParam is null");
        return null;
      }
      paramString = null;
      if (this.mActivity != null)
      {
        if (!StringUtil.a(this.mActivity.i)) {
          paramString = this.mActivity.i;
        }
        if (StringUtil.a(paramArrayOfByte.lbsPid)) {
          break label499;
        }
        paramString = paramArrayOfByte.lbsPid;
      }
      label499:
      for (;;)
      {
        if (this.mActivity.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView != null) {
          paramArrayOfByte.nativeGLSurfaceViewContext = this.mActivity.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.getEngineHandler();
        }
        LbsPackMapPoiPackServlet.a(this.mApp, paramArrayOfByte.longitude, paramArrayOfByte.latitude, paramString, paramArrayOfByte.nativeHandle, paramArrayOfByte, paramArrayOfByte.nativeGLSurfaceViewContext, this.mActivity.e);
        if (QLog.isColorLevel()) {
          MapLog.i(2, "CB_TYPE_GET_C2C_POILIST param: %s", new Object[] { paramArrayOfByte.toString() });
        }
        return null;
        if (QLog.isDevelopLevel()) {
          QLog.i("MapEngineCallback", 4, "CB_TYPE_GET_HEAD_ICON_PATH");
        }
        this.mNativePOIMangerHandle = ((Long)paramObject).longValue();
        ThreadManager.post(new MapEngineCallback.4(this), 5, null, false);
        return null;
        return this.mApp.getCurrentAccountUin();
        if (MapTestHelper.jdField_a_of_type_Int == 3) {
          testServerTime = (int)(System.currentTimeMillis() / 1000L);
        }
        return Integer.valueOf((int)NetConnInfoCenter.getServerTime());
        return ((LbsPackManager)this.mApp.getManager(214)).c(str);
      }
    }
  }
  
  public void dismissGameTipView() {}
  
  public void download(String paramString)
  {
    if (this.mARMapDownloader == null)
    {
      this.mARMapDownloader = ((ARMapManager)this.mApp.getManager(209)).a();
      this.mARMapDownloader.a(this);
    }
    if (QLog.isColorLevel()) {
      QLog.d("MapEngineCallback", 2, "armap download mapdata,url:" + paramString);
    }
    this.mARMapDownloader.a(paramString);
  }
  
  public Bitmap drawText(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    if (this.mTextBitmapBuffer == null) {
      this.mTextBitmapBuffer = Bitmap.createBitmap(800, 400, Bitmap.Config.ALPHA_8);
    }
    if (this.mTextCanvas == null) {
      this.mTextCanvas = new Canvas(this.mTextBitmapBuffer);
    }
    this.mTextBitmapInfo.fill(paramArrayOfByte);
    initTextPaint(paramInt);
    this.mTextBitmapBuffer.eraseColor(0);
    float f = (this.mTextPaint.descent() + this.mTextPaint.ascent()) / 2.0F;
    this.mTextPaint.setFakeBoldText(this.mTextBitmapInfo.bold);
    this.mTextCanvas.drawText(paramString, 400.0F, 200.0F - f, this.mTextPaint);
    return this.mTextBitmapBuffer;
  }
  
  /* Error */
  String generateHeadIcon(String paramString, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: new 223	java/io/File
    //   3: dup
    //   4: new 244	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   11: invokestatic 546	com/tencent/mobileqq/armap/map/MapEngineCallback:getHeadPngDirPath	()Ljava/lang/String;
    //   14: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_1
    //   18: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokespecial 257	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: astore 4
    //   29: aload 4
    //   31: invokevirtual 261	java/io/File:exists	()Z
    //   34: ifne +9 -> 43
    //   37: aload 4
    //   39: invokevirtual 549	java/io/File:createNewFile	()Z
    //   42: pop
    //   43: new 551	java/io/BufferedInputStream
    //   46: dup
    //   47: new 553	java/io/FileInputStream
    //   50: dup
    //   51: new 244	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   58: aload_0
    //   59: getfield 126	com/tencent/mobileqq/armap/map/MapEngineCallback:mCommonDir	Ljava/lang/String;
    //   62: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: ldc_w 555
    //   68: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokespecial 556	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   77: invokespecial 559	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   80: astore_3
    //   81: aload_3
    //   82: invokestatic 565	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   85: aload_2
    //   86: invokestatic 567	com/tencent/mobileqq/armap/map/MapEngineCallback:mergeBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   89: astore 6
    //   91: new 569	java/io/BufferedOutputStream
    //   94: dup
    //   95: new 571	java/io/FileOutputStream
    //   98: dup
    //   99: aload 4
    //   101: invokespecial 574	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   104: invokespecial 577	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   107: astore 5
    //   109: aload_3
    //   110: astore 4
    //   112: aload 5
    //   114: astore_2
    //   115: aload 6
    //   117: getstatic 583	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   120: bipush 100
    //   122: aload 5
    //   124: invokevirtual 587	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   127: pop
    //   128: aload 5
    //   130: ifnull +8 -> 138
    //   133: aload 5
    //   135: invokevirtual 592	java/io/OutputStream:close	()V
    //   138: aload_1
    //   139: astore_2
    //   140: aload_3
    //   141: ifnull +9 -> 150
    //   144: aload_3
    //   145: invokevirtual 595	java/io/InputStream:close	()V
    //   148: aload_1
    //   149: astore_2
    //   150: invokestatic 269	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   153: ifeq +29 -> 182
    //   156: ldc 41
    //   158: iconst_2
    //   159: new 244	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   166: ldc_w 597
    //   169: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload_2
    //   173: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 508	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: aload_2
    //   183: areturn
    //   184: astore_2
    //   185: aload_2
    //   186: invokevirtual 598	java/io/IOException:printStackTrace	()V
    //   189: goto -51 -> 138
    //   192: astore_2
    //   193: aload_2
    //   194: invokevirtual 598	java/io/IOException:printStackTrace	()V
    //   197: aload_1
    //   198: astore_2
    //   199: goto -49 -> 150
    //   202: astore_1
    //   203: aconst_null
    //   204: astore_3
    //   205: aconst_null
    //   206: astore 5
    //   208: aload_3
    //   209: astore 4
    //   211: aload 5
    //   213: astore_2
    //   214: aload_1
    //   215: invokevirtual 598	java/io/IOException:printStackTrace	()V
    //   218: aload_3
    //   219: astore 4
    //   221: aload 5
    //   223: astore_2
    //   224: invokestatic 269	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   227: ifeq +19 -> 246
    //   230: aload_3
    //   231: astore 4
    //   233: aload 5
    //   235: astore_2
    //   236: ldc 41
    //   238: iconst_2
    //   239: ldc_w 600
    //   242: aload_1
    //   243: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   246: aload 5
    //   248: ifnull +8 -> 256
    //   251: aload 5
    //   253: invokevirtual 592	java/io/OutputStream:close	()V
    //   256: aload_3
    //   257: ifnull +272 -> 529
    //   260: aload_3
    //   261: invokevirtual 595	java/io/InputStream:close	()V
    //   264: aconst_null
    //   265: astore_2
    //   266: goto -116 -> 150
    //   269: astore_1
    //   270: aload_1
    //   271: invokevirtual 598	java/io/IOException:printStackTrace	()V
    //   274: goto -18 -> 256
    //   277: astore_1
    //   278: aload_1
    //   279: invokevirtual 598	java/io/IOException:printStackTrace	()V
    //   282: aconst_null
    //   283: astore_2
    //   284: goto -134 -> 150
    //   287: astore_1
    //   288: aconst_null
    //   289: astore_3
    //   290: aconst_null
    //   291: astore 5
    //   293: aload_3
    //   294: astore 4
    //   296: aload 5
    //   298: astore_2
    //   299: invokestatic 269	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   302: ifeq +38 -> 340
    //   305: aload_3
    //   306: astore 4
    //   308: aload 5
    //   310: astore_2
    //   311: ldc 41
    //   313: iconst_2
    //   314: new 244	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   321: ldc_w 602
    //   324: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: aload_1
    //   328: invokevirtual 605	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   331: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: invokestatic 508	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   340: aload 5
    //   342: ifnull +8 -> 350
    //   345: aload 5
    //   347: invokevirtual 592	java/io/OutputStream:close	()V
    //   350: aload_3
    //   351: ifnull +178 -> 529
    //   354: aload_3
    //   355: invokevirtual 595	java/io/InputStream:close	()V
    //   358: aconst_null
    //   359: astore_2
    //   360: goto -210 -> 150
    //   363: astore_1
    //   364: aload_1
    //   365: invokevirtual 598	java/io/IOException:printStackTrace	()V
    //   368: goto -18 -> 350
    //   371: astore_1
    //   372: aload_1
    //   373: invokevirtual 598	java/io/IOException:printStackTrace	()V
    //   376: aconst_null
    //   377: astore_2
    //   378: goto -228 -> 150
    //   381: astore_1
    //   382: aconst_null
    //   383: astore_3
    //   384: aconst_null
    //   385: astore 5
    //   387: aload_3
    //   388: astore 4
    //   390: aload 5
    //   392: astore_2
    //   393: ldc 41
    //   395: iconst_1
    //   396: ldc_w 607
    //   399: aload_1
    //   400: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   403: aload 5
    //   405: ifnull +8 -> 413
    //   408: aload 5
    //   410: invokevirtual 592	java/io/OutputStream:close	()V
    //   413: aload_3
    //   414: ifnull +115 -> 529
    //   417: aload_3
    //   418: invokevirtual 595	java/io/InputStream:close	()V
    //   421: aconst_null
    //   422: astore_2
    //   423: goto -273 -> 150
    //   426: astore_1
    //   427: aload_1
    //   428: invokevirtual 598	java/io/IOException:printStackTrace	()V
    //   431: goto -18 -> 413
    //   434: astore_1
    //   435: aload_1
    //   436: invokevirtual 598	java/io/IOException:printStackTrace	()V
    //   439: aconst_null
    //   440: astore_2
    //   441: goto -291 -> 150
    //   444: astore_1
    //   445: aconst_null
    //   446: astore_3
    //   447: aconst_null
    //   448: astore_2
    //   449: aload_2
    //   450: ifnull +7 -> 457
    //   453: aload_2
    //   454: invokevirtual 592	java/io/OutputStream:close	()V
    //   457: aload_3
    //   458: ifnull +7 -> 465
    //   461: aload_3
    //   462: invokevirtual 595	java/io/InputStream:close	()V
    //   465: aload_1
    //   466: athrow
    //   467: astore_2
    //   468: aload_2
    //   469: invokevirtual 598	java/io/IOException:printStackTrace	()V
    //   472: goto -15 -> 457
    //   475: astore_2
    //   476: aload_2
    //   477: invokevirtual 598	java/io/IOException:printStackTrace	()V
    //   480: goto -15 -> 465
    //   483: astore_1
    //   484: aconst_null
    //   485: astore_2
    //   486: goto -37 -> 449
    //   489: astore_1
    //   490: aload 4
    //   492: astore_3
    //   493: goto -44 -> 449
    //   496: astore_1
    //   497: aconst_null
    //   498: astore 5
    //   500: goto -113 -> 387
    //   503: astore_1
    //   504: goto -117 -> 387
    //   507: astore_1
    //   508: aconst_null
    //   509: astore 5
    //   511: goto -218 -> 293
    //   514: astore_1
    //   515: goto -222 -> 293
    //   518: astore_1
    //   519: aconst_null
    //   520: astore 5
    //   522: goto -314 -> 208
    //   525: astore_1
    //   526: goto -318 -> 208
    //   529: aconst_null
    //   530: astore_2
    //   531: goto -381 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	534	0	this	MapEngineCallback
    //   0	534	1	paramString	String
    //   0	534	2	paramBitmap	Bitmap
    //   80	413	3	localObject1	Object
    //   27	464	4	localObject2	Object
    //   107	414	5	localBufferedOutputStream	java.io.BufferedOutputStream
    //   89	27	6	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   133	138	184	java/io/IOException
    //   144	148	192	java/io/IOException
    //   29	43	202	java/io/IOException
    //   43	81	202	java/io/IOException
    //   251	256	269	java/io/IOException
    //   260	264	277	java/io/IOException
    //   29	43	287	java/lang/OutOfMemoryError
    //   43	81	287	java/lang/OutOfMemoryError
    //   345	350	363	java/io/IOException
    //   354	358	371	java/io/IOException
    //   29	43	381	java/lang/Exception
    //   43	81	381	java/lang/Exception
    //   408	413	426	java/io/IOException
    //   417	421	434	java/io/IOException
    //   29	43	444	finally
    //   43	81	444	finally
    //   453	457	467	java/io/IOException
    //   461	465	475	java/io/IOException
    //   81	109	483	finally
    //   115	128	489	finally
    //   214	218	489	finally
    //   224	230	489	finally
    //   236	246	489	finally
    //   299	305	489	finally
    //   311	340	489	finally
    //   393	403	489	finally
    //   81	109	496	java/lang/Exception
    //   115	128	503	java/lang/Exception
    //   81	109	507	java/lang/OutOfMemoryError
    //   115	128	514	java/lang/OutOfMemoryError
    //   81	109	518	java/io/IOException
    //   115	128	525	java/io/IOException
  }
  
  public String getCfgPath()
  {
    String str2 = this.mMapConfigDir;
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (!str2.endsWith("/")) {
        str1 = str2 + "/";
      }
    }
    return str1;
  }
  
  public String getConfigCommonImgPath(String paramString)
  {
    String str = this.mCommonDir + File.separator + paramString;
    if (QLog.isColorLevel()) {
      QLog.d("MapEngineCallback", 2, "getConfigCommonImgPath ,imgName = " + paramString + ",result = " + str);
    }
    return str;
  }
  
  public String getDataPath()
  {
    String str = ARResUtil.b + "/map/";
    try
    {
      File localFile = new File(str);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return str;
  }
  
  public float getDensity()
  {
    return this.mDensity;
  }
  
  public float getDisplayAspectRatio()
  {
    float f2 = 0.5F;
    DisplayMetrics localDisplayMetrics = this.mActivity.getResources().getDisplayMetrics();
    float f1 = f2;
    if (localDisplayMetrics.heightPixels != 0)
    {
      f1 = f2;
      if (localDisplayMetrics.widthPixels != 0)
      {
        float f3 = localDisplayMetrics.widthPixels;
        float f4 = localDisplayMetrics.heightPixels;
        f2 = f3 / f4;
        f1 = f2;
        if (MapLog.isLoggable(1))
        {
          MapLog.d("MapEngineCallback", "getDisplayAspectRatio [%f, %f, %f]", new Object[] { Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f2) });
          f1 = f2;
        }
      }
    }
    return f1;
  }
  
  public int getPOIReportMaxValue(String paramString)
  {
    int i = this.mActivity.a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("MapEngineCallback", 2, String.format(Locale.getDefault(), "getPOIReportMaxValue [%s, %d]", new Object[] { paramString, Integer.valueOf(i) }));
    }
    return i;
  }
  
  public String getSatPath()
  {
    String str = ARResUtil.b + "/Sat/";
    try
    {
      File localFile = new File(str);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return str;
  }
  
  public float getTextScale()
  {
    return this.mTextScale;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    int i;
    do
    {
      return false;
      i = paramMessage.arg1;
      paramMessage = (String)paramMessage.obj;
      writeMapDownloadData(paramMessage, null, 0);
    } while (!MapLog.isLoggable(2));
    MapLog.i("MapEngineCallback", 2, "handleMessage MAPDOWNLOAD_TIMEOUT," + i + "," + paramMessage, new Object[0]);
    return false;
  }
  
  public void initMapEngine(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt1, int paramInt2)
  {
    this.mMapConfigDir = paramString1;
    this.mMapDaySkinDir = paramString2;
    this.mMapNightSkinDir = paramString3;
    this.mSkySkinDir = paramString4;
    this.mTreeDir = paramString5;
    this.mCommonDir = paramString6;
    this.mMapDayStyle = paramInt1;
    this.mMapNightStyle = paramInt2;
    this.mOpenBoxDir = paramString7;
    this.preloadMapFiles = ARResUtil.a();
    paramString1 = ArMapUtil.b(this.mApp);
    if (!paramString1.getBoolean("armap_preload_offline", false))
    {
      setMapEngineParam(getDensity(), getTextScale(), getDataPath(), getCfgPath(), getSatPath(), this, this.mSkySkinDir, paramString6, paramInt1, paramInt2, this.preloadMapFiles);
      if (QLog.isColorLevel()) {
        QLog.d("MapEngineCallback", 2, "first enter map");
      }
      paramString1.edit().putBoolean("armap_preload_offline", true).commit();
      ArMapUtil.a(this.preloadMapFiles);
      return;
    }
    setMapEngineParam(getDensity(), getTextScale(), getDataPath(), getCfgPath(), getSatPath(), this, this.mSkySkinDir, paramString6, paramInt1, paramInt2, null);
  }
  
  public void initMapEngineByOldData()
  {
    setMapEngineParam(getDensity(), getTextScale(), getDataPath(), getCfgPath(), getSatPath(), this, this.mSkySkinDir, this.mCommonDir, this.mMapDayStyle, this.mMapNightStyle, this.preloadMapFiles);
    this.mActivity.p();
  }
  
  public void initTextPaint(int paramInt)
  {
    if (this.mTextPaint == null)
    {
      this.mTextPaint = new Paint();
      this.mTextPaint.setTypeface(Typeface.DEFAULT);
      this.mTextPaint.setAntiAlias(true);
      this.mTextPaint.setStyle(Paint.Style.FILL);
      this.mTextPaint.setTextAlign(Paint.Align.CENTER);
      this.mTextPaint.setLinearText(true);
    }
    this.mTextPaint.setTextSize(paramInt);
  }
  
  public Bitmap loadImg(String paramString)
  {
    if (new File(this.mMapDaySkinDir + paramString).exists()) {}
    for (paramString = this.mMapDaySkinDir + paramString;; paramString = this.mMapNightSkinDir + paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MapEngineCallback", 2, "callback loadImage:" + paramString);
      }
      try
      {
        localFileInputStream = new FileInputStream(paramString);
        paramString = BitmapFactory.decodeStream(localFileInputStream);
      }
      catch (IOException localIOException1)
      {
        FileInputStream localFileInputStream;
        paramString = null;
        localIOException1.printStackTrace();
        return paramString;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        do
        {
          paramString = null;
          String str = paramString;
        } while (!QLog.isColorLevel());
        QLog.d("MapEngineCallback", 2, "loadImg oom:" + localOutOfMemoryError1.getMessage());
        return paramString;
      }
      try
      {
        localFileInputStream.close();
        str = paramString;
        return str;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        break label183;
      }
      catch (IOException localIOException2)
      {
        break label174;
      }
      if (!new File(this.mMapNightSkinDir + paramString).exists()) {
        break;
      }
    }
    return null;
  }
  
  public void loadPOILogoRes(String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MapEngineCallback", 2, "loadPOILogoRes:" + paramString + " callbackHandler:" + paramLong);
    }
    this.mActivity.b(paramString, paramLong);
  }
  
  public void loadPOIModelConfig(String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MapEngineCallback", 2, "loadPOIModelConfig:" + paramString + " handler:" + paramLong);
    }
    this.mActivity.a(paramString, paramLong);
  }
  
  /* Error */
  public void onClickPOINode(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, int paramInt4, double paramDouble1, double paramDouble2, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: iconst_2
    //   1: invokestatic 355	com/tencent/mobileqq/armap/utils/MapLog:isLoggable	(I)Z
    //   4: ifeq +122 -> 126
    //   7: ldc 41
    //   9: iconst_2
    //   10: new 244	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 813
    //   20: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_1
    //   24: invokevirtual 684	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: ldc_w 815
    //   30: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: iload_2
    //   34: invokevirtual 684	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   37: ldc_w 817
    //   40: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: lload 4
    //   45: invokevirtual 798	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   48: ldc_w 819
    //   51: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: lload 6
    //   56: invokestatic 823	com/tencent/mobileqq/armap/utils/MapLog:toUnsignedLongValue	(J)Ljava/math/BigInteger;
    //   59: invokevirtual 826	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   62: ldc_w 828
    //   65: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: iload 8
    //   70: invokevirtual 684	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   73: ldc_w 830
    //   76: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: iload_3
    //   80: invokevirtual 684	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   83: ldc_w 832
    //   86: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 13
    //   91: invokevirtual 826	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   94: ldc_w 834
    //   97: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: dload 9
    //   102: invokevirtual 837	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   105: ldc_w 839
    //   108: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: dload 11
    //   113: invokevirtual 837	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   116: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: iconst_0
    //   120: anewarray 4	java/lang/Object
    //   123: invokestatic 367	com/tencent/mobileqq/armap/utils/MapLog:i	(Ljava/lang/String;ILjava/lang/String;[Ljava/lang/Object;)V
    //   126: aload 13
    //   128: instanceof 238
    //   131: ifeq +262 -> 393
    //   134: aload 13
    //   136: checkcast 238	java/lang/String
    //   139: astore 22
    //   141: aload 14
    //   143: instanceof 238
    //   146: ifeq +254 -> 400
    //   149: aload 14
    //   151: checkcast 238	java/lang/String
    //   154: astore 13
    //   156: aconst_null
    //   157: astore 14
    //   159: aconst_null
    //   160: astore 17
    //   162: aconst_null
    //   163: astore 25
    //   165: aconst_null
    //   166: astore 23
    //   168: aconst_null
    //   169: astore 24
    //   171: new 841	org/json/JSONObject
    //   174: dup
    //   175: aload 13
    //   177: invokespecial 842	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   180: astore 18
    //   182: aload 18
    //   184: ifnull +627 -> 811
    //   187: aconst_null
    //   188: astore 16
    //   190: aload 18
    //   192: ldc_w 844
    //   195: invokevirtual 847	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   198: ifeq +222 -> 420
    //   201: aload 18
    //   203: ldc_w 844
    //   206: invokevirtual 850	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   209: astore 13
    //   211: goto +615 -> 826
    //   214: aload 16
    //   216: ifnonnull +262 -> 478
    //   219: aload 24
    //   221: astore 17
    //   223: aload 23
    //   225: astore 19
    //   227: aload 25
    //   229: astore 21
    //   231: aload 14
    //   233: astore 20
    //   235: invokestatic 269	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   238: ifeq +28 -> 266
    //   241: ldc 41
    //   243: iconst_2
    //   244: ldc_w 852
    //   247: invokestatic 397	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   250: aload 14
    //   252: astore 20
    //   254: aload 25
    //   256: astore 21
    //   258: aload 23
    //   260: astore 19
    //   262: aload 24
    //   264: astore 17
    //   266: aload 20
    //   268: astore 16
    //   270: aload 19
    //   272: astore 13
    //   274: aload 17
    //   276: astore 14
    //   278: aload 21
    //   280: astore 17
    //   282: aload 18
    //   284: ifnull +411 -> 695
    //   287: aload 18
    //   289: ldc_w 854
    //   292: invokevirtual 847	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   295: ifeq +510 -> 805
    //   298: aload 18
    //   300: ldc_w 854
    //   303: invokevirtual 857	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   306: istore 15
    //   308: aconst_null
    //   309: astore 18
    //   311: iload_3
    //   312: bipush 10
    //   314: if_icmpne +21 -> 335
    //   317: iconst_2
    //   318: anewarray 4	java/lang/Object
    //   321: astore 18
    //   323: aload 18
    //   325: iconst_0
    //   326: aload 13
    //   328: aastore
    //   329: aload 18
    //   331: iconst_1
    //   332: aload 14
    //   334: aastore
    //   335: aload_0
    //   336: getfield 130	com/tencent/mobileqq/armap/map/MapEngineCallback:mActivity	Lcom/tencent/mobileqq/armap/ARMapActivity;
    //   339: ifnull +33 -> 372
    //   342: aload_0
    //   343: getfield 130	com/tencent/mobileqq/armap/map/MapEngineCallback:mActivity	Lcom/tencent/mobileqq/armap/ARMapActivity;
    //   346: iload_1
    //   347: iload_2
    //   348: iload_3
    //   349: lload 4
    //   351: iload 15
    //   353: lload 6
    //   355: iload 8
    //   357: aload 22
    //   359: aload 16
    //   361: dload 9
    //   363: dload 11
    //   365: aload 17
    //   367: aload 18
    //   369: invokevirtual 860	com/tencent/mobileqq/armap/ARMapActivity:a	(IIIJIJILjava/lang/String;Ljava/lang/String;DDLjava/lang/String;Ljava/lang/Object;)V
    //   372: new 862	com/tencent/mobileqq/armap/map/MapEngineCallback$7
    //   375: dup
    //   376: aload_0
    //   377: iload 8
    //   379: lload 4
    //   381: lload 6
    //   383: invokespecial 865	com/tencent/mobileqq/armap/map/MapEngineCallback$7:<init>	(Lcom/tencent/mobileqq/armap/map/MapEngineCallback;IJJ)V
    //   386: iconst_5
    //   387: aconst_null
    //   388: iconst_0
    //   389: invokestatic 406	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   392: return
    //   393: ldc 114
    //   395: astore 22
    //   397: goto -256 -> 141
    //   400: ldc 114
    //   402: astore 13
    //   404: goto -248 -> 156
    //   407: astore 13
    //   409: aload 13
    //   411: invokevirtual 866	org/json/JSONException:printStackTrace	()V
    //   414: aconst_null
    //   415: astore 18
    //   417: goto -235 -> 182
    //   420: aconst_null
    //   421: astore 13
    //   423: goto +403 -> 826
    //   426: aload 13
    //   428: invokestatic 232	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   431: ifne -217 -> 214
    //   434: new 841	org/json/JSONObject
    //   437: dup
    //   438: aload 13
    //   440: invokespecial 842	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   443: astore 16
    //   445: goto -231 -> 214
    //   448: astore 17
    //   450: aconst_null
    //   451: astore 16
    //   453: aconst_null
    //   454: astore 14
    //   456: aconst_null
    //   457: astore 13
    //   459: aload 17
    //   461: invokevirtual 866	org/json/JSONException:printStackTrace	()V
    //   464: aconst_null
    //   465: astore 19
    //   467: aload 14
    //   469: astore 17
    //   471: aload 19
    //   473: astore 14
    //   475: goto -193 -> 282
    //   478: aload 17
    //   480: astore 13
    //   482: aload 16
    //   484: ldc_w 868
    //   487: invokevirtual 847	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   490: ifeq +13 -> 503
    //   493: aload 16
    //   495: ldc_w 868
    //   498: invokevirtual 871	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   501: astore 13
    //   503: aload 16
    //   505: ldc_w 873
    //   508: invokevirtual 877	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   511: ldc_w 879
    //   514: invokevirtual 871	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   517: astore 14
    //   519: aload 24
    //   521: astore 17
    //   523: aload 23
    //   525: astore 19
    //   527: aload 13
    //   529: astore 21
    //   531: aload 14
    //   533: astore 20
    //   535: aload 16
    //   537: ldc_w 881
    //   540: invokevirtual 847	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   543: ifeq -277 -> 266
    //   546: aload 16
    //   548: ldc_w 881
    //   551: invokevirtual 877	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   554: astore 25
    //   556: aload 24
    //   558: astore 17
    //   560: aload 23
    //   562: astore 19
    //   564: aload 13
    //   566: astore 21
    //   568: aload 14
    //   570: astore 20
    //   572: aload 25
    //   574: ifnull -308 -> 266
    //   577: aload 25
    //   579: ldc_w 883
    //   582: invokevirtual 847	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   585: ifeq +49 -> 634
    //   588: aload 25
    //   590: ldc_w 883
    //   593: invokevirtual 871	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   596: astore 16
    //   598: aload 25
    //   600: ldc_w 885
    //   603: invokevirtual 847	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   606: ifeq +34 -> 640
    //   609: aload 25
    //   611: ldc_w 885
    //   614: invokevirtual 871	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   617: astore 17
    //   619: aload 16
    //   621: astore 19
    //   623: aload 13
    //   625: astore 21
    //   627: aload 14
    //   629: astore 20
    //   631: goto -365 -> 266
    //   634: aconst_null
    //   635: astore 16
    //   637: goto -39 -> 598
    //   640: aconst_null
    //   641: astore 17
    //   643: aload 16
    //   645: astore 19
    //   647: aload 13
    //   649: astore 21
    //   651: aload 14
    //   653: astore 20
    //   655: goto -389 -> 266
    //   658: astore 17
    //   660: aconst_null
    //   661: astore 16
    //   663: aconst_null
    //   664: astore 14
    //   666: aconst_null
    //   667: astore 13
    //   669: aload 17
    //   671: invokevirtual 281	java/lang/Exception:printStackTrace	()V
    //   674: aconst_null
    //   675: astore 19
    //   677: aload 14
    //   679: astore 17
    //   681: aload 19
    //   683: astore 14
    //   685: goto -403 -> 282
    //   688: astore 18
    //   690: aload 18
    //   692: invokevirtual 866	org/json/JSONException:printStackTrace	()V
    //   695: iconst_m1
    //   696: istore 15
    //   698: goto -390 -> 308
    //   701: astore 17
    //   703: aconst_null
    //   704: astore 16
    //   706: aload 13
    //   708: astore 14
    //   710: aconst_null
    //   711: astore 13
    //   713: goto -44 -> 669
    //   716: astore 17
    //   718: aload 14
    //   720: astore 16
    //   722: aload 13
    //   724: astore 14
    //   726: aconst_null
    //   727: astore 13
    //   729: goto -60 -> 669
    //   732: astore 17
    //   734: aload 14
    //   736: astore 19
    //   738: aload 13
    //   740: astore 14
    //   742: aload 16
    //   744: astore 13
    //   746: aload 19
    //   748: astore 16
    //   750: goto -81 -> 669
    //   753: astore 17
    //   755: aconst_null
    //   756: astore 16
    //   758: aload 13
    //   760: astore 14
    //   762: aconst_null
    //   763: astore 13
    //   765: goto -306 -> 459
    //   768: astore 17
    //   770: aload 14
    //   772: astore 16
    //   774: aload 13
    //   776: astore 14
    //   778: aconst_null
    //   779: astore 13
    //   781: goto -322 -> 459
    //   784: astore 17
    //   786: aload 14
    //   788: astore 19
    //   790: aload 13
    //   792: astore 14
    //   794: aload 16
    //   796: astore 13
    //   798: aload 19
    //   800: astore 16
    //   802: goto -343 -> 459
    //   805: iconst_m1
    //   806: istore 15
    //   808: goto -500 -> 308
    //   811: aconst_null
    //   812: astore 17
    //   814: aconst_null
    //   815: astore 16
    //   817: aconst_null
    //   818: astore 13
    //   820: aconst_null
    //   821: astore 14
    //   823: goto -541 -> 282
    //   826: aload 13
    //   828: ifnonnull -402 -> 426
    //   831: aload 18
    //   833: astore 16
    //   835: goto -621 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	838	0	this	MapEngineCallback
    //   0	838	1	paramInt1	int
    //   0	838	2	paramInt2	int
    //   0	838	3	paramInt3	int
    //   0	838	4	paramLong1	long
    //   0	838	6	paramLong2	long
    //   0	838	8	paramInt4	int
    //   0	838	9	paramDouble1	double
    //   0	838	11	paramDouble2	double
    //   0	838	13	paramObject1	Object
    //   0	838	14	paramObject2	Object
    //   306	501	15	i	int
    //   188	646	16	localObject1	Object
    //   160	206	17	localObject2	Object
    //   448	12	17	localJSONException1	org.json.JSONException
    //   469	173	17	localObject3	Object
    //   658	12	17	localException1	Exception
    //   679	1	17	localObject4	Object
    //   701	1	17	localException2	Exception
    //   716	1	17	localException3	Exception
    //   732	1	17	localException4	Exception
    //   753	1	17	localJSONException2	org.json.JSONException
    //   768	1	17	localJSONException3	org.json.JSONException
    //   784	1	17	localJSONException4	org.json.JSONException
    //   812	1	17	localObject5	Object
    //   180	236	18	localObject6	Object
    //   688	144	18	localJSONException5	org.json.JSONException
    //   225	574	19	localObject7	Object
    //   233	421	20	localObject8	Object
    //   229	421	21	localObject9	Object
    //   139	257	22	str	String
    //   166	395	23	localObject10	Object
    //   169	388	24	localObject11	Object
    //   163	447	25	localJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   171	182	407	org/json/JSONException
    //   190	211	448	org/json/JSONException
    //   235	250	448	org/json/JSONException
    //   426	445	448	org/json/JSONException
    //   482	503	448	org/json/JSONException
    //   190	211	658	java/lang/Exception
    //   235	250	658	java/lang/Exception
    //   426	445	658	java/lang/Exception
    //   482	503	658	java/lang/Exception
    //   287	308	688	org/json/JSONException
    //   503	519	701	java/lang/Exception
    //   535	556	716	java/lang/Exception
    //   577	598	716	java/lang/Exception
    //   598	619	732	java/lang/Exception
    //   503	519	753	org/json/JSONException
    //   535	556	768	org/json/JSONException
    //   577	598	768	org/json/JSONException
    //   598	619	784	org/json/JSONException
  }
  
  public void onDestory()
  {
    this.mTextBitmapBuffer = null;
    this.mTextSizeBuffer = null;
    this.mTextBitmapInfo = null;
    this.mApp.a.b(this.mFaceObser);
    this.mApp.removeObserver(this.mArmapObserver);
    this.mSubHandler.removeMessages(1);
  }
  
  /* Error */
  public void onDownLoadFinish(String paramString1, boolean paramBoolean, String paramString2, com.tencent.mobileqq.transfile.NetResp paramNetResp)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifeq +524 -> 525
    //   4: new 553	java/io/FileInputStream
    //   7: dup
    //   8: aload_3
    //   9: invokespecial 556	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: astore_3
    //   13: new 551	java/io/BufferedInputStream
    //   16: dup
    //   17: aload_3
    //   18: invokespecial 559	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   21: astore 10
    //   23: aload 10
    //   25: invokestatic 901	com/tencent/mobileqq/armap/utils/BufferedByteStream:a	(Ljava/io/BufferedInputStream;)[B
    //   28: astore 11
    //   30: aload 10
    //   32: invokevirtual 902	java/io/BufferedInputStream:close	()V
    //   35: aload_3
    //   36: invokevirtual 787	java/io/FileInputStream:close	()V
    //   39: aload 11
    //   41: astore_3
    //   42: iload_2
    //   43: ifeq +117 -> 160
    //   46: aload_3
    //   47: ifnonnull +106 -> 153
    //   50: iconst_0
    //   51: istore 5
    //   53: aload_1
    //   54: aload_3
    //   55: iload 5
    //   57: invokestatic 679	com/tencent/mobileqq/armap/map/MapEngineCallback:writeMapDownloadData	(Ljava/lang/String;[BI)V
    //   60: return
    //   61: astore_3
    //   62: aload 11
    //   64: astore_3
    //   65: goto -23 -> 42
    //   68: astore 11
    //   70: aconst_null
    //   71: astore 10
    //   73: aconst_null
    //   74: astore_3
    //   75: iconst_2
    //   76: invokestatic 355	com/tencent/mobileqq/armap/utils/MapLog:isLoggable	(I)Z
    //   79: ifeq +37 -> 116
    //   82: ldc 41
    //   84: iconst_2
    //   85: new 244	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   92: ldc_w 904
    //   95: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload 11
    //   100: invokevirtual 905	java/io/IOException:getMessage	()Ljava/lang/String;
    //   103: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: iconst_0
    //   110: anewarray 4	java/lang/Object
    //   113: invokestatic 367	com/tencent/mobileqq/armap/utils/MapLog:i	(Ljava/lang/String;ILjava/lang/String;[Ljava/lang/Object;)V
    //   116: aload_3
    //   117: invokevirtual 902	java/io/BufferedInputStream:close	()V
    //   120: aload 10
    //   122: invokevirtual 787	java/io/FileInputStream:close	()V
    //   125: aconst_null
    //   126: astore_3
    //   127: goto -85 -> 42
    //   130: astore_3
    //   131: aconst_null
    //   132: astore_3
    //   133: goto -91 -> 42
    //   136: astore_1
    //   137: aconst_null
    //   138: astore 10
    //   140: aconst_null
    //   141: astore_3
    //   142: aload_3
    //   143: invokevirtual 902	java/io/BufferedInputStream:close	()V
    //   146: aload 10
    //   148: invokevirtual 787	java/io/FileInputStream:close	()V
    //   151: aload_1
    //   152: athrow
    //   153: aload_3
    //   154: arraylength
    //   155: istore 5
    //   157: goto -104 -> 53
    //   160: aload_0
    //   161: getfield 177	com/tencent/mobileqq/armap/map/MapEngineCallback:mApp	Lcom/tencent/mobileqq/armap/ArMapInterface;
    //   164: sipush 209
    //   167: invokevirtual 485	com/tencent/mobileqq/armap/ArMapInterface:getManager	(I)Lmqq/manager/Manager;
    //   170: checkcast 496	com/tencent/mobileqq/armap/ARMapManager
    //   173: astore_3
    //   174: aload_3
    //   175: ifnull +345 -> 520
    //   178: aload_3
    //   179: iconst_1
    //   180: invokevirtual 908	com/tencent/mobileqq/armap/ARMapManager:a	(Z)Lcom/tencent/mobileqq/armap/config/ARMapConfig;
    //   183: astore_3
    //   184: aload_3
    //   185: ifnull +255 -> 440
    //   188: aload_3
    //   189: getfield 913	com/tencent/mobileqq/armap/config/ARMapConfig:mapDownloadTimeoutFor503	I
    //   192: i2l
    //   193: lstore 6
    //   195: aload_3
    //   196: ifnull +252 -> 448
    //   199: aload_3
    //   200: getfield 916	com/tencent/mobileqq/armap/config/ARMapConfig:mapDownloadTimeout	I
    //   203: i2l
    //   204: lstore 8
    //   206: aload 4
    //   208: getfield 920	com/tencent/mobileqq/transfile/NetResp:c	I
    //   211: sipush 503
    //   214: if_icmpne +7 -> 221
    //   217: lload 6
    //   219: lstore 8
    //   221: lload 8
    //   223: lconst_0
    //   224: lcmp
    //   225: iflt +34 -> 259
    //   228: aload_0
    //   229: getfield 212	com/tencent/mobileqq/armap/map/MapEngineCallback:mSubHandler	Landroid/os/Handler;
    //   232: iconst_1
    //   233: aload 4
    //   235: getfield 920	com/tencent/mobileqq/transfile/NetResp:c	I
    //   238: iconst_0
    //   239: aload_1
    //   240: invokevirtual 924	android/os/Handler:obtainMessage	(IIILjava/lang/Object;)Landroid/os/Message;
    //   243: astore_3
    //   244: aload_0
    //   245: getfield 212	com/tencent/mobileqq/armap/map/MapEngineCallback:mSubHandler	Landroid/os/Handler;
    //   248: aload_3
    //   249: ldc2_w 475
    //   252: lload 8
    //   254: lmul
    //   255: invokevirtual 928	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   258: pop
    //   259: iconst_2
    //   260: invokestatic 355	com/tencent/mobileqq/armap/utils/MapLog:isLoggable	(I)Z
    //   263: ifeq +82 -> 345
    //   266: ldc 41
    //   268: iconst_2
    //   269: new 244	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   276: ldc_w 930
    //   279: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: iload_2
    //   283: invokevirtual 933	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   286: ldc_w 686
    //   289: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload 4
    //   294: getfield 935	com/tencent/mobileqq/transfile/NetResp:b	I
    //   297: invokevirtual 684	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   300: ldc_w 686
    //   303: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload 4
    //   308: getfield 920	com/tencent/mobileqq/transfile/NetResp:c	I
    //   311: invokevirtual 684	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   314: ldc_w 686
    //   317: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: lload 8
    //   322: invokevirtual 798	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   325: ldc_w 686
    //   328: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: aload_1
    //   332: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: iconst_0
    //   339: anewarray 4	java/lang/Object
    //   342: invokestatic 367	com/tencent/mobileqq/armap/utils/MapLog:i	(Ljava/lang/String;ILjava/lang/String;[Ljava/lang/Object;)V
    //   345: new 937	java/util/HashMap
    //   348: dup
    //   349: invokespecial 938	java/util/HashMap:<init>	()V
    //   352: astore_1
    //   353: aload_1
    //   354: ldc_w 940
    //   357: aload 4
    //   359: getfield 935	com/tencent/mobileqq/transfile/NetResp:b	I
    //   362: invokestatic 943	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   365: invokevirtual 947	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   368: pop
    //   369: aload_1
    //   370: ldc_w 949
    //   373: aload 4
    //   375: getfield 950	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_Int	I
    //   378: invokestatic 943	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   381: invokevirtual 947	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   384: pop
    //   385: aload_1
    //   386: ldc_w 952
    //   389: aload 4
    //   391: getfield 920	com/tencent/mobileqq/transfile/NetResp:c	I
    //   394: invokestatic 943	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   397: invokevirtual 947	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   400: pop
    //   401: aload_1
    //   402: ldc_w 954
    //   405: aload 4
    //   407: getfield 956	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   410: invokevirtual 947	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   413: pop
    //   414: invokestatic 962	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   417: invokestatic 967	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   420: aload_0
    //   421: getfield 177	com/tencent/mobileqq/armap/map/MapEngineCallback:mApp	Lcom/tencent/mobileqq/armap/ArMapInterface;
    //   424: invokevirtual 192	com/tencent/mobileqq/armap/ArMapInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   427: ldc_w 969
    //   430: iconst_0
    //   431: lconst_0
    //   432: lconst_0
    //   433: aload_1
    //   434: ldc 114
    //   436: invokevirtual 972	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   439: return
    //   440: ldc2_w 973
    //   443: lstore 6
    //   445: goto -250 -> 195
    //   448: ldc2_w 975
    //   451: lstore 8
    //   453: goto -247 -> 206
    //   456: astore_3
    //   457: goto -306 -> 151
    //   460: astore_1
    //   461: aconst_null
    //   462: astore 4
    //   464: aload_3
    //   465: astore 10
    //   467: aload 4
    //   469: astore_3
    //   470: goto -328 -> 142
    //   473: astore_1
    //   474: aload_3
    //   475: astore 4
    //   477: aload 10
    //   479: astore_3
    //   480: aload 4
    //   482: astore 10
    //   484: goto -342 -> 142
    //   487: astore_1
    //   488: goto -346 -> 142
    //   491: astore 11
    //   493: aconst_null
    //   494: astore 12
    //   496: aload_3
    //   497: astore 10
    //   499: aload 12
    //   501: astore_3
    //   502: goto -427 -> 75
    //   505: astore 11
    //   507: aload_3
    //   508: astore 12
    //   510: aload 10
    //   512: astore_3
    //   513: aload 12
    //   515: astore 10
    //   517: goto -442 -> 75
    //   520: aconst_null
    //   521: astore_3
    //   522: goto -338 -> 184
    //   525: aconst_null
    //   526: astore_3
    //   527: goto -485 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	530	0	this	MapEngineCallback
    //   0	530	1	paramString1	String
    //   0	530	2	paramBoolean	boolean
    //   0	530	3	paramString2	String
    //   0	530	4	paramNetResp	com.tencent.mobileqq.transfile.NetResp
    //   51	105	5	i	int
    //   193	251	6	l1	long
    //   204	248	8	l2	long
    //   21	495	10	localObject	Object
    //   28	35	11	arrayOfByte	byte[]
    //   68	31	11	localIOException1	IOException
    //   491	1	11	localIOException2	IOException
    //   505	1	11	localIOException3	IOException
    //   494	20	12	str	String
    // Exception table:
    //   from	to	target	type
    //   30	39	61	java/lang/Exception
    //   4	13	68	java/io/IOException
    //   116	125	130	java/lang/Exception
    //   4	13	136	finally
    //   142	151	456	java/lang/Exception
    //   13	23	460	finally
    //   23	30	473	finally
    //   75	116	487	finally
    //   13	23	491	java/io/IOException
    //   23	30	505	java/io/IOException
  }
  
  public void onFullScreenAnimEnd()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MapEngineCallback", 2, "onFullScreenAnimEnd.");
    }
  }
  
  public void onMapLoadFinished()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MapEngineCallback", 2, "onMapLoadFinished");
    }
    if (this.mActivity != null) {
      this.mActivity.i();
    }
  }
  
  public void onPOIReport(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MapEngineCallback", 2, String.format(Locale.getDefault(), "onPOIReport [%s, %s]", new Object[] { paramString1, paramString2 }));
    }
    if ((paramString1 != null) && (paramString1.length() > 0) && (paramString2 != null) && (paramString2.length() > 0)) {
      ThreadManager.post(new ARMapExposionReport(paramString1, paramString2, this.mActivity.e), 5, null, false);
    }
  }
  
  public void onRotationAngleChanged(float paramFloat)
  {
    this.mUIHandler.obtainMessage(3, Float.valueOf(-1.0F * paramFloat)).sendToTarget();
  }
  
  public void onSwitchRotateMode(int paramInt)
  {
    if (this.mActivity != null) {
      this.mActivity.b(paramInt);
    }
    if (MapLog.isLoggable(2)) {
      MapLog.i("MapEngineCallback", 2, "switchRotateMode:" + paramInt, new Object[0]);
    }
  }
  
  public void openLbsPackErrReport(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MapEngineCallback", 2, "openLbsPackErrReport, errCount" + paramInt + ", pid:" + paramString);
    }
    String str = "";
    if (paramInt == 1) {
      str = "0X8007A52";
    }
    for (;;)
    {
      ReportController.b(null, "dc01440", "", "", str, str, 0, 0, "", "", "", paramString);
      return;
      if (paramInt == 2) {
        str = "0X8007A53";
      }
    }
  }
  
  public void showGameTipView(float paramFloat1, float paramFloat2) {}
  
  public void showPOIGuide(boolean paramBoolean, float paramFloat, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MapEngineCallback", 2, "showPOIGuide radian = " + paramFloat + ",show =" + paramBoolean + ",dir = " + paramString + ",taskType = " + paramInt);
    }
    if (this.mActivity.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.mActivity.a(paramBoolean, paramFloat, paramString, paramInt);
    }
  }
  
  public native void updateNativeHeadIcon(String paramString, long paramLong);
  
  public void updatePOIResultTestInfo(int paramInt1, long paramLong, int paramInt2)
  {
    if ((this.mActivity != null) && (this.mActivity.h))
    {
      Object localObject = new StringBuilder(200);
      ((StringBuilder)localObject).append("poiresult: poiCount =").append(paramInt1).append(",farthestPOIId = ").append(MapLog.toUnsignedLongValue(paramLong)).append(",farthestDistance = ").append(paramInt2);
      localObject = ((StringBuilder)localObject).toString();
      if (MapLog.isLoggable(1)) {
        MapLog.d("MapEngineCallback", "updatePOIResultTestInfo  " + (String)localObject, new Object[0]);
      }
      this.mActivity.runOnUiThread(new MapEngineCallback.6(this, (String)localObject));
    }
  }
  
  public void writeFile(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    ThreadManager.postImmediately(new MapEngineCallback.5(this, paramString, paramArrayOfByte), null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.map.MapEngineCallback
 * JD-Core Version:    0.7.0.1
 */