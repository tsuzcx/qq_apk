package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.StoryHaloManager;
import com.tencent.biz.qqstory.model.events.ReadStoryVideoEvent;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVideoInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;
import mqq.os.MqqHandler;

public final class RecentTabHaloPresenter$ReadStoryVideoEventReceiver
  extends QQUIEventReceiver<RecentTabHaloPresenter, ReadStoryVideoEvent>
{
  public RecentTabHaloPresenter$ReadStoryVideoEventReceiver(@NonNull RecentTabHaloPresenter paramRecentTabHaloPresenter)
  {
    super(paramRecentTabHaloPresenter);
  }
  
  private void b(RecentTabHaloPresenter paramRecentTabHaloPresenter, ReadStoryVideoEvent paramReadStoryVideoEvent)
  {
    Object localObject1 = ((MsgTabStoryManager)RecentTabHaloPresenter.a(paramRecentTabHaloPresenter).getManager(QQManagerFactory.MSG_TAB_STORY_MANAGER)).a().a(3, "");
    if ((localObject1 != null) && (paramReadStoryVideoEvent.b.equals(((MsgTabNodeInfo)localObject1).e)))
    {
      if (QLog.isColorLevel())
      {
        paramRecentTabHaloPresenter = this.TAG;
        paramReadStoryVideoEvent = new StringBuilder();
        paramReadStoryVideoEvent.append("onEvent: invoked. Message: guideInfo: ");
        paramReadStoryVideoEvent.append(localObject1);
        QLog.i(paramRecentTabHaloPresenter, 2, paramReadStoryVideoEvent.toString());
      }
      return;
    }
    localObject1 = (StoryHaloManager)RecentTabHaloPresenter.a(paramRecentTabHaloPresenter).getManager(QQManagerFactory.STORY_HALO_MANAGER);
    MsgTabNodeInfo localMsgTabNodeInfo = ((StoryHaloManager)localObject1).b(paramReadStoryVideoEvent.jdField_a_of_type_JavaLangString);
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("syncHaloReadStatus: invoked. Message: haloNodeInfo: ");
      localStringBuilder.append(localMsgTabNodeInfo);
      localStringBuilder.append("\nmanager: ");
      localStringBuilder.append(localObject1);
      QLog.i((String)localObject2, 2, localStringBuilder.toString());
    }
    if (localMsgTabNodeInfo == null) {
      return;
    }
    int i = localMsgTabNodeInfo.a.size() - 1;
    while (i >= 0)
    {
      localObject2 = (MsgTabNodeVideoInfo)localMsgTabNodeInfo.a.get(i);
      if ((((MsgTabNodeVideoInfo)localObject2).jdField_a_of_type_Long == paramReadStoryVideoEvent.jdField_a_of_type_Long) && (!((MsgTabNodeVideoInfo)localObject2).jdField_a_of_type_Boolean))
      {
        ((MsgTabNodeVideoInfo)localObject2).jdField_a_of_type_Boolean = true;
        localMsgTabNodeInfo.b -= 1;
        break;
      }
      i -= 1;
    }
    ((StoryHaloManager)localObject1).c(localMsgTabNodeInfo);
    ((StoryHaloManager)localObject1).b(localMsgTabNodeInfo);
    paramRecentTabHaloPresenter = new RecentTabHaloPresenter.ReadStoryVideoEventReceiver.2(this, paramRecentTabHaloPresenter);
    ThreadManager.getUIHandler().post(paramRecentTabHaloPresenter);
  }
  
  public void a(@NonNull RecentTabHaloPresenter paramRecentTabHaloPresenter, @NonNull ReadStoryVideoEvent paramReadStoryVideoEvent)
  {
    ThreadManager.post(new RecentTabHaloPresenter.ReadStoryVideoEventReceiver.1(this, paramRecentTabHaloPresenter, paramReadStoryVideoEvent), 8, null, true);
  }
  
  public Class acceptEventClass()
  {
    return ReadStoryVideoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.RecentTabHaloPresenter.ReadStoryVideoEventReceiver
 * JD-Core Version:    0.7.0.1
 */