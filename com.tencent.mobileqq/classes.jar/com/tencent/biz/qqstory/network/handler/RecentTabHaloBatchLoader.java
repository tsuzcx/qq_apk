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
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Queue<MsgTabNodeInfo> jdField_a_of_type_JavaUtilQueue;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicBoolean b = new AtomicBoolean(false);
  
  public RecentTabHaloBatchLoader(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
  }
  
  private void a(RecentTabHaloRequest paramRecentTabHaloRequest, RecentTabHaloResponse paramRecentTabHaloResponse)
  {
    StoryHaloManager localStoryHaloManager = (StoryHaloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STORY_HALO_MANAGER);
    List localList = paramRecentTabHaloResponse.a();
    localStoryHaloManager.a(paramRecentTabHaloResponse.a());
    if (paramRecentTabHaloRequest.a() == 3)
    {
      paramRecentTabHaloRequest = localList.iterator();
      while (paramRecentTabHaloRequest.hasNext())
      {
        paramRecentTabHaloResponse = (MsgTabNodeInfo)paramRecentTabHaloRequest.next();
        localStoryHaloManager.b(paramRecentTabHaloResponse);
        localStoryHaloManager.c(paramRecentTabHaloResponse);
        localStoryHaloManager.d(paramRecentTabHaloResponse);
      }
    }
    localStoryHaloManager.a(localList);
    localStoryHaloManager.a(localList, true);
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilQueue = new ConcurrentLinkedQueue();
  }
  
  private void c()
  {
    Object localObject = (StoryHaloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STORY_HALO_MANAGER);
    if (!this.b.get()) {
      for (;;)
      {
        MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)this.jdField_a_of_type_JavaUtilQueue.poll();
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
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void a(@NonNull RecentTabHaloRequest paramRecentTabHaloRequest, @Nullable RecentTabHaloResponse paramRecentTabHaloResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (a()) {
      return;
    }
    this.b.set(true);
    if ((paramRecentTabHaloResponse != null) && (!paramErrorMessage.isFail()))
    {
      a(paramRecentTabHaloRequest, paramRecentTabHaloResponse);
      this.b.set(false);
      c();
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
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.RecentTabHaloBatchLoader
 * JD-Core Version:    0.7.0.1
 */