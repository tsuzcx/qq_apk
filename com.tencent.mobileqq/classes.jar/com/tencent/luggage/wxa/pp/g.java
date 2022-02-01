package com.tencent.luggage.wxa.pp;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsoluteLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qz.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.am;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.page.bd.a;
import com.tencent.mm.plugin.appbrand.page.bi;
import com.tencent.mm.plugin.appbrand.page.bk;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.y.b;
import com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;
import com.tencent.mm.plugin.appbrand.widget.base.d;
import com.tencent.mm.plugin.appbrand.widget.base.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"ViewConstructor"})
public final class g
  extends AbsoluteLayout
  implements com.tencent.mm.plugin.appbrand.page.ac, ae, bd, bi, y.b, d
{
  final e a;
  private final List<bd.a> b = new LinkedList();
  private final AbsoluteLayout c;
  private final u d;
  private boolean e;
  private int f;
  private int g;
  
  public g(@NonNull u paramu)
  {
    super(paramu.getContext());
    super.setId(2131428550);
    this.d = paramu;
    this.c = this;
    this.a = new e(this.c);
  }
  
  private void a(am paramam)
  {
    paramam = paramam.getWrapperView();
    if ((this.c.getWidth() != paramam.getWidth()) || (this.c.getHeight() != paramam.getHeight()))
    {
      ViewGroup.LayoutParams localLayoutParams = this.c.getLayoutParams();
      localLayoutParams.width = paramam.getWidth();
      localLayoutParams.height = paramam.getHeight();
      this.c.setLayoutParams(localLayoutParams);
    }
  }
  
  private <Input extends View,  extends ac> boolean a(am paramam, Input paramInput, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if ((paramam != null) && (paramam.getWrapperView() != null) && (paramInput != null))
    {
      a(paramam);
      paramam = new AbsoluteLayout.LayoutParams(paramInt1, paramInt2, paramInt3, paramInt4);
      this.c.addView(paramInput, paramam);
      if (paramBoolean) {
        ((ac)paramInput).a(this.d);
      }
      return true;
    }
    return false;
  }
  
  private boolean a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject = this.c;
    if (localObject == null) {
      return false;
    }
    localObject = ((AbsoluteLayout)localObject).getLayoutParams();
    if (localObject == null)
    {
      localObject = new ViewGroup.LayoutParams(paramInt1, paramInt2);
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return true;
    }
    if ((paramInt1 == ((ViewGroup.LayoutParams)localObject).width) && (paramInt2 == ((ViewGroup.LayoutParams)localObject).height)) {
      return paramBoolean;
    }
    ((ViewGroup.LayoutParams)localObject).width = paramInt1;
    ((ViewGroup.LayoutParams)localObject).height = paramInt2;
    this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    return true;
  }
  
  private <Input extends View,  extends ac> boolean b(Input paramInput)
  {
    if (paramInput == null) {
      return false;
    }
    if (this.c == null) {
      return false;
    }
    int i = 0;
    while (i < this.c.getChildCount())
    {
      if (paramInput == this.c.getChildAt(i)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void a(int paramInt)
  {
    setTranslationY(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    o.f("MicroMsg.AppBrandInputContainer", "onScrollChanged, left = %d, top = %d, oldLeft = %d, oldTop = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (this.c != null)
    {
      a(false, paramView.getWidth(), paramView.getHeight());
      this.c.scrollTo(paramInt1, paramInt2);
    }
    paramView = this.b.iterator();
    while (paramView.hasNext()) {
      ((bd.a)paramView.next()).a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public <Input extends View,  extends ac> void a(Input paramInput)
  {
    if (paramInput == null) {
      return;
    }
    paramInput.setVisibility(8);
    o.f("MicroMsg.AppBrandInputContainer", "clearWebView imm active = %b", new Object[] { Boolean.valueOf(ak.a(this).isActive()) });
    this.c.removeView(paramInput);
    ((ac)paramInput).b(this.d);
  }
  
  public void a(bd.a parama)
  {
    if (parama == null) {
      return;
    }
    if (this.b.contains(parama)) {
      return;
    }
    this.b.add(parama);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (a(paramBoolean, paramInt3 - paramInt1, paramInt4 - paramInt2)) {
      post(new g.1(this));
    }
  }
  
  public boolean a()
  {
    if (getChildCount() <= 0) {
      return false;
    }
    int i = 0;
    while (i <= getChildCount())
    {
      if (AppBrandViewMotionCompat.a(getChildAt(i))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean a(@NonNull Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.translate(-getScrollX(), -getScrollY());
    if (bk.a(this)) {
      bk.a(paramCanvas, this, 0.0F, 0.0F);
    } else {
      b.a(paramCanvas, this);
    }
    paramCanvas.restore();
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent != null) && (paramMotionEvent.getActionMasked() == 0)) {
      return this.a.b(paramMotionEvent);
    }
    return false;
  }
  
  public <Input extends View,  extends ac> boolean a(am paramam, Input paramInput, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(paramam, paramInput, paramInt1, paramInt2, paramInt3, paramInt4, true);
  }
  
  public void b(bd.a parama)
  {
    if (parama == null) {
      return;
    }
    this.b.remove(parama);
  }
  
  public <Input extends View,  extends ac> boolean b(am paramam, Input paramInput, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramam != null) && (paramam.getWrapperView() != null))
    {
      if (paramInput == null) {
        return false;
      }
      if (!b(paramInput)) {
        return false;
      }
      a(paramam);
      if (paramInput.getLayoutParams() != null)
      {
        if (!(paramInput.getLayoutParams() instanceof AbsoluteLayout.LayoutParams)) {
          return false;
        }
        if ((paramInput.getWidth() != paramInt1) || (paramInput.getHeight() != paramInt2) || (paramInput.getLeft() != paramInt3) || (paramInput.getTop() != paramInt4))
        {
          paramam = (AbsoluteLayout.LayoutParams)paramInput.getLayoutParams();
          paramam.x = paramInt3;
          paramam.y = paramInt4;
          paramam.width = paramInt1;
          paramam.height = paramInt2;
          paramInput.setLayoutParams(paramam);
        }
        return true;
      }
    }
    return false;
  }
  
  protected void measureChild(View paramView, int paramInt1, int paramInt2)
  {
    if (this.e) {
      paramView.forceLayout();
    }
    super.measureChild(paramView, paramInt1, paramInt2);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool;
    if ((!isLayoutRequested()) && (paramInt1 == this.f) && (paramInt2 == this.g)) {
      bool = false;
    } else {
      bool = true;
    }
    this.e = bool;
    this.f = paramInt1;
    this.g = paramInt2;
    super.onMeasure(paramInt1, paramInt2);
    this.e = false;
  }
  
  public void setId(int paramInt) {}
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.g
 * JD-Core Version:    0.7.0.1
 */