package com.tencent.biz.qqstory.playvideo.model;

import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent;
import com.tencent.biz.qqstory.network.BatchHandlerListPuller;
import com.tencent.biz.qqstory.network.BatchHandlerListPuller.IPullResultCallback;
import com.tencent.biz.qqstory.network.response.GetCollectionVideoListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;

class MemorySharePlayingListSync$1$1
  implements BatchHandlerListPuller.IPullResultCallback
{
  MemorySharePlayingListSync$1$1(MemorySharePlayingListSync.1 param1, BatchHandlerListPuller paramBatchHandlerListPuller, GetCollectionVideoListResponse paramGetCollectionVideoListResponse) {}
  
  public void a(boolean paramBoolean)
  {
    this.a.a();
    DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent localPlayerVideoListEvent = new DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent();
    localPlayerVideoListEvent.a = this.c.a.h;
    localPlayerVideoListEvent.b = this.c.a.k;
    localPlayerVideoListEvent.i = false;
    localPlayerVideoListEvent.j = this.b.e;
    localPlayerVideoListEvent.k = this.c.a.g;
    localPlayerVideoListEvent.e = this.c.a.b;
    localPlayerVideoListEvent.h = localPlayerVideoListEvent.e.size();
    if (localPlayerVideoListEvent.h < localPlayerVideoListEvent.e.size()) {
      localPlayerVideoListEvent.h = localPlayerVideoListEvent.e.size();
    }
    StoryDispatcher.a().dispatch(localPlayerVideoListEvent);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("get video list return:");
    localStringBuilder.append(localPlayerVideoListEvent);
    SLog.b("Q.qqstory.player.MemorySharePlayingListSync", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.model.MemorySharePlayingListSync.1.1
 * JD-Core Version:    0.7.0.1
 */