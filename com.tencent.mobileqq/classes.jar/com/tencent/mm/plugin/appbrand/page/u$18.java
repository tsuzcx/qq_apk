package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;

class u$18
  implements Runnable
{
  u$18(u paramu, View paramView) {}
  
  public void run()
  {
    Object localObject = this.b;
    u.a((u)localObject, new u.a((u)localObject, ((u)localObject).getContext()));
    localObject = this.b;
    localObject = ((u)localObject).a(u.c((u)localObject));
    RelativeLayout.LayoutParams localLayoutParams = this.b.S().a(this.a, (View)localObject);
    if (localObject != null) {
      u.c(this.b).addView(this.a, u.c(this.b).getChildCount() - 1, localLayoutParams);
    } else {
      u.c(this.b).addView(this.a, localLayoutParams);
    }
    this.b.S().b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.u.18
 * JD-Core Version:    0.7.0.1
 */