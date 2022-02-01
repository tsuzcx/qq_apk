package com.tencent.biz.qqstory.playvideo;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationUtils;

class StoryPlayerActivity$1
  implements ViewTreeObserver.OnPreDrawListener
{
  StoryPlayerActivity$1(StoryPlayerActivity paramStoryPlayerActivity, View paramView) {}
  
  public boolean onPreDraw()
  {
    AnimationUtils.b((ViewGroup)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerActivity.a(), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerActivity.a, new StoryPlayerActivity.1.1(this));
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeOnPreDrawListener(this);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.StoryPlayerActivity.1
 * JD-Core Version:    0.7.0.1
 */