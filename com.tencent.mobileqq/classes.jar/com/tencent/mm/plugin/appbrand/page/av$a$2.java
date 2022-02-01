package com.tencent.mm.plugin.appbrand.page;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class av$a$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int b;
  
  av$a$2(av.a parama) {}
  
  public void onGlobalLayout()
  {
    if (av.a.a(this.a) == null)
    {
      av.a.b(this.a);
      return;
    }
    int i = this.b + 1;
    this.b = i;
    if (i == 2)
    {
      av.a.b(this.a);
      av.a.a(this.a).run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.av.a.2
 * JD-Core Version:    0.7.0.1
 */