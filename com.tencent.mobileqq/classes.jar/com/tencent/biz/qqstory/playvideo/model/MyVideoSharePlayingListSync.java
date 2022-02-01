package com.tencent.biz.qqstory.playvideo.model;

import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.request.GetShareVideoListRequest;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MyVideoSharePlayingListSync
  extends BasePagePlayingListSync
{
  protected long j;
  protected int k;
  protected String l;
  
  protected void a()
  {
    Object localObject = (StoryManager)SuperManager.a(5);
    StoryVideoItem localStoryVideoItem;
    if (QQStoryContext.a().b(this.l))
    {
      localObject = ((StoryManager)localObject).g(this.l);
      if (localObject != null)
      {
        localIterator = ((List)localObject).iterator();
        while (localIterator.hasNext())
        {
          localStoryVideoItem = (StoryVideoItem)localIterator.next();
          if ((!localStoryVideoItem.isUploadFail()) && (!localStoryVideoItem.isUploadSuc())) {
            localIterator.remove();
          }
        }
      }
      Collections.sort((List)localObject, new MyVideoSharePlayingListSync.1(this));
    }
    else
    {
      localObject = ((StoryManager)localObject).d(this.l);
    }
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      localStoryVideoItem = (StoryVideoItem)localIterator.next();
      if (TextUtils.isEmpty(localStoryVideoItem.mOwnerUid)) {
        localStoryVideoItem.mOwnerUid = QQStoryContext.a().i();
      }
    }
    if (((List)localObject).size() > 0)
    {
      localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext()) {
        if (((StoryVideoItem)localIterator.next()).mCreateTime / 1000L > this.j) {
          localIterator.remove();
        }
      }
      if (((List)localObject).size() == 0) {
        return;
      }
      if (((StoryVideoItem)((List)localObject).get(((List)localObject).size() - 1)).mCreateTime / 1000L != this.j) {
        return;
      }
      this.d = true;
      localObject = new DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent();
      ((DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent)localObject).a = this.h;
      ((DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent)localObject).b = this.l;
      ((DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent)localObject).i = true;
      ((DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent)localObject).j = true;
      StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject);
    }
  }
  
  protected void b()
  {
    this.e = true;
    GetShareVideoListRequest localGetShareVideoListRequest = new GetShareVideoListRequest(this.l, this.j, this.k);
    localGetShareVideoListRequest.h = this.c;
    CmdTaskManger.a().a(localGetShareVideoListRequest, new MyVideoSharePlayingListSync.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.model.MyVideoSharePlayingListSync
 * JD-Core Version:    0.7.0.1
 */