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
import com.tencent.liteav.basic.c.h;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.beauty.d.d;
import com.tencent.liteav.renderer.TXCGLSurfaceView;
import com.tencent.liteav.screencapture.a.a;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import com.tencent.rtmp.TXLog;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public class d
  extends com.tencent.liteav.basic.module.a
  implements b.b, com.tencent.liteav.basic.b.b, com.tencent.liteav.beauty.f, l, com.tencent.liteav.videoencoder.e
{
  private int A = 0;
  private int B = 0;
  private com.tencent.liteav.basic.c.e C = null;
  private com.tencent.liteav.basic.structs.b D;
  private int E = 0;
  private boolean F = false;
  private boolean G = false;
  private volatile boolean H = false;
  private long I = 0L;
  private long J = 0L;
  private int K = 2;
  private WeakReference<o> L;
  private boolean M = false;
  private WeakReference<d.a> N = null;
  private h O = null;
  private h P;
  private h Q;
  private com.tencent.liteav.beauty.b.k R;
  private byte[] S;
  private boolean T = false;
  private boolean U = false;
  private boolean V = false;
  private final com.tencent.liteav.beauty.b W;
  private WeakReference<com.tencent.liteav.basic.b.b> X;
  private WeakReference<m> Y;
  private int Z = 0;
  b a;
  private int aa = 0;
  b b;
  private final com.tencent.liteav.basic.util.e c = new com.tencent.liteav.basic.util.e(Looper.getMainLooper());
  private k d = null;
  private com.tencent.liteav.beauty.d e = null;
  private boolean f = false;
  private boolean g = false;
  private TXSVideoEncoderParam h = null;
  private com.tencent.liteav.videoencoder.b i = null;
  private int j = 15;
  private boolean k = false;
  private TXSVideoEncoderParam l = null;
  private com.tencent.liteav.videoencoder.b m = null;
  private final Object n = new Object();
  private Context o = null;
  private g p = null;
  private int q = 0;
  private int r = 0;
  private int s = 0;
  private boolean t = false;
  private int u = 0;
  private int v = 0;
  private boolean w = false;
  private TXCloudVideoView x = null;
  private final Object y = new Object();
  private Surface z = null;
  
  public d(Context paramContext)
  {
    this.o = paramContext.getApplicationContext();
    this.p = new g();
    this.e = new com.tencent.liteav.beauty.d(this.o, true);
    this.e.a(this);
    this.e.a(this);
    if (this.p.U) {
      this.e.a(d.d.a);
    } else if (this.p.T) {
      this.e.a(d.d.b);
    } else {
      this.e.a(d.d.c);
    }
    this.h = new TXSVideoEncoderParam();
    this.h.encoderMode = 1;
    this.i = null;
    this.l = new TXSVideoEncoderParam();
    this.l.encoderMode = 1;
    this.a = new b(this);
    this.W = new com.tencent.liteav.beauty.b(new com.tencent.liteav.basic.license.g(this.o));
    this.W.setPreprocessor(this.e);
    com.tencent.liteav.basic.d.c.a().a(this.o);
  }
  
  private void A()
  {
    k localk = this.d;
    if (localk != null) {
      localk.a(new d.17(this));
    }
  }
  
  private void B()
  {
    if (this.e != null)
    {
      if (this.p.U)
      {
        this.e.a(d.d.a);
        return;
      }
      if (this.p.T)
      {
        this.e.a(d.d.b);
        return;
      }
      this.e.a(d.d.c);
    }
  }
  
  private int a(int paramInt1, int paramInt2, Object paramObject)
  {
    paramInt1 = this.p.a;
    paramInt2 = this.p.b;
    if ((this.p.l == 0) || (this.p.l == 2))
    {
      paramInt1 = this.p.b;
      paramInt2 = this.p.a;
    }
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      if (this.p.M)
      {
        z();
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
    b(paramInt2, paramInt3, this.e.a());
    com.tencent.liteav.videoencoder.b localb = this.i;
    if (localb != null) {
      localb.a(paramInt1, paramInt2, paramInt3, l1);
    }
    localb = this.m;
    if (localb != null) {
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
    z();
    localObject = new com.tencent.liteav.videoencoder.b(paramInt3);
    TXCStatus.a(getID(), 4005, this.E, Integer.valueOf(paramInt3));
    if (paramInt3 == 1) {
      TXCEventRecorderProxy.a(getID(), 4004, 1L, -1L, "", this.E);
    } else {
      TXCEventRecorderProxy.a(getID(), 4004, 0L, -1L, "", this.E);
    }
    this.U = false;
    TXSVideoEncoderParam localTXSVideoEncoderParam = this.h;
    localTXSVideoEncoderParam.encodeType = paramInt3;
    localTXSVideoEncoderParam.width = paramInt1;
    localTXSVideoEncoderParam.height = paramInt2;
    localTXSVideoEncoderParam.fps = paramInt4;
    localTXSVideoEncoderParam.gop = this.p.i;
    this.h.encoderProfile = this.p.n;
    localTXSVideoEncoderParam = this.h;
    if (paramObject == null) {
      paramObject = ((com.tencent.liteav.videoencoder.b)localObject).a(paramInt1, paramInt2);
    }
    localTXSVideoEncoderParam.glContext = paramObject;
    paramObject = this.h;
    paramObject.realTime = paramBoolean;
    paramObject.streamType = this.E;
    paramObject.annexb = this.G;
    paramObject.bMultiRef = this.F;
    paramObject.baseFrameIndex = (this.I + 20L);
    paramObject.baseGopIndex = ((this.J + 1L) % 255L + 1L);
    paramObject.bLimitFps = this.g;
    paramObject.record = this.V;
    paramObject.encFmt = this.p.Y;
    this.h.isHEVCEncoderEnabled = this.H;
    this.h.bitrate = this.p.c;
    ((com.tencent.liteav.videoencoder.b)localObject).a(this);
    ((com.tencent.liteav.videoencoder.b)localObject).a(this);
    ((com.tencent.liteav.videoencoder.b)localObject).a(this.h);
    ((com.tencent.liteav.videoencoder.b)localObject).c(this.p.c);
    ((com.tencent.liteav.videoencoder.b)localObject).d(this.j);
    ((com.tencent.liteav.videoencoder.b)localObject).setID(getID());
    ((com.tencent.liteav.videoencoder.b)localObject).a(this.Z);
    this.i = ((com.tencent.liteav.videoencoder.b)localObject);
    TXCStatus.a(getID(), 4003, this.E, Integer.valueOf(this.h.width << 16 | this.h.height));
    TXCStatus.a(getID(), 13003, this.E, Integer.valueOf(this.h.gop * 1000));
    TXCEventRecorderProxy.a(getID(), 4003, this.h.width, this.h.height, "", this.E);
    TXCKeyPointReportProxy.a(40036, this.h.encodeType, this.E);
    TXCKeyPointReportProxy.a(40037, this.h.width << 16 | this.h.height, this.E);
  }
  
  private void a(int paramInt, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("EVT_USERID", getID());
    localBundle.putInt("EVT_ID", paramInt);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    if (paramString != null) {
      localBundle.putCharSequence("EVT_MSG", paramString);
    }
    com.tencent.liteav.basic.util.f.a(this.X, paramInt, localBundle);
    long l1;
    if (paramInt == -1317)
    {
      TXCEventRecorderProxy.a(getID(), 2002, 4L, -1L, "", this.E);
    }
    else if (paramInt == -1314)
    {
      TXCEventRecorderProxy.a(getID(), 2002, 5L, -1L, "", this.E);
    }
    else if ((paramInt == 1003) && (this.d != null))
    {
      paramString = getID();
      if (this.d.l()) {
        l1 = 0L;
      } else {
        l1 = 1L;
      }
      TXCEventRecorderProxy.a(paramString, 4001, l1, -1L, "", this.E);
    }
    if ((paramInt != -1302) && (paramInt != -1317) && (paramInt != -1318) && (paramInt != -1319))
    {
      if ((paramInt == -1301) || (paramInt == -1314) || (paramInt == -1315) || (paramInt == -1316))
      {
        TXCKeyPointReportProxy.b(30003, paramInt);
        if (this.d != null)
        {
          paramString = getID();
          if (this.d.l()) {
            l1 = 0L;
          } else {
            l1 = 1L;
          }
          TXCEventRecorderProxy.a(paramString, 4002, l1, paramInt, "", this.E);
        }
      }
    }
    else {
      TXCKeyPointReportProxy.b(30002, paramInt);
    }
  }
  
  private void a(com.tencent.liteav.basic.structs.b paramb, int paramInt1, int paramInt2, Object paramObject, long paramLong)
  {
    synchronized (this.n)
    {
      if (this.s == 2) {
        return;
      }
      paramb.e = paramInt1;
      paramb.f = paramInt2;
      paramb.i = this.p.S;
      if (this.p.l == 0)
      {
        paramb.g = this.p.b;
        paramb.h = this.p.a;
      }
      else
      {
        paramb.g = this.p.a;
        paramb.h = this.p.b;
      }
      paramb.l = com.tencent.liteav.basic.util.f.a(paramb.e, paramb.f, paramb.g, paramb.h);
      try
      {
        this.e.a(this.p.l);
        this.e.a(paramObject);
        this.e.a(paramb, paramb.b, 0, paramLong);
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
  }
  
  private void a(com.tencent.liteav.basic.structs.b paramb, boolean paramBoolean)
  {
    e(paramb.e, paramb.f);
    this.D = paramb;
    if (this.x != null)
    {
      ??? = this.d;
      if (??? != null) {
        ((k)???).a(paramb);
      }
    }
    else
    {
      synchronized (this.y)
      {
        if ((this.z != null) && (this.C == null) && (this.d != null) && (this.d.f() != null))
        {
          this.C = new com.tencent.liteav.basic.c.e();
          this.C.a(this.d.f(), this.z);
          this.C.a(this.v);
          this.C.b(this.aa);
        }
        if ((this.C != null) && (this.d != null)) {
          this.C.a(paramb.a, paramb.i, this.u, this.A, this.B, paramb.e, paramb.f, paramBoolean, this.d.l());
        }
        return;
      }
    }
  }
  
  private void a(Object paramObject, int paramInt, boolean paramBoolean)
  {
    y();
    com.tencent.liteav.videoencoder.b localb = new com.tencent.liteav.videoencoder.b(paramInt);
    TXCStatus.a(getID(), 4005, 3, Integer.valueOf(paramInt));
    if (paramInt == 1) {
      TXCEventRecorderProxy.a(getID(), 4004, 1L, -1L, "", 3);
    } else {
      TXCEventRecorderProxy.a(getID(), 4004, 0L, -1L, "", 3);
    }
    TXSVideoEncoderParam localTXSVideoEncoderParam = this.l;
    if (paramObject == null) {
      paramObject = localb.a(localTXSVideoEncoderParam.width, this.l.height);
    }
    localTXSVideoEncoderParam.glContext = paramObject;
    paramObject = this.l;
    paramObject.encodeType = paramInt;
    paramObject.realTime = paramBoolean;
    paramObject.isHEVCEncoderEnabled = false;
    TXCLog.i("TXCCaptureAndEnc", "start small video encoder");
    localb.a(this);
    localb.a(this);
    localb.a(this.l);
    localb.c(this.l.bitrate);
    localb.setID(getID());
    localb.a(this.Z);
    this.m = localb;
    TXCStatus.a(getID(), 4003, 3, Integer.valueOf(this.l.width << 16 | this.l.height));
    TXCStatus.a(getID(), 13003, 3, Integer.valueOf(this.l.gop * 1000));
  }
  
  private void a(Runnable paramRunnable)
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.c.a(paramRunnable);
      return;
    }
    paramRunnable.run();
  }
  
  private void b(int paramInt1, int paramInt2, Object paramObject)
  {
    int i3 = this.p.j;
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
    if (this.q == 1)
    {
      i2 = i1;
      if (this.r == 0) {
        i2 = 1;
      }
    }
    i1 = this.p.i;
    if ((this.i == null) || (this.U) || (this.h.width != paramInt1) || (this.h.height != paramInt2) || (this.h.encodeType != i2) || (this.h.gop != i1) || (this.H != this.h.isHEVCEncoderEnabled)) {
      a(paramInt1, paramInt2, i2, paramObject, this.p.h, this.p.P);
    }
    if (((this.m == null) || (this.l.encodeType != i2)) && (this.k)) {
      a(paramObject, i2, this.p.P);
    }
  }
  
  private int c(com.tencent.liteav.basic.structs.b paramb)
  {
    if (this.M) {
      return paramb.a;
    }
    int i2 = paramb.a;
    int i7;
    if (this.aa == 1) {
      i7 = 1;
    } else {
      i7 = 0;
    }
    int i1 = i2;
    h localh;
    if (i7 != paramb.i)
    {
      if (this.P == null)
      {
        localh = new h();
        localh.a();
        localh.a(true);
        localh.a(paramb.e, paramb.f);
        if (paramb.e > paramb.f) {
          localh.h();
        } else {
          localh.g();
        }
        this.P = localh;
      }
      localh = this.P;
      i1 = i2;
      if (localh != null)
      {
        localh.a(paramb.e, paramb.f);
        i1 = localh.b(paramb.a);
      }
    }
    i2 = i1;
    if (this.u != 0)
    {
      if (this.Q == null)
      {
        localh = new h();
        localh.a();
        localh.a(true);
        localh.a(paramb.e, paramb.f);
        this.Q = localh;
      }
      localh = this.Q;
      i2 = i1;
      if (localh != null)
      {
        GLES20.glViewport(0, 0, paramb.e, paramb.f);
        int i4 = paramb.e;
        int i5 = paramb.f;
        float[] arrayOfFloat = localh.a(i4, i5, null, com.tencent.liteav.basic.util.f.a(i4, i5, paramb.e, paramb.f), 0);
        int i6 = (720 - this.u) % 360;
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
        localh.a(i4, i5, i6, arrayOfFloat, i2 / i3, false, false);
        localh.b(i1);
        i2 = localh.l();
      }
    }
    return i2;
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    com.tencent.liteav.beauty.d locald;
    if (this.p.J != -1.0F)
    {
      locald = this.e;
      if (locald != null) {
        locald.a(this.p.E, this.p.H, this.p.I, this.p.J);
      }
    }
    else
    {
      locald = this.e;
      if ((locald != null) && (paramInt1 != 0) && (paramInt2 != 0))
      {
        Bitmap localBitmap = this.p.E;
        float f2 = this.p.F;
        float f1 = paramInt1;
        f2 /= f1;
        float f3 = this.p.G / paramInt2;
        if (this.p.E == null) {
          f1 = 0.0F;
        } else {
          f1 = this.p.E.getWidth() / f1;
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
    Object localObject2 = this.L;
    if (localObject2 == null) {
      return;
    }
    int i2 = c(paramb);
    int i1 = this.K;
    Object localObject1;
    if (i1 == 2)
    {
      localObject1 = (o)((WeakReference)localObject2).get();
      if (localObject1 != null)
      {
        localObject2 = new TXSVideoFrame();
        ((TXSVideoFrame)localObject2).width = paramb.e;
        ((TXSVideoFrame)localObject2).height = paramb.f;
        ((TXSVideoFrame)localObject2).textureId = i2;
        ((TXSVideoFrame)localObject2).eglContext = this.e.a();
        ((TXSVideoFrame)localObject2).pts = TXCTimeUtil.generatePtsMS();
        ((o)localObject1).onRenderVideoFrame(getID(), this.E, (TXSVideoFrame)localObject2);
        if (this.M) {
          paramb.a = ((TXSVideoFrame)localObject2).textureId;
        }
      }
    }
    else if ((i1 == 1) || (i1 == 4))
    {
      localObject1 = this.O;
      i1 = 3;
      if (localObject1 == null)
      {
        if (this.K == 1) {
          localObject1 = new com.tencent.liteav.beauty.b.o(1);
        } else {
          localObject1 = new com.tencent.liteav.beauty.b.o(3);
        }
        ((h)localObject1).a(true);
        if (((h)localObject1).a())
        {
          ((h)localObject1).a(paramb.e, paramb.f);
          ((h)localObject1).a(new d.18(this, (WeakReference)localObject2));
          this.O = ((h)localObject1);
        }
        else
        {
          TXCLog.i("TXCCaptureAndEnc", "init filter error ");
          this.O = null;
        }
      }
      localObject1 = this.O;
      if (localObject1 != null)
      {
        GLES20.glViewport(0, 0, paramb.e, paramb.f);
        ((h)localObject1).a(paramb.e, paramb.f);
        ((h)localObject1).b(i2);
      }
      if ((this.M) && (this.S != null))
      {
        i2 = this.K;
        if ((i2 == 1) || (i2 != 4)) {
          i1 = 1;
        }
        if (this.R == null)
        {
          localObject1 = new com.tencent.liteav.beauty.b.k(i1);
          ((com.tencent.liteav.beauty.b.k)localObject1).a(true);
          if (!((com.tencent.liteav.beauty.b.k)localObject1).a()) {
            TXCLog.w("TXCCaptureAndEnc", " init i420ToRGBA filter failed");
          }
          ((com.tencent.liteav.beauty.b.k)localObject1).a(paramb.e, paramb.f);
          this.R = ((com.tencent.liteav.beauty.b.k)localObject1);
        }
        localObject1 = this.R;
        if (localObject1 != null)
        {
          GLES20.glViewport(0, 0, paramb.e, paramb.f);
          ((com.tencent.liteav.beauty.b.k)localObject1).a(paramb.e, paramb.f);
          ((com.tencent.liteav.beauty.b.k)localObject1).a(this.S);
          paramb.a = ((com.tencent.liteav.beauty.b.k)localObject1).q();
        }
        this.S = null;
      }
    }
    if (this.M)
    {
      paramb = this.x;
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
    if (!this.w)
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putString("EVT_USERID", getID());
      ((Bundle)localObject).putInt("EVT_ID", 2003);
      ((Bundle)localObject).putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
      ((Bundle)localObject).putCharSequence("EVT_MSG", "Renders the first video frame");
      ((Bundle)localObject).putInt("EVT_PARAM1", paramInt1);
      ((Bundle)localObject).putInt("EVT_PARAM2", paramInt2);
      com.tencent.liteav.basic.util.f.a(this.X, 2003, (Bundle)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("trtc_render render first frame ");
      ((StringBuilder)localObject).append(getID());
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(this.E);
      TXCLog.i("TXCCaptureAndEnc", ((StringBuilder)localObject).toString());
      this.w = true;
    }
  }
  
  private void k(boolean paramBoolean)
  {
    ??? = this.d;
    if (??? == null) {
      return;
    }
    ((k)???).a(new d.7(this));
    t();
    this.d.a(paramBoolean);
    this.d = null;
    TXCLog.i("TXCCaptureAndEnc", "stopped CaptureSource");
    ??? = this.x;
    this.c.post(new d.8(this, (TXCloudVideoView)???, paramBoolean));
    this.x = null;
    synchronized (this.y)
    {
      this.z = null;
      if (this.C != null)
      {
        this.C.a();
        this.C = null;
      }
      if (this.a.a()) {
        this.a.b();
      }
      if (this.t) {
        w();
      }
      return;
    }
  }
  
  private void l(boolean paramBoolean)
  {
    k localk = this.d;
    if (localk != null) {
      localk.a(new d.16(this, paramBoolean));
    }
  }
  
  private void w()
  {
    TXCLog.i("TXCCaptureAndEnc", " startBlackStream");
    if (this.b == null) {
      this.b = new b(this);
    }
    this.b.a(10, -1, null, 64, 64);
  }
  
  private void x()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" stopBlackStream when enableBlackStream ");
    ((StringBuilder)localObject).append(this.t);
    TXCLog.i("TXCCaptureAndEnc", ((StringBuilder)localObject).toString());
    localObject = this.b;
    if (localObject != null) {
      ((b)localObject).b();
    }
  }
  
  private void y()
  {
    try
    {
      com.tencent.liteav.videoencoder.b localb = this.m;
      this.m = null;
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
  
  private void z()
  {
    try
    {
      TXCLog.i("TXCCaptureAndEnc", "stopBigVideoEncoderInGLThread");
      com.tencent.liteav.videoencoder.b localb = this.i;
      this.i = null;
      if (localb != null)
      {
        localb.a();
        localb.a(null);
      }
      this.U = true;
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCCaptureAndEnc", "stopBigVideoEncoder failed.", localException);
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, Object paramObject, long paramLong)
  {
    for (;;)
    {
      synchronized (this.n)
      {
        if (this.s == 2) {
          return 0;
        }
        int i1 = a(paramInt2, paramInt3, paramObject);
        if (i1 != 0) {
          return i1;
        }
        if (paramLong == 0L)
        {
          paramLong = TXCTimeUtil.generatePtsMS();
          paramObject = this.i;
          if (paramObject != null)
          {
            paramObject.a(this.p.S);
            paramObject.a(paramInt1, paramInt2, paramInt3, paramLong);
          }
          paramObject = this.m;
          if (paramObject != null)
          {
            paramObject.a(this.p.S);
            paramObject.a(paramInt1, paramInt2, paramInt3, paramLong);
          }
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
    Object localObject = this.Y;
    if (localObject != null)
    {
      localObject = (m)((WeakReference)localObject).get();
      if (localObject != null) {
        paramb.a = ((m)localObject).a(paramb.a, paramb.e, paramb.f);
      }
    }
    d(paramb);
    a(paramb, false);
    return paramb.a;
  }
  
  public int a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i1;
    if ((this.l.width == paramInt1) && (this.l.height == paramInt2)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    Object localObject = this.l;
    ((TXSVideoEncoderParam)localObject).width = paramInt1;
    ((TXSVideoEncoderParam)localObject).height = paramInt2;
    ((TXSVideoEncoderParam)localObject).fps = paramInt3;
    ((TXSVideoEncoderParam)localObject).gop = paramInt5;
    ((TXSVideoEncoderParam)localObject).encoderProfile = 1;
    ((TXSVideoEncoderParam)localObject).realTime = this.p.P;
    localObject = this.l;
    ((TXSVideoEncoderParam)localObject).streamType = 3;
    ((TXSVideoEncoderParam)localObject).bitrate = paramInt4;
    ((TXSVideoEncoderParam)localObject).annexb = true;
    ((TXSVideoEncoderParam)localObject).bMultiRef = false;
    if ((this.m != null) && ((i1 != 0) || ((this.k) && (!paramBoolean))))
    {
      localObject = this.d;
      if (localObject != null) {
        ((k)localObject).a(new d.3(this));
      } else {
        y();
      }
    }
    this.k = paramBoolean;
    return 0;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    for (;;)
    {
      synchronized (this.n)
      {
        if (this.s == 2) {
          return 0;
        }
        int i1 = a(paramInt2, paramInt3, null);
        if (i1 != 0) {
          return i1;
        }
        com.tencent.liteav.videoencoder.b localb = this.i;
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
    Object localObject = this.N;
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
    k localk = this.d;
    if (localk == null) {
      return;
    }
    localk.a(paramFloat);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if ((this.d != null) && (this.p.K)) {
      this.d.a(paramFloat1, paramFloat2);
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("vrotation setVideoEncRotation ");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.i("TXCCaptureAndEnc", ((StringBuilder)localObject).toString());
    this.Z = paramInt;
    localObject = this.d;
    if (localObject != null)
    {
      ((k)localObject).a(new d.1(this, paramInt));
      return;
    }
    localObject = this.i;
    if (localObject != null) {
      ((com.tencent.liteav.videoencoder.b)localObject).a(paramInt);
    }
    localObject = this.m;
    if (localObject != null) {
      ((com.tencent.liteav.videoencoder.b)localObject).a(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    synchronized (this.y)
    {
      if (this.C != null)
      {
        this.C.a(new d.4(this, paramInt1, paramInt2));
      }
      else
      {
        this.A = paramInt1;
        this.B = paramInt2;
      }
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    k localk = this.d;
    if (localk == null) {
      return;
    }
    localk.a(new d.22(this, paramInt2, paramInt3, paramInt1));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean)
  {
    if (paramInt1 == 2)
    {
      if (this.H != paramBoolean)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("codecability setVideoQosParam enableHevcEncode= ");
        ((StringBuilder)localObject).append(paramBoolean);
        TXCLog.i("TXCCaptureAndEnc", ((StringBuilder)localObject).toString());
      }
      if ((this.h.width != 0) && (this.h.height != 0) && ((paramInt2 != this.h.width) || (paramInt3 != this.h.height) || (paramInt4 > this.h.fps) || (!paramBoolean)))
      {
        localObject = this.d;
        if (localObject != null) {
          ((k)localObject).a(new d.12(this, paramInt2, paramInt3, paramInt4, paramBoolean, paramInt5));
        }
      }
      else
      {
        localObject = this.i;
        if (localObject != null)
        {
          ((com.tencent.liteav.videoencoder.b)localObject).b(paramInt5, paramInt6);
          ((com.tencent.liteav.videoencoder.b)localObject).b(paramInt4);
        }
      }
      d(paramInt7);
      return;
    }
    Object localObject = this.l;
    if ((localObject != null) && ((paramInt2 != ((TXSVideoEncoderParam)localObject).width) || (paramInt3 != this.l.height)))
    {
      localObject = this.d;
      if (localObject != null) {
        ((k)localObject).a(new d.20(this, paramInt2, paramInt3, paramInt4));
      }
    }
    localObject = this.m;
    if (localObject != null)
    {
      ((com.tencent.liteav.videoencoder.b)localObject).b(paramInt5, paramInt6);
      ((com.tencent.liteav.videoencoder.b)localObject).b(paramInt4);
    }
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramInt == 2)
    {
      this.J = paramLong1;
      this.I = paramLong2;
    }
  }
  
  public void a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    g localg = this.p;
    localg.E = paramBitmap;
    localg.H = paramFloat1;
    localg.I = paramFloat2;
    localg.J = paramFloat3;
    A();
  }
  
  public void a(Bitmap paramBitmap, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    paramBitmap = new d.11(this, paramBitmap, paramByteBuffer, paramInt1, paramInt2);
    paramByteBuffer = this.d;
    if (paramByteBuffer != null)
    {
      paramByteBuffer.a(paramBitmap);
      return;
    }
    paramBitmap.run();
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    paramSurfaceTexture = this.e;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.b();
    }
  }
  
  public void a(MediaFormat paramMediaFormat)
  {
    Object localObject = this.N;
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
    if (this.x != null)
    {
      TXCLog.w("TXCCaptureAndEnc", "camera preview view is not null, can't set surface");
      return;
    }
    synchronized (this.y)
    {
      StringBuilder localStringBuilder;
      if (this.z != paramSurface)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("surface-render: set surface ");
        localStringBuilder.append(paramSurface);
        TXCLog.i("TXCCaptureAndEnc", localStringBuilder.toString());
        this.z = paramSurface;
        if (this.C != null)
        {
          this.C.a();
          this.C = null;
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
  
  public void a(com.tencent.liteav.basic.b.b paramb)
  {
    this.X = new WeakReference(paramb);
  }
  
  public void a(com.tencent.liteav.basic.c.o paramo)
  {
    Object localObject = this.x;
    if (localObject != null)
    {
      localObject = ((TXCloudVideoView)localObject).getGLSurfaceView();
      if (localObject != null)
      {
        ((TXCGLSurfaceView)localObject).a(new d.5(this, paramo));
        return;
      }
      if (paramo != null) {
        paramo.onTakePhotoComplete(null);
      }
    }
    else
    {
      localObject = this.C;
      if (localObject != null)
      {
        ((com.tencent.liteav.basic.c.e)localObject).a(new d.6(this, paramo));
        return;
      }
      if (paramo != null) {
        paramo.onTakePhotoComplete(null);
      }
    }
  }
  
  public void a(TXSNALPacket paramTXSNALPacket, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(com.tencent.liteav.basic.structs.b paramb, long paramLong)
  {
    a(paramb.a, paramb.e, paramb.f, paramLong);
  }
  
  public void a(d.a parama)
  {
    this.N = new WeakReference(parama);
  }
  
  public void a(g paramg)
  {
    boolean bool = true;
    int i1;
    if ((paramg != null) && ((this.p.E != paramg.E) || (this.p.F != paramg.F) || (this.p.G != paramg.G) || (this.p.J != paramg.J) || (this.p.H != paramg.H) || (this.p.I != paramg.I))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if ((paramg != null) && ((this.p.a != paramg.a) || (this.p.b != paramg.b))) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    if (paramg != null) {
      try
      {
        this.p = ((g)paramg.clone());
      }
      catch (CloneNotSupportedException paramg)
      {
        this.p = new g();
        paramg.printStackTrace();
      }
    } else {
      this.p = new g();
    }
    TXCLog.i("TXCCaptureAndEnc", String.format("vsize setConfig w*h:%d*%d orientation:%d", new Object[] { Integer.valueOf(this.p.a), Integer.valueOf(this.p.b), Integer.valueOf(this.p.l) }));
    paramg = this.d;
    if (paramg != null) {
      paramg.e(this.p.l);
    }
    if ((i2 == 0) || (this.p.T)) {
      bool = false;
    }
    l(bool);
    if (j())
    {
      B();
      if (i1 != 0) {
        A();
      }
    }
  }
  
  public void a(m paramm)
  {
    this.Y = new WeakReference(paramm);
  }
  
  public void a(o paramo, int paramInt)
  {
    this.K = paramInt;
    if (paramo != null)
    {
      this.L = new WeakReference(paramo);
      return;
    }
    this.L = null;
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
    this.q = 1;
    if (this.d == null)
    {
      this.d = new i(this.o, this.p, parama);
      TXCLog.i("TXCCaptureAndEnc", "create TXCScreenCaptureSource");
    }
    this.W.a(false);
    j(this.E);
    this.d.a(this);
    this.d.a(this);
    this.d.a();
    this.d.a(getID());
    TXCDRApi.txReportDAU(this.o, com.tencent.liteav.basic.datareport.a.aG);
  }
  
  public void a(TXCloudVideoView paramTXCloudVideoView)
  {
    if (this.p.M)
    {
      TXCLog.e("TXCCaptureAndEnc", "enable pure audio push , so can not start preview!");
      return;
    }
    Object localObject = this.a;
    if (localObject != null) {
      ((b)localObject).b();
    }
    this.w = false;
    boolean bool = this.p.W;
    if (paramTXCloudVideoView != null)
    {
      TXCGLSurfaceView[] arrayOfTXCGLSurfaceView = new TXCGLSurfaceView[1];
      a(new d.25(this, arrayOfTXCGLSurfaceView, paramTXCloudVideoView));
      localObject = arrayOfTXCGLSurfaceView[0];
      arrayOfTXCGLSurfaceView[0].setNotifyListener(this);
      TXCLog.i("TXCCaptureAndEnc", "start camera preview with GLSurfaceView");
    }
    else
    {
      localObject = new com.tencent.liteav.basic.c.f();
      TXCLog.i("TXCCaptureAndEnc", "start camera preview with SurfaceTexture");
      bool = false;
    }
    this.q = 0;
    this.d = new c(this.o, this.p, (com.tencent.liteav.basic.c.m)localObject, bool);
    x();
    j(this.E);
    this.d.a(getID());
    this.d.a(this);
    this.d.a(this);
    this.d.a();
    this.d.b(this.u);
    this.d.c(this.v);
    this.d.d(this.aa);
    this.x = paramTXCloudVideoView;
    this.c.post(new d.2(this, paramTXCloudVideoView));
    this.w = false;
    TXCKeyPointReportProxy.a(30003);
  }
  
  public void a(boolean paramBoolean)
  {
    this.M = paramBoolean;
  }
  
  public TXBeautyManager b()
  {
    return this.W;
  }
  
  public void b(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setLocalViewMirror ");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.i("TXCCaptureAndEnc", ((StringBuilder)localObject).toString());
    this.aa = paramInt;
    localObject = this.d;
    if (localObject != null) {
      ((k)localObject).d(this.aa);
    }
    localObject = this.C;
    if (localObject != null) {
      ((com.tencent.liteav.basic.c.e)localObject).b(this.aa);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    k localk = this.d;
    if (localk == null) {
      return;
    }
    localk.a(paramInt1, paramInt2);
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.W.setBeautyLevel(paramInt1);
    this.W.setWhitenessLevel(paramInt2);
    this.W.setRuddyLevel(paramInt3);
  }
  
  public void b(com.tencent.liteav.basic.structs.b paramb)
  {
    if (!this.T)
    {
      this.T = true;
      TXCKeyPointReportProxy.b(30003, 0);
    }
    if (this.s == 2) {
      return;
    }
    k localk = this.d;
    if ((this.e != null) && (!this.p.M) && (localk != null))
    {
      if ((this.h.height != paramb.h) || (this.h.width != paramb.g)) {
        d(paramb.g, paramb.h);
      }
      this.e.a(localk.f());
      this.e.a(this.p.l);
      this.e.a(paramb, paramb.b, 0, 0L);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enableBlackStream ");
    localStringBuilder.append(paramBoolean);
    TXCLog.i("TXCCaptureAndEnc", localStringBuilder.toString());
    this.t = paramBoolean;
    if (this.t)
    {
      if (this.d == null) {
        w();
      }
    }
    else {
      x();
    }
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong) {}
  
  public int c()
  {
    return this.h.width;
  }
  
  public void c(int paramInt)
  {
    k localk = this.d;
    if (localk == null) {
      return;
    }
    localk.a(new d.21(this, paramInt));
  }
  
  public void c(boolean paramBoolean)
  {
    k(paramBoolean);
  }
  
  public int d()
  {
    return this.h.height;
  }
  
  public void d(int paramInt)
  {
    k localk = this.d;
    if (localk == null) {
      return;
    }
    localk.a(new d.23(this, paramInt));
  }
  
  public void d(boolean paramBoolean)
  {
    this.V = paramBoolean;
  }
  
  public int e()
  {
    if (j())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ignore startPush when pushing, status:");
      localStringBuilder.append(this.s);
      TXCLog.w("TXCCaptureAndEnc", localStringBuilder.toString());
      return -2;
    }
    TXCDRApi.initCrashReport(this.o);
    this.s = 1;
    TXCLog.i("TXCCaptureAndEnc", "startWithoutAudio");
    B();
    TXCDRApi.txReportDAU(this.o, com.tencent.liteav.basic.datareport.a.bu);
    return 0;
  }
  
  public void e(int paramInt)
  {
    if (this.p.h == paramInt) {
      return;
    }
    this.p.h = paramInt;
    k localk = this.d;
    if ((localk != null) && (localk.g() < paramInt))
    {
      int i1 = this.q;
      if (i1 != 0)
      {
        if (i1 != 1) {
          return;
        }
        this.d.f(paramInt);
        return;
      }
      l(true);
      t();
    }
  }
  
  public boolean e(boolean paramBoolean)
  {
    k localk = this.d;
    if (localk == null) {
      return false;
    }
    return localk.d(paramBoolean);
  }
  
  public void f()
  {
    if (!j())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ignore stopPush when not pushing, status:");
      ((StringBuilder)localObject).append(this.s);
      TXCLog.w("TXCCaptureAndEnc", ((StringBuilder)localObject).toString());
      return;
    }
    TXCLog.i("TXCCaptureAndEnc", "stop");
    this.s = 0;
    t();
    this.p.P = false;
    Object localObject = this.a;
    if (localObject != null) {
      ((b)localObject).b();
    }
    b(false);
    this.D = null;
  }
  
  public void f(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setRenderMode ");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.i("TXCCaptureAndEnc", ((StringBuilder)localObject).toString());
    this.v = paramInt;
    localObject = this.d;
    if (localObject != null) {
      ((k)localObject).c(paramInt);
    }
    localObject = this.C;
    if (localObject != null) {
      ((com.tencent.liteav.basic.c.e)localObject).a(this.v);
    }
  }
  
  public boolean f(boolean paramBoolean)
  {
    this.p.S = paramBoolean;
    k localk = this.d;
    if (localk == null) {
      return false;
    }
    localk.c(paramBoolean);
    return true;
  }
  
  public void g()
  {
    Object localObject;
    if (this.s != 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ignore pause push when is not pushing, status:");
      ((StringBuilder)localObject).append(this.s);
      TXCLog.w("TXCCaptureAndEnc", ((StringBuilder)localObject).toString());
      return;
    }
    this.s = 2;
    TXCLog.i("TXCCaptureAndEnc", "pausePusher");
    if ((this.p.D & 0x1) == 1)
    {
      t();
      if ((this.a != null) && (!this.p.M)) {
        this.a.a(this.p.C, this.p.B, this.p.A, this.h.width, this.h.height);
      }
      localObject = this.d;
      if (localObject != null) {
        ((k)localObject).c();
      }
    }
  }
  
  public void g(int paramInt)
  {
    if (this.u != paramInt)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("vrotation setRenderRotation ");
      ((StringBuilder)localObject).append(paramInt);
      TXCLog.i("TXCCaptureAndEnc", ((StringBuilder)localObject).toString());
    }
    this.u = paramInt;
    Object localObject = this.d;
    if (localObject == null) {
      return;
    }
    ((k)localObject).b(paramInt);
  }
  
  public void g(boolean paramBoolean)
  {
    if ((this.H) && (paramBoolean))
    {
      TXCLog.i("TXCCaptureAndEnc", "enableRPS when mEnableHEVCEncode = true");
      return;
    }
    if (this.F == paramBoolean) {
      return;
    }
    this.F = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("trtc_api onVideoConfigChanged enableRps ");
    localStringBuilder.append(this.F);
    TXCLog.i("TXCCaptureAndEnc", localStringBuilder.toString());
    if (this.F) {
      this.p.j = 0;
    }
    t();
  }
  
  public void h()
  {
    Object localObject;
    if (this.s != 2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ignore resume push when is not pause, status:");
      ((StringBuilder)localObject).append(this.s);
      TXCLog.w("TXCCaptureAndEnc", ((StringBuilder)localObject).toString());
      return;
    }
    this.s = 1;
    TXCLog.i("TXCCaptureAndEnc", "resumePusher");
    if ((this.p.D & 0x1) == 1)
    {
      if ((this.a != null) && (!this.p.M)) {
        this.a.b();
      }
      t();
      localObject = this.d;
      if (localObject != null) {
        ((k)localObject).b();
      }
      A();
    }
  }
  
  public void h(int paramInt)
  {
    this.W.setBeautyStyle(paramInt);
  }
  
  public void h(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void i(boolean paramBoolean)
  {
    this.G = paramBoolean;
  }
  
  public boolean i()
  {
    return this.t;
  }
  
  public boolean i(int paramInt)
  {
    k localk = this.d;
    if (localk == null) {
      return false;
    }
    return localk.a(paramInt);
  }
  
  public void j(int paramInt)
  {
    this.E = paramInt;
    k localk = this.d;
    if (localk != null) {
      localk.g(this.E);
    }
  }
  
  public void j(boolean paramBoolean)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("mEnableHEVCEncode = ");
    ((StringBuilder)???).append(paramBoolean);
    TXCLog.i("TXCCaptureAndEnc", ((StringBuilder)???).toString());
    ??? = this.d;
    if (??? != null)
    {
      ((k)???).a(new d.9(this, paramBoolean));
      return;
    }
    synchronized (this.n)
    {
      this.H = paramBoolean;
      return;
    }
  }
  
  public boolean j()
  {
    return this.s != 0;
  }
  
  public void k()
  {
    k localk = this.d;
    if (localk == null) {
      return;
    }
    localk.a(new d.24(this));
  }
  
  public void k(int paramInt)
  {
    com.tencent.liteav.videoencoder.b localb;
    if (paramInt == 2) {
      localb = this.i;
    } else if (paramInt == 3) {
      localb = this.m;
    } else {
      localb = null;
    }
    if (localb != null) {
      localb.b();
    }
  }
  
  public void l()
  {
    if (this.d == null) {
      return;
    }
    this.W.a(true);
    k(true);
  }
  
  public void l(int paramInt)
  {
    if (!this.H) {
      if (this.h.width * this.h.height < 518400) {
        this.p.j = 0;
      } else if ((this.h.width * this.h.height < 921600) && (this.f)) {
        this.p.j = 0;
      }
    }
    if (paramInt == 3)
    {
      v();
      return;
    }
    j(false);
    com.tencent.liteav.basic.util.f.a(this.X, -2310, getID());
    this.f = true;
    u();
  }
  
  public void m(int paramInt) {}
  
  public boolean m()
  {
    k localk = this.d;
    if (localk != null) {
      return localk.h();
    }
    return false;
  }
  
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
    d.19 local19 = new d.19(this, paramInt);
    k localk = this.d;
    if (localk == null)
    {
      local19.run();
      return;
    }
    localk.a(local19);
  }
  
  public boolean n()
  {
    k localk = this.d;
    if (localk != null) {
      return localk.i();
    }
    return false;
  }
  
  public boolean o()
  {
    k localk = this.d;
    if (localk != null) {
      return localk.j();
    }
    return false;
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.putString("EVT_USERID", getID());
    }
    if (paramInt == -2311) {
      j(false);
    }
    com.tencent.liteav.basic.util.f.a(this.X, paramInt, paramBundle);
    long l1;
    if (paramInt == -1317) {
      TXCEventRecorderProxy.a(getID(), 2002, 4L, -1L, "", this.E);
    } else if (paramInt == -1314) {
      TXCEventRecorderProxy.a(getID(), 2002, 5L, -1L, "", this.E);
    } else if (paramInt == 1003)
    {
      if (this.d != null)
      {
        paramBundle = getID();
        if (this.d.l()) {
          l1 = 0L;
        } else {
          l1 = 1L;
        }
        TXCEventRecorderProxy.a(paramBundle, 4001, l1, -1L, "", this.E);
      }
    }
    else if (paramInt == -1308) {
      l();
    }
    if ((paramInt != -1302) && (paramInt != -1317) && (paramInt != -1318) && (paramInt != -1319))
    {
      if ((paramInt == -1301) || (paramInt == -1314) || (paramInt == -1315) || (paramInt == -1316))
      {
        TXCKeyPointReportProxy.b(30003, paramInt);
        if (this.d != null)
        {
          paramBundle = getID();
          if (this.d.l()) {
            l1 = 0L;
          } else {
            l1 = 1L;
          }
          TXCEventRecorderProxy.a(paramBundle, 4002, l1, paramInt, "", this.E);
        }
      }
    }
    else {
      TXCKeyPointReportProxy.b(30002, paramInt);
    }
  }
  
  public boolean p()
  {
    k localk = this.d;
    if (localk != null) {
      return localk.k();
    }
    return false;
  }
  
  public int q()
  {
    k localk = this.d;
    if (localk == null) {
      return 0;
    }
    return localk.e();
  }
  
  public void r()
  {
    try
    {
      if (this.e != null) {
        this.e.b();
      }
      if (this.O != null)
      {
        this.O.d();
        this.O = null;
      }
      if (this.Q != null)
      {
        this.Q.d();
        this.Q = null;
      }
      if (this.P != null)
      {
        this.P.d();
        this.P = null;
      }
      z();
      y();
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCCaptureAndEnc", "stop preprocessor and encoder failed.", localException);
    }
  }
  
  public void s()
  {
    TXCLog.i("TXCCaptureAndEnc", "onCaptureDestroy->enter ");
    Object localObject = this.e;
    if (localObject != null) {
      ((com.tencent.liteav.beauty.d)localObject).b();
    }
    localObject = this.O;
    if (localObject != null)
    {
      ((h)localObject).d();
      this.O = null;
    }
    localObject = this.Q;
    if (localObject != null)
    {
      ((h)localObject).d();
      this.Q = null;
    }
    localObject = this.P;
    if (localObject != null)
    {
      ((h)localObject).d();
      this.P = null;
    }
    localObject = this.R;
    if (localObject != null)
    {
      ((com.tencent.liteav.beauty.b.k)localObject).d();
      this.R = null;
    }
    z();
    y();
    localObject = this.Y;
    if (localObject != null)
    {
      localObject = (m)((WeakReference)localObject).get();
      if (localObject != null) {
        ((m)localObject).a();
      }
    }
  }
  
  public void setID(String paramString)
  {
    super.setID(paramString);
    Object localObject = this.i;
    if (localObject != null) {
      ((com.tencent.liteav.videoencoder.b)localObject).setID(paramString);
    }
    localObject = this.m;
    if (localObject != null) {
      ((com.tencent.liteav.videoencoder.b)localObject).setID(paramString);
    }
    localObject = this.e;
    if (localObject != null) {
      ((com.tencent.liteav.beauty.d)localObject).setID(paramString);
    }
    localObject = this.d;
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
    d.13 local13 = new d.13(this);
    ??? = this.d;
    if (??? != null)
    {
      ((k)???).a(local13);
      return;
    }
    synchronized (this.n)
    {
      local13.run();
      return;
    }
  }
  
  public void u()
  {
    if (this.i == null) {
      return;
    }
    k localk = this.d;
    if (localk != null)
    {
      localk.a(new d.14(this));
      return;
    }
    z();
  }
  
  public void v()
  {
    if (this.m == null) {
      return;
    }
    k localk = this.d;
    if (localk != null)
    {
      localk.a(new d.15(this));
      return;
    }
    y();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.d
 * JD-Core Version:    0.7.0.1
 */