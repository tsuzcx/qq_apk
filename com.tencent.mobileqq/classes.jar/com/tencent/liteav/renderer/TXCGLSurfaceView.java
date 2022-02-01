package com.tencent.liteav.renderer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.AttributeSet;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.c.h;
import com.tencent.liteav.basic.c.j;
import com.tencent.liteav.basic.c.k;
import com.tencent.liteav.basic.c.l;
import com.tencent.liteav.basic.c.m;
import com.tencent.liteav.basic.c.n;
import com.tencent.liteav.basic.c.o;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;

public class TXCGLSurfaceView
  extends TXCGLSurfaceViewBase
  implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer, m
{
  private o A = null;
  private int B = 0;
  private int C = 0;
  private boolean D = true;
  private boolean E = true;
  private n F;
  private long G;
  private byte[] H = null;
  private long I = 0L;
  private int J = 0;
  private int K = 0;
  private final Queue<Runnable> L = new LinkedList();
  WeakReference<b> a;
  private SurfaceTexture g;
  private EGLContext h;
  private h i;
  private int[] j;
  private float[] k = new float[16];
  private int l = 0;
  private boolean m = false;
  private float n = 1.0F;
  private float o = 1.0F;
  private int p = 20;
  private long q = 0L;
  private long r = 0L;
  private int s = 12288;
  private boolean t = true;
  private boolean u = false;
  private Object v = new Object();
  private Handler w;
  private int x = 0;
  private int y = 0;
  private boolean z = true;
  
  public TXCGLSurfaceView(Context paramContext)
  {
    super(paramContext);
    setEGLContextClientVersion(2);
    a(8, 8, 8, 8, 16, 0);
    setRenderer(this);
  }
  
  public TXCGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setEGLContextClientVersion(2);
    a(8, 8, 8, 8, 16, 0);
    setRenderer(this);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.z)
    {
      int i1 = this.x;
      if (i1 != 0)
      {
        int i2 = this.y;
        if (i2 != 0)
        {
          int i3;
          if (i1 <= i2) {
            i3 = 1;
          } else {
            i3 = 0;
          }
          i1 = this.y;
          i2 = this.x;
          if (i1 < i2) {
            i1 = i2;
          }
          int i4 = this.y;
          int i5 = this.x;
          i2 = i4;
          if (i4 >= i5) {
            i2 = i5;
          }
          i5 = i1;
          i4 = i2;
          if (i3 != 0)
          {
            i4 = i1;
            i5 = i2;
          }
          ByteBuffer localByteBuffer = ByteBuffer.allocate(i5 * i4 * 4);
          Bitmap localBitmap = Bitmap.createBitmap(i5, i4, Bitmap.Config.ARGB_8888);
          localByteBuffer.position(0);
          GLES20.glReadPixels(paramInt1, paramInt2, i5, i4, 6408, 5121, localByteBuffer);
          o localo = this.A;
          if (localo != null) {
            new Thread(new TXCGLSurfaceView.5(this, localByteBuffer, localBitmap, i5, i4, localo)).start();
          }
        }
      }
      this.A = null;
      this.z = false;
    }
  }
  
  private void a(long paramLong)
  {
    try
    {
      Thread.sleep(paramLong);
      return;
    }
    catch (Exception localException) {}
  }
  
  private boolean a(Queue<Runnable> paramQueue)
  {
    try
    {
      if (paramQueue.isEmpty()) {
        return false;
      }
      Runnable localRunnable = (Runnable)paramQueue.poll();
      if (localRunnable == null) {
        return false;
      }
      localRunnable.run();
      return true;
    }
    finally {}
  }
  
  private int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = paramInt2;
    float f2 = paramInt1;
    float f3 = f1 / f2;
    float f4 = paramInt4 / paramInt3;
    if (f3 > f4)
    {
      paramInt3 = (int)(f2 * f4);
      paramInt2 = (paramInt2 - paramInt3) / 2;
      paramInt4 = 0;
    }
    else
    {
      paramInt3 = (int)(f1 / f4);
      paramInt4 = (paramInt1 - paramInt3) / 2;
      int i1 = 0;
      paramInt1 = paramInt3;
      paramInt3 = paramInt2;
      paramInt2 = i1;
    }
    return new int[] { paramInt1, paramInt3, paramInt4, paramInt2 };
  }
  
  private void g()
  {
    Object localObject;
    if (this.E)
    {
      if (this.g != null)
      {
        if (Build.VERSION.SDK_INT >= 21)
        {
          if (this.w == null)
          {
            localObject = new HandlerThread("VideoCaptureThread");
            ((HandlerThread)localObject).start();
            this.w = new Handler(((HandlerThread)localObject).getLooper());
          }
          this.g.setOnFrameAvailableListener(this, this.w);
          return;
        }
        this.g.setOnFrameAvailableListener(this);
      }
    }
    else
    {
      localObject = this.g;
      if (localObject != null) {
        ((SurfaceTexture)localObject).setOnFrameAvailableListener(null);
      }
    }
  }
  
  public void a()
  {
    b(false);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.p = paramInt;
    paramInt = this.p;
    if (paramInt <= 0) {
      this.p = 1;
    } else if (paramInt > 60) {
      this.p = 60;
    }
    this.A = null;
    this.z = false;
    this.J = 0;
    this.I = 0L;
    this.K = 0;
    b(true);
    this.E = paramBoolean;
    this.G = 0L;
    g();
  }
  
  public void a(int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2)
  {
    if (this.i == null) {
      return;
    }
    try
    {
      if (this.c) {
        return;
      }
      GLES20.glClear(16640);
      int i5 = getWidth();
      int i6 = getHeight();
      int i1 = this.B;
      int i2;
      Object localObject1;
      int i3;
      int i4;
      if ((i1 != 0) && (i1 == 1))
      {
        i1 = (720 - paramInt2) % 360;
        if ((i1 != 90) && (i1 != 270)) {
          i2 = 0;
        } else {
          i2 = 1;
        }
        if (i2 != 0) {
          i1 = paramInt4;
        } else {
          i1 = paramInt3;
        }
        if (i2 != 0) {
          i2 = paramInt3;
        } else {
          i2 = paramInt4;
        }
        localObject1 = a(i5, i6, i1, i2);
        i1 = localObject1[0];
        i2 = localObject1[1];
        i3 = localObject1[2];
        i4 = localObject1[3];
      }
      else
      {
        i3 = 0;
        i4 = 0;
        i2 = i6;
        i1 = i5;
      }
      this.x = i1;
      this.y = i2;
      GLES20.glViewport(i3, i4, i1, i2);
      i5 = this.C;
      if (i5 == 1)
      {
        if (paramBoolean2) {}
      }
      else {
        while ((i5 == 2) && (paramBoolean2))
        {
          paramBoolean1 ^= true;
          break;
        }
      }
      float f1;
      if (i2 != 0) {
        f1 = i1 / i2;
      } else {
        f1 = 1.0F;
      }
      float f2;
      if (paramInt4 != 0) {
        f2 = paramInt3 / paramInt4;
      } else {
        f2 = 1.0F;
      }
      if ((this.m != paramBoolean1) || (this.l != paramInt2) || (this.n != f1) || (this.o != f2) || (this.D != paramBoolean2))
      {
        this.m = paramBoolean1;
        this.l = paramInt2;
        this.n = f1;
        this.o = f2;
        this.D = paramBoolean2;
        i6 = (720 - this.l) % 360;
        if ((i6 != 90) && (i6 != 270)) {
          paramInt2 = 0;
        } else {
          paramInt2 = 1;
        }
        if (paramInt2 != 0) {
          i5 = i2;
        } else {
          i5 = i1;
        }
        if (paramInt2 == 0) {
          i1 = i2;
        }
        localObject1 = this.i;
        float[] arrayOfFloat = l.a(k.a, false, true);
        f1 = i5 / i1;
        if (paramInt2 != 0) {
          paramBoolean1 = false;
        } else {
          paramBoolean1 = this.m;
        }
        if (paramInt2 != 0) {
          paramBoolean2 = this.m;
        } else {
          paramBoolean2 = false;
        }
        ((h)localObject1).a(paramInt3, paramInt4, i6, arrayOfFloat, f1, paramBoolean1, paramBoolean2);
        if (paramInt2 != 0) {
          this.i.g();
        } else {
          this.i.h();
        }
      }
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      GLES20.glClear(16640);
      this.i.a(paramInt1);
      a(i3, i4);
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void a(o paramo)
  {
    this.A = paramo;
    this.z = true;
  }
  
  public void a(Runnable paramRunnable)
  {
    synchronized (this.L)
    {
      this.L.add(paramRunnable);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.t = true;
    if (paramBoolean)
    {
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      GLES20.glClear(16384);
      this.s = e();
    }
    try
    {
      if (this.u)
      {
        this.u = false;
        if (this.g != null) {
          this.g.updateTexImage();
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    try
    {
      this.H = paramArrayOfByte;
      this.t = false;
      this.u = true;
      return;
    }
    finally {}
  }
  
  protected void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("surfaceDestroyed-->enter with mSurfaceTextureListener:");
    ((StringBuilder)localObject).append(this.F);
    TXCLog.i("TXCGLSurfaceView", ((StringBuilder)localObject).toString());
    localObject = this.F;
    if (localObject != null) {
      ((n)localObject).b(this.g);
    }
    localObject = this.g;
    if (localObject != null)
    {
      ((SurfaceTexture)localObject).release();
      this.g = null;
    }
  }
  
  public void b(Runnable paramRunnable)
  {
    synchronized (this.L)
    {
      this.L.add(paramRunnable);
      return;
    }
  }
  
  protected int c()
  {
    if (this.s != 12288)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("background capture swapbuffer error : ");
      localStringBuilder.append(this.s);
      TXCLog.e("TXCGLSurfaceView", localStringBuilder.toString());
    }
    return this.s;
  }
  
  public EGLContext getGLContext()
  {
    return this.h;
  }
  
  public SurfaceTexture getSurfaceTexture()
  {
    return this.g;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (Build.VERSION.SDK_INT >= 21)
    {
      Handler localHandler = this.w;
      if (localHandler != null)
      {
        localHandler.getLooper().quitSafely();
        this.w = null;
      }
    }
  }
  
  /* Error */
  public void onDrawFrame(GL10 paramGL10)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 120	com/tencent/liteav/renderer/TXCGLSurfaceView:L	Ljava/util/Queue;
    //   5: invokespecial 373	com/tencent/liteav/renderer/TXCGLSurfaceView:a	(Ljava/util/Queue;)Z
    //   8: pop
    //   9: iconst_1
    //   10: istore 8
    //   12: iconst_1
    //   13: istore 6
    //   15: invokestatic 379	java/lang/System:currentTimeMillis	()J
    //   18: lstore 9
    //   20: aload_0
    //   21: getfield 78	com/tencent/liteav/renderer/TXCGLSurfaceView:r	J
    //   24: lstore 11
    //   26: lload 11
    //   28: lconst_0
    //   29: lcmp
    //   30: ifeq +11 -> 41
    //   33: lload 9
    //   35: lload 11
    //   37: lcmp
    //   38: ifge +9 -> 47
    //   41: aload_0
    //   42: lload 9
    //   44: putfield 78	com/tencent/liteav/renderer/TXCGLSurfaceView:r	J
    //   47: aload_0
    //   48: getfield 78	com/tencent/liteav/renderer/TXCGLSurfaceView:r	J
    //   51: lstore 11
    //   53: lload 9
    //   55: lload 11
    //   57: lsub
    //   58: aload_0
    //   59: getfield 76	com/tencent/liteav/renderer/TXCGLSurfaceView:q	J
    //   62: ldc2_w 380
    //   65: lmul
    //   66: aload_0
    //   67: getfield 74	com/tencent/liteav/renderer/TXCGLSurfaceView:p	I
    //   70: i2l
    //   71: ldiv
    //   72: lcmp
    //   73: ifge +16 -> 89
    //   76: aload_0
    //   77: ldc2_w 382
    //   80: invokespecial 385	com/tencent/liteav/renderer/TXCGLSurfaceView:a	(J)V
    //   83: iconst_0
    //   84: istore 6
    //   86: goto -71 -> 15
    //   89: lload 9
    //   91: lload 11
    //   93: lsub
    //   94: ldc2_w 380
    //   97: lcmp
    //   98: ifle +21 -> 119
    //   101: aload_0
    //   102: lconst_1
    //   103: putfield 76	com/tencent/liteav/renderer/TXCGLSurfaceView:q	J
    //   106: aload_0
    //   107: invokestatic 379	java/lang/System:currentTimeMillis	()J
    //   110: putfield 78	com/tencent/liteav/renderer/TXCGLSurfaceView:r	J
    //   113: iconst_1
    //   114: istore 7
    //   116: goto +6 -> 122
    //   119: iconst_0
    //   120: istore 7
    //   122: aload_0
    //   123: getfield 82	com/tencent/liteav/renderer/TXCGLSurfaceView:t	Z
    //   126: ifeq +4 -> 130
    //   129: return
    //   130: aload_0
    //   131: monitorenter
    //   132: aload_0
    //   133: getfield 84	com/tencent/liteav/renderer/TXCGLSurfaceView:u	Z
    //   136: istore 13
    //   138: aconst_null
    //   139: astore_1
    //   140: aconst_null
    //   141: astore 14
    //   143: iload 13
    //   145: ifne +9 -> 154
    //   148: iconst_1
    //   149: istore 7
    //   151: goto +113 -> 264
    //   154: aload_0
    //   155: getfield 109	com/tencent/liteav/renderer/TXCGLSurfaceView:H	[B
    //   158: ifnull +41 -> 199
    //   161: aload_0
    //   162: getfield 109	com/tencent/liteav/renderer/TXCGLSurfaceView:H	[B
    //   165: astore_1
    //   166: aload_0
    //   167: aconst_null
    //   168: putfield 109	com/tencent/liteav/renderer/TXCGLSurfaceView:H	[B
    //   171: aload_0
    //   172: getfield 209	com/tencent/liteav/renderer/TXCGLSurfaceView:g	Landroid/graphics/SurfaceTexture;
    //   175: ifnull +444 -> 619
    //   178: aload_0
    //   179: getfield 209	com/tencent/liteav/renderer/TXCGLSurfaceView:g	Landroid/graphics/SurfaceTexture;
    //   182: invokevirtual 313	android/graphics/SurfaceTexture:updateTexImage	()V
    //   185: aload_0
    //   186: getfield 209	com/tencent/liteav/renderer/TXCGLSurfaceView:g	Landroid/graphics/SurfaceTexture;
    //   189: aload_0
    //   190: getfield 64	com/tencent/liteav/renderer/TXCGLSurfaceView:k	[F
    //   193: invokevirtual 389	android/graphics/SurfaceTexture:getTransformMatrix	([F)V
    //   196: goto +423 -> 619
    //   199: aload 14
    //   201: astore_1
    //   202: aload_0
    //   203: getfield 209	com/tencent/liteav/renderer/TXCGLSurfaceView:g	Landroid/graphics/SurfaceTexture;
    //   206: ifnull +24 -> 230
    //   209: aload_0
    //   210: getfield 209	com/tencent/liteav/renderer/TXCGLSurfaceView:g	Landroid/graphics/SurfaceTexture;
    //   213: invokevirtual 313	android/graphics/SurfaceTexture:updateTexImage	()V
    //   216: aload_0
    //   217: getfield 209	com/tencent/liteav/renderer/TXCGLSurfaceView:g	Landroid/graphics/SurfaceTexture;
    //   220: aload_0
    //   221: getfield 64	com/tencent/liteav/renderer/TXCGLSurfaceView:k	[F
    //   224: invokevirtual 389	android/graphics/SurfaceTexture:getTransformMatrix	([F)V
    //   227: aload 14
    //   229: astore_1
    //   230: iload 7
    //   232: ifne +16 -> 248
    //   235: aload_0
    //   236: aload_0
    //   237: getfield 76	com/tencent/liteav/renderer/TXCGLSurfaceView:q	J
    //   240: lconst_1
    //   241: ladd
    //   242: putfield 76	com/tencent/liteav/renderer/TXCGLSurfaceView:q	J
    //   245: goto +8 -> 253
    //   248: aload_0
    //   249: lconst_1
    //   250: putfield 76	com/tencent/liteav/renderer/TXCGLSurfaceView:q	J
    //   253: aload_0
    //   254: iconst_0
    //   255: putfield 84	com/tencent/liteav/renderer/TXCGLSurfaceView:u	Z
    //   258: iconst_0
    //   259: istore 7
    //   261: iconst_0
    //   262: istore 6
    //   264: aload_0
    //   265: monitorexit
    //   266: iconst_1
    //   267: iload 7
    //   269: if_icmpne +17 -> 286
    //   272: iconst_1
    //   273: iload 6
    //   275: if_icmpne +347 -> 622
    //   278: aload_0
    //   279: ldc2_w 390
    //   282: invokespecial 385	com/tencent/liteav/renderer/TXCGLSurfaceView:a	(J)V
    //   285: return
    //   286: invokestatic 379	java/lang/System:currentTimeMillis	()J
    //   289: lstore 9
    //   291: lload 9
    //   293: l2d
    //   294: dstore_2
    //   295: aload_0
    //   296: getfield 111	com/tencent/liteav/renderer/TXCGLSurfaceView:I	J
    //   299: lstore 11
    //   301: lload 11
    //   303: l2d
    //   304: dstore 4
    //   306: dload 4
    //   308: invokestatic 397	java/lang/Double:isNaN	(D)Z
    //   311: pop
    //   312: dload_2
    //   313: dload 4
    //   315: ldc2_w 398
    //   318: dadd
    //   319: dcmpl
    //   320: ifle +68 -> 388
    //   323: aload_0
    //   324: getfield 115	com/tencent/liteav/renderer/TXCGLSurfaceView:K	I
    //   327: istore 6
    //   329: iload 6
    //   331: i2d
    //   332: dstore_2
    //   333: dload_2
    //   334: invokestatic 397	java/lang/Double:isNaN	(D)Z
    //   337: pop
    //   338: aload_0
    //   339: getfield 111	com/tencent/liteav/renderer/TXCGLSurfaceView:I	J
    //   342: lstore 11
    //   344: lload 9
    //   346: lload 11
    //   348: lsub
    //   349: l2d
    //   350: dstore 4
    //   352: dload 4
    //   354: invokestatic 397	java/lang/Double:isNaN	(D)Z
    //   357: pop
    //   358: dload_2
    //   359: ldc2_w 398
    //   362: dmul
    //   363: dload 4
    //   365: ddiv
    //   366: d2i
    //   367: istore 6
    //   369: aload_0
    //   370: iload 6
    //   372: iconst_1
    //   373: iadd
    //   374: putfield 113	com/tencent/liteav/renderer/TXCGLSurfaceView:J	I
    //   377: aload_0
    //   378: lload 9
    //   380: putfield 111	com/tencent/liteav/renderer/TXCGLSurfaceView:I	J
    //   383: aload_0
    //   384: iconst_0
    //   385: putfield 115	com/tencent/liteav/renderer/TXCGLSurfaceView:K	I
    //   388: aload_0
    //   389: aload_0
    //   390: getfield 115	com/tencent/liteav/renderer/TXCGLSurfaceView:K	I
    //   393: iconst_1
    //   394: iadd
    //   395: putfield 115	com/tencent/liteav/renderer/TXCGLSurfaceView:K	I
    //   398: aload_0
    //   399: getfield 325	com/tencent/liteav/renderer/TXCGLSurfaceView:F	Lcom/tencent/liteav/basic/c/n;
    //   402: ifnull +44 -> 446
    //   405: aload_1
    //   406: ifnull +20 -> 426
    //   409: aload_0
    //   410: getfield 325	com/tencent/liteav/renderer/TXCGLSurfaceView:F	Lcom/tencent/liteav/basic/c/n;
    //   413: aload_1
    //   414: aload_0
    //   415: getfield 64	com/tencent/liteav/renderer/TXCGLSurfaceView:k	[F
    //   418: invokeinterface 402 3 0
    //   423: goto +23 -> 446
    //   426: aload_0
    //   427: getfield 325	com/tencent/liteav/renderer/TXCGLSurfaceView:F	Lcom/tencent/liteav/basic/c/n;
    //   430: aload_0
    //   431: getfield 404	com/tencent/liteav/renderer/TXCGLSurfaceView:j	[I
    //   434: iconst_0
    //   435: iaload
    //   436: aload_0
    //   437: getfield 64	com/tencent/liteav/renderer/TXCGLSurfaceView:k	[F
    //   440: invokeinterface 407 3 0
    //   445: pop
    //   446: aload_0
    //   447: monitorenter
    //   448: aload_0
    //   449: getfield 255	com/tencent/liteav/renderer/TXCGLSurfaceView:c	Z
    //   452: ifne +171 -> 623
    //   455: iload 8
    //   457: istore 6
    //   459: goto +3 -> 462
    //   462: aload_0
    //   463: monitorexit
    //   464: iload 6
    //   466: ifeq +152 -> 618
    //   469: aload_0
    //   470: invokevirtual 310	com/tencent/liteav/renderer/TXCGLSurfaceView:e	()I
    //   473: istore 6
    //   475: iload 6
    //   477: sipush 12288
    //   480: if_icmpeq +138 -> 618
    //   483: invokestatic 379	java/lang/System:currentTimeMillis	()J
    //   486: aload_0
    //   487: getfield 248	com/tencent/liteav/renderer/TXCGLSurfaceView:G	J
    //   490: lsub
    //   491: ldc2_w 408
    //   494: lcmp
    //   495: ifle +123 -> 618
    //   498: new 316	java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial 317	java/lang/StringBuilder:<init>	()V
    //   505: astore_1
    //   506: aload_1
    //   507: ldc_w 411
    //   510: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: pop
    //   514: aload_1
    //   515: iload 6
    //   517: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   520: pop
    //   521: ldc_w 330
    //   524: aload_1
    //   525: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   528: invokestatic 413	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   531: aload_0
    //   532: invokestatic 379	java/lang/System:currentTimeMillis	()J
    //   535: putfield 248	com/tencent/liteav/renderer/TXCGLSurfaceView:G	J
    //   538: new 415	android/os/Bundle
    //   541: dup
    //   542: invokespecial 416	android/os/Bundle:<init>	()V
    //   545: astore_1
    //   546: aload_1
    //   547: ldc_w 418
    //   550: iload 6
    //   552: invokevirtual 422	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   555: aload_1
    //   556: ldc_w 424
    //   559: sipush 2110
    //   562: invokevirtual 422	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   565: aload_1
    //   566: ldc_w 426
    //   569: invokestatic 431	com/tencent/liteav/basic/util/TXCTimeUtil:getTimeTick	()J
    //   572: invokevirtual 435	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   575: aload_1
    //   576: ldc_w 437
    //   579: ldc_w 439
    //   582: invokevirtual 443	android/os/Bundle:putCharSequence	(Ljava/lang/String;Ljava/lang/CharSequence;)V
    //   585: aload_0
    //   586: getfield 445	com/tencent/liteav/renderer/TXCGLSurfaceView:a	Ljava/lang/ref/WeakReference;
    //   589: sipush 2110
    //   592: aload_1
    //   593: invokestatic 450	com/tencent/liteav/basic/util/f:a	(Ljava/lang/ref/WeakReference;ILandroid/os/Bundle;)V
    //   596: return
    //   597: astore_1
    //   598: aload_0
    //   599: monitorexit
    //   600: aload_1
    //   601: athrow
    //   602: astore_1
    //   603: aload_0
    //   604: monitorexit
    //   605: aload_1
    //   606: athrow
    //   607: astore_1
    //   608: ldc_w 330
    //   611: ldc_w 452
    //   614: aload_1
    //   615: invokestatic 455	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   618: return
    //   619: goto -389 -> 230
    //   622: return
    //   623: iconst_0
    //   624: istore 6
    //   626: goto -164 -> 462
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	629	0	this	TXCGLSurfaceView
    //   0	629	1	paramGL10	GL10
    //   294	65	2	d1	double
    //   304	60	4	d2	double
    //   13	612	6	i1	int
    //   114	156	7	i2	int
    //   10	446	8	i3	int
    //   18	361	9	l1	long
    //   24	323	11	l2	long
    //   136	8	13	bool	boolean
    //   141	87	14	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   448	455	597	finally
    //   462	464	597	finally
    //   598	600	597	finally
    //   132	138	602	finally
    //   154	196	602	finally
    //   202	227	602	finally
    //   235	245	602	finally
    //   248	253	602	finally
    //   253	258	602	finally
    //   264	266	602	finally
    //   603	605	602	finally
    //   130	132	607	java/lang/Exception
    //   278	285	607	java/lang/Exception
    //   286	291	607	java/lang/Exception
    //   295	301	607	java/lang/Exception
    //   323	329	607	java/lang/Exception
    //   338	344	607	java/lang/Exception
    //   369	388	607	java/lang/Exception
    //   388	405	607	java/lang/Exception
    //   409	423	607	java/lang/Exception
    //   426	446	607	java/lang/Exception
    //   446	448	607	java/lang/Exception
    //   469	475	607	java/lang/Exception
    //   483	596	607	java/lang/Exception
    //   600	602	607	java/lang/Exception
    //   605	607	607	java/lang/Exception
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    this.t = false;
    try
    {
      this.u = true;
      return;
    }
    finally {}
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2) {}
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    this.h = ((EGL10)EGLContext.getEGL()).eglGetCurrentContext();
    this.j = new int[1];
    this.j[0] = j.b();
    paramGL10 = this.j;
    if (paramGL10[0] <= 0)
    {
      this.j = null;
      TXCLog.e("TXCGLSurfaceView", "create oes texture error!! at glsurfaceview");
      return;
    }
    this.g = new SurfaceTexture(paramGL10[0]);
    g();
    this.i = new h();
    if (!this.i.a()) {
      return;
    }
    this.i.a(l.e, l.a(k.a, false, false));
    paramGL10 = this.F;
    if (paramGL10 != null) {
      paramGL10.a(this.g);
    }
  }
  
  public void setFPS(int paramInt)
  {
    b(new TXCGLSurfaceView.1(this, paramInt));
  }
  
  public void setNotifyListener(b paramb)
  {
    this.a = new WeakReference(paramb);
  }
  
  public void setRendMirror(int paramInt)
  {
    b(new TXCGLSurfaceView.3(this, paramInt));
  }
  
  public void setRendMode(int paramInt)
  {
    b(new TXCGLSurfaceView.2(this, paramInt));
  }
  
  protected void setRunInBackground(boolean paramBoolean)
  {
    if (paramBoolean) {
      try
      {
        TXCLog.i("TXCGLSurfaceView", "background capture enter background");
        this.c = true;
        return;
      }
      finally {}
    }
    b(new TXCGLSurfaceView.4(this));
  }
  
  public void setSurfaceTextureListener(n paramn)
  {
    this.F = paramn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.renderer.TXCGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */