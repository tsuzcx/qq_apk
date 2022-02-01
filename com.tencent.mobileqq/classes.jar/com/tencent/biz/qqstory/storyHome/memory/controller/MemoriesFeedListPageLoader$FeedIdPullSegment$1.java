package com.tencent.biz.qqstory.storyHome.memory.controller;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.request.GetProfileFeedIdListRequest;
import com.tencent.biz.qqstory.network.request.GetProfileFeedIdListRequest.GetProfileFeedIdListResponse;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.FeedIdListCache;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;

class MemoriesFeedListPageLoader$FeedIdPullSegment$1
  implements CmdTaskManger.CommandCallback<GetProfileFeedIdListRequest, GetProfileFeedIdListRequest.GetProfileFeedIdListResponse>
{
  MemoriesFeedListPageLoader$FeedIdPullSegment$1(MemoriesFeedListPageLoader.FeedIdPullSegment paramFeedIdPullSegment, JobContext paramJobContext, Integer paramInteger) {}
  
  public void a(@NonNull GetProfileFeedIdListRequest paramGetProfileFeedIdListRequest, @Nullable GetProfileFeedIdListRequest.GetProfileFeedIdListResponse paramGetProfileFeedIdListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.a.isJobCancelled())
    {
      SLog.d("Q.qqstory.home.data.FeedListPageLoaderBase", "feedId pull segment cancel on net respond");
      return;
    }
    if ((!paramErrorMessage.isFail()) && (paramGetProfileFeedIdListResponse != null))
    {
      MemoriesFeedListPageLoader.FeedIdPullSegment.a(this.c).a(paramGetProfileFeedIdListResponse.e, paramGetProfileFeedIdListResponse.b, paramGetProfileFeedIdListResponse.a);
      ((FeedManager)SuperManager.a(11)).c(paramGetProfileFeedIdListResponse.e);
      paramGetProfileFeedIdListRequest = MemoriesFeedListPageLoader.FeedIdPullSegment.a(this.c).a(this.b.intValue(), 5);
      MemoriesFeedListPageLoader.FeedIdPullSegment.a(this.c, paramGetProfileFeedIdListRequest);
      return;
    }
    SLog.a("Q.qqstory.home.data.FeedListPageLoaderBase", "pull feedId list fail %s", paramErrorMessage.toString());
    MemoriesFeedListPageLoader.FeedIdPullSegment.a(this.c, paramErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesFeedListPageLoader.FeedIdPullSegment.1
 * JD-Core Version:    0.7.0.1
 */