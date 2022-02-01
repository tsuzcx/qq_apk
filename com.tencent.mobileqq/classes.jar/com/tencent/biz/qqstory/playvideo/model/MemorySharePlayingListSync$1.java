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
import com.tencent.biz.qqstory.network.BatchHandlerListPuller;
import com.tencent.biz.qqstory.network.handler.GetVidPollInfoHandler;
import com.tencent.biz.qqstory.network.request.GetCollectionVideoListRequest;
import com.tencent.biz.qqstory.network.response.GetCollectionVideoListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MemorySharePlayingListSync$1
  implements CmdTaskManger.CommandCallback<GetCollectionVideoListRequest, GetCollectionVideoListResponse>
{
  MemorySharePlayingListSync$1(MemorySharePlayingListSync paramMemorySharePlayingListSync) {}
  
  public void a(@NonNull GetCollectionVideoListRequest paramGetCollectionVideoListRequest, @Nullable GetCollectionVideoListResponse paramGetCollectionVideoListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    MemorySharePlayingListSync localMemorySharePlayingListSync = this.a;
    int i = 0;
    localMemorySharePlayingListSync.e = false;
    if ((paramGetCollectionVideoListResponse != null) && (!paramErrorMessage.isFail()))
    {
      paramGetCollectionVideoListResponse.g = ((StoryManager)SuperManager.a(5)).a(paramGetCollectionVideoListResponse.g);
      paramErrorMessage = paramGetCollectionVideoListResponse.g.iterator();
      while (paramErrorMessage.hasNext()) {
        ((StoryVideoItem)paramErrorMessage.next()).mOwnerUid = this.a.k;
      }
      if (TextUtils.isEmpty(paramGetCollectionVideoListRequest.h)) {
        this.a.b.clear();
      }
      this.a.c = paramGetCollectionVideoListResponse.b;
      this.a.b.addAll(paramGetCollectionVideoListResponse.g);
      paramGetCollectionVideoListRequest = this.a;
      paramGetCollectionVideoListRequest.f = paramGetCollectionVideoListRequest.b.size();
      this.a.d = paramGetCollectionVideoListResponse.e;
      paramGetCollectionVideoListRequest = this.a;
      int j = paramGetCollectionVideoListResponse.f;
      boolean bool = true;
      if (j != 1) {
        bool = false;
      }
      paramGetCollectionVideoListRequest.g = bool;
      SLog.a("Q.qqstory.player.MemorySharePlayingListSync", "last load position:%d cookie:%s", Integer.valueOf(this.a.f), this.a.c);
      ((DownloadUrlManager)SuperManager.a(28)).a(paramGetCollectionVideoListResponse.h);
      paramGetCollectionVideoListRequest = new ArrayList();
      while (i < this.a.b.size())
      {
        paramGetCollectionVideoListRequest.add(((StoryVideoItem)this.a.b.get(i)).mVid);
        i += 1;
      }
      paramErrorMessage = BatchHandlerListPuller.a(paramGetCollectionVideoListRequest);
      paramErrorMessage.a("Q.qqstory.player.MemorySharePlayingListSync");
      paramErrorMessage.a(new MemorySharePlayingListSync.1.1(this, paramErrorMessage, paramGetCollectionVideoListResponse));
      paramErrorMessage.b();
      GetVidPollInfoHandler.a(paramGetCollectionVideoListRequest);
      return;
    }
    paramGetCollectionVideoListRequest = new DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent();
    paramGetCollectionVideoListRequest.a = this.a.h;
    paramGetCollectionVideoListRequest.b = this.a.k;
    paramGetCollectionVideoListRequest.g = paramErrorMessage;
    StoryDispatcher.a().dispatch(paramGetCollectionVideoListRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.model.MemorySharePlayingListSync.1
 * JD-Core Version:    0.7.0.1
 */