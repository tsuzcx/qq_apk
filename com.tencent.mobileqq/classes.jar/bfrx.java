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
import android.os.Environment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.util.ScreenShotUtil.1;
import com.tencent.mobileqq.util.ScreenShotUtil.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

public final class bfrx
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
  
  public static String a()
  {
    if (CheckPermission.isHasStoragePermission(BaseApplicationImpl.getContext())) {
      return Environment.getExternalStorageDirectory() + "/Tencent/MobileQQ/web_long_shot/";
    }
    return BaseApplicationImpl.getContext().getFilesDir() + "/Tencent/MobileQQ/web_long_shot/";
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
    //   18: invokestatic 170	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifeq +8 -> 29
    //   24: aload 4
    //   26: astore_3
    //   27: aload_3
    //   28: areturn
    //   29: aload_1
    //   30: invokevirtual 175	java/io/File:exists	()Z
    //   33: ifne +8 -> 41
    //   36: aload_1
    //   37: invokevirtual 178	java/io/File:mkdirs	()Z
    //   40: pop
    //   41: new 172	java/io/File
    //   44: dup
    //   45: aload_1
    //   46: aload_2
    //   47: invokespecial 181	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   50: astore_3
    //   51: new 183	java/io/BufferedOutputStream
    //   54: dup
    //   55: new 185	java/io/FileOutputStream
    //   58: dup
    //   59: aload_3
    //   60: invokespecial 188	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   63: invokespecial 191	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   66: astore_2
    //   67: aload_2
    //   68: astore_1
    //   69: aload_0
    //   70: getstatic 197	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   73: bipush 100
    //   75: aload_2
    //   76: invokevirtual 201	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   79: pop
    //   80: aload_2
    //   81: astore_1
    //   82: aload_2
    //   83: invokevirtual 206	java/io/OutputStream:flush	()V
    //   86: aload_2
    //   87: ifnull +7 -> 94
    //   90: aload_2
    //   91: invokevirtual 209	java/io/OutputStream:close	()V
    //   94: aload_3
    //   95: invokevirtual 212	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   98: areturn
    //   99: astore_0
    //   100: ldc 24
    //   102: iconst_1
    //   103: ldc 214
    //   105: aload_0
    //   106: invokestatic 32	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   109: goto -15 -> 94
    //   112: astore_3
    //   113: aconst_null
    //   114: astore_0
    //   115: aload_0
    //   116: astore_1
    //   117: ldc 24
    //   119: iconst_1
    //   120: aload_3
    //   121: iconst_0
    //   122: anewarray 4	java/lang/Object
    //   125: invokestatic 217	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   128: ldc 219
    //   130: astore_3
    //   131: aload_0
    //   132: ifnull -105 -> 27
    //   135: aload_0
    //   136: invokevirtual 209	java/io/OutputStream:close	()V
    //   139: ldc 219
    //   141: areturn
    //   142: astore_0
    //   143: ldc 24
    //   145: iconst_1
    //   146: ldc 214
    //   148: aload_0
    //   149: invokestatic 32	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   152: ldc 219
    //   154: areturn
    //   155: astore_0
    //   156: aconst_null
    //   157: astore_1
    //   158: aload_1
    //   159: ifnull +7 -> 166
    //   162: aload_1
    //   163: invokevirtual 209	java/io/OutputStream:close	()V
    //   166: aload_0
    //   167: athrow
    //   168: astore_1
    //   169: ldc 24
    //   171: iconst_1
    //   172: ldc 214
    //   174: aload_1
    //   175: invokestatic 32	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   178: goto -12 -> 166
    //   181: astore_0
    //   182: goto -24 -> 158
    //   185: astore_3
    //   186: aload_2
    //   187: astore_0
    //   188: goto -73 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	paramBitmap	Bitmap
    //   0	191	1	paramFile	java.io.File
    //   0	191	2	paramString	String
    //   5	90	3	localObject1	Object
    //   112	9	3	localThrowable1	java.lang.Throwable
    //   130	1	3	str	String
    //   185	1	3	localThrowable2	java.lang.Throwable
    //   1	24	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   90	94	99	java/io/IOException
    //   51	67	112	java/lang/Throwable
    //   135	139	142	java/io/IOException
    //   51	67	155	finally
    //   162	166	168	java/io/IOException
    //   69	80	181	finally
    //   82	86	181	finally
    //   117	128	181	finally
    //   69	80	185	java/lang/Throwable
    //   82	86	185	java/lang/Throwable
  }
  
  public static <T> void a(WebView paramWebView, bfsc<T> parambfsc)
  {
    QLog.d("ScreenShotUtil", 1, "webViewFragmentScreenLongShot start");
    if (paramWebView == null)
    {
      QLog.e("ScreenShotUtil", 1, "webviewFragmentScreenLongShot error, mWebView is null");
      parambfsc.a(new NullPointerException("mWebView is null"));
      return;
    }
    Object localObject1 = paramWebView.getContext();
    if (localObject1 == null)
    {
      QLog.e("ScreenShotUtil", 1, "webviewFragmentScreenLongShot error, context is null");
      parambfsc.a(new NullPointerException("context is null"));
      return;
    }
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    localObject1 = new axpc((Context)localObject1);
    ((axpc)localObject1).a(amtj.a(2131698491));
    ((axpc)localObject1).a(true);
    ((axpc)localObject1).a(new bfry(localAtomicBoolean, (axpc)localObject1));
    ((axpc)localObject1).show();
    ValueAnimator localValueAnimator1 = ObjectAnimator.ofInt(new int[] { 0, 90 });
    localValueAnimator1.setDuration(2000L);
    ValueAnimator localValueAnimator2 = ObjectAnimator.ofInt(new int[] { 90, 99 });
    localValueAnimator2.setDuration(10000L);
    Object localObject2 = new bfrz((axpc)localObject1);
    localValueAnimator1.addUpdateListener((ValueAnimator.AnimatorUpdateListener)localObject2);
    localValueAnimator2.addUpdateListener((ValueAnimator.AnimatorUpdateListener)localObject2);
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).playSequentially(new Animator[] { localValueAnimator1, localValueAnimator2 });
    ((AnimatorSet)localObject2).start();
    ((axpc)localObject1).setOnDismissListener(new bfsa((AnimatorSet)localObject2));
    a(paramWebView, new bfsb(localAtomicBoolean, (axpc)localObject1, parambfsc, paramWebView, (AnimatorSet)localObject2));
  }
  
  public static void a(WebView paramWebView, bfsd parambfsd)
  {
    if ((paramWebView == null) || (parambfsd == null)) {}
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
                  jdField_a_of_type_JavaLangReflectMethod.invoke(paramWebView.getX5WebViewExtension(), new Object[] { localBitmap, Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Integer.valueOf(1), Integer.valueOf(1), new ScreenShotUtil.1(parambfsd, localBitmap) });
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
              parambfsd.a(localBitmap);
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
    parambfsd.a(localBitmap);
  }
  
  public static <T> boolean a(WebView paramWebView, bfsc<T> parambfsc)
  {
    QLog.d("ScreenShotUtil", 1, "snapshotWholePage start");
    if (paramWebView == null)
    {
      QLog.e("ScreenShotUtil", 1, "snapshotWholePage error, mWebView is null");
      parambfsc.a(new NullPointerException("mWebView is null"));
    }
    for (;;)
    {
      return false;
      int i = paramWebView.getMeasuredWidth();
      int j = paramWebView.getContentWidth();
      int k = paramWebView.getContentHeight();
      if ((i <= 0) || (j <= 0) || (k <= 0))
      {
        QLog.e("ScreenShotUtil", 1, "measuredWidth <= 0 || contentWidth <= 0 || contentHeight <= 0");
        parambfsc.a(new IllegalStateException("measuredWidth <= 0 || contentWidth <= 0 || contentHeight <= 0"));
        return false;
      }
      float f = i / j;
      j = (int)(k * f);
      if (j > 20000)
      {
        QLog.e("ScreenShotUtil", 1, "height > 20000, out of height limit");
        parambfsc.a(new IllegalStateException(amtj.a(2131717947)));
        return false;
      }
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.RGB_565);
        if (localBitmap != null)
        {
          Canvas localCanvas = new Canvas(localBitmap);
          localCanvas.scale(f, f);
          ThreadManagerV2.executeOnNetWorkThread(new ScreenShotUtil.2(paramWebView, localCanvas, parambfsc, localBitmap));
          return true;
        }
      }
      catch (OutOfMemoryError paramWebView)
      {
        if (0 != 0) {
          throw new NullPointerException();
        }
        QLog.e("ScreenShotUtil", 1, "createBitmap out of memory");
        parambfsc.a(new IllegalStateException(amtj.a(2131717947)));
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfrx
 * JD-Core Version:    0.7.0.1
 */