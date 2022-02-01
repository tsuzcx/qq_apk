package com.tencent.liteav;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.view.Surface;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils;
import com.tencent.liteav.basic.opengl.j;
import com.tencent.liteav.basic.opengl.n;
import com.tencent.liteav.basic.opengl.p;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.beauty.d.d;
import com.tencent.liteav.renderer.TXCGLSurfaceView;
import com.tencent.liteav.screencapture.a.a;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import com.tencent.liteav.videoencoder.e;
import com.tencent.rtmp.TXLog;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

public class d
  extends com.tencent.liteav.basic.module.a
  implements b.b, com.tencent.liteav.basic.c.b, com.tencent.liteav.beauty.f, l, e
{
  private final Object A = new Object();
  private Surface B = null;
  private int C = 0;
  private int D = 0;
  private com.tencent.liteav.basic.opengl.g E = null;
  private com.tencent.liteav.basic.structs.b F;
  private int G = 0;
  private boolean H = false;
  private boolean I = false;
  private volatile boolean J = false;
  private long K = 0L;
  private long L = 0L;
  private int M = 2;
  private WeakReference<o> N;
  private boolean O = false;
  private WeakReference<d.a> P = null;
  private j Q = null;
  private j R;
  private j S;
  private com.tencent.liteav.beauty.b.k T;
  private int U = -1;
  private boolean V = false;
  private boolean W = false;
  private boolean X = false;
  private final com.tencent.liteav.beauty.b Y;
  private boolean Z = true;
  b a;
  private WeakReference<m> aa;
  private com.tencent.liteav.basic.opengl.f ab = null;
  private WeakReference<com.tencent.liteav.basic.c.b> ac;
  private int ad = 0;
  private int ae = 0;
  b b;
  private final com.tencent.liteav.basic.util.c c = new com.tencent.liteav.basic.util.c("capturer", (int)TimeUnit.SECONDS.toMillis(5L));
  private final com.tencent.liteav.basic.util.f d = new com.tencent.liteav.basic.util.f(Looper.getMainLooper());
  private k e = null;
  private com.tencent.liteav.beauty.d f = null;
  private boolean g = false;
  private boolean h = false;
  private TXSVideoEncoderParam i = null;
  private com.tencent.liteav.videoencoder.b j = null;
  private int k = 8;
  private boolean l = false;
  private TXSVideoEncoderParam m = null;
  private com.tencent.liteav.videoencoder.b n = null;
  private final Object o = new Object();
  private Context p = null;
  private g q = null;
  private com.tencent.liteav.basic.structs.c r = com.tencent.liteav.basic.structs.c.b;
  private int s = 0;
  private int t = 0;
  private int u = 0;
  private boolean v = false;
  private int w = 0;
  private int x = 0;
  private boolean y = false;
  private TXCloudVideoView z = null;
  
  public d(Context paramContext)
  {
    this.p = paramContext.getApplicationContext();
    this.q = new g();
    this.f = new com.tencent.liteav.beauty.d(this.p, true);
    this.f.a(this);
    this.f.a(this);
    if (this.q.V) {
      this.f.a(d.d.a);
    } else if (this.q.U) {
      this.f.a(d.d.b);
    } else {
      this.f.a(d.d.c);
    }
    this.i = new TXSVideoEncoderParam();
    this.i.encoderMode = 1;
    this.j = null;
    this.m = new TXSVideoEncoderParam();
    this.m.encoderMode = 1;
    this.a = new b(this);
    this.Y = new com.tencent.liteav.beauty.b(new com.tencent.liteav.basic.license.g(this.p));
    this.Y.setPreprocessor(this.f);
    com.tencent.liteav.basic.d.c.a().a(this.p);
  }
  
  private void A()
  {
    try
    {
      com.tencent.liteav.videoencoder.b localb = this.n;
      this.n = null;
      if (localb != null)
      {
        localb.a();
        localb.a(null);
        return;
      }
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCCaptureAndEnc", "stop video encoder failed.", localException);
    }
  }
  
  private void B()
  {
    try
    {
      TXCLog.i("TXCCaptureAndEnc", "stopBigVideoEncoderInGLThread");
      com.tencent.liteav.videoencoder.b localb = this.j;
      this.j = null;
      if (localb != null)
      {
        localb.a();
        localb.a(null);
      }
      this.W = true;
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCCaptureAndEnc", "stopBigVideoEncoder failed.", localException);
    }
  }
  
  private void C()
  {
    k localk = this.e;
    if (localk != null) {
      localk.a(new d.17(this));
    }
  }
  
  private void D()
  {
    if (this.f != null)
    {
      if (this.q.V)
      {
        this.f.a(d.d.a);
        return;
      }
      if (this.q.U)
      {
        this.f.a(d.d.b);
        return;
      }
      this.f.a(d.d.c);
    }
  }
  
  private int a(int paramInt1, int paramInt2, Object paramObject)
  {
    paramInt1 = this.q.a;
    paramInt2 = this.q.b;
    if ((this.q.m == 0) || (this.q.m == 2))
    {
      paramInt1 = this.q.b;
      paramInt2 = this.q.a;
    }
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      if (this.q.N)
      {
        B();
        return -1000;
      }
      b(paramInt1, paramInt2, paramObject);
      return 0;
    }
    TXCLog.e("TXCCaptureAndEnc", "sendCustomYUVData: invalid video encode resolution");
    return -1;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    long l1 = paramLong;
    if (paramLong == 0L) {
      l1 = TXCTimeUtil.generatePtsMS();
    }
    b(paramInt2, paramInt3, this.f.a());
    com.tencent.liteav.videoencoder.b localb = this.j;
    if (localb != null)
    {
      localb.b(this.Z);
      localb.a(paramInt1, paramInt2, paramInt3, l1);
    }
    localb = this.n;
    if (localb != null)
    {
      localb.b(this.Z);
      localb.a(paramInt1, paramInt2, paramInt3, l1);
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, Object paramObject, int paramInt4, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("New encode size width = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" height = ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" encType = ");
    ((StringBuilder)localObject).append(paramInt3);
    ((StringBuilder)localObject).append(" eglContext: ");
    ((StringBuilder)localObject).append(paramObject);
    TXCLog.i("TXCCaptureAndEnc", ((StringBuilder)localObject).toString());
    B();
    localObject = new com.tencent.liteav.videoencoder.b(paramInt3);
    TXCStatus.a(getID(), 4005, this.G, Integer.valueOf(paramInt3));
    if (paramInt3 == 1) {
      TXCEventRecorderProxy.a(getID(), 4004, 1L, -1L, "", this.G);
    } else {
      TXCEventRecorderProxy.a(getID(), 4004, 0L, -1L, "", this.G);
    }
    this.W = false;
    TXSVideoEncoderParam localTXSVideoEncoderParam = this.i;
    localTXSVideoEncoderParam.encodeType = paramInt3;
    localTXSVideoEncoderParam.width = paramInt1;
    localTXSVideoEncoderParam.height = paramInt2;
    localTXSVideoEncoderParam.fps = paramInt4;
    localTXSVideoEncoderParam.gop = this.q.j;
    this.i.encoderProfile = this.q.o;
    localTXSVideoEncoderParam = this.i;
    if (paramObject == null) {
      paramObject = ((com.tencent.liteav.videoencoder.b)localObject).a(paramInt1, paramInt2);
    }
    localTXSVideoEncoderParam.glContext = paramObject;
    paramObject = this.i;
    paramObject.realTime = paramBoolean;
    paramObject.streamType = this.G;
    paramObject.annexb = this.I;
    paramObject.bMultiRef = this.H;
    paramObject.baseFrameIndex = (this.K + 20L);
    paramObject.baseGopIndex = ((this.L + 1L) % 255L + 1L);
    paramObject.bLimitFps = this.h;
    paramObject.record = this.X;
    paramObject.encFmt = this.q.Z;
    this.i.isH265EncoderEnabled = this.J;
    this.i.bitrate = this.q.c;
    ((com.tencent.liteav.videoencoder.b)localObject).a(this);
    ((com.tencent.liteav.videoencoder.b)localObject).a(this);
    ((com.tencent.liteav.videoencoder.b)localObject).a(this.i);
    ((com.tencent.liteav.videoencoder.b)localObject).c(this.q.c);
    ((com.tencent.liteav.videoencoder.b)localObject).d(this.k);
    ((com.tencent.liteav.videoencoder.b)localObject).setID(getID());
    ((com.tencent.liteav.videoencoder.b)localObject).a(this.ad);
    ((com.tencent.liteav.videoencoder.b)localObject).a(this.r);
    this.j = ((com.tencent.liteav.videoencoder.b)localObject);
    TXCStatus.a(getID(), 4003, this.G, Integer.valueOf(this.i.width << 16 | this.i.height));
    TXCStatus.a(getID(), 13003, this.G, Integer.valueOf(this.i.gop * 1000));
    TXCEventRecorderProxy.a(getID(), 4003, this.i.width, this.i.height, "", this.G);
    TXCKeyPointReportProxy.a(40036, this.i.encodeType, this.G);
    TXCKeyPointReportProxy.a(40037, this.i.width << 16 | this.i.height, this.G);
  }
  
  private void a(int paramInt, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("EVT_USERID", getID());
    localBundle.putInt("EVT_ID", paramInt);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    localBundle.putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
    if (paramString != null) {
      localBundle.putCharSequence("EVT_MSG", paramString);
    }
    com.tencent.liteav.basic.util.h.a(this.ac, paramInt, localBundle);
    long l1;
    if (paramInt == -1314)
    {
      TXCEventRecorderProxy.a(getID(), 2002, 5L, -1L, "", this.G);
    }
    else if ((paramInt == 1003) && (this.e != null))
    {
      paramString = getID();
      if (this.e.l()) {
        l1 = 0L;
      } else {
        l1 = 1L;
      }
      TXCEventRecorderProxy.a(paramString, 4001, l1, -1L, "", this.G);
    }
    if ((paramInt == -1301) || (paramInt == -1314) || (paramInt == -1315) || (paramInt == -1316))
    {
      TXCKeyPointReportProxy.b(30003, paramInt);
      if (this.e != null)
      {
        paramString = getID();
        if (this.e.l()) {
          l1 = 0L;
        } else {
          l1 = 1L;
        }
        TXCEventRecorderProxy.a(paramString, 4002, l1, paramInt, "", this.G);
      }
    }
  }
  
  private void a(com.tencent.liteav.basic.structs.b paramb, int paramInt1, int paramInt2, Object paramObject, long paramLong)
  {
    synchronized (this.o)
    {
      if ((this.u != 2) && ((this.b == null) || (!this.b.a())))
      {
        paramb.e = paramInt1;
        paramb.f = paramInt2;
        paramb.i = this.q.T;
        if (this.q.m == 0)
        {
          paramb.g = this.q.b;
          paramb.h = this.q.a;
        }
        else
        {
          paramb.g = this.q.a;
          paramb.h = this.q.b;
        }
        paramb.l = com.tencent.liteav.basic.util.h.a(paramb.e, paramb.f, paramb.g, paramb.h);
        try
        {
          this.f.a(this.q.m);
          this.f.a(paramObject);
          this.f.a(paramb, paramb.b, 0, paramLong);
        }
        catch (Exception paramb)
        {
          paramObject = new StringBuilder();
          paramObject.append("send custom video frame failed.");
          paramObject.append(paramb.getMessage());
          TXCLog.e("TXCCaptureAndEnc", paramObject.toString());
        }
        return;
      }
      return;
    }
  }
  
  private void a(com.tencent.liteav.basic.structs.b paramb, boolean paramBoolean)
  {
    e(paramb.e, paramb.f);
    this.F = paramb;
    if (this.z != null)
    {
      ??? = this.e;
      if (??? != null) {
        ((k)???).a(paramb);
      }
    }
    else
    {
      synchronized (this.A)
      {
        if ((this.B != null) && (this.E == null) && (this.e != null) && (this.e.f() != null))
        {
          this.E = new com.tencent.liteav.basic.opengl.g();
          this.E.a(this.e.f(), this.B);
          this.E.a(this.x);
          this.E.b(this.ae);
        }
        if ((this.E != null) && (this.e != null)) {
          this.E.a(paramb.a, paramb.i, this.w, this.C, this.D, paramb.e, paramb.f, paramBoolean, this.e.l());
        }
        return;
      }
    }
  }
  
  private void a(Object paramObject, int paramInt, boolean paramBoolean)
  {
    A();
    com.tencent.liteav.videoencoder.b localb = new com.tencent.liteav.videoencoder.b(paramInt);
    TXCStatus.a(getID(), 4005, 3, Integer.valueOf(paramInt));
    if (paramInt == 1) {
      TXCEventRecorderProxy.a(getID(), 4004, 1L, -1L, "", 3);
    } else {
      TXCEventRecorderProxy.a(getID(), 4004, 0L, -1L, "", 3);
    }
    TXSVideoEncoderParam localTXSVideoEncoderParam = this.m;
    if (paramObject == null) {
      paramObject = localb.a(localTXSVideoEncoderParam.width, this.m.height);
    }
    localTXSVideoEncoderParam.glContext = paramObject;
    paramObject = this.m;
    paramObject.encodeType = paramInt;
    paramObject.realTime = paramBoolean;
    paramObject.isH265EncoderEnabled = false;
    TXCLog.i("TXCCaptureAndEnc", "start small video encoder");
    localb.a(this);
    localb.a(this);
    localb.a(this.m);
    localb.c(this.m.bitrate);
    localb.setID(getID());
    localb.a(this.ad);
    localb.a(this.r);
    this.n = localb;
    TXCStatus.a(getID(), 4003, 3, Integer.valueOf(this.m.width << 16 | this.m.height));
    TXCStatus.a(getID(), 13003, 3, Integer.valueOf(this.m.gop * 1000));
  }
  
  private void a(Runnable paramRunnable)
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.d.a(paramRunnable);
      return;
    }
    paramRunnable.run();
  }
  
  private void b(int paramInt1, int paramInt2, Object paramObject)
  {
    int i3 = this.q.k;
    int i2 = 2;
    int i1 = i2;
    if (i3 != 0) {
      if (i3 != 1)
      {
        if (i3 != 2) {
          i1 = i2;
        } else {
          i1 = 3;
        }
      }
      else {
        i1 = 1;
      }
    }
    i2 = i1;
    if (this.s == 1)
    {
      i2 = i1;
      if (this.t == 0) {
        i2 = 1;
      }
    }
    i1 = this.q.j;
    if ((this.j == null) || (this.W) || (this.i.width != paramInt1) || (this.i.height != paramInt2) || (this.i.encodeType != i2) || (this.i.gop != i1) || (this.J != this.i.isH265EncoderEnabled)) {
      a(paramInt1, paramInt2, i2, paramObject, this.q.i, this.q.Q);
    }
    if (((this.n == null) || (this.m.encodeType != i2)) && (this.l)) {
      a(paramObject, i2, this.q.Q);
    }
  }
  
  private int c(com.tencent.liteav.basic.structs.b paramb)
  {
    if (this.O) {
      return paramb.a;
    }
    int i2 = paramb.a;
    int i7;
    if (this.ae == 1) {
      i7 = 1;
    } else {
      i7 = 0;
    }
    int i1 = i2;
    j localj;
    if (i7 != paramb.i)
    {
      if (this.R == null)
      {
        localj = new j();
        localj.a();
        localj.a(true);
        localj.a(paramb.e, paramb.f);
        if (paramb.e > paramb.f) {
          localj.h();
        } else {
          localj.g();
        }
        this.R = localj;
      }
      localj = this.R;
      i1 = i2;
      if (localj != null)
      {
        localj.a(paramb.e, paramb.f);
        i1 = localj.b(paramb.a);
      }
    }
    i2 = i1;
    if (this.w != 0)
    {
      if (this.S == null)
      {
        localj = new j();
        localj.a();
        localj.a(true);
        localj.a(paramb.e, paramb.f);
        this.S = localj;
      }
      localj = this.S;
      i2 = i1;
      if (localj != null)
      {
        GLES20.glViewport(0, 0, paramb.e, paramb.f);
        int i4 = paramb.e;
        int i5 = paramb.f;
        float[] arrayOfFloat = localj.a(i4, i5, null, com.tencent.liteav.basic.util.h.a(i4, i5, paramb.e, paramb.f), 0);
        int i6 = (720 - this.w) % 360;
        if ((i6 != 90) && (i6 != 270)) {
          i2 = paramb.e;
        } else {
          i2 = paramb.f;
        }
        int i3;
        if ((i6 != 90) && (i6 != 270)) {
          i3 = paramb.f;
        } else {
          i3 = paramb.e;
        }
        localj.a(i4, i5, i6, arrayOfFloat, i2 / i3, false, false);
        localj.b(i1);
        i2 = localj.l();
      }
    }
    return i2;
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    com.tencent.liteav.beauty.d locald;
    if (this.q.K != -1.0F)
    {
      locald = this.f;
      if (locald != null) {
        locald.a(this.q.F, this.q.I, this.q.J, this.q.K);
      }
    }
    else
    {
      locald = this.f;
      if ((locald != null) && (paramInt1 != 0) && (paramInt2 != 0))
      {
        Bitmap localBitmap = this.q.F;
        float f2 = this.q.G;
        float f1 = paramInt1;
        f2 /= f1;
        float f3 = this.q.H / paramInt2;
        if (this.q.F == null) {
          f1 = 0.0F;
        } else {
          f1 = this.q.F.getWidth() / f1;
        }
        locald.a(localBitmap, f2, f3, f1);
      }
    }
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2);
  }
  
  private void d(com.tencent.liteav.basic.structs.b paramb)
  {
    Object localObject1 = this.N;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = (o)((WeakReference)localObject1).get();
    }
    if (localObject1 == null) {
      return;
    }
    TXSVideoFrame localTXSVideoFrame = new TXSVideoFrame();
    localTXSVideoFrame.width = paramb.e;
    localTXSVideoFrame.height = paramb.f;
    localTXSVideoFrame.pts = TXCTimeUtil.generatePtsMS();
    int i2 = c(paramb);
    int i1 = this.M;
    if (i1 == 5)
    {
      localTXSVideoFrame.textureId = i2;
      localTXSVideoFrame.eglContext = this.f.a();
      if (this.U == -1)
      {
        this.U = TXCOpenGlUtils.d();
        TXCLog.i("TXCCaptureAndEnc", "create FrameBuffer: %d", new Object[] { Integer.valueOf(this.U) });
      }
      TXCOpenGlUtils.a(localTXSVideoFrame.textureId, this.U);
      GLES20.glBindFramebuffer(36160, this.U);
      ((o)localObject1).onRenderVideoFrame(getID(), this.G, localTXSVideoFrame);
      TXCOpenGlUtils.d(this.U);
      if (this.O)
      {
        if (localTXSVideoFrame.data != null) {
          localObject1 = ByteBuffer.wrap(localTXSVideoFrame.data);
        } else {
          localObject1 = localTXSVideoFrame.buffer;
        }
        ((ByteBuffer)localObject1).position(0);
        paramb.a = TXCOpenGlUtils.a((ByteBuffer)localObject1, paramb.e, paramb.f, i2);
      }
    }
    else if (i1 == 2)
    {
      localTXSVideoFrame.textureId = i2;
      localTXSVideoFrame.eglContext = this.f.a();
      ((o)localObject1).onRenderVideoFrame(getID(), this.G, localTXSVideoFrame);
      if (this.O) {
        paramb.a = localTXSVideoFrame.textureId;
      }
    }
    else if ((i1 == 1) || (i1 == 4))
    {
      Object localObject2 = this.Q;
      i1 = 3;
      if (localObject2 == null)
      {
        if (this.M == 1) {
          localObject2 = new com.tencent.liteav.beauty.b.o(1);
        } else {
          localObject2 = new com.tencent.liteav.beauty.b.o(3);
        }
        ((j)localObject2).a(true);
        if (((j)localObject2).a())
        {
          ((j)localObject2).a(paramb.e, paramb.f);
          this.Q = ((j)localObject2);
        }
        else
        {
          TXCLog.i("TXCCaptureAndEnc", "init filter error ");
          this.Q = null;
        }
      }
      localObject2 = this.Q;
      if (localObject2 != null)
      {
        GLES20.glViewport(0, 0, paramb.e, paramb.f);
        ((j)localObject2).a(paramb.e, paramb.f);
        ((j)localObject2).b(i2);
        GLES20.glBindFramebuffer(36160, ((j)localObject2).m());
        ((o)localObject1).onRenderVideoFrame(getID(), this.G, localTXSVideoFrame);
      }
      if ((this.O) && ((localTXSVideoFrame.data != null) || (localTXSVideoFrame.buffer != null)))
      {
        i2 = this.M;
        if ((i2 == 1) || (i2 != 4)) {
          i1 = 1;
        }
        if (this.T == null)
        {
          localObject1 = new com.tencent.liteav.beauty.b.k(i1);
          ((com.tencent.liteav.beauty.b.k)localObject1).a(true);
          if (!((com.tencent.liteav.beauty.b.k)localObject1).a()) {
            TXCLog.w("TXCCaptureAndEnc", " init i420ToRGBA filter failed");
          }
          ((com.tencent.liteav.beauty.b.k)localObject1).a(paramb.e, paramb.f);
          this.T = ((com.tencent.liteav.beauty.b.k)localObject1);
        }
        localObject1 = this.T;
        GLES20.glViewport(0, 0, paramb.e, paramb.f);
        ((com.tencent.liteav.beauty.b.k)localObject1).a(paramb.e, paramb.f);
        if (localTXSVideoFrame.data != null) {
          ((com.tencent.liteav.beauty.b.k)localObject1).a(localTXSVideoFrame.data);
        } else {
          ((com.tencent.liteav.beauty.b.k)localObject1).a(localTXSVideoFrame.buffer);
        }
        paramb.a = ((com.tencent.liteav.beauty.b.k)localObject1).r();
      }
    }
    if (this.O)
    {
      paramb = this.z;
      if (paramb != null)
      {
        paramb = paramb.getGLSurfaceView();
        if (paramb != null) {
          paramb.d();
        }
      }
    }
  }
  
  private void e(int paramInt1, int paramInt2)
  {
    if (!this.y)
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putString("EVT_USERID", getID());
      ((Bundle)localObject).putInt("EVT_ID", 2003);
      ((Bundle)localObject).putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
      ((Bundle)localObject).putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
      ((Bundle)localObject).putCharSequence("EVT_MSG", "Renders the first video frame");
      ((Bundle)localObject).putInt("EVT_PARAM1", paramInt1);
      ((Bundle)localObject).putInt("EVT_PARAM2", paramInt2);
      com.tencent.liteav.basic.util.h.a(this.ac, 2003, (Bundle)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("trtc_render render first frame ");
      ((StringBuilder)localObject).append(getID());
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(this.G);
      TXCLog.i("TXCCaptureAndEnc", ((StringBuilder)localObject).toString());
      this.y = true;
    }
  }
  
  private void l(boolean paramBoolean)
  {
    ??? = this.e;
    if (??? == null) {
      return;
    }
    ((k)???).a(new d.7(this));
    u();
    this.e.a(paramBoolean);
    this.e = null;
    TXCLog.i("TXCCaptureAndEnc", "stopped CaptureSource");
    ??? = this.z;
    this.d.post(new d.8(this, (TXCloudVideoView)???, paramBoolean));
    this.z = null;
    synchronized (this.A)
    {
      this.B = null;
      if (this.E != null)
      {
        this.E.a();
        this.E = null;
      }
      if (this.a.a()) {
        this.a.b();
      }
      if (this.v) {
        x();
      }
      return;
    }
  }
  
  private void m(boolean paramBoolean)
  {
    k localk = this.e;
    if (localk != null) {
      localk.a(new d.16(this, paramBoolean));
    }
  }
  
  private void x()
  {
    TXCLog.i("TXCCaptureAndEnc", " startBlackStream");
    if (this.b == null) {
      this.b = new b(this);
    }
    this.b.a(10, -1, null, 64, 64);
  }
  
  private void y()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" stopBlackStream when enableBlackStream ");
    ((StringBuilder)localObject).append(this.v);
    TXCLog.i("TXCCaptureAndEnc", ((StringBuilder)localObject).toString());
    localObject = this.b;
    if (localObject != null) {
      ((b)localObject).b();
    }
  }
  
  private void z()
  {
    int i1 = this.U;
    if (i1 != -1)
    {
      TXCLog.i("TXCCaptureAndEnc", "destroy FrameBuffer: %d", new Object[] { Integer.valueOf(i1) });
      TXCOpenGlUtils.b(this.U);
      this.U = -1;
    }
    Object localObject = this.ab;
    m localm = null;
    if (localObject != null)
    {
      ((com.tencent.liteav.basic.opengl.f)localObject).e();
      this.ab = null;
    }
    localObject = this.aa;
    if (localObject != null) {
      localm = (m)((WeakReference)localObject).get();
    }
    if (localm != null) {
      localm.onGLContextReadyToDestory();
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, Object paramObject, long paramLong)
  {
    for (;;)
    {
      synchronized (this.o)
      {
        if ((this.u != 2) && ((this.b == null) || (!this.b.a())))
        {
          int i1 = a(paramInt2, paramInt3, paramObject);
          if (i1 != 0) {
            return i1;
          }
          if (paramLong == 0L)
          {
            paramLong = TXCTimeUtil.generatePtsMS();
            paramObject = this.j;
            if (paramObject != null)
            {
              paramObject.a(this.q.T);
              paramObject.a(paramInt1, paramInt2, paramInt3, paramLong);
            }
            paramObject = this.n;
            if (paramObject != null)
            {
              paramObject.a(this.q.T);
              paramObject.a(paramInt1, paramInt2, paramInt3, paramLong);
            }
            return 0;
          }
        }
        else
        {
          return 0;
        }
      }
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, Object paramObject, long paramLong, int paramInt4)
  {
    com.tencent.liteav.basic.structs.b localb = new com.tencent.liteav.basic.structs.b();
    localb.a = paramInt1;
    localb.b = 0;
    a(localb, paramInt2, paramInt3, paramObject, paramLong);
    return 0;
  }
  
  public int a(com.tencent.liteav.basic.structs.b paramb)
  {
    Object localObject = this.aa;
    if (localObject != null) {
      localObject = (m)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      com.tencent.liteav.basic.opengl.f localf = this.ab;
      if ((localf == null) || (localf.c() != paramb.e) || (this.ab.d() != paramb.f))
      {
        localf = this.ab;
        if (localf != null) {
          localf.e();
        }
        this.ab = new com.tencent.liteav.basic.opengl.f(paramb.e, paramb.f);
        this.ab.a();
      }
      paramb.a = ((m)localObject).onProcessVideoFrame(paramb.a, paramb.e, paramb.f, this.ab.b());
      GLES20.glDisable(3042);
      GLES20.glDisable(2929);
    }
    d(paramb);
    a(paramb, false);
    return paramb.a;
  }
  
  public int a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i1;
    if ((this.m.width == paramInt1) && (this.m.height == paramInt2)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    Object localObject = this.m;
    ((TXSVideoEncoderParam)localObject).width = paramInt1;
    ((TXSVideoEncoderParam)localObject).height = paramInt2;
    ((TXSVideoEncoderParam)localObject).fps = paramInt3;
    ((TXSVideoEncoderParam)localObject).gop = paramInt5;
    ((TXSVideoEncoderParam)localObject).encoderProfile = 1;
    ((TXSVideoEncoderParam)localObject).realTime = this.q.Q;
    localObject = this.m;
    ((TXSVideoEncoderParam)localObject).streamType = 3;
    ((TXSVideoEncoderParam)localObject).bitrate = paramInt4;
    ((TXSVideoEncoderParam)localObject).annexb = true;
    ((TXSVideoEncoderParam)localObject).bMultiRef = false;
    if ((this.n != null) && ((i1 != 0) || ((this.l) && (!paramBoolean))))
    {
      localObject = this.e;
      if (localObject != null) {
        ((k)localObject).a(new d.3(this));
      } else {
        A();
      }
    }
    this.l = paramBoolean;
    return 0;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    for (;;)
    {
      synchronized (this.o)
      {
        if ((this.u != 2) && ((this.b == null) || (!this.b.a())))
        {
          int i1 = a(paramInt2, paramInt3, null);
          if (i1 != 0) {
            return i1;
          }
          com.tencent.liteav.videoencoder.b localb = this.j;
          if (localb != null)
          {
            if (paramLong == 0L)
            {
              paramLong = TXCTimeUtil.generatePtsMS();
              localb.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramLong);
            }
          }
          else {
            return 0;
          }
        }
        else
        {
          return 0;
        }
      }
    }
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, Object paramObject, long paramLong, int paramInt4)
  {
    com.tencent.liteav.basic.structs.b localb = new com.tencent.liteav.basic.structs.b();
    localb.m = paramArrayOfByte;
    localb.b = paramInt1;
    localb.d = true;
    a(localb, paramInt2, paramInt3, paramObject, paramLong);
    return 0;
  }
  
  public void a()
  {
    TXCLog.i("TXCCaptureAndEnc", "onPushEnd");
    Object localObject = this.P;
    if (localObject == null) {
      return;
    }
    localObject = (d.a)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    ((d.a)localObject).onBackgroudPushStop();
  }
  
  public void a(float paramFloat)
  {
    k localk = this.e;
    if (localk == null) {
      return;
    }
    localk.a(paramFloat);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if ((this.e != null) && (this.q.L)) {
      this.e.a(paramFloat1, paramFloat2);
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("vrotation setVideoEncRotation ");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.i("TXCCaptureAndEnc", ((StringBuilder)localObject).toString());
    this.ad = paramInt;
    localObject = this.e;
    if (localObject != null)
    {
      ((k)localObject).a(new d.1(this, paramInt));
      return;
    }
    localObject = this.j;
    if (localObject != null) {
      ((com.tencent.liteav.videoencoder.b)localObject).a(paramInt);
    }
    localObject = this.n;
    if (localObject != null) {
      ((com.tencent.liteav.videoencoder.b)localObject).a(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    synchronized (this.A)
    {
      if (this.E != null)
      {
        this.E.a(new d.4(this, paramInt1, paramInt2));
      }
      else
      {
        this.C = paramInt1;
        this.D = paramInt2;
      }
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    k localk = this.e;
    if (localk == null) {
      return;
    }
    localk.a(new d.21(this, paramInt2, paramInt3, paramInt1));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean)
  {
    if (paramInt1 == 2)
    {
      if ((this.i.width != 0) && (this.i.height != 0) && ((paramInt2 != this.i.width) || (paramInt3 != this.i.height) || (paramInt4 > this.i.fps) || (paramBoolean != this.J)))
      {
        localObject1 = this.e;
        if (localObject1 != null)
        {
          ((k)localObject1).a(new d.12(this, paramInt2, paramInt3, paramInt4, paramBoolean, paramInt5));
        }
        else if (this.J != paramBoolean)
        {
          localObject1 = this.o;
          if (!paramBoolean) {}
          try
          {
            if (this.J) {
              this.J = false;
            }
          }
          finally {}
        }
      }
      else
      {
        localObject1 = this.j;
        if (localObject1 != null)
        {
          ((com.tencent.liteav.videoencoder.b)localObject1).b(paramInt5, paramInt6);
          ((com.tencent.liteav.videoencoder.b)localObject1).b(paramInt4);
        }
      }
      d(paramInt7);
      return;
    }
    Object localObject1 = this.m;
    if ((localObject1 != null) && ((paramInt2 != ((TXSVideoEncoderParam)localObject1).width) || (paramInt3 != this.m.height)))
    {
      localObject1 = this.e;
      if (localObject1 != null) {
        ((k)localObject1).a(new d.19(this, paramInt2, paramInt3, paramInt4));
      }
    }
    localObject1 = this.n;
    if (localObject1 != null)
    {
      ((com.tencent.liteav.videoencoder.b)localObject1).b(paramInt5, paramInt6);
      ((com.tencent.liteav.videoencoder.b)localObject1).b(paramInt4);
    }
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramInt == 2)
    {
      this.L = paramLong1;
      this.K = paramLong2;
    }
  }
  
  public void a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    g localg = this.q;
    localg.F = paramBitmap;
    localg.I = paramFloat1;
    localg.J = paramFloat2;
    localg.K = paramFloat3;
    C();
  }
  
  public void a(Bitmap paramBitmap, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    paramBitmap = new d.11(this, paramBitmap, paramByteBuffer, paramInt1, paramInt2);
    paramByteBuffer = this.e;
    if (paramByteBuffer != null)
    {
      paramByteBuffer.a(paramBitmap);
      return;
    }
    paramBitmap.run();
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    paramSurfaceTexture = this.f;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.b();
    }
    paramSurfaceTexture = this.aa;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture = (m)paramSurfaceTexture.get();
    } else {
      paramSurfaceTexture = null;
    }
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.onGLContextCreated();
    }
  }
  
  public void a(MediaFormat paramMediaFormat)
  {
    Object localObject = this.P;
    if (localObject == null) {
      return;
    }
    localObject = (d.a)((WeakReference)localObject).get();
    if (localObject != null) {
      ((d.a)localObject).onEncVideoFormat(paramMediaFormat);
    }
  }
  
  public void a(Surface paramSurface)
  {
    if (this.z != null)
    {
      TXCLog.w("TXCCaptureAndEnc", "camera preview view is not null, can't set surface");
      return;
    }
    synchronized (this.A)
    {
      StringBuilder localStringBuilder;
      if (this.B != paramSurface)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("surface-render: set surface ");
        localStringBuilder.append(paramSurface);
        TXCLog.i("TXCCaptureAndEnc", localStringBuilder.toString());
        this.B = paramSurface;
        if (this.E != null)
        {
          this.E.a();
          this.E = null;
        }
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("surface-render: set surface the same");
        localStringBuilder.append(paramSurface);
        TXCLog.i("TXCCaptureAndEnc", localStringBuilder.toString());
      }
      return;
    }
  }
  
  public void a(com.tencent.liteav.basic.c.b paramb)
  {
    this.ac = new WeakReference(paramb);
  }
  
  public void a(p paramp)
  {
    Object localObject = this.z;
    if (localObject != null)
    {
      localObject = ((TXCloudVideoView)localObject).getGLSurfaceView();
      if (localObject != null)
      {
        ((TXCGLSurfaceView)localObject).a(new d.5(this, paramp));
        return;
      }
      if (paramp != null) {
        paramp.onTakePhotoComplete(null);
      }
    }
    else
    {
      localObject = this.E;
      if (localObject != null)
      {
        ((com.tencent.liteav.basic.opengl.g)localObject).a(new d.6(this, paramp));
        return;
      }
      if (paramp != null) {
        paramp.onTakePhotoComplete(null);
      }
    }
  }
  
  public void a(TXSNALPacket paramTXSNALPacket, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(com.tencent.liteav.basic.structs.b paramb, long paramLong)
  {
    a(paramb.a, paramb.e, paramb.f, paramLong);
  }
  
  public void a(com.tencent.liteav.basic.structs.c paramc)
  {
    this.r = paramc;
    com.tencent.liteav.videoencoder.b localb = this.j;
    if (localb != null) {
      localb.a(paramc);
    }
    localb = this.n;
    if (localb != null) {
      localb.a(paramc);
    }
  }
  
  public void a(d.a parama)
  {
    this.P = new WeakReference(parama);
  }
  
  public void a(g paramg)
  {
    boolean bool3 = false;
    int i1;
    if ((paramg != null) && ((this.q.F != paramg.F) || (this.q.G != paramg.G) || (this.q.H != paramg.H) || (this.q.K != paramg.K) || (this.q.I != paramg.I) || (this.q.J != paramg.J))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    boolean bool1;
    if ((paramg != null) && ((this.q.a != paramg.a) || (this.q.b != paramg.b))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if ((paramg != null) && (this.q.a > 0) && (this.q.b > 0) && (paramg.a > 0) && (paramg.b > 0) && (Math.abs(this.q.a / this.q.b - paramg.a / paramg.b) > 0.1D)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (paramg != null) {
      try
      {
        this.q = ((g)paramg.clone());
      }
      catch (CloneNotSupportedException paramg)
      {
        this.q = new g();
        paramg.printStackTrace();
      }
    } else {
      this.q = new g();
    }
    TXCLog.i("TXCCaptureAndEnc", String.format("vsize setConfig w*h:%d*%d orientation:%d", new Object[] { Integer.valueOf(this.q.a), Integer.valueOf(this.q.b), Integer.valueOf(this.q.m) }));
    paramg = this.e;
    if (paramg != null) {
      paramg.e(this.q.m);
    }
    D();
    if (this.q.U) {
      bool1 = bool3;
    } else if (!this.q.V) {
      bool1 = bool2;
    }
    m(bool1);
    if ((k()) && (i1 != 0)) {
      C();
    }
  }
  
  public void a(m paramm)
  {
    this.aa = new WeakReference(paramm);
  }
  
  public void a(o paramo, int paramInt)
  {
    this.M = paramInt;
    if (paramo != null)
    {
      this.N = new WeakReference(paramo);
      return;
    }
    this.N = null;
  }
  
  public void a(a.a parama)
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      parama = new Bundle();
      parama.putString("EVT_MSG", "Screen recording failed, unsupported Android system version. system version should above 5.0");
      onNotifyEvent(-1309, parama);
      parama = new StringBuilder();
      parama.append("Screen capture need running on Android Lollipop or higher version, current:");
      parama.append(Build.VERSION.SDK_INT);
      TXLog.e("TXCCaptureAndEnc", parama.toString());
      return;
    }
    this.s = 1;
    if (this.e == null)
    {
      this.e = new i(this.p, this.q, parama);
      TXCLog.i("TXCCaptureAndEnc", "create TXCScreenCaptureSource");
    }
    this.Y.a(false);
    j(this.G);
    this.e.a(this);
    this.e.a(this);
    this.e.a();
    this.e.a(getID());
    TXCDRApi.txReportDAU(this.p, com.tencent.liteav.basic.datareport.a.aH);
  }
  
  public void a(TXCloudVideoView paramTXCloudVideoView)
  {
    if (this.q.N)
    {
      TXCLog.e("TXCCaptureAndEnc", "enable pure audio push , so can not start preview!");
      return;
    }
    Object localObject = this.a;
    if (localObject != null) {
      ((b)localObject).b();
    }
    this.y = false;
    boolean bool = this.q.X;
    if (paramTXCloudVideoView != null)
    {
      TXCGLSurfaceView[] arrayOfTXCGLSurfaceView = new TXCGLSurfaceView[1];
      a(new d.24(this, arrayOfTXCGLSurfaceView, paramTXCloudVideoView));
      localObject = arrayOfTXCGLSurfaceView[0];
      arrayOfTXCGLSurfaceView[0].setNotifyListener(this);
      TXCLog.i("TXCCaptureAndEnc", "start camera preview with GLSurfaceView");
    }
    else
    {
      localObject = new com.tencent.liteav.basic.opengl.h();
      TXCLog.i("TXCCaptureAndEnc", "start camera preview with SurfaceTexture");
      bool = false;
    }
    this.s = 0;
    this.e = new c(this.p, this.q, (n)localObject, bool);
    y();
    j(this.G);
    this.e.a(getID());
    this.e.a(this);
    this.e.a(this);
    this.e.a();
    this.e.b(this.w);
    this.e.c(this.x);
    this.e.d(this.ae);
    this.z = paramTXCloudVideoView;
    this.d.post(new d.2(this, paramTXCloudVideoView));
    this.y = false;
    TXCKeyPointReportProxy.a(30003);
  }
  
  public void a(boolean paramBoolean)
  {
    this.O = paramBoolean;
  }
  
  public TXBeautyManager b()
  {
    return this.Y;
  }
  
  public void b(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setLocalViewMirror ");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.i("TXCCaptureAndEnc", ((StringBuilder)localObject).toString());
    this.ae = paramInt;
    localObject = this.e;
    if (localObject != null) {
      ((k)localObject).d(this.ae);
    }
    localObject = this.E;
    if (localObject != null) {
      ((com.tencent.liteav.basic.opengl.g)localObject).b(this.ae);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    k localk = this.e;
    if (localk == null) {
      return;
    }
    localk.a(paramInt1, paramInt2);
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.Y.setBeautyLevel(paramInt1);
    this.Y.setWhitenessLevel(paramInt2);
    this.Y.setRuddyLevel(paramInt3);
  }
  
  public void b(com.tencent.liteav.basic.structs.b paramb)
  {
    this.c.a();
    if (!this.V)
    {
      this.V = true;
      TXCKeyPointReportProxy.b(30003, 0);
    }
    if (this.u == 2) {
      return;
    }
    k localk = this.e;
    if ((this.f != null) && (!this.q.N) && (localk != null))
    {
      if ((this.i.height != paramb.h) || (this.i.width != paramb.g)) {
        d(paramb.g, paramb.h);
      }
      this.f.a(localk.f());
      this.f.a(this.q.m);
      this.f.a(paramb, paramb.b, 0, 0L);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.Z = paramBoolean;
    TXCLog.i("TXCCaptureAndEnc", "Is encoder need texture after glFinish: %b", new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong) {}
  
  public g c()
  {
    return this.q;
  }
  
  public void c(int paramInt)
  {
    k localk = this.e;
    if (localk == null) {
      return;
    }
    localk.a(new d.20(this, paramInt));
  }
  
  public void c(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enableBlackStream ");
    localStringBuilder.append(paramBoolean);
    TXCLog.i("TXCCaptureAndEnc", localStringBuilder.toString());
    this.v = paramBoolean;
    if (this.v)
    {
      if (this.e == null) {
        x();
      }
    }
    else {
      y();
    }
  }
  
  public int d()
  {
    return this.i.width;
  }
  
  public void d(int paramInt)
  {
    k localk = this.e;
    if (localk == null) {
      return;
    }
    localk.a(new d.22(this, paramInt));
  }
  
  public void d(boolean paramBoolean)
  {
    l(paramBoolean);
  }
  
  public int e()
  {
    return this.i.height;
  }
  
  public void e(int paramInt)
  {
    if (this.q.i == paramInt) {
      return;
    }
    this.q.i = paramInt;
    k localk = this.e;
    if ((localk != null) && (localk.g() < paramInt))
    {
      int i1 = this.s;
      if (i1 != 0)
      {
        if (i1 != 1) {
          return;
        }
        this.e.f(paramInt);
        return;
      }
      m(true);
      u();
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.X = paramBoolean;
  }
  
  public int f()
  {
    if (k())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ignore startPush when pushing, status:");
      localStringBuilder.append(this.u);
      TXCLog.w("TXCCaptureAndEnc", localStringBuilder.toString());
      return -2;
    }
    TXCDRApi.initCrashReport(this.p);
    this.u = 1;
    TXCLog.i("TXCCaptureAndEnc", "startWithoutAudio");
    D();
    return 0;
  }
  
  public void f(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setRenderMode ");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.i("TXCCaptureAndEnc", ((StringBuilder)localObject).toString());
    this.x = paramInt;
    localObject = this.e;
    if (localObject != null) {
      ((k)localObject).c(paramInt);
    }
    localObject = this.E;
    if (localObject != null) {
      ((com.tencent.liteav.basic.opengl.g)localObject).a(this.x);
    }
  }
  
  public boolean f(boolean paramBoolean)
  {
    k localk = this.e;
    if (localk == null) {
      return false;
    }
    return localk.d(paramBoolean);
  }
  
  public void g()
  {
    if (!k())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ignore stopPush when not pushing, status:");
      ((StringBuilder)localObject).append(this.u);
      TXCLog.w("TXCCaptureAndEnc", ((StringBuilder)localObject).toString());
      return;
    }
    TXCLog.i("TXCCaptureAndEnc", "stop");
    this.u = 0;
    u();
    this.q.Q = false;
    Object localObject = this.a;
    if (localObject != null) {
      ((b)localObject).b();
    }
    c(false);
    this.F = null;
  }
  
  public void g(int paramInt)
  {
    if (this.w != paramInt)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("vrotation setRenderRotation ");
      ((StringBuilder)localObject).append(paramInt);
      TXCLog.i("TXCCaptureAndEnc", ((StringBuilder)localObject).toString());
    }
    this.w = paramInt;
    Object localObject = this.e;
    if (localObject == null) {
      return;
    }
    ((k)localObject).b(paramInt);
  }
  
  public boolean g(boolean paramBoolean)
  {
    this.q.T = paramBoolean;
    k localk = this.e;
    if (localk == null) {
      return false;
    }
    localk.c(paramBoolean);
    return true;
  }
  
  public void h()
  {
    Object localObject;
    if (this.u != 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ignore pause push when is not pushing, status:");
      ((StringBuilder)localObject).append(this.u);
      TXCLog.w("TXCCaptureAndEnc", ((StringBuilder)localObject).toString());
      return;
    }
    this.u = 2;
    TXCLog.i("TXCCaptureAndEnc", "pausePusher");
    if ((this.q.E & 0x1) == 1)
    {
      u();
      if ((this.a != null) && (!this.q.N))
      {
        int i1 = this.i.width;
        int i3 = this.i.height;
        int i2;
        if (i1 != 0)
        {
          i2 = i3;
          if (i3 == 0) {}
        }
        for (;;)
        {
          break;
          i1 = this.q.a;
          i2 = this.q.b;
          if ((this.q.m == 0) || (this.q.m == 2))
          {
            i1 = this.q.b;
            i2 = this.q.a;
          }
        }
        this.a.a(this.q.D, this.q.C, this.q.B, i1, i2);
      }
      localObject = this.e;
      if (localObject != null) {
        ((k)localObject).c();
      }
    }
  }
  
  public void h(int paramInt)
  {
    this.Y.setBeautyStyle(paramInt);
  }
  
  public void h(boolean paramBoolean)
  {
    if (this.J)
    {
      TXCLog.i("TXCCaptureAndEnc", "enableRPS when mEnableHEVCEncode = true");
      return;
    }
    if (this.H == paramBoolean) {
      return;
    }
    this.H = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("trtc_api onVideoConfigChanged enableRps ");
    localStringBuilder.append(this.H);
    TXCLog.i("TXCCaptureAndEnc", localStringBuilder.toString());
    if (this.H) {
      this.q.k = 0;
    }
    u();
  }
  
  public void i()
  {
    Object localObject;
    if (this.u != 2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ignore resume push when is not pause, status:");
      ((StringBuilder)localObject).append(this.u);
      TXCLog.w("TXCCaptureAndEnc", ((StringBuilder)localObject).toString());
      return;
    }
    this.u = 1;
    TXCLog.i("TXCCaptureAndEnc", "resumePusher");
    if ((this.q.E & 0x1) == 1)
    {
      if ((this.a != null) && (!this.q.N)) {
        this.a.b();
      }
      u();
      localObject = this.e;
      if (localObject != null) {
        ((k)localObject).b();
      }
      C();
    }
  }
  
  public void i(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean i(int paramInt)
  {
    k localk = this.e;
    if (localk == null) {
      return false;
    }
    return localk.a(paramInt);
  }
  
  public void j(int paramInt)
  {
    this.G = paramInt;
    k localk = this.e;
    if (localk != null) {
      localk.g(this.G);
    }
  }
  
  public void j(boolean paramBoolean)
  {
    this.I = paramBoolean;
  }
  
  public boolean j()
  {
    return this.v;
  }
  
  public void k(int paramInt)
  {
    com.tencent.liteav.videoencoder.b localb;
    if (paramInt == 2) {
      localb = this.j;
    } else if (paramInt == 3) {
      localb = this.n;
    } else {
      localb = null;
    }
    if (localb != null) {
      localb.b();
    }
  }
  
  public void k(boolean paramBoolean)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("mEnableHEVCEncode = ");
    ((StringBuilder)???).append(paramBoolean);
    TXCLog.i("TXCCaptureAndEnc", ((StringBuilder)???).toString());
    ??? = this.e;
    if (??? != null)
    {
      ((k)???).a(new d.9(this, paramBoolean));
      return;
    }
    synchronized (this.o)
    {
      this.J = paramBoolean;
      return;
    }
  }
  
  public boolean k()
  {
    return this.u != 0;
  }
  
  public void l()
  {
    k localk = this.e;
    if (localk == null) {
      return;
    }
    localk.a(new d.23(this));
  }
  
  public void l(int paramInt)
  {
    if (!this.J) {
      if (this.i.width * this.i.height < 518400) {
        this.q.k = 0;
      } else if ((this.i.width * this.i.height < 921600) && (this.g)) {
        this.q.k = 0;
      }
    }
    if (paramInt == 3)
    {
      w();
      return;
    }
    if (this.J) {
      com.tencent.liteav.basic.util.h.a(this.ac, -2310, getID());
    } else {
      this.g = true;
    }
    k(false);
    v();
  }
  
  public void m()
  {
    if (this.e == null) {
      return;
    }
    this.Y.a(true);
    l(true);
  }
  
  public void m(int paramInt) {}
  
  public void n(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 1) {
      i1 = 1;
    }
    paramInt = i1;
    if (i1 > 2) {
      paramInt = 2;
    }
    d.18 local18 = new d.18(this, paramInt);
    k localk = this.e;
    if (localk == null)
    {
      local18.run();
      return;
    }
    localk.a(local18);
  }
  
  public boolean n()
  {
    k localk = this.e;
    if (localk != null) {
      return localk.h();
    }
    return false;
  }
  
  public boolean o()
  {
    k localk = this.e;
    if (localk != null) {
      return localk.i();
    }
    return false;
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.putString("EVT_USERID", getID());
    }
    if (paramInt == -2311) {
      k(false);
    }
    com.tencent.liteav.basic.util.h.a(this.ac, paramInt, paramBundle);
    long l1;
    if (paramInt == -1314) {
      TXCEventRecorderProxy.a(getID(), 2002, 5L, -1L, "", this.G);
    } else if (paramInt == 1003)
    {
      if (this.e != null)
      {
        paramBundle = getID();
        if (this.e.l()) {
          l1 = 0L;
        } else {
          l1 = 1L;
        }
        TXCEventRecorderProxy.a(paramBundle, 4001, l1, -1L, "", this.G);
      }
    }
    else if (paramInt == -1308) {
      m();
    }
    if ((paramInt == -1301) || (paramInt == -1314) || (paramInt == -1315) || (paramInt == -1316))
    {
      TXCKeyPointReportProxy.b(30003, paramInt);
      if (this.e != null)
      {
        paramBundle = getID();
        if (this.e.l()) {
          l1 = 0L;
        } else {
          l1 = 1L;
        }
        TXCEventRecorderProxy.a(paramBundle, 4002, l1, paramInt, "", this.G);
      }
    }
  }
  
  public boolean p()
  {
    k localk = this.e;
    if (localk != null) {
      return localk.j();
    }
    return false;
  }
  
  public boolean q()
  {
    k localk = this.e;
    if (localk != null) {
      return localk.k();
    }
    return false;
  }
  
  public int r()
  {
    k localk = this.e;
    if (localk == null) {
      return 0;
    }
    return localk.e();
  }
  
  public void s()
  {
    try
    {
      if (this.f != null) {
        this.f.b();
      }
      if (this.Q != null)
      {
        this.Q.d();
        this.Q = null;
      }
      if (this.S != null)
      {
        this.S.d();
        this.S = null;
      }
      if (this.R != null)
      {
        this.R.d();
        this.R = null;
      }
      B();
      A();
      z();
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCCaptureAndEnc", "stop preprocessor and encoder failed.", localException);
    }
  }
  
  public void setID(String paramString)
  {
    super.setID(paramString);
    Object localObject = this.j;
    if (localObject != null) {
      ((com.tencent.liteav.videoencoder.b)localObject).setID(paramString);
    }
    localObject = this.n;
    if (localObject != null) {
      ((com.tencent.liteav.videoencoder.b)localObject).setID(paramString);
    }
    localObject = this.f;
    if (localObject != null) {
      ((com.tencent.liteav.beauty.d)localObject).setID(paramString);
    }
    localObject = this.e;
    if (localObject != null) {
      ((k)localObject).a(getID());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setID:");
    ((StringBuilder)localObject).append(paramString);
    TXCLog.w("TXCCaptureAndEnc", ((StringBuilder)localObject).toString());
  }
  
  public void t()
  {
    TXCLog.i("TXCCaptureAndEnc", "onCaptureDestroy->enter ");
    Object localObject = this.f;
    if (localObject != null) {
      ((com.tencent.liteav.beauty.d)localObject).b();
    }
    localObject = this.Q;
    if (localObject != null)
    {
      ((j)localObject).d();
      this.Q = null;
    }
    localObject = this.S;
    if (localObject != null)
    {
      ((j)localObject).d();
      this.S = null;
    }
    localObject = this.R;
    if (localObject != null)
    {
      ((j)localObject).d();
      this.R = null;
    }
    localObject = this.T;
    if (localObject != null)
    {
      ((com.tencent.liteav.beauty.b.k)localObject).d();
      this.T = null;
    }
    B();
    A();
    z();
  }
  
  public void u()
  {
    d.13 local13 = new d.13(this);
    ??? = this.e;
    if (??? != null)
    {
      ((k)???).a(local13);
      return;
    }
    synchronized (this.o)
    {
      local13.run();
      return;
    }
  }
  
  public void v()
  {
    if (this.j == null) {
      return;
    }
    k localk = this.e;
    if (localk != null)
    {
      localk.a(new d.14(this));
      return;
    }
    B();
  }
  
  public void w()
  {
    if (this.n == null) {
      return;
    }
    k localk = this.e;
    if (localk != null)
    {
      localk.a(new d.15(this));
      return;
    }
    A();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.d
 * JD-Core Version:    0.7.0.1
 */