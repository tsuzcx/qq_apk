package com.google.android.material.behavior;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;

class SwipeDismissBehavior$SettleRunnable
  implements Runnable
{
  private final View a;
  private final boolean b;
  
  SwipeDismissBehavior$SettleRunnable(SwipeDismissBehavior paramSwipeDismissBehavior, View paramView, boolean paramBoolean)
  {
    this.a = paramView;
    this.b = paramBoolean;
  }
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.a.continueSettling(true)))
    {
      ViewCompat.postOnAnimation(this.a, this);
      return;
    }
    if ((this.b) && (this.this$0.b != null)) {
      this.this$0.b.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.behavior.SwipeDismissBehavior.SettleRunnable
 * JD-Core Version:    0.7.0.1
 */