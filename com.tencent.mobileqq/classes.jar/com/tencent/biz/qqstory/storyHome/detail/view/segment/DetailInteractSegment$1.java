package com.tencent.biz.qqstory.storyHome.detail.view.segment;

import com.tencent.biz.qqstory.newshare.callback.OnSimpleShareListener;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;

class DetailInteractSegment$1
  extends OnSimpleShareListener
{
  DetailInteractSegment$1(DetailInteractSegment paramDetailInteractSegment) {}
  
  public void a()
  {
    super.a();
    DetailInteractSegment.a(this.a, null);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    StoryReportor.a("home_page", "suc_share", 2, paramInt, new String[] { StoryReportor.b(DetailInteractSegment.a(this.a).a) + "", StoryReportor.a(DetailInteractSegment.a(this.a).a) + "", DetailInteractSegment.a(this.a).a.feedId });
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    StoryReportor.a("home_page", "share_chanel", 2, paramInt, new String[] { StoryReportor.b(DetailInteractSegment.a(this.a).a) + "", StoryReportor.a(DetailInteractSegment.a(this.a).a) + "", DetailInteractSegment.a(this.a).a.feedId });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailInteractSegment.1
 * JD-Core Version:    0.7.0.1
 */