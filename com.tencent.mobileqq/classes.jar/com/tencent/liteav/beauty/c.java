package com.tencent.liteav.beauty;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils;
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils.a;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.b.i;
import com.tencent.liteav.beauty.b.l;
import com.tencent.liteav.beauty.b.m;
import com.tencent.liteav.beauty.b.n;
import com.tencent.liteav.beauty.b.o;
import com.tencent.liteav.beauty.b.x;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

class c
  extends HandlerThread
{
  private int A = 0;
  private int B = 0;
  private Context C = null;
  private boolean D = true;
  private boolean E = false;
  private d.e F = new d.e();
  private d.f G = null;
  private int H = -1;
  private int I = -1;
  private int J = -1;
  private int K = -1;
  private int L = -1;
  private int M = -1;
  private float N = 1.0F;
  private int O = -1;
  private int P = -1;
  private int Q = 1;
  private boolean R = false;
  private float[] S = null;
  private boolean T = false;
  private int U = 0;
  private int V = 0;
  private com.tencent.liteav.basic.opengl.a W = null;
  private Bitmap X = null;
  private com.tencent.liteav.beauty.b.k Y = null;
  private o Z = null;
  boolean a = false;
  private int aA = 0;
  private int aB = 0;
  private int aC = 0;
  private int aD = 0;
  private int aE = 0;
  private boolean aF = false;
  private com.tencent.liteav.beauty.a.a.c aG = null;
  private com.tencent.liteav.beauty.a.a.a aH = null;
  private Bitmap aI = null;
  private List<d.f> aJ = null;
  private long aK = 0L;
  private int aL = 0;
  private final int aM = 100;
  private final float aN = 1000.0F;
  private byte[] aO = null;
  private int[] aP = null;
  private boolean aQ = false;
  private byte[] aR = null;
  private int aS = -1;
  private int aT = 0;
  private int aU = 1;
  private int aV = this.aS;
  private e aW = null;
  private WeakReference<com.tencent.liteav.basic.c.b> aX = new WeakReference(null);
  private com.tencent.liteav.beauty.b.a aY = new com.tencent.liteav.beauty.b.a();
  private final com.tencent.liteav.basic.util.c aZ;
  private com.tencent.liteav.beauty.b.b aa = null;
  private com.tencent.liteav.beauty.b.a.a ab = null;
  private com.tencent.liteav.beauty.b.b.a ac = null;
  private com.tencent.liteav.beauty.b.c ad = null;
  private com.tencent.liteav.beauty.b.c.a ae = null;
  private Bitmap af;
  private Bitmap ag;
  private float ah;
  private float ai;
  private float aj;
  private m ak;
  private n al = null;
  private x am = null;
  private com.tencent.liteav.beauty.b.j an = null;
  private i ao = null;
  private com.tencent.liteav.basic.opengl.j ap = null;
  private l aq = null;
  private com.tencent.liteav.basic.opengl.k ar = null;
  private com.tencent.liteav.basic.opengl.j as = null;
  private final Queue<Runnable> at = new LinkedList();
  private boolean au;
  private Object av = new Object();
  private Object aw = new Object();
  private Handler ax;
  private c.a ay;
  private float az = 0.5F;
  protected int[] b = null;
  private TXCOpenGlUtils.a ba = new c.12(this);
  protected int[] c = null;
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private int g = 0;
  private int h = 0;
  private int i = 0;
  private int j = 0;
  private int k = 0;
  private int l = 0;
  private int m = 0;
  private int n = 0;
  private int o = 0;
  private int p = 0;
  private int q = 0;
  private int r = 0;
  private int s = 0;
  private int t = 0;
  private int u = 0;
  private int v = 0;
  private int w = 0;
  private int x = 0;
  private int y = 0;
  private int z = 0;
  
  c(Context paramContext, boolean paramBoolean)
  {
    super("TXCFilterDrawer");
    this.C = paramContext;
    this.ax = new Handler(this.C.getMainLooper());
    this.au = paramBoolean;
    this.aZ = new com.tencent.liteav.basic.util.c("filter-drawer", (int)TimeUnit.SECONDS.toMillis(5L));
  }
  
  private int B(int paramInt)
  {
    GLES20.glViewport(0, 0, this.H, this.I);
    return a(this.Y.r(), paramInt, 0L);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (true == this.au)
    {
      if (this.aW != null)
      {
        NativeLoad.nativeGlReadPixs(paramInt1, paramInt2, this.aO);
        this.aW.a(this.aO, this.O, this.P, this.V, TXCTimeUtil.generatePtsMS());
        return 0;
      }
      localObject = this.aR;
      if (localObject != null)
      {
        NativeLoad.nativeGlReadPixs(paramInt1, paramInt2, (byte[])localObject);
        return 0;
      }
    }
    else
    {
      if (3 == TXCOpenGlUtils.a())
      {
        if (0L == this.aK) {
          this.aK = TXCTimeUtil.getTimeTick();
        }
        int i1 = this.aL + 1;
        this.aL = i1;
        if (i1 >= 100)
        {
          float f1 = 100.0F / ((float)(TXCTimeUtil.getTimeTick() - this.aK) / 1000.0F);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Real fps ");
          ((StringBuilder)localObject).append(f1);
          TXCLog.i("TXCFilterDrawer", ((StringBuilder)localObject).toString());
          this.aL = 0;
          this.aK = TXCTimeUtil.getTimeTick();
        }
        GLES30.glPixelStorei(3333, 1);
        if (Build.VERSION.SDK_INT >= 18) {
          GLES30.glReadBuffer(1029);
        }
        GLES30.glBindBuffer(35051, this.aP[0]);
        localObject = null;
        NativeLoad.nativeGlReadPixs(paramInt1, paramInt2, null);
        if (Build.VERSION.SDK_INT >= 18)
        {
          ByteBuffer localByteBuffer = (ByteBuffer)GLES30.glMapBufferRange(35051, 0, paramInt1 * paramInt2 * 4, 1);
          localObject = localByteBuffer;
          if (localByteBuffer == null)
          {
            TXCLog.e("TXCFilterDrawer", "glMapBufferRange is null");
            return -1;
          }
        }
        NativeLoad.nativeGlMapBufferToQueue(paramInt1, paramInt2, (ByteBuffer)localObject);
        if (Build.VERSION.SDK_INT >= 18) {
          GLES30.glUnmapBuffer(35051);
        }
        GLES30.glBindBuffer(35051, 0);
        return 0;
      }
      NativeLoad.nativeGlReadPixsToQueue(paramInt1, paramInt2);
    }
    return 0;
  }
  
  private int a(int paramInt, long paramLong)
  {
    int i1 = this.V;
    if (i1 == 0)
    {
      if (this.aW != null)
      {
        long l1 = paramLong;
        if (paramLong == 0L) {
          l1 = TXCTimeUtil.generatePtsMS();
        }
        this.aW.a(paramInt, this.O, this.P, l1);
      }
      return paramInt;
    }
    if ((1 != i1) && (3 != i1) && (2 != i1))
    {
      TXCLog.e("TXCFilterDrawer", "Don't support format!");
      return -1;
    }
    GLES20.glViewport(0, 0, this.O, this.P);
    if (this.Z == null)
    {
      TXCLog.e("TXCFilterDrawer", "mRGBA2I420Filter is null!");
      return paramInt;
    }
    GLES20.glBindFramebuffer(36160, this.b[0]);
    this.Z.a(paramInt);
    if (2 == this.V) {
      a(this.O, this.P);
    } else {
      a(this.O, this.P * 3 / 8);
    }
    GLES20.glBindFramebuffer(36160, 0);
    return paramInt;
  }
  
  private void a(int paramInt1, int paramInt2, float paramFloat1, Bitmap paramBitmap1, float paramFloat2, Bitmap paramBitmap2, float paramFloat3)
  {
    if (this.ak == null)
    {
      TXCLog.i("TXCFilterDrawer", "createComLooKupFilter");
      this.ak = new m(paramFloat1, paramBitmap1, paramFloat2, paramBitmap2, paramFloat3);
      if (true == this.ak.a())
      {
        this.ak.a(true);
        this.ak.a(paramInt1, paramInt2);
        return;
      }
      TXCLog.e("TXCFilterDrawer", "mLookupFilterGroup init failed!");
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    TXCLog.i("TXCFilterDrawer", "create Beauty Filter!");
    if (paramInt3 == 0)
    {
      if (this.ab == null) {
        this.ab = new com.tencent.liteav.beauty.b.a.a();
      }
      this.aa = this.ab;
      Log.i("TXCFilterDrawer", "0 BeautyFilter");
    }
    else if (1 == paramInt3)
    {
      if (this.ac == null) {
        this.ac = new com.tencent.liteav.beauty.b.b.a();
      }
      this.aa = this.ac;
      Log.i("TXCFilterDrawer", "1 BeautyFilter");
    }
    else if (2 == paramInt3)
    {
      if (this.ae == null) {
        this.ae = new com.tencent.liteav.beauty.b.c.a();
      }
      this.aa = this.ae;
      Log.i("TXCFilterDrawer", "2 BeautyFilter");
    }
    else if (3 == paramInt3)
    {
      if (this.ad == null) {
        this.ad = new com.tencent.liteav.beauty.b.c();
      }
      this.aa = this.ad;
      Log.i("TXCFilterDrawer", "3 BeautyFilter");
    }
    com.tencent.liteav.beauty.b.b localb = this.aa;
    if (localb == null)
    {
      TXCLog.e("TXCFilterDrawer", "mBeautyFilter set error!");
      return;
    }
    localb.a(true);
    if (true == this.aa.c(paramInt1, paramInt2))
    {
      paramInt1 = this.aB;
      if (paramInt1 > 0) {
        this.aa.c(paramInt1);
      }
      paramInt1 = this.aC;
      if (paramInt1 > 0) {
        this.aa.d(paramInt1);
      }
      paramInt1 = this.aE;
      if (paramInt1 > 0) {
        this.aa.e(paramInt1);
      }
      paramInt1 = this.aD;
      if (paramInt1 > 0) {
        this.aa.f(paramInt1);
      }
    }
    else
    {
      TXCLog.e("TXCFilterDrawer", "mBeautyFilter init failed!");
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Object localObject1 = this.aw;
    paramInt5 = (paramInt5 + 360) % 360;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("real outputAngle ");
      localStringBuilder.append(paramInt5);
      TXCLog.i("TXCFilterDrawer", localStringBuilder.toString());
      if (this.ap == null)
      {
        if ((paramInt1 == paramInt3) && (paramInt2 == paramInt4) && (paramInt5 == 0))
        {
          TXCLog.i("TXCFilterDrawer", "Don't need change output Image, don't create out filter!");
          return;
        }
        this.ap = new com.tencent.liteav.basic.opengl.j();
        if (true == this.ap.a()) {
          this.ap.a(true);
        } else {
          TXCLog.e("TXCFilterDrawer", "mOutputZoomFilter init failed!");
        }
      }
      this.ap.a(paramInt3, paramInt4);
      this.ap.a((720 - paramInt5) % 360, null);
      return;
    }
    finally {}
  }
  
  private void a(com.tencent.liteav.basic.opengl.a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6)
  {
    if (this.aq == null)
    {
      TXCLog.i("TXCFilterDrawer", "Create CropFilter");
      if (4 == paramInt6) {
        this.aq = new l("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform mat4 textureTransform;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (textureTransform * inputTextureCoordinate).xy;\n}", "#extension GL_OES_EGL_image_external : require\n\nvarying lowp vec2 textureCoordinate;\n \nuniform samplerExternalOES inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}", true);
      } else {
        this.aq = new l();
      }
      if (true == this.aq.a()) {
        this.aq.a(true);
      } else {
        TXCLog.e("TXCFilterDrawer", "mInputCropFilter init failed!");
      }
    }
    l locall = this.aq;
    locall.a(paramInt3, paramInt4);
    parama = this.aq.a(this.H, this.I, null, parama, paramInt6);
    int i1 = (720 - paramInt5) % 360;
    if ((i1 != 90) && (i1 != 270)) {
      paramInt5 = paramInt3;
    } else {
      paramInt5 = paramInt4;
    }
    paramInt6 = paramInt3;
    if (i1 != 90) {
      if (i1 == 270) {
        paramInt6 = paramInt3;
      } else {
        paramInt6 = paramInt4;
      }
    }
    this.aq.a(paramInt1, paramInt2, i1, parama, paramInt5 / paramInt6, paramBoolean, false);
  }
  
  private void a(Runnable paramRunnable)
  {
    synchronized (this.at)
    {
      this.at.add(paramRunnable);
      return;
    }
  }
  
  private void a(Queue<Runnable> paramQueue)
  {
    for (;;)
    {
      Runnable localRunnable = null;
      try
      {
        if (!paramQueue.isEmpty()) {
          localRunnable = (Runnable)paramQueue.poll();
        }
        if (localRunnable != null) {
          localRunnable.run();
        } else {
          return;
        }
      }
      finally {}
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  private void a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      e locale = this.aW;
      if (locale != null)
      {
        locale.a(paramArrayOfByte, this.O, this.P, this.V, TXCTimeUtil.generatePtsMS());
        return;
      }
      TXCLog.i("TXCFilterDrawer", "First Frame, don't process!");
      return;
    }
    int i1 = this.P;
    int i2 = i1 * 3 / 8;
    if (2 != this.V) {
      i1 = i2;
    }
    if (this.aW != null)
    {
      if (true == NativeLoad.nativeGlReadPixsFromQueue(this.O, i1, this.aO))
      {
        this.aW.a(this.aO, this.O, this.P, this.V, TXCTimeUtil.generatePtsMS());
        return;
      }
      TXCLog.d("TXCFilterDrawer", "nativeGlReadPixsFromQueue Failed");
      this.aW.a(paramArrayOfByte, this.O, this.P, this.V, TXCTimeUtil.generatePtsMS());
      return;
    }
    if (!NativeLoad.nativeGlReadPixsFromQueue(this.O, i1, this.aR)) {
      TXCLog.d("TXCFilterDrawer", "nativeGlReadPixsFromQueue Failed");
    }
  }
  
  private void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2)
  {
    GLES20.glGenFramebuffers(1, paramArrayOfInt1, 0);
    paramArrayOfInt2[0] = TXCOpenGlUtils.a(paramInt1, paramInt2, 6408, 6408, paramArrayOfInt2);
    GLES20.glBindFramebuffer(36160, paramArrayOfInt1[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramArrayOfInt2[0], 0);
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  private void b()
  {
    TXCLog.i("TXCFilterDrawer", "come into releaseInternal");
    this.aQ = false;
    Object localObject = this.Y;
    if (localObject != null)
    {
      ((com.tencent.liteav.beauty.b.k)localObject).d();
      this.Y = null;
    }
    localObject = this.Z;
    if (localObject != null)
    {
      ((o)localObject).d();
      this.Z = null;
    }
    c();
    localObject = this.ak;
    if (localObject != null)
    {
      ((m)localObject).d();
      this.ak = null;
    }
    localObject = this.al;
    if (localObject != null)
    {
      ((n)localObject).a();
      this.al = null;
    }
    localObject = this.ar;
    if (localObject != null)
    {
      ((com.tencent.liteav.basic.opengl.k)localObject).d();
      this.ar = null;
    }
    localObject = this.aq;
    if (localObject != null)
    {
      ((l)localObject).d();
      this.aq = null;
    }
    localObject = this.ap;
    if (localObject != null)
    {
      ((com.tencent.liteav.basic.opengl.j)localObject).d();
      this.ap = null;
    }
    localObject = this.am;
    if (localObject != null)
    {
      ((x)localObject).d();
      this.am = null;
    }
    localObject = this.an;
    if (localObject != null)
    {
      ((com.tencent.liteav.beauty.b.j)localObject).a();
      this.an = null;
    }
    localObject = this.ao;
    if (localObject != null)
    {
      ((i)localObject).d();
      this.ao = null;
    }
    localObject = this.as;
    if (localObject != null)
    {
      ((com.tencent.liteav.basic.opengl.j)localObject).d();
      this.as = null;
    }
    localObject = this.b;
    if (localObject != null)
    {
      GLES20.glDeleteFramebuffers(1, (int[])localObject, 0);
      this.b = null;
    }
    localObject = this.c;
    if (localObject != null)
    {
      GLES20.glDeleteTextures(1, (int[])localObject, 0);
      this.c = null;
    }
    localObject = this.aP;
    if ((localObject != null) && (localObject[0] > 0))
    {
      GLES30.glDeleteBuffers(1, (int[])localObject, 0);
      this.aP = null;
    }
    TXCLog.i("TXCFilterDrawer", "come out releaseInternal");
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (this.as == null)
    {
      TXCLog.i("TXCFilterDrawer", "createRecoverScaleFilter");
      this.as = new com.tencent.liteav.basic.opengl.j();
      if (true == this.as.a()) {
        this.as.a(true);
      } else {
        TXCLog.e("TXCFilterDrawer", "mRecoverScaleFilter init failed!");
      }
    }
    com.tencent.liteav.basic.opengl.j localj = this.as;
    if (localj != null) {
      localj.a(paramInt1, paramInt2);
    }
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    com.tencent.liteav.beauty.b.k localk = this.Y;
    if (localk == null)
    {
      TXCLog.e("TXCFilterDrawer", "mI4202RGBAFilter is null!");
      return;
    }
    localk.a(paramArrayOfByte);
  }
  
  private void c()
  {
    Object localObject = this.ab;
    if (localObject != null)
    {
      ((com.tencent.liteav.beauty.b.a.a)localObject).d();
      this.ab = null;
    }
    localObject = this.ac;
    if (localObject != null)
    {
      ((com.tencent.liteav.beauty.b.b.a)localObject).d();
      this.ac = null;
    }
    localObject = this.ad;
    if (localObject != null)
    {
      ((com.tencent.liteav.beauty.b.c)localObject).d();
      this.ad = null;
    }
    localObject = this.ae;
    if (localObject != null)
    {
      ((com.tencent.liteav.beauty.b.c.a)localObject).d();
      this.ae = null;
    }
    this.aa = null;
  }
  
  private boolean c(d.b paramb)
  {
    TXCLog.i("TXCFilterDrawer", "come into initInternal");
    b();
    this.au = paramb.j;
    this.H = paramb.d;
    this.I = paramb.e;
    this.W = paramb.m;
    int i3 = paramb.g;
    int i4 = paramb.f;
    int i5 = paramb.h;
    this.R = paramb.i;
    this.O = paramb.b;
    this.P = paramb.c;
    int i6 = paramb.a;
    this.J = paramb.g;
    this.K = paramb.f;
    if ((i5 == 90) || (i5 == 270))
    {
      this.J = paramb.f;
      this.K = paramb.g;
    }
    this.V = paramb.l;
    this.U = paramb.k;
    this.aO = new byte[this.O * this.P * 4];
    TXCLog.i("TXCFilterDrawer", "processWidth mPituScaleRatio is %f, process size: %d x %d", new Object[] { Float.valueOf(this.N), Integer.valueOf(this.J), Integer.valueOf(this.K) });
    if (this.N != 1.0F)
    {
      int i1 = this.J;
      int i2 = this.K;
      if (i1 >= i2) {
        i1 = i2;
      }
      if (i1 > 368) {
        this.N = (432.0F / i1);
      }
      if (this.N > 1.0F) {
        this.N = 1.0F;
      }
    }
    float f1 = this.J;
    float f2 = this.N;
    this.L = ((int)(f1 * f2));
    this.M = ((int)(this.K * f2));
    a(this.L, this.M, this.aA);
    paramb = this.G;
    if ((paramb != null) && (paramb.a != null) && (this.am == null))
    {
      TXCLog.i("TXCFilterDrawer", "reset water mark!");
      a(this.G.a, this.G.b, this.G.c, this.G.d);
    }
    if (((this.af != null) || (this.ag != null)) && (this.ak == null)) {
      a(this.L, this.M, this.ah, this.af, this.ai, this.ag, this.aj);
    }
    a(this.W, i3, i4, this.L, this.M, this.R, i5, this.U);
    a(this.J, this.K, this.O, this.P, i6);
    paramb = this.b;
    if (paramb == null) {
      this.b = new int[1];
    } else {
      GLES20.glDeleteFramebuffers(1, paramb, 0);
    }
    paramb = this.c;
    if (paramb == null) {
      this.c = new int[1];
    } else {
      GLES20.glDeleteTextures(1, paramb, 0);
    }
    a(this.b, this.c, this.O, this.P);
    if (3 == TXCOpenGlUtils.a())
    {
      if (this.aP == null)
      {
        this.aP = new int[1];
      }
      else
      {
        TXCLog.i("TXCFilterDrawer", "m_pbo0 is not null, delete Buffers, and recreate");
        GLES30.glDeleteBuffers(1, this.aP, 0);
      }
      TXCLog.i("TXCFilterDrawer", "opengl es 3.0, use PBO");
      TXCOpenGlUtils.a(i3, i4, this.aP);
    }
    TXCLog.i("TXCFilterDrawer", "come out initInternal");
    return true;
  }
  
  private boolean d(d.b paramb)
  {
    if (((1 == paramb.k) || (3 == paramb.k) || (2 == paramb.k)) && (this.Y == null))
    {
      this.Y = new com.tencent.liteav.beauty.b.k(paramb.k);
      this.Y.a(true);
      if (!this.Y.a())
      {
        TXCLog.e("TXCFilterDrawer", "mI4202RGBAFilter init failed!!, break init");
        return false;
      }
      this.Y.a(paramb.d, paramb.e);
    }
    if (((1 == paramb.l) || (3 == paramb.l) || (2 == paramb.l)) && (this.Z == null))
    {
      this.Z = new o(paramb.l);
      if (!this.Z.a())
      {
        TXCLog.e("TXCFilterDrawer", "mRGBA2I420Filter init failed!!, break init");
        return false;
      }
      this.Z.a(paramb.b, paramb.c);
    }
    return true;
  }
  
  public void A(int paramInt) {}
  
  public int a(int paramInt1, int paramInt2, long paramLong)
  {
    this.aZ.a();
    a(this.at);
    int i1;
    if (this.N != 1.0F) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    GLES20.glViewport(0, 0, this.L, this.M);
    int i2 = paramInt1;
    if (this.aq != null)
    {
      if ((4 == paramInt2) || (true == this.T))
      {
        this.aq.a(this.S);
        this.aq.c(this.T);
      }
      i2 = this.aq.b(paramInt1);
    }
    paramInt1 = i2;
    if (this.aa != null)
    {
      if (Math.min(this.O, this.P) < 540) {
        paramInt1 = 0;
      } else {
        paramInt1 = this.aD;
      }
      this.aa.f(paramInt1);
      if ((this.aB <= 0) && (this.aC <= 0))
      {
        paramInt1 = i2;
        if (this.aE <= 0) {}
      }
      else
      {
        paramInt1 = this.aa.b(i2);
      }
    }
    Object localObject = this.ak;
    paramInt2 = paramInt1;
    if (localObject != null) {
      paramInt2 = ((m)localObject).b(paramInt1);
    }
    GLES20.glViewport(0, 0, this.J, this.K);
    localObject = this.an;
    paramInt1 = paramInt2;
    if (localObject != null)
    {
      paramInt1 = ((com.tencent.liteav.beauty.b.j)localObject).a(paramInt2);
      i1 = 0;
    }
    localObject = this.ao;
    paramInt2 = paramInt1;
    if (localObject != null)
    {
      paramInt2 = ((i)localObject).b(paramInt1);
      i1 = 0;
    }
    paramInt1 = paramInt2;
    if (i1 != 0)
    {
      b(this.J, this.K);
      paramInt1 = paramInt2;
      if (this.as != null)
      {
        GLES20.glViewport(0, 0, this.J, this.K);
        paramInt1 = this.as.b(paramInt2);
      }
    }
    localObject = this.aW;
    paramInt2 = paramInt1;
    if (localObject != null)
    {
      i1 = ((e)localObject).a(paramInt1, this.J, this.K);
      paramInt2 = paramInt1;
      if (i1 > 0) {
        paramInt2 = i1;
      }
    }
    GLES20.glViewport(0, 0, this.J, this.K);
    localObject = this.am;
    paramInt1 = paramInt2;
    if (localObject != null) {
      paramInt1 = ((x)localObject).b(paramInt2);
    }
    paramInt2 = paramInt1;
    if (this.ap != null)
    {
      GLES20.glViewport(0, 0, this.O, this.P);
      paramInt2 = this.ap.b(paramInt1);
    }
    a(paramInt2, paramLong);
    return paramInt2;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    a(paramArrayOfByte);
    if (!this.au)
    {
      paramArrayOfByte = (byte[])paramArrayOfByte.clone();
      this.ay.obtainMessage(2, paramArrayOfByte).sendToTarget();
      if (!this.aQ)
      {
        TXCLog.i("TXCFilterDrawer", "First Frame, clear queue");
        NativeLoad.nativeClearQueue();
      }
      this.ay.obtainMessage(3, paramInt, 0).sendToTarget();
      a(paramArrayOfByte, this.aQ);
      this.aQ = true;
      return -1;
    }
    b(paramArrayOfByte);
    return B(paramInt);
  }
  
  public void a()
  {
    if (!this.au)
    {
      c.a locala = this.ay;
      if (locala == null) {
        break label36;
      }
      locala.obtainMessage(1).sendToTarget();
    }
    try
    {
      this.aY.b();
      return;
    }
    catch (InterruptedException localInterruptedException) {}
    b();
    label36:
    return;
  }
  
  public void a(float paramFloat)
  {
    this.az = paramFloat;
    a(new c.1(this, paramFloat));
  }
  
  public void a(float paramFloat1, Bitmap paramBitmap1, float paramFloat2, Bitmap paramBitmap2, float paramFloat3)
  {
    if ((this.af == paramBitmap1) && (this.ag == paramBitmap2))
    {
      if ((this.ak != null) && ((this.ah != paramFloat1) || (this.ai != paramFloat2) || (this.aj != paramFloat3)))
      {
        this.ah = paramFloat1;
        this.ai = paramFloat2;
        this.aj = paramFloat3;
        a(new c.8(this, paramFloat1, paramFloat2, paramFloat3));
      }
    }
    else
    {
      this.af = paramBitmap1;
      this.ag = paramBitmap2;
      this.ah = paramFloat1;
      this.ai = paramFloat2;
      this.aj = paramFloat3;
      a(new c.6(this, paramFloat1, paramBitmap1, paramFloat2, paramBitmap2, paramFloat3));
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(Bitmap paramBitmap)
  {
    a(1.0F, paramBitmap, this.az, null, 0.0F);
  }
  
  public void a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.G == null) {
      this.G = new d.f();
    }
    if ((TXCCommonUtil.equals(this.G.a, paramBitmap)) && (paramFloat1 == this.G.b) && (paramFloat2 == this.G.c) && (paramFloat3 == this.G.d) && (this.am != null))
    {
      Log.d("TXCFilterDrawer", "Same Water Mark; don't set again");
      return;
    }
    d.f localf = this.G;
    localf.a = paramBitmap;
    localf.b = paramFloat1;
    localf.c = paramFloat2;
    localf.d = paramFloat3;
    a(new c.10(this, paramBitmap, paramFloat1, paramFloat2, paramFloat3));
  }
  
  void a(com.tencent.liteav.basic.c.b paramb)
  {
    TXCLog.i("TXCFilterDrawer", "set notify");
    this.aX = new WeakReference(paramb);
    paramb = this.an;
    if (paramb != null) {
      paramb.a((com.tencent.liteav.basic.c.b)this.aX.get());
    }
  }
  
  void a(e parame)
  {
    TXCLog.i("TXCFilterDrawer", "set listener");
    this.aW = parame;
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean)
  {
    a(new c.9(this, paramBoolean));
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.aR = paramArrayOfByte;
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    a(new c.7(this, paramArrayOfFloat));
  }
  
  public boolean a(d.b paramb)
  {
    boolean bool = true;
    try
    {
      if (!paramb.j)
      {
        if (this.ay == null)
        {
          start();
          this.ay = new c.a(this, getLooper(), this.C);
        }
        this.ay.obtainMessage(0, paramb).sendToTarget();
        this.ay.b();
      }
      else
      {
        bool = c(paramb);
      }
      return bool;
    }
    finally {}
  }
  
  public void b(int paramInt)
  {
    a(new c.11(this, paramInt));
  }
  
  public void b(boolean paramBoolean) {}
  
  public boolean b(d.b paramb)
  {
    if (!this.au)
    {
      c.a locala = this.ay;
      if (locala == null)
      {
        TXCLog.e("TXCFilterDrawer", "mThreadHandler is null!");
        return false;
      }
      locala.obtainMessage(5, 0, 0, paramb).sendToTarget();
    }
    else
    {
      d(paramb);
    }
    return true;
  }
  
  public void c(int paramInt)
  {
    this.aB = paramInt;
    a(new c.13(this, paramInt));
  }
  
  public void d(int paramInt)
  {
    if ((this.aA != paramInt) && (paramInt <= 3))
    {
      if (paramInt < 0) {
        return;
      }
      this.aA = paramInt;
      a(new c.2(this, paramInt));
    }
  }
  
  public void e(int paramInt)
  {
    this.aC = paramInt;
    a(new c.3(this, paramInt));
  }
  
  public void f(int paramInt)
  {
    this.aD = paramInt;
    a(new c.4(this, paramInt));
  }
  
  public void g(int paramInt)
  {
    this.aE = paramInt;
    a(new c.5(this, paramInt));
  }
  
  public void h(int paramInt) {}
  
  public void i(int paramInt) {}
  
  public void j(int paramInt) {}
  
  public void k(int paramInt) {}
  
  public void l(int paramInt) {}
  
  public void m(int paramInt) {}
  
  public void n(int paramInt) {}
  
  public void o(int paramInt) {}
  
  public void p(int paramInt) {}
  
  public void q(int paramInt) {}
  
  public void r(int paramInt) {}
  
  public void s(int paramInt) {}
  
  public void t(int paramInt) {}
  
  public void u(int paramInt) {}
  
  public void v(int paramInt) {}
  
  public void w(int paramInt) {}
  
  public void x(int paramInt) {}
  
  public void y(int paramInt) {}
  
  public void z(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.c
 * JD-Core Version:    0.7.0.1
 */