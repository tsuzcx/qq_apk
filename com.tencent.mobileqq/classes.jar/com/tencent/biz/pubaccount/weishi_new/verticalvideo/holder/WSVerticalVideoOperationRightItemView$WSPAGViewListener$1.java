package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import mqq.util.WeakReference;

class WSVerticalVideoOperationRightItemView$WSPAGViewListener$1
  implements Runnable
{
  WSVerticalVideoOperationRightItemView$WSPAGViewListener$1(WSVerticalVideoOperationRightItemView.WSPAGViewListener paramWSPAGViewListener) {}
  
  public void run()
  {
    WSVerticalVideoOperationRightItemView localWSVerticalVideoOperationRightItemView = (WSVerticalVideoOperationRightItemView)WSVerticalVideoOperationRightItemView.WSPAGViewListener.a(this.this$0).get();
    if (localWSVerticalVideoOperationRightItemView != null)
    {
      WSVerticalVideoOperationRightItemView.c(localWSVerticalVideoOperationRightItemView);
      WSLog.d("WSVerticalVideoOperationRightItemView", "[WSVerticalVideoOperationRightItemView.java][onAnimationEnd] hideAtGuideView!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoOperationRightItemView.WSPAGViewListener.1
 * JD-Core Version:    0.7.0.1
 */