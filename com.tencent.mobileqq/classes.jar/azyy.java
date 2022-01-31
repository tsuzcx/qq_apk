import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Picture;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.util.ScreenShotUtil.1;
import com.tencent.mobileqq.util.ScreenShotUtil.2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

public final class azyy
{
  private static Method jdField_a_of_type_JavaLangReflectMethod;
  private static boolean jdField_a_of_type_Boolean;
  
  public static Bitmap a(int paramInt1, int paramInt2)
  {
    try
    {
      Bitmap localBitmap1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      return localBitmap1;
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      QLog.e("ScreenShotUtil", 1, "createBitmap failed", localOutOfMemoryError1);
      System.gc();
      try
      {
        Bitmap localBitmap2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        return localBitmap2;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        QLog.e("ScreenShotUtil", 1, "createBitmap failed again", localOutOfMemoryError2);
      }
    }
    return null;
  }
  
  public static Bitmap a(WebView paramWebView, int paramInt1, int paramInt2)
  {
    if ((paramWebView == null) || (paramInt1 <= 0) || (paramInt2 <= 0)) {
      return null;
    }
    Bitmap localBitmap = a(paramInt1, paramInt2);
    if (localBitmap == null) {
      return null;
    }
    Canvas localCanvas = new Canvas(localBitmap);
    PaintFlagsDrawFilter localPaintFlagsDrawFilter;
    float f;
    if (paramWebView.getX5WebViewExtension() != null)
    {
      localPaintFlagsDrawFilter = new PaintFlagsDrawFilter(134, 64);
      paramInt2 = QbSdk.getTbsVersion(paramWebView.getContext());
      if ((paramInt2 >= 43000) && (paramInt2 < 43105))
      {
        f = paramInt1 / paramWebView.getMeasuredWidth();
        localCanvas.scale(f, f);
        localCanvas.setDrawFilter(localPaintFlagsDrawFilter);
        paramWebView.getX5WebViewExtension().snapshotVisible(localCanvas, false, false, false, false);
        if (QLog.isColorLevel()) {
          QLog.d("ScreenShotUtil", 2, "snapshot with snapshotVisible()");
        }
        localCanvas.setDrawFilter(null);
      }
    }
    for (;;)
    {
      return localBitmap;
      f = paramInt1 / paramWebView.getContentWidth();
      localCanvas.scale(f, f);
      localCanvas.setDrawFilter(localPaintFlagsDrawFilter);
      paramWebView.getX5WebViewExtension().snapshotWholePage(localCanvas, false, false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ScreenShotUtil", 2, "snapshot with snapshotWholePage()");
      break;
      f = paramInt1 / paramWebView.getMeasuredWidth();
      localCanvas.scale(f, f);
      paramWebView = paramWebView.capturePicture();
      if (paramWebView != null) {
        paramWebView.draw(localCanvas);
      }
    }
  }
  
  /* Error */
  public static String a(Bitmap paramBitmap, java.io.File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload 4
    //   5: astore_3
    //   6: aload_0
    //   7: ifnull +20 -> 27
    //   10: aload 4
    //   12: astore_3
    //   13: aload_1
    //   14: ifnull +13 -> 27
    //   17: aload_2
    //   18: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifeq +8 -> 29
    //   24: aload 4
    //   26: astore_3
    //   27: aload_3
    //   28: areturn
    //   29: aload_1
    //   30: invokevirtual 136	java/io/File:exists	()Z
    //   33: ifne +8 -> 41
    //   36: aload_1
    //   37: invokevirtual 139	java/io/File:mkdirs	()Z
    //   40: pop
    //   41: new 133	java/io/File
    //   44: dup
    //   45: aload_1
    //   46: aload_2
    //   47: invokespecial 142	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   50: astore_3
    //   51: new 144	java/io/BufferedOutputStream
    //   54: dup
    //   55: new 146	java/io/FileOutputStream
    //   58: dup
    //   59: aload_3
    //   60: invokespecial 149	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   63: invokespecial 152	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   66: astore_2
    //   67: aload_2
    //   68: astore_1
    //   69: aload_0
    //   70: getstatic 158	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   73: bipush 100
    //   75: aload_2
    //   76: invokevirtual 162	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   79: pop
    //   80: aload_2
    //   81: ifnull +11 -> 92
    //   84: aload_2
    //   85: invokevirtual 167	java/io/OutputStream:flush	()V
    //   88: aload_2
    //   89: invokevirtual 170	java/io/OutputStream:close	()V
    //   92: aload_3
    //   93: invokevirtual 174	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   96: areturn
    //   97: astore_0
    //   98: ldc 24
    //   100: iconst_1
    //   101: ldc 176
    //   103: aload_0
    //   104: invokestatic 32	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   107: goto -15 -> 92
    //   110: astore_3
    //   111: aconst_null
    //   112: astore_0
    //   113: aload_0
    //   114: astore_1
    //   115: ldc 24
    //   117: iconst_1
    //   118: aload_3
    //   119: iconst_0
    //   120: anewarray 4	java/lang/Object
    //   123: invokestatic 179	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   126: ldc 181
    //   128: astore_3
    //   129: aload_0
    //   130: ifnull -103 -> 27
    //   133: aload_0
    //   134: invokevirtual 167	java/io/OutputStream:flush	()V
    //   137: aload_0
    //   138: invokevirtual 170	java/io/OutputStream:close	()V
    //   141: ldc 181
    //   143: areturn
    //   144: astore_0
    //   145: ldc 24
    //   147: iconst_1
    //   148: ldc 176
    //   150: aload_0
    //   151: invokestatic 32	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   154: ldc 181
    //   156: areturn
    //   157: astore_0
    //   158: aconst_null
    //   159: astore_1
    //   160: aload_1
    //   161: ifnull +11 -> 172
    //   164: aload_1
    //   165: invokevirtual 167	java/io/OutputStream:flush	()V
    //   168: aload_1
    //   169: invokevirtual 170	java/io/OutputStream:close	()V
    //   172: aload_0
    //   173: athrow
    //   174: astore_1
    //   175: ldc 24
    //   177: iconst_1
    //   178: ldc 176
    //   180: aload_1
    //   181: invokestatic 32	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   184: goto -12 -> 172
    //   187: astore_0
    //   188: goto -28 -> 160
    //   191: astore_3
    //   192: aload_2
    //   193: astore_0
    //   194: goto -81 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	paramBitmap	Bitmap
    //   0	197	1	paramFile	java.io.File
    //   0	197	2	paramString	String
    //   5	88	3	localObject1	Object
    //   110	9	3	localThrowable1	java.lang.Throwable
    //   128	1	3	str	String
    //   191	1	3	localThrowable2	java.lang.Throwable
    //   1	24	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   84	92	97	java/io/IOException
    //   51	67	110	java/lang/Throwable
    //   133	141	144	java/io/IOException
    //   51	67	157	finally
    //   164	172	174	java/io/IOException
    //   69	80	187	finally
    //   115	126	187	finally
    //   69	80	191	java/lang/Throwable
  }
  
  public static <T> void a(WebView paramWebView, azzd<T> paramazzd)
  {
    QLog.d("ScreenShotUtil", 1, "webViewFragmentScreenLongShot start");
    if (paramWebView == null)
    {
      QLog.e("ScreenShotUtil", 1, "webviewFragmentScreenLongShot error, mWebView is null");
      paramazzd.a(new NullPointerException("mWebView is null"));
      return;
    }
    Object localObject1 = paramWebView.getContext();
    if (localObject1 == null)
    {
      QLog.e("ScreenShotUtil", 1, "webviewFragmentScreenLongShot error, context is null");
      paramazzd.a(new NullPointerException("context is null"));
      return;
    }
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    localObject1 = new atgo((Context)localObject1);
    ((atgo)localObject1).a(ajjy.a(2131633593));
    ((atgo)localObject1).a(true);
    ((atgo)localObject1).a(new azyz(localAtomicBoolean, (atgo)localObject1));
    ((atgo)localObject1).show();
    ValueAnimator localValueAnimator1 = ObjectAnimator.ofInt(new int[] { 0, 90 });
    localValueAnimator1.setDuration(2000L);
    ValueAnimator localValueAnimator2 = ObjectAnimator.ofInt(new int[] { 90, 99 });
    localValueAnimator2.setDuration(10000L);
    Object localObject2 = new azza((atgo)localObject1);
    localValueAnimator1.addUpdateListener((ValueAnimator.AnimatorUpdateListener)localObject2);
    localValueAnimator2.addUpdateListener((ValueAnimator.AnimatorUpdateListener)localObject2);
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).playSequentially(new Animator[] { localValueAnimator1, localValueAnimator2 });
    ((AnimatorSet)localObject2).start();
    ((atgo)localObject1).setOnDismissListener(new azzb((AnimatorSet)localObject2));
    a(paramWebView, new azzc(localAtomicBoolean, (atgo)localObject1, paramazzd, paramWebView, (AnimatorSet)localObject2));
  }
  
  public static void a(WebView paramWebView, azze paramazze)
  {
    if ((paramWebView == null) || (paramazze == null)) {}
    int i;
    int j;
    Bitmap localBitmap;
    do
    {
      do
      {
        return;
        i = paramWebView.getMeasuredWidth();
        j = paramWebView.getMeasuredHeight();
      } while ((i <= 0) || (j <= 0));
      localBitmap = a(i, j);
    } while (localBitmap == null);
    Canvas localCanvas = new Canvas(localBitmap);
    if (paramWebView.getX5WebViewExtension() != null)
    {
      Class[] arrayOfClass;
      if ((!jdField_a_of_type_Boolean) && (jdField_a_of_type_JavaLangReflectMethod == null))
      {
        arrayOfClass = paramWebView.getX5WebViewExtension().getClass().getInterfaces();
        j = arrayOfClass.length;
        i = 0;
      }
      for (;;)
      {
        for (;;)
        {
          Class localClass;
          if (i < j)
          {
            localClass = arrayOfClass[i];
            if (!"com.tencent.smtt.export.internal.interfaces.IX5WebView".equals(localClass.getName())) {}
          }
          else
          {
            try
            {
              jdField_a_of_type_JavaLangReflectMethod = localClass.getDeclaredMethod("snapshotVisibleWithBitmap", new Class[] { Bitmap.class, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Float.TYPE, Float.TYPE, Runnable.class });
              if (QLog.isColorLevel()) {
                QLog.i("ScreenShotUtil", 2, "call snapshotVisibleWithBitmap");
              }
              jdField_a_of_type_Boolean = true;
              try
              {
                if (jdField_a_of_type_JavaLangReflectMethod != null) {
                  jdField_a_of_type_JavaLangReflectMethod.invoke(paramWebView.getX5WebViewExtension(), new Object[] { localBitmap, Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Integer.valueOf(1), Integer.valueOf(1), new ScreenShotUtil.1(paramazze, localBitmap) });
                }
                i = 1;
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  i = 0;
                }
              }
              if (i != 0) {
                break;
              }
              localCanvas.setDrawFilter(new PaintFlagsDrawFilter(134, 64));
              paramWebView.getX5WebViewExtension().snapshotVisible(localCanvas, false, false, false, false);
              if (QLog.isColorLevel()) {
                QLog.d("ScreenShotUtil", 2, "snapshot with snapshotVisible()");
              }
              localCanvas.setDrawFilter(null);
              paramazze.a(localBitmap);
              return;
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.i("ScreenShotUtil", 2, "call snapshotVisibleWithBitmap failed: " + localException1.getMessage());
                }
                jdField_a_of_type_JavaLangReflectMethod = null;
              }
            }
          }
        }
        i += 1;
      }
    }
    paramWebView.draw(localCanvas);
    paramazze.a(localBitmap);
  }
  
  public static <T> boolean a(WebView paramWebView, azzd<T> paramazzd)
  {
    QLog.d("ScreenShotUtil", 1, "snapshotWholePage start");
    if (paramWebView == null)
    {
      QLog.e("ScreenShotUtil", 1, "snapshotWholePage error, mWebView is null");
      paramazzd.a(new NullPointerException("mWebView is null"));
    }
    for (;;)
    {
      return false;
      int i = paramWebView.getMeasuredWidth();
      int k = paramWebView.getContentWidth();
      int j = paramWebView.getContentHeight();
      if ((i <= 0) || (k <= 0) || (j <= 0))
      {
        QLog.e("ScreenShotUtil", 1, "measuredWidth <= 0 || contentWidth <= 0 || contentHeight <= 0");
        paramazzd.a(new IllegalStateException("measuredWidth <= 0 || contentWidth <= 0 || contentHeight <= 0"));
        return false;
      }
      float f = i / k;
      j = (int)(j * f);
      if (j > 20000)
      {
        QLog.e("ScreenShotUtil", 1, "height > 20000, out of height limit");
        paramazzd.a(new IllegalStateException(ajjy.a(2131653210)));
        return false;
      }
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.RGB_565);
        if (localBitmap != null)
        {
          Canvas localCanvas = new Canvas(localBitmap);
          localCanvas.scale(f, f);
          ThreadManagerV2.executeOnNetWorkThread(new ScreenShotUtil.2(paramWebView, localCanvas, paramazzd, localBitmap));
          return true;
        }
      }
      catch (OutOfMemoryError paramWebView)
      {
        if (0 != 0) {
          throw new NullPointerException();
        }
        QLog.e("ScreenShotUtil", 1, "createBitmap out of memory");
        paramazzd.a(new IllegalStateException(ajjy.a(2131653210)));
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azyy
 * JD-Core Version:    0.7.0.1
 */