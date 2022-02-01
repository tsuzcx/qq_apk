package com.tencent.biz.qqstory.takevideo;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.LruCache;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class FastAnimationDrawable
  extends Drawable
  implements Animatable
{
  public static byte[] a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private volatile BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  public LruCache<Integer, BitmapDrawable> a;
  private FastAnimationDrawable.CallAntiShakeListener jdField_a_of_type_ComTencentBizQqstoryTakevideoFastAnimationDrawable$CallAntiShakeListener;
  private FastAnimationDrawable.InvalidationHandler jdField_a_of_type_ComTencentBizQqstoryTakevideoFastAnimationDrawable$InvalidationHandler;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private Set<SoftReference<Bitmap>> jdField_a_of_type_JavaUtilSet;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private volatile boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private volatile BitmapDrawable jdField_b_of_type_AndroidGraphicsDrawableBitmapDrawable;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = new byte[24576];
  }
  
  private static int a(Bitmap.Config paramConfig)
  {
    if (paramConfig == Bitmap.Config.ARGB_8888) {
      return 4;
    }
    if (paramConfig == Bitmap.Config.RGB_565) {
      return 2;
    }
    if (paramConfig == Bitmap.Config.ARGB_4444) {
      return 2;
    }
    if (paramConfig == Bitmap.Config.ALPHA_8) {}
    return 1;
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int j = paramOptions.outHeight;
    int k = paramOptions.outWidth;
    if ((j <= paramInt2) && (k <= paramInt1)) {
      return 1;
    }
    int i = 2;
    for (;;)
    {
      if ((j / i <= paramInt2) && (k / i <= paramInt1)) {
        return i;
      }
      i *= 2;
    }
  }
  
  /* Error */
  public static Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_1
    //   5: ifnull +32 -> 37
    //   8: aload_1
    //   9: getfield 66	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   12: ifeq +25 -> 37
    //   15: new 68	java/io/BufferedInputStream
    //   18: dup
    //   19: new 70	java/io/FileInputStream
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 74	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   27: sipush 2048
    //   30: invokespecial 77	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   33: astore_0
    //   34: goto +19 -> 53
    //   37: new 68	java/io/BufferedInputStream
    //   40: dup
    //   41: new 70	java/io/FileInputStream
    //   44: dup
    //   45: aload_0
    //   46: invokespecial 74	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   49: invokespecial 80	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   52: astore_0
    //   53: aload_0
    //   54: astore_2
    //   55: aload_0
    //   56: aconst_null
    //   57: aload_1
    //   58: invokestatic 86	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   61: astore_1
    //   62: aload_0
    //   63: invokevirtual 91	java/io/InputStream:close	()V
    //   66: aload_1
    //   67: areturn
    //   68: astore_1
    //   69: goto +14 -> 83
    //   72: astore_1
    //   73: goto +30 -> 103
    //   76: astore_0
    //   77: goto +49 -> 126
    //   80: astore_1
    //   81: aconst_null
    //   82: astore_0
    //   83: aload_0
    //   84: astore_2
    //   85: ldc 93
    //   87: iconst_1
    //   88: ldc 95
    //   90: aload_1
    //   91: invokestatic 101	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   94: aload_0
    //   95: ifnull +28 -> 123
    //   98: aload_3
    //   99: astore_1
    //   100: goto -38 -> 62
    //   103: aload_0
    //   104: astore_2
    //   105: ldc 93
    //   107: iconst_1
    //   108: ldc 103
    //   110: aload_1
    //   111: invokestatic 101	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   114: aload_0
    //   115: ifnull +8 -> 123
    //   118: aload_3
    //   119: astore_1
    //   120: goto -58 -> 62
    //   123: aconst_null
    //   124: areturn
    //   125: astore_0
    //   126: aload_2
    //   127: ifnull +7 -> 134
    //   130: aload_2
    //   131: invokevirtual 91	java/io/InputStream:close	()V
    //   134: goto +5 -> 139
    //   137: aload_0
    //   138: athrow
    //   139: goto -2 -> 137
    //   142: astore_0
    //   143: aload_1
    //   144: areturn
    //   145: astore_1
    //   146: goto -12 -> 134
    //   149: astore_1
    //   150: aconst_null
    //   151: astore_0
    //   152: goto -49 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	paramString	String
    //   0	155	1	paramOptions	BitmapFactory.Options
    //   1	130	2	str	String
    //   3	116	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   55	62	68	java/lang/OutOfMemoryError
    //   55	62	72	java/lang/Exception
    //   8	34	76	finally
    //   37	53	76	finally
    //   8	34	80	java/lang/OutOfMemoryError
    //   37	53	80	java/lang/OutOfMemoryError
    //   55	62	125	finally
    //   85	94	125	finally
    //   105	114	125	finally
    //   62	66	142	java/io/IOException
    //   130	134	145	java/io/IOException
    //   8	34	149	java/lang/Exception
    //   37	53	149	java/lang/Exception
  }
  
  @TargetApi(12)
  private BitmapDrawable a(String paramString)
  {
    Object localObject2 = null;
    localObject1 = localObject2;
    try
    {
      try
      {
        localObject3 = new BitmapFactory.Options();
        localObject1 = localObject2;
        ((BitmapFactory.Options)localObject3).inJustDecodeBounds = true;
        localObject1 = localObject2;
        ((BitmapFactory.Options)localObject3).inTempStorage = jdField_a_of_type_ArrayOfByte;
        localObject1 = localObject2;
        BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject3);
        localObject1 = localObject2;
        int i = a((BitmapFactory.Options)localObject3, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        localObject1 = localObject2;
        ((BitmapFactory.Options)localObject3).inJustDecodeBounds = false;
        localObject1 = localObject2;
        ((BitmapFactory.Options)localObject3).inSampleSize = i;
        localObject1 = localObject2;
        ((BitmapFactory.Options)localObject3).inTempStorage = jdField_a_of_type_ArrayOfByte;
        localObject1 = localObject2;
        ((BitmapFactory.Options)localObject3).inPreferredConfig = Bitmap.Config.RGB_565;
        localObject1 = localObject2;
        if (Build.VERSION.SDK_INT >= 11)
        {
          localObject1 = localObject2;
          a((BitmapFactory.Options)localObject3);
        }
        localObject1 = localObject2;
        localObject3 = a(paramString, (BitmapFactory.Options)localObject3);
        localObject1 = localObject3;
        int j = ImageUtil.c(paramString);
        localObject2 = localObject3;
        if (j != 0)
        {
          localObject2 = localObject3;
          if (j % 90 == 0)
          {
            localObject1 = localObject3;
            if (QLog.isColorLevel())
            {
              localObject1 = localObject3;
              localObject2 = new StringBuilder();
              localObject1 = localObject3;
              ((StringBuilder)localObject2).append("has exif rotate");
              localObject1 = localObject3;
              ((StringBuilder)localObject2).append(j);
              localObject1 = localObject3;
              QLog.d("FastAnimationDrawable", 2, ((StringBuilder)localObject2).toString());
            }
            localObject1 = localObject3;
            int k = ((Bitmap)localObject3).getWidth();
            localObject1 = localObject3;
            int m = ((Bitmap)localObject3).getHeight();
            localObject1 = localObject3;
            localObject2 = new Matrix();
            localObject1 = localObject3;
            ((Matrix)localObject2).postRotate(j, k / 2.0F, m / 2.0F);
            localObject1 = localObject3;
            localObject2 = Bitmap.createBitmap((Bitmap)localObject3, 0, 0, k, m, (Matrix)localObject2, true);
          }
        }
        localObject3 = localObject2;
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = localObject2;
          localObject3 = new StringBuilder();
          localObject1 = localObject2;
          ((StringBuilder)localObject3).append("path:");
          localObject1 = localObject2;
          ((StringBuilder)localObject3).append(paramString);
          localObject1 = localObject2;
          ((StringBuilder)localObject3).append(" SampleSize:");
          localObject1 = localObject2;
          ((StringBuilder)localObject3).append(i);
          localObject1 = localObject2;
          ((StringBuilder)localObject3).append(" bitmap:");
          localObject1 = localObject2;
          ((StringBuilder)localObject3).append(((Bitmap)localObject2).getByteCount());
          localObject1 = localObject2;
          QLog.d("FastAnimationDrawable", 2, ((StringBuilder)localObject3).toString());
          localObject3 = localObject2;
        }
      }
      finally
      {
        break label453;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        label453:
        Object localObject3 = localObject1;
      }
    }
    paramString = new BitmapDrawable((Bitmap)localObject3);
    return paramString;
    throw paramString;
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FastAnimationDrawable", 2, "reset");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = null;
    this.jdField_b_of_type_AndroidGraphicsDrawableBitmapDrawable = null;
  }
  
  @TargetApi(11)
  private void a(BitmapFactory.Options paramOptions)
  {
    paramOptions.inMutable = true;
    Bitmap localBitmap = a(paramOptions);
    if (localBitmap != null) {
      paramOptions.inBitmap = localBitmap;
    }
  }
  
  @TargetApi(19)
  private static boolean a(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool1 = false;
    boolean bool2 = false;
    if (i < 19)
    {
      bool1 = bool2;
      if (paramBitmap.getWidth() == paramOptions.outWidth)
      {
        bool1 = bool2;
        if (paramBitmap.getHeight() == paramOptions.outHeight)
        {
          bool1 = bool2;
          if (paramOptions.inSampleSize == 1) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    if (paramOptions.outWidth / paramOptions.inSampleSize * (paramOptions.outHeight / paramOptions.inSampleSize) * a(paramBitmap.getConfig()) <= paramBitmap.getAllocationByteCount()) {
      bool1 = true;
    }
    return bool1;
  }
  
  protected Bitmap a(BitmapFactory.Options paramOptions)
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilSet;
    Object localObject2 = null;
    if ((localObject1 != null) && (!((Set)localObject1).isEmpty())) {
      synchronized (this.jdField_a_of_type_JavaUtilSet)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
        for (;;)
        {
          localObject1 = localObject2;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (Bitmap)((SoftReference)localIterator.next()).get();
          if ((localObject1 != null) && (((Bitmap)localObject1).isMutable()))
          {
            if (a((Bitmap)localObject1, paramOptions))
            {
              localIterator.remove();
              break;
            }
          }
          else {
            localIterator.remove();
          }
        }
        return localObject1;
      }
    }
    return null;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_AndroidGraphicsDrawableBitmapDrawable != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableBitmapDrawable;
      this.jdField_b_of_type_AndroidGraphicsDrawableBitmapDrawable = null;
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.setBounds(getBounds());
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.draw(paramCanvas);
    }
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public boolean isRunning()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setVisible changed:");
      localStringBuilder.append(bool);
      localStringBuilder.append(" visible:");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" restart:");
      localStringBuilder.append(paramBoolean2);
      QLog.d("FastAnimationDrawable", 2, localStringBuilder.toString());
    }
    if (paramBoolean1)
    {
      if (bool)
      {
        start();
        if (paramBoolean2)
        {
          a();
          return bool;
        }
        start();
        return bool;
      }
    }
    else if (bool) {
      stop();
    }
    return bool;
  }
  
  public void start()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FastAnimationDrawable", 2, "start");
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.submit(new FastAnimationDrawable.LoopReadWriteRunnable(this));
    }
  }
  
  public void stop()
  {
    if (isRunning())
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoFastAnimationDrawable$CallAntiShakeListener = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.FastAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */