package com.tencent.biz.qqstory.view;

import android.app.Activity;
import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class StoryNewGuideDialog$2
  implements Animation.AnimationListener
{
  StoryNewGuideDialog$2(StoryNewGuideDialog paramStoryNewGuideDialog, Context paramContext) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      if (!((Activity)this.jdField_a_of_type_AndroidContentContext).isFinishing()) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog.dismiss();
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog.dismiss();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.StoryNewGuideDialog.2
 * JD-Core Version:    0.7.0.1
 */