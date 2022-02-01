package com.tencent.biz.qqstory.view.segment;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.qqstory.support.logging.SLog;

class SegmentView$2
  implements Animation.AnimationListener
{
  public void onAnimationEnd(Animation paramAnimation)
  {
    SLog.b(this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentView.a(), "deletedItemViewWithAnimation end");
    this.jdField_a_of_type_AndroidViewView.clearAnimation();
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentView.m();
    this.jdField_a_of_type_AndroidViewView.getLayoutParams().height = this.jdField_a_of_type_Int;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    SLog.b(this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentView.a(), "deletedItemViewWithAnimation start");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.segment.SegmentView.2
 * JD-Core Version:    0.7.0.1
 */