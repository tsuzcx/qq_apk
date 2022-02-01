package com.tencent.luggage.wxa.gd;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.fx.a.a;
import com.tencent.luggage.wxa.fy.i;
import com.tencent.luggage.wxa.fy.j;
import com.tencent.luggage.wxa.fy.k;
import com.tencent.luggage.wxa.fy.l;
import com.tencent.luggage.wxa.fy.m;
import com.tencent.luggage.wxa.fy.n;
import com.tencent.luggage.wxa.fy.r;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import org.json.JSONArray;
import org.json.JSONObject;

public class d
  extends com.tencent.luggage.wxa.gf.a
  implements i
{
  private boolean A = false;
  private int B;
  private int C;
  private int D = 0;
  private int E = 0;
  private int F;
  private int G;
  private int H;
  private int I;
  private String J;
  private String K;
  private boolean L;
  private boolean M;
  private boolean N;
  private boolean O;
  private boolean P = false;
  private boolean Q = false;
  private AtomicBoolean R = null;
  private final ConcurrentLinkedQueue<Runnable> S = new ConcurrentLinkedQueue();
  private Handler T;
  private HandlerThread U = com.tencent.luggage.wxa.sc.d.b(String.format("VideoThread_%s", new Object[] { Long.valueOf(System.currentTimeMillis()) }), 5);
  @Nullable
  private volatile com.tencent.luggage.wxa.fx.a V = null;
  @Nullable
  private com.tencent.luggage.wxa.lr.c W = null;
  @Nullable
  private String X = null;
  @Nullable
  private Surface Y = null;
  @Nullable
  private d.a Z = null;
  private boolean aa = false;
  private com.tencent.luggage.wxa.jx.s ab = new d.26(this);
  private com.tencent.luggage.wxa.fy.a ac = new d.27(this, this, this.ab);
  private com.tencent.luggage.wxa.fy.b<f> ad = new d.28(this);
  @Nullable
  private d.b ae = null;
  @Nullable
  private a af = null;
  @Nullable
  private com.tencent.luggage.wxa.fy.s ag = null;
  private float ah = 1.0F;
  private float ai = 1.0F;
  private boolean aj = false;
  private boolean ak = false;
  private i al = new r();
  private AtomicBoolean am = new AtomicBoolean(false);
  @Nullable
  private volatile String an = null;
  @Nullable
  private volatile String ao = null;
  @Nullable
  private volatile com.tencent.luggage.wxa.fy.g ap = null;
  @Nullable
  private volatile Bitmap aq = null;
  private Surface e;
  private SurfaceTexture f;
  private com.tencent.luggage.wxa.mi.b g;
  private com.tencent.luggage.wxa.ge.d h;
  private com.tencent.luggage.wxa.ge.a i;
  private com.tencent.luggage.wxa.ge.c j;
  private com.tencent.luggage.wxa.ge.e k;
  private com.tencent.luggage.wxa.ge.f l;
  private com.tencent.luggage.wxa.ge.b m;
  private volatile com.tencent.luggage.wxa.nf.b n;
  private com.tencent.luggage.wxa.fx.a o;
  private a.a p;
  private boolean q;
  private boolean r;
  private boolean s;
  private boolean t;
  private long u;
  private boolean v;
  private boolean w;
  private boolean x;
  private volatile boolean y;
  private boolean z = false;
  
  public d()
  {
    this.U.start();
    this.T = new Handler(this.U.getLooper());
  }
  
  private String E()
  {
    return String.format("%s(%s)", new Object[] { "MicroMsg.SameLayer.VideoPluginHandler", A() });
  }
  
  private void F()
  {
    synchronized (this.S)
    {
      if (!this.S.isEmpty())
      {
        o.d(E(), "flushPendingTasks, size:%d", new Object[] { Integer.valueOf(this.S.size()) });
        Iterator localIterator = this.S.iterator();
        while (localIterator.hasNext()) {
          ((Runnable)localIterator.next()).run();
        }
        this.S.clear();
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  private void G()
  {
    super.d();
    o.d(E(), "*** handler(%s) handlePluginDestroy", new Object[] { A() });
    ab();
    an();
  }
  
  private void H()
  {
    this.q = false;
    this.r = false;
    this.s = false;
    this.t = false;
  }
  
  private void I()
  {
    com.tencent.luggage.wxa.mi.b localb = this.g;
    if ((localb != null) && (this.f != null))
    {
      int i1 = localb.i();
      int i2 = this.g.j();
      if ((i1 == 0) && (i2 == 0))
      {
        o.c(E(), "VideoCanvas, registerMediaPlayer, width or height is 0");
        return;
      }
      if (!this.P)
      {
        this.P = true;
        com.tencent.luggage.wxa.jv.a.a().a(B(), this, this.f, i1, i2, this.o.a());
        return;
      }
      o.c(E(), "VideoCanvas, registerMediaPlayer, already registered");
      return;
    }
    o.c(E(), "VideoCanvas, registerMediaPlayer, media player or surface texture is null");
  }
  
  private void J()
  {
    a(new d.38(this));
  }
  
  private void K()
  {
    if (!this.y)
    {
      o.d(E(), "onMediaPlayerSeekComplete, mp released");
      return;
    }
    o.d(E(), "onSeekComplete");
    if (ao()) {
      this.h.b(m());
    }
    if (this.q)
    {
      o.d(E(), "onSeekComplete, start when seek complete");
      this.q = false;
      c(false);
      return;
    }
    boolean bool = this.g.f();
    if (this.r)
    {
      long l1 = this.g.g();
      long l2 = this.g.h();
      o.d(E(), "onSeekComplete, video playing before seeking, isCurrentPlaying:%b, position:%s, duration:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l2), Long.valueOf(l1) });
      this.r = false;
      if (l2 / 1000L < l1 / 1000L)
      {
        o.d(E(), "onSeekComplete, video not end");
        if ((bool) && (ao()))
        {
          o.d(E(), "onSeekComplete, dispatch play again");
          this.h.a(false);
        }
      }
      else
      {
        o.d(E(), "onSeekComplete, video ends");
        this.g.m();
        this.g.l();
      }
    }
    else
    {
      o.d(E(), "onSeekComplete, video not playing before seeking, isCurrentPlaying:%b", new Object[] { Boolean.valueOf(bool) });
      if ((!bool) && (ao()))
      {
        o.d(E(), "onSeekComplete, dispatch pause again");
        this.h.b(false);
      }
    }
  }
  
  private void L()
  {
    a(new d.39(this));
  }
  
  private void M()
  {
    if (!this.y)
    {
      o.d(E(), "onMediaPlayerCompletion, mp released");
      return;
    }
    o.d(E(), "onCompletion");
    if (ao()) {
      this.h.a();
    }
    Object localObject = this.m;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.ge.b)localObject).f(this.o, this.g);
    }
    if (this.z)
    {
      o.d(E(), "onCompletion, video loop playing");
      this.q = true;
      a(0L);
      return;
    }
    o.d(E(), "onCompletion, video end playing");
    this.N = true;
    localObject = this.g;
    if ((localObject != null) && ((localObject instanceof com.tencent.luggage.wxa.mk.c))) {
      ((com.tencent.luggage.wxa.mi.b)localObject).m();
    }
  }
  
  private void N()
  {
    a(new d.2(this));
  }
  
  private void O()
  {
    if (!this.y)
    {
      o.d(E(), "onMediaPlayerPrepared, mp released");
      return;
    }
    o.d(E(), "onPrepared");
    com.tencent.luggage.wxa.ge.b localb = this.m;
    if (localb != null) {
      localb.a(this.o, this.g, ag());
    }
    boolean bool2 = true;
    this.w = true;
    a(false);
    if ((ao()) && (this.g != null)) {
      this.h.a(ah(), ai(), ag());
    }
    I();
    long l1 = this.u;
    if (l1 > 0L)
    {
      a(l1);
      this.u = 0L;
    }
    boolean bool1 = this.O ^ true;
    if ((this.o.g() instanceof u)) {
      bool1 = ((u)this.o.g()).R();
    } else {
      o.c(E(), "onPrepared, component is not page view");
    }
    if ((!bool1) && (!ap()))
    {
      o.d(E(), "onPrepared, stop video auto play when webview in background");
      bool1 = bool2;
      if (!this.v) {
        if (this.t) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      a(new AtomicBoolean(bool1));
      return;
    }
    if ((!this.v) && (!this.t))
    {
      o.d(E(), "onPrepared, not set start play when prepared");
      return;
    }
    o.d(E(), "onPrepared, start play when prepared, mStartWhenPrepared:%s, mControlStartWhenPrepared:%s", new Object[] { Boolean.valueOf(this.v), Boolean.valueOf(this.t) });
    if ((this.n != null) && (this.n.g()))
    {
      o.d("MicroMsg.SameLayer.VideoPluginHandler", "onMediaPlayerPreparedInternal: castMediaPresent, avoid play when prepared");
      return;
    }
    c(this.v);
  }
  
  private void P()
  {
    if (!this.y)
    {
      o.d(E(), "onMediaPlayerVideoFirstFrame, mp released");
      return;
    }
    o.d(E(), "onMediaPlayerVideoFirstFrame");
    com.tencent.luggage.wxa.ge.b localb = this.m;
    if (localb != null) {
      localb.a(this.o, this.g);
    }
  }
  
  private void Q()
  {
    com.tencent.luggage.wxa.fx.a locala = this.o;
    if (locala != null)
    {
      locala.f();
      this.p = null;
    }
  }
  
  private void R()
  {
    a(new d.6(this));
  }
  
  private void S()
  {
    Object localObject = E();
    String str = A();
    boolean bool = false;
    o.d((String)localObject, "*** handler(%s) handleWebViewForeground", new Object[] { str });
    this.O = false;
    if (!this.Q)
    {
      bool = c();
      a(null);
    }
    localObject = new d.7(this, bool);
    if (!a(null))
    {
      o.d(E(), "handleWebViewForeground, plugin is not ready, add to pending tasks");
      this.S.add(localObject);
      return;
    }
    if (!T())
    {
      o.d(E(), "handleWebViewForeground, resume playing");
      ((Runnable)localObject).run();
    }
  }
  
  private boolean T()
  {
    Object localObject = this.o;
    if ((localObject instanceof com.tencent.luggage.wxa.ju.b))
    {
      com.tencent.luggage.wxa.jx.c localc = ((com.tencent.luggage.wxa.fx.a)localObject).g();
      localObject = null;
      if ((localc instanceof u)) {
        localObject = (u)localc;
      } else if ((localc instanceof h)) {
        localObject = ((h)localc).v();
      }
      if (localObject != null)
      {
        localObject = ((u)localObject).q();
        o.d(E(), "cancelResumePlayingWhenRelaunch:%s", new Object[] { Boolean.valueOf(((com.tencent.luggage.wxa.iu.d)localObject).aJ()) });
        return ((com.tencent.luggage.wxa.iu.d)localObject).aJ();
      }
    }
    return false;
  }
  
  private void U()
  {
    a(new d.10(this));
  }
  
  private void V()
  {
    o.d(E(), "*** handler(%s) handleWebViewDestroy", new Object[] { A() });
    ac();
  }
  
  private void W()
  {
    this.Q = false;
    boolean bool;
    if (!this.O)
    {
      bool = c();
      a(null);
    }
    else
    {
      bool = false;
    }
    if (bool)
    {
      if (T())
      {
        o.d("MicroMsg.SameLayer.VideoPluginHandler", "onRuntimeEnterForeground, cancel resume playing when relaunch");
        return;
      }
      o.d("MicroMsg.SameLayer.VideoPluginHandler", "onRuntimeEnterForeground, isPlayingWhenEnterBackground, try resume");
      c(false);
    }
  }
  
  private void X()
  {
    this.Q = true;
    if (b() == null)
    {
      boolean bool = l();
      a(new AtomicBoolean(bool));
      o.d(E(), "onRuntimeEnterBackground, isPlayingWhenEnterBackground:%s", new Object[] { Boolean.valueOf(bool) });
      if ((this.ak) && (aq()))
      {
        o.d(E(), "onRuntimeEnterBackground, background play audio is enabled");
        return;
      }
      aa();
    }
  }
  
  private void Y()
  {
    o.d(E(), "applyPluginTextureScaleIfNeed");
    if (!this.aa)
    {
      o.d(E(), "applyPluginTextureScaleIfNeed, TextureScale is not sticky");
      return;
    }
    if ((this.O) && (this.Y != null))
    {
      o.d(E(), "applyPluginTextureScaleIfNeed, in PIP mode");
      return;
    }
    com.tencent.luggage.wxa.fx.d.a(D(), C(), B(), this.ah, this.ai);
  }
  
  private void Z()
  {
    b(true);
  }
  
  private String a(com.tencent.luggage.wxa.fx.a parama, String paramString)
  {
    com.tencent.luggage.wxa.ge.b localb = this.m;
    String str = paramString;
    if (localb != null) {
      str = localb.a(parama, paramString);
    }
    return str;
  }
  
  private void a(int paramInt)
  {
    a(new d.36(this, paramInt));
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    a(new d.37(this, paramInt1, paramInt2));
  }
  
  private void a(long paramLong)
  {
    if ((this.w) && (this.g != null))
    {
      if (ao()) {
        this.h.b();
      }
      if (this.g != null)
      {
        this.r = l();
        paramLong = Math.min(ag(), Math.max(0L, paramLong));
        o.d(E(), "seek, position:%s, isPlaying:%s, videoEndPlaying:%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(this.r), Boolean.valueOf(this.N) });
        this.N = false;
        this.g.a(paramLong);
      }
    }
    else
    {
      this.u = paramLong;
    }
  }
  
  private void a(com.tencent.luggage.wxa.fx.a parama, JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("enableCasting")) {
      return;
    }
    boolean bool = paramJSONObject.optBoolean("enableCasting");
    paramJSONObject = E();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isEnableVideoCast = ");
    localStringBuilder.append(bool);
    o.e(paramJSONObject, localStringBuilder.toString());
    d(parama);
    this.n.a(bool);
  }
  
  private void a(@NonNull com.tencent.luggage.wxa.fy.g paramg)
  {
    o.d(E(), "getSnapshotAsync");
    this.ap = paramg;
    aj();
  }
  
  private void a(boolean paramBoolean)
  {
    if (!af.c(this.K))
    {
      if (D() != null)
      {
        Object localObject = this.l;
        if (localObject != null)
        {
          float f1 = this.ah;
          float f2 = this.ai;
          if (!((com.tencent.luggage.wxa.ge.f)localObject).a(this.K, this.B, this.C, this.F, this.G)) {
            return;
          }
          this.ah = this.l.a();
          this.ai = this.l.b();
          o.d(E(), "adjust objectFit:%s, scale:[%s, %s]", new Object[] { this.K, Float.valueOf(this.ah), Float.valueOf(this.ai) });
          if ((this.O) && (this.Y != null))
          {
            this.aa = true;
            o.d(E(), "adjust objectFit, TextureScale sticky");
          }
          else
          {
            com.tencent.luggage.wxa.fx.d.a(D(), C(), B(), this.ah, this.ai);
            this.aa = false;
          }
          if ((this.ah == f1) && (this.ai == f2)) {
            return;
          }
          localObject = this.Z;
          if (localObject == null) {
            return;
          }
          ((d.a)localObject).a(paramBoolean, this.ah, this.ai);
          return;
        }
      }
      o.d(E(), "adjust objectFit, video not prepared");
    }
    else
    {
      o.d(E(), "adjust objectFit, no video objectFit");
    }
  }
  
  private boolean a(Runnable paramRunnable)
  {
    Handler localHandler = this.T;
    if (localHandler != null)
    {
      if (localHandler.getLooper() == Looper.myLooper()) {
        paramRunnable.run();
      } else {
        this.T.post(paramRunnable);
      }
      return true;
    }
    return false;
  }
  
  private boolean a(Runnable paramRunnable, long paramLong)
  {
    Handler localHandler = this.T;
    if (localHandler != null)
    {
      localHandler.postDelayed(paramRunnable, paramLong);
      return true;
    }
    return false;
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      if ((this.w) && (((com.tencent.luggage.wxa.mi.b)localObject).f()))
      {
        o.d(E(), "video play, video is playing");
        if (ao()) {
          this.h.a(paramBoolean1);
        }
        return true;
      }
      if ((this.g != null) && (!this.w))
      {
        o.d(E(), "video play, video not prepared yet, start until prepared");
        this.t = true;
        return true;
      }
      localObject = this.g;
      if ((localObject != null) && (((com.tencent.luggage.wxa.mi.b)localObject).a() == 5))
      {
        if (!paramBoolean2)
        {
          o.d(E(), "video has ended playing, do not restart");
          return false;
        }
        o.d(E(), "video play, video has stopped now, try prepare and start when prepared");
        Z();
        this.t = true;
        return true;
      }
      if (this.N)
      {
        if (!paramBoolean2)
        {
          o.d(E(), "video has ended playing, do not restart");
          return false;
        }
        o.d(E(), "video play, video has ended playing, clear surface and start again");
        this.N = false;
        am();
        o(this.o);
        if (this.g != null)
        {
          this.v = true;
          localObject = a(this.o, this.J);
          if (!af.c((String)localObject))
          {
            this.g.a((String)localObject, this.X);
            c((String)localObject);
          }
          else
          {
            this.g.a(this.J, this.X);
            c(this.J);
          }
          o.d(E(), "video play, media player state:%s", new Object[] { Integer.valueOf(this.g.a()) });
          b(false);
          this.t = true;
        }
        return true;
      }
      o.d(E(), "video play");
      if (this.g != null)
      {
        if (ao()) {
          this.h.a(paramBoolean1);
        }
        Y();
        this.g.l();
      }
      return true;
    }
    return false;
  }
  
  private boolean aa()
  {
    com.tencent.luggage.wxa.mi.b localb = this.g;
    if (localb != null)
    {
      if (!this.w)
      {
        o.d(E(), "video pause, video not prepared yet, pause video when prepared");
        this.t = false;
        return true;
      }
      if (!localb.f())
      {
        o.d(E(), "video pause, video is not playing");
        return true;
      }
      o.d(E(), "video pause");
      this.g.m();
      if (ao()) {
        this.h.b(false);
      }
      return true;
    }
    return false;
  }
  
  private boolean ab()
  {
    com.tencent.luggage.wxa.mi.b localb = this.g;
    if (localb != null)
    {
      com.tencent.luggage.wxa.ge.b localb1 = this.m;
      if (localb1 != null) {
        localb1.e(this.o, localb);
      }
      if (!this.w)
      {
        o.d(E(), "video stop, video not prepared yet, stop video when prepared");
        this.t = false;
        return true;
      }
      o.d(E(), "video stop");
      this.g.n();
      if (ao()) {
        this.h.b(true);
      }
      return true;
    }
    return false;
  }
  
  private void ac()
  {
    o.d(E(), "video release");
    com.tencent.luggage.wxa.ge.b localb = this.m;
    if (localb != null) {
      localb.e(this.o);
    }
    ab();
    ak();
    af();
    ae();
    an();
    Q();
    ad();
  }
  
  private void ad()
  {
    o.d(E(), "video release handler thread");
    Object localObject = this.T;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.U;
    if (localObject != null) {
      ((HandlerThread)localObject).quitSafely();
    }
  }
  
  private void ae()
  {
    if (this.n != null)
    {
      this.n.h();
      this.n = null;
    }
  }
  
  private void af()
  {
    com.tencent.luggage.wxa.ge.d locald = this.h;
    if (locald != null)
    {
      locald.c();
      this.h = null;
      this.i = null;
    }
  }
  
  private int ag()
  {
    com.tencent.luggage.wxa.mi.b localb = this.g;
    if (localb != null) {
      return localb.g();
    }
    return 0;
  }
  
  private int ah()
  {
    com.tencent.luggage.wxa.mi.b localb = this.g;
    if (localb != null) {
      return localb.i();
    }
    return 0;
  }
  
  private int ai()
  {
    com.tencent.luggage.wxa.mi.b localb = this.g;
    if (localb != null) {
      return localb.j();
    }
    return 0;
  }
  
  private void aj()
  {
    o.d(E(), "takeScreenshot");
    com.tencent.luggage.wxa.fx.d.a(D(), C(), B());
  }
  
  private void ak()
  {
    if (this.g != null)
    {
      o.d(E(), "releaseMediaPlayer");
      this.g.a(null);
      this.g.a(null);
      this.g.a(null);
      this.g.a(null);
      this.g.a(null);
      this.g.a(null);
      this.g.n();
      this.g.o();
      this.g.b();
    }
    this.g = null;
    this.y = false;
  }
  
  private void al()
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      ((com.tencent.luggage.wxa.mi.b)localObject).a(this.A);
      if (this.e != null)
      {
        boolean bool2 = this.am.get();
        if ((!this.O) && (!bool2))
        {
          o.d(E(), "applyMediaPlayerParams, setSurface");
          this.g.a(this.e);
          return;
        }
        localObject = E();
        boolean bool3 = this.O;
        boolean bool1 = true;
        if (this.Y == null) {
          bool1 = false;
        }
        o.d((String)localObject, "applyMediaPlayerParams, setSurface, WebViewInBackground: %b, JustPlayAudio: %b, SurfacePipSet exist: %b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if (this.O)
        {
          localObject = this.Y;
          if (localObject != null) {
            this.g.a((Surface)localObject);
          }
        }
      }
    }
  }
  
  private void am()
  {
    try
    {
      if ((this.f != null) && (this.w))
      {
        o.d(E(), "clearSurfaceTexture");
        e(this.f);
        return;
      }
    }
    catch (Exception localException)
    {
      o.a(E(), localException, "clearSurfaceTexture error", new Object[0]);
    }
  }
  
  private void an()
  {
    Surface localSurface = this.e;
    if (localSurface != null)
    {
      localSurface.release();
      this.e = null;
    }
  }
  
  private boolean ao()
  {
    try
    {
      if (this.x)
      {
        com.tencent.luggage.wxa.ge.d locald = this.h;
        if (locald != null)
        {
          bool = true;
          break label25;
        }
      }
      boolean bool = false;
      label25:
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean ap()
  {
    return this.ad.c(this.o);
  }
  
  private boolean aq()
  {
    Object localObject = this.o;
    if (localObject == null)
    {
      o.c(E(), "amIBackgroundAudioPlayer, mInsertInvokeContext is null");
      return false;
    }
    localObject = com.tencent.luggage.wxa.fy.e.a((com.tencent.luggage.wxa.fx.a)localObject);
    if (localObject == null)
    {
      o.c(E(), "amIBackgroundAudioPlayer, audioOfVideoBackgroundPlayManager is null");
      return false;
    }
    return ((com.tencent.luggage.wxa.mu.a)localObject).a(this);
  }
  
  private void ar()
  {
    o.e(E(), "registerAddOnPlayAudio");
    a(m.class, new d.29(this));
  }
  
  private void as()
  {
    o.e(E(), "registerAddOnVideoController");
    a(n.class, new d.30(this));
  }
  
  private void at()
  {
    o.e(E(), "registerAddOnInfo");
    a(l.class, new d.31(this));
  }
  
  private void au()
  {
    o.e(E(), "registerAddOnGetSnapshot");
    a(k.class, new d.33(this));
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (!this.y)
    {
      o.d(E(), "onMediaPlayerVideoSizeChanged, mp released");
      return;
    }
    o.d(E(), "onVideoSizeChanged, width:%d, height:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    a(false);
    int i1 = ag();
    if ((this.w) && (this.g != null) && ((paramInt1 != this.F) || (paramInt2 != this.G) || (i1 != this.H)))
    {
      if (ao()) {
        this.h.a(paramInt1, paramInt2, i1);
      }
      I();
    }
    this.F = paramInt1;
    this.G = paramInt2;
    this.H = i1;
  }
  
  private void b(@NonNull com.tencent.luggage.wxa.fx.a parama, @NonNull JSONObject paramJSONObject)
  {
    parama = parama.g();
    if (parama == null)
    {
      o.c(E(), "updateReferrers, component is null");
      return;
    }
    com.tencent.luggage.wxa.lr.a locala = (com.tencent.luggage.wxa.lr.a)com.tencent.luggage.wxa.ba.e.a(com.tencent.luggage.wxa.lr.a.class);
    if (locala == null)
    {
      o.c(E(), "updateReferrers, referrerHelper is null");
      return;
    }
    if (this.W == null) {
      this.W = locala.a();
    }
    paramJSONObject = locala.a(paramJSONObject, parama);
    if (paramJSONObject != null) {
      this.W = paramJSONObject;
    }
    paramJSONObject = E();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateReferrers, mReferrerPolicy: ");
    localStringBuilder.append(this.W);
    o.d(paramJSONObject, localStringBuilder.toString());
    if (com.tencent.luggage.wxa.lr.c.b == this.W)
    {
      this.X = null;
      return;
    }
    this.X = locala.b(parama);
    parama = E();
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("updateReferrers, mReferrer: ");
    paramJSONObject.append(this.X);
    o.d(parama, paramJSONObject.toString());
  }
  
  private void b(@NonNull Runnable paramRunnable)
  {
    a(new d.32(this, paramRunnable));
    a(paramRunnable, 1000L);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.g != null)
    {
      o.d(E(), "video prepare async");
      if ((paramBoolean) && (ao())) {
        this.h.b();
      }
      this.w = false;
      this.t = false;
      com.tencent.luggage.wxa.ge.b localb = this.m;
      if (localb != null) {
        localb.b(this.o, this.g);
      }
      this.g.k();
    }
  }
  
  private boolean b(@Nullable Bitmap paramBitmap)
  {
    com.tencent.luggage.wxa.fx.a locala = this.V;
    if (locala == null)
    {
      o.c(E(), "handlePluginScreenshotTaken4JsApiCall, invokeContext is null");
      return false;
    }
    if (paramBitmap == null)
    {
      o.c(E(), "handlePluginScreenshotTaken4JsApiCall, bitmap is null");
      return false;
    }
    int i1 = this.B;
    Bitmap localBitmap = paramBitmap;
    if (i1 != 0)
    {
      int i2 = this.C;
      localBitmap = paramBitmap;
      if (i2 != 0) {
        localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(this.ah * i1), (int)(this.ai * i2), false);
      }
    }
    this.m.a(locala, localBitmap);
    this.V = null;
    return true;
  }
  
  private boolean b(String paramString)
  {
    if (paramString.equalsIgnoreCase("startCasting")) {
      return true;
    }
    if (this.n == null) {
      return false;
    }
    return this.n.f();
  }
  
  private boolean b(JSONObject paramJSONObject)
  {
    if ((this.g != null) && (paramJSONObject != null) && (paramJSONObject.has("data")))
    {
      paramJSONObject = paramJSONObject.optJSONArray("data");
      if ((paramJSONObject != null) && (paramJSONObject.length() != 0))
      {
        double d = paramJSONObject.optDouble(0, -1.0D);
        if (d < 0.0D)
        {
          o.c(E(), "seek, invalid position:%s", new Object[] { Double.valueOf(d) });
          return false;
        }
        a((d * 1000.0D));
        return true;
      }
      o.c(E(), "seek, data array is null");
    }
    return false;
  }
  
  private void c(int paramInt)
  {
    if (!this.y)
    {
      o.d(E(), "onMediaPlayerBufferingUpdate, mp released");
      return;
    }
    if (paramInt != this.I)
    {
      this.I = paramInt;
      o.d(E(), "onBufferingUpdate, percent:%s", new Object[] { Integer.valueOf(paramInt) });
    }
    if ((ao()) && (this.w)) {
      this.h.a(paramInt);
    }
  }
  
  private void c(SurfaceTexture paramSurfaceTexture)
  {
    super.a(paramSurfaceTexture);
    o.d(E(), "*** handler(%s) handlePluginReady", new Object[] { A() });
    H();
    this.f = paramSurfaceTexture;
    this.e = new Surface(paramSurfaceTexture);
    if (this.g != null)
    {
      o.d(E(), "handlePluginReady, setSurface:%s", new Object[] { paramSurfaceTexture });
      this.g.a(this.e);
      I();
    }
    F();
  }
  
  private void c(com.tencent.luggage.wxa.fx.a parama)
  {
    String str = parama.e();
    if (af.c(str)) {
      return;
    }
    JSONObject localJSONObject = parama.d();
    o.d(E(), "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { A(), str, localJSONObject.toString() });
    if (str.contains("insert")) {
      f(parama);
    } else if (str.contains("update")) {
      g(parama);
    } else if ((str.contains("operate")) && (str.contains("Background"))) {
      h(parama);
    } else if (str.contains("operate")) {
      i(parama);
    } else if (str.contains("remove")) {
      j(parama);
    }
    this.ac.a(str, parama);
    str = this.J;
    if (str == null) {
      str = "";
    }
    this.ad.a(parama, str);
  }
  
  private void c(@Nullable String paramString)
  {
    String str = E();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doCheckVideoUrl, videoPath: ");
    localStringBuilder.append(paramString);
    o.d(str, localStringBuilder.toString());
    com.tencent.luggage.wxa.rz.f.a.c(new d.25(this, paramString));
  }
  
  private boolean c(int paramInt1, int paramInt2)
  {
    return a(new d.3(this, paramInt1, paramInt2));
  }
  
  private boolean c(@Nullable Bitmap paramBitmap)
  {
    com.tencent.luggage.wxa.fy.g localg = this.ap;
    if (localg == null)
    {
      o.c(E(), "handlePluginScreenshotTaken4NativeCall, getSnapshotCallback is null");
      return false;
    }
    if (paramBitmap == null)
    {
      o.c(E(), "handlePluginScreenshotTaken4NativeCall, bitmap is null");
      localg.a(null);
      return true;
    }
    int i1 = this.B;
    Bitmap localBitmap = paramBitmap;
    if (i1 != 0)
    {
      int i2 = this.C;
      localBitmap = paramBitmap;
      if (i2 != 0) {
        localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(this.ah * i1), (int)(this.ai * i2), false);
      }
    }
    localg.a(localBitmap);
    this.ap = null;
    return true;
  }
  
  private boolean c(JSONObject paramJSONObject)
  {
    if ((this.g != null) && (paramJSONObject != null) && (paramJSONObject.has("data")))
    {
      paramJSONObject = paramJSONObject.optJSONArray("data");
      if ((paramJSONObject != null) && (paramJSONObject.length() != 0))
      {
        double d = paramJSONObject.optDouble(0, -1.0D);
        if (d < 0.0D)
        {
          o.c(E(), "speed, invalid rate:%s", new Object[] { Double.valueOf(d) });
          return false;
        }
        o.d(E(), "speed, speed:%s", new Object[] { Double.valueOf(d) });
        return this.g.a((float)d);
      }
      o.c(E(), "speed, data array is null");
    }
    return false;
  }
  
  private boolean c(boolean paramBoolean)
  {
    return a(paramBoolean, true);
  }
  
  private void d(int paramInt)
  {
    a(new d.8(this, paramInt));
  }
  
  private void d(SurfaceTexture paramSurfaceTexture)
  {
    this.f = paramSurfaceTexture;
    this.e = new Surface(paramSurfaceTexture);
    if (this.g != null)
    {
      o.d(E(), "replaceSurfaceTextureInternal, setSurface:%s", new Object[] { paramSurfaceTexture });
      this.g.a(this.e);
    }
  }
  
  private void d(com.tencent.luggage.wxa.fx.a parama)
  {
    if (this.n != null) {
      return;
    }
    this.n = this.m.a(this.i, parama);
  }
  
  /* Error */
  private void d(@Nullable String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 686	com/tencent/luggage/wxa/qz/af:c	(Ljava/lang/String;)Z
    //   4: ifne +148 -> 152
    //   7: aload_1
    //   8: ldc_w 1157
    //   11: invokevirtual 1160	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   14: ifeq +138 -> 152
    //   17: new 1162	java/net/URL
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 1164	java/net/URL:<init>	(Ljava/lang/String;)V
    //   25: invokevirtual 1168	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   28: checkcast 1170	java/net/HttpURLConnection
    //   31: astore_1
    //   32: aload_1
    //   33: astore_3
    //   34: aload_1
    //   35: invokevirtual 1173	java/net/HttpURLConnection:connect	()V
    //   38: aload_1
    //   39: astore_3
    //   40: aload_1
    //   41: invokevirtual 1176	java/net/HttpURLConnection:getResponseCode	()I
    //   44: istore_2
    //   45: aload_1
    //   46: astore_3
    //   47: aload_0
    //   48: invokespecial 262	com/tencent/luggage/wxa/gd/d:E	()Ljava/lang/String;
    //   51: ldc_w 1178
    //   54: iconst_1
    //   55: anewarray 194	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: iload_2
    //   61: invokestatic 273	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   64: aastore
    //   65: invokestatic 279	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   68: iload_2
    //   69: sipush 400
    //   72: if_icmplt +12 -> 84
    //   75: aload_1
    //   76: astore_3
    //   77: aload_0
    //   78: iconst_m1
    //   79: iload_2
    //   80: invokespecial 1180	com/tencent/luggage/wxa/gd/d:c	(II)Z
    //   83: pop
    //   84: aload_1
    //   85: ifnull +67 -> 152
    //   88: goto +48 -> 136
    //   91: astore 4
    //   93: goto +13 -> 106
    //   96: astore_1
    //   97: aconst_null
    //   98: astore_3
    //   99: goto +43 -> 142
    //   102: astore 4
    //   104: aconst_null
    //   105: astore_1
    //   106: aload_1
    //   107: astore_3
    //   108: aload_0
    //   109: invokespecial 262	com/tencent/luggage/wxa/gd/d:E	()Ljava/lang/String;
    //   112: aload 4
    //   114: ldc_w 1182
    //   117: iconst_1
    //   118: anewarray 194	java/lang/Object
    //   121: dup
    //   122: iconst_0
    //   123: aload 4
    //   125: invokevirtual 1185	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   128: aastore
    //   129: invokestatic 867	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: aload_1
    //   133: ifnull +19 -> 152
    //   136: aload_1
    //   137: invokevirtual 1188	java/net/HttpURLConnection:disconnect	()V
    //   140: return
    //   141: astore_1
    //   142: aload_3
    //   143: ifnull +7 -> 150
    //   146: aload_3
    //   147: invokevirtual 1188	java/net/HttpURLConnection:disconnect	()V
    //   150: aload_1
    //   151: athrow
    //   152: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	d
    //   0	153	1	paramString	String
    //   44	36	2	i1	int
    //   33	114	3	str	String
    //   91	1	4	localException1	Exception
    //   102	22	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   34	38	91	java/lang/Exception
    //   40	45	91	java/lang/Exception
    //   47	68	91	java/lang/Exception
    //   77	84	91	java/lang/Exception
    //   17	32	96	finally
    //   17	32	102	java/lang/Exception
    //   34	38	141	finally
    //   40	45	141	finally
    //   47	68	141	finally
    //   77	84	141	finally
    //   108	132	141	finally
  }
  
  private boolean d(int paramInt1, int paramInt2)
  {
    if (!this.y)
    {
      o.d(E(), "onMediaPlayerError, mp released");
      return false;
    }
    o.d(E(), "onError, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.luggage.wxa.ge.c localc = this.j;
    if (localc != null) {
      localc.a(paramInt1, paramInt2);
    }
    return false;
  }
  
  private void e(int paramInt)
  {
    o.d(E(), "*** handler(%s) handleWebViewBackground, type:%d", new Object[] { A(), Integer.valueOf(paramInt) });
    this.O = true;
    d.9 local9 = new d.9(this, paramInt);
    if (!a(null))
    {
      o.d(E(), "handleWebViewBackground, plugin is not ready, add to pending tasks");
      this.S.add(local9);
      return;
    }
    local9.run();
  }
  
  private void e(SurfaceTexture paramSurfaceTexture)
  {
    EGL10 localEGL10 = (EGL10)EGLContext.getEGL();
    EGLDisplay localEGLDisplay = localEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    localEGL10.eglInitialize(localEGLDisplay, null);
    Object localObject = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    int i1 = localObject.length;
    localEGL10.eglChooseConfig(localEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344 }, (EGLConfig[])localObject, i1, arrayOfInt);
    arrayOfInt = localObject[0];
    localObject = localEGL10.eglCreateContext(localEGLDisplay, arrayOfInt, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
    paramSurfaceTexture = localEGL10.eglCreateWindowSurface(localEGLDisplay, arrayOfInt, paramSurfaceTexture, new int[] { 12344 });
    localEGL10.eglMakeCurrent(localEGLDisplay, paramSurfaceTexture, paramSurfaceTexture, (EGLContext)localObject);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glClear(16384);
    localEGL10.eglSwapBuffers(localEGLDisplay, paramSurfaceTexture);
    localEGL10.eglDestroySurface(localEGLDisplay, paramSurfaceTexture);
    localEGL10.eglMakeCurrent(localEGLDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
    localEGL10.eglDestroyContext(localEGLDisplay, (EGLContext)localObject);
    localEGL10.eglTerminate(localEGLDisplay);
  }
  
  private void e(com.tencent.luggage.wxa.fx.a parama)
  {
    o.d(E(), "registerLifecycleListener");
    this.p = new d.5(this);
    parama.a(this.p);
  }
  
  private boolean e(int paramInt1, int paramInt2)
  {
    return a(new d.4(this, paramInt1, paramInt2));
  }
  
  private void f(com.tencent.luggage.wxa.fx.a parama)
  {
    this.o = parama;
    if (this.g == null)
    {
      o.c(E(), "insert, media player is null");
      p(this.o);
    }
    e(parama);
    Object localObject1 = this.m;
    if (localObject1 != null) {
      ((com.tencent.luggage.wxa.ge.b)localObject1).d(parama);
    }
    if ((this.e != null) && (this.g != null))
    {
      o.d(E(), "insert, setSurface");
      this.g.a(this.e);
    }
    localObject1 = parama.d();
    this.v = ((JSONObject)localObject1).optBoolean("autoplay", false);
    this.u = ((((JSONObject)localObject1).optDouble("initialTime", 0.0D) * 1000.0D));
    this.z = ((JSONObject)localObject1).optBoolean("loop", false);
    this.A = ((JSONObject)localObject1).optBoolean("muted", false);
    this.g.a(this.A);
    this.L = ((JSONObject)localObject1).optBoolean("autoPauseIfNavigate", true);
    this.M = ((JSONObject)localObject1).optBoolean("autoPauseIfOpenNative", true);
    this.x = ((JSONObject)localObject1).optBoolean("needEvent", false);
    Object localObject2;
    if (this.x)
    {
      localObject2 = this.h;
      if (localObject2 != null)
      {
        ((com.tencent.luggage.wxa.ge.d)localObject2).a(parama);
        localObject2 = ((JSONObject)localObject1).optString("data", "");
        this.h.a((String)localObject2);
        com.tencent.luggage.wxa.ge.a locala = this.i;
        if (locala != null)
        {
          locala.a(parama);
          this.i.a((String)localObject2);
        }
      }
    }
    if (((JSONObject)localObject1).has("position"))
    {
      localObject2 = ((JSONObject)localObject1).optJSONObject("position");
      if (localObject2 != null)
      {
        this.B = com.tencent.luggage.wxa.pc.g.c(((JSONObject)localObject2).optInt("width", 0));
        this.C = com.tencent.luggage.wxa.pc.g.c(((JSONObject)localObject2).optInt("height", 0));
        o.d(E(), "insert, size:[%d, %d]", new Object[] { Integer.valueOf(this.B), Integer.valueOf(this.C) });
      }
    }
    this.K = ((JSONObject)localObject1).optString("objectFit", "contain");
    if (af.c(this.K)) {
      this.K = "contain";
    }
    a(true);
    b(parama, (JSONObject)localObject1);
    this.J = ((JSONObject)localObject1).optString("filePath");
    if (!af.c(this.J))
    {
      localObject2 = this.m;
      if (localObject2 != null) {
        ((com.tencent.luggage.wxa.ge.b)localObject2).a(this.o, this.g, this.J);
      }
      localObject2 = a(parama, this.J);
      o.d(E(), "insert, path:%s, proxy:%s", new Object[] { this.J, localObject2 });
      if (!af.c((String)localObject2))
      {
        this.g.a((String)localObject2, this.X);
        c((String)localObject2);
        o.d(E(), "insert, media player prepare async");
        Z();
      }
    }
    this.an = ((JSONObject)localObject1).optString("title", this.an);
    this.ao = ((JSONObject)localObject1).optString("backgroundPoster", this.ao);
    a(parama, (JSONObject)localObject1);
    parama.a("ok");
  }
  
  private boolean f(int paramInt1, int paramInt2)
  {
    if (!this.y)
    {
      o.d(E(), "onMediaPlayerInfo, mp released");
      return false;
    }
    o.d(E(), "onInfo, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.luggage.wxa.ge.b localb;
    if (paramInt1 == 701)
    {
      this.s = this.g.f();
      o.d(E(), "onInfo, buffering start, isPlayingBeforeBuffering:%b", new Object[] { Boolean.valueOf(this.s) });
      if (ao()) {
        this.h.b();
      }
      localb = this.m;
      if (localb != null)
      {
        localb.c(this.o, this.g);
        return false;
      }
    }
    else if (paramInt1 == 702)
    {
      boolean bool = this.g.f();
      o.d(E(), "onInfo, buffering end, isPlayingBeforeBuffering:%b, isCurrentPlaying:%b", new Object[] { Boolean.valueOf(this.s), Boolean.valueOf(bool) });
      if (this.s)
      {
        this.s = false;
        if ((bool) && (ao()))
        {
          o.d(E(), "onInfo, buffering end, notify video play");
          this.h.a(false);
        }
      }
      else if ((!bool) && (ao()))
      {
        o.d(E(), "onInfo, buffering end, notify video pause");
        this.h.b(false);
      }
      localb = this.m;
      if (localb != null)
      {
        localb.d(this.o, this.g);
        return false;
      }
    }
    else if (paramInt1 == 3)
    {
      P();
    }
    return false;
  }
  
  private void g(com.tencent.luggage.wxa.fx.a parama)
  {
    if (this.g == null)
    {
      o.c(E(), "update, media player is null");
      parama.a("fail");
      return;
    }
    JSONObject localJSONObject = parama.d();
    boolean bool1 = localJSONObject.has("filePath");
    int i3 = 1;
    if (bool1)
    {
      localObject = localJSONObject.optString("filePath");
      if ((!af.c((String)localObject)) && (!((String)localObject).equalsIgnoreCase(this.J)))
      {
        this.J = ((String)localObject);
        localObject = a(parama, this.J);
        o.d(E(), "update, path:%s, proxy:%s", new Object[] { this.J, localObject });
        if ((this.g == null) || (!af.c((String)localObject)))
        {
          this.N = false;
          ab();
          o(parama);
        }
        com.tencent.luggage.wxa.ge.b localb = this.m;
        if (localb != null) {
          localb.a(this.o, this.g, this.J);
        }
        this.g.a((String)localObject, this.X);
        c((String)localObject);
        i2 = 1;
        break label215;
      }
    }
    int i2 = 0;
    label215:
    if ((this.e != null) && (this.g != null))
    {
      boolean bool2 = this.am.get();
      if ((!this.O) && (!bool2))
      {
        o.d(E(), "update, setSurface");
        this.g.a(this.e);
      }
      else
      {
        localObject = E();
        boolean bool3 = this.O;
        if (this.Y != null) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        o.d((String)localObject, "update, setSurface, WebViewInBackground: %b, JustPlayAudio: %b, SurfacePipSet exist: %b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if (this.O)
        {
          localObject = this.Y;
          if (localObject != null) {
            this.g.a((Surface)localObject);
          }
        }
      }
    }
    if (localJSONObject.has("autoplay")) {
      this.v = localJSONObject.optBoolean("autoplay", this.v);
    }
    if (localJSONObject.has("initialTime")) {
      this.u = ((localJSONObject.optDouble("initialTime", 0.0D) * 1000.0D));
    }
    if (localJSONObject.has("loop")) {
      this.z = localJSONObject.optBoolean("loop", this.z);
    }
    if (localJSONObject.has("muted"))
    {
      this.A = localJSONObject.optBoolean("muted", this.A);
      this.g.a(this.A);
    }
    if (localJSONObject.has("autoPauseIfNavigate")) {
      this.L = localJSONObject.optBoolean("autoPauseIfNavigate", this.L);
    }
    if (localJSONObject.has("autoPauseIfOpenNative")) {
      this.M = localJSONObject.optBoolean("autoPauseIfOpenNative", this.M);
    }
    if (localJSONObject.has("needEvent")) {
      this.x = localJSONObject.optBoolean("needEvent", this.x);
    }
    if (this.x)
    {
      localObject = this.h;
      if (localObject != null)
      {
        ((com.tencent.luggage.wxa.ge.d)localObject).a(parama);
        localObject = localJSONObject.optString("data", "");
        if (localJSONObject.has("data")) {
          this.h.a((String)localObject);
        }
        if (this.i != null)
        {
          if (localJSONObject.has("data")) {
            this.i.a((String)localObject);
          }
          this.i.a(parama);
        }
      }
    }
    int i1;
    if (localJSONObject.has("position"))
    {
      localObject = localJSONObject.optJSONObject("position");
      if (localObject != null)
      {
        i1 = this.B;
        int i4 = this.C;
        this.B = com.tencent.luggage.wxa.pc.g.c(((JSONObject)localObject).optInt("width", i1));
        this.C = com.tencent.luggage.wxa.pc.g.c(((JSONObject)localObject).optInt("height", i4));
        o.d(E(), "update, size:[%d, %d]", new Object[] { Integer.valueOf(this.B), Integer.valueOf(this.C) });
        if ((this.B != i1) || (this.C != i4))
        {
          bool1 = true;
          break label803;
        }
      }
      bool1 = false;
      label803:
      i1 = 1;
    }
    else
    {
      bool1 = false;
      i1 = 0;
    }
    if (localJSONObject.has("objectFit"))
    {
      localObject = this.K;
      this.K = localJSONObject.optString("objectFit", (String)localObject);
      if (af.c(this.K)) {
        this.K = "contain";
      }
      i1 = i3;
      if (!this.K.equals(localObject))
      {
        bool1 = false;
        i1 = i3;
      }
    }
    if (i1 != 0) {
      a(bool1);
    }
    a(parama, localJSONObject);
    Object localObject = localJSONObject.optString("filePath");
    if ((this.n != null) && (this.n.f())) {
      this.n.b((String)localObject);
    }
    this.an = localJSONObject.optString("title", this.an);
    this.ao = localJSONObject.optString("backgroundPoster", this.ao);
    if (i2 != 0)
    {
      o.d(E(), "update, media player prepare async");
      Z();
    }
    parama.a("ok");
  }
  
  private void h(com.tencent.luggage.wxa.fx.a parama)
  {
    Object localObject = this.g;
    String str = "fail";
    if (localObject == null)
    {
      o.c(E(), "operateBackground, media player is null");
      parama.a("fail");
      return;
    }
    localObject = parama.d().optString("type");
    if (!af.c((String)localObject))
    {
      o.d(E(), "operateBackground, type:%s", new Object[] { localObject });
      boolean bool1;
      if (((String)localObject).equalsIgnoreCase("stop"))
      {
        boolean bool2 = r(parama);
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if (this.Q)
          {
            o.d(E(), "operateBackground, isRuntimeInBackground, setPlayingWhenEnterBackground false");
            a(new AtomicBoolean(false));
            bool1 = bool2;
          }
        }
      }
      else
      {
        bool1 = false;
      }
      if (bool1) {
        str = "ok";
      }
      parama.a(str);
    }
  }
  
  private void i(com.tencent.luggage.wxa.fx.a parama)
  {
    Object localObject = this.g;
    String str1 = "fail";
    if (localObject == null)
    {
      o.c(E(), "operate, media player is null");
      parama.a("fail");
      return;
    }
    JSONObject localJSONObject = parama.d();
    localObject = localJSONObject.optString("type");
    if (!af.c((String)localObject))
    {
      String str2 = E();
      boolean bool = false;
      o.d(str2, "operate, type:%s", new Object[] { localObject });
      if (b((String)localObject))
      {
        o.d(E(), "video cast operate, type:%s", new Object[] { localObject });
        if (this.n == null) {
          d(parama);
        }
        this.n.a(this.J);
        this.n.a(m());
        if (((String)localObject).equalsIgnoreCase("requestFullScreen")) {
          bool = k(parama);
        } else if (((String)localObject).equalsIgnoreCase("exitFullScreen")) {
          bool = l(parama);
        } else {
          bool = this.n.a(localJSONObject, parama);
        }
      }
      else if (((String)localObject).equalsIgnoreCase("play"))
      {
        bool = c(false);
      }
      else if (((String)localObject).equalsIgnoreCase("pause"))
      {
        bool = aa();
      }
      else if (((String)localObject).equalsIgnoreCase("stop"))
      {
        bool = ab();
        if ((bool) && (this.Q))
        {
          o.d(E(), "stop, isRuntimeInBackground, setPlayingWhenEnterBackground false");
          a(new AtomicBoolean(false));
        }
      }
      else if (((String)localObject).equalsIgnoreCase("seek"))
      {
        bool = b(localJSONObject);
      }
      else if (((String)localObject).equalsIgnoreCase("playbackRate"))
      {
        bool = c(localJSONObject);
      }
      else if (((String)localObject).equalsIgnoreCase("requestFullScreen"))
      {
        bool = k(parama);
      }
      else if (((String)localObject).equalsIgnoreCase("exitFullScreen"))
      {
        bool = l(parama);
      }
      else if (((String)localObject).equalsIgnoreCase("setScreenBrightness"))
      {
        bool = m(parama);
      }
      else if (((String)localObject).equalsIgnoreCase("exitPictureInPicture"))
      {
        bool = this.ad.b(parama);
      }
      else if (((String)localObject).equalsIgnoreCase("requestBackgroundPlayback"))
      {
        bool = q(parama);
      }
      else if (((String)localObject).equalsIgnoreCase("exitBackgroundPlayback"))
      {
        bool = r(parama);
      }
      if (((String)localObject).equalsIgnoreCase("snapshot"))
      {
        n(parama);
      }
      else
      {
        if (bool) {
          str1 = "ok";
        }
        parama.a(str1);
      }
      if ((((String)localObject).equalsIgnoreCase("pause")) || (((String)localObject).equalsIgnoreCase("stop"))) {
        this.ad.a(parama);
      }
    }
  }
  
  private void j(com.tencent.luggage.wxa.fx.a parama)
  {
    ac();
    parama.a("ok");
    this.ad.a(parama);
  }
  
  private boolean k(com.tencent.luggage.wxa.fx.a parama)
  {
    o.d(E(), "requestFullscreen");
    com.tencent.luggage.wxa.ge.b localb = this.m;
    return (localb != null) && (localb.a(parama));
  }
  
  private boolean l(com.tencent.luggage.wxa.fx.a parama)
  {
    o.d(E(), "exitFullscreen");
    com.tencent.luggage.wxa.ge.b localb = this.m;
    return (localb != null) && (localb.b(parama));
  }
  
  private boolean m(com.tencent.luggage.wxa.fx.a parama)
  {
    o.d(E(), "setScreenBrightness");
    com.tencent.luggage.wxa.ge.b localb = this.m;
    return (localb != null) && (localb.c(parama));
  }
  
  private void n(com.tencent.luggage.wxa.fx.a parama)
  {
    o.d(E(), "getSnapshotCached");
    if (this.m == null)
    {
      parama.a("fail:snapshot error");
      return;
    }
    this.V = parama;
    aj();
  }
  
  private void o(com.tencent.luggage.wxa.fx.a parama)
  {
    ak();
    p(parama);
    al();
  }
  
  private void p(com.tencent.luggage.wxa.fx.a parama)
  {
    o.d(E(), "createMediaPlayer");
    com.tencent.luggage.wxa.ge.b localb = this.m;
    if (localb != null) {
      this.g = localb.a(parama, this.T);
    }
    parama = this.g;
    if (parama == null)
    {
      o.b(E(), "createMediaPlayer, create media player fail");
      return;
    }
    this.y = true;
    parama.a(new d.17(this));
    this.g.a(new d.18(this));
    this.g.a(new d.19(this));
    this.g.a(new d.20(this));
    this.g.a(new d.21(this));
    this.g.a(new d.22(this));
    this.g.a(new d.24(this));
    parama = this.ae;
    if (parama != null) {
      parama.a(this.w);
    }
  }
  
  private boolean q(com.tencent.luggage.wxa.fx.a parama)
  {
    o.e(E(), "enableBackgroundPlayAudio");
    if (!this.aj)
    {
      ar();
      as();
      at();
      au();
      this.aj = true;
    }
    if (s(parama))
    {
      this.am.set(true);
      parama = this.g;
      if (parama != null) {
        parama.a(null);
      }
      this.ak = true;
      parama = this.h;
      if (parama != null) {
        parama.c(true);
      }
      return true;
    }
    return false;
  }
  
  private boolean r(com.tencent.luggage.wxa.fx.a parama)
  {
    o.e(E(), "disableBackgroundPlayAudio");
    if (t(parama))
    {
      this.am.set(false);
      o.e(E(), "disableBackgroundPlayAudio, hasEndedPlaying: %b, videoLooping: %b", new Object[] { Boolean.valueOf(this.N), Boolean.valueOf(this.z) });
      if ((this.g != null) && ((!this.N) || (this.z))) {
        this.g.a(this.e);
      }
      this.ak = false;
      parama = this.h;
      if (parama != null) {
        parama.c(false);
      }
      return true;
    }
    return false;
  }
  
  private boolean s(com.tencent.luggage.wxa.fx.a parama)
  {
    o.e(E(), "enableBackgroundPlayAudioInternal");
    if (parama == null)
    {
      o.c(E(), "enableBackgroundPlayAudioInternal, invokeContext is null");
      return false;
    }
    parama = com.tencent.luggage.wxa.fy.e.a(parama);
    if (parama == null)
    {
      o.c(E(), "enableBackgroundPlayAudioInternal, audioOfVideoBackgroundPlayManager is null");
      return false;
    }
    return parama.a(this, true);
  }
  
  private boolean t(com.tencent.luggage.wxa.fx.a parama)
  {
    o.e(E(), "disableBackgroundPlayAudioInternal");
    if (parama == null)
    {
      o.c(E(), "disableBackgroundPlayAudioInternal, invokeContext is null");
      return false;
    }
    parama = com.tencent.luggage.wxa.fy.e.a(parama);
    if (parama == null)
    {
      o.c(E(), "disableBackgroundPlayAudio, audioOfVideoBackgroundPlayManager is null");
      return false;
    }
    parama.b(this);
    return true;
  }
  
  @Nullable
  public <AddOn extends j> AddOn a(@NonNull Class<AddOn> paramClass)
  {
    String str = E();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getAddOn for ");
    localStringBuilder.append(paramClass.getSimpleName());
    o.d(str, localStringBuilder.toString());
    return this.al.a(paramClass);
  }
  
  @NonNull
  public String a()
  {
    return p();
  }
  
  public void a(@Nullable Bitmap paramBitmap)
  {
    super.a(paramBitmap);
    o.d(E(), "*** handler(%s) handlePluginScreenshotTaken", new Object[] { A() });
    if (!b(paramBitmap)) {
      c(paramBitmap);
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    a(new d.1(this, paramSurfaceTexture));
  }
  
  public void a(@Nullable com.tencent.luggage.wxa.fy.s params)
  {
    this.ag = params;
    com.tencent.luggage.wxa.ge.d locald = this.h;
    if (locald != null) {
      locald.a(params);
    }
  }
  
  public void a(@Nullable a parama)
  {
    this.af = parama;
    parama = this.h;
    if (parama != null) {
      parama.a(this.af);
    }
  }
  
  public void a(@Nullable d.a parama)
  {
    this.Z = parama;
  }
  
  public void a(@Nullable d.b paramb)
  {
    this.ae = paramb;
    if ((paramb != null) && (this.g != null)) {
      paramb.a(this.w);
    }
  }
  
  public void a(com.tencent.luggage.wxa.ge.b paramb)
  {
    this.m = paramb;
    paramb = this.m;
    if (paramb != null)
    {
      paramb.a(this);
      this.l = this.m.a();
      this.k = this.m.b();
      this.i = this.m.e();
      this.h = this.m.d();
      this.h.a(this);
      this.h.a(this.af);
      this.h.a(this.ag);
      this.j = this.m.c();
      this.j.a(new d.35(this));
    }
  }
  
  public <AddOn extends j> void a(@NonNull Class<AddOn> paramClass, @Nullable AddOn paramAddOn)
  {
    String str = E();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAddOn for ");
    localStringBuilder.append(paramClass.getSimpleName());
    o.d(str, localStringBuilder.toString());
    this.al.a(paramClass, paramAddOn);
  }
  
  public void a(AtomicBoolean paramAtomicBoolean)
  {
    this.R = paramAtomicBoolean;
  }
  
  public void a(@NonNull JSONObject paramJSONObject)
  {
    this.D = com.tencent.luggage.wxa.pc.g.c(paramJSONObject.optInt("x", this.D));
    this.E = com.tencent.luggage.wxa.pc.g.c(paramJSONObject.optInt("y", this.E));
    o.e(E(), "updateVideoPosition, mPosX: %d, mPosY: %d", new Object[] { Integer.valueOf(this.D), Integer.valueOf(this.E) });
  }
  
  public boolean a(@Nullable Surface paramSurface)
  {
    if (this.g != null)
    {
      if (!this.am.get()) {
        this.g.a(paramSurface);
      } else {
        o.d(E(), "setSurface, JustPlayAudio");
      }
      if (this.e == paramSurface) {
        this.Y = null;
      } else {
        this.Y = paramSurface;
      }
      paramSurface = E();
      boolean bool;
      if (this.Y != null) {
        bool = true;
      } else {
        bool = false;
      }
      o.d(paramSurface, "setSurface, SurfacePipSet exist: %b", new Object[] { Boolean.valueOf(bool) });
      return true;
    }
    o.c(E(), "setSurface, MediaPlayer is null");
    return false;
  }
  
  public boolean a(com.tencent.luggage.wxa.fx.a parama)
  {
    return true;
  }
  
  public String b(com.tencent.luggage.wxa.fx.a parama)
  {
    a(new d.34(this, parama));
    return null;
  }
  
  public AtomicBoolean b()
  {
    return this.R;
  }
  
  public void b(SurfaceTexture paramSurfaceTexture)
  {
    a(new d.12(this, paramSurfaceTexture));
  }
  
  public boolean c()
  {
    AtomicBoolean localAtomicBoolean = this.R;
    return (localAtomicBoolean != null) && (localAtomicBoolean.get());
  }
  
  public void d()
  {
    a(new d.23(this));
  }
  
  public void e()
  {
    a(new d.11(this));
  }
  
  public void f()
  {
    a(new d.13(this));
  }
  
  public float g()
  {
    return this.ah;
  }
  
  public float h()
  {
    return this.ai;
  }
  
  public void i()
  {
    a(new d.14(this));
  }
  
  public void j()
  {
    a(new d.15(this));
  }
  
  public void k()
  {
    a(new d.16(this));
  }
  
  public boolean l()
  {
    com.tencent.luggage.wxa.mi.b localb = this.g;
    if (localb != null) {
      return localb.f();
    }
    return false;
  }
  
  public int m()
  {
    com.tencent.luggage.wxa.mi.b localb = this.g;
    if (localb != null) {
      return localb.h();
    }
    return 0;
  }
  
  public com.tencent.luggage.wxa.ge.d n()
  {
    return this.h;
  }
  
  public com.tencent.luggage.wxa.ge.e o()
  {
    return this.k;
  }
  
  public String p()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(A());
    localStringBuilder.append("@");
    localStringBuilder.append(hashCode());
    return localStringBuilder.toString();
  }
  
  @Nullable
  public Integer q()
  {
    Object localObject = this.o;
    if (localObject == null)
    {
      o.c(E(), "getOriginPageViewId, invokeContext is null");
      return null;
    }
    localObject = com.tencent.luggage.wxa.fy.b.d((com.tencent.luggage.wxa.fx.a)localObject);
    if (localObject == null)
    {
      o.c(E(), "getOriginPageViewId, pageView is null");
      return null;
    }
    return Integer.valueOf(localObject.hashCode());
  }
  
  public com.tencent.luggage.wxa.mi.b r()
  {
    return this.g;
  }
  
  public SurfaceTexture s()
  {
    return this.f;
  }
  
  public Surface t()
  {
    return this.e;
  }
  
  public int u()
  {
    int i1 = (int)(this.ah * this.B);
    String str = E();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getVideoContainerWidth, videoContainerWidth: ");
    localStringBuilder.append(i1);
    o.e(str, localStringBuilder.toString());
    return i1;
  }
  
  public int v()
  {
    int i1 = (int)(this.ai * this.C);
    String str = E();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getVideoContainerHeight, videoContainerHeight: ");
    localStringBuilder.append(i1);
    o.e(str, localStringBuilder.toString());
    return i1;
  }
  
  public int w()
  {
    int i1 = (int)(this.D + (1.0F - this.ah) * this.B / 2.0F);
    String str = E();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getVideoPositionX, videoPosX: ");
    localStringBuilder.append(i1);
    o.e(str, localStringBuilder.toString());
    return i1;
  }
  
  public int x()
  {
    int i1 = (int)(this.E + (1.0F - this.ai) * this.C / 2.0F);
    String str = E();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getVideoPositionY, videoPosY: ");
    localStringBuilder.append(i1);
    o.e(str, localStringBuilder.toString());
    return i1;
  }
  
  public boolean y()
  {
    return this.ak;
  }
  
  public boolean z()
  {
    return this.am.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gd.d
 * JD-Core Version:    0.7.0.1
 */