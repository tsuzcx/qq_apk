package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WSVerticalItemBottomCollectionController$2
  extends AnimatorListenerAdapter
{
  WSVerticalItemBottomCollectionController$2(WSVerticalItemBottomCollectionController paramWSVerticalItemBottomCollectionController) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    WSVerticalItemBottomCollectionController.c(this.a);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("collection animator start: ");
    if (WSVerticalItemBottomCollectionController.b(this.a) == null) {
      paramAnimator = "null";
    } else {
      paramAnimator = WSVerticalItemBottomCollectionController.b(this.a).feed_desc;
    }
    localStringBuilder.append(paramAnimator);
    WSLog.b("AbsWsUIGroup", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemBottomCollectionController.2
 * JD-Core Version:    0.7.0.1
 */