package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rh.b;

public class d
  extends b
{
  private int a = 0;
  private boolean c = false;
  private int d;
  private boolean e = true;
  private Integer f = null;
  
  public d(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private boolean a(View paramView)
  {
    return paramView instanceof e;
  }
  
  private e getActionBar()
  {
    if (getChildCount() <= 0) {
      return null;
    }
    return (e)getChildAt(0);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.a = paramInt;
    this.c = paramBoolean;
    if (!this.e)
    {
      super.a(paramInt, paramBoolean, false);
      return;
    }
    super.a(paramInt, paramBoolean, true);
  }
  
  public void a(Context paramContext)
  {
    if ((getContext() instanceof MutableContextWrapper)) {
      ((MutableContextWrapper)getContext()).setBaseContext(paramContext);
    }
    if (this.f != null) {
      b_(0);
    }
  }
  
  public void b()
  {
    o.e("Luggage.WXA.AppBrandActionBarContainer", "resetStatusBarForegroundStyle hash[%d] color[%d] foregroundDark[%b] mActuallyVisible[%b] isLayoutFrozen[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.a), Boolean.valueOf(this.c), Boolean.valueOf(this.e), Boolean.valueOf(c()) });
    a(this.a, this.c);
  }
  
  public void b_(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onStatusBarHeightChange: newHeight = ");
    ((StringBuilder)localObject).append(paramInt);
    o.d("Luggage.WXA.AppBrandActionBarContainer", ((StringBuilder)localObject).toString());
    localObject = this.f;
    if (localObject != null)
    {
      paramInt = ((Integer)localObject).intValue();
      this.d = paramInt;
      super.b_(paramInt);
      return;
    }
    this.d = paramInt;
    if (c()) {
      return;
    }
    super.b_(paramInt);
  }
  
  protected boolean canAnimate()
  {
    return false;
  }
  
  public void dispatchSystemUiVisibilityChanged(int paramInt)
  {
    super.dispatchSystemUiVisibilityChanged(paramInt);
    if ((this.e) && (ViewCompat.isAttachedToWindow(this)) && (b) && ((getWindowSystemUiVisibility() & 0x4) == 0))
    {
      o.e("Luggage.WXA.AppBrandActionBarContainer", "dispatchSystemUiVisibilityChanged resetStatusBarForegroundStyle, hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
      b();
    }
  }
  
  public boolean hasOverlappingRendering()
  {
    return false;
  }
  
  public void onViewAdded(View paramView)
  {
    super.onViewAdded(paramView);
    if (a(paramView))
    {
      paramView.setBackground(new d.a(this, 0));
      return;
    }
    throw new IllegalAccessError("Cant add non ActionBar instance here");
  }
  
  public void setActuallyVisible(boolean paramBoolean)
  {
    int i;
    if (paramBoolean != this.e) {
      i = 1;
    } else {
      i = 0;
    }
    this.e = paramBoolean;
    if ((i != 0) && (paramBoolean))
    {
      setDeferStatusBarHeightChange(false);
      b();
      setWillNotDraw(false);
    }
    if ((i != 0) && (!paramBoolean)) {
      setDeferStatusBarHeightChange(true);
    }
  }
  
  public void setDeferStatusBarHeightChange(boolean paramBoolean)
  {
    super.setLayoutFrozen(paramBoolean);
  }
  
  public void setForceTopInsetsHeight(int paramInt)
  {
    this.f = Integer.valueOf(paramInt);
  }
  
  public void setStatusBarColor(int paramInt)
  {
    a(paramInt, this.c);
  }
  
  public void setStatusBarForegroundStyle(boolean paramBoolean)
  {
    if (getActionBar() == null) {
      return;
    }
    a(getActionBar().getBackgroundColor(), paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.d
 * JD-Core Version:    0.7.0.1
 */