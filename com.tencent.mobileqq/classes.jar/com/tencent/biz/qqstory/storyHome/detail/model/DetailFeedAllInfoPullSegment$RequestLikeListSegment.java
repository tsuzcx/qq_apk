package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tribe.async.async.JobContext;
import com.tribe.async.parallel.ParallelJobSegment;

class DetailFeedAllInfoPullSegment$RequestLikeListSegment
  extends ParallelJobSegment<String, DetailFeedAllInfoPullSegment.LikeData>
{
  public int a;
  
  public DetailFeedAllInfoPullSegment$RequestLikeListSegment(DetailFeedAllInfoPullSegment paramDetailFeedAllInfoPullSegment, int paramInt)
  {
    super("RequestLikeListSegment");
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    DetailLikeListLoader.GetLikeListRequest localGetLikeListRequest = new DetailLikeListLoader.GetLikeListRequest();
    localGetLikeListRequest.jdField_a_of_type_JavaLangString = paramString;
    localGetLikeListRequest.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Int != -1) {
      localGetLikeListRequest.c = this.jdField_a_of_type_Int;
    }
    CmdTaskManger.a().a(localGetLikeListRequest, new DetailFeedAllInfoPullSegment.RequestLikeListSegment.1(this, paramJobContext, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPullSegment.RequestLikeListSegment
 * JD-Core Version:    0.7.0.1
 */