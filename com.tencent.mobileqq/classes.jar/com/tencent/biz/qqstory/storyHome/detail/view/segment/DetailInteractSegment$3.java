package com.tencent.biz.qqstory.storyHome.detail.view.segment;

import com.tencent.biz.qqstory.newshare.callback.OnSimpleShareListener;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;

class DetailInteractSegment$3
  extends OnSimpleShareListener
{
  DetailInteractSegment$3(DetailInteractSegment paramDetailInteractSegment) {}
  
  public void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(StoryReportor.b(DetailInteractSegment.a(this.a).a));
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StoryReportor.a(DetailInteractSegment.a(this.a).a));
    localStringBuilder.append("");
    StoryReportor.a("home_page", "share_chanel", 2, paramInt, new String[] { localObject, localStringBuilder.toString(), DetailInteractSegment.a(this.a).a.feedId });
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(StoryReportor.b(DetailInteractSegment.a(this.a).a));
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StoryReportor.a(DetailInteractSegment.a(this.a).a));
    localStringBuilder.append("");
    StoryReportor.a("home_page", "suc_share", 2, paramInt, new String[] { localObject, localStringBuilder.toString(), DetailInteractSegment.a(this.a).a.feedId });
  }
  
  public void d()
  {
    super.d();
    DetailInteractSegment.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailInteractSegment.3
 * JD-Core Version:    0.7.0.1
 */