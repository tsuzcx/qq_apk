package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.commercial.WSBigCardCommercialInfo;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;

class WSVerticalItemWidgetAdvBigCardController$1
  extends AnimatorListenerAdapter
{
  WSVerticalItemWidgetAdvBigCardController$1(WSVerticalItemWidgetAdvBigCardController paramWSVerticalItemWidgetAdvBigCardController, int paramInt1, int paramInt2) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = WSVerticalItemWidgetAdvBigCardController.d(this.c);
    if (paramAnimator == null) {
      return;
    }
    WSVerticalItemWidgetAdvBigCardController.a(this.c, paramAnimator.i());
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    paramAnimator = new StringBuilder();
    paramAnimator.append("ease-in onAnimationStart, from:");
    paramAnimator.append(this.a);
    paramAnimator.append(" to:");
    paramAnimator.append(this.b);
    WSLog.a("WSAdvBigCardController", paramAnimator.toString());
    WSVerticalItemWidgetAdvBigCardController.a(this.c).setVisibility(0);
    if (WSVerticalItemWidgetAdvBigCardController.b(this.c) != null) {
      WSVerticalItemWidgetAdvBigCardController.b(this.c).a();
    }
    WSVerticalBeaconReport.a(WSVerticalItemWidgetAdvBigCardController.c(this.c).k(), WSVerticalItemWidgetAdvBigCardController.c(this.c).l(), (WSVerticalItemData)this.c.c(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemWidgetAdvBigCardController.1
 * JD-Core Version:    0.7.0.1
 */