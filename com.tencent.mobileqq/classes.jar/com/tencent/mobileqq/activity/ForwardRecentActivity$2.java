package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;

class ForwardRecentActivity$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ForwardRecentActivity$2(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onGlobalLayout()
  {
    this.a.getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
    ForwardRecentActivity.access$000(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity.2
 * JD-Core Version:    0.7.0.1
 */