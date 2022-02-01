package com.tencent.biz.qqstory.playvideo.dataprovider;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.request.GetTroopAssistantFeedIdListRequest;
import com.tencent.biz.qqstory.network.request.GetTroopAssistantFeedIdListRequest.GetTroopAssistantFeedIdListResponse;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.FeedIdListCache;
import com.tencent.biz.qqstory.support.logging.SLog;

class TroopAssistantHomeFeedPlayPageLoader$1
  implements CmdTaskManger.CommandCallback<GetTroopAssistantFeedIdListRequest, GetTroopAssistantFeedIdListRequest.GetTroopAssistantFeedIdListResponse>
{
  TroopAssistantHomeFeedPlayPageLoader$1(TroopAssistantHomeFeedPlayPageLoader paramTroopAssistantHomeFeedPlayPageLoader, IGroupPageLoader.CallBack paramCallBack) {}
  
  public void a(@NonNull GetTroopAssistantFeedIdListRequest paramGetTroopAssistantFeedIdListRequest, @Nullable GetTroopAssistantFeedIdListRequest.GetTroopAssistantFeedIdListResponse paramGetTroopAssistantFeedIdListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((!paramErrorMessage.isFail()) && (paramGetTroopAssistantFeedIdListResponse != null))
    {
      this.b.b.a(paramGetTroopAssistantFeedIdListResponse.e, paramGetTroopAssistantFeedIdListResponse.b, paramGetTroopAssistantFeedIdListResponse.a);
      this.a.a(paramErrorMessage, FeedIdBasePlayPageLoader.b(paramGetTroopAssistantFeedIdListResponse.e), paramGetTroopAssistantFeedIdListResponse.a);
      return;
    }
    SLog.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
    this.a.a(paramErrorMessage, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.TroopAssistantHomeFeedPlayPageLoader.1
 * JD-Core Version:    0.7.0.1
 */