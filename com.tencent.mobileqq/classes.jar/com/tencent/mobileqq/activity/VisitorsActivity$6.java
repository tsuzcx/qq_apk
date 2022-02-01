package com.tencent.mobileqq.activity;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class VisitorsActivity$6
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  VisitorsActivity$6(VisitorsActivity paramVisitorsActivity) {}
  
  public void onGlobalLayout()
  {
    this.a.b.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    int[] arrayOfInt = new int[2];
    this.a.b.getLocationInWindow(arrayOfInt);
    this.a.j = arrayOfInt[1];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VisitorsActivity.6
 * JD-Core Version:    0.7.0.1
 */