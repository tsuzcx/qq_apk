package com.tencent.biz.qqstory.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.TouchDelegate;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.CircleTransformation;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.RoundedTransformation;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.Transformation;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.URLImageLoader;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.URLImageLoader.Config;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.InfoPrinter;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StringAppendTool;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.maxvideo.trim.TrimNative;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

@TargetApi(14)
public class UIUtils
{
  public static int a = -1;
  public static int b = -1;
  public static int c = -1;
  public static int d = -1;
  public static HashMap<String, Bitmap> e = new HashMap();
  public static HashMap<String, int[]> f = new HashMap();
  public static Drawable g;
  public static Drawable h;
  public static Drawable i;
  public static final DownloadParams.DecodeHandler j = new UIUtils.1();
  private static URLImageLoader k;
  private static Long l = Long.valueOf(0L);
  
  public static float a(Context paramContext)
  {
    if (paramContext == null) {
      return 0.0F;
    }
    return paramContext.getResources().getDisplayMetrics().density;
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * a(paramContext) + 0.5F);
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i1 = paramOptions.outHeight;
    int i2 = paramOptions.outWidth;
    int n = 1;
    int m = 1;
    if ((i1 > paramInt2) || (i2 > paramInt1))
    {
      i1 /= 2;
      i2 /= 2;
      for (;;)
      {
        n = m;
        if (i1 / m <= paramInt2) {
          break;
        }
        n = m;
        if (i2 / m <= paramInt1) {
          break;
        }
        m *= 2;
      }
    }
    return n;
  }
  
  public static Bitmap a(Resources paramResources, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramResources == null) {
      return null;
    }
    if (paramInt1 <= 0) {
      return null;
    }
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      int m = 1;
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
      if ((paramInt2 <= 0) && (paramInt3 <= 0)) {
        paramInt2 = m;
      } else {
        paramInt2 = a(localOptions, paramInt2, paramInt3);
      }
      localOptions.inJustDecodeBounds = false;
      localOptions.inSampleSize = paramInt2;
      paramResources = BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
      return paramResources;
    }
    catch (OutOfMemoryError paramResources)
    {
      paramResources.printStackTrace();
      return null;
    }
    catch (Exception paramResources)
    {
      paramResources.printStackTrace();
    }
    return null;
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat)
  {
    if (paramBitmap == null)
    {
      paramBitmap = new StringBuilder();
      paramBitmap.append("rotateBitmap arg source is null! ");
      paramBitmap.append(FeedUtils.a(3));
      SLog.e("Q.qqstory.UIViewUtils", paramBitmap.toString());
      return null;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postRotate(paramFloat);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    Object localObject = new Matrix();
    ((Matrix)localObject).postScale(paramFloat1, paramFloat2);
    try
    {
      paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
      return paramBitmap;
    }
    catch (Exception paramBitmap)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("generateScaleBitmap error:");
      ((StringBuilder)localObject).append(paramBitmap);
      SLog.e("Q.qqstory.UIViewUtils", ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      float f1 = paramBitmap.getWidth();
      float f2 = paramBitmap.getHeight();
      float f3 = f2 / f1;
      float f4 = paramInt2 / paramInt1;
      int i1 = (int)f2;
      int i2 = (int)f1;
      int n;
      int m;
      if (f3 > f4)
      {
        i1 = (int)(f1 * f4);
        n = (int)((f2 - i1) / 2.0F);
        m = 0;
      }
      else
      {
        i2 = (int)(f2 / f4);
        m = (int)((f1 - i2) / 2.0F);
        n = 0;
      }
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      localBitmap.setDensity(BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().densityDpi);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      Rect localRect1 = new Rect(m, n, i2 + m, i1 + n);
      Rect localRect2 = new Rect(0, 0, paramInt1, paramInt2);
      RectF localRectF = new RectF(localRect2);
      localPaint.setAntiAlias(true);
      localPaint.setDither(true);
      localPaint.setFilterBitmap(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-12434878);
      localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
      return localBitmap;
    }
    catch (Throwable paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
    return null;
  }
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    return a(paramString, paramInt1, paramInt2, 0L);
  }
  
  /* Error */
  public static Bitmap a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 264	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +13 -> 17
    //   7: ldc 128
    //   9: ldc_w 266
    //   12: invokestatic 137	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: aconst_null
    //   16: areturn
    //   17: invokestatic 272	java/lang/System:currentTimeMillis	()J
    //   20: lstore 7
    //   22: new 274	android/media/MediaMetadataRetriever
    //   25: dup
    //   26: invokespecial 275	android/media/MediaMetadataRetriever:<init>	()V
    //   29: astore 10
    //   31: aload 10
    //   33: aload_0
    //   34: invokevirtual 279	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   37: aload 10
    //   39: lload_3
    //   40: invokevirtual 283	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   43: astore 9
    //   45: aload 9
    //   47: astore_0
    //   48: goto +96 -> 144
    //   51: ldc 128
    //   53: ldc_w 285
    //   56: invokestatic 137	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: goto +83 -> 142
    //   62: astore 9
    //   64: new 114	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   71: astore 11
    //   73: aload 11
    //   75: ldc_w 287
    //   78: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 11
    //   84: aload_0
    //   85: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 11
    //   91: ldc_w 289
    //   94: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload 11
    //   100: new 291	java/io/File
    //   103: dup
    //   104: aload_0
    //   105: invokespecial 293	java/io/File:<init>	(Ljava/lang/String;)V
    //   108: invokevirtual 297	java/io/File:exists	()Z
    //   111: invokevirtual 300	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload 11
    //   117: ldc_w 302
    //   120: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload 11
    //   126: aload 9
    //   128: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: ldc 128
    //   134: aload 11
    //   136: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 137	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: aconst_null
    //   143: astore_0
    //   144: aload_0
    //   145: ifnonnull +18 -> 163
    //   148: ldc 128
    //   150: ldc_w 304
    //   153: invokestatic 137	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: aload 10
    //   158: invokevirtual 307	android/media/MediaMetadataRetriever:release	()V
    //   161: aconst_null
    //   162: areturn
    //   163: iload_1
    //   164: i2f
    //   165: aload_0
    //   166: invokevirtual 150	android/graphics/Bitmap:getWidth	()I
    //   169: i2f
    //   170: fdiv
    //   171: fstore 5
    //   173: iload_2
    //   174: i2f
    //   175: aload_0
    //   176: invokevirtual 153	android/graphics/Bitmap:getHeight	()I
    //   179: i2f
    //   180: fdiv
    //   181: fstore 6
    //   183: new 139	android/graphics/Matrix
    //   186: dup
    //   187: invokespecial 140	android/graphics/Matrix:<init>	()V
    //   190: astore 9
    //   192: aload 9
    //   194: fload 5
    //   196: fload 6
    //   198: invokevirtual 162	android/graphics/Matrix:postScale	(FF)Z
    //   201: pop
    //   202: aload_0
    //   203: iconst_0
    //   204: iconst_0
    //   205: aload_0
    //   206: invokevirtual 150	android/graphics/Bitmap:getWidth	()I
    //   209: aload_0
    //   210: invokevirtual 153	android/graphics/Bitmap:getHeight	()I
    //   213: aload 9
    //   215: iconst_1
    //   216: invokestatic 157	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   219: astore 9
    //   221: aload_0
    //   222: invokevirtual 310	android/graphics/Bitmap:recycle	()V
    //   225: aload 10
    //   227: invokevirtual 307	android/media/MediaMetadataRetriever:release	()V
    //   230: ldc 128
    //   232: ldc_w 312
    //   235: invokestatic 272	java/lang/System:currentTimeMillis	()J
    //   238: lload 7
    //   240: lsub
    //   241: invokestatic 50	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   244: invokestatic 315	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   247: aload 9
    //   249: areturn
    //   250: astore_0
    //   251: goto -200 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	paramString	String
    //   0	254	1	paramInt1	int
    //   0	254	2	paramInt2	int
    //   0	254	3	paramLong	long
    //   171	24	5	f1	float
    //   181	16	6	f2	float
    //   20	219	7	l1	long
    //   43	3	9	localBitmap	Bitmap
    //   62	65	9	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   190	58	9	localObject	Object
    //   29	197	10	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   71	64	11	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   31	45	62	java/lang/IllegalArgumentException
    //   31	45	250	java/lang/OutOfMemoryError
  }
  
  public static Drawable a(Context paramContext, String paramString1, int paramInt1, int paramInt2, Drawable paramDrawable, String paramString2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = paramDrawable;
    if (paramDrawable == null) {
      localDrawable = paramContext.getResources().getDrawable(2130848221);
    }
    if (TextUtils.isEmpty(paramString1)) {
      return localDrawable;
    }
    try
    {
      paramContext = new URL(paramString1);
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localURLDrawableOptions.mFailedDrawable = localURLDrawableOptions.mLoadingDrawable;
      localURLDrawableOptions.mUseAutoScaleParams = false;
      localURLDrawableOptions.mRetryCount = 2;
      if (!TextUtils.isEmpty(paramString2)) {
        localURLDrawableOptions.mMemoryCacheKeySuffix = paramString2;
      }
      paramContext = URLDrawable.getDrawable(paramContext, localURLDrawableOptions);
      paramContext.setTag(URLDrawableDecodeHandler.a(paramInt1, paramInt2));
      paramContext.setDecodeHandler(URLDrawableDecodeHandler.b);
      if ((paramContext.getStatus() == 2) || (paramContext.getStatus() == 3))
      {
        InfoPrinter.c("Q.qqstory.UIViewUtils", new Object[] { "drawable restartDownload" });
        paramContext.restartDownload();
      }
      return paramContext;
    }
    catch (MalformedURLException paramContext)
    {
      paramContext.printStackTrace();
      InfoPrinter.a("Q.qqstory.UIViewUtils", new Object[] { paramContext.getMessage() });
    }
    return localDrawable;
  }
  
  public static UIUtils.StoryProgressUI a(Activity paramActivity, String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = HardCodeUtil.a(2131913116);
    }
    paramActivity = new QQProgressDialog(paramActivity);
    paramActivity.a(str);
    paramActivity.show();
    return new UIUtils.StoryProgressUI(paramActivity);
  }
  
  public static String a(int paramInt)
  {
    StringBuilder localStringBuilder = (StringBuilder)StringAppendTool.a.get();
    localStringBuilder.setLength(0);
    try
    {
      localObject = new RuntimeException("getStackTrace").getStackTrace();
      int m = 2;
      while ((m < localObject.length) && (m < paramInt))
      {
        localStringBuilder.append(localObject[m]);
        m += 1;
      }
      localObject = localStringBuilder.toString();
      localStringBuilder.setLength(0);
      return localObject;
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getStackTrace");
      ((StringBuilder)localObject).append(localException.toString());
      AssertUtils.fail(((StringBuilder)localObject).toString(), new Object[0]);
    }
    return "{can not get stack}";
  }
  
  public static String a(long paramLong)
  {
    double d1 = paramLong;
    if (d1 > 1000000000.0D) {
      return "10亿+";
    }
    Object localObject;
    String str;
    if (d1 > 100000000.0D)
    {
      localObject = new StringBuilder();
      d1 = paramLong / 10000000L;
      Double.isNaN(d1);
      ((StringBuilder)localObject).append(d1 / 10.0D);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131913114));
      str = ((StringBuilder)localObject).toString();
      localObject = str;
      if (str.endsWith(".0亿")) {
        return str.replace(".0", "");
      }
    }
    else if (paramLong > 10000L)
    {
      localObject = new StringBuilder();
      d1 = paramLong / 1000L;
      Double.isNaN(d1);
      ((StringBuilder)localObject).append(d1 / 10.0D);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131913115));
      str = ((StringBuilder)localObject).toString();
      localObject = str;
      if (str.endsWith(".0万")) {
        return str.replace(".0", "");
      }
    }
    else
    {
      localObject = String.valueOf(paramLong);
    }
    return localObject;
  }
  
  public static String a(long paramLong1, long paramLong2)
  {
    return a(paramLong1, paramLong2, false);
  }
  
  public static String a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    int i4 = b() / 3600;
    int i5 = (int)(paramLong2 / 3600000L);
    Object localObject1 = TimeZone.getDefault();
    if (i4 != i5) {
      ((TimeZone)localObject1).setRawOffset((int)paramLong2);
    }
    Object localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).setTimeZone((TimeZone)localObject1);
    ((Calendar)localObject2).setTimeInMillis(paramLong1);
    localObject1 = new StringBuilder();
    int m = ((Calendar)localObject2).get(1);
    int n = ((Calendar)localObject2).get(2) + 1;
    int i1 = ((Calendar)localObject2).get(5);
    int i2 = ((Calendar)localObject2).get(11);
    int i3 = ((Calendar)localObject2).get(12);
    if (i4 != i5) {
      ((StringBuilder)localObject1).append("当地 ");
    }
    if (paramBoolean)
    {
      ((Calendar)localObject2).setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
      i4 = ((Calendar)localObject2).get(1);
      i5 = ((Calendar)localObject2).get(2);
      int i6 = ((Calendar)localObject2).get(5);
      if ((m != i4) || (n != i5 + 1) || (i1 != i6))
      {
        ((StringBuilder)localObject1).append(n);
        ((StringBuilder)localObject1).append("月");
        ((StringBuilder)localObject1).append(i1);
        ((StringBuilder)localObject1).append("日 ");
      }
    }
    if (i3 > 9)
    {
      if (i2 > 9)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(i2);
        ((StringBuilder)localObject2).append(":");
        ((StringBuilder)localObject2).append(i3);
        ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("0");
        ((StringBuilder)localObject2).append(i2);
        ((StringBuilder)localObject2).append(":");
        ((StringBuilder)localObject2).append(i3);
        ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
      }
    }
    else if (i2 > 9)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(i2);
      ((StringBuilder)localObject2).append(":0");
      ((StringBuilder)localObject2).append(i3);
      ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("0");
      ((StringBuilder)localObject2).append(i2);
      ((StringBuilder)localObject2).append(":0");
      ((StringBuilder)localObject2).append(i3);
      ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
    }
    return ((StringBuilder)localObject1).toString();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString1;
    }
    int m = paramString1.indexOf("?");
    if (-1 == m) {
      return paramString1;
    }
    int n = m + 1;
    Map localMap = URLUtil.b(paramString1.substring(n));
    if (localMap.remove(paramString2) == null) {
      return paramString1;
    }
    m = 0;
    paramString1 = paramString1.substring(0, n);
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      paramString2 = (String)localIterator.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append('&');
      localStringBuilder.append(URLUtil.c(paramString2));
      localStringBuilder.append('=');
      localStringBuilder.append(URLUtil.c((String)localMap.get(paramString2)));
      paramString2 = localStringBuilder.toString();
      paramString1 = paramString2;
      if (m == 0) {
        paramString1 = paramString2.replace("&", "");
      }
      m += 1;
    }
    return paramString1;
  }
  
  public static String a(int[] paramArrayOfInt)
  {
    StringBuilder localStringBuilder = (StringBuilder)StringAppendTool.a.get();
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.set(1, localCalendar1.get(1));
    localCalendar2.set(2, localCalendar1.get(2));
    localCalendar2.set(5, localCalendar1.get(5) - 1);
    localCalendar2.set(11, 0);
    localCalendar2.set(12, 0);
    localCalendar2.set(13, 0);
    if ((localCalendar1.get(1) == paramArrayOfInt[0]) && (localCalendar1.get(2) + 1 == paramArrayOfInt[1]) && (localCalendar1.get(5) == paramArrayOfInt[2]))
    {
      localStringBuilder.append("今天");
    }
    else if ((localCalendar2.get(1) == paramArrayOfInt[0]) && (localCalendar2.get(2) + 1 == paramArrayOfInt[1]) && (localCalendar2.get(5) == paramArrayOfInt[2]))
    {
      localStringBuilder.append("昨天");
    }
    else if (localCalendar1.get(1) == paramArrayOfInt[0])
    {
      localStringBuilder.append(paramArrayOfInt[1]);
      localStringBuilder.append("月");
      localStringBuilder.append(paramArrayOfInt[2]);
      localStringBuilder.append("日");
    }
    else
    {
      localStringBuilder.append(paramArrayOfInt[0]);
      localStringBuilder.append("年");
      localStringBuilder.append(paramArrayOfInt[1]);
      localStringBuilder.append("月");
      localStringBuilder.append(paramArrayOfInt[2]);
      localStringBuilder.append("日");
    }
    paramArrayOfInt = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    return paramArrayOfInt;
  }
  
  public static void a()
  {
    URLImageLoader localURLImageLoader = k;
    if (localURLImageLoader != null) {
      localURLImageLoader.c();
    }
  }
  
  public static void a(View paramView)
  {
    if (View.class.isInstance(paramView.getParent())) {
      ((View)paramView.getParent()).setTouchDelegate(null);
    }
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramView.isEnabled()) && (paramView.getVisibility() == 0))
    {
      Object localObject = new Rect();
      paramView.setEnabled(true);
      paramView.getHitRect((Rect)localObject);
      if ((((Rect)localObject).top == 0) && (((Rect)localObject).bottom == 0) && (((Rect)localObject).left == 0) && (((Rect)localObject).right == 0))
      {
        ((View)paramView.getParent()).post(new UIUtils.2(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
        return;
      }
      ((Rect)localObject).top -= paramInt1;
      ((Rect)localObject).bottom += paramInt2;
      ((Rect)localObject).left -= paramInt3;
      ((Rect)localObject).right += paramInt4;
      localObject = new TouchDelegate((Rect)localObject, paramView);
      if (View.class.isInstance(paramView.getParent())) {
        ((View)paramView.getParent()).setTouchDelegate((TouchDelegate)localObject);
      }
      return;
    }
    if (View.class.isInstance(paramView.getParent())) {
      ((View)paramView.getParent()).setTouchDelegate(null);
    }
  }
  
  public static void a(ImageView paramImageView)
  {
    URLImageLoader localURLImageLoader = k;
    if (localURLImageLoader != null) {
      localURLImageLoader.a(paramImageView);
    }
    f.clear();
    e.clear();
  }
  
  public static void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramImageView == null) {
      return;
    }
    Object localObject;
    if (paramInt3 != 0)
    {
      if (paramInt3 != 1) {
        localObject = null;
      } else {
        localObject = new CircleTransformation(null, null);
      }
    }
    else {
      localObject = new RoundedTransformation(20, 0, 1.0F, null, null);
    }
    a(paramImageView, paramString, paramInt1, paramInt2, (Transformation)localObject);
  }
  
  public static void a(ImageView paramImageView, String paramString1, int paramInt1, int paramInt2, int paramInt3, Drawable paramDrawable, String paramString2)
  {
    a(paramImageView, paramString1, paramInt1, paramInt2, paramInt3, paramDrawable, paramString2, true);
  }
  
  public static void a(ImageView paramImageView, String paramString1, int paramInt1, int paramInt2, int paramInt3, Drawable paramDrawable, String paramString2, boolean paramBoolean)
  {
    a(paramImageView, paramString1, paramInt1, paramInt2, paramInt3, paramDrawable, paramString2, paramBoolean, null);
  }
  
  public static void a(ImageView paramImageView, String paramString1, int paramInt1, int paramInt2, int paramInt3, Drawable paramDrawable, String paramString2, boolean paramBoolean, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = paramURLDrawableOptions;
    if (paramURLDrawableOptions == null) {
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    }
    paramURLDrawableOptions = paramDrawable;
    if (paramDrawable == null) {
      paramURLDrawableOptions = paramImageView.getResources().getDrawable(2130848395);
    }
    if (TextUtils.isEmpty(paramString1))
    {
      if (paramBoolean)
      {
        paramImageView.setImageDrawable(paramURLDrawableOptions);
        return;
      }
      if (Build.VERSION.SDK_INT < 16)
      {
        paramImageView.setBackgroundDrawable(paramURLDrawableOptions);
        return;
      }
      paramImageView.setBackground(paramURLDrawableOptions);
      return;
    }
    try
    {
      new URL(paramString1);
      localURLDrawableOptions.mLoadingDrawable = paramURLDrawableOptions;
      localURLDrawableOptions.mFailedDrawable = localURLDrawableOptions.mLoadingDrawable;
      localURLDrawableOptions.mUseAutoScaleParams = false;
      if (!TextUtils.isEmpty(paramString2)) {
        localURLDrawableOptions.mMemoryCacheKeySuffix = paramString2;
      }
      paramString1 = URLDrawable.getDrawable(paramString1, localURLDrawableOptions);
      paramString1.setTag(URLDrawableDecodeHandler.b(paramInt1, paramInt2, paramInt3));
      paramString1.setDecodeHandler(j);
      if ((paramString1.getStatus() != 2) && (paramString1.getStatus() != 3))
      {
        paramString1.startDownload();
      }
      else
      {
        InfoPrinter.c("Q.qqstory.UIViewUtils", new Object[] { "drawable restartDownload" });
        paramString1.restartDownload();
      }
      if (paramBoolean)
      {
        paramImageView.setImageDrawable(paramString1);
        return;
      }
      if (Build.VERSION.SDK_INT < 16)
      {
        paramImageView.setBackgroundDrawable(paramString1);
        return;
      }
      paramImageView.setBackground(paramString1);
      return;
    }
    catch (MalformedURLException paramString1)
    {
      paramString1.printStackTrace();
      InfoPrinter.a("Q.qqstory.UIViewUtils", new Object[] { paramString1.getMessage() });
      if (paramBoolean)
      {
        paramImageView.setImageDrawable(paramURLDrawableOptions);
        return;
      }
      if (Build.VERSION.SDK_INT < 16)
      {
        paramImageView.setBackgroundDrawable(paramURLDrawableOptions);
        return;
      }
      paramImageView.setBackground(paramURLDrawableOptions);
    }
  }
  
  public static void a(ImageView paramImageView, String paramString1, int paramInt1, int paramInt2, Drawable paramDrawable, String paramString2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = paramDrawable;
    if (paramDrawable == null) {
      localDrawable = paramImageView.getResources().getDrawable(2130837924);
    }
    if (TextUtils.isEmpty(paramString1))
    {
      paramImageView.setImageDrawable(localDrawable);
      return;
    }
    try
    {
      paramString1 = new URL(paramString1);
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localURLDrawableOptions.mFailedDrawable = localURLDrawableOptions.mLoadingDrawable;
      localURLDrawableOptions.mUseAutoScaleParams = false;
      localURLDrawableOptions.mRequestWidth = paramInt1;
      localURLDrawableOptions.mRequestHeight = paramInt2;
      if (!TextUtils.isEmpty(paramString2)) {
        localURLDrawableOptions.mMemoryCacheKeySuffix = paramString2;
      }
      paramString1 = URLDrawable.getDrawable(paramString1, localURLDrawableOptions);
      if ((paramString1.getStatus() == 2) || (paramString1.getStatus() == 3))
      {
        InfoPrinter.c("Q.qqstory.UIViewUtils", new Object[] { "drawable restartDownload" });
        paramString1.restartDownload();
      }
      paramImageView.setImageDrawable(paramString1);
      return;
    }
    catch (MalformedURLException paramString1)
    {
      paramString1.printStackTrace();
      InfoPrinter.a("Q.qqstory.UIViewUtils", new Object[] { paramString1.getMessage() });
      paramImageView.setImageDrawable(localDrawable);
    }
  }
  
  public static void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, Transformation paramTransformation)
  {
    a(paramImageView, paramString, paramInt1, paramInt2, paramTransformation, 0);
  }
  
  public static void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, Transformation paramTransformation, int paramInt3)
  {
    Drawable localDrawable;
    if ((paramTransformation != null) && ((paramTransformation instanceof CircleTransformation)))
    {
      if (g == null) {
        g = paramImageView.getResources().getDrawable(2130848221);
      }
      localDrawable = g;
    }
    else if ((paramTransformation != null) && ((paramTransformation instanceof RoundedTransformation)))
    {
      if (h == null) {
        h = paramImageView.getResources().getDrawable(2130848395);
      }
      localDrawable = h;
    }
    else
    {
      if (i == null) {
        i = new ColorDrawable(-3289651);
      }
      localDrawable = i;
    }
    a(paramImageView, paramString, paramInt1, paramInt2, paramTransformation, paramInt3, localDrawable);
  }
  
  public static void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, Transformation paramTransformation, int paramInt3, Drawable paramDrawable)
  {
    if (paramImageView == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramImageView.setTag(2131436784, null);
      paramImageView.setImageDrawable(paramDrawable);
      a(paramImageView);
      return;
    }
    if (k == null) {
      k = new URLImageLoader();
    }
    URLImageLoader.Config localConfig = new URLImageLoader.Config();
    localConfig.b = paramTransformation;
    localConfig.a = paramString;
    localConfig.d = paramInt2;
    localConfig.c = paramInt1;
    localConfig.e = paramDrawable;
    k.a(paramImageView, localConfig, localConfig.e, paramInt3);
  }
  
  public static void a(ImageView paramImageView, String paramString1, Drawable paramDrawable1, Drawable paramDrawable2, int paramInt1, int paramInt2, String paramString2)
  {
    boolean bool;
    if (paramInt1 != 0) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool);
    if (paramInt2 != 0) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    if (TextUtils.isEmpty(paramString1))
    {
      paramImageView.setImageDrawable(paramDrawable2);
      SLog.e("Q.qqstory.UIViewUtils", "setImageByURLDrawable ERROR, url is null");
      return;
    }
    try
    {
      new URL(paramString1);
      localURLDrawableOptions.mLoadingDrawable = paramDrawable1;
      localURLDrawableOptions.mFailedDrawable = paramDrawable2;
      localURLDrawableOptions.mUseAutoScaleParams = false;
      localURLDrawableOptions.mRequestWidth = paramInt1;
      localURLDrawableOptions.mRequestHeight = paramInt2;
      if (!TextUtils.isEmpty(paramString2)) {
        localURLDrawableOptions.mMemoryCacheKeySuffix = paramString2;
      }
      paramDrawable1 = URLDrawable.getDrawable(paramString1, localURLDrawableOptions);
      if ((paramDrawable1.getStatus() == 1) && (paramDrawable1.getCurrDrawable() != null))
      {
        SLog.a("Q.qqstory.UIViewUtils", "setImageByURLDrawable() %s, %s, not start download!", paramString1, paramDrawable1);
      }
      else if ((paramDrawable1.getStatus() != 3) && (paramDrawable1.getStatus() != 2))
      {
        UIUtils.URLDrawableMonitor.a(paramDrawable1, paramString2);
        paramDrawable1.startDownload();
      }
      else
      {
        UIUtils.URLDrawableMonitor.a(paramDrawable1, paramString2);
        paramDrawable1.restartDownload();
      }
      paramImageView.setImageDrawable(paramDrawable1);
      return;
    }
    catch (MalformedURLException paramDrawable1)
    {
      paramDrawable1.printStackTrace();
      InfoPrinter.a("Q.qqstory.UIViewUtils", new Object[] { paramDrawable1.getMessage() });
      paramImageView.setImageDrawable(paramDrawable2);
      SLog.c("Q.qqstory.UIViewUtils", paramDrawable1, "setImageByURLDrawable MalformedURLException, url is %s", new Object[] { paramString1 });
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    URLImageLoader localURLImageLoader = k;
    if (localURLImageLoader != null) {
      if (paramBoolean) {
        localURLImageLoader.e();
      } else {
        localURLImageLoader.f();
      }
    }
    if (paramBoolean)
    {
      URLDrawable.pause();
      return;
    }
    URLDrawable.resume();
  }
  
  public static int b()
  {
    return TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000;
  }
  
  public static int b(Context paramContext)
  {
    int m = c;
    if (m > 0) {
      return m;
    }
    paramContext = (WindowManager)paramContext.getSystemService("window");
    if (Build.VERSION.SDK_INT >= 13)
    {
      Point localPoint = new Point();
      paramContext.getDefaultDisplay().getSize(localPoint);
      c = localPoint.x;
    }
    else
    {
      c = paramContext.getDefaultDisplay().getWidth();
    }
    return c;
  }
  
  public static int b(Context paramContext, float paramFloat)
  {
    float f1 = FontSettingManager.getFontLevel() / 16.0F;
    return (int)(paramFloat * (a(paramContext) / f1) + 0.5F);
  }
  
  public static String b(long paramLong)
  {
    return a(paramLong, b() * 1000);
  }
  
  public static void b(ImageView paramImageView, String paramString1, int paramInt1, int paramInt2, Drawable paramDrawable, String paramString2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = paramDrawable;
    if (paramDrawable == null) {
      localDrawable = paramImageView.getResources().getDrawable(2130848221);
    }
    if (TextUtils.isEmpty(paramString1))
    {
      paramImageView.setImageDrawable(localDrawable);
      return;
    }
    try
    {
      new URL(paramString1);
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localURLDrawableOptions.mFailedDrawable = localURLDrawableOptions.mLoadingDrawable;
      localURLDrawableOptions.mUseAutoScaleParams = false;
      localURLDrawableOptions.mRetryCount = 2;
      if (!TextUtils.isEmpty(paramString2)) {
        localURLDrawableOptions.mMemoryCacheKeySuffix = paramString2;
      }
      paramString1 = URLDrawable.getDrawable(paramString1, localURLDrawableOptions);
      paramString1.setTag(URLDrawableDecodeHandler.a(paramInt1, paramInt2));
      paramString1.setDecodeHandler(URLDrawableDecodeHandler.b);
      if ((paramString1.getStatus() == 2) || (paramString1.getStatus() == 3))
      {
        InfoPrinter.c("Q.qqstory.UIViewUtils", new Object[] { "drawable restartDownload" });
        paramString1.restartDownload();
      }
      paramImageView.setImageDrawable(paramString1);
      return;
    }
    catch (MalformedURLException paramString1)
    {
      paramString1.printStackTrace();
      InfoPrinter.a("Q.qqstory.UIViewUtils", new Object[] { paramString1.getMessage() });
      paramImageView.setImageDrawable(localDrawable);
    }
  }
  
  public static float c(Context paramContext, float paramFloat)
  {
    return paramFloat / a(paramContext) + 0.5F;
  }
  
  public static int c(Context paramContext)
  {
    int i1 = ScreenUtil.getInstantScreenWidth(paramContext);
    int n = i1;
    if (Build.MANUFACTURER.contains("Xiaomi"))
    {
      n = i1;
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramContext = BaseApplication.getContext().getContentResolver();
        int m = 0;
        if (Settings.Global.getInt(paramContext, "force_fsg_nav_bar", 0) != 0) {
          m = 1;
        }
        n = i1;
        if (m != 0)
        {
          SLog.b("Q.qqstory.UIViewUtils", "find global screen in Xiaomi");
          n = ScreenUtil.getRealWidth(BaseApplication.getContext());
        }
      }
    }
    return n;
  }
  
  public static boolean c()
  {
    try
    {
      boolean bool = TrimNative.isGetThumbnailReady();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      SLog.c("Q.qqstory.UIViewUtils", "trimNativeIsReady is failed! e=%s", localThrowable);
    }
    return false;
  }
  
  public static int d(Context paramContext)
  {
    int i1 = ScreenUtil.getInstantScreenHeight(paramContext);
    int n = i1;
    if (Build.MANUFACTURER.contains("Xiaomi")) {
      if ((!Build.MODEL.contains("MIX 2S")) && (!Build.MODEL.contains("MI 8")))
      {
        n = i1;
        if (!Build.MODEL.contains("MIX 2")) {}
      }
      else
      {
        n = i1;
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramContext = BaseApplication.getContext().getContentResolver();
          int m = 0;
          if (Settings.Global.getInt(paramContext, "force_fsg_nav_bar", 0) != 0) {
            m = 1;
          }
          n = i1;
          if (m != 0)
          {
            SLog.b("Q.qqstory.UIViewUtils", "find global screen in Xiaomi");
            n = ScreenUtil.getRealHeight(BaseApplication.getContext());
          }
        }
      }
    }
    return n;
  }
  
  public static boolean d()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - l.longValue();
    if ((l2 > 0L) && (l2 < 800L))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("time:");
        localStringBuilder.append(l1);
        localStringBuilder.append(", mLastClickTIme:");
        localStringBuilder.append(l);
        localStringBuilder.append(", timeDiff:");
        localStringBuilder.append(l2);
        QLog.i("isFastDoubleClick", 2, localStringBuilder.toString());
      }
      return true;
    }
    l = Long.valueOf(l1);
    return false;
  }
  
  public static int e(Context paramContext)
  {
    int m = d;
    if (m > 0) {
      return m;
    }
    paramContext = (WindowManager)paramContext.getSystemService("window");
    if (Build.VERSION.SDK_INT >= 13)
    {
      Point localPoint = new Point();
      paramContext.getDefaultDisplay().getSize(localPoint);
      d = localPoint.y;
    }
    else
    {
      d = paramContext.getDefaultDisplay().getHeight();
    }
    return d;
  }
  
  public static int f(Context paramContext)
  {
    int n = b;
    int m = -1;
    if (n != -1) {
      return n;
    }
    n = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (n > 0) {
      m = paramContext.getResources().getDimensionPixelSize(n);
    }
    n = m;
    if (m <= 0) {
      n = a(paramContext, 25.0F);
    }
    b = n;
    return n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.UIUtils
 * JD-Core Version:    0.7.0.1
 */