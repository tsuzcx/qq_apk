package com.tencent.mobileqq.activity.bless;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;

class BlessActivity$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  BlessActivity$1(BlessActivity paramBlessActivity, RelativeLayout paramRelativeLayout) {}
  
  public void onGlobalLayout()
  {
    this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    BlessActivity.a(this.b, this.a.getHeight());
    BlessActivity.b(this.b, this.a.getWidth());
    BlessActivity.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessActivity.1
 * JD-Core Version:    0.7.0.1
 */