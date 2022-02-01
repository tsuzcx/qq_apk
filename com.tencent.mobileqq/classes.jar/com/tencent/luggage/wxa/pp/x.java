package com.tencent.luggage.wxa.pp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.jx.e.a;
import com.tencent.luggage.wxa.pv.a.a;
import com.tencent.luggage.wxa.pv.a.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.rh.d;
import com.tencent.mm.plugin.appbrand.ui.c;

public class x
  extends LinearLayout
  implements ad, u.b
{
  private static final int a = 2131428537;
  private static com.tencent.luggage.wxa.nj.a r;
  private static boolean s = false;
  private static boolean t = false;
  private static final x.b u = new x.f(null);
  private final Runnable b = new x.1(this);
  private x.d c;
  private x.c d;
  private boolean e = false;
  private x.e f;
  private int g = 2;
  private com.tencent.luggage.wxa.pv.a h;
  private View i;
  private View j;
  private ImageButton k;
  private boolean l;
  private View m;
  private boolean n;
  private EditText o;
  private Context p;
  @NonNull
  private final ae q;
  
  public x(Context paramContext, com.tencent.luggage.wxa.nj.a parama)
  {
    super(paramContext);
    this.p = paramContext;
    if ((paramContext instanceof ae)) {
      paramContext = (ae)paramContext;
    } else {
      paramContext = new com.tencent.luggage.wxa.ps.a();
    }
    this.q = paramContext;
    o.e("MicroMsg.AppBrandSoftKeyboardPanel", "mComponentView is assigned");
    r = parama;
    l();
  }
  
  public static x a(@NonNull View paramView, com.tencent.luggage.wxa.nj.a parama)
  {
    if (r != parama)
    {
      o.e("MicroMsg.AppBrandSoftKeyboardPanel", "mComponentView != componentView so we set mComponentView = componentView;");
      r = parama;
    }
    n localn = n.a(paramView);
    if (localn == null) {
      return null;
    }
    if ((localn.getOnLayoutListener() == null) || (!(localn.getOnLayoutListener() instanceof u))) {
      localn.setOnLayoutListener(new u());
    }
    Object localObject2 = c(paramView);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = d.a(paramView.getContext());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = d.h(paramView.getContext());
      }
      if ((paramView instanceof x)) {
        paramView = (x)paramView;
      } else {
        paramView = new x((Context)localObject1, parama);
      }
      localn.b(paramView);
      localObject1 = paramView;
    }
    return localObject1;
  }
  
  public static x c(View paramView)
  {
    return (x)paramView.getRootView().findViewById(a);
  }
  
  private void c()
  {
    o.f("MicroMsg.AppBrandSoftKeyboardPanel", "[scrollUp] forceMeasurePanel enter");
    this.i.requestLayout();
  }
  
  private void d(int paramInt)
  {
    post(new x.5(this, paramInt, this.e));
  }
  
  private void l()
  {
    o.e("MicroMsg.AppBrandSoftKeyboardPanel", "init");
    b(a);
    setOrientation(1);
    if (s) {
      this.j = r;
    } else {
      this.j = g();
    }
    Object localObject = this.j;
    if (localObject != null)
    {
      localObject = (ViewGroup)((View)localObject).getParent();
      if (localObject != null)
      {
        o.d("MicroMsg.AppBrandSoftKeyboardPanel", "toolbar is already exsited in a layout,the class of the parent is %s  the id is : %d", new Object[] { localObject.getClass().toString(), Integer.valueOf(((ViewGroup)localObject).getId()) });
        ((ViewGroup)localObject).removeView(this.j);
      }
    }
    addView(this.j);
    t = false;
    localObject = (a.b)e.a(a.b.class);
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((a.b)localObject).a(this.p);
    }
    this.h = ((com.tencent.luggage.wxa.pv.a)localObject);
    if (this.h == null) {
      this.h = new a.a(this.p);
    }
    this.i = this.h.b();
    this.i.setVisibility(8);
    this.i.setBackgroundColor(0);
    this.h.a(new x.4(this));
    addView(this.i);
    b();
  }
  
  private void m()
  {
    j_();
    ((u)n.a(this).getOnLayoutListener()).a(this);
  }
  
  private void n()
  {
    n localn = n.a(this);
    if (localn == null) {
      return;
    }
    if (localn.getOnLayoutListener() == null) {
      return;
    }
    ((u)localn.getOnLayoutListener()).a(null);
  }
  
  private void o()
  {
    q();
    Object localObject = this.o;
    if (localObject != null)
    {
      localObject = ak.a((View)localObject);
      if (!((InputMethodManager)localObject).showSoftInput(this.o, 1)) {
        ((InputMethodManager)localObject).showSoftInput(this.o, 2);
      }
    }
    else
    {
      this.q.k();
    }
  }
  
  private void p()
  {
    this.h.e();
    u.b(this);
    ImageButton localImageButton = this.k;
    if (localImageButton != null) {
      localImageButton.setSelected(true);
    }
    d(1);
  }
  
  private void q()
  {
    this.h.f();
    u.a(this);
    ImageButton localImageButton = this.k;
    if (localImageButton != null) {
      localImageButton.setSelected(false);
    }
    d(0);
  }
  
  private void setPanelHeightImpl(int paramInt)
  {
    if (this.h.a(paramInt)) {
      this.b.run();
    }
  }
  
  public void a(int paramInt)
  {
    o.e("MicroMsg.AppBrandSoftKeyboardPanel", "[scrollUp] refreshHeight %d", new Object[] { Integer.valueOf(paramInt) });
    u.a(this, paramInt);
  }
  
  public void a(EditText paramEditText)
  {
    this.o = paramEditText;
  }
  
  public void a(boolean paramBoolean)
  {
    o.e("MicroMsg.AppBrandSoftKeyboardPanel", "onKeyboardStateChanged, kbShown = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      c(0);
      q();
      return;
    }
    if (isShown())
    {
      if ((this.l) && (1 == this.g))
      {
        p();
        return;
      }
      j();
    }
  }
  
  public boolean a()
  {
    return this.h.a();
  }
  
  protected void b()
  {
    Object localObject = this.j;
    if (localObject == null) {
      return;
    }
    if ((localObject instanceof x.a))
    {
      localObject = (x.a)localObject;
      boolean bool3 = this.l;
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (!((bool3 ^ true) & (this.n ^ true))) {
        if (c.a(this)) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      ((x.a)localObject).a(bool1);
    }
  }
  
  protected final void b(int paramInt)
  {
    super.setId(paramInt);
  }
  
  protected final void b(boolean paramBoolean)
  {
    if (!this.e)
    {
      x.c localc = this.d;
      if (localc != null)
      {
        this.e = true;
        localc.a(paramBoolean);
        this.e = false;
      }
    }
  }
  
  public boolean b(EditText paramEditText)
  {
    if (paramEditText == this.o)
    {
      this.o = null;
      return true;
    }
    return false;
  }
  
  void c(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt == 0)
    {
      i1 = paramInt;
      if (c.a(this)) {
        i1 = 8;
      }
    }
    if (getVisibility() == i1) {
      return;
    }
    super.setVisibility(i1);
    if (i1 == 0)
    {
      m();
      return;
    }
    n();
  }
  
  protected void d()
  {
    setCanSmileyInput(this.l);
    setShowDoneButton(this.n);
    b();
  }
  
  public void d(View paramView)
  {
    if (paramView != null)
    {
      ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(paramView);
      }
    }
  }
  
  protected void e() {}
  
  public void f()
  {
    if (this.o != null) {
      o();
    }
    d();
    if (!isShown()) {
      c(0);
    }
  }
  
  protected <T extends View,  extends x.a> T g()
  {
    x.g localg = new x.g(getContext());
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = r.d().getDrawable(2130852842);
    localStateListDrawable.addState(new int[] { 16842913 }, localDrawable);
    localDrawable = r.d().getDrawable(2130852841);
    localStateListDrawable.addState(new int[0], localDrawable);
    this.k = ((ImageButton)localg.findViewById(2131446110));
    this.k.setSelected(false);
    this.k.setImageDrawable(localStateListDrawable);
    this.k.setOnClickListener(new x.2(this));
    this.m = localg.findViewById(2131446109);
    this.m.setOnClickListener(new x.3(this));
    return localg;
  }
  
  public EditText getAttachedEditText()
  {
    return this.o;
  }
  
  public int getMinimumHeight()
  {
    if (getVisibility() != 0) {
      return 0;
    }
    if (s)
    {
      Object localObject = r;
      if (localObject != null)
      {
        localObject = ((com.tencent.luggage.wxa.nj.a)localObject).getCustomViewContainer();
        if ((localObject != null) && ((((e.a)localObject).a() instanceof ViewGroup)) && (((ViewGroup)((e.a)localObject).a()).getChildCount() > 0) && (((ViewGroup)((e.a)localObject).a()).getChildAt(0).getLayoutParams() != null)) {
          return Math.max(((ViewGroup)((e.a)localObject).a()).getChildAt(0).getLayoutParams().height, 0);
        }
        return 0;
      }
    }
    return com.tencent.luggage.wxa.qx.a.e(getContext(), 48);
  }
  
  public void h()
  {
    View localView = this.j;
    if (localView == null) {
      return;
    }
    if (t)
    {
      d(localView);
      if (s) {
        this.j = r;
      } else {
        this.j = g();
      }
      d(this.j);
      addView(this.j, 0);
      o.e("MicroMsg.AppBrandSoftKeyboardPanel", "toolbar is changed in updateToolbar() because of toolbarChanged");
      t = false;
    }
    if (s)
    {
      localView = this.j;
      if (localView != r)
      {
        d(localView);
        this.j = r;
        d(this.j);
        addView(this.j, 0);
        o.e("MicroMsg.AppBrandSoftKeyboardPanel", "toolbar is changed in updateToolbar() because toolbar != mComponentView");
      }
    }
    if ((s) && (this.j.getParent() != this))
    {
      d(this.j);
      addView(this.j, 0);
    }
  }
  
  public void i()
  {
    c(8);
    if (this.p != null)
    {
      localObject = this.o;
      if (localObject != null) {
        this.q.hideVKB((View)localObject);
      } else {
        this.q.i();
      }
    }
    this.h.g();
    Object localObject = this.k;
    if (localObject != null) {
      ((ImageButton)localObject).setOnClickListener(null);
    }
    this.c = null;
    removeAllViews();
    this.p = null;
  }
  
  public void j()
  {
    if (!isShown()) {
      return;
    }
    c(8);
    if ((this.o != null) && (!this.q.j())) {
      ak.a(this).hideSoftInputFromWindow(getWindowToken(), 0);
    }
    q();
    e();
  }
  
  protected void j_()
  {
    a(this, r);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    m();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    i();
    n();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    o.f("MicroMsg.AppBrandSoftKeyboardPanel", "[scrollUp] SoftKeyboardPanel onLayout measuredHeight = %d", new Object[] { Integer.valueOf(getMeasuredHeight()) });
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    o.e("MicroMsg.AppBrandSoftKeyboardPanel", "smileyPanelWrapper, onMeasure");
  }
  
  public void setCanSmileyInput(boolean paramBoolean)
  {
    h();
    int i1 = 0;
    this.l = false;
    ImageButton localImageButton = this.k;
    if (localImageButton != null)
    {
      if (!this.l) {
        i1 = 4;
      }
      localImageButton.setVisibility(i1);
    }
    b();
  }
  
  public void setComponentView(boolean paramBoolean)
  {
    if (s != paramBoolean)
    {
      s = paramBoolean;
      t = true;
    }
  }
  
  public void setId(int paramInt) {}
  
  public void setOnDoneListener(x.c paramc)
  {
    this.d = paramc;
  }
  
  public void setOnSmileyChosenListener(x.d paramd)
  {
    this.c = paramd;
  }
  
  public void setOnVisibilityChangedListener(x.e parame)
  {
    this.f = parame;
  }
  
  public void setShowDoneButton(boolean paramBoolean)
  {
    h();
    this.n = paramBoolean;
    View localView = this.m;
    if (localView != null)
    {
      int i1;
      if (this.n) {
        i1 = 0;
      } else {
        i1 = 4;
      }
      localView.setVisibility(i1);
    }
    b();
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt == 8)
    {
      if (getVisibility() != paramInt) {
        b(false);
      }
      j();
      return;
    }
    if (paramInt == 0)
    {
      f();
      return;
    }
    c(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.x
 * JD-Core Version:    0.7.0.1
 */