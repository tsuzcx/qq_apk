package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;

@SuppressLint({"ViewConstructor"})
public class y
  extends x
{
  private y.a a;
  private y.b b;
  private boolean c = false;
  private am d;
  private LinearLayout e;
  private TextView f;
  private View g;
  private ImageView h;
  private ImageView i;
  private ImageView j;
  private final Runnable k = new y.1(this);
  private long l = 0L;
  
  public y(Context paramContext, am paramam)
  {
    super(paramContext);
    this.d = paramam;
    this.e = ((LinearLayout)LayoutInflater.from(getContext()).inflate(2131624223, this, false));
    a(this.e, paramam.getWrapperView());
    j();
  }
  
  private AnimationDrawable a(int paramInt, float[] paramArrayOfFloat)
  {
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AnimationDrawable hash:");
    localStringBuilder.append(localAnimationDrawable.hashCode());
    o.d("MicroMsg.AppBrandPullDownWebView", localStringBuilder.toString());
    localAnimationDrawable.setOneShot(false);
    localAnimationDrawable.addFrame(a(paramInt, paramArrayOfFloat[0]), 0);
    localAnimationDrawable.addFrame(a(paramInt, paramArrayOfFloat[1]), 300);
    localAnimationDrawable.addFrame(a(paramInt, paramArrayOfFloat[2]), 300);
    localAnimationDrawable.addFrame(a(paramInt, paramArrayOfFloat[3]), 300);
    return localAnimationDrawable;
  }
  
  private Drawable a(int paramInt, float paramFloat)
  {
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new OvalShape());
    localShapeDrawable.setIntrinsicHeight(32);
    localShapeDrawable.setIntrinsicWidth(32);
    localShapeDrawable.getPaint().setColor(paramInt);
    localShapeDrawable.getPaint().setAlpha((int)(paramFloat * 255.0F));
    return localShapeDrawable;
  }
  
  private void j()
  {
    this.f = ((TextView)findViewById(2131428578));
    this.g = findViewById(2131428574);
    this.h = ((ImageView)findViewById(2131428575));
    this.i = ((ImageView)findViewById(2131428576));
    this.j = ((ImageView)findViewById(2131428577));
  }
  
  private void k()
  {
    this.f.setTextColor(-1);
    this.f.setAlpha(0.4F);
  }
  
  private void l()
  {
    this.f.setTextColor(-16777216);
    this.f.setAlpha(0.2F);
  }
  
  private void m()
  {
    ImageView localImageView = this.h;
    if (localImageView == null)
    {
      o.c("MicroMsg.AppBrandPullDownWebView", "setupLightLoading but mLoading0 is null, try protect");
      return;
    }
    localImageView.setImageDrawable(a(-1, new float[] { 0.2F, 0.6F, 0.4F, 0.2F }));
    this.i.setImageDrawable(a(-1, new float[] { 0.2F, 0.2F, 0.6F, 0.4F }));
    this.j.setImageDrawable(a(-1, new float[] { 0.2F, 0.4F, 0.2F, 0.6F }));
  }
  
  private void n()
  {
    ImageView localImageView = this.h;
    if (localImageView == null)
    {
      o.c("MicroMsg.AppBrandPullDownWebView", "setupDarkLoading but mLoading0 is null, try protect");
      return;
    }
    localImageView.setImageDrawable(a(-16777216, new float[] { 0.1F, 0.4F, 0.2F, 0.1F }));
    this.i.setImageDrawable(a(-16777216, new float[] { 0.1F, 0.1F, 0.4F, 0.2F }));
    this.j.setImageDrawable(a(-16777216, new float[] { 0.1F, 0.2F, 0.1F, 0.4F }));
  }
  
  protected void a(int paramInt)
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((y.b)localObject).a(paramInt);
    }
    if (!this.c) {
      return;
    }
    removeCallbacks(this.k);
    int m = paramInt;
    if (paramInt > this.e.getHeight()) {
      m = this.e.getHeight();
    }
    localObject = this.e;
    ((LinearLayout)localObject).setTranslationY(m - ((LinearLayout)localObject).getHeight());
  }
  
  public void a(String paramString, int paramInt)
  {
    setBackgroundTextStyle(paramString);
    setPullDownBackgroundColor(paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    setNeedStay(paramBoolean);
    View localView = this.g;
    int m;
    if (paramBoolean) {
      m = 0;
    } else {
      m = 4;
    }
    localView.setVisibility(m);
  }
  
  protected void d()
  {
    h();
    y.a locala = this.a;
    if (locala != null) {
      locala.a();
    }
    this.l = System.currentTimeMillis();
  }
  
  protected void e()
  {
    i();
  }
  
  protected boolean f()
  {
    return this.d.c();
  }
  
  public void g()
  {
    long l1 = System.currentTimeMillis() - this.l;
    if (l1 < 1000L)
    {
      postDelayed(new y.2(this), 1000L - l1);
      return;
    }
    c();
  }
  
  protected int getStayHeight()
  {
    return this.e.getHeight();
  }
  
  public void h()
  {
    ImageView localImageView = this.h;
    if (localImageView == null)
    {
      o.b("MicroMsg.AppBrandPullDownWebView", "startLoadingAnimation, mLoading0 is null");
      return;
    }
    if (localImageView.getDrawable() == null)
    {
      o.c("MicroMsg.AppBrandPullDownWebView", "startLoadingAnimation but drawable is null, try protect");
      n();
      l();
    }
    ((AnimationDrawable)this.h.getDrawable()).start();
    ((AnimationDrawable)this.i.getDrawable()).start();
    ((AnimationDrawable)this.j.getDrawable()).start();
  }
  
  public void i()
  {
    ImageView localImageView = this.h;
    if ((localImageView != null) && (localImageView.getDrawable() != null))
    {
      ((AnimationDrawable)this.h.getDrawable()).stop();
      ((AnimationDrawable)this.h.getDrawable()).selectDrawable(0);
      ((AnimationDrawable)this.i.getDrawable()).stop();
      ((AnimationDrawable)this.i.getDrawable()).selectDrawable(0);
      ((AnimationDrawable)this.j.getDrawable()).stop();
      ((AnimationDrawable)this.j.getDrawable()).selectDrawable(0);
      return;
    }
    o.c("MicroMsg.AppBrandPullDownWebView", "stopLoadingAnimation but drawable is null, try protect");
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    post(this.k);
  }
  
  public void setBackgroundTextStyle(String paramString)
  {
    if ("light".equals(paramString))
    {
      m();
      k();
      return;
    }
    if ("dark".equals(paramString))
    {
      n();
      l();
      return;
    }
    if ("ignore".equals(paramString)) {
      return;
    }
    n();
    l();
  }
  
  public void setHeadViewHeight(int paramInt)
  {
    if (paramInt <= this.e.getHeight()) {
      return;
    }
    this.e.getLayoutParams().height = paramInt;
    this.e.requestLayout();
  }
  
  public void setOnPullDownListener(y.a parama)
  {
    this.a = parama;
  }
  
  public void setOnPullDownOffsetListener(y.b paramb)
  {
    this.b = paramb;
  }
  
  public void setPullDownText(String paramString)
  {
    if (af.c(paramString))
    {
      this.f.setVisibility(8);
      return;
    }
    this.f.setVisibility(0);
    this.f.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.y
 * JD-Core Version:    0.7.0.1
 */