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
import com.tencent.liteav.basic.c.h;
import com.tencent.liteav.basic.c.j.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.b.k;
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

class c
  extends HandlerThread
{
  private int A = 0;
  private int B = 0;
  private int C = 0;
  private int D = 0;
  private Context E = null;
  private boolean F = true;
  private boolean G = false;
  private d.e H = new d.e();
  private d.f I = null;
  private int J = -1;
  private int K = -1;
  private int L = -1;
  private int M = -1;
  private int N = -1;
  private int O = -1;
  private float P = 1.0F;
  private int Q = -1;
  private int R = -1;
  private int S = 1;
  private boolean T = false;
  private float[] U = null;
  private boolean V = false;
  private int W = 0;
  private int X = 0;
  private com.tencent.liteav.basic.c.a Y = null;
  private Bitmap Z = null;
  boolean a = false;
  private c.a aA;
  private float aB = 0.5F;
  private int aC = 0;
  private int aD = 0;
  private int aE = 0;
  private int aF = 0;
  private int aG = 0;
  private boolean aH = false;
  private com.tencent.liteav.beauty.a.a.c aI = null;
  private com.tencent.liteav.beauty.a.a.a aJ = null;
  private Bitmap aK = null;
  private List<d.f> aL = null;
  private long aM = 0L;
  private int aN = 0;
  private final int aO = 100;
  private final float aP = 1000.0F;
  private byte[] aQ = null;
  private int[] aR = null;
  private boolean aS = false;
  private byte[] aT = null;
  private int aU = -1;
  private int aV = 0;
  private int aW = 1;
  private int aX = this.aU;
  private e aY = null;
  private WeakReference<com.tencent.liteav.basic.b.b> aZ = new WeakReference(null);
  private k aa = null;
  private o ab = null;
  private com.tencent.liteav.beauty.b.b ac = null;
  private com.tencent.liteav.beauty.b.a.a ad = null;
  private com.tencent.liteav.beauty.b.b.a ae = null;
  private com.tencent.liteav.beauty.b.c af = null;
  private com.tencent.liteav.beauty.b.c.a ag = null;
  private Bitmap ah;
  private Bitmap ai;
  private float aj;
  private float ak;
  private float al;
  private m am;
  private n an = null;
  private x ao = null;
  private com.tencent.liteav.beauty.b.j ap = null;
  private com.tencent.liteav.beauty.b.i aq = null;
  private h ar = null;
  private l as = null;
  private com.tencent.liteav.basic.c.i at = null;
  private h au = null;
  private final Queue<Runnable> av = new LinkedList();
  private boolean aw;
  private Object ax = new Object();
  private Object ay = new Object();
  private Handler az;
  protected int[] b = null;
  private j.a ba = new c.12(this);
  protected int[] c = null;
  com.tencent.liteav.beauty.b.a d = new com.tencent.liteav.beauty.b.a();
  com.tencent.liteav.beauty.b.a e = new com.tencent.liteav.beauty.b.a();
  com.tencent.liteav.beauty.b.a f = new com.tencent.liteav.beauty.b.a();
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
    this.E = paramContext;
    this.az = new Handler(this.E.getMainLooper());
    this.aw = paramBoolean;
  }
  
  private int A(int paramInt)
  {
    GLES20.glViewport(0, 0, this.J, this.K);
    return a(this.aa.q(), paramInt, 0L);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (true == this.aw)
    {
      if (this.aY != null)
      {
        NativeLoad.getInstance();
        NativeLoad.nativeGlReadPixs(paramInt1, paramInt2, this.aQ);
        this.aY.a(this.aQ, this.Q, this.R, this.X, TXCTimeUtil.generatePtsMS());
        return 0;
      }
      if (this.aT != null)
      {
        NativeLoad.getInstance();
        NativeLoad.nativeGlReadPixs(paramInt1, paramInt2, this.aT);
        return 0;
      }
    }
    else
    {
      if (3 == com.tencent.liteav.basic.c.j.a())
      {
        if (0L == this.aM) {
          this.aM = TXCTimeUtil.getTimeTick();
        }
        int i1 = this.aN + 1;
        this.aN = i1;
        if (i1 >= 100)
        {
          float f1 = 100.0F / ((float)(TXCTimeUtil.getTimeTick() - this.aM) / 1000.0F);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Real fps ");
          ((StringBuilder)localObject).append(f1);
          TXCLog.i("TXCFilterDrawer", ((StringBuilder)localObject).toString());
          this.aN = 0;
          this.aM = TXCTimeUtil.getTimeTick();
        }
        GLES30.glPixelStorei(3333, 1);
        if (Build.VERSION.SDK_INT >= 18) {
          GLES30.glReadBuffer(1029);
        }
        GLES30.glBindBuffer(35051, this.aR[0]);
        NativeLoad.getInstance();
        Object localObject = null;
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
        NativeLoad.getInstance();
        NativeLoad.nativeGlMapBufferToQueue(paramInt1, paramInt2, (ByteBuffer)localObject);
        if (Build.VERSION.SDK_INT >= 18) {
          GLES30.glUnmapBuffer(35051);
        }
        GLES30.glBindBuffer(35051, 0);
        return 0;
      }
      NativeLoad.getInstance();
      NativeLoad.nativeGlReadPixsToQueue(paramInt1, paramInt2);
    }
    return 0;
  }
  
  private int a(int paramInt, long paramLong)
  {
    int i1 = this.X;
    if (i1 == 0)
    {
      if (this.aY != null)
      {
        long l1 = paramLong;
        if (paramLong == 0L) {
          l1 = TXCTimeUtil.generatePtsMS();
        }
        this.aY.a(paramInt, this.Q, this.R, l1);
      }
      return paramInt;
    }
    if ((1 != i1) && (3 != i1) && (2 != i1))
    {
      TXCLog.e("TXCFilterDrawer", "Don't support format!");
      return -1;
    }
    GLES20.glViewport(0, 0, this.Q, this.R);
    if (this.ab == null)
    {
      TXCLog.e("TXCFilterDrawer", "mRGBA2I420Filter is null!");
      return paramInt;
    }
    GLES20.glBindFramebuffer(36160, this.b[0]);
    this.ab.a(paramInt);
    if (2 == this.X) {
      a(this.Q, this.R);
    } else {
      a(this.Q, this.R * 3 / 8);
    }
    GLES20.glBindFramebuffer(36160, 0);
    return paramInt;
  }
  
  private void a(int paramInt1, int paramInt2, float paramFloat1, Bitmap paramBitmap1, float paramFloat2, Bitmap paramBitmap2, float paramFloat3)
  {
    if (this.am == null)
    {
      TXCLog.i("TXCFilterDrawer", "createComLooKupFilter");
      this.am = new m(paramFloat1, paramBitmap1, paramFloat2, paramBitmap2, paramFloat3);
      if (true == this.am.a())
      {
        this.am.a(true);
        this.am.a(paramInt1, paramInt2);
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
      if (this.ad == null) {
        this.ad = new com.tencent.liteav.beauty.b.a.a();
      }
      this.ac = this.ad;
      Log.i("TXCFilterDrawer", "0 BeautyFilter");
    }
    else if (1 == paramInt3)
    {
      if (this.ae == null) {
        this.ae = new com.tencent.liteav.beauty.b.b.a();
      }
      this.ac = this.ae;
      Log.i("TXCFilterDrawer", "1 BeautyFilter");
    }
    else if (2 == paramInt3)
    {
      if (this.ag == null) {
        this.ag = new com.tencent.liteav.beauty.b.c.a();
      }
      this.ac = this.ag;
      Log.i("TXCFilterDrawer", "2 BeautyFilter");
    }
    else if (3 == paramInt3)
    {
      if (this.af == null) {
        this.af = new com.tencent.liteav.beauty.b.c();
      }
      this.ac = this.af;
      Log.i("TXCFilterDrawer", "3 BeautyFilter");
    }
    com.tencent.liteav.beauty.b.b localb = this.ac;
    if (localb == null)
    {
      TXCLog.e("TXCFilterDrawer", "mBeautyFilter set error!");
      return;
    }
    localb.a(true);
    if (true == this.ac.c(paramInt1, paramInt2))
    {
      paramInt1 = this.aD;
      if (paramInt1 > 0) {
        this.ac.c(paramInt1);
      }
      paramInt1 = this.aE;
      if (paramInt1 > 0) {
        this.ac.d(paramInt1);
      }
      paramInt1 = this.aG;
      if (paramInt1 > 0) {
        this.ac.e(paramInt1);
      }
      paramInt1 = this.aF;
      if (paramInt1 > 0) {
        this.ac.f(paramInt1);
      }
    }
    else
    {
      TXCLog.e("TXCFilterDrawer", "mBeautyFilter init failed!");
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Object localObject1 = this.ay;
    paramInt5 = (paramInt5 + 360) % 360;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("real outputAngle ");
      localStringBuilder.append(paramInt5);
      TXCLog.i("TXCFilterDrawer", localStringBuilder.toString());
      if (this.ar == null)
      {
        if ((paramInt1 == paramInt3) && (paramInt2 == paramInt4) && (paramInt5 == 0))
        {
          TXCLog.i("TXCFilterDrawer", "Don't need change output Image, don't create out filter!");
          return;
        }
        this.ar = new h();
        if (true == this.ar.a()) {
          this.ar.a(true);
        } else {
          TXCLog.e("TXCFilterDrawer", "mOutputZoomFilter init failed!");
        }
      }
      this.ar.a(paramInt3, paramInt4);
      this.ar.a((720 - paramInt5) % 360, null);
      return;
    }
    finally {}
  }
  
  private void a(com.tencent.liteav.basic.c.a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6)
  {
    if (this.as == null)
    {
      TXCLog.i("TXCFilterDrawer", "Create CropFilter");
      if (4 == paramInt6) {
        this.as = new l("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform mat4 textureTransform;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (textureTransform * inputTextureCoordinate).xy;\n}", "#extension GL_OES_EGL_image_external : require\n\nvarying lowp vec2 textureCoordinate;\n \nuniform samplerExternalOES inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}", true);
      } else {
        this.as = new l();
      }
      if (true == this.as.a()) {
        this.as.a(true);
      } else {
        TXCLog.e("TXCFilterDrawer", "mInputCropFilter init failed!");
      }
    }
    l locall = this.as;
    locall.a(paramInt3, paramInt4);
    parama = this.as.a(this.J, this.K, null, parama, paramInt6);
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
    this.as.a(paramInt1, paramInt2, i1, parama, paramInt5 / paramInt6, paramBoolean, false);
  }
  
  private void a(Runnable paramRunnable)
  {
    synchronized (this.av)
    {
      this.av.add(paramRunnable);
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
      e locale = this.aY;
      if (locale != null)
      {
        locale.a(paramArrayOfByte, this.Q, this.R, this.X, TXCTimeUtil.generatePtsMS());
        return;
      }
      TXCLog.i("TXCFilterDrawer", "First Frame, don't process!");
      return;
    }
    int i1 = this.R;
    int i2 = i1 * 3 / 8;
    if (2 != this.X) {
      i1 = i2;
    }
    if (this.aY != null)
    {
      NativeLoad.getInstance();
      if (true == NativeLoad.nativeGlReadPixsFromQueue(this.Q, i1, this.aQ))
      {
        this.aY.a(this.aQ, this.Q, this.R, this.X, TXCTimeUtil.generatePtsMS());
        return;
      }
      TXCLog.d("TXCFilterDrawer", "nativeGlReadPixsFromQueue Failed");
      this.aY.a(paramArrayOfByte, this.Q, this.R, this.X, TXCTimeUtil.generatePtsMS());
      return;
    }
    NativeLoad.getInstance();
    if (!NativeLoad.nativeGlReadPixsFromQueue(this.Q, i1, this.aT)) {
      TXCLog.d("TXCFilterDrawer", "nativeGlReadPixsFromQueue Failed");
    }
  }
  
  private void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2)
  {
    GLES20.glGenFramebuffers(1, paramArrayOfInt1, 0);
    paramArrayOfInt2[0] = com.tencent.liteav.basic.c.j.a(paramInt1, paramInt2, 6408, 6408, paramArrayOfInt2);
    GLES20.glBindFramebuffer(36160, paramArrayOfInt1[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramArrayOfInt2[0], 0);
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  private void b()
  {
    TXCLog.i("TXCFilterDrawer", "come into releaseInternal");
    this.aS = false;
    Object localObject = this.aa;
    if (localObject != null)
    {
      ((k)localObject).d();
      this.aa = null;
    }
    localObject = this.ab;
    if (localObject != null)
    {
      ((o)localObject).d();
      this.ab = null;
    }
    c();
    localObject = this.am;
    if (localObject != null)
    {
      ((m)localObject).d();
      this.am = null;
    }
    localObject = this.an;
    if (localObject != null)
    {
      ((n)localObject).a();
      this.an = null;
    }
    localObject = this.at;
    if (localObject != null)
    {
      ((com.tencent.liteav.basic.c.i)localObject).d();
      this.at = null;
    }
    localObject = this.as;
    if (localObject != null)
    {
      ((l)localObject).d();
      this.as = null;
    }
    localObject = this.ar;
    if (localObject != null)
    {
      ((h)localObject).d();
      this.ar = null;
    }
    localObject = this.ao;
    if (localObject != null)
    {
      ((x)localObject).d();
      this.ao = null;
    }
    localObject = this.ap;
    if (localObject != null)
    {
      ((com.tencent.liteav.beauty.b.j)localObject).a();
      this.ap = null;
    }
    localObject = this.aq;
    if (localObject != null)
    {
      ((com.tencent.liteav.beauty.b.i)localObject).d();
      this.aq = null;
    }
    localObject = this.au;
    if (localObject != null)
    {
      ((h)localObject).d();
      this.au = null;
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
    TXCLog.i("TXCFilterDrawer", "come out releaseInternal");
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (this.au == null)
    {
      TXCLog.i("TXCFilterDrawer", "createRecoverScaleFilter");
      this.au = new h();
      if (true == this.au.a()) {
        this.au.a(true);
      } else {
        TXCLog.e("TXCFilterDrawer", "mRecoverScaleFilter init failed!");
      }
    }
    h localh = this.au;
    if (localh != null) {
      localh.a(paramInt1, paramInt2);
    }
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    k localk = this.aa;
    if (localk == null)
    {
      TXCLog.e("TXCFilterDrawer", "mI4202RGBAFilter is null!");
      return;
    }
    localk.a(paramArrayOfByte);
  }
  
  private void c()
  {
    Object localObject = this.ad;
    if (localObject != null)
    {
      ((com.tencent.liteav.beauty.b.a.a)localObject).d();
      this.ad = null;
    }
    localObject = this.ae;
    if (localObject != null)
    {
      ((com.tencent.liteav.beauty.b.b.a)localObject).d();
      this.ae = null;
    }
    localObject = this.af;
    if (localObject != null)
    {
      ((com.tencent.liteav.beauty.b.c)localObject).d();
      this.af = null;
    }
    localObject = this.ag;
    if (localObject != null)
    {
      ((com.tencent.liteav.beauty.b.c.a)localObject).d();
      this.ag = null;
    }
    this.ac = null;
  }
  
  private boolean c(d.b paramb)
  {
    TXCLog.i("TXCFilterDrawer", "come into initInternal");
    b();
    this.aw = paramb.j;
    this.J = paramb.d;
    this.K = paramb.e;
    this.Y = paramb.m;
    int i3 = paramb.g;
    int i4 = paramb.f;
    int i5 = paramb.h;
    this.T = paramb.i;
    this.Q = paramb.b;
    this.R = paramb.c;
    int i6 = paramb.a;
    this.L = paramb.g;
    this.M = paramb.f;
    if ((i5 == 90) || (i5 == 270))
    {
      this.L = paramb.f;
      this.M = paramb.g;
    }
    this.X = paramb.l;
    this.W = paramb.k;
    this.aQ = new byte[this.Q * this.R * 4];
    TXCLog.i("TXCFilterDrawer", "processWidth mPituScaleRatio is %f, process size: %d x %d", new Object[] { Float.valueOf(this.P), Integer.valueOf(this.L), Integer.valueOf(this.M) });
    if (this.P != 1.0F)
    {
      int i1 = this.L;
      int i2 = this.M;
      if (i1 >= i2) {
        i1 = i2;
      }
      if (i1 > 368) {
        this.P = (432.0F / i1);
      }
      if (this.P > 1.0F) {
        this.P = 1.0F;
      }
    }
    float f1 = this.L;
    float f2 = this.P;
    this.N = ((int)(f1 * f2));
    this.O = ((int)(this.M * f2));
    a(this.N, this.O, this.aC);
    paramb = this.I;
    if ((paramb != null) && (paramb.a != null) && (this.ao == null))
    {
      TXCLog.i("TXCFilterDrawer", "reset water mark!");
      a(this.I.a, this.I.b, this.I.c, this.I.d);
    }
    if (((this.ah != null) || (this.ai != null)) && (this.am == null)) {
      a(this.N, this.O, this.aj, this.ah, this.ak, this.ai, this.al);
    }
    a(this.Y, i3, i4, this.N, this.O, this.T, i5, this.W);
    a(this.L, this.M, this.Q, this.R, i6);
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
    a(this.b, this.c, this.Q, this.R);
    if (3 == com.tencent.liteav.basic.c.j.a())
    {
      if (this.aR == null)
      {
        this.aR = new int[1];
      }
      else
      {
        TXCLog.i("TXCFilterDrawer", "m_pbo0 is not null, delete Buffers, and recreate");
        GLES30.glDeleteBuffers(1, this.aR, 0);
      }
      TXCLog.i("TXCFilterDrawer", "opengl es 3.0, use PBO");
      com.tencent.liteav.basic.c.j.a(i3, i4, this.aR);
    }
    TXCLog.i("TXCFilterDrawer", "come out initInternal");
    return true;
  }
  
  private boolean d(d.b paramb)
  {
    if (((1 == paramb.k) || (3 == paramb.k) || (2 == paramb.k)) && (this.aa == null))
    {
      this.aa = new k(paramb.k);
      this.aa.a(true);
      if (!this.aa.a())
      {
        TXCLog.e("TXCFilterDrawer", "mI4202RGBAFilter init failed!!, break init");
        return false;
      }
      this.aa.a(paramb.d, paramb.e);
    }
    if (((1 == paramb.l) || (3 == paramb.l) || (2 == paramb.l)) && (this.ab == null))
    {
      this.ab = new o(paramb.l);
      if (!this.ab.a())
      {
        TXCLog.e("TXCFilterDrawer", "mRGBA2I420Filter init failed!!, break init");
        return false;
      }
      this.ab.a(paramb.b, paramb.c);
    }
    return true;
  }
  
  public int a(int paramInt1, int paramInt2, long paramLong)
  {
    a(this.av);
    int i1;
    if (this.P != 1.0F) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    GLES20.glViewport(0, 0, this.N, this.O);
    int i2 = paramInt1;
    if (this.as != null)
    {
      if ((4 == paramInt2) || (true == this.V))
      {
        this.as.a(this.U);
        this.as.c(this.V);
      }
      i2 = this.as.b(paramInt1);
    }
    paramInt1 = i2;
    if (this.ac != null)
    {
      if (Math.min(this.Q, this.R) < 540) {
        paramInt2 = 0;
      } else {
        paramInt2 = this.aF;
      }
      this.ac.f(paramInt2);
      if ((this.aD <= 0) && (this.aE <= 0) && (this.aG <= 0))
      {
        paramInt1 = i2;
        if (paramInt2 <= 0) {}
      }
      else
      {
        paramInt1 = this.ac.b(i2);
      }
    }
    Object localObject = this.am;
    paramInt2 = paramInt1;
    if (localObject != null) {
      paramInt2 = ((m)localObject).b(paramInt1);
    }
    GLES20.glViewport(0, 0, this.L, this.M);
    localObject = this.ap;
    paramInt1 = paramInt2;
    if (localObject != null)
    {
      paramInt1 = ((com.tencent.liteav.beauty.b.j)localObject).a(paramInt2);
      i1 = 0;
    }
    localObject = this.aq;
    paramInt2 = paramInt1;
    if (localObject != null)
    {
      paramInt2 = ((com.tencent.liteav.beauty.b.i)localObject).b(paramInt1);
      i1 = 0;
    }
    paramInt1 = paramInt2;
    if (i1 != 0)
    {
      b(this.L, this.M);
      paramInt1 = paramInt2;
      if (this.au != null)
      {
        GLES20.glViewport(0, 0, this.L, this.M);
        paramInt1 = this.au.b(paramInt2);
      }
    }
    localObject = this.aY;
    paramInt2 = paramInt1;
    if (localObject != null)
    {
      i1 = ((e)localObject).a(paramInt1, this.L, this.M);
      paramInt2 = paramInt1;
      if (i1 > 0) {
        paramInt2 = i1;
      }
    }
    GLES20.glViewport(0, 0, this.L, this.M);
    localObject = this.ao;
    paramInt1 = paramInt2;
    if (localObject != null) {
      paramInt1 = ((x)localObject).b(paramInt2);
    }
    paramInt2 = paramInt1;
    if (this.ar != null)
    {
      GLES20.glViewport(0, 0, this.Q, this.R);
      paramInt2 = this.ar.b(paramInt1);
    }
    a(paramInt2, paramLong);
    return paramInt2;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    a(paramArrayOfByte);
    if (!this.aw)
    {
      paramArrayOfByte = (byte[])paramArrayOfByte.clone();
      this.aA.obtainMessage(2, paramArrayOfByte).sendToTarget();
      if (!this.aS)
      {
        TXCLog.i("TXCFilterDrawer", "First Frame, clear queue");
        NativeLoad.getInstance();
        NativeLoad.nativeClearQueue();
      }
      this.aA.obtainMessage(3, paramInt, 0).sendToTarget();
      a(paramArrayOfByte, this.aS);
      this.aS = true;
      return -1;
    }
    b(paramArrayOfByte);
    return A(paramInt);
  }
  
  public void a()
  {
    if (!this.aw)
    {
      c.a locala = this.aA;
      if (locala == null) {
        break label36;
      }
      locala.obtainMessage(1).sendToTarget();
    }
    try
    {
      this.d.b();
      return;
    }
    catch (InterruptedException localInterruptedException) {}
    b();
    label36:
    return;
  }
  
  public void a(float paramFloat)
  {
    this.aB = paramFloat;
    a(new c.1(this, paramFloat));
  }
  
  public void a(float paramFloat1, Bitmap paramBitmap1, float paramFloat2, Bitmap paramBitmap2, float paramFloat3)
  {
    if ((this.ah == paramBitmap1) && (this.ai == paramBitmap2))
    {
      if ((this.am != null) && ((this.aj != paramFloat1) || (this.ak != paramFloat2) || (this.al != paramFloat3)))
      {
        this.aj = paramFloat1;
        this.ak = paramFloat2;
        this.al = paramFloat3;
        a(new c.8(this, paramFloat1, paramFloat2, paramFloat3));
      }
    }
    else
    {
      this.ah = paramBitmap1;
      this.ai = paramBitmap2;
      this.aj = paramFloat1;
      this.ak = paramFloat2;
      this.al = paramFloat3;
      a(new c.6(this, paramFloat1, paramBitmap1, paramFloat2, paramBitmap2, paramFloat3));
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(Bitmap paramBitmap)
  {
    a(1.0F, paramBitmap, this.aB, null, 0.0F);
  }
  
  public void a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.I == null) {
      this.I = new d.f();
    }
    if ((TXCCommonUtil.equals(this.I.a, paramBitmap)) && (paramFloat1 == this.I.b) && (paramFloat2 == this.I.c) && (paramFloat3 == this.I.d) && (this.ao != null))
    {
      Log.d("TXCFilterDrawer", "Same Water Mark; don't set again");
      return;
    }
    d.f localf = this.I;
    localf.a = paramBitmap;
    localf.b = paramFloat1;
    localf.c = paramFloat2;
    localf.d = paramFloat3;
    a(new c.10(this, paramBitmap, paramFloat1, paramFloat2, paramFloat3));
  }
  
  void a(com.tencent.liteav.basic.b.b paramb)
  {
    TXCLog.i("TXCFilterDrawer", "set notify");
    this.aZ = new WeakReference(paramb);
    paramb = this.ap;
    if (paramb != null) {
      paramb.a((com.tencent.liteav.basic.b.b)this.aZ.get());
    }
  }
  
  void a(e parame)
  {
    TXCLog.i("TXCFilterDrawer", "set listener");
    this.aY = parame;
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean)
  {
    a(new c.9(this, paramBoolean));
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.aT = paramArrayOfByte;
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
        if (this.aA == null)
        {
          start();
          this.aA = new c.a(this, getLooper(), this.E);
        }
        this.aA.obtainMessage(0, paramb).sendToTarget();
        this.aA.b();
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
    if (!this.aw)
    {
      c.a locala = this.aA;
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
    this.aD = paramInt;
    a(new c.13(this, paramInt));
  }
  
  public void d(int paramInt)
  {
    if ((this.aC != paramInt) && (paramInt <= 3))
    {
      if (paramInt < 0) {
        return;
      }
      this.aC = paramInt;
      a(new c.2(this, paramInt));
    }
  }
  
  public void e(int paramInt)
  {
    this.aE = paramInt;
    a(new c.3(this, paramInt));
  }
  
  public void f(int paramInt)
  {
    this.aF = paramInt;
    a(new c.4(this, paramInt));
  }
  
  public void g(int paramInt)
  {
    this.aG = paramInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.beauty.c
 * JD-Core Version:    0.7.0.1
 */