package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.request.BatchGetFriendStoryFeedInfoRequest;
import com.tencent.biz.qqstory.network.request.BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import java.util.Vector;

class HomeFeedAllInfoPullSegment$1
  implements CmdTaskManger.CommandCallback<BatchGetFriendStoryFeedInfoRequest, BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp>
{
  HomeFeedAllInfoPullSegment$1(HomeFeedAllInfoPullSegment paramHomeFeedAllInfoPullSegment, JobContext paramJobContext, FeedListPageLoaderBase.GetFeedIdListResult paramGetFeedIdListResult) {}
  
  public void a(@NonNull BatchGetFriendStoryFeedInfoRequest paramBatchGetFriendStoryFeedInfoRequest, @Nullable BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.a.isJobCancelled())
    {
      SLog.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed basic info pull segment cancel on net respond");
      return;
    }
    BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp localGetFriendStoryFeedInfoResp = ???;
    if (??? == null) {
      localGetFriendStoryFeedInfoResp = new BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp(paramErrorMessage);
    }
    if (paramErrorMessage.isFail()) {
      SLog.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for feed info request");
    }
    synchronized (this.c)
    {
      HomeFeedAllInfoPullSegment.a(this.c, localGetFriendStoryFeedInfoResp);
      HomeFeedAllInfoPullSegment.a(this.c).remove(paramBatchGetFriendStoryFeedInfoRequest);
      HomeFeedAllInfoPullSegment.a(this.c, this.b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedAllInfoPullSegment.1
 * JD-Core Version:    0.7.0.1
 */