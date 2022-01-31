package com.tencent.biz.pubaccount.weishi_new.view;

import android.os.Handler;
import android.view.View;
import bdoo;
import tlo;
import tnu;

public class RedDotBubblePopupWindow$1
  implements Runnable
{
  public RedDotBubblePopupWindow$1(tnu paramtnu, View paramView) {}
  
  public void run()
  {
    int[] arrayOfInt = new int[2];
    this.a.getLocationOnScreen(arrayOfInt);
    tnu.a(this.this$0).measure(0, 0);
    int i = tnu.a(this.this$0).getMeasuredWidth();
    int j = tnu.a(this.this$0).getMeasuredHeight();
    tlo.d("RedDotBubblePopupWindow", "popupWidth:" + i + " popupHeight:" + j + "   location[0]:" + arrayOfInt[0] + " location[1]:" + arrayOfInt[1] + " getWidth:" + this.a.getWidth() + " getHeight:" + this.a.getHeight());
    this.this$0.showAtLocation(this.a, 0, arrayOfInt[0] + this.a.getWidth() / 2 - i / 2, arrayOfInt[1] + this.a.getHeight() + bdoo.a(2.0F));
    this.this$0.a.postDelayed(new RedDotBubblePopupWindow.1.1(this), 3000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.RedDotBubblePopupWindow.1
 * JD-Core Version:    0.7.0.1
 */