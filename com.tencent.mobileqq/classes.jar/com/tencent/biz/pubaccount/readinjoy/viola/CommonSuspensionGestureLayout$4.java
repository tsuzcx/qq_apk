package com.tencent.biz.pubaccount.readinjoy.viola;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;

class CommonSuspensionGestureLayout$4
  implements Runnable
{
  CommonSuspensionGestureLayout$4(CommonSuspensionGestureLayout paramCommonSuspensionGestureLayout) {}
  
  public void run()
  {
    ((ViewGroup)CommonSuspensionGestureLayout.a(this.this$0).getParent()).removeView(CommonSuspensionGestureLayout.a(this.this$0));
    this.this$0.addView(CommonSuspensionGestureLayout.a(this.this$0));
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)CommonSuspensionGestureLayout.a(this.this$0).getLayoutParams();
    localLayoutParams.gravity = 80;
    localLayoutParams.bottomMargin = CommonSuspensionGestureLayout.a(CommonSuspensionGestureLayout.a(this.this$0));
    CommonSuspensionGestureLayout.a(this.this$0).setLayoutParams(localLayoutParams);
    this.this$0.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout.4
 * JD-Core Version:    0.7.0.1
 */