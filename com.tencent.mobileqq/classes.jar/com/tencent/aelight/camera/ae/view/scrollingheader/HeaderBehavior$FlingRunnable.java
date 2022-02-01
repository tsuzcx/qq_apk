package com.tencent.aelight.camera.ae.view.scrollingheader;

import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

class HeaderBehavior$FlingRunnable
  implements Runnable
{
  private final CoordinatorLayout a;
  private final V b;
  
  HeaderBehavior$FlingRunnable(CoordinatorLayout paramCoordinatorLayout, V paramV)
  {
    this.a = paramV;
    Object localObject;
    this.b = localObject;
  }
  
  public void run()
  {
    if ((this.b != null) && (this.this$0.a != null))
    {
      if (this.this$0.a.computeScrollOffset())
      {
        HeaderBehavior localHeaderBehavior = this.this$0;
        localHeaderBehavior.b_(this.a, this.b, localHeaderBehavior.a.getCurrY());
        ViewCompat.postOnAnimation(this.b, this);
        return;
      }
      this.this$0.a(this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.scrollingheader.HeaderBehavior.FlingRunnable
 * JD-Core Version:    0.7.0.1
 */