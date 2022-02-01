package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.network.request.GetFeedCommentRequest;
import com.tencent.biz.qqstory.storyHome.model.FeedCommentSync;
import com.tribe.async.async.JobContext;
import com.tribe.async.parallel.ParallelJobSegment;

class DetailFeedAllInfoPullSegment$RequestCommentListSegment
  extends ParallelJobSegment<FeedCommentSync, DetailFeedAllInfoPullSegment.CommentData>
{
  public DetailFeedAllInfoPullSegment$RequestCommentListSegment(DetailFeedAllInfoPullSegment paramDetailFeedAllInfoPullSegment)
  {
    this(paramDetailFeedAllInfoPullSegment, "RequestCommentListSegment");
  }
  
  public DetailFeedAllInfoPullSegment$RequestCommentListSegment(DetailFeedAllInfoPullSegment paramDetailFeedAllInfoPullSegment, String paramString)
  {
    super(paramString);
  }
  
  protected void a(JobContext paramJobContext, FeedCommentSync paramFeedCommentSync)
  {
    GetFeedCommentRequest localGetFeedCommentRequest = new GetFeedCommentRequest();
    localGetFeedCommentRequest.f = paramFeedCommentSync;
    CmdTaskManger.a().a(localGetFeedCommentRequest, new DetailFeedAllInfoPullSegment.RequestCommentListSegment.1(this, paramJobContext, paramFeedCommentSync));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPullSegment.RequestCommentListSegment
 * JD-Core Version:    0.7.0.1
 */