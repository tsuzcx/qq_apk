package com.tencent.biz.qqstory.playmode.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.request.GetCollectionVideoListRequest;
import com.tencent.biz.qqstory.network.response.GetCollectionVideoListResponse;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

final class PlayModeUtils$6
  implements CmdTaskManger.CommandCallback<GetCollectionVideoListRequest, GetCollectionVideoListResponse>
{
  PlayModeUtils$6(PlayModeUtils.FeedShareInteractStatusObserver paramFeedShareInteractStatusObserver) {}
  
  public void a(@NonNull GetCollectionVideoListRequest paramGetCollectionVideoListRequest, @Nullable GetCollectionVideoListResponse paramGetCollectionVideoListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    ThreadManager.getUIHandler().post(new PlayModeUtils.6.1(this, paramGetCollectionVideoListResponse, paramErrorMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.PlayModeUtils.6
 * JD-Core Version:    0.7.0.1
 */