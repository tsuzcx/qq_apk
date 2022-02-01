package com.tencent.liteav;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.audio.d;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.opengl.p;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.liteav.renderer.g;
import com.tencent.rtmp.TXLivePlayer.ITXAudioRawDataListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class f
  extends n
  implements TXCRenderAndDec.a, TXCRenderAndDec.b, d, com.tencent.liteav.audio.f, com.tencent.liteav.basic.c.b, com.tencent.liteav.network.f, com.tencent.liteav.renderer.a.a, g
{
  private int A;
  private int B;
  private com.tencent.liteav.renderer.h C;
  private com.tencent.liteav.renderer.h D;
  private float[] E;
  private float[] F;
  private String G;
  private int H;
  private com.tencent.liteav.basic.b.b I;
  private Object J;
  private com.tencent.liteav.basic.c.a K;
  private TXLivePlayer.ITXAudioRawDataListener L;
  private String M;
  private boolean N;
  private long O;
  private long P;
  private f.a Q;
  private TXCRenderAndDec e = null;
  private com.tencent.liteav.renderer.a f = null;
  private TXCStreamDownloader g = null;
  private Handler h;
  private TextureView i;
  private boolean j;
  private boolean k;
  private int l;
  private int m;
  private int n;
  private boolean o;
  private Surface p;
  private int q;
  private int r;
  private int s;
  private boolean t;
  private boolean u;
  private boolean v;
  private int w;
  private com.tencent.liteav.a.a x;
  private TXRecordCommon.ITXVideoRecordListener y;
  private e z;
  
  public f(Context paramContext)
  {
    super(paramContext);
    boolean bool = false;
    this.j = false;
    this.k = false;
    this.l = 100;
    this.m = 0;
    this.n = 0;
    this.o = false;
    this.q = 2;
    this.r = 48000;
    this.s = 16;
    this.t = false;
    this.u = false;
    this.v = false;
    this.w = 0;
    this.A = 0;
    this.B = 0;
    this.C = null;
    this.D = null;
    this.E = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
    this.F = new float[16];
    this.G = "";
    this.I = com.tencent.liteav.basic.b.b.a;
    this.J = null;
    this.K = new f.1(this);
    this.M = "";
    this.N = false;
    this.O = 0L;
    this.P = 0L;
    this.Q = null;
    c.a().a(paramContext);
    TXCAudioEngine.CreateInstance(paramContext, c.a().c());
    TXCAudioEngine.getInstance().addEventCallback(new WeakReference(this.K));
    long l1 = c.a().a("Audio", "EnableAutoRestartDevice");
    paramContext = TXCAudioEngine.getInstance();
    if ((l1 == 1L) || (l1 == -1L)) {
      bool = true;
    }
    paramContext.enableAutoRestartDevice(bool);
    this.h = new Handler(Looper.getMainLooper());
    this.f = new com.tencent.liteav.renderer.a();
    this.f.a(this);
    this.Q = new f.a(this);
    paramContext = new StringBuilder();
    paramContext.append("[FirstFramePath] TXCLivePlayer: create player success. instance:");
    paramContext.append(hashCode());
    c(paramContext.toString());
  }
  
  private void a(int paramInt, String paramString)
  {
    if (this.d != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("EVT_ID", paramInt);
      localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
      localBundle.putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
      if (paramString != null) {
        localBundle.putCharSequence("EVT_MSG", paramString);
      }
      paramString = this.h;
      if (paramString != null) {
        paramString.post(new f.5(this, paramInt, localBundle));
      }
    }
  }
  
  private int b(String paramString, int paramInt)
  {
    int i1 = 0;
    if (paramInt == 0)
    {
      this.g = new TXCStreamDownloader(this.b, 1);
    }
    else if (paramInt == 5)
    {
      this.g = new TXCStreamDownloader(this.b, 4);
    }
    else
    {
      this.g = new TXCStreamDownloader(this.b, 0);
      if (!TextUtils.isEmpty(this.a.l)) {
        this.g.setFlvSessionKey(this.a.l);
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start network. network instance:");
    localStringBuilder.append(this.g.hashCode());
    c(localStringBuilder.toString());
    this.g.setID(this.M);
    this.g.setListener(this);
    this.g.setNotifyListener(this);
    this.g.setHeaders(this.a.p);
    if (paramInt == 5) {
      i1 = 1;
    }
    if (i1 != 0)
    {
      this.g.setRetryTimes(5);
      this.g.setRetryInterval(1);
    }
    else
    {
      this.g.setRetryTimes(this.a.e);
      this.g.setRetryInterval(this.a.f);
    }
    return this.g.start(paramString, this.a.i, this.a.m, this.a.j, this.a.k);
  }
  
  private void b(String paramString)
  {
    this.M = String.format("%s-%d", new Object[] { paramString, Long.valueOf(TXCTimeUtil.getTimeTick() % 10000L) });
    paramString = this.e;
    if (paramString != null) {
      paramString.setID(this.M);
    }
    paramString = this.f;
    if (paramString != null) {
      paramString.setID(this.M);
    }
    paramString = this.g;
    if (paramString != null) {
      paramString.setID(this.M);
    }
    paramString = this.z;
    if (paramString != null) {
      paramString.d(this.M);
    }
  }
  
  private void c(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new StringBuilder();
    paramString.append("TXCLivePlayer(");
    paramString.append(hashCode());
    paramString.append(") ");
    paramString.append(str);
    TXCLog.i("TXCLivePlayer", paramString.toString());
  }
  
  private void d(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new StringBuilder();
    paramString.append("TXCLivePlayer(");
    paramString.append(hashCode());
    paramString.append(") ");
    paramString.append(str);
    TXCLog.e("TXCLivePlayer", paramString.toString());
  }
  
  private void e(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new StringBuilder();
    paramString.append("TXCLivePlayer(");
    paramString.append(hashCode());
    paramString.append(") ");
    paramString.append(str);
    TXCLog.w("TXCLivePlayer", paramString.toString());
  }
  
  private void f(int paramInt)
  {
    Object localObject = this.i;
    boolean bool = false;
    if (localObject != null) {
      ((TextureView)localObject).setVisibility(0);
    }
    this.e = new TXCRenderAndDec(this.b);
    this.e.setNotifyListener(this);
    this.e.setVideoRender(this.f);
    this.e.setDecListener(this);
    this.e.setRenderAndDecDelegate(this);
    this.e.setConfig(this.a);
    this.e.setID(this.M);
    localObject = this.e;
    if (paramInt == 5) {
      bool = true;
    }
    ((TXCRenderAndDec)localObject).start(bool);
    this.e.setRenderMode(this.n);
    this.e.setRenderRotation(this.m);
  }
  
  private void j()
  {
    if (this.x == null)
    {
      this.A = this.f.h();
      this.B = this.f.i();
      com.tencent.liteav.a.a.a locala = l();
      this.x = new com.tencent.liteav.a.a(this.b);
      this.x.a(locala);
      this.x.a(new f.2(this));
    }
    if (this.C == null)
    {
      this.C = new com.tencent.liteav.renderer.h(Boolean.valueOf(true));
      this.C.b();
      this.C.b(this.A, this.B);
      this.C.a(this.A, this.B);
    }
    if (this.D == null)
    {
      this.D = new com.tencent.liteav.renderer.h(Boolean.valueOf(false));
      this.D.b();
      this.D.b(this.f.f(), this.f.g());
      this.D.a(this.f.f(), this.f.g());
      Matrix.setIdentityM(this.F, 0);
    }
  }
  
  private void k()
  {
    com.tencent.liteav.renderer.h localh = this.C;
    if (localh != null)
    {
      localh.c();
      this.C = null;
    }
    localh = this.D;
    if (localh != null)
    {
      localh.c();
      this.D = null;
    }
  }
  
  private com.tencent.liteav.a.a.a l()
  {
    int i1 = this.A;
    int i2;
    if (i1 > 0)
    {
      i2 = this.B;
      if (i2 > 0) {}
    }
    else
    {
      i1 = 480;
      i2 = 640;
    }
    com.tencent.liteav.a.a.a locala = new com.tencent.liteav.a.a.a();
    locala.a = i1;
    locala.b = i2;
    locala.c = 20;
    double d1 = i1 * i1;
    Double.isNaN(d1);
    double d2 = i2 * i2;
    Double.isNaN(d2);
    locala.d = ((int)(Math.sqrt(d1 * 1.0D + d2) * 1.2D));
    locala.h = this.q;
    locala.i = this.r;
    locala.j = this.s;
    locala.f = com.tencent.liteav.a.a.a(this.b, ".mp4");
    locala.g = com.tencent.liteav.a.a.a(this.b, ".jpg");
    locala.e = this.f.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("record config: ");
    localStringBuilder.append(locala);
    TXCLog.d("TXCLivePlayer", localStringBuilder.toString());
    return locala;
  }
  
  private void m()
  {
    TXCRenderAndDec localTXCRenderAndDec = this.e;
    if (localTXCRenderAndDec != null)
    {
      localTXCRenderAndDec.stop();
      this.e.setVideoRender(null);
      this.e.setDecListener(null);
      this.e.setNotifyListener(null);
      this.e = null;
    }
  }
  
  private void n()
  {
    boolean bool;
    if (this.H == 5) {
      bool = true;
    } else {
      bool = false;
    }
    TXCAudioEngine.getInstance();
    TXCAudioEngine.enableAudioVolumeEvaluation(true, 300);
    a(this.L);
    if (this.H == 5) {
      TXCAudioEngine.getInstance().setRemoteAudioCacheParams(this.M, this.a.g ^ true, (int)(com.tencent.liteav.basic.b.a.b * 1000.0F), (int)(com.tencent.liteav.basic.b.a.b * 1000.0F), (int)(com.tencent.liteav.basic.b.a.c * 1000.0F));
    } else {
      TXCAudioEngine.getInstance().setRemoteAudioCacheParams(this.M, this.a.g ^ true, (int)(this.a.a * 1000.0F), (int)(this.a.c * 1000.0F), (int)(this.a.b * 1000.0F));
    }
    TXCAudioEngine.getInstance().muteRemoteAudio(this.M, this.j);
    TXCAudioEngine.getInstance().muteRemoteAudioInSpeaker(this.M, this.k);
    TXCAudioEngine.getInstance().setRemotePlayoutVolume(this.M, this.l);
    TXCAudioEngine.getInstance().setRemoteAudioStreamEventListener(this.M, this);
    x();
    TXCAudioEngine.getInstance().startRemoteAudio(this.M, bool);
  }
  
  private void o()
  {
    TXCAudioEngine.getInstance().setRemoteAudioStreamEventListener(this.M, null);
    TXCAudioEngine.getInstance().setSetAudioEngineRemoteStreamDataListener(this.M, null);
    TXCAudioEngine.getInstance().stopRemoteAudio(this.M);
    TXCAudioEngine.getInstance().UnInitAudioDevice();
  }
  
  private void p()
  {
    if (this.g != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stop network. network instance:");
      localStringBuilder.append(this.g.hashCode());
      c(localStringBuilder.toString());
      this.g.setListener(null);
      this.g.setNotifyListener(null);
      this.g.stop();
      this.g = null;
    }
  }
  
  private void q()
  {
    this.z = new e(this.b);
    this.z.a(this.G);
    e locale = this.z;
    boolean bool;
    if (this.H == 5) {
      bool = true;
    } else {
      bool = false;
    }
    locale.a(bool);
    this.z.d(this.M);
    this.z.e(this.g.getRTMPProxyUserId());
    this.z.a();
  }
  
  private void r()
  {
    e locale = this.z;
    if (locale != null)
    {
      locale.c();
      this.z = null;
    }
  }
  
  private void s()
  {
    this.N = false;
    x();
  }
  
  private void t()
  {
    if (this.O > 0L)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putInt("EVT_PLAY_PROGRESS", (int)(this.O / 1000L));
      ((Bundle)localObject).putInt("EVT_PLAY_PROGRESS_MS", (int)this.O);
      onNotifyEvent(2005, (Bundle)localObject);
    }
    Object localObject = this.h;
    if ((localObject != null) && (this.N)) {
      ((Handler)localObject).postDelayed(new f.4(this), 1000L);
    }
  }
  
  private void u()
  {
    Handler localHandler = this.h;
    if (localHandler != null) {
      localHandler.postDelayed(this.Q, 2000L);
    }
  }
  
  private void v()
  {
    Handler localHandler = this.h;
    if (localHandler != null) {
      localHandler.removeCallbacks(this.Q);
    }
  }
  
  private void w()
  {
    ArrayList localArrayList = new ArrayList();
    String str = this.M;
    if (str != null) {
      localArrayList.add(str);
    }
    a.a("18446744073709551615", localArrayList);
  }
  
  private void x()
  {
    if ((this.t) || (this.L != null) || (this.N)) {
      TXCAudioEngine.getInstance().setSetAudioEngineRemoteStreamDataListener(this.M, this);
    }
    if ((!this.t) && (this.L == null) && (!this.N)) {
      TXCAudioEngine.getInstance().setSetAudioEngineRemoteStreamDataListener(this.M, null);
    }
  }
  
  public int a(int paramInt, float[] paramArrayOfFloat)
  {
    paramArrayOfFloat = this.x;
    if ((this.t) && (paramArrayOfFloat != null))
    {
      com.tencent.liteav.renderer.h localh = this.C;
      if (localh != null)
      {
        int i1 = localh.d(paramInt);
        paramArrayOfFloat.a(i1, TXCTimeUtil.getTimeTick());
        this.f.a(i1, this.A, this.B, false, 0);
      }
    }
    if (this.t)
    {
      j();
      return paramInt;
    }
    k();
    return paramInt;
  }
  
  public int a(String paramString)
  {
    if (c())
    {
      Object localObject = this.g;
      if (localObject != null)
      {
        boolean bool = ((TXCStreamDownloader)localObject).switchStream(paramString);
        long l1 = 0L;
        long l2 = TXCStatus.c(this.M, 2007);
        localObject = this.e;
        if (localObject != null) {
          l1 = ((TXCRenderAndDec)localObject).getVideoCacheDuration();
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[SwitchStream] current jitter size when start switch stream. video:");
        ((StringBuilder)localObject).append(l1);
        ((StringBuilder)localObject).append(" audio:");
        ((StringBuilder)localObject).append(l2);
        c(((StringBuilder)localObject).toString());
        if (bool)
        {
          this.G = paramString;
          return 0;
        }
        return -2;
      }
    }
    return -1;
  }
  
  public int a(String paramString, int paramInt)
  {
    if (c())
    {
      e("play: ignore start play when is playing");
      return -2;
    }
    if ((this.a != null) && (this.a.c > this.a.b))
    {
      paramString = new StringBuilder();
      paramString.append("play: can not start play while invalid cache config [minAutoAdjustCacheTime(");
      paramString.append(this.a.c);
      paramString.append(") > maxAutoAdjustCacheTime(");
      paramString.append(this.a.b);
      paramString.append(")]!!!!!!");
      d(paramString.toString());
      return -1;
    }
    if ((this.a.a > this.a.b) || (this.a.a < this.a.c))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("play: invalid cacheTime ");
      localStringBuilder.append(this.a.a);
      localStringBuilder.append(", need between minAutoAdjustCacheTime ");
      localStringBuilder.append(this.a.c);
      localStringBuilder.append(" and maxAutoAdjustCacheTime ");
      localStringBuilder.append(this.a.b);
      localStringBuilder.append(" , fix to maxAutoAdjustCacheTime");
      e(localStringBuilder.toString());
      this.a.a = this.a.b;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[FirstFramePath] TXCLivePlayer: start play. instance: ");
    localStringBuilder.append(hashCode());
    c(localStringBuilder.toString());
    this.G = paramString;
    this.H = paramInt;
    b(paramString);
    this.o = true;
    this.w = 0;
    this.u = true;
    f(paramInt);
    n();
    paramInt = b(paramString, paramInt);
    if (paramInt != 0)
    {
      this.o = false;
      p();
      m();
      o();
      paramString = this.i;
      if (paramString != null)
      {
        paramString.setVisibility(8);
        return paramInt;
      }
    }
    else
    {
      a(this.p);
      q();
      u();
      if ((this.I == com.tencent.liteav.basic.b.b.c) && (this.i == null))
      {
        paramString = this.f;
        if (paramString != null) {
          paramString.c(this.J);
        }
      }
    }
    try
    {
      if (Class.forName("com.tencent.liteav.demo.play.SuperPlayerView") != null) {
        TXCDRApi.txReportDAU(this.b, com.tencent.liteav.basic.datareport.a.bF);
      }
      return paramInt;
    }
    catch (Exception paramString) {}
    return paramInt;
  }
  
  public int a(boolean paramBoolean)
  {
    if (!c())
    {
      e("play: ignore stop play when not started");
      return -2;
    }
    TXCLog.v("TXCLivePlayer", "play: stop");
    this.o = false;
    p();
    m();
    Object localObject = this.i;
    if ((localObject != null) && (paramBoolean)) {
      ((TextureView)localObject).setVisibility(8);
    }
    localObject = this.f;
    if (localObject != null) {
      ((com.tencent.liteav.renderer.a)localObject).a((Surface)null);
    }
    if (this.i == null)
    {
      localObject = this.f;
      if (localObject != null) {
        ((com.tencent.liteav.renderer.a)localObject).d();
      }
    }
    o();
    r();
    v();
    s();
    return 0;
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(int paramInt)
  {
    this.n = paramInt;
    TXCRenderAndDec localTXCRenderAndDec = this.e;
    if (localTXCRenderAndDec != null) {
      localTXCRenderAndDec.setRenderMode(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    com.tencent.liteav.renderer.a locala = this.f;
    if (locala != null) {
      locala.d(paramInt1, paramInt2);
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    k();
    d();
  }
  
  public void a(Surface paramSurface)
  {
    this.p = paramSurface;
    com.tencent.liteav.renderer.a locala = this.f;
    if (locala != null) {
      locala.a(paramSurface);
    }
  }
  
  public void a(p paramp)
  {
    com.tencent.liteav.renderer.a locala = this.f;
    if (locala != null) {
      locala.a(paramp);
    }
  }
  
  public void a(h paramh)
  {
    super.a(paramh);
    TXCRenderAndDec localTXCRenderAndDec = this.e;
    if (localTXCRenderAndDec != null) {
      localTXCRenderAndDec.setConfig(paramh);
    }
  }
  
  public void a(o paramo, com.tencent.liteav.basic.b.b paramb, Object paramObject)
  {
    this.I = paramb;
    this.J = paramObject;
    if ((c()) && (this.I == com.tencent.liteav.basic.b.b.c) && (this.i == null) && (paramo != null))
    {
      paramObject = this.f;
      if (paramObject != null) {
        paramObject.c(this.J);
      }
    }
    paramObject = this.e;
    if (paramObject != null)
    {
      paramObject.setVideoFrameListener(paramo, paramb);
      return;
    }
    e("setVideoFrameListener->enter with renderAndDec is empty");
  }
  
  public void a(TXLivePlayer.ITXAudioRawDataListener paramITXAudioRawDataListener)
  {
    this.L = paramITXAudioRawDataListener;
    x();
  }
  
  public void a(TXCloudVideoView paramTXCloudVideoView)
  {
    if ((this.c != null) && (this.c != paramTXCloudVideoView))
    {
      TextureView localTextureView = this.c.getVideoView();
      if (localTextureView != null) {
        this.c.removeView(localTextureView);
      }
    }
    super.a(paramTXCloudVideoView);
    if (this.c != null)
    {
      this.i = this.c.getVideoView();
      if (this.i == null) {
        this.i = new TextureView(this.c.getContext());
      }
      this.c.addVideoView(this.i);
    }
    paramTXCloudVideoView = this.f;
    if (paramTXCloudVideoView != null) {
      paramTXCloudVideoView.a(this.i);
    }
  }
  
  public void a(TXRecordCommon.ITXVideoRecordListener paramITXVideoRecordListener)
  {
    this.y = paramITXVideoRecordListener;
  }
  
  public void b()
  {
    a(this.G, this.H);
  }
  
  public void b(int paramInt)
  {
    this.m = paramInt;
    TXCRenderAndDec localTXCRenderAndDec = this.e;
    if (localTXCRenderAndDec != null) {
      localTXCRenderAndDec.setRenderRotation(paramInt);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.j = paramBoolean;
    TXCAudioEngine.getInstance().muteRemoteAudio(this.M, this.j);
  }
  
  public void c(int paramInt)
  {
    this.l = paramInt;
    TXCAudioEngine.getInstance().setRemotePlayoutVolume(this.M, this.l);
  }
  
  public void c(boolean paramBoolean)
  {
    this.k = paramBoolean;
    TXCAudioEngine.getInstance().muteRemoteAudioInSpeaker(this.M, paramBoolean);
  }
  
  public boolean c()
  {
    return this.o;
  }
  
  public int d()
  {
    if (!this.t)
    {
      e("stopRecord: no recording task exist");
      return -1;
    }
    this.t = false;
    x();
    com.tencent.liteav.a.a locala = this.x;
    if (locala != null)
    {
      locala.a();
      this.x = null;
    }
    return 0;
  }
  
  public int d(int paramInt)
  {
    if (this.t)
    {
      d("startRecord: there is existing uncompleted record task");
      return -1;
    }
    this.t = true;
    this.f.a(this);
    this.f.a(this);
    x();
    TXCDRApi.txReportDAU(this.b, com.tencent.liteav.basic.datareport.a.aw);
    return 0;
  }
  
  public boolean e()
  {
    return true;
  }
  
  public void f()
  {
    this.P = 0L;
    if (this.N) {
      return;
    }
    this.N = true;
    x();
    Handler localHandler = this.h;
    if (localHandler != null) {
      localHandler.postDelayed(new f.3(this), 1000L);
    }
  }
  
  public void g()
  {
    w();
    Object localObject1 = com.tencent.liteav.basic.util.h.a();
    int i1 = localObject1[0] / 10;
    int i2 = localObject1[1] / 10;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(i1);
    ((StringBuilder)localObject1).append("/");
    ((StringBuilder)localObject1).append(i2);
    ((StringBuilder)localObject1).append("%");
    localObject1 = ((StringBuilder)localObject1).toString();
    int i3 = TXCStatus.c(this.M, 7102);
    int i4 = TXCStatus.c(this.M, 7101);
    String str = TXCStatus.b(this.M, 7110);
    i2 = (int)TXCStatus.d(this.M, 6002);
    Bundle localBundle = new Bundle();
    Object localObject2 = this.f;
    if (localObject2 != null)
    {
      localBundle.putInt("VIDEO_WIDTH", ((com.tencent.liteav.renderer.a)localObject2).h());
      localBundle.putInt("VIDEO_HEIGHT", this.f.i());
    }
    localObject2 = this.e;
    if (localObject2 != null)
    {
      localBundle.putInt("VIDEO_CACHE", (int)((TXCRenderAndDec)localObject2).getVideoCacheDuration());
      localBundle.putInt("V_SUM_CACHE_SIZE", (int)this.e.getVideoCacheFrameCount());
      localBundle.putInt("V_DEC_CACHE_SIZE", this.e.getVideoDecCacheFrameCount());
      localBundle.putInt("AV_PLAY_INTERVAL", (int)this.e.getAVPlayInterval());
      localBundle.putInt("AV_RECV_INTERVAL", (int)this.e.getAVNetRecvInterval());
      if (i2 == 0) {
        i1 = 15;
      } else {
        i1 = i2;
      }
      double d = TXCStatus.c(this.M, 7120) * 10 / i1 / 10.0F;
      Double.isNaN(d);
      localBundle.putInt("VIDEO_GOP", (int)(d + 0.5D));
    }
    i1 = TXCAudioEngine.getInstance().getPlayAECType();
    int i5 = TXCStatus.c(this.M, 2019);
    int i6 = TXCStatus.c(this.M, 2020);
    int i7 = TXCAudioEngine.getInstance().getPlaySampleRate();
    int i8 = TXCAudioEngine.getInstance().getPlayChannels();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(i1);
    ((StringBuilder)localObject2).append(" | ");
    ((StringBuilder)localObject2).append(i5);
    ((StringBuilder)localObject2).append(",");
    ((StringBuilder)localObject2).append(i6);
    ((StringBuilder)localObject2).append(" | ");
    ((StringBuilder)localObject2).append(i7);
    ((StringBuilder)localObject2).append(",");
    ((StringBuilder)localObject2).append(i8);
    localBundle.putString("AUDIO_PLAY_INFO", ((StringBuilder)localObject2).toString());
    localBundle.putInt("AUDIO_CACHE", TXCStatus.c(this.M, 2007));
    localBundle.putInt("NET_JITTER", TXCStatus.c(this.M, 2018));
    localBundle.putFloat("AUDIO_CACHE_THRESHOLD", TXCStatus.c(this.M, 2021) / 1000.0F);
    localBundle.putInt("NET_SPEED", i4 + i3);
    localBundle.putInt("VIDEO_FPS", i2);
    localBundle.putInt("VIDEO_BITRATE", i4);
    localBundle.putInt("AUDIO_BITRATE", i3);
    localBundle.putCharSequence("SERVER_IP", str);
    localBundle.putCharSequence("CPU_USAGE", (CharSequence)localObject1);
    this.w += 1;
    if (this.w == 5) {
      if (this.v) {
        TXCStatus.a(this.M, 6013, Long.valueOf(0L));
      } else {
        TXCStatus.a(this.M, 6013, Long.valueOf(1L));
      }
    }
    com.tencent.liteav.basic.util.h.a(this.d, 15001, localBundle);
    localObject1 = this.e;
    if (localObject1 != null) {
      ((TXCRenderAndDec)localObject1).updateLoadInfo();
    }
    localObject1 = this.z;
    if (localObject1 != null) {
      ((e)localObject1).f();
    }
  }
  
  public int h()
  {
    return TXCAudioEngine.getInstance().getRemotePlayoutVolumeLevel(this.M);
  }
  
  public void onAudioJitterBufferNotify(String paramString1, int paramInt, String paramString2)
  {
    onNotifyEvent(paramInt, null);
  }
  
  public void onAudioPlayPcmData(String paramString, byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2)
  {
    this.r = paramInt1;
    this.q = paramInt2;
    long l1 = paramLong;
    if (this.x != null)
    {
      l1 = paramLong;
      if (paramLong <= 0L) {
        l1 = TXCTimeUtil.getTimeTick();
      }
      this.x.a(paramArrayOfByte, l1);
    }
    if (this.P <= 0L)
    {
      paramString = this.L;
      if (paramString != null) {
        paramString.onAudioInfoChanged(paramInt1, paramInt2, 16);
      }
    }
    paramString = this.L;
    if (paramString != null) {
      paramString.onPcmDataAvailable(paramArrayOfByte, l1);
    }
    paramLong = this.P;
    if (paramLong <= 0L)
    {
      this.P = l1;
      return;
    }
    this.O = (l1 - paramLong);
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    if ((2003 == paramInt) && (!this.v)) {
      this.v = true;
    }
    if ((2003 == paramInt) || (2026 == paramInt))
    {
      if (this.u)
      {
        a(2004, "Video play started");
        this.u = false;
      }
      if (2026 == paramInt)
      {
        a(2026, "Audio play started");
        TXCStatus.a(this.M, 2033, Long.valueOf(TXCTimeUtil.getTimeTick()));
        return;
      }
    }
    if (2025 == paramInt)
    {
      a(2004, "Video play started");
      return;
    }
    if ((2023 != paramInt) && (2024 != paramInt))
    {
      Handler localHandler = this.h;
      if (localHandler != null) {
        localHandler.post(new f.6(this, paramInt, paramBundle));
      }
      return;
    }
    a(2007, "Video play loading");
  }
  
  public void onPullAudio(com.tencent.liteav.basic.structs.a parama) {}
  
  public void onPullNAL(TXSNALPacket paramTXSNALPacket)
  {
    if (!this.o) {
      return;
    }
    try
    {
      if (this.e != null)
      {
        this.e.decVideo(paramTXSNALPacket);
        return;
      }
    }
    catch (Exception paramTXSNALPacket)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("decode video failed.");
      localStringBuilder.append(paramTXSNALPacket.getMessage());
      d(localStringBuilder.toString());
    }
  }
  
  public void onRequestKeyFrame(String paramString, int paramInt)
  {
    if (this.o)
    {
      paramString = this.g;
      if (paramString != null) {
        paramString.requestKeyFrame(this.G);
      }
    }
  }
  
  public void onTextureProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    com.tencent.liteav.a.a locala = this.x;
    if ((this.t) && (locala != null))
    {
      com.tencent.liteav.renderer.h localh = this.D;
      if (localh != null)
      {
        localh.a(this.E);
        locala.a(this.D.d(paramInt1), TXCTimeUtil.getTimeTick());
        this.D.a(this.F);
        this.D.c(paramInt1);
      }
    }
    if (this.t)
    {
      j();
      return;
    }
    k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.f
 * JD-Core Version:    0.7.0.1
 */