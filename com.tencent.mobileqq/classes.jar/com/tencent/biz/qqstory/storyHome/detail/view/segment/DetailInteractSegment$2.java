package com.tencent.biz.qqstory.storyHome.detail.view.segment;

import com.tencent.biz.qqstory.newshare.callback.OnSimpleShareListener;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;

class DetailInteractSegment$2
  extends OnSimpleShareListener
{
  DetailInteractSegment$2(DetailInteractSegment paramDetailInteractSegment, FeedItem paramFeedItem) {}
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(StoryReportor.b(this.a));
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StoryReportor.a(this.a));
    localStringBuilder.append("");
    StoryReportor.a("home_page", "suc_share", 2, paramInt, new String[] { localObject, localStringBuilder.toString(), this.a.feedId });
  }
  
  public void d()
  {
    super.d();
    DetailInteractSegment.a(this.b, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailInteractSegment.2
 * JD-Core Version:    0.7.0.1
 */