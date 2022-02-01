package com.tencent.biz.qqstory.storyHome.detail.view.segment;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;

class FeedItemThumbAdapter$2
  implements ValueAnimator.AnimatorUpdateListener
{
  FeedItemThumbAdapter$2(FeedItemThumbAdapter paramFeedItemThumbAdapter, StoryHomeHorizontalListView paramStoryHomeHorizontalListView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    try
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.scrollTo((int)(300.0F - f * 300.0F), 0);
      return;
    }
    catch (Exception paramValueAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.FeedItemThumbAdapter.2
 * JD-Core Version:    0.7.0.1
 */