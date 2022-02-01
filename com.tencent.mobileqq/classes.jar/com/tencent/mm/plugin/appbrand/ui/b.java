package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.pc.l;
import com.tencent.luggage.wxa.qx.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rh.c;
import com.tencent.luggage.wxa.rh.c.a;

@SuppressLint({"ViewConstructor"})
public class b
  extends LinearLayout
  implements c.a
{
  private final com.tencent.luggage.wxa.ed.d a;
  private final b.a[] b;
  private final SparseArray<b.b> c;
  private final SparseArray<b.b> d;
  private int e;
  
  public b(Context paramContext, com.tencent.luggage.wxa.ed.d paramd)
  {
    super(paramContext);
    this.a = paramd;
    this.c = new SparseArray();
    this.d = new SparseArray();
    this.b = new b.a[4];
    c();
  }
  
  private void b(int paramInt, String paramString)
  {
    Object localObject = (Integer)com.tencent.luggage.wxa.om.d.b.get(paramInt);
    if (localObject == null)
    {
      o.b("MicroMsg.AppBrandUIPerformancePanel", "insertPerformanceData no such performance type: %d", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    String str = getContext().getString(((Integer)localObject).intValue());
    localObject = (b.b)this.d.get(paramInt);
    if (localObject == null) {
      localObject = c(paramInt, str);
    }
    if (localObject == null)
    {
      o.b("MicroMsg.AppBrandUIPerformancePanel", "insertPerformanceData label view is null.");
      return;
    }
    b.b.a((b.b)localObject, paramString);
  }
  
  private void b(String paramString1, String paramString2)
  {
    b.b localb2 = (b.b)this.c.get(paramString1.hashCode());
    b.b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b.b(this, getContext());
      b.b.b(localb1, paramString1);
      addView(localb1);
      this.c.put(paramString1.hashCode(), localb1);
    }
    b.b.a(localb1, paramString2);
  }
  
  @Nullable
  private b.b c(int paramInt, String paramString)
  {
    b.b localb = new b.b(this, getContext());
    b.b.b(localb, paramString);
    int i = paramInt / 100 - 1;
    if (i >= 4)
    {
      o.b("MicroMsg.AppBrandUIPerformancePanel", "insertPerformanceLabelView group index is invalid.");
      return null;
    }
    if (i == 3) {
      addView(localb);
    } else {
      addView(localb, indexOfChild(this.b[(i + 1)]));
    }
    this.d.put(paramInt, localb);
    return localb;
  }
  
  private void c()
  {
    setClickable(false);
    f();
    h();
    i();
    c.a((Activity)getContext()).a(this);
  }
  
  private void d()
  {
    setVisibility(0);
    setAlpha(0.0F);
    animate().alpha(1.0F).setDuration(500L).setStartDelay(500L).setListener(null);
  }
  
  private void e()
  {
    animate().alpha(0.0F).setDuration(500L).setListener(new b.1(this));
  }
  
  private void f()
  {
    int i = getContext().getResources().getDisplayMetrics().widthPixels;
    int j = a.e(getContext(), 10);
    int k = a.e(getContext(), 4);
    Object localObject = new FrameLayout.LayoutParams(i * 3 / 5, -2);
    ((FrameLayout.LayoutParams)localObject).gravity = 53;
    setLayoutParams((ViewGroup.LayoutParams)localObject);
    g();
    setPadding(j, j, j, j);
    setOrientation(1);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setCornerRadius(k);
    ((GradientDrawable)localObject).setColor(-652403418);
    setBackground((Drawable)localObject);
  }
  
  private void g()
  {
    if ((getLayoutParams() != null) && ((getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      ((ViewGroup.MarginLayoutParams)getLayoutParams()).topMargin = (com.tencent.mm.plugin.appbrand.widget.b.a(getContext()) + this.e);
      requestLayout();
    }
  }
  
  private void h()
  {
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, 2);
    TextView localTextView = new TextView(getContext());
    View localView = new View(getContext());
    localTextView.setTextColor(-1);
    localTextView.setLayoutParams(localLayoutParams1);
    localTextView.setTextSize(1, 14.0F);
    localTextView.setText(getContext().getString(2131886866));
    addView(localTextView);
    localLayoutParams2.setMargins(0, a.e(getContext(), 10), 0, 0);
    localView.setLayoutParams(localLayoutParams2);
    localView.setBackgroundColor(1728053247);
    addView(localView);
  }
  
  private void i()
  {
    int i = 0;
    while (i < 4)
    {
      b.a locala = new b.a(this, getContext());
      locala.setText(getContext().getString(com.tencent.luggage.wxa.om.d.a[i]));
      this.b[i] = locala;
      addView(locala);
      i += 1;
    }
  }
  
  public void a()
  {
    com.tencent.luggage.wxa.om.b.c(this.a);
    d();
  }
  
  public void a(int paramInt, String paramString)
  {
    l.a(new b.2(this, paramInt, paramString));
  }
  
  public void a(String paramString1, String paramString2)
  {
    l.a(new b.3(this, paramString1, paramString2));
  }
  
  public void b()
  {
    com.tencent.luggage.wxa.om.b.a(this.a.aa());
    e();
  }
  
  public void b_(int paramInt)
  {
    this.e = paramInt;
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.b
 * JD-Core Version:    0.7.0.1
 */