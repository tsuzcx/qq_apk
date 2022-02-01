package com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageController$startBarrageItemAnimation$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class BarrageController$startBarrageItemAnimation$2
  implements Animator.AnimatorListener
{
  BarrageController$startBarrageItemAnimation$2(BarrageItemView paramBarrageItemView, ValueAnimator paramValueAnimator) {}
  
  public void onAnimationCancel(@Nullable Animator paramAnimator) {}
  
  public void onAnimationEnd(@Nullable Animator paramAnimator)
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageItemView.getX() + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageItemView.getWidth() <= 0) {
      i = 1;
    }
    if (i != 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageController.a().removeView((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageItemView);
      paramAnimator = BarrageController.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageController).iterator();
      Intrinsics.checkExpressionValueIsNotNull(paramAnimator, "animatorList.iterator()");
      while (paramAnimator.hasNext())
      {
        Object localObject = paramAnimator.next();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "animatorListIterator.next()");
        if (Intrinsics.areEqual(((BarrageController.AnimatorState)localObject).a(), this.jdField_a_of_type_AndroidAnimationValueAnimator)) {
          paramAnimator.remove();
        }
      }
    }
    QLog.d("BarrageController", 2, "onAnimationEnd but not out of screen.");
  }
  
  public void onAnimationRepeat(@Nullable Animator paramAnimator) {}
  
  public void onAnimationStart(@Nullable Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage.BarrageController.startBarrageItemAnimation.2
 * JD-Core Version:    0.7.0.1
 */