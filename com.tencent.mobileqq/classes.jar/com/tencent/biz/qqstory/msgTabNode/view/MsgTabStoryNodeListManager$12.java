package com.tencent.biz.qqstory.msgTabNode.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class MsgTabStoryNodeListManager$12
  implements ValueAnimator.AnimatorUpdateListener
{
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    MsgTabStoryNodeListManager.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager).setAlpha(1.0F - MsgTabStoryNodeListManager.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager).getTranslationY() / MsgTabStoryNodeListManager.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager) + 0.3F);
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    float f2 = this.jdField_a_of_type_Float;
    MsgTabStoryNodeListManager.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager).setTranslationY(f1 - f2 + this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager.12
 * JD-Core Version:    0.7.0.1
 */