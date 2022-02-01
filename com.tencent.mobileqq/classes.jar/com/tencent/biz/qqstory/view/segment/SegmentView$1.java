package com.tencent.biz.qqstory.view.segment;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.biz.qqstory.support.logging.SLog;

class SegmentView$1
  extends Animation
{
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    this.jdField_a_of_type_AndroidViewView.getLayoutParams().height = (this.jdField_a_of_type_Int - (int)(this.jdField_a_of_type_Int * paramFloat));
    this.jdField_a_of_type_AndroidViewView.requestLayout();
  }
  
  public void cancel()
  {
    super.cancel();
    SLog.b(this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentView.a(), "deletedItemViewWithAnimation cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.segment.SegmentView.1
 * JD-Core Version:    0.7.0.1
 */