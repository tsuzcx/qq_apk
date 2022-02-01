package com.tencent.biz.qqstory.playvideo.dataprovider;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.request.GetProfileFeedIdListRequest;
import com.tencent.biz.qqstory.network.request.GetProfileFeedIdListRequest.GetProfileFeedIdListResponse;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.FeedIdListCache;
import com.tencent.biz.qqstory.support.logging.SLog;

class ProfileFeedPlayPageLoader$1
  implements CmdTaskManger.CommandCallback<GetProfileFeedIdListRequest, GetProfileFeedIdListRequest.GetProfileFeedIdListResponse>
{
  ProfileFeedPlayPageLoader$1(ProfileFeedPlayPageLoader paramProfileFeedPlayPageLoader, IGroupPageLoader.CallBack paramCallBack) {}
  
  public void a(@NonNull GetProfileFeedIdListRequest paramGetProfileFeedIdListRequest, @Nullable GetProfileFeedIdListRequest.GetProfileFeedIdListResponse paramGetProfileFeedIdListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((!paramErrorMessage.isFail()) && (paramGetProfileFeedIdListResponse != null))
    {
      this.b.b.a(paramGetProfileFeedIdListResponse.e, paramGetProfileFeedIdListResponse.b, paramGetProfileFeedIdListResponse.a);
      this.a.a(paramErrorMessage, FeedIdBasePlayPageLoader.b(paramGetProfileFeedIdListResponse.e), paramGetProfileFeedIdListResponse.a);
      return;
    }
    SLog.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
    this.a.a(paramErrorMessage, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.ProfileFeedPlayPageLoader.1
 * JD-Core Version:    0.7.0.1
 */