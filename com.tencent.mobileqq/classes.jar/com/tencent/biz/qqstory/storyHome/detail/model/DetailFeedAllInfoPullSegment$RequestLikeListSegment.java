package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tribe.async.async.JobContext;
import com.tribe.async.parallel.ParallelJobSegment;

class DetailFeedAllInfoPullSegment$RequestLikeListSegment
  extends ParallelJobSegment<String, DetailFeedAllInfoPullSegment.LikeData>
{
  public int a = -1;
  
  public DetailFeedAllInfoPullSegment$RequestLikeListSegment(DetailFeedAllInfoPullSegment paramDetailFeedAllInfoPullSegment, int paramInt)
  {
    super("RequestLikeListSegment");
    this.a = paramInt;
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    DetailLikeListLoader.GetLikeListRequest localGetLikeListRequest = new DetailLikeListLoader.GetLikeListRequest();
    localGetLikeListRequest.e = paramString;
    localGetLikeListRequest.f = true;
    int i = this.a;
    if (i != -1) {
      localGetLikeListRequest.g = i;
    }
    CmdTaskManger.a().a(localGetLikeListRequest, new DetailFeedAllInfoPullSegment.RequestLikeListSegment.1(this, paramJobContext, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPullSegment.RequestLikeListSegment
 * JD-Core Version:    0.7.0.1
 */