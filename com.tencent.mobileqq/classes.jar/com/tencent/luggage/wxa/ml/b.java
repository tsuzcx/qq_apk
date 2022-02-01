package com.tencent.luggage.wxa.ml;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.wxa.ma.e;
import com.tencent.luggage.wxa.ma.e.b;
import com.tencent.luggage.wxa.ma.e.c;
import com.tencent.luggage.wxa.ma.e.d;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.s;
import com.tencent.luggage.wxa.qz.v;
import com.tencent.luggage.wxa.qz.x;
import com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar;

public abstract class b
  extends RelativeLayout
  implements e, d.a, d.b, d.c, d.d, d.e
{
  protected v A = new v(new b.4(this), false);
  protected v B = new v(new b.5(this), true);
  private e.d C = p();
  private View.OnClickListener D = q();
  private boolean E = false;
  private Runnable F = new b.8(this);
  protected Context a;
  protected boolean b = true;
  protected ImageView c;
  protected RelativeLayout d;
  protected TextView e;
  protected ProgressBar f;
  protected TextView g;
  protected LinearLayout h;
  protected VideoPlayerSeekBar i;
  protected e.b j;
  protected d k;
  protected boolean l;
  protected boolean m = true;
  protected int n = 0;
  protected boolean o = false;
  protected e.c p;
  protected s q = new s(Looper.getMainLooper());
  protected int r = 0;
  protected boolean s = true;
  protected int t = -1;
  protected int u = 0;
  protected boolean v = false;
  protected boolean w = false;
  protected long x = 0L;
  protected int y = 0;
  protected v z = new v(new b.1(this), true);
  
  public b(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public b(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    k();
  }
  
  private void G()
  {
    o.d("MicroMsg.Video.AbstractVideoView", "%s reset error count ", new Object[] { v() });
    this.u = 0;
  }
  
  private void c(boolean paramBoolean)
  {
    e.b localb = this.j;
    if (localb != null) {
      localb.a(paramBoolean);
    }
  }
  
  private String e(int paramInt1, int paramInt2)
  {
    if (paramInt1 == -1010) {
      return "MEDIA_ERR_SRC_NOT_SUPPORTED";
    }
    if (paramInt1 == -1007) {
      return "MEDIA_ERR_SRC_NOT_SUPPORTED";
    }
    if (paramInt1 == -1004)
    {
      if (!x.a(this.a)) {
        return "MEDIA_ERR_NETWORK";
      }
      return "MEDIA_ERR_DECODE";
    }
    if (!x.a(this.a)) {
      return "MEDIA_ERR_NETWORK";
    }
    return "MEDIA_ERR_DECODE";
  }
  
  public void A()
  {
    o.d("MicroMsg.Video.AbstractVideoView", "%s onTextureUpdate ", new Object[] { v() });
    s();
  }
  
  public void B()
  {
    o.d("MicroMsg.Video.AbstractVideoView", "%s onCompletion, curMs %d, duration %d", new Object[] { v(), Integer.valueOf(getCurrPosSec()), Integer.valueOf(getVideoDurationSec()) });
    b(getVideoDurationSec());
    s();
    m();
    e.c localc = this.p;
    if (localc != null) {
      localc.b(getSessionId(), getMediaId());
    }
    this.y = 0;
    this.x = 0;
  }
  
  public void C()
  {
    o.d("MicroMsg.Video.AbstractVideoView", "%s on surface available", new Object[] { v() });
    a(false);
  }
  
  protected boolean D()
  {
    long l1 = this.k.getLastSurfaceUpdateTime();
    int i1 = this.k.getCurrentPosition();
    o.e("MicroMsg.Video.AbstractVideoView", "%s check surface is update surface[%d %d] playtime[%d %d]", new Object[] { v(), Long.valueOf(this.x), Long.valueOf(l1), Integer.valueOf(this.y), Integer.valueOf(i1) });
    if ((l1 > 0L) && (l1 == this.x) && (i1 != this.y))
    {
      o.c("MicroMsg.Video.AbstractVideoView", "%s check surface is update error", new Object[] { v() });
      a(this.y / 1000, true);
      return false;
    }
    this.x = l1;
    this.y = i1;
    return true;
  }
  
  protected boolean E()
  {
    return false;
  }
  
  protected boolean F()
  {
    return true;
  }
  
  protected d a(Context paramContext)
  {
    return null;
  }
  
  protected void a(int paramInt)
  {
    e.b localb = this.j;
    if (localb != null) {
      localb.b(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    o.c("MicroMsg.Video.AbstractVideoView", "%s onError info [%d %d] errorCount[%d]", new Object[] { v(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.u) });
    this.u += 1;
    if (this.u > 5)
    {
      e.c localc = this.p;
      if (localc != null) {
        localc.a(getSessionId(), getMediaId(), e(paramInt1, paramInt2), paramInt1, paramInt2);
      }
      e();
      s();
      return;
    }
    paramInt2 = getCurrPosSec();
    int i1 = this.t;
    paramInt1 = i1;
    if (i1 == -1) {
      paramInt1 = paramInt2;
    }
    o.d("MicroMsg.Video.AbstractVideoView", "%s onError now, try to start again. currPlaySec[%d] seekTimeWhenPrepared[%d] currPosSec[%d]", new Object[] { v(), Integer.valueOf(paramInt1), Integer.valueOf(this.t), Integer.valueOf(paramInt2) });
    e();
    r();
    this.q.b(new b.3(this, paramInt1), 200L);
  }
  
  protected void a(long paramLong)
  {
    this.q.b(this.F);
    this.q.b(this.F, paramLong);
  }
  
  protected void a(boolean paramBoolean)
  {
    o.e("MicroMsg.Video.AbstractVideoView", "%s start timer rightNow[%b]", new Object[] { v(), Boolean.valueOf(paramBoolean) });
    this.z.a(500L);
  }
  
  public boolean a(double paramDouble)
  {
    return a(paramDouble, b());
  }
  
  public boolean a(double paramDouble, boolean paramBoolean)
  {
    boolean bool2 = y();
    int i2 = getVideoDurationSec();
    int i3 = (int)paramDouble;
    int i1 = i3;
    if (i2 > 0)
    {
      i1 = i3;
      if (paramDouble > i2) {
        i1 = i2;
      }
    }
    d locald = this.k;
    boolean bool1;
    if ((locald != null) && (!af.c(locald.getVideoPath()))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    o.h("MicroMsg.Video.AbstractVideoView", "%s seek to [%d %s] seconds afterPlay[%b] isPrepared[%b] duration[%d] hadSetPath[%b]", new Object[] { v(), Integer.valueOf(i1), Double.valueOf(paramDouble), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Integer.valueOf(i2), Boolean.valueOf(bool1) });
    if (bool2)
    {
      if (this.k != null)
      {
        r();
        b(i1);
        this.k.a(i1 * 1000, paramBoolean);
        return paramBoolean;
      }
    }
    else
    {
      this.t = i1;
      if (bool1)
      {
        this.s = true;
        return false;
      }
      this.s = paramBoolean;
      d();
    }
    return false;
  }
  
  public int b(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  protected void b(int paramInt)
  {
    a(paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    o.d("MicroMsg.Video.AbstractVideoView", "%s on seek complete startPlay[%b]", new Object[] { v(), Boolean.valueOf(paramBoolean) });
    Object localObject = this.k;
    if (localObject != null) {
      ((d)localObject).setOneTimeVideoTextureUpdateCallback(this);
    }
    s();
    c(paramBoolean);
    b(getCurrPosSec());
    if (paramBoolean)
    {
      a(false);
      this.o = false;
      localObject = this.p;
      if (localObject != null) {
        ((e.c)localObject).d(getSessionId(), getMediaId());
      }
    }
  }
  
  public boolean b()
  {
    d locald = this.k;
    if (locald != null) {
      return locald.e();
    }
    return false;
  }
  
  protected <T> T c(int paramInt)
  {
    return findViewById(paramInt);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    o.d("MicroMsg.Video.AbstractVideoView", "%s on get video size [%d, %d]", new Object[] { v(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    e.c localc = this.p;
    if (localc != null) {
      localc.a(getSessionId(), getMediaId(), paramInt1, paramInt2);
    }
  }
  
  public void e()
  {
    o.d("MicroMsg.Video.AbstractVideoView", "%s stop", new Object[] { v() });
    d locald = this.k;
    if (locald != null) {
      locald.b();
    }
    this.t = -1;
    this.s = true;
    this.w = false;
    this.y = 0;
    this.x = 0;
    m();
    this.q.b(new b.2(this), 10L);
  }
  
  public boolean f()
  {
    o.d("MicroMsg.Video.AbstractVideoView", "%s pause", new Object[] { v() });
    if (this.k != null)
    {
      c(false);
      this.k.d();
      m();
      e.c localc = this.p;
      if (localc != null) {
        localc.c(getSessionId(), getMediaId());
      }
      return true;
    }
    return false;
  }
  
  public void g()
  {
    o.d("MicroMsg.Video.AbstractVideoView", "%s onUIResume %s", new Object[] { v(), af.c() });
    this.b = true;
  }
  
  public int getCacheTimeSec()
  {
    return 0;
  }
  
  public int getCurrPosMs()
  {
    d locald = this.k;
    if (locald != null) {
      return locald.getCurrentPosition();
    }
    return 0;
  }
  
  public int getCurrPosSec()
  {
    d locald = this.k;
    if (locald != null) {
      return Math.round(locald.getCurrentPosition() * 1.0F / 1000.0F);
    }
    return 0;
  }
  
  protected String getMediaId()
  {
    return "";
  }
  
  public int getPlayerType()
  {
    return this.r;
  }
  
  public String getSessionId()
  {
    return "";
  }
  
  public int getVideoDurationSec()
  {
    d locald = this.k;
    if (locald != null) {
      return Math.round(locald.getDuration() * 1.0F / 1000.0F);
    }
    return -1;
  }
  
  public int getVideoSource()
  {
    return 0;
  }
  
  public void h()
  {
    o.d("MicroMsg.Video.AbstractVideoView", "%s onUIPause %s", new Object[] { v(), af.c() });
    this.n = getCurrPosSec();
    this.o = b();
    this.y = 0;
    this.x = 0;
    f();
    m();
    this.b = false;
  }
  
  public void i()
  {
    o.d("MicroMsg.Video.AbstractVideoView", "%s onUIDestroy", new Object[] { v() });
    e();
    this.q.a(null);
    m();
    o();
  }
  
  protected int j()
  {
    return 2131624197;
  }
  
  protected void k()
  {
    o.d("MicroMsg.Video.AbstractVideoView", "%s init abstract video view", new Object[] { v() });
    LayoutInflater.from(this.a).inflate(j(), this);
    this.c = ((ImageView)c(2131449726));
    this.d = ((RelativeLayout)c(2131449703));
    this.e = ((TextView)c(2131449537));
    this.f = ((ProgressBar)c(2131449631));
    this.g = ((TextView)c(2131449729));
    this.h = ((LinearLayout)c(2131449602));
    Object localObject = (VideoPlayerSeekBar)c(2131449665);
    this.i = ((VideoPlayerSeekBar)localObject);
    this.j = ((e.b)localObject);
    localObject = this.i;
    if (localObject != null)
    {
      ((VideoPlayerSeekBar)localObject).setIplaySeekCallback(this.C);
      this.i.setOnClickListener(this.D);
    }
    this.k = a(this.a);
    this.k.setVideoCallback(this);
    this.k.setOnSeekCompleteCallback(this);
    this.k.setOnInfoCallback(this);
    this.k.setOnSurfaceCallback(this);
    localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.d.addView((View)this.k, 0, (ViewGroup.LayoutParams)localObject);
  }
  
  public void l()
  {
    e.b localb = this.j;
    if (localb != null) {
      this.h.removeView((View)localb);
    }
  }
  
  protected void m()
  {
    this.z.c();
    this.A.c();
  }
  
  protected void n()
  {
    if (this.u > 0)
    {
      o.e("MicroMsg.Video.AbstractVideoView", "%s start error check timer", new Object[] { v() });
      this.B.a(5000L);
    }
  }
  
  protected void o()
  {
    this.B.c();
  }
  
  protected e.d p()
  {
    return new b.6(this);
  }
  
  protected View.OnClickListener q()
  {
    return new b.7(this);
  }
  
  protected void r()
  {
    a(500L);
  }
  
  protected void s()
  {
    this.q.b(this.F);
    this.q.a(new b.9(this));
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    o.d("MicroMsg.Video.AbstractVideoView", "%s set cover", new Object[] { v() });
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      ImageView localImageView = this.c;
      if (localImageView != null) {
        localImageView.setImageBitmap(paramBitmap);
      }
    }
  }
  
  public void setFullDirection(int paramInt) {}
  
  public void setIMMVideoViewCallback(e.c paramc)
  {
    this.p = paramc;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    o.d("MicroMsg.Video.AbstractVideoView", "%s is show seek bar[%b]", new Object[] { v(), Boolean.valueOf(paramBoolean) });
    this.l = paramBoolean;
    if (this.l)
    {
      t();
      return;
    }
    u();
  }
  
  public void setMute(boolean paramBoolean)
  {
    d locald = this.k;
    if (locald != null) {
      locald.setMute(paramBoolean);
    }
  }
  
  public void setVideoFooterView(e.b paramb)
  {
    if (!(paramb instanceof View))
    {
      o.c("MicroMsg.Video.AbstractVideoView", "%s set video footer view but is not view", new Object[] { v() });
      return;
    }
    l();
    this.j = paramb;
    this.m = false;
    this.h.addView((View)this.j);
  }
  
  protected void setVideoTotalTime(int paramInt)
  {
    e.b localb = this.j;
    if ((localb != null) && (localb.getVideoTotalTime() != paramInt)) {
      this.j.setVideoTotalTime(paramInt);
    }
  }
  
  protected void t()
  {
    this.q.a(new b.10(this));
  }
  
  protected void u()
  {
    this.q.a(new b.11(this));
  }
  
  protected String v()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(hashCode());
    return localStringBuilder.toString();
  }
  
  public boolean w()
  {
    if (this.k == null) {
      return false;
    }
    if (b()) {
      f();
    } else if (af.c(this.k.getVideoPath())) {
      d();
    } else {
      x();
    }
    return true;
  }
  
  public boolean x()
  {
    if (!this.b)
    {
      o.c("MicroMsg.Video.AbstractVideoView", "%s ui on pause now, why u call me to play? [%s]", new Object[] { v(), af.c() });
      return false;
    }
    Object localObject = this.k;
    if (localObject != null)
    {
      boolean bool = ((d)localObject).f();
      o.d("MicroMsg.Video.AbstractVideoView", "%s video play [%b] isPlayOnUiPause[%b]", new Object[] { v(), Boolean.valueOf(bool), Boolean.valueOf(this.o) });
      c(bool);
      if (bool)
      {
        this.o = false;
        a(false);
        localObject = this.p;
        if (localObject != null) {
          ((e.c)localObject).d(getSessionId(), getMediaId());
        }
      }
      return bool;
    }
    return false;
  }
  
  protected boolean y()
  {
    d locald = this.k;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (locald != null)
    {
      bool1 = bool2;
      if (!af.c(locald.getVideoPath()))
      {
        bool1 = bool2;
        if (this.w) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void z()
  {
    o.d("MicroMsg.Video.AbstractVideoView", "%s onPrepared startWhenPrepared[%b] seekTimeWhenPrepared[%d] isPrepared[%b]", new Object[] { v(), Boolean.valueOf(this.s), Integer.valueOf(this.t), Boolean.valueOf(this.w) });
    this.w = true;
    Object localObject = this.k;
    if (localObject != null) {
      ((d)localObject).setOneTimeVideoTextureUpdateCallback(this);
    }
    setVideoTotalTime(getVideoDurationSec());
    if (this.s)
    {
      if (this.t <= -1)
      {
        if ((x()) && (F())) {
          this.A.a(1000L);
        }
      }
      else if (!c()) {
        a(this.t, this.s);
      } else {
        x();
      }
    }
    else
    {
      int i1 = this.t;
      if (i1 >= 0) {
        a(i1, false);
      }
    }
    this.t = -1;
    this.s = true;
    this.y = 0;
    this.x = 0;
    localObject = this.p;
    if (localObject != null) {
      ((e.c)localObject).a(getSessionId(), getMediaId());
    }
    n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ml.b
 * JD-Core Version:    0.7.0.1
 */