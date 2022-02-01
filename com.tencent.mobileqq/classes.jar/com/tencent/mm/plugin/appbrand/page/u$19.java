package com.tencent.mm.plugin.appbrand.page;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.d;

class u$19
  implements Runnable
{
  u$19(u paramu) {}
  
  public void run()
  {
    u.d(this.a);
    this.a.b_.a(this.a.getContext());
    u.c(this.a).addView(this.a.b_, -1, new ViewGroup.LayoutParams(-1, -2));
    this.a.S().a(this.a.d);
    if (this.a.d.getParent() == this.a.b_) {
      return;
    }
    throw new IllegalAccessError("You should not modify actionbar's view hierarchy");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.u.19
 * JD-Core Version:    0.7.0.1
 */