package com.tencent.luggage.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewParent;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.widget.decoder.SkiaImageDecoder;
import com.tencent.luggage.widget.decoder.SkiaImageRegionDecoder;
import com.tencent.luggage.widget.decoder.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class c
  extends View
{
  private static final String a = "c";
  private static Bitmap.Config aC;
  private static final List<Integer> b;
  private static final List<Integer> c;
  private static final List<Integer> d;
  private static final List<Integer> e;
  private static final List<Integer> f;
  private float A = 1.0F;
  private int B = 1;
  private int C = 500;
  private float D;
  private float E;
  private PointF F;
  private PointF G;
  private PointF H;
  private Float I;
  private PointF J;
  private PointF K;
  private int L;
  private int M;
  private int N;
  private Rect O;
  private Rect P;
  private boolean Q;
  private boolean R;
  private boolean S;
  private int T;
  private GestureDetector U;
  private GestureDetector V;
  private d W;
  private final float[] aA = new float[8];
  private final float aB = getResources().getDisplayMetrics().density;
  private final ReadWriteLock aa = new ReentrantReadWriteLock(true);
  private com.tencent.luggage.widget.decoder.b<? extends com.tencent.luggage.widget.decoder.c> ab = new com.tencent.luggage.widget.decoder.a(SkiaImageDecoder.class);
  private com.tencent.luggage.widget.decoder.b<? extends d> ac = new com.tencent.luggage.widget.decoder.a(SkiaImageRegionDecoder.class);
  private PointF ad;
  private float ae;
  private final float af;
  private float ag;
  private boolean ah;
  private PointF ai;
  private PointF aj;
  private PointF ak;
  private c.a al;
  private boolean am;
  private boolean an;
  private c.e ao;
  private c.f ap;
  private View.OnLongClickListener aq;
  private final Handler ar;
  private Paint as;
  private Paint at;
  private Paint au;
  private Paint av;
  private c.g aw;
  private Matrix ax;
  private RectF ay;
  private final float[] az = new float[8];
  private Bitmap g;
  private boolean h;
  private boolean i;
  private Uri j;
  private int k;
  private Map<Integer, List<c.h>> l;
  private boolean m;
  private int n = 0;
  private float o = 2.0F;
  private float p = n();
  private int q = -1;
  private int r = 1;
  private int s = 1;
  private int t = 2147483647;
  private int u = 2147483647;
  private Executor v = AsyncTask.THREAD_POOL_EXECUTOR;
  private boolean w = true;
  private boolean x = true;
  private boolean y = true;
  private boolean z = true;
  
  static
  {
    Integer localInteger1 = Integer.valueOf(1);
    Integer localInteger2 = Integer.valueOf(2);
    Integer localInteger3 = Integer.valueOf(3);
    b = Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(90), Integer.valueOf(180), Integer.valueOf(270), Integer.valueOf(-1) });
    c = Arrays.asList(new Integer[] { localInteger1, localInteger2, localInteger3 });
    d = Arrays.asList(new Integer[] { localInteger2, localInteger1 });
    e = Arrays.asList(new Integer[] { localInteger1, localInteger2, localInteger3 });
    f = Arrays.asList(new Integer[] { localInteger2, localInteger1, localInteger3, Integer.valueOf(4) });
  }
  
  public c(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public c(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setMinimumDpi(160);
    setDoubleTapZoomDpi(160);
    setMinimumTileDpi(320);
    setGestureDetector(paramContext);
    this.ar = new Handler(new c.1(this));
    this.af = TypedValue.applyDimension(1, 20.0F, paramContext.getResources().getDisplayMetrics());
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 -= paramFloat2;
    paramFloat2 = paramFloat3 - paramFloat4;
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  private float a(int paramInt, long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    if (paramInt != 1)
    {
      if (paramInt == 2) {
        return b(paramLong1, paramFloat1, paramFloat2, paramLong2);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unexpected easing type: ");
      localStringBuilder.append(paramInt);
      throw new IllegalStateException(localStringBuilder.toString());
    }
    return a(paramLong1, paramFloat1, paramFloat2, paramLong2);
  }
  
  private float a(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    float f1 = (float)paramLong1 / (float)paramLong2;
    return -paramFloat2 * f1 * (f1 - 2.0F) + paramFloat1;
  }
  
  private int a(float paramFloat)
  {
    float f1 = paramFloat;
    if (this.q > 0)
    {
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      f1 = (localDisplayMetrics.xdpi + localDisplayMetrics.ydpi) / 2.0F;
      f1 = paramFloat * (this.q / f1);
    }
    int i3 = (int)(l() * f1);
    int i1 = (int)(m() * f1);
    if ((i3 != 0) && (i1 != 0))
    {
      int i4 = m();
      int i2 = 1;
      if ((i4 <= i1) && (l() <= i3))
      {
        i1 = 1;
      }
      else
      {
        i1 = Math.round(m() / i1);
        i3 = Math.round(l() / i3);
        if (i1 >= i3) {
          i1 = i3;
        }
      }
      for (;;)
      {
        i3 = i2 * 2;
        if (i3 >= i1) {
          break;
        }
        i2 = i3;
      }
      return i2;
    }
    return 32;
  }
  
  private int a(int paramInt)
  {
    return (int)(this.aB * paramInt);
  }
  
  /* Error */
  @AnyThread
  private int a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc_w 322
    //   4: invokevirtual 328	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   7: ifeq +225 -> 232
    //   10: aconst_null
    //   11: astore 5
    //   13: aconst_null
    //   14: astore 4
    //   16: aload_1
    //   17: invokevirtual 332	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   20: aload_2
    //   21: invokestatic 338	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   24: iconst_1
    //   25: anewarray 324	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: ldc_w 340
    //   33: aastore
    //   34: aconst_null
    //   35: aconst_null
    //   36: aconst_null
    //   37: invokevirtual 346	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   40: astore_1
    //   41: aload_1
    //   42: ifnull +130 -> 172
    //   45: aload_1
    //   46: astore 4
    //   48: aload_1
    //   49: astore 5
    //   51: aload_1
    //   52: invokeinterface 352 1 0
    //   57: ifeq +115 -> 172
    //   60: aload_1
    //   61: astore 4
    //   63: aload_1
    //   64: astore 5
    //   66: aload_1
    //   67: iconst_0
    //   68: invokeinterface 355 2 0
    //   73: istore_3
    //   74: aload_1
    //   75: astore 4
    //   77: aload_1
    //   78: astore 5
    //   80: getstatic 128	com/tencent/luggage/widget/c:b	Ljava/util/List;
    //   83: iload_3
    //   84: invokestatic 120	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   87: invokeinterface 361 2 0
    //   92: ifeq +11 -> 103
    //   95: iload_3
    //   96: iconst_m1
    //   97: if_icmpeq +6 -> 103
    //   100: goto +74 -> 174
    //   103: aload_1
    //   104: astore 4
    //   106: aload_1
    //   107: astore 5
    //   109: getstatic 363	com/tencent/luggage/widget/c:a	Ljava/lang/String;
    //   112: astore_2
    //   113: aload_1
    //   114: astore 4
    //   116: aload_1
    //   117: astore 5
    //   119: new 275	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   126: astore 6
    //   128: aload_1
    //   129: astore 4
    //   131: aload_1
    //   132: astore 5
    //   134: aload 6
    //   136: ldc_w 365
    //   139: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload_1
    //   144: astore 4
    //   146: aload_1
    //   147: astore 5
    //   149: aload 6
    //   151: iload_3
    //   152: invokevirtual 286	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload_1
    //   157: astore 4
    //   159: aload_1
    //   160: astore 5
    //   162: aload_2
    //   163: aload 6
    //   165: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 370	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   171: pop
    //   172: iconst_0
    //   173: istore_3
    //   174: aload_1
    //   175: ifnull +9 -> 184
    //   178: aload_1
    //   179: invokeinterface 373 1 0
    //   184: iload_3
    //   185: ireturn
    //   186: astore_1
    //   187: goto +31 -> 218
    //   190: aload 5
    //   192: astore 4
    //   194: getstatic 363	com/tencent/luggage/widget/c:a	Ljava/lang/String;
    //   197: ldc_w 375
    //   200: invokestatic 370	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   203: pop
    //   204: aload 5
    //   206: ifnull +125 -> 331
    //   209: aload 5
    //   211: invokeinterface 373 1 0
    //   216: iconst_0
    //   217: ireturn
    //   218: aload 4
    //   220: ifnull +10 -> 230
    //   223: aload 4
    //   225: invokeinterface 373 1 0
    //   230: aload_1
    //   231: athrow
    //   232: aload_2
    //   233: ldc_w 377
    //   236: invokevirtual 328	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   239: ifeq +92 -> 331
    //   242: aload_2
    //   243: ldc_w 379
    //   246: invokevirtual 328	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   249: ifne +82 -> 331
    //   252: new 381	android/media/ExifInterface
    //   255: dup
    //   256: aload_2
    //   257: bipush 7
    //   259: invokevirtual 385	java/lang/String:substring	(I)Ljava/lang/String;
    //   262: invokespecial 386	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   265: ldc_w 388
    //   268: iconst_1
    //   269: invokevirtual 392	android/media/ExifInterface:getAttributeInt	(Ljava/lang/String;I)I
    //   272: istore_3
    //   273: iload_3
    //   274: iconst_1
    //   275: if_icmpeq +56 -> 331
    //   278: iload_3
    //   279: ifne +62 -> 341
    //   282: iconst_0
    //   283: ireturn
    //   284: getstatic 363	com/tencent/luggage/widget/c:a	Ljava/lang/String;
    //   287: astore_1
    //   288: new 275	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   295: astore_2
    //   296: aload_2
    //   297: ldc_w 394
    //   300: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload_2
    //   305: iload_3
    //   306: invokevirtual 286	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload_1
    //   311: aload_2
    //   312: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokestatic 370	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   318: pop
    //   319: iconst_0
    //   320: ireturn
    //   321: getstatic 363	com/tencent/luggage/widget/c:a	Ljava/lang/String;
    //   324: ldc_w 396
    //   327: invokestatic 370	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   330: pop
    //   331: iconst_0
    //   332: ireturn
    //   333: astore_1
    //   334: goto -144 -> 190
    //   337: astore_1
    //   338: goto -17 -> 321
    //   341: iload_3
    //   342: bipush 6
    //   344: if_icmpne +6 -> 350
    //   347: bipush 90
    //   349: ireturn
    //   350: iload_3
    //   351: iconst_3
    //   352: if_icmpne +7 -> 359
    //   355: sipush 180
    //   358: ireturn
    //   359: iload_3
    //   360: bipush 8
    //   362: if_icmpne -78 -> 284
    //   365: sipush 270
    //   368: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	369	0	this	c
    //   0	369	1	paramContext	Context
    //   0	369	2	paramString	String
    //   73	290	3	i1	int
    //   14	210	4	localContext1	Context
    //   11	199	5	localContext2	Context
    //   126	38	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   16	41	186	finally
    //   51	60	186	finally
    //   66	74	186	finally
    //   80	95	186	finally
    //   109	113	186	finally
    //   119	128	186	finally
    //   134	143	186	finally
    //   149	156	186	finally
    //   162	172	186	finally
    //   194	204	186	finally
    //   16	41	333	java/lang/Exception
    //   51	60	333	java/lang/Exception
    //   66	74	333	java/lang/Exception
    //   80	95	333	java/lang/Exception
    //   109	113	333	java/lang/Exception
    //   119	128	333	java/lang/Exception
    //   134	143	333	java/lang/Exception
    //   149	156	333	java/lang/Exception
    //   162	172	333	java/lang/Exception
    //   252	273	337	java/lang/Exception
    //   284	319	337	java/lang/Exception
  }
  
  @NonNull
  private Point a(Canvas paramCanvas)
  {
    return new Point(Math.min(paramCanvas.getMaximumBitmapWidth(), this.t), Math.min(paramCanvas.getMaximumBitmapHeight(), this.u));
  }
  
  @NonNull
  private PointF a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    int i1 = getPaddingLeft();
    int i2 = (getWidth() - getPaddingRight() - getPaddingLeft()) / 2;
    int i3 = getPaddingTop();
    int i4 = (getHeight() - getPaddingBottom() - getPaddingTop()) / 2;
    if (this.aw == null) {
      this.aw = new c.g(0.0F, new PointF(0.0F, 0.0F), null);
    }
    c.g.a(this.aw, paramFloat3);
    c.g.b(this.aw).set(i1 + i2 - paramFloat1 * paramFloat3, i3 + i4 - paramFloat2 * paramFloat3);
    a(true, this.aw);
    return c.g.b(this.aw);
  }
  
  @NonNull
  private PointF a(float paramFloat1, float paramFloat2, float paramFloat3, @NonNull PointF paramPointF)
  {
    PointF localPointF = a(paramFloat1, paramFloat2, paramFloat3);
    int i1 = getPaddingLeft();
    int i2 = (getWidth() - getPaddingRight() - getPaddingLeft()) / 2;
    int i3 = getPaddingTop();
    int i4 = (getHeight() - getPaddingBottom() - getPaddingTop()) / 2;
    paramPointF.set((i1 + i2 - localPointF.x) / paramFloat3, (i3 + i4 - localPointF.y) / paramFloat3);
    return paramPointF;
  }
  
  private void a(float paramFloat, PointF paramPointF, int paramInt)
  {
    c.f localf = this.ap;
    if (localf != null)
    {
      float f1 = this.D;
      if (f1 != paramFloat) {
        localf.a(f1, paramInt);
      }
    }
    if ((this.ap != null) && (!this.F.equals(paramPointF))) {
      this.ap.a(getCenter(), paramInt);
    }
  }
  
  private void a(Bitmap paramBitmap)
  {
    try
    {
      a("onPreviewLoaded", new Object[0]);
      if ((this.g == null) && (!this.an))
      {
        if (this.P != null) {
          this.g = Bitmap.createBitmap(paramBitmap, this.P.left, this.P.top, this.P.width(), this.P.height());
        } else {
          this.g = paramBitmap;
        }
        this.h = true;
        if (g())
        {
          invalidate();
          requestLayout();
        }
        return;
      }
      paramBitmap.recycle();
      return;
    }
    finally {}
  }
  
  private void a(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    try
    {
      a("onImageLoaded", new Object[0]);
      if ((this.L > 0) && (this.M > 0) && ((this.L != paramBitmap.getWidth()) || (this.M != paramBitmap.getHeight()))) {
        a(false);
      }
      if ((this.g != null) && (!this.i)) {
        this.g.recycle();
      }
      if ((this.g != null) && (this.i) && (this.ao != null)) {
        this.ao.c();
      }
      this.h = false;
      this.i = paramBoolean;
      this.g = paramBitmap;
      this.L = paramBitmap.getWidth();
      this.M = paramBitmap.getHeight();
      this.N = paramInt;
      paramBoolean = g();
      boolean bool = h();
      if ((paramBoolean) || (bool))
      {
        invalidate();
        requestLayout();
      }
      return;
    }
    finally {}
  }
  
  private void a(@NonNull Point paramPoint)
  {
    try
    {
      a("initialiseBaseLayer maxTileDimensions=%dx%d", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y) });
      this.aw = new c.g(0.0F, new PointF(0.0F, 0.0F), null);
      a(true, this.aw);
      this.k = a(c.g.a(this.aw));
      if (this.k > 1) {
        this.k /= 2;
      }
      if ((this.k == 1) && (this.O == null) && (l() < paramPoint.x) && (m() < paramPoint.y))
      {
        this.W.b();
        this.W = null;
        a(new c.c(this, getContext(), this.ab, this.j, false));
      }
      else
      {
        b(paramPoint);
        paramPoint = ((List)this.l.get(Integer.valueOf(this.k))).iterator();
        while (paramPoint.hasNext())
        {
          c.h localh = (c.h)paramPoint.next();
          a(new c.i(this, this.W, localh));
        }
        c(true);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramPoint;
    }
  }
  
  private void a(PointF paramPointF1, PointF paramPointF2)
  {
    if (!this.x)
    {
      PointF localPointF = this.K;
      if (localPointF != null)
      {
        paramPointF1.x = localPointF.x;
        paramPointF1.y = this.K.y;
      }
      else
      {
        paramPointF1.x = (l() / 2);
        paramPointF1.y = (m() / 2);
      }
    }
    float f1 = Math.min(this.o, this.A);
    float f2 = this.D;
    double d1 = f2;
    double d2 = f1;
    Double.isNaN(d2);
    int i1;
    if ((d1 > d2 * 0.9D) && (f2 != this.p)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if (i1 == 0) {
      f1 = n();
    }
    int i2 = this.B;
    if (i2 == 3) {
      a(f1, paramPointF1);
    } else if ((i2 != 2) && (i1 != 0) && (this.x))
    {
      if (i2 == 1) {
        c.b.a(new c.b(this, f1, paramPointF1, paramPointF2, null).a(false).a(this.C), 4).a();
      }
    }
    else {
      c.b.a(new c.b(this, f1, paramPointF1, null).a(false).a(this.C), 4).a();
    }
    invalidate();
  }
  
  @AnyThread
  private void a(Rect paramRect1, Rect paramRect2)
  {
    if (getRequiredRotation() == 0)
    {
      paramRect2.set(paramRect1);
      return;
    }
    if (getRequiredRotation() == 90)
    {
      paramRect2.set(paramRect1.top, this.M - paramRect1.right, paramRect1.bottom, this.M - paramRect1.left);
      return;
    }
    if (getRequiredRotation() == 180)
    {
      paramRect2.set(this.L - paramRect1.right, this.M - paramRect1.bottom, this.L - paramRect1.left, this.M - paramRect1.top);
      return;
    }
    paramRect2.set(this.L - paramRect1.bottom, paramRect1.left, this.L - paramRect1.top, paramRect1.right);
  }
  
  private void a(AsyncTask<Void, Void, ?> paramAsyncTask)
  {
    paramAsyncTask.executeOnExecutor(this.v, new Void[0]);
  }
  
  private void a(b paramb)
  {
    if ((paramb != null) && (b.contains(Integer.valueOf(paramb.c()))))
    {
      this.n = paramb.c();
      this.I = Float.valueOf(paramb.a());
      this.J = paramb.b();
      invalidate();
    }
  }
  
  private void a(d paramd, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      a("onTilesInited sWidth=%d, sHeight=%d, sOrientation=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.n) });
      if ((this.L > 0) && (this.M > 0) && ((this.L != paramInt1) || (this.M != paramInt2)))
      {
        a(false);
        if (this.g != null)
        {
          if (!this.i) {
            this.g.recycle();
          }
          this.g = null;
          if ((this.ao != null) && (this.i)) {
            this.ao.c();
          }
          this.h = false;
          this.i = false;
        }
      }
      this.W = paramd;
      this.L = paramInt1;
      this.M = paramInt2;
      this.N = paramInt3;
      g();
      if ((!h()) && (this.t > 0) && (this.t != 2147483647) && (this.u > 0) && (this.u != 2147483647) && (getWidth() > 0) && (getHeight() > 0)) {
        a(new Point(this.t, this.u));
      }
      invalidate();
      requestLayout();
      return;
    }
    finally {}
  }
  
  @AnyThread
  private void a(String paramString, Object... paramVarArgs)
  {
    if (this.m) {
      Log.d(a, String.format(paramString, paramVarArgs));
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("reset newImage=");
    ((StringBuilder)localObject1).append(paramBoolean);
    a(((StringBuilder)localObject1).toString(), new Object[0]);
    this.D = 0.0F;
    this.E = 0.0F;
    this.F = null;
    this.G = null;
    this.H = null;
    this.I = Float.valueOf(0.0F);
    this.J = null;
    this.K = null;
    this.Q = false;
    this.R = false;
    this.S = false;
    this.T = 0;
    this.k = 0;
    this.ad = null;
    this.ae = 0.0F;
    this.ag = 0.0F;
    this.ah = false;
    this.aj = null;
    this.ai = null;
    this.ak = null;
    this.al = null;
    this.aw = null;
    this.ax = null;
    this.ay = null;
    if (paramBoolean)
    {
      this.j = null;
      this.aa.writeLock().lock();
    }
    Object localObject3;
    try
    {
      if (this.W != null)
      {
        this.W.b();
        this.W = null;
      }
      this.aa.writeLock().unlock();
      localObject1 = this.g;
      if ((localObject1 != null) && (!this.i)) {
        ((Bitmap)localObject1).recycle();
      }
      if ((this.g != null) && (this.i))
      {
        localObject1 = this.ao;
        if (localObject1 != null) {
          ((c.e)localObject1).c();
        }
      }
      this.L = 0;
      this.M = 0;
      this.N = 0;
      this.O = null;
      this.P = null;
      this.am = false;
      this.an = false;
      this.g = null;
      this.h = false;
      this.i = false;
    }
    finally
    {
      this.aa.writeLock().unlock();
    }
    if (localObject3 != null)
    {
      localObject3 = ((Map)localObject3).entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Iterator localIterator = ((List)((Map.Entry)((Iterator)localObject3).next()).getValue()).iterator();
        while (localIterator.hasNext())
        {
          c.h localh = (c.h)localIterator.next();
          c.h.a(localh, false);
          if (c.h.a(localh) != null)
          {
            c.h.a(localh).recycle();
            c.h.a(localh, null);
          }
        }
      }
      this.l = null;
    }
    setGestureDetector(getContext());
  }
  
  private void a(boolean paramBoolean, c.g paramg)
  {
    boolean bool = paramBoolean;
    if (this.r == 2)
    {
      bool = paramBoolean;
      if (a()) {
        bool = false;
      }
    }
    PointF localPointF = c.g.b(paramg);
    float f4 = f(c.g.a(paramg));
    float f3 = l() * f4;
    float f5 = m() * f4;
    if ((this.r == 3) && (a()))
    {
      localPointF.x = Math.max(localPointF.x, getWidth() / 2 - f3);
      localPointF.y = Math.max(localPointF.y, getHeight() / 2 - f5);
    }
    else if (bool)
    {
      localPointF.x = Math.max(localPointF.x, getWidth() - f3);
      localPointF.y = Math.max(localPointF.y, getHeight() - f5);
    }
    else
    {
      localPointF.x = Math.max(localPointF.x, -f3);
      localPointF.y = Math.max(localPointF.y, -f5);
    }
    int i1 = getPaddingLeft();
    float f2 = 0.5F;
    if ((i1 <= 0) && (getPaddingRight() <= 0)) {
      f1 = 0.5F;
    } else {
      f1 = getPaddingLeft() / (getPaddingLeft() + getPaddingRight());
    }
    if ((getPaddingTop() > 0) || (getPaddingBottom() > 0)) {
      f2 = getPaddingTop() / (getPaddingTop() + getPaddingBottom());
    }
    if ((this.r == 3) && (a()))
    {
      f1 = Math.max(0, getWidth() / 2);
      i1 = Math.max(0, getHeight() / 2);
    }
    else
    {
      if (bool)
      {
        f3 = Math.max(0.0F, (getWidth() - f3) * f1);
        f1 = Math.max(0.0F, (getHeight() - f5) * f2);
        f2 = f3;
        break label405;
      }
      f1 = Math.max(0, getWidth());
      i1 = Math.max(0, getHeight());
    }
    f3 = i1;
    f2 = f1;
    float f1 = f3;
    label405:
    localPointF.x = Math.min(localPointF.x, f2);
    localPointF.y = Math.min(localPointF.y, f1);
    c.g.a(paramg, f4);
  }
  
  private void a(float[] paramArrayOfFloat, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    paramArrayOfFloat[0] = paramFloat1;
    paramArrayOfFloat[1] = paramFloat2;
    paramArrayOfFloat[2] = paramFloat3;
    paramArrayOfFloat[3] = paramFloat4;
    paramArrayOfFloat[4] = paramFloat5;
    paramArrayOfFloat[5] = paramFloat6;
    paramArrayOfFloat[6] = paramFloat7;
    paramArrayOfFloat[7] = paramFloat8;
  }
  
  private boolean a(@NonNull MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getPointerCount();
    int i2 = paramMotionEvent.getAction();
    float f1;
    if (i2 != 0)
    {
      if (i2 != 1) {
        if (i2 != 2)
        {
          if (i2 == 5) {
            break label1915;
          }
          if (i2 != 6)
          {
            if (i2 == 261) {
              break label1915;
            }
            if (i2 != 262) {
              return false;
            }
          }
        }
        else
        {
          if (this.T > 0)
          {
            float f2;
            float f3;
            double d1;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            double d2;
            if (i1 >= 2)
            {
              f1 = a(paramMotionEvent.getX(0), paramMotionEvent.getX(1), paramMotionEvent.getY(0), paramMotionEvent.getY(1));
              f2 = (paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F;
              f3 = (paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F;
              if ((!this.y) || ((a(this.ad.x, f2, this.ad.y, f3) <= 5.0F) && (Math.abs(f1 - this.ae) <= 5.0F) && (!this.R))) {
                break label1690;
              }
              this.Q = true;
              this.R = true;
              d1 = this.D;
              this.D = Math.min(this.o, f1 / this.ae * this.E);
              if (this.D <= n())
              {
                this.ae = f1;
                this.E = n();
                this.ad.set(f2, f3);
                this.G.set(this.F);
              }
              else if (this.x)
              {
                f4 = this.ad.x;
                f5 = this.G.x;
                f6 = this.ad.y;
                f7 = this.G.y;
                float f9 = this.D;
                float f10 = this.E;
                f8 = f9 / f10;
                f9 /= f10;
                paramMotionEvent = this.F;
                paramMotionEvent.x = (f2 - (f4 - f5) * f8);
                paramMotionEvent.y = (f3 - (f6 - f7) * f9);
                d2 = m();
                Double.isNaN(d1);
                Double.isNaN(d2);
                if ((d2 * d1 >= getHeight()) || (this.D * m() < getHeight()))
                {
                  d2 = l();
                  Double.isNaN(d1);
                  Double.isNaN(d2);
                  if ((d1 * d2 >= getWidth()) || (this.D * l() < getWidth())) {}
                }
                else
                {
                  d(true);
                  this.ad.set(f2, f3);
                  this.G.set(this.F);
                  this.E = this.D;
                  this.ae = f1;
                }
              }
              else if (this.K != null)
              {
                this.F.x = (getWidth() / 2 - this.D * this.K.x);
                this.F.y = (getHeight() / 2 - this.D * this.K.y);
              }
              else
              {
                this.F.x = (getWidth() / 2 - this.D * (l() / 2));
                this.F.y = (getHeight() / 2 - this.D * (m() / 2));
              }
              d(true);
              c(this.w);
            }
            else
            {
              if (!this.S) {
                break label1278;
              }
              f2 = Math.abs(this.ak.y - paramMotionEvent.getY()) * 2.0F + this.af;
              if (this.ag == -1.0F) {
                this.ag = f2;
              }
              if (paramMotionEvent.getY() > this.ai.y) {
                i1 = 1;
              } else {
                i1 = 0;
              }
              this.ai.set(0.0F, paramMotionEvent.getY());
              f1 = f2 / this.ag;
              f3 = 1.0F;
              f4 = Math.abs(1.0F - f1) * 0.5F;
              if (f4 <= 0.03F)
              {
                f1 = f2;
                if (!this.ah) {}
              }
              else
              {
                this.ah = true;
                f1 = f3;
                if (this.ag > 0.0F) {
                  if (i1 != 0) {
                    f1 = f4 + 1.0F;
                  } else {
                    f1 = 1.0F - f4;
                  }
                }
                d1 = this.D;
                this.D = Math.max(n(), Math.min(this.o, this.D * f1));
                if (this.x)
                {
                  f1 = this.ad.x;
                  f3 = this.G.x;
                  f4 = this.ad.y;
                  f5 = this.G.y;
                  f7 = this.D;
                  f8 = this.E;
                  f6 = f7 / f8;
                  f7 /= f8;
                  this.F.x = (this.ad.x - (f1 - f3) * f6);
                  this.F.y = (this.ad.y - (f4 - f5) * f7);
                  d2 = m();
                  Double.isNaN(d1);
                  Double.isNaN(d2);
                  if ((d2 * d1 >= getHeight()) || (this.D * m() < getHeight()))
                  {
                    d2 = l();
                    Double.isNaN(d1);
                    Double.isNaN(d2);
                    f1 = f2;
                    if (d1 * d2 < getWidth())
                    {
                      f1 = f2;
                      if (this.D * l() < getWidth()) {}
                    }
                  }
                  else
                  {
                    d(true);
                    this.ad.set(b(this.aj));
                    this.G.set(this.F);
                    this.E = this.D;
                    f1 = 0.0F;
                  }
                }
                else if (this.K != null)
                {
                  this.F.x = (getWidth() / 2 - this.D * this.K.x);
                  this.F.y = (getHeight() / 2 - this.D * this.K.y);
                  f1 = f2;
                }
                else
                {
                  this.F.x = (getWidth() / 2 - this.D * (l() / 2));
                  this.F.y = (getHeight() / 2 - this.D * (m() / 2));
                  f1 = f2;
                }
              }
              this.ag = f1;
              d(true);
              c(this.w);
            }
            for (;;)
            {
              i1 = 1;
              break label1693;
              label1278:
              if (this.Q) {
                break;
              }
              f1 = Math.abs(paramMotionEvent.getX() - this.ad.x);
              f2 = Math.abs(paramMotionEvent.getY() - this.ad.y);
              f3 = this.aB * 5.0F;
              if ((f1 <= f3) && (f2 <= f3) && (!this.R)) {
                break;
              }
              this.F.x = (this.G.x + (paramMotionEvent.getX() - this.ad.x));
              this.F.y = (this.G.y + (paramMotionEvent.getY() - this.ad.y));
              f4 = this.F.x;
              f5 = this.F.y;
              d(true);
              if (f4 != this.F.x) {
                i1 = 1;
              } else {
                i1 = 0;
              }
              if (f5 != this.F.y) {
                i2 = 1;
              } else {
                i2 = 0;
              }
              int i3;
              if ((i1 != 0) && (f1 > f2) && (!this.R)) {
                i3 = 1;
              } else {
                i3 = 0;
              }
              int i4;
              if ((i2 != 0) && (f2 > f1) && (!this.R)) {
                i4 = 1;
              } else {
                i4 = 0;
              }
              int i5;
              if ((f5 == this.F.y) && (f2 > 3.0F * f3)) {
                i5 = 1;
              } else {
                i5 = 0;
              }
              if ((i3 == 0) && (i4 == 0) && ((i1 == 0) || (i2 == 0) || (i5 != 0) || (this.R)))
              {
                this.R = true;
              }
              else if ((f1 > f3) || (f2 > f3))
              {
                this.T = 0;
                this.ar.removeMessages(1);
                b(false);
              }
              if (!this.x)
              {
                this.F.x = this.G.x;
                this.F.y = this.G.y;
                b(false);
              }
              c(this.w);
            }
          }
          label1690:
          i1 = 0;
          label1693:
          if (i1 != 0)
          {
            this.ar.removeMessages(1);
            invalidate();
            return true;
          }
          return false;
        }
      }
      this.ar.removeMessages(1);
      if (this.S)
      {
        this.S = false;
        if (!this.ah) {
          a(this.aj, this.ad);
        }
      }
      if ((this.T > 0) && ((this.Q) || (this.R)))
      {
        if ((this.Q) && (i1 == 2))
        {
          this.R = true;
          this.G.set(this.F.x, this.F.y);
          if (paramMotionEvent.getActionIndex() == 1) {
            this.ad.set(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
          } else {
            this.ad.set(paramMotionEvent.getX(1), paramMotionEvent.getY(1));
          }
        }
        if (i1 < 3) {
          this.Q = false;
        }
        if (i1 < 2)
        {
          this.R = false;
          this.T = 0;
        }
        c(true);
        return true;
      }
      if (i1 == 1)
      {
        this.Q = false;
        this.R = false;
        this.T = 0;
      }
      return true;
    }
    label1915:
    this.al = null;
    b(true);
    this.T = Math.max(this.T, i1);
    if (i1 >= 2)
    {
      if (this.y)
      {
        f1 = a(paramMotionEvent.getX(0), paramMotionEvent.getX(1), paramMotionEvent.getY(0), paramMotionEvent.getY(1));
        this.E = this.D;
        this.ae = f1;
        this.G.set(this.F.x, this.F.y);
        this.ad.set((paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F, (paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F);
      }
      else
      {
        this.T = 0;
      }
      this.ar.removeMessages(1);
      return true;
    }
    if (!this.S)
    {
      this.G.set(this.F.x, this.F.y);
      this.ad.set(paramMotionEvent.getX(), paramMotionEvent.getY());
      this.ar.sendEmptyMessageDelayed(1, 600L);
    }
    return true;
  }
  
  private boolean a(c.h paramh)
  {
    float f1 = b(0.0F);
    float f2 = b(getWidth());
    float f3 = c(0.0F);
    float f4 = c(getHeight());
    return (f1 <= c.h.d(paramh).right) && (c.h.d(paramh).left <= f2) && (f3 <= c.h.d(paramh).bottom) && (c.h.d(paramh).top <= f4);
  }
  
  private float b(float paramFloat)
  {
    PointF localPointF = this.F;
    if (localPointF == null) {
      return (0.0F / 0.0F);
    }
    return (paramFloat - localPointF.x) / this.D;
  }
  
  private float b(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    float f2 = (float)paramLong1 / ((float)paramLong2 / 2.0F);
    float f1;
    if (f2 < 1.0F) {
      f1 = paramFloat2 / 2.0F * f2;
    }
    for (paramFloat2 = f2;; paramFloat2 = f2 * (f2 - 2.0F) - 1.0F)
    {
      return f1 * paramFloat2 + paramFloat1;
      f2 -= 1.0F;
      f1 = -paramFloat2 / 2.0F;
    }
  }
  
  private void b(Point paramPoint)
  {
    a("initialiseTileMap maxTileDimensions=%dx%d", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y) });
    this.l = new LinkedHashMap();
    int i1 = this.k;
    int i2 = 1;
    int i6 = 1;
    int i3 = l() / i2;
    int i8 = m() / i6;
    int i4 = i3 / i1;
    int i9 = i8 / i1;
    for (;;)
    {
      if (i4 + i2 + 1 <= paramPoint.x)
      {
        double d1 = i4;
        double d2 = getWidth();
        Double.isNaN(d2);
        i4 = i6;
        int i5 = i8;
        int i7 = i9;
        if (d1 > d2 * 1.25D)
        {
          i4 = i6;
          i5 = i8;
          i7 = i9;
          if (i1 < this.k) {}
        }
        else
        {
          for (;;)
          {
            if (i7 + i4 + 1 <= paramPoint.y)
            {
              d1 = i7;
              d2 = getHeight();
              Double.isNaN(d2);
              if ((d1 <= d2 * 1.25D) || (i1 >= this.k))
              {
                ArrayList localArrayList = new ArrayList(i2 * i4);
                i6 = 0;
                while (i6 < i2)
                {
                  i7 = 0;
                  while (i7 < i4)
                  {
                    c.h localh = new c.h(null);
                    c.h.a(localh, i1);
                    boolean bool;
                    if (i1 == this.k) {
                      bool = true;
                    } else {
                      bool = false;
                    }
                    c.h.a(localh, bool);
                    if (i6 == i2 - 1) {
                      i8 = l();
                    } else {
                      i8 = (i6 + 1) * i3;
                    }
                    if (i7 == i4 - 1) {
                      i9 = m();
                    } else {
                      i9 = (i7 + 1) * i5;
                    }
                    c.h.a(localh, new Rect(i6 * i3, i7 * i5, i8, i9));
                    c.h.b(localh, new Rect(0, 0, 0, 0));
                    c.h.c(localh, new Rect(c.h.d(localh)));
                    localArrayList.add(localh);
                    i7 += 1;
                  }
                  i6 += 1;
                }
                this.l.put(Integer.valueOf(i1), localArrayList);
                if (i1 == 1) {
                  return;
                }
                i1 /= 2;
                i6 = i4;
                break;
              }
            }
            i4 += 1;
            i5 = m() / i4;
            i7 = i5 / i1;
          }
        }
      }
      i2 += 1;
      i3 = l() / i2;
      i4 = i3 / i1;
    }
  }
  
  private void b(@NonNull Rect paramRect1, @NonNull Rect paramRect2)
  {
    paramRect2.set((int)d(paramRect1.left), (int)e(paramRect1.top), (int)d(paramRect1.right), (int)e(paramRect1.bottom));
  }
  
  private void b(boolean paramBoolean)
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  private float c(float paramFloat)
  {
    PointF localPointF = this.F;
    if (localPointF == null) {
      return (0.0F / 0.0F);
    }
    return (paramFloat - localPointF.y) / this.D;
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.W != null)
    {
      if (this.l == null) {
        return;
      }
      int i1 = Math.min(this.k, a(this.D));
      Iterator localIterator1 = this.l.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((List)((Map.Entry)localIterator1.next()).getValue()).iterator();
        while (localIterator2.hasNext())
        {
          c.h localh = (c.h)localIterator2.next();
          if ((c.h.f(localh) < i1) || ((c.h.f(localh) > i1) && (c.h.f(localh) != this.k)))
          {
            c.h.a(localh, false);
            if (c.h.a(localh) != null)
            {
              c.h.a(localh).recycle();
              c.h.a(localh, null);
            }
          }
          if (c.h.f(localh) == i1)
          {
            if (a(localh))
            {
              c.h.a(localh, true);
              if ((!c.h.c(localh)) && (c.h.a(localh) == null) && (paramBoolean)) {
                a(new c.i(this, this.W, localh));
              }
            }
            else if (c.h.f(localh) != this.k)
            {
              c.h.a(localh, false);
              if (c.h.a(localh) != null)
              {
                c.h.a(localh).recycle();
                c.h.a(localh, null);
              }
            }
          }
          else if (c.h.f(localh) == this.k) {
            c.h.a(localh, true);
          }
        }
      }
    }
  }
  
  private float d(float paramFloat)
  {
    PointF localPointF = this.F;
    if (localPointF == null) {
      return (0.0F / 0.0F);
    }
    return paramFloat * this.D + localPointF.x;
  }
  
  private void d(boolean paramBoolean)
  {
    int i1;
    if (this.F == null)
    {
      i1 = 1;
      this.F = new PointF(0.0F, 0.0F);
    }
    else
    {
      i1 = 0;
    }
    if (this.aw == null) {
      this.aw = new c.g(0.0F, new PointF(0.0F, 0.0F), null);
    }
    c.g.a(this.aw, this.D);
    c.g.b(this.aw).set(this.F);
    a(paramBoolean, this.aw);
    this.D = c.g.a(this.aw);
    this.F.set(c.g.b(this.aw));
    if ((i1 != 0) && (this.s != 4)) {
      this.F.set(a(l() / 2, m() / 2, this.D));
    }
  }
  
  private float e(float paramFloat)
  {
    PointF localPointF = this.F;
    if (localPointF == null) {
      return (0.0F / 0.0F);
    }
    return paramFloat * this.D + localPointF.y;
  }
  
  private float f(float paramFloat)
  {
    paramFloat = Math.max(n(), paramFloat);
    return Math.min(this.o, paramFloat);
  }
  
  private boolean f()
  {
    Object localObject1 = this.g;
    boolean bool1 = true;
    if ((localObject1 != null) && (!this.h)) {
      return true;
    }
    localObject1 = this.l;
    if (localObject1 != null)
    {
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (((Integer)((Map.Entry)localObject2).getKey()).intValue() == this.k)
        {
          localObject2 = ((List)((Map.Entry)localObject2).getValue()).iterator();
          for (boolean bool2 = bool1;; bool2 = false)
          {
            c.h localh;
            do
            {
              bool1 = bool2;
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localh = (c.h)((Iterator)localObject2).next();
            } while ((!c.h.c(localh)) && (c.h.a(localh) != null));
          }
        }
      }
      return bool1;
    }
    return false;
  }
  
  private boolean g()
  {
    boolean bool;
    if ((getWidth() > 0) && (getHeight() > 0) && (this.L > 0) && (this.M > 0) && ((this.g != null) || (f()))) {
      bool = true;
    } else {
      bool = false;
    }
    if ((!this.am) && (bool))
    {
      j();
      this.am = true;
      b();
      c.e locale = this.ao;
      if (locale != null) {
        locale.a();
      }
    }
    return bool;
  }
  
  public static Bitmap.Config getPreferredBitmapConfig()
  {
    return aC;
  }
  
  @AnyThread
  private int getRequiredRotation()
  {
    int i2 = this.n;
    int i1 = i2;
    if (i2 == -1) {
      i1 = this.N;
    }
    return i1;
  }
  
  private boolean h()
  {
    boolean bool = f();
    if ((!this.an) && (bool))
    {
      j();
      this.an = true;
      c();
      c.e locale = this.ao;
      if (locale != null) {
        locale.b();
      }
    }
    return bool;
  }
  
  private void i()
  {
    if (this.as == null)
    {
      this.as = new Paint();
      this.as.setAntiAlias(true);
      this.as.setFilterBitmap(true);
      this.as.setDither(true);
    }
    if (((this.at == null) || (this.au == null)) && (this.m))
    {
      this.at = new Paint();
      this.at.setTextSize(a(12));
      this.at.setColor(-65281);
      this.at.setStyle(Paint.Style.FILL);
      this.au = new Paint();
      this.au.setColor(-65281);
      this.au.setStyle(Paint.Style.STROKE);
      this.au.setStrokeWidth(a(1));
    }
  }
  
  private void j()
  {
    if ((getWidth() != 0) && (getHeight() != 0) && (this.L > 0))
    {
      if (this.M <= 0) {
        return;
      }
      if (this.J != null)
      {
        Float localFloat = this.I;
        if (localFloat != null)
        {
          this.D = localFloat.floatValue();
          if (this.F == null) {
            this.F = new PointF();
          }
          this.F.x = (getWidth() / 2 - this.D * this.J.x);
          this.F.y = (getHeight() / 2 - this.D * this.J.y);
          this.J = null;
          this.I = null;
          d(true);
          c(true);
        }
      }
      d(false);
    }
  }
  
  private void k()
  {
    try
    {
      a("onTileLoaded", new Object[0]);
      g();
      h();
      if ((f()) && (this.g != null))
      {
        if (!this.i) {
          this.g.recycle();
        }
        this.g = null;
        if ((this.ao != null) && (this.i)) {
          this.ao.c();
        }
        this.h = false;
        this.i = false;
      }
      invalidate();
      return;
    }
    finally {}
  }
  
  private int l()
  {
    int i1 = getRequiredRotation();
    if ((i1 != 90) && (i1 != 270)) {
      return this.L;
    }
    return this.M;
  }
  
  private int m()
  {
    int i1 = getRequiredRotation();
    if ((i1 != 90) && (i1 != 270)) {
      return this.M;
    }
    return this.L;
  }
  
  private float n()
  {
    int i1 = getPaddingBottom() + getPaddingTop();
    int i2 = getPaddingLeft() + getPaddingRight();
    int i3 = this.s;
    if ((i3 != 2) && (i3 != 4))
    {
      if (i3 == 3)
      {
        float f1 = this.p;
        if (f1 > 0.0F) {
          return f1;
        }
      }
      return Math.min((getWidth() - i2) / l(), (getHeight() - i1) / m());
    }
    return Math.max((getWidth() - i2) / l(), (getHeight() - i1) / m());
  }
  
  private void setGestureDetector(Context paramContext)
  {
    this.U = new GestureDetector(paramContext, new c.2(this, paramContext));
    this.V = new GestureDetector(paramContext, new c.3(this));
  }
  
  public static void setPreferredBitmapConfig(Bitmap.Config paramConfig)
  {
    aC = paramConfig;
  }
  
  @Nullable
  public final PointF a(float paramFloat1, float paramFloat2)
  {
    return a(paramFloat1, paramFloat2, new PointF());
  }
  
  @Nullable
  public final PointF a(float paramFloat1, float paramFloat2, @NonNull PointF paramPointF)
  {
    if (this.F == null) {
      return null;
    }
    paramPointF.set(b(paramFloat1), c(paramFloat2));
    return paramPointF;
  }
  
  @Nullable
  public final PointF a(PointF paramPointF)
  {
    return a(paramPointF.x, paramPointF.y, new PointF());
  }
  
  public final void a(float paramFloat, @Nullable PointF paramPointF)
  {
    this.al = null;
    this.I = Float.valueOf(paramFloat);
    this.J = paramPointF;
    this.K = paramPointF;
    invalidate();
  }
  
  public final void a(@NonNull a parama1, a parama2, b paramb)
  {
    if (parama1 != null)
    {
      a(true);
      if (paramb != null) {
        a(paramb);
      }
      if (parama2 != null) {
        if (parama1.b() == null)
        {
          if ((parama1.e() > 0) && (parama1.f() > 0))
          {
            this.L = parama1.e();
            this.M = parama1.f();
            this.P = parama2.g();
            if (parama2.b() != null)
            {
              this.i = parama2.h();
              a(parama2.b());
            }
            else
            {
              Uri localUri = parama2.a();
              paramb = localUri;
              if (localUri == null)
              {
                paramb = localUri;
                if (parama2.c() != null)
                {
                  paramb = new StringBuilder();
                  paramb.append("android.resource://");
                  paramb.append(getContext().getPackageName());
                  paramb.append("/");
                  paramb.append(parama2.c());
                  paramb = Uri.parse(paramb.toString());
                }
              }
              a(new c.c(this, getContext(), this.ab, paramb, true));
            }
          }
          else
          {
            throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
          }
        }
        else {
          throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
        }
      }
      if ((parama1.b() != null) && (parama1.g() != null))
      {
        a(Bitmap.createBitmap(parama1.b(), parama1.g().left, parama1.g().top, parama1.g().width(), parama1.g().height()), 0, false);
        return;
      }
      if (parama1.b() != null)
      {
        a(parama1.b(), 0, parama1.h());
        return;
      }
      this.O = parama1.g();
      this.j = parama1.a();
      if ((this.j == null) && (parama1.c() != null))
      {
        parama2 = new StringBuilder();
        parama2.append("android.resource://");
        parama2.append(getContext().getPackageName());
        parama2.append("/");
        parama2.append(parama1.c());
        this.j = Uri.parse(parama2.toString());
      }
      if ((!parama1.d()) && (this.O == null))
      {
        a(new c.c(this, getContext(), this.ab, this.j, false));
        return;
      }
      a(new c.j(this, getContext(), this.ac, this.j));
      return;
    }
    throw new NullPointerException("imageSource must not be null");
  }
  
  public final boolean a()
  {
    return this.am;
  }
  
  @Nullable
  public final PointF b(float paramFloat1, float paramFloat2, @NonNull PointF paramPointF)
  {
    if (this.F == null) {
      return null;
    }
    paramPointF.set(d(paramFloat1), e(paramFloat2));
    return paramPointF;
  }
  
  @Nullable
  public final PointF b(PointF paramPointF)
  {
    return b(paramPointF.x, paramPointF.y, new PointF());
  }
  
  protected void b() {}
  
  protected void c() {}
  
  public final int getAppliedOrientation()
  {
    return getRequiredRotation();
  }
  
  @Nullable
  public final PointF getCenter()
  {
    int i1 = getWidth() / 2;
    int i2 = getHeight() / 2;
    return a(i1, i2);
  }
  
  public float getMaxScale()
  {
    return this.o;
  }
  
  public final float getMinScale()
  {
    return n();
  }
  
  public final int getOrientation()
  {
    return this.n;
  }
  
  public final int getSHeight()
  {
    return this.M;
  }
  
  public final int getSWidth()
  {
    return this.L;
  }
  
  public final float getScale()
  {
    return this.D;
  }
  
  @Nullable
  public Uri getSourceUri()
  {
    return this.j;
  }
  
  @Nullable
  public final b getState()
  {
    if ((this.F != null) && (this.L > 0) && (this.M > 0)) {
      return new b(getScale(), getCenter(), getOrientation());
    }
    return null;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    i();
    if ((this.L != 0) && (this.M != 0) && (getWidth() != 0))
    {
      if (getHeight() == 0) {
        return;
      }
      if ((this.l == null) && (this.W != null)) {
        a(a(paramCanvas));
      }
      if (!g()) {
        return;
      }
      j();
      Object localObject1 = this.al;
      float f1;
      float f2;
      float f3;
      if ((localObject1 != null) && (c.a.c((c.a)localObject1) != null))
      {
        f1 = this.D;
        if (this.H == null) {
          this.H = new PointF(0.0F, 0.0F);
        }
        this.H.set(this.F);
        long l1 = System.currentTimeMillis() - c.a.d(this.al);
        boolean bool1;
        if (l1 > c.a.e(this.al)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        l1 = Math.min(l1, c.a.e(this.al));
        this.D = a(c.a.f(this.al), l1, c.a.g(this.al), c.a.h(this.al) - c.a.g(this.al), c.a.e(this.al));
        f2 = a(c.a.f(this.al), l1, c.a.c(this.al).x, c.a.i(this.al).x - c.a.c(this.al).x, c.a.e(this.al));
        f3 = a(c.a.f(this.al), l1, c.a.c(this.al).y, c.a.i(this.al).y - c.a.c(this.al).y, c.a.e(this.al));
        localObject1 = this.F;
        ((PointF)localObject1).x -= d(c.a.j(this.al).x) - f2;
        localObject1 = this.F;
        ((PointF)localObject1).y -= e(c.a.j(this.al).y) - f3;
        boolean bool2;
        if ((!bool1) && (c.a.g(this.al) != c.a.h(this.al))) {
          bool2 = false;
        } else {
          bool2 = true;
        }
        d(bool2);
        a(f1, this.H, c.a.k(this.al));
        c(bool1);
        if (bool1)
        {
          if (c.a.b(this.al) != null) {
            try
            {
              c.a.b(this.al).a();
            }
            catch (Exception localException)
            {
              Log.w(a, "Error thrown by animation listener", localException);
            }
          }
          this.al = null;
        }
        invalidate();
      }
      Object localObject2;
      int i1;
      Object localObject3;
      Object localObject4;
      if ((this.l != null) && (f()))
      {
        int i3 = Math.min(this.k, a(this.D));
        localObject2 = this.l.entrySet().iterator();
        i1 = 0;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          if (((Integer)((Map.Entry)localObject3).getKey()).intValue() == i3)
          {
            localObject3 = ((List)((Map.Entry)localObject3).getValue()).iterator();
            for (int i2 = i1;; i2 = 1) {
              do
              {
                i1 = i2;
                if (!((Iterator)localObject3).hasNext()) {
                  break;
                }
                localObject4 = (c.h)((Iterator)localObject3).next();
              } while ((!c.h.b((c.h)localObject4)) || ((!c.h.c((c.h)localObject4)) && (c.h.a((c.h)localObject4) != null)));
            }
          }
        }
        localObject2 = this.l.entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          if ((((Integer)((Map.Entry)localObject3).getKey()).intValue() != i3) && (i1 == 0)) {}
          for (;;)
          {
            break;
            localObject3 = ((List)((Map.Entry)localObject3).getValue()).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (c.h)((Iterator)localObject3).next();
              b(c.h.d((c.h)localObject4), c.h.e((c.h)localObject4));
              if ((!c.h.c((c.h)localObject4)) && (c.h.a((c.h)localObject4) != null))
              {
                if (this.av != null) {
                  paramCanvas.drawRect(c.h.e((c.h)localObject4), this.av);
                }
                if (this.ax == null) {
                  this.ax = new Matrix();
                }
                this.ax.reset();
                a(this.az, 0.0F, 0.0F, c.h.a((c.h)localObject4).getWidth(), 0.0F, c.h.a((c.h)localObject4).getWidth(), c.h.a((c.h)localObject4).getHeight(), 0.0F, c.h.a((c.h)localObject4).getHeight());
                if (getRequiredRotation() == 0) {
                  a(this.aA, c.h.e((c.h)localObject4).left, c.h.e((c.h)localObject4).top, c.h.e((c.h)localObject4).right, c.h.e((c.h)localObject4).top, c.h.e((c.h)localObject4).right, c.h.e((c.h)localObject4).bottom, c.h.e((c.h)localObject4).left, c.h.e((c.h)localObject4).bottom);
                } else if (getRequiredRotation() == 90) {
                  a(this.aA, c.h.e((c.h)localObject4).right, c.h.e((c.h)localObject4).top, c.h.e((c.h)localObject4).right, c.h.e((c.h)localObject4).bottom, c.h.e((c.h)localObject4).left, c.h.e((c.h)localObject4).bottom, c.h.e((c.h)localObject4).left, c.h.e((c.h)localObject4).top);
                } else if (getRequiredRotation() == 180) {
                  a(this.aA, c.h.e((c.h)localObject4).right, c.h.e((c.h)localObject4).bottom, c.h.e((c.h)localObject4).left, c.h.e((c.h)localObject4).bottom, c.h.e((c.h)localObject4).left, c.h.e((c.h)localObject4).top, c.h.e((c.h)localObject4).right, c.h.e((c.h)localObject4).top);
                } else if (getRequiredRotation() == 270) {
                  a(this.aA, c.h.e((c.h)localObject4).left, c.h.e((c.h)localObject4).bottom, c.h.e((c.h)localObject4).left, c.h.e((c.h)localObject4).top, c.h.e((c.h)localObject4).right, c.h.e((c.h)localObject4).top, c.h.e((c.h)localObject4).right, c.h.e((c.h)localObject4).bottom);
                }
                this.ax.setPolyToPoly(this.az, 0, this.aA, 0, 4);
                paramCanvas.drawBitmap(c.h.a((c.h)localObject4), this.ax, this.as);
                if (this.m) {
                  paramCanvas.drawRect(c.h.e((c.h)localObject4), this.au);
                }
              }
              else if ((c.h.c((c.h)localObject4)) && (this.m))
              {
                paramCanvas.drawText("LOADING", c.h.e((c.h)localObject4).left + a(5), c.h.e((c.h)localObject4).top + a(35), this.at);
              }
              if ((c.h.b((c.h)localObject4)) && (this.m))
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("ISS ");
                localStringBuilder.append(c.h.f((c.h)localObject4));
                localStringBuilder.append(" RECT ");
                localStringBuilder.append(c.h.d((c.h)localObject4).top);
                localStringBuilder.append(",");
                localStringBuilder.append(c.h.d((c.h)localObject4).left);
                localStringBuilder.append(",");
                localStringBuilder.append(c.h.d((c.h)localObject4).bottom);
                localStringBuilder.append(",");
                localStringBuilder.append(c.h.d((c.h)localObject4).right);
                paramCanvas.drawText(localStringBuilder.toString(), c.h.e((c.h)localObject4).left + a(5), c.h.e((c.h)localObject4).top + a(15), this.at);
              }
            }
          }
        }
      }
      else
      {
        localObject2 = this.g;
        if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
        {
          f1 = this.D;
          if (this.h)
          {
            f2 = this.L / this.g.getWidth();
            f3 = this.D;
            float f4 = this.M / this.g.getHeight();
            f2 = f1 * f2;
            f1 = f3 * f4;
          }
          else
          {
            f2 = f1;
          }
          if (this.ax == null) {
            this.ax = new Matrix();
          }
          this.ax.reset();
          this.ax.postScale(f2, f1);
          this.ax.postRotate(getRequiredRotation());
          this.ax.postTranslate(this.F.x, this.F.y);
          if (getRequiredRotation() == 180)
          {
            localObject2 = this.ax;
            f1 = this.D;
            ((Matrix)localObject2).postTranslate(this.L * f1, f1 * this.M);
          }
          else if (getRequiredRotation() == 90)
          {
            this.ax.postTranslate(this.D * this.M, 0.0F);
          }
          else if (getRequiredRotation() == 270)
          {
            this.ax.postTranslate(0.0F, this.D * this.L);
          }
          if (this.av != null)
          {
            if (this.ay == null) {
              this.ay = new RectF();
            }
            localObject2 = this.ay;
            if (this.h) {
              i1 = this.g.getWidth();
            } else {
              i1 = this.L;
            }
            f1 = i1;
            if (this.h) {
              i1 = this.g.getHeight();
            } else {
              i1 = this.M;
            }
            ((RectF)localObject2).set(0.0F, 0.0F, f1, i1);
            this.ax.mapRect(this.ay);
            paramCanvas.drawRect(this.ay, this.av);
          }
          paramCanvas.drawBitmap(this.g, this.ax, this.as);
        }
      }
      if (this.m)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Scale: ");
        ((StringBuilder)localObject2).append(String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.D) }));
        ((StringBuilder)localObject2).append(" (");
        ((StringBuilder)localObject2).append(String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(n()) }));
        ((StringBuilder)localObject2).append(" - ");
        ((StringBuilder)localObject2).append(String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.o) }));
        ((StringBuilder)localObject2).append(")");
        paramCanvas.drawText(((StringBuilder)localObject2).toString(), a(5), a(15), this.at);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Translate: ");
        ((StringBuilder)localObject2).append(String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.F.x) }));
        ((StringBuilder)localObject2).append(":");
        ((StringBuilder)localObject2).append(String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.F.y) }));
        paramCanvas.drawText(((StringBuilder)localObject2).toString(), a(5), a(30), this.at);
        localObject2 = getCenter();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("Source center: ");
        ((StringBuilder)localObject3).append(String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(((PointF)localObject2).x) }));
        ((StringBuilder)localObject3).append(":");
        ((StringBuilder)localObject3).append(String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(((PointF)localObject2).y) }));
        paramCanvas.drawText(((StringBuilder)localObject3).toString(), a(5), a(45), this.at);
        localObject2 = this.al;
        if (localObject2 != null)
        {
          localObject2 = b(c.a.l((c.a)localObject2));
          localObject3 = b(c.a.m(this.al));
          localObject4 = b(c.a.j(this.al));
          paramCanvas.drawCircle(((PointF)localObject2).x, ((PointF)localObject2).y, a(10), this.au);
          this.au.setColor(-65536);
          paramCanvas.drawCircle(((PointF)localObject3).x, ((PointF)localObject3).y, a(20), this.au);
          this.au.setColor(-16776961);
          paramCanvas.drawCircle(((PointF)localObject4).x, ((PointF)localObject4).y, a(25), this.au);
          this.au.setColor(-16711681);
          paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, a(30), this.au);
        }
        if (this.ad != null)
        {
          this.au.setColor(-65536);
          paramCanvas.drawCircle(this.ad.x, this.ad.y, a(20), this.au);
        }
        if (this.aj != null)
        {
          this.au.setColor(-16776961);
          paramCanvas.drawCircle(d(this.aj.x), e(this.aj.y), a(35), this.au);
        }
        if ((this.ak != null) && (this.S))
        {
          this.au.setColor(-16711681);
          paramCanvas.drawCircle(this.ak.x, this.ak.y, a(30), this.au);
        }
        this.au.setColor(-65281);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int i5 = View.MeasureSpec.getMode(paramInt2);
    int i3 = View.MeasureSpec.getSize(paramInt1);
    int i4 = View.MeasureSpec.getSize(paramInt2);
    int i2 = 1;
    if (i1 != 1073741824) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i5 == 1073741824) {
      i2 = 0;
    }
    paramInt1 = i3;
    paramInt2 = i4;
    if (this.L > 0)
    {
      paramInt1 = i3;
      paramInt2 = i4;
      if (this.M > 0) {
        if ((i1 != 0) && (i2 != 0))
        {
          paramInt1 = l();
          paramInt2 = m();
        }
        else
        {
          double d1;
          double d2;
          if (i2 != 0)
          {
            d1 = m();
            d2 = l();
            Double.isNaN(d1);
            Double.isNaN(d2);
            d1 /= d2;
            d2 = i3;
            Double.isNaN(d2);
            paramInt2 = (int)(d1 * d2);
            paramInt1 = i3;
          }
          else
          {
            paramInt1 = i3;
            paramInt2 = i4;
            if (i1 != 0)
            {
              d1 = l();
              d2 = m();
              Double.isNaN(d1);
              Double.isNaN(d2);
              d1 /= d2;
              d2 = i4;
              Double.isNaN(d2);
              paramInt1 = (int)(d1 * d2);
              paramInt2 = i4;
            }
          }
        }
      }
    }
    setMeasuredDimension(Math.max(paramInt1, getSuggestedMinimumWidth()), Math.max(paramInt2, getSuggestedMinimumHeight()));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a("onSizeChanged %dx%d -> %dx%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    PointF localPointF = getCenter();
    if ((this.am) && (localPointF != null))
    {
      this.al = null;
      this.I = Float.valueOf(this.D);
      this.J = localPointF;
    }
  }
  
  public boolean onTouchEvent(@NonNull MotionEvent paramMotionEvent)
  {
    c.a locala = this.al;
    boolean bool1 = true;
    if ((locala != null) && (!c.a.a(locala)))
    {
      b(true);
      return true;
    }
    locala = this.al;
    if ((locala != null) && (c.a.b(locala) != null)) {
      try
      {
        c.a.b(this.al).b();
      }
      catch (Exception localException)
      {
        Log.w(a, "Error thrown by animation listener", localException);
      }
    }
    this.al = null;
    GestureDetector localGestureDetector;
    if (this.F == null)
    {
      localGestureDetector = this.V;
      if (localGestureDetector != null) {
        localGestureDetector.onTouchEvent(paramMotionEvent);
      }
      return true;
    }
    if (!this.S)
    {
      localGestureDetector = this.U;
      if ((localGestureDetector == null) || (localGestureDetector.onTouchEvent(paramMotionEvent)))
      {
        this.Q = false;
        this.R = false;
        this.T = 0;
        return true;
      }
    }
    if (this.G == null) {
      this.G = new PointF(0.0F, 0.0F);
    }
    if (this.H == null) {
      this.H = new PointF(0.0F, 0.0F);
    }
    if (this.ad == null) {
      this.ad = new PointF(0.0F, 0.0F);
    }
    float f1 = this.D;
    this.H.set(this.F);
    boolean bool2 = a(paramMotionEvent);
    a(f1, this.H, 2);
    if (!bool2)
    {
      if (super.onTouchEvent(paramMotionEvent)) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public final void setBitmapDecoderClass(@NonNull Class<? extends com.tencent.luggage.widget.decoder.c> paramClass)
  {
    if (paramClass != null)
    {
      this.ab = new com.tencent.luggage.widget.decoder.a(paramClass);
      return;
    }
    throw new IllegalArgumentException("Decoder class cannot be set to null");
  }
  
  public final void setBitmapDecoderFactory(@NonNull com.tencent.luggage.widget.decoder.b<? extends com.tencent.luggage.widget.decoder.c> paramb)
  {
    if (paramb != null)
    {
      this.ab = paramb;
      return;
    }
    throw new IllegalArgumentException("Decoder factory cannot be set to null");
  }
  
  public final void setDebug(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public final void setDoubleTapZoomDpi(int paramInt)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    setDoubleTapZoomScale((localDisplayMetrics.xdpi + localDisplayMetrics.ydpi) / 2.0F / paramInt);
  }
  
  public final void setDoubleTapZoomDuration(int paramInt)
  {
    this.C = Math.max(0, paramInt);
  }
  
  public final void setDoubleTapZoomScale(float paramFloat)
  {
    this.A = paramFloat;
  }
  
  public final void setDoubleTapZoomStyle(int paramInt)
  {
    if (c.contains(Integer.valueOf(paramInt)))
    {
      this.B = paramInt;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid zoom style: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void setEagerLoadingEnabled(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }
  
  public void setExecutor(@NonNull Executor paramExecutor)
  {
    if (paramExecutor != null)
    {
      this.v = paramExecutor;
      return;
    }
    throw new NullPointerException("Executor must not be null");
  }
  
  public final void setImage(@NonNull a parama)
  {
    a(parama, null, null);
  }
  
  public final void setMaxScale(float paramFloat)
  {
    this.o = paramFloat;
  }
  
  public void setMaxTileSize(int paramInt)
  {
    this.t = paramInt;
    this.u = paramInt;
  }
  
  public final void setMaximumDpi(int paramInt)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    setMinScale((localDisplayMetrics.xdpi + localDisplayMetrics.ydpi) / 2.0F / paramInt);
  }
  
  public final void setMinScale(float paramFloat)
  {
    this.p = paramFloat;
  }
  
  public final void setMinimumDpi(int paramInt)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    setMaxScale((localDisplayMetrics.xdpi + localDisplayMetrics.ydpi) / 2.0F / paramInt);
  }
  
  public final void setMinimumScaleType(int paramInt)
  {
    if (f.contains(Integer.valueOf(paramInt)))
    {
      this.s = paramInt;
      if (a())
      {
        d(true);
        invalidate();
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid scale type: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void setMinimumTileDpi(int paramInt)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.q = ((int)Math.min((localDisplayMetrics.xdpi + localDisplayMetrics.ydpi) / 2.0F, paramInt));
    if (a())
    {
      a(false);
      invalidate();
    }
  }
  
  public void setOnImageEventListener(c.e parame)
  {
    this.ao = parame;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.aq = paramOnLongClickListener;
  }
  
  public void setOnStateChangedListener(c.f paramf)
  {
    this.ap = paramf;
  }
  
  public final void setOrientation(int paramInt)
  {
    if (b.contains(Integer.valueOf(paramInt)))
    {
      this.n = paramInt;
      a(false);
      invalidate();
      requestLayout();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid orientation: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public final void setPanEnabled(boolean paramBoolean)
  {
    this.x = paramBoolean;
    if (!paramBoolean)
    {
      PointF localPointF = this.F;
      if (localPointF != null)
      {
        localPointF.x = (getWidth() / 2 - this.D * (l() / 2));
        this.F.y = (getHeight() / 2 - this.D * (m() / 2));
        if (a())
        {
          c(true);
          invalidate();
        }
      }
    }
  }
  
  public final void setPanLimit(int paramInt)
  {
    if (e.contains(Integer.valueOf(paramInt)))
    {
      this.r = paramInt;
      if (a())
      {
        d(true);
        invalidate();
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid pan limit: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public final void setQuickScaleEnabled(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }
  
  public final void setRegionDecoderClass(@NonNull Class<? extends d> paramClass)
  {
    if (paramClass != null)
    {
      this.ac = new com.tencent.luggage.widget.decoder.a(paramClass);
      return;
    }
    throw new IllegalArgumentException("Decoder class cannot be set to null");
  }
  
  public final void setRegionDecoderFactory(@NonNull com.tencent.luggage.widget.decoder.b<? extends d> paramb)
  {
    if (paramb != null)
    {
      this.ac = paramb;
      return;
    }
    throw new IllegalArgumentException("Decoder factory cannot be set to null");
  }
  
  public final void setTileBackgroundColor(int paramInt)
  {
    if (Color.alpha(paramInt) == 0)
    {
      this.av = null;
    }
    else
    {
      this.av = new Paint();
      this.av.setStyle(Paint.Style.FILL);
      this.av.setColor(paramInt);
    }
    invalidate();
  }
  
  public final void setZoomEnabled(boolean paramBoolean)
  {
    this.y = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.widget.c
 * JD-Core Version:    0.7.0.1
 */