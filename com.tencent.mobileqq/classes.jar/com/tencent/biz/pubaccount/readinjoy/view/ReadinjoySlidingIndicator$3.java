package com.tencent.biz.pubaccount.readinjoy.view;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;

class ReadinjoySlidingIndicator$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ReadinjoySlidingIndicator$3(ReadinjoySlidingIndicator paramReadinjoySlidingIndicator) {}
  
  @SuppressLint({"NewApi"})
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT < 16) {
      this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
    for (;;)
    {
      ReadinjoySlidingIndicator.a(this.a, ReadinjoySlidingIndicator.a(this.a));
      View localView = ReadinjoySlidingIndicator.a(this.a).getChildAt(ReadinjoySlidingIndicator.a(this.a));
      ReadinjoySlidingIndicator.a(this.a, localView.getLeft());
      this.a.invalidate();
      return;
      this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoySlidingIndicator.3
 * JD-Core Version:    0.7.0.1
 */