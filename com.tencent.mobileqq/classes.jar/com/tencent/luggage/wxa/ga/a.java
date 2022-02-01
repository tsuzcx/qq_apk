package com.tencent.luggage.wxa.ga;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.fx.a.a;
import com.tencent.luggage.wxa.fy.i;
import com.tencent.luggage.wxa.fy.k;
import com.tencent.luggage.wxa.fy.l;
import com.tencent.luggage.wxa.fy.m;
import com.tencent.luggage.wxa.fy.n;
import com.tencent.luggage.wxa.fy.t;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.rtmp.TXLiveBase;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends com.tencent.luggage.wxa.gf.a
  implements i, com.tencent.luggage.wxa.fy.o
{
  private com.tencent.luggage.wxa.jx.s A = new a.5(this);
  private com.tencent.luggage.wxa.fy.a B = new a.6(this, this, this.A);
  private com.tencent.luggage.wxa.fy.b<d> C = new a.7(this);
  private String D = "";
  @Nullable
  private com.tencent.luggage.wxa.fy.s E = null;
  private int F = -1;
  private volatile boolean G = false;
  private boolean H = false;
  private boolean I = false;
  private boolean J = false;
  private i K = new com.tencent.luggage.wxa.fy.r();
  private AtomicBoolean L = new AtomicBoolean(false);
  @Nullable
  private volatile String M = null;
  @Nullable
  private volatile String N = null;
  @Nullable
  private volatile com.tencent.luggage.wxa.fy.g O = null;
  @Nullable
  private volatile Bitmap P = null;
  private Surface e;
  private SurfaceTexture f;
  @Nullable
  private b g;
  private com.tencent.luggage.wxa.gb.c h;
  private com.tencent.luggage.wxa.gb.b i;
  private com.tencent.luggage.wxa.gb.a j;
  private com.tencent.luggage.wxa.fx.a k;
  private a.a l;
  private int m;
  private int n;
  private int o = 0;
  private int p = 0;
  private boolean q;
  private boolean r;
  private boolean s;
  @Nullable
  private com.tencent.luggage.wxa.lr.c t = null;
  @Nullable
  private String u = null;
  private Handler v;
  private HandlerThread w = com.tencent.luggage.wxa.sc.d.b(String.format("LivePlayerThread_%s", new Object[] { Long.valueOf(System.currentTimeMillis()) }), 5);
  private boolean x = false;
  private volatile boolean y = false;
  private AtomicBoolean z = null;
  
  public a()
  {
    this.w.start();
    this.v = new Handler(this.w.getLooper());
    com.tencent.luggage.wxa.fz.b.a();
    u();
  }
  
  private void E()
  {
    Handler localHandler = this.v;
    if (localHandler != null) {
      localHandler.post(new a.23(this));
    }
  }
  
  private void F()
  {
    com.tencent.luggage.wxa.qz.o.d(t(), "*** handler(%s) handleWebViewDestroy", new Object[] { A() });
    H();
  }
  
  private void G()
  {
    this.x = false;
    if ((!this.y) && (c() != null))
    {
      boolean bool = c().get();
      a(null);
      if (bool)
      {
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.SameLayer.LivePlayerPluginHandler", "onRuntimeEnterForeground, isPlayingWhenEnterBackground, try resume");
        b localb = this.g;
        if (localb == null)
        {
          com.tencent.luggage.wxa.qz.o.c(t(), "onRuntimeEnterForeground, adapter is null");
          return;
        }
        localb.d();
      }
    }
  }
  
  private void H()
  {
    Object localObject = this.j;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.gb.a)localObject).c(this.k);
    }
    localObject = this.g;
    if (localObject != null)
    {
      ((b)localObject).a();
      this.g = null;
    }
    I();
    x();
    J();
  }
  
  private void I()
  {
    Surface localSurface = this.e;
    if (localSurface != null)
    {
      localSurface.release();
      this.e = null;
    }
  }
  
  private void J()
  {
    com.tencent.luggage.wxa.qz.o.d(t(), "LivePlayer release handler thread");
    Object localObject = this.v;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.w;
    if (localObject != null) {
      ((HandlerThread)localObject).quitSafely();
    }
  }
  
  private boolean K()
  {
    return this.i != null;
  }
  
  private boolean L()
  {
    return this.C.c(this.k);
  }
  
  private boolean M()
  {
    Object localObject = this.k;
    if (localObject == null)
    {
      com.tencent.luggage.wxa.qz.o.c(t(), "amIBackgroundAudioPlayer, mInsertInvokeContext is null");
      return false;
    }
    localObject = com.tencent.luggage.wxa.fy.e.a((com.tencent.luggage.wxa.fx.a)localObject);
    if (localObject == null)
    {
      com.tencent.luggage.wxa.qz.o.c(t(), "amIBackgroundAudioPlayer, audioOfVideoBackgroundPlayManager is null");
      return false;
    }
    return ((com.tencent.luggage.wxa.mu.a)localObject).a(this);
  }
  
  private void N()
  {
    com.tencent.luggage.wxa.qz.o.e(t(), "registerAddOnPlayAudio");
    a(m.class, new a.10(this));
  }
  
  private void O()
  {
    com.tencent.luggage.wxa.qz.o.e(t(), "registerAddOnVideoController");
    a(n.class, new a.12(this));
  }
  
  private void P()
  {
    com.tencent.luggage.wxa.qz.o.e(t(), "registerAddOnInfo");
    a(l.class, new a.13(this));
  }
  
  private void Q()
  {
    com.tencent.luggage.wxa.qz.o.e(t(), "registerAddOnGetSnapshot");
    a(k.class, new a.16(this));
  }
  
  private void a(com.tencent.luggage.wxa.fx.a parama, JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("needEvent"))
    {
      this.q = paramJSONObject.optBoolean("needEvent", false);
      if (K()) {
        this.i.a(parama);
      }
    }
  }
  
  private void a(@NonNull com.tencent.luggage.wxa.fy.g paramg)
  {
    com.tencent.luggage.wxa.qz.o.d(t(), "getSnapshotAsync");
    b localb = this.g;
    if (localb == null)
    {
      com.tencent.luggage.wxa.qz.o.c(t(), "getSnapshotAsync, mAdapter is null");
      paramg.a(null);
      return;
    }
    this.O = paramg;
    localb.a(true, new a.14(this));
  }
  
  private void a(@NonNull Runnable paramRunnable)
  {
    a(new a.15(this, paramRunnable));
  }
  
  private void b(SurfaceTexture paramSurfaceTexture)
  {
    super.a(paramSurfaceTexture);
    com.tencent.luggage.wxa.qz.o.d(t(), "*** handler(%s) handlePluginReady", new Object[] { A() });
    this.f = paramSurfaceTexture;
    this.e = new Surface(paramSurfaceTexture);
    if (this.g != null)
    {
      if (!this.L.get()) {
        this.g.a(this.e);
      } else {
        com.tencent.luggage.wxa.qz.o.d(t(), "setSurface, JustPlayAudio");
      }
      w();
    }
  }
  
  private void b(@NonNull com.tencent.luggage.wxa.fx.a parama, @NonNull JSONObject paramJSONObject)
  {
    parama = parama.g();
    if (parama == null)
    {
      com.tencent.luggage.wxa.qz.o.c(t(), "updateReferrers, component is null");
      return;
    }
    com.tencent.luggage.wxa.lr.a locala = (com.tencent.luggage.wxa.lr.a)com.tencent.luggage.wxa.ba.e.a(com.tencent.luggage.wxa.lr.a.class);
    if (locala == null)
    {
      com.tencent.luggage.wxa.qz.o.c(t(), "updateReferrers, referrerHelper is null");
      return;
    }
    if (this.t == null) {
      this.t = locala.a();
    }
    paramJSONObject = locala.a(paramJSONObject, parama);
    if (paramJSONObject != null) {
      this.t = paramJSONObject;
    }
    paramJSONObject = t();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateReferrers, mReferrerPolicy: ");
    localStringBuilder.append(this.t);
    com.tencent.luggage.wxa.qz.o.d(paramJSONObject, localStringBuilder.toString());
    if (com.tencent.luggage.wxa.lr.c.b == this.t)
    {
      this.u = null;
      return;
    }
    this.u = locala.b(parama);
    parama = t();
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("updateReferrers, mReferrer: ");
    paramJSONObject.append(this.u);
    com.tencent.luggage.wxa.qz.o.d(parama, paramJSONObject.toString());
  }
  
  private void b(String paramString)
  {
    Handler localHandler = this.v;
    if (localHandler != null) {
      localHandler.post(new a.9(this, paramString));
    }
  }
  
  private void b(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("position"))
    {
      paramJSONObject = paramJSONObject.optJSONObject("position");
      if (paramJSONObject != null)
      {
        this.m = com.tencent.luggage.wxa.pc.g.c(paramJSONObject.optInt("width", 0));
        this.n = com.tencent.luggage.wxa.pc.g.c(paramJSONObject.optInt("height", 0));
        com.tencent.luggage.wxa.qz.o.d(t(), "parseHtmlPosition, size:[%d, %d]", new Object[] { Integer.valueOf(this.m), Integer.valueOf(this.n) });
        w();
      }
    }
  }
  
  private void c(int paramInt)
  {
    Handler localHandler = this.v;
    if (localHandler != null) {
      localHandler.post(new a.22(this, paramInt));
    }
  }
  
  private void c(com.tencent.luggage.wxa.fx.a parama)
  {
    String str = parama.e();
    if (af.c(str)) {
      return;
    }
    JSONObject localJSONObject = parama.d();
    com.tencent.luggage.wxa.qz.o.d(t(), "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { A(), str, localJSONObject.toString() });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleJsApi:");
    localStringBuilder.append(str);
    localStringBuilder.append(", data:");
    localStringBuilder.append(localJSONObject);
    Log.i("TXLivePlayerAdapter", localStringBuilder.toString());
    if (str.contains("insert"))
    {
      f(1);
      d(parama);
    }
    else if (str.contains("update"))
    {
      f(2);
      e(parama);
    }
    else if ((str.contains("operate")) && (str.contains("Background")))
    {
      f(parama);
    }
    else if (str.contains("operate"))
    {
      f(3);
      g(parama);
    }
    else if (str.contains("remove"))
    {
      f(4);
      h(parama);
      this.C.a(parama);
    }
    this.B.a(str, parama);
    o(parama);
    p(parama);
    this.C.a(parama, this.D);
  }
  
  private void c(String paramString)
  {
    if (paramString.equalsIgnoreCase("pause"))
    {
      paramString = this.E;
      if (paramString != null) {
        paramString.c();
      } else {
        this.F = 4;
      }
      paramString = this.j;
      if (paramString != null) {
        paramString.a(B(), 2006, null);
      }
    }
    else if (paramString.equalsIgnoreCase("stop"))
    {
      paramString = this.E;
      if (paramString != null) {
        paramString.e();
      } else {
        this.F = 6;
      }
      paramString = this.j;
      if (paramString != null) {
        paramString.a(B(), 2006, null);
      }
    }
  }
  
  private void d(int paramInt)
  {
    com.tencent.luggage.wxa.qz.o.d(t(), "*** handler(%s) handleWebViewBackground, type:%d", new Object[] { A(), Integer.valueOf(paramInt) });
    this.y = true;
    if (!a(null))
    {
      com.tencent.luggage.wxa.qz.o.d(t(), "plugin is not ready");
      return;
    }
    com.tencent.luggage.wxa.qz.o.d(t(), "handleWebViewBackground, type:%s, autoPauseIfNative:%s, autoPauseIfNavigate:%s, isRuntimeInBackground:%s, isPlayingWhenEnterBackground:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.s), Boolean.valueOf(this.r), Boolean.valueOf(this.x), c() });
    Object localObject = this.j;
    if ((localObject != null) && (((com.tencent.luggage.wxa.gb.a)localObject).a(this, this.k, paramInt)))
    {
      com.tencent.luggage.wxa.qz.o.d(t(), "handleWebViewBackground, should intercept enter background, return");
      return;
    }
    if (paramInt == 4)
    {
      localObject = this.g;
      if (localObject == null) {
        com.tencent.luggage.wxa.qz.o.c(t(), "handleWebViewBackground, adapter is null 0");
      } else {
        ((b)localObject).c();
      }
    }
    if (((paramInt == 2) && (!this.s)) || ((paramInt == 1) && (!this.r) && (!this.x)))
    {
      if ((c() != null) && (c().get()))
      {
        com.tencent.luggage.wxa.qz.o.d(t(), "handleWebViewBackground, live player not auto pause, try resume, type:%s", new Object[] { Integer.valueOf(paramInt) });
        localObject = this.g;
        if (localObject == null)
        {
          com.tencent.luggage.wxa.qz.o.c(t(), "handleWebViewBackground, adapter is null 1");
          return;
        }
        ((b)localObject).d();
        return;
      }
      com.tencent.luggage.wxa.qz.o.d(t(), "handleWebViewBackground, live player not auto pause, ignore resume, type:%s", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    if ((this.g != null) && (c() == null))
    {
      boolean bool = this.g.e();
      a(new AtomicBoolean(bool));
      if ((this.J) && (1 != paramInt) && (M()))
      {
        com.tencent.luggage.wxa.qz.o.d(t(), "handleWebViewBackground runnable, background play audio is enabled, do not pause");
        return;
      }
      if (L())
      {
        com.tencent.luggage.wxa.qz.o.d(t(), "handleWebViewBackground runnable, i am pip player, do not pause");
        return;
      }
      localObject = this.g.b();
      if (bool) {
        c("pause");
      }
      com.tencent.luggage.wxa.qz.o.d(t(), "handleWebViewBackground, isPlayingWhenEnterBackground:%s, code:%d info:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(((com.tencent.luggage.wxa.fz.a)localObject).a), ((com.tencent.luggage.wxa.fz.a)localObject).b });
    }
  }
  
  private void d(com.tencent.luggage.wxa.fx.a parama)
  {
    Object localObject3 = parama.d();
    if (((JSONObject)localObject3).optInt("mode", 0) == 2)
    {
      this.H = true;
      if (i(parama)) {}
    }
    else
    {
      this.H = false;
    }
    TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[] { parama.a() }));
    this.k = parama;
    Object localObject1 = parama.g();
    if ((localObject1 instanceof u)) {
      this.y = (((u)localObject1).R() ^ true);
    } else {
      com.tencent.luggage.wxa.qz.o.c(t(), "insert, component is not AppBrandPageView");
    }
    j(parama);
    localObject1 = this.j;
    if (localObject1 != null) {
      ((com.tencent.luggage.wxa.gb.a)localObject1).d(parama);
    }
    a(parama, (JSONObject)localObject3);
    b((JSONObject)localObject3);
    this.r = ((JSONObject)localObject3).optBoolean("autoPauseIfNavigate", true);
    this.s = ((JSONObject)localObject3).optBoolean("autoPauseIfOpenNative", true);
    this.M = ((JSONObject)localObject3).optString("title", this.M);
    this.N = ((JSONObject)localObject3).optString("backgroundPoster", this.N);
    b(parama, (JSONObject)localObject3);
    localObject1 = this.u;
    StringBuilder localStringBuilder;
    if (localObject1 != null) {
      try
      {
        ((JSONObject)localObject3).put("referrer", localObject1);
      }
      catch (JSONException localJSONException1)
      {
        localObject4 = t();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("insert, put referrer fail since ");
        localStringBuilder.append(localJSONException1.toString());
        com.tencent.luggage.wxa.qz.o.c((String)localObject4, localStringBuilder.toString());
      }
    }
    if ((this.y) && (!L()))
    {
      com.tencent.luggage.wxa.qz.o.d(t(), "insert, webView in background");
      try
      {
        ((JSONObject)localObject3).put("canStartPlay", false);
      }
      catch (JSONException localJSONException2)
      {
        localObject4 = t();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("insert, put isInForeground fail since ");
        localStringBuilder.append(localJSONException2.toString());
        com.tencent.luggage.wxa.qz.o.c((String)localObject4, localStringBuilder.toString());
      }
      a(new AtomicBoolean(((JSONObject)localObject3).optBoolean("autoplay", false)));
    }
    Object localObject4 = this.g;
    Object localObject2 = "fail";
    if (localObject4 == null)
    {
      com.tencent.luggage.wxa.qz.o.c(t(), "insert, adapter is null");
      parama.a("fail");
      return;
    }
    localObject3 = com.tencent.luggage.wxa.fz.c.a((JSONObject)localObject3);
    localObject4 = this.g.a((Bundle)localObject3);
    com.tencent.luggage.wxa.qz.o.d(t(), "insert, code:%d info:%s", new Object[] { Integer.valueOf(((com.tencent.luggage.wxa.fz.a)localObject4).a), ((com.tencent.luggage.wxa.fz.a)localObject4).b });
    if (((com.tencent.luggage.wxa.fz.a)localObject4).a == 0) {
      localObject2 = "ok";
    }
    parama.a((String)localObject2);
    if (((com.tencent.luggage.wxa.fz.a)localObject4).a == 0)
    {
      localObject2 = this.j;
      if (localObject2 != null) {
        ((com.tencent.luggage.wxa.gb.a)localObject2).a(parama, (Bundle)localObject3);
      }
    }
  }
  
  private void e(int paramInt)
  {
    this.x = true;
    if ((this.g != null) && (c() == null))
    {
      boolean bool = this.g.e();
      a(new AtomicBoolean(bool));
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.SameLayer.LivePlayerPluginHandler", "onRuntimeEnterBackground, isPlayingWhenEnterBackground:%s", new Object[] { Boolean.valueOf(bool) });
      if ((this.J) && (M()))
      {
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.SameLayer.LivePlayerPluginHandler", "onRuntimeEnterBackground, background play audio is enabled");
        return;
      }
      com.tencent.luggage.wxa.gb.a locala = this.j;
      if ((locala != null) && (locala.a(this, this.k, paramInt)))
      {
        com.tencent.luggage.wxa.qz.o.d(t(), "onRuntimeEnterBackground, should intercept enter background, return");
        return;
      }
      this.g.b();
      if (bool) {
        c("pause");
      }
    }
  }
  
  private void e(com.tencent.luggage.wxa.fx.a parama)
  {
    Object localObject2 = parama.d();
    if (((JSONObject)localObject2).has("autoPauseIfNavigate")) {
      this.r = ((JSONObject)localObject2).optBoolean("autoPauseIfNavigate", true);
    }
    if (((JSONObject)localObject2).has("autoPauseIfOpenNative")) {
      this.s = ((JSONObject)localObject2).optBoolean("autoPauseIfOpenNative", true);
    }
    Object localObject1 = this.j;
    if (localObject1 != null) {
      ((com.tencent.luggage.wxa.gb.a)localObject1).d(parama);
    }
    a(parama, (JSONObject)localObject2);
    b((JSONObject)localObject2);
    this.M = ((JSONObject)localObject2).optString("title", this.M);
    this.N = ((JSONObject)localObject2).optString("backgroundPoster", this.N);
    Object localObject3 = this.g;
    localObject1 = "fail";
    if (localObject3 == null)
    {
      com.tencent.luggage.wxa.qz.o.c(t(), "update, adapter is null");
      parama.a("fail");
      return;
    }
    localObject2 = com.tencent.luggage.wxa.fz.c.a((JSONObject)localObject2);
    localObject3 = this.g.b((Bundle)localObject2);
    com.tencent.luggage.wxa.qz.o.d(t(), "update, code:%d info:%s", new Object[] { Integer.valueOf(((com.tencent.luggage.wxa.fz.a)localObject3).a), ((com.tencent.luggage.wxa.fz.a)localObject3).b });
    if (((com.tencent.luggage.wxa.fz.a)localObject3).a == 0) {
      localObject1 = "ok";
    }
    parama.a((String)localObject1);
    if (((com.tencent.luggage.wxa.fz.a)localObject3).a == 0)
    {
      localObject1 = this.j;
      if (localObject1 != null) {
        ((com.tencent.luggage.wxa.gb.a)localObject1).a(parama, (Bundle)localObject2);
      }
    }
  }
  
  private void f(int paramInt)
  {
    com.tencent.luggage.wxa.gb.c localc = this.h;
    if (localc != null) {
      localc.a(paramInt, 1L, false);
    }
  }
  
  private void f(com.tencent.luggage.wxa.fx.a parama)
  {
    String str = parama.d().optString("type");
    com.tencent.luggage.wxa.qz.o.d(t(), "operateBackground, type:%s", new Object[] { str });
    if ((!af.c(str)) && (this.g != null))
    {
      if (str.equals("stop"))
      {
        r(parama);
        if (this.x)
        {
          com.tencent.luggage.wxa.qz.o.d(t(), "operateBackground, isRuntimeInBackground, setPlayingWhenEnterBackground false");
          a(new AtomicBoolean(false));
        }
      }
      else
      {
        parama.a("fail");
      }
    }
    else {
      parama.a("fail");
    }
  }
  
  private void g(com.tencent.luggage.wxa.fx.a parama)
  {
    JSONObject localJSONObject = parama.d();
    String str2 = localJSONObject.optString("type");
    com.tencent.luggage.wxa.qz.o.d(t(), "operate, type:%s", new Object[] { str2 });
    boolean bool = af.c(str2);
    String str1 = "fail";
    if ((!bool) && (this.g != null))
    {
      if (str2.equals("snapshot"))
      {
        m(parama);
        return;
      }
      if (str2.equalsIgnoreCase("requestFullScreen"))
      {
        k(parama);
        return;
      }
      if (str2.equalsIgnoreCase("exitFullScreen"))
      {
        l(parama);
        return;
      }
      if (str2.equalsIgnoreCase("exitPictureInPicture"))
      {
        n(parama);
        return;
      }
      if (str2.equalsIgnoreCase("requestBackgroundPlayback"))
      {
        q(parama);
        return;
      }
      if (str2.equalsIgnoreCase("exitBackgroundPlayback"))
      {
        r(parama);
        return;
      }
      if (this.g.a(str2, localJSONObject).a == 0) {
        str1 = "ok";
      }
      parama.a(str1);
      if ((str2.equalsIgnoreCase("stop")) || (str2.equalsIgnoreCase("pause")))
      {
        this.C.a(parama);
        c(str2);
        if ((str2.equalsIgnoreCase("stop")) && (this.x))
        {
          com.tencent.luggage.wxa.qz.o.d(t(), "operate, isRuntimeInBackground, setPlayingWhenEnterBackground false");
          a(new AtomicBoolean(false));
        }
      }
    }
    else
    {
      parama.a("fail");
    }
  }
  
  private void h(com.tencent.luggage.wxa.fx.a parama)
  {
    H();
    parama.a("ok");
  }
  
  private boolean i(com.tencent.luggage.wxa.fx.a parama)
  {
    Object localObject = parama.b();
    if (!(localObject instanceof Activity))
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.SameLayer.LivePlayerPluginHandler", "checkPermission, pageContext not activity");
      parama.a("fail:internal error invalid android context");
      return false;
    }
    if (com.tencent.luggage.util.j.a((Activity)localObject, "android.permission.RECORD_AUDIO")) {
      return true;
    }
    localObject = new HashMap();
    ((Map)localObject).put("errCode", Integer.valueOf(10001));
    com.tencent.luggage.wxa.qz.o.c("MicroMsg.SameLayer.LivePlayerPluginHandler", "checkPermission, permission denied");
    parama.a("fail:system permission denied", (Map)localObject);
    return false;
  }
  
  private void j(com.tencent.luggage.wxa.fx.a parama)
  {
    this.l = new a.20(this);
    parama.a(this.l);
  }
  
  private void k(com.tencent.luggage.wxa.fx.a parama)
  {
    Object localObject = this.j;
    boolean bool;
    if ((localObject != null) && (((com.tencent.luggage.wxa.gb.a)localObject).a(parama))) {
      bool = true;
    } else {
      bool = false;
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.SameLayer.LivePlayerPluginHandler", "operateRequestFullscreen, result:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      localObject = "ok";
    } else {
      localObject = "fail";
    }
    parama.a((String)localObject);
  }
  
  private void l(com.tencent.luggage.wxa.fx.a parama)
  {
    Object localObject = this.j;
    boolean bool;
    if ((localObject != null) && (((com.tencent.luggage.wxa.gb.a)localObject).b(parama))) {
      bool = true;
    } else {
      bool = false;
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.SameLayer.LivePlayerPluginHandler", "operateExitFullscreen, result:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      localObject = "ok";
    } else {
      localObject = "fail";
    }
    parama.a((String)localObject);
  }
  
  private void m(com.tencent.luggage.wxa.fx.a parama)
  {
    Object localObject = this.g;
    if (localObject == null)
    {
      com.tencent.luggage.wxa.qz.o.c(t(), "operateSnapshot, adapter is null");
      parama.a("fail");
      return;
    }
    ((b)localObject).a(new a.4(this, parama));
    localObject = this.g.a("snapshot", parama.d());
    if (((com.tencent.luggage.wxa.fz.a)localObject).a != 0)
    {
      com.tencent.luggage.wxa.qz.o.d(t(), "operateSnapshot, fail:%s", new Object[] { Integer.valueOf(((com.tencent.luggage.wxa.fz.a)localObject).a) });
      parama.a("fail:snapshot error");
      return;
    }
    com.tencent.luggage.wxa.qz.o.d(t(), "operateSnapshot, success");
  }
  
  private void n(com.tencent.luggage.wxa.fx.a parama)
  {
    boolean bool = this.C.b(parama);
    com.tencent.luggage.wxa.qz.o.d(t(), "operateExitPip, result:%s", new Object[] { Boolean.valueOf(bool) });
    String str;
    if (bool) {
      str = "ok";
    } else {
      str = "fail";
    }
    parama.a(str);
  }
  
  private void o(com.tencent.luggage.wxa.fx.a parama)
  {
    parama = parama.d();
    if (parama == null)
    {
      com.tencent.luggage.wxa.qz.o.c(t(), "handleAutoPlay, null == dataJsonObj");
      return;
    }
    this.G = parama.optBoolean("autoplay", this.G);
  }
  
  private void p(com.tencent.luggage.wxa.fx.a parama)
  {
    parama = parama.d();
    if (parama == null)
    {
      com.tencent.luggage.wxa.qz.o.c(t(), "handlePlayerUrl, null == dataJsonObj");
      return;
    }
    this.D = parama.optString("playUrl", this.D);
  }
  
  private void q(com.tencent.luggage.wxa.fx.a parama)
  {
    com.tencent.luggage.wxa.qz.o.e(t(), "enableBackgroundPlayAudio");
    boolean bool = this.H;
    String str = "fail";
    if (bool)
    {
      com.tencent.luggage.wxa.qz.o.c(t(), "enableBackgroundPlayAudio, mIsRTCMode");
      parama.a("fail");
      return;
    }
    if (this.x)
    {
      com.tencent.luggage.wxa.qz.o.c(t(), "enableBackgroundPlayAudio, isRuntimeInBackground");
      parama.a("fail");
      return;
    }
    if (!this.I)
    {
      N();
      O();
      P();
      Q();
      this.I = true;
    }
    if (s(parama))
    {
      Object localObject = this.g;
      if ((localObject != null) && (!((b)localObject).e()))
      {
        this.L.set(true);
        this.g.a(null);
      }
      this.J = true;
      localObject = this.i;
      if (localObject != null) {
        ((com.tencent.luggage.wxa.gb.b)localObject).a(B(), true);
      }
      bool = true;
    }
    else
    {
      bool = false;
    }
    com.tencent.luggage.wxa.qz.o.d(t(), "enableBackgroundPlayAudio, result:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      str = "ok";
    }
    parama.a(str);
  }
  
  private void r(com.tencent.luggage.wxa.fx.a parama)
  {
    com.tencent.luggage.wxa.qz.o.e(t(), "disableBackgroundPlayAudio");
    boolean bool = this.H;
    String str = "fail";
    if (bool)
    {
      com.tencent.luggage.wxa.qz.o.c(t(), "disableBackgroundPlayAudio, mIsRTCMode");
      parama.a("fail");
      return;
    }
    if (t(parama))
    {
      this.L.set(false);
      Object localObject = this.g;
      if (localObject != null) {
        ((b)localObject).a(this.e);
      }
      this.J = false;
      localObject = this.i;
      if (localObject != null) {
        ((com.tencent.luggage.wxa.gb.b)localObject).a(B(), false);
      }
      bool = true;
    }
    else
    {
      bool = false;
    }
    com.tencent.luggage.wxa.qz.o.d(t(), "disableBackgroundPlayAudio, result:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      str = "ok";
    }
    parama.a(str);
  }
  
  private boolean s(com.tencent.luggage.wxa.fx.a parama)
  {
    com.tencent.luggage.wxa.qz.o.e(t(), "enableBackgroundPlayAudioInternal");
    if (parama == null)
    {
      com.tencent.luggage.wxa.qz.o.c(t(), "enableBackgroundPlayAudioInternal, invokeContext is null");
      return false;
    }
    parama = com.tencent.luggage.wxa.fy.e.a(parama);
    if (parama == null)
    {
      com.tencent.luggage.wxa.qz.o.c(t(), "enableBackgroundPlayAudioInternal, audioOfVideoBackgroundPlayManager is null");
      return false;
    }
    return parama.a(this, true);
  }
  
  private String t()
  {
    return String.format("%s(%s)", new Object[] { "MicroMsg.SameLayer.LivePlayerPluginHandler", A() });
  }
  
  private boolean t(com.tencent.luggage.wxa.fx.a parama)
  {
    com.tencent.luggage.wxa.qz.o.e(t(), "disableBackgroundPlayAudioInternal");
    if (parama == null)
    {
      com.tencent.luggage.wxa.qz.o.c(t(), "disableBackgroundPlayAudioInternal, invokeContext is null");
      return false;
    }
    parama = com.tencent.luggage.wxa.fy.e.a(parama);
    if (parama == null)
    {
      com.tencent.luggage.wxa.qz.o.c(t(), "disableBackgroundPlayAudio, audioOfVideoBackgroundPlayManager is null");
      return false;
    }
    parama.b(this);
    return true;
  }
  
  private void u()
  {
    this.g = new b(com.tencent.luggage.wxa.qz.r.a());
    this.g.a(this.v);
    this.g.a(new a.1(this));
    this.g.a(new a.11(this));
  }
  
  private void v()
  {
    super.d();
    com.tencent.luggage.wxa.qz.o.d(t(), "*** handler(%s) handlePluginDestroy", new Object[] { A() });
  }
  
  private void w()
  {
    if ((this.m != 0) && (this.n != 0) && (this.f != null) && (this.g != null))
    {
      com.tencent.luggage.wxa.qz.o.d(t(), "adjustHtmlSize, size:[%d, %d]", new Object[] { Integer.valueOf(this.m), Integer.valueOf(this.n) });
      this.f.setDefaultBufferSize(this.m, this.n);
      if ((L()) && (this.y))
      {
        com.tencent.luggage.wxa.qz.o.d(t(), "adjustHtmlSize, i am pip player, isWebViewInBackground");
        return;
      }
      this.g.a(this.m, this.n);
    }
  }
  
  private void x()
  {
    com.tencent.luggage.wxa.fx.a locala = this.k;
    if (locala != null)
    {
      locala.f();
      this.l = null;
    }
  }
  
  private void y()
  {
    Handler localHandler = this.v;
    if (localHandler != null) {
      localHandler.post(new a.21(this));
    }
  }
  
  private void z()
  {
    com.tencent.luggage.wxa.qz.o.d(t(), "*** handler(%s) handleWebViewForeground", new Object[] { A() });
    this.y = false;
    if (!a(null))
    {
      com.tencent.luggage.wxa.qz.o.d(t(), "plugin is not ready");
      return;
    }
    if ((!this.x) && (this.g != null) && (c() != null))
    {
      boolean bool = c().get();
      a(null);
      if (bool)
      {
        com.tencent.luggage.wxa.fz.a locala = this.g.d();
        com.tencent.luggage.wxa.qz.o.d(t(), "handleWebViewForeground, code:%d info:%s", new Object[] { Integer.valueOf(locala.a), locala.b });
      }
    }
  }
  
  @Nullable
  public <AddOn extends com.tencent.luggage.wxa.fy.j> AddOn a(@NonNull Class<AddOn> paramClass)
  {
    String str = t();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getAddOn for ");
    localStringBuilder.append(paramClass.getSimpleName());
    com.tencent.luggage.wxa.qz.o.d(str, localStringBuilder.toString());
    return this.K.a(paramClass);
  }
  
  @NonNull
  public String a()
  {
    return f();
  }
  
  public void a(int paramInt)
  {
    Handler localHandler = this.v;
    if (localHandler != null) {
      localHandler.post(new a.3(this, paramInt));
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    Handler localHandler = this.v;
    if (localHandler != null) {
      localHandler.post(new a.17(this, paramSurfaceTexture));
    }
  }
  
  public void a(@Nullable com.tencent.luggage.wxa.fy.s params)
  {
    this.E = params;
    if (params != null) {
      t.a(this.F, params);
    }
  }
  
  public void a(com.tencent.luggage.wxa.gb.a parama)
  {
    this.j = parama;
    parama = this.j;
    if (parama != null)
    {
      this.i = parama.a();
      this.h = this.j.b();
      this.j.a(this);
    }
  }
  
  public <AddOn extends com.tencent.luggage.wxa.fy.j> void a(@NonNull Class<AddOn> paramClass, @Nullable AddOn paramAddOn)
  {
    String str = t();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAddOn for ");
    localStringBuilder.append(paramClass.getSimpleName());
    com.tencent.luggage.wxa.qz.o.d(str, localStringBuilder.toString());
    this.K.a(paramClass, paramAddOn);
  }
  
  public void a(AtomicBoolean paramAtomicBoolean)
  {
    this.z = paramAtomicBoolean;
  }
  
  public void a(@NonNull JSONObject paramJSONObject)
  {
    this.o = com.tencent.luggage.wxa.pc.g.c(paramJSONObject.optInt("x", this.o));
    this.p = com.tencent.luggage.wxa.pc.g.c(paramJSONObject.optInt("y", this.p));
    com.tencent.luggage.wxa.qz.o.e(t(), "updateVideoPosition, mPosX: %d, mPosY: %d", new Object[] { Integer.valueOf(this.o), Integer.valueOf(this.p) });
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    com.tencent.luggage.wxa.qz.o.e(t(), "setSurfaceSize, width: %d, height: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0) && (this.g != null))
    {
      if (!this.L.get())
      {
        this.g.a(paramInt1, paramInt2);
        return true;
      }
      com.tencent.luggage.wxa.qz.o.d(t(), "setSurfaceSize, JustPlayAudio");
      return true;
    }
    com.tencent.luggage.wxa.qz.o.c(t(), "setSurfaceSize, Adapter is null");
    return false;
  }
  
  public boolean a(@Nullable Surface paramSurface)
  {
    if (this.g != null)
    {
      if (!this.L.get()) {
        this.g.a(paramSurface);
      } else {
        com.tencent.luggage.wxa.qz.o.d(t(), "setSurface, JustPlayAudio");
      }
      return true;
    }
    com.tencent.luggage.wxa.qz.o.c(t(), "setSurface, Adapter is null");
    return false;
  }
  
  public boolean a(com.tencent.luggage.wxa.fx.a parama)
  {
    return true;
  }
  
  public String b()
  {
    return String.format("%s_%s", new Object[] { C(), Integer.valueOf(B()) });
  }
  
  public String b(com.tencent.luggage.wxa.fx.a parama)
  {
    Handler localHandler = this.v;
    if (localHandler != null) {
      localHandler.post(new a.19(this, parama));
    }
    return null;
  }
  
  public AtomicBoolean c()
  {
    return this.z;
  }
  
  public void d()
  {
    Handler localHandler = this.v;
    if (localHandler != null) {
      localHandler.post(new a.18(this));
    }
  }
  
  public void e()
  {
    Handler localHandler = this.v;
    if (localHandler != null) {
      localHandler.post(new a.2(this));
    }
  }
  
  public String f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(A());
    localStringBuilder.append("@");
    localStringBuilder.append(hashCode());
    return localStringBuilder.toString();
  }
  
  @Nullable
  public Integer g()
  {
    Object localObject = this.k;
    if (localObject == null)
    {
      com.tencent.luggage.wxa.qz.o.c(t(), "getOriginPageViewId, invokeContext is null");
      return null;
    }
    localObject = com.tencent.luggage.wxa.fy.b.d((com.tencent.luggage.wxa.fx.a)localObject);
    if (localObject == null)
    {
      com.tencent.luggage.wxa.qz.o.c(t(), "getOriginPageViewId, pageView is null");
      return null;
    }
    return Integer.valueOf(localObject.hashCode());
  }
  
  public void h()
  {
    b localb = this.g;
    if ((localb != null) && (!localb.e())) {
      b("play");
    }
  }
  
  public void i()
  {
    b("pause");
  }
  
  public void j()
  {
    Handler localHandler = this.v;
    if (localHandler != null) {
      localHandler.post(new a.8(this));
    }
  }
  
  @Nullable
  public b k()
  {
    return this.g;
  }
  
  public SurfaceTexture l()
  {
    return this.f;
  }
  
  public Surface m()
  {
    return this.e;
  }
  
  public int n()
  {
    return this.m;
  }
  
  public int o()
  {
    return this.n;
  }
  
  public int p()
  {
    return this.o;
  }
  
  public int q()
  {
    return this.p;
  }
  
  public boolean r()
  {
    return this.J;
  }
  
  public boolean s()
  {
    return this.L.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ga.a
 * JD-Core Version:    0.7.0.1
 */