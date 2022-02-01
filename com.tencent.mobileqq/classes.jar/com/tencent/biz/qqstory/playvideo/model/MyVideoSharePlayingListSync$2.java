package com.tencent.biz.qqstory.playvideo.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.request.GetShareVideoListRequest;
import com.tencent.biz.qqstory.network.response.GetShareVideoListResponse;
import com.tribe.async.dispatch.Dispatcher;
import java.util.Iterator;
import java.util.List;

class MyVideoSharePlayingListSync$2
  implements CmdTaskManger.CommandCallback<GetShareVideoListRequest, GetShareVideoListResponse>
{
  MyVideoSharePlayingListSync$2(MyVideoSharePlayingListSync paramMyVideoSharePlayingListSync) {}
  
  public void a(@NonNull GetShareVideoListRequest paramGetShareVideoListRequest, @Nullable GetShareVideoListResponse paramGetShareVideoListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    this.a.e = false;
    if ((paramGetShareVideoListResponse != null) && (!paramErrorMessage.isFail()))
    {
      paramGetShareVideoListResponse.f = ((StoryManager)SuperManager.a(5)).a(paramGetShareVideoListResponse.f);
      paramErrorMessage = paramGetShareVideoListResponse.f.iterator();
      while (paramErrorMessage.hasNext())
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramErrorMessage.next();
        if (TextUtils.isEmpty(localStoryVideoItem.mOwnerUid)) {
          localStoryVideoItem.mOwnerUid = this.a.l;
        }
      }
      if (TextUtils.isEmpty(paramGetShareVideoListRequest.h)) {
        this.a.b.clear();
      }
      this.a.b.addAll(paramGetShareVideoListResponse.f);
      paramGetShareVideoListRequest = this.a;
      paramGetShareVideoListRequest.f = paramGetShareVideoListRequest.b.size();
      this.a.d = paramGetShareVideoListResponse.e;
      this.a.c = paramGetShareVideoListResponse.b;
      ((DownloadUrlManager)SuperManager.a(28)).a(paramGetShareVideoListResponse.g);
      paramGetShareVideoListRequest = new DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent();
      paramGetShareVideoListRequest.a = this.a.h;
      paramGetShareVideoListRequest.b = this.a.l;
      paramGetShareVideoListRequest.i = false;
      paramGetShareVideoListRequest.j = paramGetShareVideoListResponse.e;
      paramGetShareVideoListRequest.e = this.a.b;
      if (paramGetShareVideoListRequest.h < paramGetShareVideoListRequest.e.size()) {
        paramGetShareVideoListRequest.h = paramGetShareVideoListRequest.e.size();
      }
      StoryDispatcher.a().dispatch(paramGetShareVideoListRequest);
      return;
    }
    paramGetShareVideoListRequest = new DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent();
    paramGetShareVideoListRequest.a = this.a.h;
    paramGetShareVideoListRequest.b = this.a.l;
    paramGetShareVideoListRequest.g = paramErrorMessage;
    StoryDispatcher.a().dispatch(paramGetShareVideoListRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.model.MyVideoSharePlayingListSync.2
 * JD-Core Version:    0.7.0.1
 */