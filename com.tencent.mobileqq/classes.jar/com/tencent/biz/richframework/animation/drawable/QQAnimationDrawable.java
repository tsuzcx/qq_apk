package com.tencent.biz.richframework.animation.drawable;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Application;
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
import android.util.Log;
import com.tencent.biz.richframework.AutoShadowPluginRuntime;
import com.tencent.image.SafeBitmapFactory;
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

@SuppressLint({"NewApi"})
public class QQAnimationDrawable
  extends Drawable
  implements Animatable, Runnable
{
  public static final ExecutorService h = ;
  public static byte[] i = new byte[24576];
  private String A;
  private int B;
  private int C;
  private QQAnimationDrawable.QQAnimationListener D;
  private boolean E = false;
  private Object F = new Object();
  private long G;
  private int H;
  private volatile QQAnimationDrawable.SerialExecutor I = new QQAnimationDrawable.SerialExecutor(null);
  private FutureTask<Bitmap> J;
  private Set<SoftReference<Bitmap>> K;
  protected int a = -1;
  Bitmap b;
  Bitmap c;
  int d = 160;
  final QQAnimationDrawable.InternalHandler e = new QQAnimationDrawable.InternalHandler(this, this);
  boolean f = true;
  boolean g = true;
  private final Paint j = new Paint(6);
  private int k = 0;
  private boolean l = false;
  private boolean m = true;
  private int n = 1;
  private long o = 0L;
  private Bitmap p;
  private int q = 0;
  private boolean r = true;
  private QQAnimationDrawable.WorkerRunnable s;
  private int[] t;
  private String[] u;
  private BitmapFactory.Options v = new BitmapFactory.Options();
  private int w = 2;
  private boolean x = true;
  private ArrayList<Bitmap> y = new ArrayList();
  private HashMap<String, SoftReference<Bitmap>> z = new HashMap();
  
  public QQAnimationDrawable()
  {
    this(null);
  }
  
  public QQAnimationDrawable(QQAnimationDrawable.QQAnimationListener paramQQAnimationListener)
  {
    int i2 = this.d;
    int i1 = i2;
    if (i2 == 0) {
      i1 = 160;
    }
    this.d = i1;
    this.D = paramQQAnimationListener;
    if (Build.VERSION.SDK_INT >= 11) {
      this.K = Collections.synchronizedSet(new HashSet());
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
    int i2 = paramOptions.outHeight;
    int i3 = paramOptions.outWidth;
    if ((i2 <= paramInt2) && (i3 <= paramInt1)) {
      return 1;
    }
    int i1 = 2;
    for (;;)
    {
      if ((i2 / i1 <= paramInt2) && (i3 / i1 <= paramInt1)) {
        return i1;
      }
      i1 *= 2;
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
    //   9: getfield 234	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   12: ifeq +25 -> 37
    //   15: new 236	java/io/BufferedInputStream
    //   18: dup
    //   19: new 238	java/io/FileInputStream
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 241	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   27: sipush 8192
    //   30: invokespecial 244	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   33: astore_0
    //   34: goto +19 -> 53
    //   37: new 236	java/io/BufferedInputStream
    //   40: dup
    //   41: new 238	java/io/FileInputStream
    //   44: dup
    //   45: aload_0
    //   46: invokespecial 241	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   49: invokespecial 247	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   52: astore_0
    //   53: aload_0
    //   54: astore_2
    //   55: aload_0
    //   56: aconst_null
    //   57: aload_1
    //   58: invokestatic 253	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   61: astore_1
    //   62: aload_0
    //   63: invokevirtual 258	java/io/InputStream:close	()V
    //   66: aload_1
    //   67: areturn
    //   68: astore_1
    //   69: goto +10 -> 79
    //   72: astore_0
    //   73: goto +39 -> 112
    //   76: astore_1
    //   77: aconst_null
    //   78: astore_0
    //   79: aload_0
    //   80: astore_2
    //   81: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   84: ifeq +16 -> 100
    //   87: aload_0
    //   88: astore_2
    //   89: ldc_w 266
    //   92: iconst_2
    //   93: ldc_w 268
    //   96: aload_1
    //   97: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   100: aload_0
    //   101: ifnull +8 -> 109
    //   104: aload_3
    //   105: astore_1
    //   106: goto -44 -> 62
    //   109: aconst_null
    //   110: areturn
    //   111: astore_0
    //   112: aload_2
    //   113: ifnull +7 -> 120
    //   116: aload_2
    //   117: invokevirtual 258	java/io/InputStream:close	()V
    //   120: goto +5 -> 125
    //   123: aload_0
    //   124: athrow
    //   125: goto -2 -> 123
    //   128: astore_0
    //   129: aload_1
    //   130: areturn
    //   131: astore_1
    //   132: goto -12 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	paramString	String
    //   0	135	1	paramOptions	BitmapFactory.Options
    //   1	116	2	str	String
    //   3	102	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   55	62	68	java/lang/Exception
    //   8	34	72	finally
    //   37	53	72	finally
    //   8	34	76	java/lang/Exception
    //   37	53	76	java/lang/Exception
    //   55	62	111	finally
    //   81	87	111	finally
    //   89	100	111	finally
    //   62	66	128	java/io/IOException
    //   116	120	131	java/io/IOException
  }
  
  private Bitmap a(boolean paramBoolean, int paramInt, Bitmap paramBitmap)
  {
    Object localObject3 = paramBitmap;
    long l1;
    String str;
    Object localObject1;
    Object localObject2;
    label501:
    try
    {
      if (this.u != null)
      {
        localObject3 = paramBitmap;
        if (paramInt < this.u.length)
        {
          l1 = System.currentTimeMillis();
          str = this.u[paramInt];
          localObject3 = paramBitmap;
          if (str != null) {
            if (this.x)
            {
              localObject1 = (SoftReference)this.z.get(str);
              if ((localObject1 != null) && (((SoftReference)localObject1).get() != null))
              {
                paramBitmap = (Bitmap)((SoftReference)localObject1).get();
                return paramBitmap;
              }
              localObject1 = paramBitmap;
              localObject2 = paramBitmap;
            }
          }
        }
      }
    }
    finally {}
    try
    {
      localObject3 = new BitmapFactory.Options();
      localObject1 = paramBitmap;
      localObject2 = paramBitmap;
      ((BitmapFactory.Options)localObject3).inJustDecodeBounds = true;
      localObject1 = paramBitmap;
      localObject2 = paramBitmap;
      ((BitmapFactory.Options)localObject3).inTempStorage = i;
      localObject1 = paramBitmap;
      localObject2 = paramBitmap;
      BitmapFactory.decodeFile(str, (BitmapFactory.Options)localObject3);
      localObject1 = paramBitmap;
      localObject2 = paramBitmap;
      paramInt = a((BitmapFactory.Options)localObject3, AutoShadowPluginRuntime.a().b().getResources().getDisplayMetrics().widthPixels, AutoShadowPluginRuntime.a().b().getResources().getDisplayMetrics().heightPixels);
      localObject1 = paramBitmap;
      localObject2 = paramBitmap;
      ((BitmapFactory.Options)localObject3).inJustDecodeBounds = false;
      localObject1 = paramBitmap;
      localObject2 = paramBitmap;
      ((BitmapFactory.Options)localObject3).inSampleSize = paramInt;
      localObject1 = paramBitmap;
      localObject2 = paramBitmap;
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject1 = paramBitmap;
        localObject2 = paramBitmap;
        b((BitmapFactory.Options)localObject3);
      }
      localObject1 = paramBitmap;
      localObject2 = paramBitmap;
      paramBitmap = SafeBitmapFactory.safeDecode(str, (BitmapFactory.Options)localObject3, true);
      if (paramBitmap == null)
      {
        localObject1 = paramBitmap;
        localObject2 = paramBitmap;
        StringBuilder localStringBuilder = new StringBuilder();
        localObject1 = paramBitmap;
        localObject2 = paramBitmap;
        localStringBuilder.append("decode failed path:");
        localObject1 = paramBitmap;
        localObject2 = paramBitmap;
        localStringBuilder.append(str);
        localObject1 = paramBitmap;
        localObject2 = paramBitmap;
        Log.d("QQAnimationDrawable", localStringBuilder.toString());
        localObject1 = paramBitmap;
        localObject2 = paramBitmap;
        localObject3 = a(str, (BitmapFactory.Options)localObject3);
        paramBitmap = (Bitmap)localObject3;
        if (localObject3 == null)
        {
          localObject1 = localObject3;
          localObject2 = localObject3;
          paramBitmap = new StringBuilder();
          localObject1 = localObject3;
          localObject2 = localObject3;
          paramBitmap.append("decode failed finally,path:");
          localObject1 = localObject3;
          localObject2 = localObject3;
          paramBitmap.append(str);
          localObject1 = localObject3;
          localObject2 = localObject3;
          Log.d("QQAnimationDrawable", paramBitmap.toString());
          paramBitmap = (Bitmap)localObject3;
        }
      }
      else
      {
        localObject1 = paramBitmap;
        localObject2 = paramBitmap;
        Log.d("QQAnimationDrawable", "decode success");
      }
      localObject3 = paramBitmap;
      if (paramBitmap == null) {
        break label553;
      }
      localObject3 = paramBitmap;
      localObject1 = paramBitmap;
      localObject2 = paramBitmap;
      if (paramBitmap.isRecycled()) {
        break label553;
      }
      localObject3 = paramBitmap;
      localObject1 = paramBitmap;
      localObject2 = paramBitmap;
      if (Build.VERSION.SDK_INT < 11) {
        break label553;
      }
      localObject1 = paramBitmap;
      localObject2 = paramBitmap;
      this.K.add(new SoftReference(paramBitmap));
      localObject3 = paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      break label518;
    }
    catch (Exception paramBitmap)
    {
      break label501;
    }
    Log.d("QQAnimationDrawable", "decode exception");
    localObject3 = localObject2;
    break label553;
    label518:
    Log.d("QQAnimationDrawable", "decode outOoMemory");
    localObject3 = localObject1;
    break label553;
    a(this.c, l1, str);
    localObject3 = this.c;
    label553:
    return localObject3;
  }
  
  private void a(Bitmap paramBitmap, long paramLong, int paramInt)
  {
    if (paramBitmap == null) {}
    try
    {
      this.v.inJustDecodeBounds = true;
      BitmapFactory.decodeResource(AutoShadowPluginRuntime.a().b().getResources(), paramInt, this.v);
      Bitmap.createBitmap(this.v.outWidth, this.v.outHeight, Bitmap.Config.ARGB_8888);
      return;
    }
    catch (Exception paramBitmap)
    {
      if (!QLog.isDevelopLevel()) {
        break label204;
      }
      QLog.e("QQAnimationDrawable", 4, paramBitmap.getMessage());
      return;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      break label169;
    }
    this.v.inJustDecodeBounds = false;
    if (Build.VERSION.SDK_INT >= 11) {
      this.v.inBitmap = paramBitmap;
    }
    this.v.inSampleSize = 1;
    this.v.inDensity = 320;
    this.v.inTargetDensity = this.d;
    BitmapFactory.decodeResource(AutoShadowPluginRuntime.a().b().getResources(), paramInt, this.v);
    if (QLog.isDevelopLevel())
    {
      paramBitmap = new StringBuilder();
      paramBitmap.append("getBitmapFromFile ");
      paramBitmap.append(System.currentTimeMillis() - paramLong);
      QLog.d("QQAnimationDrawable", 4, paramBitmap.toString());
      return;
      label169:
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
      this.v.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, this.v);
      if (QLog.isDevelopLevel())
      {
        paramBitmap = new StringBuilder();
        paramBitmap.append("getBitmapFromFile ");
        paramBitmap.append(paramString);
        paramBitmap.append(" ");
        paramBitmap.append(this.v.outWidth);
        paramBitmap.append("——");
        paramBitmap.append(this.v.outHeight);
        QLog.d("QQAnimationDrawable", 4, paramBitmap.toString());
      }
      Bitmap.createBitmap(this.v.outWidth, this.v.outHeight, Bitmap.Config.ARGB_8888);
      return;
    }
    catch (Exception paramBitmap)
    {
      if (!QLog.isDevelopLevel()) {
        break label266;
      }
      QLog.e("QQAnimationDrawable", 4, paramBitmap.getMessage());
      return;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      break label231;
    }
    this.v.inJustDecodeBounds = false;
    if (Build.VERSION.SDK_INT >= 11) {
      this.v.inBitmap = paramBitmap;
    }
    this.v.inSampleSize = 1;
    this.v.inDensity = 320;
    this.v.inTargetDensity = this.d;
    BitmapFactory.decodeFile(paramString, this.v);
    if (QLog.isDevelopLevel())
    {
      paramBitmap = new StringBuilder();
      paramBitmap.append("getBitmapFromFile ");
      paramBitmap.append(System.currentTimeMillis() - paramLong);
      QLog.d("QQAnimationDrawable", 4, paramBitmap.toString());
      return;
      label231:
      if (QLog.isDevelopLevel())
      {
        QLog.e("QQAnimationDrawable", 4, "getBitmapFromFile OOM");
        return;
      }
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i1 = this.a;
    boolean bool = true;
    int i2 = i1 + 1;
    i1 = i2;
    if (i2 >= this.k) {
      i1 = 0;
    }
    if (paramBoolean2) {
      unscheduleSelf(this);
    }
    if (((this.l) || (this.n <= 0)) && (i1 >= this.k - 1)) {
      paramBoolean2 = bool;
    } else {
      paramBoolean2 = false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("animation QQAnimationDrawable loadNextBitmap  playEnd:");
    ((StringBuilder)localObject).append(paramBoolean2);
    ((StringBuilder)localObject).append(",mDecodeNextFrameEnd:");
    ((StringBuilder)localObject).append(this.r);
    ((StringBuilder)localObject).append(",animate:");
    ((StringBuilder)localObject).append(paramBoolean3);
    Log.d("QQAnimationDrawable", ((StringBuilder)localObject).toString());
    if ((!paramBoolean2) && (this.r) && (paramBoolean3))
    {
      this.r = false;
      long l1;
      if (paramBoolean1) {
        l1 = 0L;
      } else {
        l1 = SystemClock.uptimeMillis() + this.G;
      }
      this.s = new QQAnimationDrawable.WorkerRunnable(this, i1, l1);
      this.I.execute(this.s);
    }
    if (paramBoolean2)
    {
      stop();
      localObject = this.D;
      if (localObject != null) {
        ((QQAnimationDrawable.QQAnimationListener)localObject).a();
      }
    }
  }
  
  @TargetApi(19)
  private static boolean a(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    int i1 = Build.VERSION.SDK_INT;
    boolean bool1 = false;
    boolean bool2 = false;
    if (i1 < 19)
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
  
  private Bitmap b(boolean paramBoolean, int paramInt, Bitmap paramBitmap)
  {
    Object localObject = paramBitmap;
    try
    {
      Bitmap localBitmap;
      if (this.t != null)
      {
        localObject = paramBitmap;
        if (paramInt < this.t.length)
        {
          long l1 = System.currentTimeMillis();
          paramInt = this.t[paramInt];
          localObject = paramBitmap;
          if (paramInt > 0) {
            if (this.x)
            {
              localObject = (SoftReference)this.z.get(Integer.valueOf(paramInt));
              if ((localObject != null) && (((SoftReference)localObject).get() != null))
              {
                paramBitmap = (Bitmap)((SoftReference)localObject).get();
                return paramBitmap;
              }
              try
              {
                localObject = BitmapFactory.decodeResource(AutoShadowPluginRuntime.a().b().getResources(), paramInt);
                paramBitmap = (Bitmap)localObject;
                this.z.put(String.valueOf(paramInt), new SoftReference(localObject));
              }
              catch (OutOfMemoryError localOutOfMemoryError)
              {
                QLog.e("QQAnimationDrawable", 1, "generateBitmap error", localOutOfMemoryError);
                localBitmap = paramBitmap;
              }
            }
            else
            {
              a(this.c, l1, paramInt);
              localBitmap = this.c;
            }
          }
        }
      }
      return localBitmap;
    }
    finally {}
  }
  
  @TargetApi(11)
  private void b(BitmapFactory.Options paramOptions)
  {
    paramOptions.inMutable = true;
    Bitmap localBitmap = a(paramOptions);
    if (localBitmap != null) {
      paramOptions.inBitmap = localBitmap;
    }
  }
  
  /* Error */
  private Bitmap c(boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_2
    //   3: aload_0
    //   4: getfield 128	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:y	Ljava/util/ArrayList;
    //   7: invokevirtual 502	java/util/ArrayList:size	()I
    //   10: if_icmpge +26 -> 36
    //   13: aload_0
    //   14: getfield 128	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:y	Ljava/util/ArrayList;
    //   17: iload_2
    //   18: invokevirtual 505	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   21: checkcast 294	android/graphics/Bitmap
    //   24: astore 9
    //   26: aload 9
    //   28: ifnull +8 -> 36
    //   31: aload_0
    //   32: monitorexit
    //   33: aload 9
    //   35: areturn
    //   36: invokestatic 283	java/lang/System:currentTimeMillis	()J
    //   39: lstore 7
    //   41: aload_0
    //   42: getfield 119	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:v	Landroid/graphics/BitmapFactory$Options;
    //   45: iconst_1
    //   46: putfield 234	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   49: aload_0
    //   50: getfield 507	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:A	Ljava/lang/String;
    //   53: aload_0
    //   54: getfield 119	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:v	Landroid/graphics/BitmapFactory$Options;
    //   57: invokestatic 300	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   60: pop
    //   61: aload_0
    //   62: getfield 119	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:v	Landroid/graphics/BitmapFactory$Options;
    //   65: getfield 224	android/graphics/BitmapFactory$Options:outWidth	I
    //   68: i2f
    //   69: aload_0
    //   70: getfield 509	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:B	I
    //   73: i2f
    //   74: fconst_1
    //   75: fmul
    //   76: fdiv
    //   77: f2i
    //   78: istore 5
    //   80: aload_0
    //   81: getfield 119	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:v	Landroid/graphics/BitmapFactory$Options;
    //   84: getfield 221	android/graphics/BitmapFactory$Options:outHeight	I
    //   87: i2f
    //   88: aload_0
    //   89: getfield 511	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:C	I
    //   92: i2f
    //   93: fconst_1
    //   94: fmul
    //   95: fdiv
    //   96: f2i
    //   97: istore 6
    //   99: aload_0
    //   100: getfield 119	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:v	Landroid/graphics/BitmapFactory$Options;
    //   103: iconst_0
    //   104: putfield 234	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   107: aload_0
    //   108: getfield 119	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:v	Landroid/graphics/BitmapFactory$Options;
    //   111: sipush 320
    //   114: putfield 381	android/graphics/BitmapFactory$Options:inDensity	I
    //   117: aload_0
    //   118: getfield 119	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:v	Landroid/graphics/BitmapFactory$Options;
    //   121: aload_0
    //   122: getfield 114	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:d	I
    //   125: putfield 384	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   128: aload_0
    //   129: getfield 507	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:A	Ljava/lang/String;
    //   132: aload_0
    //   133: getfield 119	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:v	Landroid/graphics/BitmapFactory$Options;
    //   136: invokestatic 300	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   139: astore 9
    //   141: iconst_0
    //   142: istore_3
    //   143: iload_3
    //   144: aload_0
    //   145: getfield 511	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:C	I
    //   148: if_icmpge +104 -> 252
    //   151: iconst_0
    //   152: istore 4
    //   154: iload 4
    //   156: aload_0
    //   157: getfield 509	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:B	I
    //   160: if_icmpge +256 -> 416
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
    //   180: invokestatic 514	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   183: astore 10
    //   185: aload 10
    //   187: ifnull +220 -> 407
    //   190: invokestatic 387	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   193: ifeq +46 -> 239
    //   196: new 322	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 323	java/lang/StringBuilder:<init>	()V
    //   203: astore 11
    //   205: aload 11
    //   207: ldc_w 516
    //   210: invokevirtual 329	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload 11
    //   216: iload_3
    //   217: bipush 8
    //   219: imul
    //   220: iload 4
    //   222: iadd
    //   223: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: ldc_w 266
    //   230: iconst_4
    //   231: aload 11
    //   233: invokevirtual 333	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 395	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   239: aload_0
    //   240: getfield 128	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:y	Ljava/util/ArrayList;
    //   243: aload 10
    //   245: invokevirtual 517	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   248: pop
    //   249: goto +158 -> 407
    //   252: aload 9
    //   254: ifnull +16 -> 270
    //   257: aload 9
    //   259: invokevirtual 347	android/graphics/Bitmap:isRecycled	()Z
    //   262: ifne +8 -> 270
    //   265: aload 9
    //   267: invokevirtual 520	android/graphics/Bitmap:recycle	()V
    //   270: aload_0
    //   271: aload_0
    //   272: getfield 128	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:y	Ljava/util/ArrayList;
    //   275: invokevirtual 502	java/util/ArrayList:size	()I
    //   278: putfield 100	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:k	I
    //   281: invokestatic 387	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   284: ifeq +87 -> 371
    //   287: new 322	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 323	java/lang/StringBuilder:<init>	()V
    //   294: astore 9
    //   296: aload 9
    //   298: ldc_w 522
    //   301: invokevirtual 329	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload 9
    //   307: invokestatic 283	java/lang/System:currentTimeMillis	()J
    //   310: lload 7
    //   312: lsub
    //   313: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: ldc_w 266
    //   320: iconst_4
    //   321: aload 9
    //   323: invokevirtual 333	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokestatic 395	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   329: goto +42 -> 371
    //   332: invokestatic 387	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   335: ifeq +36 -> 371
    //   338: ldc_w 266
    //   341: iconst_4
    //   342: ldc_w 397
    //   345: invokestatic 399	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   348: goto +23 -> 371
    //   351: astore 9
    //   353: invokestatic 387	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   356: ifeq +15 -> 371
    //   359: ldc_w 266
    //   362: iconst_4
    //   363: aload 9
    //   365: invokevirtual 402	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   368: invokestatic 399	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   371: aload_0
    //   372: getfield 128	com/tencent/biz/richframework/animation/drawable/QQAnimationDrawable:y	Ljava/util/ArrayList;
    //   375: iload_2
    //   376: invokevirtual 505	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   379: checkcast 294	android/graphics/Bitmap
    //   382: astore 9
    //   384: aload_0
    //   385: monitorexit
    //   386: aload 9
    //   388: areturn
    //   389: astore 9
    //   391: aload_0
    //   392: monitorexit
    //   393: goto +6 -> 399
    //   396: aload 9
    //   398: athrow
    //   399: goto -3 -> 396
    //   402: astore 9
    //   404: goto -72 -> 332
    //   407: iload 4
    //   409: iconst_1
    //   410: iadd
    //   411: istore 4
    //   413: goto -259 -> 154
    //   416: iload_3
    //   417: iconst_1
    //   418: iadd
    //   419: istore_3
    //   420: goto -277 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	423	0	this	QQAnimationDrawable
    //   0	423	1	paramBoolean	boolean
    //   0	423	2	paramInt	int
    //   142	278	3	i1	int
    //   152	260	4	i2	int
    //   78	97	5	i3	int
    //   97	80	6	i4	int
    //   39	272	7	l1	long
    //   24	298	9	localObject1	Object
    //   351	13	9	localException	Exception
    //   382	5	9	localBitmap1	Bitmap
    //   389	8	9	localObject2	Object
    //   402	1	9	localOutOfMemoryError	OutOfMemoryError
    //   183	61	10	localBitmap2	Bitmap
    //   203	29	11	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   36	141	351	java/lang/Exception
    //   143	151	351	java/lang/Exception
    //   154	185	351	java/lang/Exception
    //   190	239	351	java/lang/Exception
    //   239	249	351	java/lang/Exception
    //   257	270	351	java/lang/Exception
    //   270	329	351	java/lang/Exception
    //   2	26	389	finally
    //   36	141	389	finally
    //   143	151	389	finally
    //   154	185	389	finally
    //   190	239	389	finally
    //   239	249	389	finally
    //   257	270	389	finally
    //   270	329	389	finally
    //   332	348	389	finally
    //   353	371	389	finally
    //   371	384	389	finally
    //   36	141	402	java/lang/OutOfMemoryError
    //   143	151	402	java/lang/OutOfMemoryError
    //   154	185	402	java/lang/OutOfMemoryError
    //   190	239	402	java/lang/OutOfMemoryError
    //   239	249	402	java/lang/OutOfMemoryError
    //   257	270	402	java/lang/OutOfMemoryError
    //   270	329	402	java/lang/OutOfMemoryError
  }
  
  private void f()
  {
    long l2 = this.G;
    long l1 = 0L;
    if (l2 == 0L)
    {
      int i1 = this.H;
      if (i1 != 0) {
        l1 = this.o / i1;
      }
      this.G = l1;
      return;
    }
    if (this.o == 0L) {
      this.o = (l2 * this.H);
    }
  }
  
  public int a()
  {
    return this.k;
  }
  
  protected Bitmap a(BitmapFactory.Options paramOptions)
  {
    Object localObject1 = this.K;
    Object localObject2 = null;
    if ((localObject1 != null) && (!((Set)localObject1).isEmpty())) {
      synchronized (this.K)
      {
        Iterator localIterator = this.K.iterator();
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
  
  public void a(int paramInt)
  {
    this.m = false;
    this.n = paramInt;
    paramInt = this.n;
    if (paramInt > 1) {
      b(false);
    } else if (paramInt == 1) {
      b(true);
    }
    start();
  }
  
  public void a(long paramLong)
  {
    this.o = paramLong;
    f();
  }
  
  public void a(QQAnimationDrawable.QQAnimationListener paramQQAnimationListener)
  {
    this.D = paramQQAnimationListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.m = true;
    b(paramBoolean);
    start();
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      a(paramBoolean);
      return;
    }
    a(paramInt);
  }
  
  public void a(String[] paramArrayOfString)
  {
    b(0);
    if (!Arrays.equals(this.u, paramArrayOfString))
    {
      e();
      this.u = paramArrayOfString;
    }
    String[] arrayOfString = this.u;
    if (arrayOfString != null) {
      this.k = arrayOfString.length;
    } else {
      this.k = 0;
    }
    this.H = paramArrayOfString.length;
    f();
  }
  
  Bitmap b(boolean paramBoolean, int paramInt)
  {
    int i1 = this.w;
    Bitmap localBitmap = null;
    if (i1 == 0) {
      localBitmap = a(paramBoolean, paramInt, null);
    } else if (i1 == 2) {
      localBitmap = b(paramBoolean, paramInt, null);
    } else if (i1 == 1) {
      localBitmap = c(paramBoolean, paramInt);
    }
    if (localBitmap == null) {
      return this.c;
    }
    return localBitmap;
  }
  
  public void b()
  {
    this.n = 1;
    this.a = -1;
    this.q = 0;
    this.c = null;
    this.p = null;
    c();
  }
  
  public void b(int paramInt)
  {
    this.w = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.G = paramLong;
    f();
  }
  
  public void b(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void c()
  {
    if (this.I != null) {
      this.I.b();
    }
    FutureTask localFutureTask = this.J;
    if (localFutureTask != null) {
      localFutureTask.cancel(true);
    }
  }
  
  public void d() {}
  
  public void draw(Canvas paramCanvas)
  {
    synchronized (this.F)
    {
      if ((this.p != null) && (!this.p.isRecycled())) {
        paramCanvas.drawBitmap(this.p, null, getBounds(), this.j);
      }
      a(false, false, true);
      return;
    }
  }
  
  public void e()
  {
    try
    {
      if ((this.b != null) && (!this.b.isRecycled())) {
        this.b.recycle();
      }
      if ((this.p != null) && (!this.p.isRecycled())) {
        synchronized (this.F)
        {
          this.p.recycle();
        }
      }
      if ((this.c != null) && (!this.c.isRecycled())) {
        this.c.recycle();
      }
      Object localObject4;
      if (this.y != null)
      {
        ??? = this.y.iterator();
        while (((Iterator)???).hasNext())
        {
          localObject4 = (Bitmap)((Iterator)???).next();
          if ((localObject4 != null) && (!((Bitmap)localObject4).isRecycled())) {
            ((Bitmap)localObject4).recycle();
          }
        }
        this.y.clear();
      }
      if (this.z != null)
      {
        ??? = this.z.keySet().iterator();
        while (((Iterator)???).hasNext())
        {
          localObject4 = (String)((Iterator)???).next();
          localObject4 = (SoftReference)this.z.get(localObject4);
          if (localObject4 != null)
          {
            localObject4 = (Bitmap)((SoftReference)localObject4).get();
            if ((localObject4 != null) && (!((Bitmap)localObject4).isRecycled())) {
              ((Bitmap)localObject4).recycle();
            }
          }
        }
        this.z.clear();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public int getIntrinsicHeight()
  {
    Bitmap localBitmap = this.b;
    if (localBitmap != null) {
      return localBitmap.getScaledHeight(this.d);
    }
    return super.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    Bitmap localBitmap = this.b;
    if (localBitmap != null) {
      return localBitmap.getScaledWidth(this.d);
    }
    return super.getIntrinsicWidth();
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public boolean isRunning()
  {
    return this.a > -1;
  }
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(hashCode());
    ((StringBuilder)localObject).append("animation QQAnimationDrawable run time:");
    ((StringBuilder)localObject).append(SystemClock.uptimeMillis());
    ((StringBuilder)localObject).append(",mCurFrame:");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append("nextFrame:");
    ((StringBuilder)localObject).append(this.q);
    ((StringBuilder)localObject).append(" main:");
    boolean bool;
    if (Looper.myLooper() == Looper.getMainLooper()) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    Log.d("QQAnimationDrawable", ((StringBuilder)localObject).toString());
    if (!this.E) {
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isParenMethod:");
    ((StringBuilder)localObject).append(this.m);
    Log.d("QQAnimationDrawable", ((StringBuilder)localObject).toString());
    if ((!this.m) && (this.a == a() - 1)) {
      this.n -= 1;
    }
    this.r = true;
    localObject = this.c;
    if (localObject != null) {
      this.p = ((Bitmap)localObject);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mRepeatCount:");
    ((StringBuilder)localObject).append(this.n);
    Log.d("QQAnimationDrawable", ((StringBuilder)localObject).toString());
    if (this.a == -1)
    {
      localObject = this.D;
      if (localObject != null) {
        ((QQAnimationDrawable.QQAnimationListener)localObject).b();
      }
    }
    this.a = this.q;
    invalidateSelf();
  }
  
  public void setAlpha(int paramInt)
  {
    this.j.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.j.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.j.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.j.setFilterBitmap(paramBoolean);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (paramBoolean1)
    {
      if ((bool) || (paramBoolean2))
      {
        d();
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
    this.E = true;
    if (this.k > 0)
    {
      if (this.G <= 0L) {
        return;
      }
      if (!isRunning())
      {
        this.r = true;
        a(true, false, true);
      }
    }
  }
  
  public void stop()
  {
    this.E = false;
    Log.d("QQAnimationDrawable", " stop");
    if (isRunning()) {
      unscheduleSelf(this);
    }
    if (!this.m) {
      this.n = 1;
    }
    b();
  }
  
  public void unscheduleSelf(Runnable paramRunnable)
  {
    this.a = -1;
    super.unscheduleSelf(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */