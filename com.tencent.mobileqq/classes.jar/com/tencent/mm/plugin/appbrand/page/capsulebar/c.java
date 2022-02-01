package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.rh.b;
import junit.framework.a;

public final class c
  extends b
{
  private int a;
  
  public c(@NonNull Context paramContext)
  {
    super(paramContext);
    setClickable(false);
    this.a = 0;
  }
  
  private boolean a(View paramView)
  {
    return paramView instanceof g;
  }
  
  public void a(Context paramContext)
  {
    if ((getContext() instanceof MutableContextWrapper))
    {
      int i = this.a;
      boolean bool = false;
      if (i > 0)
      {
        if (!(paramContext instanceof Activity)) {
          bool = true;
        }
        setLayoutFrozen(bool);
      }
      else
      {
        setLayoutFrozen(false);
      }
      ((MutableContextWrapper)getContext()).setBaseContext(paramContext);
    }
  }
  
  public void b_(int paramInt)
  {
    super.b_(paramInt);
    this.a = paramInt;
  }
  
  protected FrameLayout.LayoutParams generateDefaultLayoutParams()
  {
    return new FrameLayout.LayoutParams(-2, -2, 21);
  }
  
  public void onViewAdded(View paramView)
  {
    super.onViewAdded(paramView);
    if (!a(paramView)) {
      a.a("Cant add non CapsuleBar instance here !");
    }
  }
  
  protected void s_()
  {
    super.s_();
    super.setWillNotDraw(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.c
 * JD-Core Version:    0.7.0.1
 */