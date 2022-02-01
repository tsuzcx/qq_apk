package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.luggage.wxa.jx.f.b;
import com.tencent.luggage.wxa.jx.f.d;
import com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandCapsuleBarPlaceHolderView;
import com.tencent.mm.plugin.appbrand.widget.AppBrandActionBarCustomImageView;
import com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable;
import java.util.LinkedHashSet;
import java.util.Set;

public class b
  extends LinearLayout
  implements f.b, f.d, e
{
  protected ImageView a;
  protected View b;
  protected View c;
  protected View d;
  protected TextView e;
  protected ProgressBar f;
  protected CircleProgressDrawable g;
  protected int h;
  protected int i;
  protected double j;
  protected boolean k = false;
  protected boolean l = false;
  protected c m = new c();
  private b.b n;
  private AppBrandCapsuleBarPlaceHolderView o;
  private b.a p = new b.c(this, null);
  private b.d q;
  private final Set<a> r = new LinkedHashSet();
  private boolean s = false;
  private AppBrandActionBarCustomImageView t;
  private View u;
  
  public b(Context paramContext)
  {
    super(paramContext);
    d();
  }
  
  private void a(int paramInt)
  {
    b.b localb;
    if (e.a.a(paramInt) == e.a.b)
    {
      localb = this.n;
      if (localb != null) {
        localb.a(-1);
      }
    }
    else
    {
      localb = this.n;
      if (localb != null) {
        localb.a(-16777216);
      }
    }
  }
  
  private void i()
  {
    this.d.setOnClickListener(new b.5(this));
  }
  
  private void j()
  {
    View localView = this.b;
    int i1;
    if ((!this.l) && (!this.k)) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localView.setVisibility(i1);
    requestLayout();
  }
  
  private void k()
  {
    View localView = this.d;
    int i1;
    if (this.l) {
      i1 = 4;
    } else {
      i1 = 0;
    }
    localView.setVisibility(i1);
    requestLayout();
  }
  
  private void setBackgroundColorInternal(int paramInt)
  {
    if (!this.l)
    {
      super.setBackgroundColor(paramInt);
      return;
    }
    super.setBackgroundColor(0);
  }
  
  public void a()
  {
    CircleProgressDrawable localCircleProgressDrawable = this.g;
    if (localCircleProgressDrawable != null) {
      localCircleProgressDrawable.c();
    }
    removeAllViews();
  }
  
  public void a(Bitmap paramBitmap, View.OnClickListener paramOnClickListener)
  {
    post(new b.6(this, paramBitmap, paramOnClickListener));
  }
  
  public void a(a parama)
  {
    if (parama != null) {
      this.r.add(parama);
    }
    if (!this.s)
    {
      i();
      this.s = true;
    }
  }
  
  public void b()
  {
    CircleProgressDrawable localCircleProgressDrawable = this.g;
    if (localCircleProgressDrawable != null) {
      localCircleProgressDrawable.c();
    }
  }
  
  public void c()
  {
    if (g())
    {
      CircleProgressDrawable localCircleProgressDrawable = this.g;
      if (localCircleProgressDrawable != null) {
        localCircleProgressDrawable.b();
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    Object localObject = this.o;
    int i2 = 0;
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 4;
    }
    ((AppBrandCapsuleBarPlaceHolderView)localObject).setVisibility(i1);
    if (this.o.getLayoutParams() != null)
    {
      localObject = this.o.getLayoutParams();
      i1 = i2;
      if (paramBoolean) {
        i1 = -2;
      }
      ((ViewGroup.LayoutParams)localObject).width = i1;
      this.o.requestLayout();
    }
    localObject = this.n;
    if (localObject != null) {
      ((b.b)localObject).b(this.o.getVisibility());
    }
  }
  
  protected void d()
  {
    setOrientation(1);
    setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    setBackgroundResource(2131165402);
    this.u = LayoutInflater.from(getContext()).inflate(2131624198, this, false);
    addView(this.u);
    this.h = -1;
    this.i = getResources().getColor(2131165402);
    this.j = 1.0D;
    this.c = findViewById(2131427577);
    this.a = ((ImageView)findViewById(2131427578));
    this.b = findViewById(2131427576);
    this.d = findViewById(2131427580);
    this.e = ((TextView)findViewById(2131427582));
    this.f = ((ProgressBar)findViewById(2131427575));
    this.g = new CircleProgressDrawable(getContext());
    this.o = ((AppBrandCapsuleBarPlaceHolderView)findViewById(2131427570));
    this.b.setOnClickListener(new b.3(this));
  }
  
  public void e()
  {
    b.a locala = this.p;
    if (locala != null) {
      locala.a(this.a, this.b, this.c);
    }
    this.e.setTextColor(this.h);
    this.g.a(this.h);
    this.f.setIndeterminateDrawable(this.g);
    a(this.h);
  }
  
  public boolean f()
  {
    return this.k;
  }
  
  public boolean g()
  {
    return this.f.getVisibility() == 0;
  }
  
  public View getActionView()
  {
    return this;
  }
  
  public final double getBackgroundAlpha()
  {
    return this.j;
  }
  
  public final int getBackgroundColor()
  {
    if (this.l) {
      return 0;
    }
    return this.i;
  }
  
  public AppBrandCapsuleBarPlaceHolderView getCapsuleView()
  {
    return this.o;
  }
  
  public int getForegroundColor()
  {
    return this.h;
  }
  
  public CharSequence getMainTitle()
  {
    return this.e.getText();
  }
  
  public b.a getNavResetStyleListener()
  {
    return this.p;
  }
  
  public boolean h()
  {
    return this.l;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setActionBarHeight(int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = this.u.getLayoutParams();
    if ((localLayoutParams != null) && (localLayoutParams.height != paramInt))
    {
      localLayoutParams.height = paramInt;
      this.u.setLayoutParams(localLayoutParams);
    }
  }
  
  public void setBackButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.m.a(paramOnClickListener);
  }
  
  public final void setBackgroundAlpha(double paramDouble)
  {
    this.j = paramDouble;
    if (!this.l)
    {
      Drawable localDrawable2 = super.getBackground();
      Drawable localDrawable1 = localDrawable2;
      if (localDrawable2 == null)
      {
        setBackgroundColorInternal(this.i);
        localDrawable1 = super.getBackground();
      }
      localDrawable1.setAlpha((int)(paramDouble * 255.0D));
    }
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    this.i = paramInt;
    setBackgroundColorInternal(paramInt);
    setBackgroundAlpha(this.j);
  }
  
  public final void setCapsuleBarInteractionDelegate(b.b paramb)
  {
    this.n = paramb;
    paramb = this.n;
    if (paramb != null)
    {
      paramb.b(new b.1(this));
      this.n.a(new b.2(this));
    }
  }
  
  public void setCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.m.b(paramOnClickListener);
  }
  
  public void setForegroundColor(int paramInt)
  {
    this.h = paramInt;
    e();
  }
  
  public void setForegroundStyle(String paramString)
  {
    this.h = e.a.a(paramString).c;
    e();
  }
  
  public void setForegroundStyle(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = -16777216;
    } else {
      i1 = -1;
    }
    this.h = i1;
    e();
  }
  
  public void setFullscreenMode(boolean paramBoolean)
  {
    this.l = paramBoolean;
    j();
    k();
    setBackgroundColor(this.i);
  }
  
  public void setLoadingIconVisibility(boolean paramBoolean)
  {
    Object localObject = this.q;
    if (localObject != null)
    {
      ((b.d)localObject).a(paramBoolean);
      return;
    }
    localObject = this.f;
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((ProgressBar)localObject).setVisibility(i1);
    if (paramBoolean)
    {
      this.g.a();
      this.g.b();
      return;
    }
    this.g.c();
  }
  
  public void setMainTitle(CharSequence paramCharSequence)
  {
    boolean bool = isLayoutRequested();
    this.e.setText(paramCharSequence);
    if (bool) {
      requestLayout();
    }
  }
  
  public void setNavButtonLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.b.setOnLongClickListener(new b.4(this, paramOnLongClickListener));
  }
  
  public void setNavContainerMinimumWidth(int paramInt)
  {
    View localView = this.c;
    if (localView != null) {
      localView.setMinimumWidth(paramInt);
    }
  }
  
  public void setNavHidden(boolean paramBoolean)
  {
    this.k = paramBoolean;
    j();
    e();
  }
  
  public void setNavLoadingIconVisibilityResetListener(b.d paramd)
  {
    this.q = paramd;
  }
  
  public void setNavResetStyleListener(b.a parama)
  {
    this.p = parama;
  }
  
  public void setOptionButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.m.c(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.b
 * JD-Core Version:    0.7.0.1
 */