package com.tencent.biz.pubaccount.weishi_new.view;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.utils.ViewUtils;

class RedDotBubblePopupWindow$1
  implements Runnable
{
  RedDotBubblePopupWindow$1(RedDotBubblePopupWindow paramRedDotBubblePopupWindow, View paramView) {}
  
  public void run()
  {
    if (RedDotBubblePopupWindow.a(this.this$0) == null) {
      return;
    }
    int[] arrayOfInt = new int[2];
    this.a.getLocationOnScreen(arrayOfInt);
    RedDotBubblePopupWindow.a(this.this$0).measure(0, 0);
    int i = RedDotBubblePopupWindow.a(this.this$0).getMeasuredWidth();
    int j = RedDotBubblePopupWindow.a(this.this$0).getMeasuredHeight();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("popupWidth:");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" popupHeight:");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append("   location[0]:");
    ((StringBuilder)localObject).append(arrayOfInt[0]);
    ((StringBuilder)localObject).append(" location[1]:");
    ((StringBuilder)localObject).append(arrayOfInt[1]);
    ((StringBuilder)localObject).append(" getWidth:");
    ((StringBuilder)localObject).append(this.a.getWidth());
    ((StringBuilder)localObject).append(" getHeight:");
    ((StringBuilder)localObject).append(this.a.getHeight());
    WSLog.d("RedDotBubblePopupWindow", ((StringBuilder)localObject).toString());
    if (RedDotBubblePopupWindow.b(this.this$0) != null)
    {
      if (RedDotBubblePopupWindow.b(this.this$0).isFinishing()) {
        return;
      }
      if (RedDotBubblePopupWindow.c(this.this$0) == null)
      {
        localObject = this.this$0;
        RedDotBubblePopupWindow.a((RedDotBubblePopupWindow)localObject, new RedDotBubblePopupWindow.DisPopupRunnable((RedDotBubblePopupWindow)localObject, (RedDotBubblePopupWindow)localObject));
      }
      localObject = this.this$0;
      View localView = this.a;
      ((RedDotBubblePopupWindow)localObject).showAtLocation(localView, 0, arrayOfInt[0] + localView.getWidth() / 2 - i / 2, arrayOfInt[1] + this.a.getHeight() + ViewUtils.dip2px(2.0F));
      this.this$0.a.postDelayed(RedDotBubblePopupWindow.c(this.this$0), 3000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.RedDotBubblePopupWindow.1
 * JD-Core Version:    0.7.0.1
 */