package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.Destroyable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryHaloManager;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.network.request.RecentTabHaloRequest;
import com.tencent.biz.qqstory.network.response.RecentTabHaloResponse;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.dispatch.Dispatchers;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class RecentTabHaloBatchLoader
  implements Destroyable, CmdTaskManger.CommandCallback
{
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Queue jdField_a_of_type_JavaUtilQueue;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicBoolean b = new AtomicBoolean(false);
  
  public RecentTabHaloBatchLoader(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
  }
  
  private void a(RecentTabHaloResponse paramRecentTabHaloResponse)
  {
    StoryHaloManager localStoryHaloManager = (StoryHaloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(196);
    List localList = paramRecentTabHaloResponse.a();
    localStoryHaloManager.a(localList);
    localStoryHaloManager.a(paramRecentTabHaloResponse.a());
    localStoryHaloManager.a(localList, true);
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilQueue = new ConcurrentLinkedQueue();
  }
  
  private void c()
  {
    Object localObject = (StoryHaloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(196);
    if (!this.b.get())
    {
      MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)this.jdField_a_of_type_JavaUtilQueue.poll();
      while (localMsgTabNodeInfo != null) {
        ((StoryHaloManager)localObject).a(localMsgTabNodeInfo);
      }
    }
    localObject = new RecentTabHaloBatchLoader.RecentTabHaloEvent(true);
    Dispatchers.get().dispatch((Dispatcher.Dispatchable)localObject);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    if (this.jdField_a_of_type_JavaUtilQueue == null) {
      return;
    }
    if (this.b.get())
    {
      this.jdField_a_of_type_JavaUtilQueue.add(paramMsgTabNodeInfo);
      return;
    }
    ((StoryHaloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(196)).a(paramMsgTabNodeInfo);
    paramMsgTabNodeInfo = new RecentTabHaloBatchLoader.RecentTabHaloEvent(true);
    Dispatchers.get().dispatch(paramMsgTabNodeInfo);
  }
  
  public void a(@NonNull RecentTabHaloRequest paramRecentTabHaloRequest, @Nullable RecentTabHaloResponse paramRecentTabHaloResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (a()) {}
    do
    {
      return;
      this.b.set(true);
      if ((paramRecentTabHaloResponse != null) && (!paramErrorMessage.isFail())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("RecentTabHaloBatchLoader", 2, "onEvent: failed. Message: exception: " + paramErrorMessage);
    return;
    a(paramRecentTabHaloResponse);
    this.b.set(false);
    c();
  }
  
  public void a(@NonNull List paramList, int paramInt)
  {
    if (a()) {}
    String str;
    do
    {
      return;
      StoryHaloManager localStoryHaloManager = (StoryHaloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(196);
      str = localStoryHaloManager.a();
      localStoryHaloManager.a = paramList;
    } while (paramList.size() == 0);
    paramList = new RecentTabHaloRequest(str, paramList, paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloBatchLoader", 2, "request: invoked. Message: request: " + paramList);
    }
    CmdTaskManger.a().a(paramList, this);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.RecentTabHaloBatchLoader
 * JD-Core Version:    0.7.0.1
 */