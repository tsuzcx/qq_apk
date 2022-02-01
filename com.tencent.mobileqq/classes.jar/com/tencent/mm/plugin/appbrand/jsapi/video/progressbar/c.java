package com.tencent.mm.plugin.appbrand.jsapi.video.progressbar;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.wxa.ma.e.a;
import com.tencent.luggage.wxa.ma.e.b;
import com.tencent.luggage.wxa.ma.e.e;
import com.tencent.luggage.wxa.ma.e.f;
import com.tencent.luggage.wxa.ma.e.g;
import com.tencent.luggage.wxa.ma.e.i;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.v;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class c
  extends VideoPlayerSeekBar
  implements e.a, e.b
{
  private v A;
  private boolean B;
  private boolean C;
  private boolean D;
  private boolean E;
  private boolean F;
  private boolean G;
  private boolean H;
  private boolean I = true;
  private e.e J;
  private ConcurrentLinkedQueue<e.f> K = new ConcurrentLinkedQueue();
  private ImageView n;
  private ImageView o;
  private LinearLayout p;
  private ImageView q;
  private FrameLayout r;
  private ImageView s;
  private ImageView t;
  private ImageView u;
  private TextView v;
  private LinearLayout w;
  private LinearLayout x;
  private e.i y;
  private v z;
  
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  private void A()
  {
    if (this.C)
    {
      this.o.setImageResource(2130838697);
      return;
    }
    this.o.setImageResource(2130838696);
  }
  
  private void B()
  {
    E();
    w();
    v();
    D();
    C();
  }
  
  private void C()
  {
    int i;
    if (this.B) {
      i = getResources().getDimensionPixelSize(2131296796);
    } else {
      i = getResources().getDimensionPixelSize(2131296786);
    }
    if (this.f != null)
    {
      localObject = (ViewGroup.MarginLayoutParams)this.f.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).setMarginStart(i);
      this.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    Object localObject = this.x;
    if (localObject != null)
    {
      localObject = (ViewGroup.MarginLayoutParams)((LinearLayout)localObject).getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).setMarginStart(i);
      this.x.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = this.o;
    if (localObject != null)
    {
      localObject = (ViewGroup.MarginLayoutParams)((ImageView)localObject).getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).setMarginStart(i);
      this.o.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = this.s;
    if (localObject != null)
    {
      localObject = (ViewGroup.MarginLayoutParams)((ImageView)localObject).getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).setMarginStart(i);
      this.s.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = this.n;
    if (localObject != null)
    {
      localObject = (ViewGroup.MarginLayoutParams)((ImageView)localObject).getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).setMarginStart(i);
      this.n.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  private void D()
  {
    int i;
    if (this.B) {
      i = getResources().getDimensionPixelSize(2131296799);
    } else {
      i = getResources().getDimensionPixelSize(2131296792);
    }
    float f = i;
    this.g.setTextSize(0, f);
    this.h.setTextSize(0, f);
  }
  
  private void E()
  {
    Object localObject = this.p.getLayoutParams();
    if (this.B) {
      ((ViewGroup.LayoutParams)localObject).height = getResources().getDimensionPixelSize(2131296797);
    } else {
      ((ViewGroup.LayoutParams)localObject).height = getResources().getDimensionPixelSize(2131296788);
    }
    this.p.setLayoutParams((ViewGroup.LayoutParams)localObject);
    int i;
    if (this.B) {
      i = getResources().getDimensionPixelSize(2131296798);
    } else {
      i = getResources().getDimensionPixelSize(2131296789);
    }
    this.p.setPadding(0, 0, i, 0);
    localObject = this.w;
    if (localObject != null) {
      ((LinearLayout)localObject).setPadding(i, 0, i, 0);
    }
  }
  
  private boolean F()
  {
    Object localObject = this.y;
    int j = 0;
    if (localObject == null)
    {
      o.d("MicroMsg.AppBrandVideoViewControlBar", "updateMiddleBar mStatePorter null");
      return false;
    }
    int m = ((e.i)localObject).a();
    int k = this.y.b();
    if (m >= 0)
    {
      if (k < 0) {
        return false;
      }
      int i = m;
      if (m > k) {
        i = k;
      }
      m = getBarLen();
      if (m <= 0) {
        return true;
      }
      if (k == 0)
      {
        i = j;
      }
      else
      {
        double d1 = m;
        double d2 = i;
        Double.isNaN(d2);
        double d3 = k;
        Double.isNaN(d3);
        d2 = d2 * 1.0D / d3;
        Double.isNaN(d1);
        i = (int)(d1 * d2);
      }
      localObject = (FrameLayout.LayoutParams)this.q.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).width = i;
      this.q.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return true;
    }
    return false;
  }
  
  private void G()
  {
    boolean bool = this.F;
    int j = 0;
    if (bool) {
      bool = this.E;
    } else {
      bool = false;
    }
    Object localObject = this.r;
    int i;
    if (bool) {
      i = 0;
    } else {
      i = 8;
    }
    ((FrameLayout)localObject).setVisibility(i);
    localObject = this.g;
    if (bool) {
      i = 0;
    } else {
      i = 8;
    }
    ((TextView)localObject).setVisibility(i);
    localObject = this.h;
    if (bool) {
      i = j;
    } else {
      i = 8;
    }
    ((TextView)localObject).setVisibility(i);
  }
  
  private void x()
  {
    if (this.G)
    {
      if (this.H)
      {
        this.f.setVisibility(8);
        this.t.setVisibility(0);
        return;
      }
      this.f.setVisibility(0);
      this.t.setVisibility(8);
      return;
    }
    this.f.setVisibility(8);
    this.t.setVisibility(8);
  }
  
  private void y()
  {
    if (this.m)
    {
      this.f.setImageResource(2130838704);
      this.t.setImageResource(2130838704);
      return;
    }
    this.f.setImageResource(2130838705);
    this.t.setImageResource(2130838705);
  }
  
  private void z()
  {
    this.C ^= true;
    A();
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    a(this.j, this.i);
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    e.e locale = this.J;
    if (locale != null) {
      locale.a(paramInt1, paramInt2);
    }
  }
  
  public void a(e.f paramf)
  {
    this.K.add(paramf);
  }
  
  public boolean a()
  {
    return this.C;
  }
  
  public void b()
  {
    if (e())
    {
      setVisibility(8);
      return;
    }
    c();
  }
  
  public void c()
  {
    setVisibility(0);
    if (!this.I) {
      return;
    }
    if (this.z == null) {
      this.z = new v(new c.2(this), false);
    }
    this.z.c();
    this.z.a(7000L);
  }
  
  public void d()
  {
    setVisibility(8);
  }
  
  public boolean e()
  {
    return getVisibility() == 0;
  }
  
  public void f()
  {
    this.B = true;
    B();
  }
  
  public void g()
  {
    this.B = false;
    B();
  }
  
  protected int getLayoutId()
  {
    return 2131624238;
  }
  
  public boolean h()
  {
    return this.B;
  }
  
  public boolean i()
  {
    return this.I;
  }
  
  public void j()
  {
    if (this.A == null) {
      this.A = new v(new c.3(this), true);
    }
    F();
    this.A.c();
    this.A.a(500L);
  }
  
  public void k()
  {
    v localv = this.A;
    if (localv != null) {
      localv.c();
    }
  }
  
  public void l()
  {
    v localv = this.A;
    if (localv != null) {
      localv.c();
    }
    localv = this.z;
    if (localv != null) {
      localv.c();
    }
  }
  
  public void m()
  {
    v localv = this.z;
    if (localv != null)
    {
      localv.c();
      this.z.a(7000L);
    }
  }
  
  public void n()
  {
    if ((this.G) && (this.H)) {
      this.t.setVisibility(8);
    }
  }
  
  public void o()
  {
    if ((this.G) && (this.H)) {
      this.t.setVisibility(0);
    }
  }
  
  public boolean p()
  {
    FrameLayout localFrameLayout = this.r;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localFrameLayout != null)
    {
      bool1 = bool2;
      if (getVisibility() == 0)
      {
        bool1 = bool2;
        if (this.r.getVisibility() == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected void q()
  {
    super.q();
    this.n = ((ImageView)this.b.findViewById(2131433903));
    this.o = ((ImageView)this.b.findViewById(2131431570));
    this.q = ((ImageView)this.b.findViewById(2131440415));
    this.r = ((FrameLayout)this.b.findViewById(2131440417));
    this.p = ((LinearLayout)findViewById(2131445137));
    this.s = ((ImageView)findViewById(2131439080));
    this.t = ((ImageView)findViewById(2131430441));
    this.u = ((ImageView)findViewById(2131432654));
    this.v = ((TextView)findViewById(2131447463));
    this.w = ((LinearLayout)findViewById(2131433914));
    this.x = ((LinearLayout)findViewById(2131440412));
  }
  
  public void setAutoHide(boolean paramBoolean)
  {
    this.I = paramBoolean;
  }
  
  public void setDanmakuBtnOnClickListener(e.g paramg)
  {
    this.o.setOnClickListener(new c.1(this, paramg));
  }
  
  public void setDanmakuBtnOpen(boolean paramBoolean)
  {
    this.C = paramBoolean;
    A();
  }
  
  public void setExitFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.u.setOnClickListener(paramOnClickListener);
  }
  
  public void setFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.n.setOnClickListener(paramOnClickListener);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    this.m = paramBoolean;
    y();
  }
  
  public void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.s.setOnClickListener(paramOnClickListener);
  }
  
  public void setMuteBtnState(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.s.setImageResource(2130838702);
      return;
    }
    this.s.setImageResource(2130838703);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnPlayButtonClickListener(paramOnClickListener);
    this.t.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnUpdateProgressLenListener(e.e parame)
  {
    this.J = parame;
  }
  
  public void setPlayBtnInCenterPosition(boolean paramBoolean)
  {
    this.H = paramBoolean;
    x();
  }
  
  public void setShowControlProgress(boolean paramBoolean)
  {
    this.F = paramBoolean;
    G();
  }
  
  public void setShowDanmakuBtn(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.o.setVisibility(0);
      return;
    }
    this.o.setVisibility(8);
  }
  
  public void setShowFullScreenBtn(boolean paramBoolean)
  {
    this.D = paramBoolean;
    w();
    v();
  }
  
  public void setShowMuteBtn(boolean paramBoolean)
  {
    ImageView localImageView = this.s;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localImageView.setVisibility(i);
  }
  
  public void setShowPlayBtn(boolean paramBoolean)
  {
    this.G = paramBoolean;
    x();
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    this.E = paramBoolean;
    G();
  }
  
  public void setStatePorter(e.i parami)
  {
    this.y = parami;
  }
  
  public void setTitle(String paramString)
  {
    if (!af.c(paramString)) {
      this.v.setText(paramString);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    Iterator localIterator;
    e.f localf;
    if (paramInt == 0)
    {
      localIterator = this.K.iterator();
      while (localIterator.hasNext())
      {
        localf = (e.f)localIterator.next();
        if (localf != null) {
          localf.a(true);
        }
      }
    }
    if ((paramInt == 8) || (paramInt == 4))
    {
      localIterator = this.K.iterator();
      while (localIterator.hasNext())
      {
        localf = (e.f)localIterator.next();
        if (localf != null) {
          localf.a(false);
        }
      }
    }
  }
  
  public void u()
  {
    if (this.i == 0) {
      return;
    }
    if (this.k) {
      return;
    }
    if (this.e == null) {
      return;
    }
    Object localObject = this.g;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c(this.j / 60));
    localStringBuilder.append(":");
    localStringBuilder.append(c(this.j % 60));
    ((TextView)localObject).setText(localStringBuilder.toString());
    if (getBarLen() == 0) {
      return;
    }
    localObject = (FrameLayout.LayoutParams)this.e.getLayoutParams();
    int i = getBarLen();
    ((FrameLayout.LayoutParams)localObject).leftMargin = b(this.j, i);
    this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (FrameLayout.LayoutParams)this.c.getLayoutParams();
    double d1 = this.j;
    Double.isNaN(d1);
    double d2 = this.i;
    Double.isNaN(d2);
    d1 = d1 * 1.0D / d2;
    d2 = i;
    Double.isNaN(d2);
    ((FrameLayout.LayoutParams)localObject).width = ((int)(d1 * d2));
    this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    requestLayout();
    a(this.j, this.i);
  }
  
  public void v()
  {
    if (this.B)
    {
      this.w.setVisibility(0);
      return;
    }
    this.w.setVisibility(8);
  }
  
  public void w()
  {
    if (this.D)
    {
      this.n.setVisibility(0);
      if (this.B)
      {
        this.n.setImageResource(2130838700);
        return;
      }
      this.n.setImageResource(2130838699);
      return;
    }
    this.n.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.c
 * JD-Core Version:    0.7.0.1
 */