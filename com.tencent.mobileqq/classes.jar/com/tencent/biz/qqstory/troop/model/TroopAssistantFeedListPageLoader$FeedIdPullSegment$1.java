package com.tencent.biz.qqstory.troop.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.request.GetTroopAssistantFeedIdListRequest;
import com.tencent.biz.qqstory.network.request.GetTroopAssistantFeedIdListRequest.GetTroopAssistantFeedIdListResponse;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.FeedIdListCache;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;

class TroopAssistantFeedListPageLoader$FeedIdPullSegment$1
  implements CmdTaskManger.CommandCallback<GetTroopAssistantFeedIdListRequest, GetTroopAssistantFeedIdListRequest.GetTroopAssistantFeedIdListResponse>
{
  TroopAssistantFeedListPageLoader$FeedIdPullSegment$1(TroopAssistantFeedListPageLoader.FeedIdPullSegment paramFeedIdPullSegment, JobContext paramJobContext, Integer paramInteger) {}
  
  public void a(@NonNull GetTroopAssistantFeedIdListRequest paramGetTroopAssistantFeedIdListRequest, @Nullable GetTroopAssistantFeedIdListRequest.GetTroopAssistantFeedIdListResponse paramGetTroopAssistantFeedIdListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.a.isJobCancelled())
    {
      SLog.d("Q.qqstory.home.data.FeedListPageLoaderBase", "feedId pull segment cancel on net respond");
      return;
    }
    if ((!paramErrorMessage.isFail()) && (paramGetTroopAssistantFeedIdListResponse != null))
    {
      TroopAssistantFeedListPageLoader.FeedIdPullSegment.a(this.c).a(paramGetTroopAssistantFeedIdListResponse.e, paramGetTroopAssistantFeedIdListResponse.b, paramGetTroopAssistantFeedIdListResponse.a);
      ((FeedManager)SuperManager.a(11)).c(paramGetTroopAssistantFeedIdListResponse.e);
      paramGetTroopAssistantFeedIdListRequest = TroopAssistantFeedListPageLoader.FeedIdPullSegment.a(this.c).a(this.b.intValue(), 5);
      TroopAssistantFeedListPageLoader.FeedIdPullSegment.a(this.c, paramGetTroopAssistantFeedIdListRequest);
      return;
    }
    SLog.a("Q.qqstory.home.data.FeedListPageLoaderBase", "pull feedId list fail %s", paramErrorMessage.toString());
    TroopAssistantFeedListPageLoader.FeedIdPullSegment.a(this.c, paramErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.model.TroopAssistantFeedListPageLoader.FeedIdPullSegment.1
 * JD-Core Version:    0.7.0.1
 */