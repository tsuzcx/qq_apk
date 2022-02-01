package com.tencent.biz.richframework.animation.drawable;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import mqq.app.MobileQQ;

@SuppressLint({"NewApi"})
public class QQAnimationDrawable
  extends Drawable
  implements Animatable, Runnable
{
  public static final ExecutorService a;
  public static byte[] a;
  protected int a;
  private long jdField_a_of_type_Long = 0L;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private BitmapFactory.Options jdField_a_of_type_AndroidGraphicsBitmapFactory$Options = new BitmapFactory.Options();
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
  final QQAnimationDrawable.InternalHandler jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableQQAnimationDrawable$InternalHandler = new QQAnimationDrawable.InternalHandler(this, this);
  private QQAnimationDrawable.QQAnimationListener jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableQQAnimationDrawable$QQAnimationListener;
  private volatile QQAnimationDrawable.SerialExecutor jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableQQAnimationDrawable$SerialExecutor = new QQAnimationDrawable.SerialExecutor(null);
  private QQAnimationDrawable.WorkerRunnable jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableQQAnimationDrawable$WorkerRunnable;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<Bitmap> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<String, SoftReference<Bitmap>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Set<SoftReference<Bitmap>> jdField_a_of_type_JavaUtilSet;
  private FutureTask<Bitmap> jdField_a_of_type_JavaUtilConcurrentFutureTask;
  boolean jdField_a_of_type_Boolean = true;
  private int[] jdField_a_of_type_ArrayOfInt;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  int jdField_b_of_type_Int = 160;
  private long jdField_b_of_type_Long;
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int = 0;
  private Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 1;
  private boolean jdField_d_of_type_Boolean = true;
  private int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean = true;
  private int jdField_f_of_type_Int = 2;
  private boolean jdField_f_of_type_Boolean = true;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean = false;
  private int h;
  private int i;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newSingleThreadExecutor();
    jdField_a_of_type_ArrayOfByte = new byte[24576];
  }
  
  public QQAnimationDrawable()
  {
    this(null);
  }
  
  public QQAnimationDrawable(QQAnimationDrawable.QQAnimationListener paramQQAnimationListener)
  {
    this.jdField_a_of_type_Int = -1;
    int k = this.jdField_b_of_type_Int;
    int j = k;
    if (k == 0) {
      j = 160;
    }
    this.jdField_b_of_type_Int = j;
    this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableQQAnimationDrawable$QQAnimationListener = paramQQAnimationListener;
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
    }
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
    int k = paramOptions.outHeight;
    int m = paramOptions.outWidth;
    if ((k <= paramInt2) && (m <= paramInt1)) {
      return 1;
    }
    int j = 2;
    for (;;)
    {
      if ((k / j <= paramInt2) && (m / j <= paramInt1)) {
        return j;
      }
      j *= 2;
    }
  }
  
  /* Error */
  @java.lang.Deprecated
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
    //   9: getfield 204	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   12: ifeq +25 -> 37
    //   15: new 206	java/io/BufferedInputStream
    //   18: dup
    //   19: new 208	java/io/FileInputStream
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 211	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   27: sipush 8192
    //   30: invokespecial 214	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   33: astore_0
    //   34: goto +19 -> 53
    //   37: new 206	java/io/BufferedInputStream
    //   40: dup
    //   41: new 208	java/io/FileInputStream
    //   44: dup
    //   45: aload_0
    //   46: invokespecial 211	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   49: invokespecial 217	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   52: astore_0
    //   53: aload_0
    //   54: astore_2
    //   55: aload_0
    //   56: aconst_null
    //   57: aload_1
    //   58: invokestatic 223	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   61: astore_1
    //   62: aload_0
    //   63: invokevirtual 228	java/io/InputStream:close	()V
    //   66: aload_1
    //   67: areturn
    //   68: astore_1
    //   69: goto +10 -> 79
    //   72: astore_0
    //   73: goto +49 -> 122
    //   76: astore_1
    //   77: aconst_null
    //   78: astore_0
    //   79: aload_0
    //   80: astore_2
    //   81: invokestatic 234	com/tencent/biz/richframework/delegate/impl/RFLog:isColorLevel	()Z
    //   84: ifeq +26 -> 110
    //   87: aload_0
    //   88: astore_2
    //   89: ldc 236
    //   91: getstatic 239	com/tencent/biz/richframework/delegate/impl/RFLog:CLR	I
    //   94: iconst_2
    //   95: anewarray 115	java/lang/Object
    //   98: dup
    //   99: iconst_0
    //   100: ldc 241
    //   102: aastore
    //   103: dup
    //   104: iconst_1
    //   105: aload_1
    //   106: aastore
    //   107: invokestatic 244	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   110: aload_0
    //   111: ifnull +8 -> 119
    //   114: aload_3
    //   115: astore_1
    //   116: goto -54 -> 62
    //   119: aconst_null
    //   120: areturn
    //   121: astore_0
    //   122: aload_2
    //   123: ifnull +7 -> 130
    //   126: aload_2
    //   127: invokevirtual 228	java/io/InputStream:close	()V
    //   130: goto +5 -> 135
    //   133: aload_0
    //   134: athrow
    //   135: goto -2 -> 133
    //   138: astore_0
    //   139: aload_1
    //   140: areturn
    //   141: astore_1
    //   142: goto -12 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	paramString	String
    //   0	145	1	paramOptions	BitmapFactory.Options
    //   1	126	2	str	String
    //   3	112	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   55	62	68	java/lang/Exception
    //   8	34	72	finally
    //   37	53	72	finally
    //   8	34	76	java/lang/Exception
    //   37	53	76	java/lang/Exception
    //   55	62	121	finally
    //   81	87	121	finally
    //   89	110	121	finally
    //   62	66	138	java/io/IOException
    //   126	130	141	java/io/IOException
  }
  
  private Bitmap a(boolean paramBoolean, int paramInt, Bitmap paramBitmap)
  {
    localObject = paramBitmap;
    long l;
    String str;
    label296:
    try
    {
      if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
      {
        localObject = paramBitmap;
        if (paramInt < this.jdField_a_of_type_ArrayOfJavaLangString.length)
        {
          l = System.currentTimeMillis();
          str = this.jdField_a_of_type_ArrayOfJavaLangString[paramInt];
          localObject = paramBitmap;
          if (str != null) {
            if (this.jdField_f_of_type_Boolean)
            {
              localObject = (SoftReference)this.jdField_a_of_type_JavaUtilHashMap.get(str);
              if ((localObject != null) && (((SoftReference)localObject).get() != null))
              {
                paramBitmap = (Bitmap)((SoftReference)localObject).get();
                return paramBitmap;
              }
              localBitmap = paramBitmap;
            }
          }
        }
      }
    }
    finally {}
    try
    {
      localObject = new BitmapFactory.Options();
      localBitmap = paramBitmap;
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      localBitmap = paramBitmap;
      ((BitmapFactory.Options)localObject).inTempStorage = jdField_a_of_type_ArrayOfByte;
      localBitmap = paramBitmap;
      BitmapFactory.decodeFile(str, (BitmapFactory.Options)localObject);
      localBitmap = paramBitmap;
      paramInt = a((BitmapFactory.Options)localObject, MobileQQ.sMobileQQ.getResources().getDisplayMetrics().widthPixels, MobileQQ.sMobileQQ.getResources().getDisplayMetrics().heightPixels);
      localBitmap = paramBitmap;
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      localBitmap = paramBitmap;
      ((BitmapFactory.Options)localObject).inSampleSize = paramInt;
      localBitmap = paramBitmap;
      if (Build.VERSION.SDK_INT >= 11)
      {
        localBitmap = paramBitmap;
        a((BitmapFactory.Options)localObject);
      }
      localBitmap = paramBitmap;
      paramBitmap = a(str, (BitmapFactory.Options)localObject);
      localObject = paramBitmap;
      if (paramBitmap == null) {
        break label296;
      }
      localObject = paramBitmap;
      localBitmap = paramBitmap;
      if (paramBitmap.isRecycled()) {
        break label296;
      }
      localObject = paramBitmap;
      localBitmap = paramBitmap;
      if (Build.VERSION.SDK_INT < 11) {
        break label296;
      }
      localBitmap = paramBitmap;
      this.jdField_a_of_type_JavaUtilSet.add(new SoftReference(paramBitmap));
      localObject = paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      localObject = localBitmap;
      break label296;
    }
    a(this.jdField_b_of_type_AndroidGraphicsBitmap, l, str);
    localObject = this.jdField_b_of_type_AndroidGraphicsBitmap;
    return localObject;
  }
  
  private void a(Bitmap paramBitmap, long paramLong, int paramInt)
  {
    if (paramBitmap == null) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inJustDecodeBounds = true;
      BitmapFactory.decodeResource(MobileQQ.sMobileQQ.getResources(), paramInt, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
      Bitmap.createBitmap(this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outWidth, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outHeight, Bitmap.Config.ARGB_8888);
      return;
    }
    catch (Exception paramBitmap)
    {
      if (!QLog.isDevelopLevel()) {
        break label195;
      }
      QLog.e("QQAnimationDrawable", 4, paramBitmap.getMessage());
      return;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      break label162;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inJustDecodeBounds = false;
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inBitmap = paramBitmap;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inSampleSize = 1;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inDensity = 320;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inTargetDensity = this.jdField_b_of_type_Int;
    BitmapFactory.decodeResource(MobileQQ.sMobileQQ.getResources(), paramInt, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
    if (QLog.isDevelopLevel())
    {
      paramBitmap = new StringBuilder();
      paramBitmap.append("getBitmapFromFile ");
      paramBitmap.append(System.currentTimeMillis() - paramLong);
      QLog.d("QQAnimationDrawable", 4, paramBitmap.toString());
      return;
      label162:
      if (QLog.isDevelopLevel())
      {
        QLog.e("QQAnimationDrawable", 4, "getBitmapFromFile OOM");
        return;
      }
    }
  }
  
  private void a(Bitmap paramBitmap, long paramLong, String paramString)
  {
    if (paramBitmap == null) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
      if (QLog.isDevelopLevel())
      {
        paramBitmap = new StringBuilder();
        paramBitmap.append("getBitmapFromFile ");
        paramBitmap.append(paramString);
        paramBitmap.append(" ");
        paramBitmap.append(this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outWidth);
        paramBitmap.append("——");
        paramBitmap.append(this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outHeight);
        QLog.d("QQAnimationDrawable", 4, paramBitmap.toString());
      }
      Bitmap.createBitmap(this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outWidth, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outHeight, Bitmap.Config.ARGB_8888);
      return;
    }
    catch (Exception paramBitmap)
    {
      if (!QLog.isDevelopLevel()) {
        break label262;
      }
      QLog.e("QQAnimationDrawable", 4, paramBitmap.getMessage());
      return;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      break label229;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inJustDecodeBounds = false;
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inBitmap = paramBitmap;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inSampleSize = 1;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inDensity = 320;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inTargetDensity = this.jdField_b_of_type_Int;
    BitmapFactory.decodeFile(paramString, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
    if (QLog.isDevelopLevel())
    {
      paramBitmap = new StringBuilder();
      paramBitmap.append("getBitmapFromFile ");
      paramBitmap.append(System.currentTimeMillis() - paramLong);
      QLog.d("QQAnimationDrawable", 4, paramBitmap.toString());
      return;
      label229:
      if (QLog.isDevelopLevel())
      {
        QLog.e("QQAnimationDrawable", 4, "getBitmapFromFile OOM");
        return;
      }
    }
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
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int k = this.jdField_a_of_type_Int + 1;
    int m = this.jdField_c_of_type_Int;
    boolean bool = false;
    int j = k;
    if (k >= m) {
      j = 0;
    }
    if (paramBoolean2) {
      unscheduleSelf(this);
    }
    if (((this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Int <= 0)) && (j >= this.jdField_c_of_type_Int - 1)) {
      paramBoolean2 = true;
    } else {
      paramBoolean2 = false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("animation QQAnimationDrawable loadNextBitmap  playEnd:");
    ((StringBuilder)localObject).append(paramBoolean2);
    ((StringBuilder)localObject).append(",mDecodeNextFrameEnd:");
    ((StringBuilder)localObject).append(this.jdField_e_of_type_Boolean);
    ((StringBuilder)localObject).append(",animate:");
    ((StringBuilder)localObject).append(paramBoolean3);
    QLog.d("QQAnimationDrawable", 4, ((StringBuilder)localObject).toString());
    if ((!paramBoolean2) && (this.jdField_e_of_type_Boolean) && (paramBoolean3))
    {
      this.jdField_e_of_type_Boolean = false;
      long l;
      if (paramBoolean1) {
        l = 0L;
      } else {
        l = SystemClock.uptimeMillis() + this.jdField_b_of_type_Long;
      }
      this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableQQAnimationDrawable$WorkerRunnable = new QQAnimationDrawable.WorkerRunnable(this, j, l);
      this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableQQAnimationDrawable$SerialExecutor.execute(this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableQQAnimationDrawable$WorkerRunnable);
    }
    if (paramBoolean2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("playEnd mCountOfFrame");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
      QLog.d("QQAnimationDrawable", 1, ((StringBuilder)localObject).toString());
      stop();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(hashCode());
      ((StringBuilder)localObject).append("playEnd listener");
      paramBoolean1 = bool;
      if (this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableQQAnimationDrawable$QQAnimationListener != null) {
        paramBoolean1 = true;
      }
      ((StringBuilder)localObject).append(String.valueOf(paramBoolean1));
      QLog.d("QQAnimationDrawable", 1, ((StringBuilder)localObject).toString());
      localObject = this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableQQAnimationDrawable$QQAnimationListener;
      if (localObject != null) {
        ((QQAnimationDrawable.QQAnimationListener)localObject).a();
      }
    }
  }
  
  @TargetApi(19)
  private static boolean a(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    int j = Build.VERSION.SDK_INT;
    boolean bool1 = false;
    boolean bool2 = false;
    if (j < 19)
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
  
  /* Error */
  private Bitmap b(boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_2
    //   3: aload_0
    //   4: getfield 102	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   7: invokevirtual 445	java/util/ArrayList:size	()I
    //   10: if_icmpge +26 -> 36
    //   13: aload_0
    //   14: getfield 102	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   17: iload_2
    //   18: invokevirtual 448	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   21: checkcast 267	android/graphics/Bitmap
    //   24: astore 9
    //   26: aload 9
    //   28: ifnull +8 -> 36
    //   31: aload_0
    //   32: monitorexit
    //   33: aload 9
    //   35: areturn
    //   36: invokestatic 256	java/lang/System:currentTimeMillis	()J
    //   39: lstore 7
    //   41: aload_0
    //   42: getfield 93	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   45: iconst_1
    //   46: putfield 204	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   49: aload_0
    //   50: getfield 450	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   53: aload_0
    //   54: getfield 93	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   57: invokestatic 273	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   60: pop
    //   61: aload_0
    //   62: getfield 93	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   65: getfield 194	android/graphics/BitmapFactory$Options:outWidth	I
    //   68: i2f
    //   69: aload_0
    //   70: getfield 452	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_g_of_type_Int	I
    //   73: i2f
    //   74: fconst_1
    //   75: fmul
    //   76: fdiv
    //   77: f2i
    //   78: istore 5
    //   80: aload_0
    //   81: getfield 93	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   84: getfield 191	android/graphics/BitmapFactory$Options:outHeight	I
    //   87: i2f
    //   88: aload_0
    //   89: getfield 454	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:h	I
    //   92: i2f
    //   93: fconst_1
    //   94: fmul
    //   95: fdiv
    //   96: f2i
    //   97: istore 6
    //   99: aload_0
    //   100: getfield 93	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   103: iconst_0
    //   104: putfield 204	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   107: aload_0
    //   108: getfield 93	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   111: sipush 320
    //   114: putfield 322	android/graphics/BitmapFactory$Options:inDensity	I
    //   117: aload_0
    //   118: getfield 93	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   121: aload_0
    //   122: getfield 88	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_b_of_type_Int	I
    //   125: putfield 325	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   128: aload_0
    //   129: getfield 450	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   132: aload_0
    //   133: getfield 93	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   136: invokestatic 273	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   139: astore 9
    //   141: iconst_0
    //   142: istore_3
    //   143: iload_3
    //   144: aload_0
    //   145: getfield 454	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:h	I
    //   148: if_icmpge +103 -> 251
    //   151: iconst_0
    //   152: istore 4
    //   154: iload 4
    //   156: aload_0
    //   157: getfield 452	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_g_of_type_Int	I
    //   160: if_icmpge +252 -> 412
    //   163: aload 9
    //   165: iload 4
    //   167: iload 5
    //   169: imul
    //   170: iload_3
    //   171: iload 6
    //   173: imul
    //   174: iload 5
    //   176: iload 6
    //   178: aconst_null
    //   179: iconst_1
    //   180: invokestatic 457	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   183: astore 10
    //   185: aload 10
    //   187: ifnull +216 -> 403
    //   190: invokestatic 330	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   193: ifeq +45 -> 238
    //   196: new 332	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 333	java/lang/StringBuilder:<init>	()V
    //   203: astore 11
    //   205: aload 11
    //   207: ldc_w 459
    //   210: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload 11
    //   216: iload_3
    //   217: bipush 8
    //   219: imul
    //   220: iload 4
    //   222: iadd
    //   223: invokevirtual 361	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: ldc 236
    //   229: iconst_4
    //   230: aload 11
    //   232: invokevirtual 346	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokestatic 349	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   238: aload_0
    //   239: getfield 102	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   242: aload 10
    //   244: invokevirtual 460	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   247: pop
    //   248: goto +155 -> 403
    //   251: aload 9
    //   253: ifnull +16 -> 269
    //   256: aload 9
    //   258: invokevirtual 292	android/graphics/Bitmap:isRecycled	()Z
    //   261: ifne +8 -> 269
    //   264: aload 9
    //   266: invokevirtual 463	android/graphics/Bitmap:recycle	()V
    //   269: aload_0
    //   270: aload_0
    //   271: getfield 102	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   274: invokevirtual 445	java/util/ArrayList:size	()I
    //   277: putfield 74	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_c_of_type_Int	I
    //   280: invokestatic 330	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   283: ifeq +84 -> 367
    //   286: new 332	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 333	java/lang/StringBuilder:<init>	()V
    //   293: astore 9
    //   295: aload 9
    //   297: ldc_w 465
    //   300: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload 9
    //   306: invokestatic 256	java/lang/System:currentTimeMillis	()J
    //   309: lload 7
    //   311: lsub
    //   312: invokevirtual 342	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: ldc 236
    //   318: iconst_4
    //   319: aload 9
    //   321: invokevirtual 346	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokestatic 349	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   327: goto +40 -> 367
    //   330: invokestatic 330	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   333: ifeq +34 -> 367
    //   336: ldc 236
    //   338: iconst_4
    //   339: ldc_w 351
    //   342: invokestatic 353	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   345: goto +22 -> 367
    //   348: astore 9
    //   350: invokestatic 330	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   353: ifeq +14 -> 367
    //   356: ldc 236
    //   358: iconst_4
    //   359: aload 9
    //   361: invokevirtual 356	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   364: invokestatic 353	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   367: aload_0
    //   368: getfield 102	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   371: iload_2
    //   372: invokevirtual 448	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   375: checkcast 267	android/graphics/Bitmap
    //   378: astore 9
    //   380: aload_0
    //   381: monitorexit
    //   382: aload 9
    //   384: areturn
    //   385: astore 9
    //   387: aload_0
    //   388: monitorexit
    //   389: goto +6 -> 395
    //   392: aload 9
    //   394: athrow
    //   395: goto -3 -> 392
    //   398: astore 9
    //   400: goto -70 -> 330
    //   403: iload 4
    //   405: iconst_1
    //   406: iadd
    //   407: istore 4
    //   409: goto -255 -> 154
    //   412: iload_3
    //   413: iconst_1
    //   414: iadd
    //   415: istore_3
    //   416: goto -273 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	419	0	this	QQAnimationDrawable
    //   0	419	1	paramBoolean	boolean
    //   0	419	2	paramInt	int
    //   142	274	3	j	int
    //   152	256	4	k	int
    //   78	97	5	m	int
    //   97	80	6	n	int
    //   39	271	7	l	long
    //   24	296	9	localObject1	Object
    //   348	12	9	localException	Exception
    //   378	5	9	localBitmap1	Bitmap
    //   385	8	9	localObject2	Object
    //   398	1	9	localOutOfMemoryError	OutOfMemoryError
    //   183	60	10	localBitmap2	Bitmap
    //   203	28	11	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   36	141	348	java/lang/Exception
    //   143	151	348	java/lang/Exception
    //   154	185	348	java/lang/Exception
    //   190	238	348	java/lang/Exception
    //   238	248	348	java/lang/Exception
    //   256	269	348	java/lang/Exception
    //   269	327	348	java/lang/Exception
    //   2	26	385	finally
    //   36	141	385	finally
    //   143	151	385	finally
    //   154	185	385	finally
    //   190	238	385	finally
    //   238	248	385	finally
    //   256	269	385	finally
    //   269	327	385	finally
    //   330	345	385	finally
    //   350	367	385	finally
    //   367	380	385	finally
    //   36	141	398	java/lang/OutOfMemoryError
    //   143	151	398	java/lang/OutOfMemoryError
    //   154	185	398	java/lang/OutOfMemoryError
    //   190	238	398	java/lang/OutOfMemoryError
    //   238	248	398	java/lang/OutOfMemoryError
    //   256	269	398	java/lang/OutOfMemoryError
    //   269	327	398	java/lang/OutOfMemoryError
  }
  
  private Bitmap b(boolean paramBoolean, int paramInt, Bitmap paramBitmap)
  {
    Object localObject = paramBitmap;
    long l;
    label148:
    try
    {
      if (this.jdField_a_of_type_ArrayOfInt != null)
      {
        localObject = paramBitmap;
        if (paramInt < this.jdField_a_of_type_ArrayOfInt.length)
        {
          l = System.currentTimeMillis();
          paramInt = this.jdField_a_of_type_ArrayOfInt[paramInt];
          localObject = paramBitmap;
          if (paramInt > 0) {
            if (this.jdField_f_of_type_Boolean)
            {
              localObject = (SoftReference)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
              if ((localObject != null) && (((SoftReference)localObject).get() != null))
              {
                paramBitmap = (Bitmap)((SoftReference)localObject).get();
                return paramBitmap;
              }
            }
          }
        }
      }
    }
    finally {}
    try
    {
      localObject = BitmapFactory.decodeResource(MobileQQ.sMobileQQ.getResources(), paramInt);
      paramBitmap = (Bitmap)localObject;
      this.jdField_a_of_type_JavaUtilHashMap.put(String.valueOf(paramInt), new SoftReference(localObject));
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Bitmap localBitmap = paramBitmap;
      break label148;
    }
    a(this.jdField_b_of_type_AndroidGraphicsBitmap, l, paramInt);
    localObject = this.jdField_b_of_type_AndroidGraphicsBitmap;
    return localObject;
  }
  
  private void e()
  {
    long l2 = this.jdField_b_of_type_Long;
    long l1 = 0L;
    if (l2 == 0L)
    {
      int j = this.i;
      if (j != 0) {
        l1 = this.jdField_a_of_type_Long / j;
      }
      this.jdField_b_of_type_Long = l1;
      return;
    }
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = (l2 * this.i);
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
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
  
  Bitmap a(boolean paramBoolean, int paramInt)
  {
    int j = this.jdField_f_of_type_Int;
    Bitmap localBitmap = null;
    if (j == 0) {
      localBitmap = a(paramBoolean, paramInt, null);
    } else if (j == 2) {
      localBitmap = b(paramBoolean, paramInt, null);
    } else if (j == 1) {
      localBitmap = b(paramBoolean, paramInt);
    }
    if (localBitmap == null) {
      return this.jdField_b_of_type_AndroidGraphicsBitmap;
    }
    return localBitmap;
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQAnimationDrawable", 4, " reset");
    }
    this.jdField_d_of_type_Int = 1;
    this.jdField_a_of_type_Int = -1;
    this.jdField_e_of_type_Int = 0;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    this.jdField_c_of_type_AndroidGraphicsBitmap = null;
    b();
  }
  
  public void a(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    e();
  }
  
  public void a(String[] paramArrayOfString)
  {
    a(0);
    if (!Arrays.equals(this.jdField_a_of_type_ArrayOfJavaLangString, paramArrayOfString))
    {
      d();
      this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    }
    String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    if (arrayOfString != null) {
      this.jdField_c_of_type_Int = arrayOfString.length;
    } else {
      this.jdField_c_of_type_Int = 0;
    }
    this.i = paramArrayOfString.length;
    e();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableQQAnimationDrawable$SerialExecutor != null) {
      this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableQQAnimationDrawable$SerialExecutor.b();
    }
    FutureTask localFutureTask = this.jdField_a_of_type_JavaUtilConcurrentFutureTask;
    if (localFutureTask != null) {
      localFutureTask.cancel(true);
    }
  }
  
  public void c() {}
  
  public void d()
  {
    try
    {
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      if ((this.jdField_c_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_c_of_type_AndroidGraphicsBitmap.isRecycled())) {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_c_of_type_AndroidGraphicsBitmap.recycle();
        }
      }
      if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled())) {
        this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
      }
      Object localObject4;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        ??? = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)???).hasNext())
        {
          localObject4 = (Bitmap)((Iterator)???).next();
          if ((localObject4 != null) && (!((Bitmap)localObject4).isRecycled())) {
            ((Bitmap)localObject4).recycle();
          }
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      if (this.jdField_a_of_type_JavaUtilHashMap != null)
      {
        ??? = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        while (((Iterator)???).hasNext())
        {
          localObject4 = (String)((Iterator)???).next();
          localObject4 = (SoftReference)this.jdField_a_of_type_JavaUtilHashMap.get(localObject4);
          if (localObject4 != null)
          {
            localObject4 = (Bitmap)((SoftReference)localObject4).get();
            if ((localObject4 != null) && (!((Bitmap)localObject4).isRecycled())) {
              ((Bitmap)localObject4).recycle();
            }
          }
        }
        this.jdField_a_of_type_JavaUtilHashMap.clear();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("animation QQAnimationDrawable draw  currentBitmap == null ");
    boolean bool;
    if (this.jdField_c_of_type_AndroidGraphicsBitmap == null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)???).append(bool);
    QLog.d("QQAnimationDrawable", 4, ((StringBuilder)???).toString());
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_c_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_c_of_type_AndroidGraphicsBitmap.isRecycled())) {
        paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, null, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      a(false, false, true);
      return;
    }
  }
  
  public int getIntrinsicHeight()
  {
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap != null) {
      return localBitmap.getScaledHeight(this.jdField_b_of_type_Int);
    }
    return super.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap != null) {
      return localBitmap.getScaledWidth(this.jdField_b_of_type_Int);
    }
    return super.getIntrinsicWidth();
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public boolean isRunning()
  {
    return this.jdField_a_of_type_Int > -1;
  }
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(hashCode());
    ((StringBuilder)localObject).append("animation QQAnimationDrawable run time:");
    ((StringBuilder)localObject).append(SystemClock.uptimeMillis());
    ((StringBuilder)localObject).append(",mCurFrame:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append("nextFrame:");
    ((StringBuilder)localObject).append(this.jdField_e_of_type_Int);
    ((StringBuilder)localObject).append(" main:");
    boolean bool;
    if (Looper.myLooper() == Looper.getMainLooper()) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    QLog.d("QQAnimationDrawable", 4, ((StringBuilder)localObject).toString());
    if (!this.jdField_g_of_type_Boolean) {
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isParenMethod:");
    ((StringBuilder)localObject).append(this.jdField_d_of_type_Boolean);
    QLog.d("QQAnimationDrawable", 4, ((StringBuilder)localObject).toString());
    if ((!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_Int == a() - 1)) {
      this.jdField_d_of_type_Int -= 1;
    }
    this.jdField_e_of_type_Boolean = true;
    localObject = this.jdField_b_of_type_AndroidGraphicsBitmap;
    if (localObject != null) {
      this.jdField_c_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mRepeatCount:");
    ((StringBuilder)localObject).append(this.jdField_d_of_type_Int);
    QLog.d("QQAnimationDrawable", 4, ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_Int == -1)
    {
      localObject = this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableQQAnimationDrawable$QQAnimationListener;
      if (localObject != null) {
        ((QQAnimationDrawable.QQAnimationListener)localObject).b();
      }
    }
    this.jdField_a_of_type_Int = this.jdField_e_of_type_Int;
    invalidateSelf();
  }
  
  public void setAlpha(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(paramBoolean);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (paramBoolean1)
    {
      if ((bool) || (paramBoolean2))
      {
        c();
        return bool;
      }
    }
    else {
      unscheduleSelf(this);
    }
    return bool;
  }
  
  public void start()
  {
    this.jdField_g_of_type_Boolean = true;
    if (this.jdField_c_of_type_Int > 0)
    {
      if (this.jdField_b_of_type_Long <= 0L) {
        return;
      }
      if (!isRunning())
      {
        this.jdField_e_of_type_Boolean = true;
        a(true, false, true);
      }
    }
  }
  
  public void stop()
  {
    this.jdField_g_of_type_Boolean = false;
    QLog.d("QQAnimationDrawable", 4, " stop");
    if (isRunning()) {
      unscheduleSelf(this);
    }
    if (!this.jdField_d_of_type_Boolean) {
      this.jdField_d_of_type_Int = 1;
    }
    a();
  }
  
  public void unscheduleSelf(Runnable paramRunnable)
  {
    this.jdField_a_of_type_Int = -1;
    super.unscheduleSelf(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */