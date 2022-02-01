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
    if (this.jdField_b_of_type_Int == 0) {}
    for (;;)
    {
      this.jdField_b_of_type_Int = j;
      this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableQQAnimationDrawable$QQAnimationListener = paramQQAnimationListener;
      if (Build.VERSION.SDK_INT >= 11) {
        this.jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
      }
      return;
      j = this.jdField_b_of_type_Int;
    }
  }
  
  private static int a(Bitmap.Config paramConfig)
  {
    int k = 2;
    int j;
    if (paramConfig == Bitmap.Config.ARGB_8888) {
      j = 4;
    }
    do
    {
      do
      {
        return j;
        j = k;
      } while (paramConfig == Bitmap.Config.RGB_565);
      j = k;
    } while (paramConfig == Bitmap.Config.ARGB_4444);
    if (paramConfig == Bitmap.Config.ALPHA_8) {
      return 1;
    }
    return 1;
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int m = paramOptions.outHeight;
    int n = paramOptions.outWidth;
    int k = 1;
    if ((m > paramInt2) || (n > paramInt1))
    {
      int j = 2;
      for (;;)
      {
        if (m / j <= paramInt2)
        {
          k = j;
          if (n / j <= paramInt1) {
            break;
          }
        }
        j *= 2;
      }
    }
    return k;
  }
  
  /* Error */
  @java.lang.Deprecated
  public static Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: ifnull +52 -> 55
    //   6: aload_1
    //   7: getfield 204	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   10: ifeq +45 -> 55
    //   13: new 206	java/io/BufferedInputStream
    //   16: dup
    //   17: new 208	java/io/FileInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 211	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   25: sipush 8192
    //   28: invokespecial 214	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   31: astore_0
    //   32: aload_0
    //   33: astore_2
    //   34: aload_0
    //   35: aconst_null
    //   36: aload_1
    //   37: invokestatic 220	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   40: astore_1
    //   41: aload_1
    //   42: astore_2
    //   43: aload_0
    //   44: ifnull +9 -> 53
    //   47: aload_0
    //   48: invokevirtual 225	java/io/InputStream:close	()V
    //   51: aload_1
    //   52: astore_2
    //   53: aload_2
    //   54: areturn
    //   55: new 206	java/io/BufferedInputStream
    //   58: dup
    //   59: new 208	java/io/FileInputStream
    //   62: dup
    //   63: aload_0
    //   64: invokespecial 211	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   67: invokespecial 228	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   70: astore_0
    //   71: goto -39 -> 32
    //   74: astore_1
    //   75: aconst_null
    //   76: astore_0
    //   77: aload_0
    //   78: astore_2
    //   79: invokestatic 234	com/tencent/biz/richframework/delegate/impl/RFLog:isColorLevel	()Z
    //   82: ifeq +26 -> 108
    //   85: aload_0
    //   86: astore_2
    //   87: ldc 236
    //   89: getstatic 239	com/tencent/biz/richframework/delegate/impl/RFLog:CLR	I
    //   92: iconst_2
    //   93: anewarray 115	java/lang/Object
    //   96: dup
    //   97: iconst_0
    //   98: ldc 241
    //   100: aastore
    //   101: dup
    //   102: iconst_1
    //   103: aload_1
    //   104: aastore
    //   105: invokestatic 244	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   108: aload_3
    //   109: astore_2
    //   110: aload_0
    //   111: ifnull -58 -> 53
    //   114: aload_0
    //   115: invokevirtual 225	java/io/InputStream:close	()V
    //   118: aconst_null
    //   119: areturn
    //   120: astore_0
    //   121: aconst_null
    //   122: areturn
    //   123: astore_0
    //   124: aconst_null
    //   125: astore_2
    //   126: aload_2
    //   127: ifnull +7 -> 134
    //   130: aload_2
    //   131: invokevirtual 225	java/io/InputStream:close	()V
    //   134: aload_0
    //   135: athrow
    //   136: astore_0
    //   137: aload_1
    //   138: areturn
    //   139: astore_1
    //   140: goto -6 -> 134
    //   143: astore_0
    //   144: goto -18 -> 126
    //   147: astore_1
    //   148: goto -71 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	paramString	String
    //   0	151	1	paramOptions	BitmapFactory.Options
    //   33	98	2	localObject1	Object
    //   1	108	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   6	32	74	java/lang/Exception
    //   55	71	74	java/lang/Exception
    //   114	118	120	java/io/IOException
    //   6	32	123	finally
    //   55	71	123	finally
    //   47	51	136	java/io/IOException
    //   130	134	139	java/io/IOException
    //   34	41	143	finally
    //   79	85	143	finally
    //   87	108	143	finally
    //   34	41	147	java/lang/Exception
  }
  
  private Bitmap a(boolean paramBoolean, int paramInt, Bitmap paramBitmap)
  {
    Object localObject = paramBitmap;
    long l;
    String str;
    label240:
    label249:
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
          if (str != null)
          {
            if (!this.jdField_f_of_type_Boolean) {
              break label249;
            }
            localObject = (SoftReference)this.jdField_a_of_type_JavaUtilHashMap.get(str);
            if ((localObject != null) && (((SoftReference)localObject).get() != null))
            {
              paramBitmap = (Bitmap)((SoftReference)localObject).get();
              return paramBitmap;
            }
          }
        }
      }
    }
    finally {}
    try
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      ((BitmapFactory.Options)localObject).inTempStorage = jdField_a_of_type_ArrayOfByte;
      BitmapFactory.decodeFile(str, (BitmapFactory.Options)localObject);
      paramInt = a((BitmapFactory.Options)localObject, MobileQQ.sMobileQQ.getResources().getDisplayMetrics().widthPixels, MobileQQ.sMobileQQ.getResources().getDisplayMetrics().heightPixels);
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      ((BitmapFactory.Options)localObject).inSampleSize = paramInt;
      if (Build.VERSION.SDK_INT >= 11) {
        a((BitmapFactory.Options)localObject);
      }
      localObject = a(str, (BitmapFactory.Options)localObject);
      paramBitmap = (Bitmap)localObject;
      if (localObject != null) {
        paramBitmap = (Bitmap)localObject;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      break label240;
    }
    try
    {
      if (!((Bitmap)localObject).isRecycled())
      {
        paramBitmap = (Bitmap)localObject;
        if (Build.VERSION.SDK_INT >= 11)
        {
          this.jdField_a_of_type_JavaUtilSet.add(new SoftReference(localObject));
          paramBitmap = (Bitmap)localObject;
        }
      }
    }
    catch (OutOfMemoryError paramBitmap)
    {
      paramBitmap = localOutOfMemoryError;
      break label240;
    }
    for (localObject = paramBitmap;; localObject = this.jdField_b_of_type_AndroidGraphicsBitmap)
    {
      paramBitmap = (Bitmap)localObject;
      break;
      a(this.jdField_b_of_type_AndroidGraphicsBitmap, l, str);
    }
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
        return;
      }
      QLog.e("QQAnimationDrawable", 4, paramBitmap.getMessage());
      return;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      if (!QLog.isDevelopLevel()) {
        return;
      }
      QLog.e("QQAnimationDrawable", 4, "getBitmapFromFile OOM");
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
      QLog.d("QQAnimationDrawable", 4, "getBitmapFromFile " + (System.currentTimeMillis() - paramLong));
      return;
    }
  }
  
  private void a(Bitmap paramBitmap, long paramLong, String paramString)
  {
    if (paramBitmap == null) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
      if (QLog.isDevelopLevel()) {
        QLog.d("QQAnimationDrawable", 4, "getBitmapFromFile " + paramString + " " + this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outWidth + "——" + this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outHeight);
      }
      Bitmap.createBitmap(this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outWidth, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outHeight, Bitmap.Config.ARGB_8888);
      return;
    }
    catch (Exception paramBitmap)
    {
      if (!QLog.isDevelopLevel()) {
        return;
      }
      QLog.e("QQAnimationDrawable", 4, paramBitmap.getMessage());
      return;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      if (!QLog.isDevelopLevel()) {
        return;
      }
      QLog.e("QQAnimationDrawable", 4, "getBitmapFromFile OOM");
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
      QLog.d("QQAnimationDrawable", 4, "getBitmapFromFile " + (System.currentTimeMillis() - paramLong));
      return;
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
    boolean bool = false;
    int j = this.jdField_a_of_type_Int + 1;
    if (j >= this.jdField_c_of_type_Int) {
      j = 0;
    }
    for (;;)
    {
      if (paramBoolean2) {
        unscheduleSelf(this);
      }
      if (((this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Int <= 0)) && (j >= this.jdField_c_of_type_Int - 1))
      {
        paramBoolean2 = true;
        QLog.d("QQAnimationDrawable", 4, "animation QQAnimationDrawable loadNextBitmap  playEnd:" + paramBoolean2 + ",mDecodeNextFrameEnd:" + this.jdField_e_of_type_Boolean + ",animate:" + paramBoolean3);
        if ((!paramBoolean2) && (this.jdField_e_of_type_Boolean) && (paramBoolean3))
        {
          this.jdField_e_of_type_Boolean = false;
          if (!paramBoolean1) {
            break label273;
          }
        }
      }
      label273:
      for (long l = 0L;; l = SystemClock.uptimeMillis() + this.jdField_b_of_type_Long)
      {
        this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableQQAnimationDrawable$WorkerRunnable = new QQAnimationDrawable.WorkerRunnable(this, j, l);
        this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableQQAnimationDrawable$SerialExecutor.execute(this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableQQAnimationDrawable$WorkerRunnable);
        if (paramBoolean2)
        {
          QLog.d("QQAnimationDrawable", 1, "playEnd mCountOfFrame" + this.jdField_c_of_type_Int);
          stop();
          StringBuilder localStringBuilder = new StringBuilder().append(hashCode()).append("playEnd listener");
          paramBoolean1 = bool;
          if (this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableQQAnimationDrawable$QQAnimationListener != null) {
            paramBoolean1 = true;
          }
          QLog.d("QQAnimationDrawable", 1, String.valueOf(paramBoolean1));
          if (this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableQQAnimationDrawable$QQAnimationListener != null) {
            this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableQQAnimationDrawable$QQAnimationListener.a();
          }
        }
        return;
        paramBoolean2 = false;
        break;
      }
    }
  }
  
  @TargetApi(19)
  private static boolean a(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    if (Build.VERSION.SDK_INT < 19) {
      if ((paramBitmap.getWidth() != paramOptions.outWidth) || (paramBitmap.getHeight() != paramOptions.outHeight) || (paramOptions.inSampleSize != 1)) {}
    }
    while (paramOptions.outWidth / paramOptions.inSampleSize * (paramOptions.outHeight / paramOptions.inSampleSize) * a(paramBitmap.getConfig()) <= paramBitmap.getAllocationByteCount())
    {
      return true;
      return false;
    }
    return false;
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
    //   148: if_icmpge +93 -> 241
    //   151: iconst_0
    //   152: istore 4
    //   154: iload 4
    //   156: aload_0
    //   157: getfield 452	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_g_of_type_Int	I
    //   160: if_icmpge +221 -> 381
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
    //   187: ifnull +185 -> 372
    //   190: invokestatic 330	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   193: ifeq +35 -> 228
    //   196: ldc 236
    //   198: iconst_4
    //   199: new 332	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 333	java/lang/StringBuilder:<init>	()V
    //   206: ldc_w 459
    //   209: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: iload_3
    //   213: bipush 8
    //   215: imul
    //   216: iload 4
    //   218: iadd
    //   219: invokevirtual 361	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   222: invokevirtual 346	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 349	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   228: aload_0
    //   229: getfield 102	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   232: aload 10
    //   234: invokevirtual 460	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   237: pop
    //   238: goto +134 -> 372
    //   241: aload 9
    //   243: ifnull +16 -> 259
    //   246: aload 9
    //   248: invokevirtual 292	android/graphics/Bitmap:isRecycled	()Z
    //   251: ifne +8 -> 259
    //   254: aload 9
    //   256: invokevirtual 463	android/graphics/Bitmap:recycle	()V
    //   259: aload_0
    //   260: aload_0
    //   261: getfield 102	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   264: invokevirtual 445	java/util/ArrayList:size	()I
    //   267: putfield 74	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_c_of_type_Int	I
    //   270: invokestatic 330	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   273: ifeq +34 -> 307
    //   276: ldc 236
    //   278: iconst_4
    //   279: new 332	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 333	java/lang/StringBuilder:<init>	()V
    //   286: ldc_w 465
    //   289: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokestatic 256	java/lang/System:currentTimeMillis	()J
    //   295: lload 7
    //   297: lsub
    //   298: invokevirtual 342	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   301: invokevirtual 346	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 349	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: aload_0
    //   308: getfield 102	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   311: iload_2
    //   312: invokevirtual 448	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   315: checkcast 267	android/graphics/Bitmap
    //   318: astore 9
    //   320: goto -289 -> 31
    //   323: astore 9
    //   325: invokestatic 330	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   328: ifeq -21 -> 307
    //   331: ldc 236
    //   333: iconst_4
    //   334: aload 9
    //   336: invokevirtual 352	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   339: invokestatic 354	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   342: goto -35 -> 307
    //   345: astore 9
    //   347: aload_0
    //   348: monitorexit
    //   349: aload 9
    //   351: athrow
    //   352: astore 9
    //   354: invokestatic 330	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   357: ifeq -50 -> 307
    //   360: ldc 236
    //   362: iconst_4
    //   363: ldc_w 356
    //   366: invokestatic 354	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   369: goto -62 -> 307
    //   372: iload 4
    //   374: iconst_1
    //   375: iadd
    //   376: istore 4
    //   378: goto -224 -> 154
    //   381: iload_3
    //   382: iconst_1
    //   383: iadd
    //   384: istore_3
    //   385: goto -242 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	388	0	this	QQAnimationDrawable
    //   0	388	1	paramBoolean	boolean
    //   0	388	2	paramInt	int
    //   142	243	3	j	int
    //   152	225	4	k	int
    //   78	97	5	m	int
    //   97	80	6	n	int
    //   39	257	7	l	long
    //   24	295	9	localBitmap1	Bitmap
    //   323	12	9	localException	Exception
    //   345	5	9	localObject	Object
    //   352	1	9	localOutOfMemoryError	OutOfMemoryError
    //   183	50	10	localBitmap2	Bitmap
    // Exception table:
    //   from	to	target	type
    //   36	141	323	java/lang/Exception
    //   143	151	323	java/lang/Exception
    //   154	185	323	java/lang/Exception
    //   190	228	323	java/lang/Exception
    //   228	238	323	java/lang/Exception
    //   246	259	323	java/lang/Exception
    //   259	307	323	java/lang/Exception
    //   2	26	345	finally
    //   36	141	345	finally
    //   143	151	345	finally
    //   154	185	345	finally
    //   190	228	345	finally
    //   228	238	345	finally
    //   246	259	345	finally
    //   259	307	345	finally
    //   307	320	345	finally
    //   325	342	345	finally
    //   354	369	345	finally
    //   36	141	352	java/lang/OutOfMemoryError
    //   143	151	352	java/lang/OutOfMemoryError
    //   154	185	352	java/lang/OutOfMemoryError
    //   190	228	352	java/lang/OutOfMemoryError
    //   228	238	352	java/lang/OutOfMemoryError
    //   246	259	352	java/lang/OutOfMemoryError
    //   259	307	352	java/lang/OutOfMemoryError
  }
  
  /* Error */
  private Bitmap b(boolean paramBoolean, int paramInt, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_3
    //   3: astore 6
    //   5: aload_0
    //   6: getfield 467	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_a_of_type_ArrayOfInt	[I
    //   9: ifnull +121 -> 130
    //   12: aload_3
    //   13: astore 6
    //   15: iload_2
    //   16: aload_0
    //   17: getfield 467	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_a_of_type_ArrayOfInt	[I
    //   20: arraylength
    //   21: if_icmpge +109 -> 130
    //   24: invokestatic 256	java/lang/System:currentTimeMillis	()J
    //   27: lstore 4
    //   29: aload_0
    //   30: getfield 467	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_a_of_type_ArrayOfInt	[I
    //   33: iload_2
    //   34: iaload
    //   35: istore_2
    //   36: aload_3
    //   37: astore 6
    //   39: iload_2
    //   40: ifle +90 -> 130
    //   43: aload_0
    //   44: getfield 97	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_f_of_type_Boolean	Z
    //   47: ifeq +89 -> 136
    //   50: aload_0
    //   51: getfield 107	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   54: iload_2
    //   55: invokestatic 472	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   58: invokevirtual 260	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   61: checkcast 262	java/lang/ref/SoftReference
    //   64: astore 6
    //   66: aload 6
    //   68: ifnull +24 -> 92
    //   71: aload 6
    //   73: invokevirtual 265	java/lang/ref/SoftReference:get	()Ljava/lang/Object;
    //   76: ifnull +16 -> 92
    //   79: aload 6
    //   81: invokevirtual 265	java/lang/ref/SoftReference:get	()Ljava/lang/Object;
    //   84: checkcast 267	android/graphics/Bitmap
    //   87: astore_3
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_3
    //   91: areturn
    //   92: getstatic 138	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   95: invokevirtual 142	mqq/app/MobileQQ:getResources	()Landroid/content/res/Resources;
    //   98: iload_2
    //   99: invokestatic 475	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   102: astore 6
    //   104: aload 6
    //   106: astore_3
    //   107: aload_0
    //   108: getfield 107	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   111: iload_2
    //   112: invokestatic 478	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   115: new 262	java/lang/ref/SoftReference
    //   118: dup
    //   119: aload_3
    //   120: invokespecial 295	java/lang/ref/SoftReference:<init>	(Ljava/lang/Object;)V
    //   123: invokevirtual 482	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   126: pop
    //   127: aload_3
    //   128: astore 6
    //   130: aload 6
    //   132: astore_3
    //   133: goto -45 -> 88
    //   136: aload_0
    //   137: aload_0
    //   138: getfield 303	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   141: lload 4
    //   143: iload_2
    //   144: invokespecial 484	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:a	(Landroid/graphics/Bitmap;JI)V
    //   147: aload_0
    //   148: getfield 303	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   151: astore 6
    //   153: goto -23 -> 130
    //   156: astore_3
    //   157: aload_0
    //   158: monitorexit
    //   159: aload_3
    //   160: athrow
    //   161: astore 6
    //   163: goto -36 -> 127
    //   166: astore 6
    //   168: goto -41 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	QQAnimationDrawable
    //   0	171	1	paramBoolean	boolean
    //   0	171	2	paramInt	int
    //   0	171	3	paramBitmap	Bitmap
    //   27	115	4	l	long
    //   3	149	6	localObject	Object
    //   161	1	6	localOutOfMemoryError1	OutOfMemoryError
    //   166	1	6	localOutOfMemoryError2	OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   5	12	156	finally
    //   15	36	156	finally
    //   43	66	156	finally
    //   71	88	156	finally
    //   92	104	156	finally
    //   107	127	156	finally
    //   136	153	156	finally
    //   92	104	161	java/lang/OutOfMemoryError
    //   107	127	166	java/lang/OutOfMemoryError
  }
  
  private void e()
  {
    long l = 0L;
    if (this.jdField_b_of_type_Long == 0L) {
      if (this.i == 0) {
        this.jdField_b_of_type_Long = l;
      }
    }
    while (this.jdField_a_of_type_Long != 0L) {
      for (;;)
      {
        return;
        l = this.jdField_a_of_type_Long / this.i;
      }
    }
    this.jdField_a_of_type_Long = (this.jdField_b_of_type_Long * this.i);
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  protected Bitmap a(BitmapFactory.Options paramOptions)
  {
    if ((this.jdField_a_of_type_JavaUtilSet != null) && (!this.jdField_a_of_type_JavaUtilSet.isEmpty())) {
      for (;;)
      {
        synchronized (this.jdField_a_of_type_JavaUtilSet)
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
          if (localIterator.hasNext())
          {
            Bitmap localBitmap = (Bitmap)((SoftReference)localIterator.next()).get();
            if ((localBitmap != null) && (localBitmap.isMutable()))
            {
              if (!a(localBitmap, paramOptions)) {
                continue;
              }
              localIterator.remove();
              paramOptions = localBitmap;
              return paramOptions;
            }
            localIterator.remove();
          }
        }
        paramOptions = null;
      }
    }
    return null;
  }
  
  Bitmap a(boolean paramBoolean, int paramInt)
  {
    Bitmap localBitmap1 = null;
    if (this.jdField_f_of_type_Int == 0) {
      localBitmap1 = a(paramBoolean, paramInt, null);
    }
    for (;;)
    {
      Bitmap localBitmap2 = localBitmap1;
      if (localBitmap1 == null) {
        localBitmap2 = this.jdField_b_of_type_AndroidGraphicsBitmap;
      }
      return localBitmap2;
      if (this.jdField_f_of_type_Int == 2) {
        localBitmap1 = b(paramBoolean, paramInt, null);
      } else if (this.jdField_f_of_type_Int == 1) {
        localBitmap1 = b(paramBoolean, paramInt);
      }
    }
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
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null) {}
    for (this.jdField_c_of_type_Int = this.jdField_a_of_type_ArrayOfJavaLangString.length;; this.jdField_c_of_type_Int = 0)
    {
      this.i = paramArrayOfString.length;
      e();
      return;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableQQAnimationDrawable$SerialExecutor != null) {
      this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableQQAnimationDrawable$SerialExecutor.b();
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentFutureTask != null) {
      this.jdField_a_of_type_JavaUtilConcurrentFutureTask.cancel(true);
    }
  }
  
  public void c() {}
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 546	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   6: ifnull +20 -> 26
    //   9: aload_0
    //   10: getfield 546	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   13: invokevirtual 292	android/graphics/Bitmap:isRecycled	()Z
    //   16: ifne +10 -> 26
    //   19: aload_0
    //   20: getfield 546	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   23: invokevirtual 463	android/graphics/Bitmap:recycle	()V
    //   26: aload_0
    //   27: getfield 519	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_c_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   30: ifnull +29 -> 59
    //   33: aload_0
    //   34: getfield 519	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_c_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   37: invokevirtual 292	android/graphics/Bitmap:isRecycled	()Z
    //   40: ifne +19 -> 59
    //   43: aload_0
    //   44: getfield 118	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   47: astore_1
    //   48: aload_1
    //   49: monitorenter
    //   50: aload_0
    //   51: getfield 519	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_c_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   54: invokevirtual 463	android/graphics/Bitmap:recycle	()V
    //   57: aload_1
    //   58: monitorexit
    //   59: aload_0
    //   60: getfield 303	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   63: ifnull +20 -> 83
    //   66: aload_0
    //   67: getfield 303	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   70: invokevirtual 292	android/graphics/Bitmap:isRecycled	()Z
    //   73: ifne +10 -> 83
    //   76: aload_0
    //   77: getfield 303	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   80: invokevirtual 463	android/graphics/Bitmap:recycle	()V
    //   83: aload_0
    //   84: getfield 102	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   87: ifnull +65 -> 152
    //   90: aload_0
    //   91: getfield 102	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   94: invokevirtual 547	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   97: astore_1
    //   98: aload_1
    //   99: invokeinterface 498 1 0
    //   104: ifeq +41 -> 145
    //   107: aload_1
    //   108: invokeinterface 501 1 0
    //   113: checkcast 267	android/graphics/Bitmap
    //   116: astore_2
    //   117: aload_2
    //   118: ifnull -20 -> 98
    //   121: aload_2
    //   122: invokevirtual 292	android/graphics/Bitmap:isRecycled	()Z
    //   125: ifne -27 -> 98
    //   128: aload_2
    //   129: invokevirtual 463	android/graphics/Bitmap:recycle	()V
    //   132: goto -34 -> 98
    //   135: astore_1
    //   136: aload_0
    //   137: monitorexit
    //   138: aload_1
    //   139: athrow
    //   140: astore_2
    //   141: aload_1
    //   142: monitorexit
    //   143: aload_2
    //   144: athrow
    //   145: aload_0
    //   146: getfield 102	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   149: invokevirtual 550	java/util/ArrayList:clear	()V
    //   152: aload_0
    //   153: getfield 107	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   156: ifnull +84 -> 240
    //   159: aload_0
    //   160: getfield 107	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   163: invokevirtual 554	java/util/HashMap:keySet	()Ljava/util/Set;
    //   166: invokeinterface 493 1 0
    //   171: astore_1
    //   172: aload_1
    //   173: invokeinterface 498 1 0
    //   178: ifeq +55 -> 233
    //   181: aload_1
    //   182: invokeinterface 501 1 0
    //   187: checkcast 409	java/lang/String
    //   190: astore_2
    //   191: aload_0
    //   192: getfield 107	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   195: aload_2
    //   196: invokevirtual 260	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   199: checkcast 262	java/lang/ref/SoftReference
    //   202: astore_2
    //   203: aload_2
    //   204: ifnull -32 -> 172
    //   207: aload_2
    //   208: invokevirtual 265	java/lang/ref/SoftReference:get	()Ljava/lang/Object;
    //   211: checkcast 267	android/graphics/Bitmap
    //   214: astore_2
    //   215: aload_2
    //   216: ifnull -44 -> 172
    //   219: aload_2
    //   220: invokevirtual 292	android/graphics/Bitmap:isRecycled	()Z
    //   223: ifne -51 -> 172
    //   226: aload_2
    //   227: invokevirtual 463	android/graphics/Bitmap:recycle	()V
    //   230: goto -58 -> 172
    //   233: aload_0
    //   234: getfield 107	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   237: invokevirtual 555	java/util/HashMap:clear	()V
    //   240: aload_0
    //   241: monitorexit
    //   242: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	QQAnimationDrawable
    //   135	7	1	localObject2	Object
    //   171	11	1	localIterator	Iterator
    //   116	13	2	localBitmap	Bitmap
    //   140	4	2	localObject3	Object
    //   190	37	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	135	finally
    //   26	50	135	finally
    //   59	83	135	finally
    //   83	98	135	finally
    //   98	117	135	finally
    //   121	132	135	finally
    //   143	145	135	finally
    //   145	152	135	finally
    //   152	172	135	finally
    //   172	203	135	finally
    //   207	215	135	finally
    //   219	230	135	finally
    //   233	240	135	finally
    //   50	59	140	finally
    //   141	143	140	finally
  }
  
  public void draw(Canvas paramCanvas)
  {
    ??? = new StringBuilder().append("animation QQAnimationDrawable draw  currentBitmap == null ");
    boolean bool;
    if (this.jdField_c_of_type_AndroidGraphicsBitmap == null) {
      bool = true;
    }
    for (;;)
    {
      QLog.d("QQAnimationDrawable", 4, bool);
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_c_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_c_of_type_AndroidGraphicsBitmap.isRecycled())) {
          paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, null, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
        }
        a(false, false, true);
        return;
        bool = false;
      }
    }
  }
  
  public int getIntrinsicHeight()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      return this.jdField_a_of_type_AndroidGraphicsBitmap.getScaledHeight(this.jdField_b_of_type_Int);
    }
    return super.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      return this.jdField_a_of_type_AndroidGraphicsBitmap.getScaledWidth(this.jdField_b_of_type_Int);
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
    StringBuilder localStringBuilder = new StringBuilder().append(hashCode()).append("animation QQAnimationDrawable run time:").append(SystemClock.uptimeMillis()).append(",mCurFrame:").append(this.jdField_a_of_type_Int).append("nextFrame:").append(this.jdField_e_of_type_Int).append(" main:");
    if (Looper.myLooper() == Looper.getMainLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("QQAnimationDrawable", 4, bool);
      if (this.jdField_g_of_type_Boolean) {
        break;
      }
      return;
    }
    QLog.d("QQAnimationDrawable", 4, "isParenMethod:" + this.jdField_d_of_type_Boolean);
    if ((!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_Int == a() - 1)) {
      this.jdField_d_of_type_Int -= 1;
    }
    this.jdField_e_of_type_Boolean = true;
    if (this.jdField_b_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_c_of_type_AndroidGraphicsBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
    }
    QLog.d("QQAnimationDrawable", 4, "mRepeatCount:" + this.jdField_d_of_type_Int);
    if ((this.jdField_a_of_type_Int == -1) && (this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableQQAnimationDrawable$QQAnimationListener != null)) {
      this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableQQAnimationDrawable$QQAnimationListener.b();
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
      if ((bool) || (paramBoolean2)) {
        c();
      }
      return bool;
    }
    unscheduleSelf(this);
    return bool;
  }
  
  public void start()
  {
    this.jdField_g_of_type_Boolean = true;
    if ((this.jdField_c_of_type_Int <= 0) || (this.jdField_b_of_type_Long <= 0L)) {}
    while (isRunning()) {
      return;
    }
    this.jdField_e_of_type_Boolean = true;
    a(true, false, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */