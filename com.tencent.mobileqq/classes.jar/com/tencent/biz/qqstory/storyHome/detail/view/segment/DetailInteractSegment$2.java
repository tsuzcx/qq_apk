package com.tencent.biz.qqstory.storyHome.detail.view.segment;

import com.tencent.biz.qqstory.newshare.callback.OnSimpleShareListener;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;

class DetailInteractSegment$2
  extends OnSimpleShareListener
{
  DetailInteractSegment$2(DetailInteractSegment paramDetailInteractSegment, FeedItem paramFeedItem) {}
  
  public void a()
  {
    super.a();
    DetailInteractSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewSegmentDetailInteractSegment, null);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    StoryReportor.a("home_page", "suc_share", 2, paramInt, new String[] { StoryReportor.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem) + "", StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem) + "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailInteractSegment.2
 * JD-Core Version:    0.7.0.1
 */