package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class av$a
{
  private Runnable b = new av.a.1(this);
  private ViewTreeObserver.OnGlobalLayoutListener c;
  
  private av$a(av paramav) {}
  
  private void c()
  {
    View localView = av.a(this.a).getContentView();
    if (localView != null)
    {
      localView.removeCallbacks(this.b);
      if (this.c != null) {
        localView.getViewTreeObserver().removeOnGlobalLayoutListener(this.c);
      }
    }
  }
  
  void a()
  {
    av.b(this.a, true);
    c();
    Object localObject = av.a(this.a).getContentView();
    localObject.getClass();
    localObject = (View)localObject;
    ((View)localObject).postDelayed(this.b, 100L);
    localObject = ((View)localObject).getViewTreeObserver();
    av.a.2 local2 = new av.a.2(this);
    this.c = local2;
    ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(local2);
  }
  
  void b()
  {
    c();
    this.c = null;
    this.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.av.a
 * JD-Core Version:    0.7.0.1
 */