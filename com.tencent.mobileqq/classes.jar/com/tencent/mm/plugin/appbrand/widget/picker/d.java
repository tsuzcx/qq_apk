package com.tencent.mm.plugin.appbrand.widget.picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.lo.c;
import com.tencent.luggage.wxa.pd.a;
import com.tencent.luggage.wxa.pd.a.a;
import com.tencent.luggage.wxa.pd.j;
import com.tencent.luggage.wxa.pd.s;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;

public class d
  extends FrameLayout
{
  TextView a;
  View b;
  View c;
  View d;
  View e;
  @Nullable
  private c f;
  private FrameLayout g;
  private d.a h;
  private boolean i;
  private View j;
  private boolean k;
  private d.b l;
  @Nullable
  private j m = null;
  
  public d(Context paramContext)
  {
    super(paramContext);
    d();
  }
  
  private String a(String paramString)
  {
    if ("设置时间".equals(paramString)) {
      return getContext().getString(2131886876);
    }
    if ("设置地区".equals(paramString)) {
      return getContext().getString(2131886875);
    }
    if ("设置日期".equals(paramString)) {
      return getContext().getString(2131886874);
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private void a(int paramInt)
  {
    super.setVisibility(paramInt);
  }
  
  private void a(View paramView)
  {
    this.c = paramView.findViewById(2131440289);
    this.d = this.c.findViewById(2131449783);
    h();
    this.c.findViewById(2131429750).setOnClickListener(new d.4(this));
    this.c.findViewById(2131429749).setOnClickListener(new d.5(this));
    this.c.setOnClickListener(new d.6(this));
  }
  
  private void a(boolean paramBoolean, Object paramObject)
  {
    if (!this.i)
    {
      d.a locala = this.h;
      if (locala != null)
      {
        this.i = true;
        locala.a(paramBoolean, paramObject);
        this.i = false;
      }
    }
  }
  
  private void b(View paramView)
  {
    paramView = paramView.findViewById(2131428563);
    paramView.setOnClickListener(new d.7(this));
    paramView.setBackgroundColor(ContextCompat.getColor(paramView.getContext(), 2131165193));
  }
  
  private void b(String paramString)
  {
    this.e.setVisibility(8);
    this.b.setVisibility(0);
    this.a.setVisibility(0);
    this.a.setText(paramString);
  }
  
  private void c()
  {
    this.h = null;
    this.l = null;
  }
  
  private void d()
  {
    setClickable(true);
    setLongClickable(true);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.gravity = 80;
    this.j = LayoutInflater.from(getContext()).inflate(2131624220, this, false);
    this.g = ((FrameLayout)this.j.findViewById(2131428563));
    this.e = this.j.findViewById(2131428561);
    a(this.j);
    b(this.j);
    addView(this.j, localLayoutParams);
    this.a = ((TextView)findViewById(2131428560));
    this.a.setClickable(true);
    this.b = findViewById(2131428559);
    addOnLayoutChangeListener(new d.3(this));
  }
  
  private void e()
  {
    f();
    this.a.setText("");
    this.b.setVisibility(8);
    this.a.setVisibility(8);
  }
  
  private void f()
  {
    g();
    this.e.setVisibility(0);
  }
  
  private void g()
  {
    int n;
    if (i()) {
      n = 0;
    } else {
      n = getContext().getResources().getDimensionPixelSize(2131296339);
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.e.getLayoutParams();
    localLayoutParams.height = n;
    this.e.setLayoutParams(localLayoutParams);
  }
  
  private void h()
  {
    int n;
    int i1;
    int i2;
    if (i())
    {
      n = getContext().getResources().getDimensionPixelSize(2131296336);
      i1 = getContext().getResources().getDimensionPixelSize(2131296336);
      i2 = getContext().getResources().getDimensionPixelSize(2131298213);
    }
    else
    {
      n = getContext().getResources().getDimensionPixelSize(2131296345);
      i1 = getContext().getResources().getDimensionPixelSize(2131296342);
      i2 = getContext().getResources().getDimensionPixelSize(2131298214);
    }
    ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)this.d.getLayoutParams();
    localLayoutParams.topMargin = n;
    localLayoutParams.bottomMargin = i1;
    this.d.setLayoutParams(localLayoutParams);
    this.c.setLayoutParams(new LinearLayout.LayoutParams(-1, i2));
  }
  
  private boolean i()
  {
    return s.c == j().b();
  }
  
  @NonNull
  private j j()
  {
    if (this.m == null)
    {
      o.c("MicroMsg.AppBrand.AppBrandPickerBottomPanelBase", "requireOrientationGetter, orientationGetter is null, use AndroidOrientationGetter as fallback");
      this.m = a.a.b(null);
    }
    return this.m;
  }
  
  public void a()
  {
    if (this.k) {
      return;
    }
    Object localObject = this.f;
    if (localObject == null)
    {
      setVisibility(8);
      return;
    }
    ((c)localObject).onShow(this);
    clearAnimation();
    setVisibility(0);
    this.k = true;
    localObject = AnimationUtils.loadAnimation(getContext(), 2130772038);
    this.j.startAnimation((Animation)localObject);
    startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772036));
    ((Animation)localObject).setAnimationListener(new d.1(this));
  }
  
  @SuppressLint({"WrongCall"})
  protected final void a(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected final void a(Object paramObject)
  {
    d.b localb = this.l;
    if (localb != null) {
      localb.a(paramObject);
    }
  }
  
  public void b()
  {
    if (this.k) {
      return;
    }
    a(false, null);
    Object localObject = this.f;
    if (localObject != null)
    {
      ((c)localObject).onHide(this);
      this.k = true;
      localObject = AnimationUtils.loadAnimation(getContext(), 2130772200);
      this.j.startAnimation((Animation)localObject);
      startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772037));
      ((Animation)localObject).setAnimationListener(new d.2(this));
    }
  }
  
  public c getPicker()
  {
    return this.f;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    c();
    removeAllViews();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!isShown()) {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, -2147483648));
    }
  }
  
  @CallSuper
  public void setHeader(String paramString)
  {
    if (af.c(paramString))
    {
      e();
      return;
    }
    b(a(paramString));
  }
  
  public void setOnResultListener(d.a parama)
  {
    this.h = parama;
  }
  
  public void setOnValueUpdateListener(d.b paramb)
  {
    this.l = paramb;
  }
  
  public void setOrientationGetter(@NonNull j paramj)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setOrientationGetter, orientationGetter is ");
    localStringBuilder.append(paramj.a());
    o.e("MicroMsg.AppBrand.AppBrandPickerBottomPanelBase", localStringBuilder.toString());
    this.m = paramj;
  }
  
  protected void setPickerImpl(c paramc)
  {
    c localc = this.f;
    if (localc != null) {
      localc.onDetach(this);
    }
    this.f = paramc;
    paramc = this.f;
    if (paramc != null) {
      paramc.onAttach(this);
    }
    if (this.g != null)
    {
      paramc = this.f;
      if (paramc != null)
      {
        if (paramc.getView() == null) {
          return;
        }
        this.g.removeAllViews();
        c();
        paramc = new FrameLayout.LayoutParams(-1, -1);
        paramc.gravity = 17;
        this.g.addView(this.f.getView(), paramc);
      }
    }
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt != 0)
    {
      b();
      return;
    }
    super.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.d
 * JD-Core Version:    0.7.0.1
 */