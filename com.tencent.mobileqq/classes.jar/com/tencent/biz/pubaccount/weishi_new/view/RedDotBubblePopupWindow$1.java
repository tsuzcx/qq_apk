package com.tencent.biz.pubaccount.weishi_new.view;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import bhtq;
import uqf;

class RedDotBubblePopupWindow$1
  implements Runnable
{
  RedDotBubblePopupWindow$1(RedDotBubblePopupWindow paramRedDotBubblePopupWindow, View paramView) {}
  
  public void run()
  {
    if (RedDotBubblePopupWindow.a(this.this$0) == null) {}
    int[] arrayOfInt;
    int i;
    do
    {
      return;
      arrayOfInt = new int[2];
      this.a.getLocationOnScreen(arrayOfInt);
      RedDotBubblePopupWindow.a(this.this$0).measure(0, 0);
      i = RedDotBubblePopupWindow.a(this.this$0).getMeasuredWidth();
      int j = RedDotBubblePopupWindow.a(this.this$0).getMeasuredHeight();
      uqf.d("RedDotBubblePopupWindow", "popupWidth:" + i + " popupHeight:" + j + "   location[0]:" + arrayOfInt[0] + " location[1]:" + arrayOfInt[1] + " getWidth:" + this.a.getWidth() + " getHeight:" + this.a.getHeight());
    } while ((RedDotBubblePopupWindow.a(this.this$0) == null) || (RedDotBubblePopupWindow.a(this.this$0).isFinishing()));
    if (RedDotBubblePopupWindow.a(this.this$0) == null) {
      RedDotBubblePopupWindow.a(this.this$0, new RedDotBubblePopupWindow.DisPopupRunnable(this.this$0, this.this$0));
    }
    this.this$0.showAtLocation(this.a, 0, arrayOfInt[0] + this.a.getWidth() / 2 - i / 2, arrayOfInt[1] + this.a.getHeight() + bhtq.a(2.0F));
    this.this$0.a.postDelayed(RedDotBubblePopupWindow.a(this.this$0), 3000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.RedDotBubblePopupWindow.1
 * JD-Core Version:    0.7.0.1
 */