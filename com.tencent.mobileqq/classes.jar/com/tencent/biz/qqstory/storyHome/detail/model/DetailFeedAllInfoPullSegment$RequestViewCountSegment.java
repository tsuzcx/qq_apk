package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.network.request.GetFeedFeatureRequest;
import com.tribe.async.async.JobContext;
import com.tribe.async.parallel.ParallelJobSegment;
import java.util.ArrayList;

class DetailFeedAllInfoPullSegment$RequestViewCountSegment
  extends ParallelJobSegment<String, Integer>
{
  public DetailFeedAllInfoPullSegment$RequestViewCountSegment(DetailFeedAllInfoPullSegment paramDetailFeedAllInfoPullSegment)
  {
    this(paramDetailFeedAllInfoPullSegment, "RequestViewCountSegment");
  }
  
  public DetailFeedAllInfoPullSegment$RequestViewCountSegment(DetailFeedAllInfoPullSegment paramDetailFeedAllInfoPullSegment, String paramString)
  {
    super(paramString);
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    GetFeedFeatureRequest localGetFeedFeatureRequest = new GetFeedFeatureRequest();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localGetFeedFeatureRequest.f = localArrayList;
    CmdTaskManger.a().a(localGetFeedFeatureRequest, new DetailFeedAllInfoPullSegment.RequestViewCountSegment.1(this, paramJobContext, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPullSegment.RequestViewCountSegment
 * JD-Core Version:    0.7.0.1
 */