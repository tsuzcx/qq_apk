package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.jj.a.d;
import com.tencent.luggage.wxa.pc.g;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.d;

@SuppressLint({"ViewConstructor"})
public class az
  extends FrameLayout
  implements b.d
{
  boolean a = false;
  private u b;
  private com.tencent.mm.plugin.appbrand.widget.actionbar.d c;
  private b d;
  
  public az(@NonNull Context paramContext, u paramu)
  {
    super(paramContext);
    this.b = paramu;
    b();
  }
  
  private void b()
  {
    a.d locald = this.b.am();
    if (locald == null) {
      return;
    }
    if (locald.a())
    {
      this.c = new com.tencent.mm.plugin.appbrand.widget.actionbar.d(getContext());
      this.c.setActuallyVisible(false);
      this.d = ((b)this.b.U().a(getContext(), b.class));
      this.d.setFullscreenMode(false);
      this.d.c(true);
    }
    try
    {
      this.b.q().aV().a(this.d.getCapsuleView());
      label104:
      a();
      this.c.addView(this.d);
      addView(this.c, -1, -2);
      setBackgroundColor(g.a(locald.h, -1));
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      break label104;
    }
  }
  
  private void c()
  {
    if (this.d != null)
    {
      if ((getVisibility() == 0) && (ViewCompat.isAttachedToWindow(this)))
      {
        this.d.setLoadingIconVisibility(true);
        this.c.setActuallyVisible(true);
        return;
      }
      this.d.setLoadingIconVisibility(false);
      this.c.setActuallyVisible(false);
    }
  }
  
  final void a()
  {
    if (this.d == null) {
      return;
    }
    if (!TextUtils.isEmpty(this.b.ah().getMainTitle())) {
      this.d.setMainTitle(this.b.ah().getMainTitle());
    } else {
      this.d.setMainTitle(getContext().getString(2131886753));
    }
    this.d.setNavHidden(this.b.ah().f());
  }
  
  final void a(@NonNull Context paramContext)
  {
    com.tencent.mm.plugin.appbrand.widget.actionbar.d locald = this.c;
    if (locald != null) {
      locald.a(paramContext);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    c();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    c();
  }
  
  public void setBackgroundColor(int paramInt)
  {
    if (paramInt == 0)
    {
      setWillNotDraw(true);
      return;
    }
    paramInt |= 0xFF000000;
    setWillNotDraw(false);
    super.setBackgroundColor(paramInt);
    b localb = this.d;
    if (localb != null)
    {
      localb.setBackgroundAlpha(1.0D);
      this.d.setBackgroundColor(paramInt);
      boolean bool = com.tencent.mm.ui.e.a(paramInt);
      this.d.setForegroundStyle(bool ^ true);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.az
 * JD-Core Version:    0.7.0.1
 */