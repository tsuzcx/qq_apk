package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter;
import com.tencent.biz.qqstory.storyHome.model.StoryHomeFeed;
import com.tencent.widget.ActionSheet.OnDismissListener;
import java.util.List;

class FeedSegment$12
  implements ActionSheet.OnDismissListener
{
  FeedSegment$12(FeedSegment paramFeedSegment, int paramInt) {}
  
  public void onDismiss()
  {
    StoryHomeFeed localStoryHomeFeed = (StoryHomeFeed)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment.a.a().get(this.jdField_a_of_type_Int);
    FeedSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment, localStoryHomeFeed, "clk_hide");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.12
 * JD-Core Version:    0.7.0.1
 */