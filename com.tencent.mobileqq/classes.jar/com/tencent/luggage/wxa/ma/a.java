package com.tencent.luggage.wxa.ma;

import android.content.Context;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.pc.g;
import com.tencent.luggage.wxa.pc.l;
import com.tencent.luggage.wxa.pc.l.a;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.v;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.ui.AppBrandDotPercentIndicator;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class a
  extends RelativeLayout
{
  private com.tencent.mm.plugin.appbrand.jsapi.video.ui.a A;
  private a.a B;
  private boolean C;
  private boolean D;
  private double E;
  private int F;
  private String G;
  private boolean H;
  private boolean I;
  private boolean J;
  private boolean K;
  private boolean L;
  private int M;
  private String N;
  private boolean O;
  private boolean P;
  private boolean Q;
  private boolean R;
  private boolean S;
  private boolean T = false;
  private boolean U = true;
  private boolean V = false;
  private boolean W = false;
  private int a = -1;
  private v aa;
  private int ab = 0;
  private int ac = -16777216;
  private e.c ad;
  private int ae;
  private RelativeLayout b;
  private e c;
  private TextView d;
  private DanmuView e;
  private e.a f;
  private View g;
  private View h;
  private TextView i;
  private LinearLayout j;
  private AppBrandDotPercentIndicator k;
  private TextView l;
  private ImageView m;
  private ImageView n;
  private ImageView o;
  private ImageView p;
  private FrameLayout q;
  private String r;
  private int s;
  private String t;
  private c u;
  private boolean v;
  private boolean w;
  private com.tencent.luggage.wxa.mg.b x;
  private boolean y;
  private boolean z;
  
  public <T extends View,  extends e> a(Context paramContext, T paramT)
  {
    super(paramContext);
    this.c = ((e)paramT);
    a(paramContext);
    this.b.addView(paramT);
  }
  
  private d a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    int i2 = paramJSONObject.optInt("time", 0);
    String str = paramJSONObject.optString("text", "");
    int i1 = g.a(paramJSONObject.optString("color", ""));
    if (i1 == 0) {
      i1 = -1;
    }
    return new com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a(getContext(), new SpannableString(str), i1, 0, 3.0F, i2);
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131624235, this);
    setBackgroundColor(this.ac);
    this.b = ((RelativeLayout)findViewById(2131449765));
    this.d = ((TextView)findViewById(2131440726));
    this.g = findViewById(2131431464);
    this.h = findViewById(2131431478);
    this.i = ((TextView)findViewById(2131431484));
    this.j = ((LinearLayout)findViewById(2131427841));
    this.k = ((AppBrandDotPercentIndicator)findViewById(2131427842));
    this.l = ((TextView)findViewById(2131427839));
    this.m = ((ImageView)findViewById(2131427840));
    this.n = ((ImageView)findViewById(2131431458));
    this.o = ((ImageView)findViewById(2131440399));
    this.p = ((ImageView)findViewById(2131440398));
    this.q = ((FrameLayout)findViewById(2131440400));
    this.k.setDotsNum(8);
    ((ImageView)findViewById(2131431477)).setOnClickListener(new a.1(this));
    k();
    n();
  }
  
  private String b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c(paramInt / 60));
    localStringBuilder.append(":");
    localStringBuilder.append(c(paramInt % 60));
    return localStringBuilder.toString();
  }
  
  private void b(boolean paramBoolean)
  {
    com.tencent.luggage.wxa.mg.b localb = this.x;
    if (localb == null) {
      return;
    }
    localb.a(this.s, paramBoolean, this.ae);
  }
  
  private String c(int paramInt)
  {
    if (paramInt < 10)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("0");
      localStringBuilder.append(paramInt);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
  
  private void c(String paramString1, String paramString2)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "leonlad setPreLoadVideoPath %s", new Object[] { paramString1 });
    if ((!this.c.b()) && (this.N.equalsIgnoreCase(paramString2)))
    {
      this.N = paramString2;
      this.c.a(this.C, paramString1, 0);
      if (this.v)
      {
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay true");
        a();
      }
      else
      {
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay false");
        j();
      }
    }
    paramString1 = this.x;
    if (paramString1 != null) {
      paramString1.a(paramString2);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    boolean bool = true;
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "updateLiveUI isLive:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    e.a locala = this.f;
    if (((this.J) || (this.K)) && (!paramBoolean)) {
      paramBoolean = bool;
    } else {
      paramBoolean = false;
    }
    locala.setShowProgress(paramBoolean);
  }
  
  private void j()
  {
    e locale = this.c;
    if (locale != null) {
      locale.a();
    }
  }
  
  private void k()
  {
    this.A = new com.tencent.mm.plugin.appbrand.jsapi.video.ui.a(getContext(), this, new a.10(this));
  }
  
  private void l()
  {
    this.f.n();
  }
  
  private void m()
  {
    this.f.o();
  }
  
  private void n()
  {
    this.c.setIMMVideoViewCallback(new a.11(this));
  }
  
  private boolean o()
  {
    if (this.Q) {
      return true;
    }
    boolean bool = s();
    if (!t()) {
      bool = false;
    }
    return bool;
  }
  
  private void p()
  {
    this.e = ((DanmuView)findViewById(2131431573));
    this.e.setDanmuViewCallBack(new a.12(this));
    this.e.a(0.0F, 0.8F);
    this.e.setMaxRunningPerRow(5);
    this.e.setPickItemInterval(200);
    this.e.d();
    e locale = this.c;
    if ((locale != null) && (((View)locale).getHeight() > 0))
    {
      int i1 = (int)(this.e.getYOffset() * ((View)this.c).getHeight());
      float f1 = com.tencent.mm.plugin.appbrand.jsapi.video.danmu.b.a(getContext());
      this.e.setMaxRow((int)(i1 / f1));
    }
  }
  
  private void q()
  {
    boolean bool = this.f.p();
    if ((this.w) && (this.J) && (this.U) && (!bool) && (!r()) && (!u()))
    {
      this.q.setVisibility(0);
      return;
    }
    this.q.setVisibility(8);
  }
  
  private boolean r()
  {
    return (this.C) || (this.c.c());
  }
  
  private boolean s()
  {
    return (this.I) && (!this.c.c()) && (!u());
  }
  
  private void setCover(String paramString)
  {
    if (af.c(paramString)) {
      return;
    }
    if (!af.c(this.G))
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "setCover mCoverUrl not null");
      return;
    }
    l.a().c(new a.8(this, paramString));
  }
  
  private boolean t()
  {
    return (!u()) && (((!h()) && (this.y)) || ((h()) && (this.z)));
  }
  
  private boolean u()
  {
    return this.g.getVisibility() == 0;
  }
  
  private void v()
  {
    if (this.aa == null) {
      this.aa = new v(new a.7(this), true);
    }
    this.aa.a(500L);
  }
  
  private void w()
  {
    v localv = this.aa;
    if (localv != null) {
      localv.c();
    }
  }
  
  public void a()
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "start");
    if (this.c.b())
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "start, video is playing");
      return;
    }
    if (!this.V)
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "start, video not prepared");
      this.W = true;
    }
    else
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "start, video prepared, reset control flag");
      this.W = false;
    }
    if (this.w) {
      this.f.j();
    }
    this.g.setVisibility(8);
    this.c.d();
    if ((this.e != null) && (this.f.a())) {
      this.e.b();
    }
    if (com.tencent.luggage.wxa.ba.e.a(h.class) != null) {
      ((h)com.tencent.luggage.wxa.ba.e.a(h.class)).a(this.N);
    }
  }
  
  public void a(double paramDouble)
  {
    a(paramDouble, false);
  }
  
  public void a(double paramDouble, boolean paramBoolean)
  {
    int i1 = this.c.getCurrPosSec();
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "seek to position=%s current=%d isLive=%b", new Object[] { Double.valueOf(paramDouble), Integer.valueOf(i1), Boolean.valueOf(this.C) });
    if (r()) {
      return;
    }
    this.g.setVisibility(8);
    if (paramBoolean) {
      this.c.a(paramDouble, paramBoolean);
    } else {
      this.c.a(paramDouble);
    }
    DanmuView localDanmuView = this.e;
    if ((localDanmuView != null) && (i1 > paramDouble)) {
      localDanmuView.a((int)paramDouble);
    }
  }
  
  public void a(int paramInt)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "onUIPause, type:%d", new Object[] { Integer.valueOf(paramInt) });
    if (((paramInt == 2) && (!this.S)) || ((paramInt == 1) && (!this.R)))
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "onUIPause, should skip ui pause");
      this.T = true;
      return;
    }
    this.c.h();
  }
  
  public void a(e.a parama)
  {
    this.f = parama;
    parama = this.f;
    if (((parama instanceof View)) && (parama != null))
    {
      parama = (View)parama;
      if (parama.getId() != -1) {
        parama.setId(2131428604);
      }
    }
    this.f.d();
    this.f.setFullScreenBtnOnClickListener(new a.13(this));
    this.f.setIplaySeekCallback(new a.14(this));
    this.f.setOnPlayButtonClickListener(new a.15(this));
    this.f.setStatePorter(new a.2(this));
    this.f.setMuteBtnOnClickListener(new a.3(this));
    this.f.setExitFullScreenBtnOnClickListener(new a.4(this));
    this.f.a(new a.5(this));
    this.f.setOnUpdateProgressLenListener(new a.6(this));
  }
  
  public void a(String paramString1, String paramString2)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "setCover:%s", new Object[] { paramString1 });
    if (af.c(paramString1)) {
      return;
    }
    this.G = paramString1;
    AppBrandSimpleImageLoader.instance().attach(this.n, paramString1, null, null);
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    c localc = this.u;
    Object localObject = paramString;
    if (localc != null)
    {
      localObject = paramString;
      if (localc.getFileSystem() != null)
      {
        localObject = paramString;
        if (this.u.getFileSystem().a(paramString))
        {
          paramString = this.u.getFileSystem().g(paramString);
          if (paramString == null)
          {
            localObject = null;
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("file://");
            ((StringBuilder)localObject).append(paramString.l());
            localObject = ((StringBuilder)localObject).toString();
          }
        }
      }
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "setVideoPath path=%s isLive=%s", new Object[] { localObject, Boolean.valueOf(paramBoolean) });
    if (af.c((String)localObject))
    {
      com.tencent.luggage.wxa.qz.o.f("MicroMsg.Video.AppBrandVideoView", "setVideoPath videoPath empty");
      return;
    }
    c();
    this.C = paramBoolean;
    this.N = ((String)localObject);
    this.c.setVideoSource(this.M);
    this.c.a(paramBoolean, (String)localObject, paramInt);
    double d1 = this.E;
    if (d1 > 0.0D) {
      this.c.a(d1, this.v);
    }
    if ((this.M == 1) && (com.tencent.luggage.wxa.ba.e.a(h.class) != null))
    {
      paramString = ((h)com.tencent.luggage.wxa.ba.e.a(h.class)).b(this.N);
      if (paramString != null)
      {
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "setVideoPath localVideoPath:%s", new Object[] { paramString });
        c(paramString, this.N);
      }
    }
    if (this.v)
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay true");
      a();
    }
    else
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay false");
      j();
    }
    setCover((String)localObject);
  }
  
  public void a(boolean paramBoolean)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "enableProgressGesture %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.I = paramBoolean;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "operateFullScreen toFullScreen:%b direction:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (this.B == null)
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.Video.AppBrandVideoView", "operateFullScreen mFullScreenDelegate null");
      return;
    }
    if (paramBoolean == h())
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "operateFullScreen current same");
      return;
    }
    int i1 = paramInt;
    if (paramInt == -1)
    {
      i1 = this.a;
      paramInt = i1;
      if (i1 == -1) {
        paramInt = 90;
      }
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "operateFullScreen target direction:%d", new Object[] { Integer.valueOf(paramInt) });
      i1 = paramInt;
    }
    if (paramBoolean)
    {
      this.ae = i1;
      this.B.a(i1);
      this.f.f();
      b(true);
      return;
    }
    this.B.a();
    this.f.g();
  }
  
  public boolean a(float paramFloat)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "setPlaybackRate %s", new Object[] { Float.valueOf(paramFloat) });
    return this.c.a(paramFloat);
  }
  
  public void b()
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "pause");
    if (!this.V)
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "pause, video not prepared");
      this.W = false;
      return;
    }
    if (!this.c.b())
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "pause, video not playing");
      return;
    }
    this.c.f();
    if ((this.e != null) && (this.f.a())) {
      this.e.c();
    }
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    if (this.e == null)
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.Video.AppBrandVideoView", " addDanmaku mDanmakuView null");
      p();
    }
    int i1 = g.a(paramString2);
    if (i1 == 0) {
      i1 = -1;
    }
    paramString1 = new com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a(getContext(), new SpannableString(paramString1), i1, 0, 3.0F, this.c.getCurrPosSec());
    this.e.a(paramString1);
    return true;
  }
  
  public void c()
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "stop");
    if (!this.V)
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "stop, video not prepared");
      this.W = false;
      return;
    }
    if (!this.c.b())
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "stop, video not playing");
      return;
    }
    this.c.e();
    this.f.k();
    DanmuView localDanmuView = this.e;
    if (localDanmuView != null) {
      localDanmuView.d();
    }
  }
  
  public void d()
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "onUIResume");
    if (this.T)
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "onUIResume, should skip ui resume");
      this.T = false;
      return;
    }
    this.c.g();
  }
  
  public void e()
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "onUIDestroy");
    f();
  }
  
  public void f()
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "clean");
    c();
    this.c.i();
    DanmuView localDanmuView = this.e;
    if (localDanmuView != null) {
      localDanmuView.e();
    }
    this.f.l();
    w();
  }
  
  public boolean g()
  {
    return this.x != null;
  }
  
  public int getCacheTimeSec()
  {
    e locale = this.c;
    if (locale != null) {
      return locale.getCacheTimeSec();
    }
    return 0;
  }
  
  public com.tencent.luggage.wxa.mg.b getCallback()
  {
    return this.x;
  }
  
  public String getCookieData()
  {
    return this.r;
  }
  
  public int getCurrPosMs()
  {
    return this.c.getCurrPosMs();
  }
  
  public int getCurrPosSec()
  {
    return this.c.getCurrPosSec();
  }
  
  public int getDuration()
  {
    int i1 = this.F;
    if (i1 > 0) {
      return i1;
    }
    return this.c.getVideoDurationSec();
  }
  
  public boolean h()
  {
    a.a locala = this.B;
    if (locala == null)
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.Video.AppBrandVideoView", "isInFullScreen mFullScreenDelegate null");
      return false;
    }
    return locala.b();
  }
  
  public void i()
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "onExitFullScreen");
    if (this.f.h()) {
      this.f.g();
    }
    b(false);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (o())
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.ui.a locala = this.A;
      if (locala != null) {
        locala.a(paramMotionEvent);
      }
      return true;
    }
    if ((paramMotionEvent.getAction() == 0) && (this.w) && (this.g.getVisibility() != 0))
    {
      this.f.b();
      if (this.P) {
        l();
      }
    }
    if (this.H) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAutoPauseIfNavigate(boolean paramBoolean)
  {
    this.R = paramBoolean;
  }
  
  public void setAutoPauseIfOpenNative(boolean paramBoolean)
  {
    this.S = paramBoolean;
  }
  
  public void setAutoPlay(boolean paramBoolean)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "setAutoPlay %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.v = paramBoolean;
  }
  
  public void setCallback(com.tencent.luggage.wxa.mg.b paramb)
  {
    this.x = paramb;
  }
  
  public void setComponent(c paramc)
  {
    this.u = paramc;
    this.t = paramc.getAppId();
  }
  
  public void setConsumeTouchEvent(boolean paramBoolean)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "setConsumeTouchEvent game=%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.H = paramBoolean;
  }
  
  public void setCookieData(String paramString)
  {
    this.r = paramString;
  }
  
  public void setDanmakuEnable(boolean paramBoolean)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "setDanmakuEnable %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.f.setDanmakuBtnOpen(paramBoolean);
  }
  
  public void setDanmakuItemList(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return;
    }
    int i2 = 0;
    if (paramJSONArray != null) {
      i1 = paramJSONArray.length();
    } else {
      i1 = 0;
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "setDanmakuItemList length=%d", new Object[] { Integer.valueOf(i1) });
    if (this.e == null)
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.Video.AppBrandVideoView", "setDanmakuItemList mDanmakuView null");
      p();
    }
    ArrayList localArrayList = new ArrayList();
    int i1 = i2;
    while (i1 < paramJSONArray.length())
    {
      d locald = a(paramJSONArray.optJSONObject(i1));
      if (locald != null) {
        localArrayList.add(locald);
      }
      i1 += 1;
    }
    this.e.a(localArrayList, true);
  }
  
  public void setDuration(int paramInt)
  {
    if (paramInt <= 0)
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "setDuration error duration=%d", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    this.i.setText(b(paramInt));
    this.F = paramInt;
  }
  
  public void setEnablePlayGesture(boolean paramBoolean)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "setEnablePlayGesture %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.Q = paramBoolean;
  }
  
  public void setFullScreenDelegate(a.a parama)
  {
    this.B = parama;
  }
  
  public void setFullScreenDirection(int paramInt)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "setFullScreenDirection %d", new Object[] { Integer.valueOf(paramInt) });
    this.a = paramInt;
  }
  
  public void setFullScreenState(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.f.f();
      return;
    }
    this.f.g();
  }
  
  public void setIMMVideoViewCallback(e.c paramc)
  {
    this.ad = paramc;
  }
  
  public void setInitialTime(double paramDouble)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "setInitialTime %s", new Object[] { Double.valueOf(paramDouble) });
    this.E = paramDouble;
  }
  
  public void setIsEnableBottomProgressBar(boolean paramBoolean)
  {
    this.U = paramBoolean;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "setIsShowBasicControls %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.w = paramBoolean;
    e.a locala = this.f;
    if (locala != null)
    {
      if (this.w)
      {
        locala.c();
        return;
      }
      locala.d();
    }
  }
  
  public void setLoop(boolean paramBoolean)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "setLoop %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.D = paramBoolean;
  }
  
  public void setMute(boolean paramBoolean)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "setMute %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.O = paramBoolean;
    this.c.setMute(paramBoolean);
    this.f.setMuteBtnState(paramBoolean);
  }
  
  public void setObjectFit(String paramString)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "setObjectFit %s", new Object[] { paramString });
    if ("fill".equalsIgnoreCase(paramString))
    {
      this.c.setScaleType(e.h.b);
      this.n.setScaleType(ImageView.ScaleType.FIT_XY);
      return;
    }
    if ("cover".equalsIgnoreCase(paramString))
    {
      this.c.setScaleType(e.h.d);
      this.n.setScaleType(ImageView.ScaleType.CENTER_CROP);
      return;
    }
    this.c.setScaleType(e.h.c);
    this.n.setScaleType(ImageView.ScaleType.FIT_CENTER);
  }
  
  public void setPageGesture(boolean paramBoolean)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "setPageGesture %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.y = paramBoolean;
  }
  
  public void setPageGestureInFullscreen(boolean paramBoolean)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "setPageGestureInFullscreen %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.z = paramBoolean;
  }
  
  public void setPlayBtnPosition(String paramString)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "setPlayBtnPosition %s", new Object[] { paramString });
    if ((!af.c(paramString)) && (paramString.equalsIgnoreCase("center")))
    {
      this.f.setPlayBtnInCenterPosition(true);
      return;
    }
    this.f.setPlayBtnInCenterPosition(false);
  }
  
  public void setShowCenterPlayBtn(boolean paramBoolean)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "setShowCenterPlayBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.L = paramBoolean;
    Object localObject = this.g;
    int i2 = 8;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((View)localObject).setVisibility(i1);
    localObject = this.h;
    int i1 = i2;
    if (paramBoolean) {
      i1 = 0;
    }
    ((View)localObject).setVisibility(i1);
    if (this.L)
    {
      localObject = this.f;
      if (localObject != null) {
        ((e.a)localObject).d();
      }
    }
  }
  
  public void setShowControlProgress(boolean paramBoolean)
  {
    boolean bool = true;
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "setShowControlProgress %b", new Object[] { Boolean.valueOf(paramBoolean) });
    e.a locala = this.f;
    if ((paramBoolean) && (!r())) {
      paramBoolean = bool;
    } else {
      paramBoolean = false;
    }
    locala.setShowControlProgress(paramBoolean);
  }
  
  public void setShowDanmakuBtn(boolean paramBoolean)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "setShowDanmakuBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (this.e == null) {
        p();
      }
      this.f.setDanmakuBtnOnClickListener(new a.9(this));
    }
    this.f.setShowDanmakuBtn(paramBoolean);
  }
  
  public void setShowFullScreenBtn(boolean paramBoolean)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "setShowFullScreenBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.f.setShowFullScreenBtn(paramBoolean);
  }
  
  public void setShowMuteBtn(boolean paramBoolean)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "showMuteBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.f.setShowMuteBtn(paramBoolean);
  }
  
  public void setShowPlayBtn(boolean paramBoolean)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "setShowPlayBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.f.setShowPlayBtn(paramBoolean);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    boolean bool = true;
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "setShowProgress %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.J = paramBoolean;
    e.a locala = this.f;
    if (((paramBoolean) || (this.K)) && (!r())) {
      paramBoolean = bool;
    } else {
      paramBoolean = false;
    }
    locala.setShowProgress(paramBoolean);
  }
  
  public void setShowProgressBarInControlMode(boolean paramBoolean)
  {
    boolean bool = true;
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "setShowProgressInControlMode %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.K = paramBoolean;
    e.a locala = this.f;
    if (((this.J) || (paramBoolean)) && (!r())) {
      paramBoolean = bool;
    } else {
      paramBoolean = false;
    }
    locala.setShowProgress(paramBoolean);
  }
  
  public void setTitle(String paramString)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "setTitle %s", new Object[] { paramString });
    this.f.setTitle(paramString);
  }
  
  public void setVideoPlayerId(int paramInt)
  {
    this.s = paramInt;
  }
  
  public void setVideoSource(int paramInt)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Video.AppBrandVideoView", "setVideoSource %d", new Object[] { Integer.valueOf(paramInt) });
    this.M = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ma.a
 * JD-Core Version:    0.7.0.1
 */