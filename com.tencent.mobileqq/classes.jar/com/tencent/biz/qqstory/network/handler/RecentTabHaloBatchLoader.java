package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.Destroyable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.base.StoryHaloManager;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.network.request.RecentTabHaloRequest;
import com.tencent.biz.qqstory.network.response.RecentTabHaloResponse;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class RecentTabHaloBatchLoader
  implements Destroyable, CmdTaskManger.CommandCallback<RecentTabHaloRequest, RecentTabHaloResponse>
{
  private final QQAppInterface a;
  private AtomicBoolean b = new AtomicBoolean(false);
  private Queue<MsgTabNodeInfo> c;
  private AtomicBoolean d = new AtomicBoolean(false);
  
  public RecentTabHaloBatchLoader(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    c();
  }
  
  private void a(RecentTabHaloRequest paramRecentTabHaloRequest, RecentTabHaloResponse paramRecentTabHaloResponse)
  {
    StoryHaloManager localStoryHaloManager = (StoryHaloManager)this.a.getManager(QQManagerFactory.STORY_HALO_MANAGER);
    List localList = paramRecentTabHaloResponse.b();
    localStoryHaloManager.a(paramRecentTabHaloResponse.a());
    if (paramRecentTabHaloRequest.b() == 3)
    {
      paramRecentTabHaloRequest = localList.iterator();
      while (paramRecentTabHaloRequest.hasNext())
      {
        paramRecentTabHaloResponse = (MsgTabNodeInfo)paramRecentTabHaloRequest.next();
        localStoryHaloManager.b(paramRecentTabHaloResponse);
        localStoryHaloManager.c(paramRecentTabHaloResponse);
        localStoryHaloManager.e(paramRecentTabHaloResponse);
      }
    }
    localStoryHaloManager.b(localList);
    localStoryHaloManager.a(localList, true);
  }
  
  private void c()
  {
    this.c = new ConcurrentLinkedQueue();
  }
  
  private void d()
  {
    Object localObject = (StoryHaloManager)this.a.getManager(QQManagerFactory.STORY_HALO_MANAGER);
    if (!this.d.get()) {
      for (;;)
      {
        MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)this.c.poll();
        if (localMsgTabNodeInfo == null) {
          break;
        }
        ((StoryHaloManager)localObject).a(localMsgTabNodeInfo);
      }
    }
    localObject = new RecentTabHaloBatchLoader.RecentTabHaloEvent(true);
    StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject);
  }
  
  public void a()
  {
    this.b.set(true);
  }
  
  public void a(@NonNull RecentTabHaloRequest paramRecentTabHaloRequest, @Nullable RecentTabHaloResponse paramRecentTabHaloResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (b()) {
      return;
    }
    this.d.set(true);
    if ((paramRecentTabHaloResponse != null) && (!paramErrorMessage.isFail()))
    {
      a(paramRecentTabHaloRequest, paramRecentTabHaloResponse);
      this.d.set(false);
      d();
      return;
    }
    if (QLog.isColorLevel())
    {
      paramRecentTabHaloRequest = new StringBuilder();
      paramRecentTabHaloRequest.append("onEvent: failed. Message: exception: ");
      paramRecentTabHaloRequest.append(paramErrorMessage);
      QLog.e("RecentTabHaloBatchLoader", 2, paramRecentTabHaloRequest.toString());
    }
  }
  
  public boolean b()
  {
    return this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.RecentTabHaloBatchLoader
 * JD-Core Version:    0.7.0.1
 */