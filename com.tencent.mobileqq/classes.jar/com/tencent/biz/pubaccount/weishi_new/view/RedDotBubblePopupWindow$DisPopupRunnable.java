package com.tencent.biz.pubaccount.weishi_new.view;

import java.lang.ref.WeakReference;

class RedDotBubblePopupWindow$DisPopupRunnable
  implements Runnable
{
  WeakReference<RedDotBubblePopupWindow> a;
  
  RedDotBubblePopupWindow$DisPopupRunnable(RedDotBubblePopupWindow paramRedDotBubblePopupWindow1, RedDotBubblePopupWindow paramRedDotBubblePopupWindow2)
  {
    this.a = new WeakReference(paramRedDotBubblePopupWindow2);
  }
  
  public void run()
  {
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.RedDotBubblePopupWindow.DisPopupRunnable
 * JD-Core Version:    0.7.0.1
 */