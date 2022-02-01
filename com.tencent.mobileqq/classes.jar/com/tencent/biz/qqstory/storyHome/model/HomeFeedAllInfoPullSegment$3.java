package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.LikeManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.request.BatchGetFeedLikeRequest;
import com.tencent.biz.qqstory.network.request.BatchGetFeedLikeRequest.BatchGetFeedLikeResp;
import com.tencent.biz.qqstory.network.request.BatchGetFeedLikeRequest.FeedLikeInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

class HomeFeedAllInfoPullSegment$3
  implements CmdTaskManger.CommandCallback<BatchGetFeedLikeRequest, BatchGetFeedLikeRequest.BatchGetFeedLikeResp>
{
  HomeFeedAllInfoPullSegment$3(HomeFeedAllInfoPullSegment paramHomeFeedAllInfoPullSegment, JobContext paramJobContext, FeedListPageLoaderBase.GetFeedIdListResult paramGetFeedIdListResult) {}
  
  public void a(@NonNull BatchGetFeedLikeRequest paramBatchGetFeedLikeRequest, @Nullable BatchGetFeedLikeRequest.BatchGetFeedLikeResp arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.a.isJobCancelled())
    {
      SLog.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed like info pull segment cancel on net respond");
      return;
    }
    if (??? == null)
    {
      paramErrorMessage = new BatchGetFeedLikeRequest.BatchGetFeedLikeResp(paramErrorMessage);
    }
    else
    {
      if (paramErrorMessage.isFail()) {
        SLog.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for like request");
      }
      LikeManager localLikeManager = (LikeManager)SuperManager.a(15);
      Iterator localIterator = ???.a.iterator();
      for (;;)
      {
        paramErrorMessage = ???;
        if (!localIterator.hasNext()) {
          break;
        }
        paramErrorMessage = (BatchGetFeedLikeRequest.FeedLikeInfo)localIterator.next();
        localLikeManager.a(paramErrorMessage.d, paramErrorMessage.a, false, true);
      }
    }
    synchronized (this.c)
    {
      HomeFeedAllInfoPullSegment.a(this.c, paramErrorMessage);
      HomeFeedAllInfoPullSegment.a(this.c).remove(paramBatchGetFeedLikeRequest);
      HomeFeedAllInfoPullSegment.a(this.c, this.b);
      return;
    }
    for (;;)
    {
      throw paramBatchGetFeedLikeRequest;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedAllInfoPullSegment.3
 * JD-Core Version:    0.7.0.1
 */