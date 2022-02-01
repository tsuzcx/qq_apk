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
    Object localObject = ((MsgTabStoryManager)RecentTabHaloPresenter.a(paramRecentTabHaloPresenter).getManager(QQManagerFactory.MSG_TAB_STORY_MANAGER)).a().a(3, "");
    if ((localObject != null) && (paramReadStoryVideoEvent.b.equals(((MsgTabNodeInfo)localObject).e))) {
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "onEvent: invoked. Message: guideInfo: " + localObject);
      }
    }
    MsgTabNodeInfo localMsgTabNodeInfo;
    do
    {
      return;
      localObject = (StoryHaloManager)RecentTabHaloPresenter.a(paramRecentTabHaloPresenter).getManager(QQManagerFactory.STORY_HALO_MANAGER);
      localMsgTabNodeInfo = ((StoryHaloManager)localObject).b(paramReadStoryVideoEvent.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "syncHaloReadStatus: invoked. Message: haloNodeInfo: " + localMsgTabNodeInfo + "\nmanager: " + localObject);
      }
    } while (localMsgTabNodeInfo == null);
    int i = localMsgTabNodeInfo.a.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        MsgTabNodeVideoInfo localMsgTabNodeVideoInfo = (MsgTabNodeVideoInfo)localMsgTabNodeInfo.a.get(i);
        if ((localMsgTabNodeVideoInfo.jdField_a_of_type_Long == paramReadStoryVideoEvent.jdField_a_of_type_Long) && (!localMsgTabNodeVideoInfo.jdField_a_of_type_Boolean))
        {
          localMsgTabNodeVideoInfo.jdField_a_of_type_Boolean = true;
          localMsgTabNodeInfo.b -= 1;
        }
      }
      else
      {
        ((StoryHaloManager)localObject).c(localMsgTabNodeInfo);
        ((StoryHaloManager)localObject).b(localMsgTabNodeInfo);
        paramRecentTabHaloPresenter = new RecentTabHaloPresenter.ReadStoryVideoEventReceiver.2(this, paramRecentTabHaloPresenter);
        ThreadManager.getUIHandler().post(paramRecentTabHaloPresenter);
        return;
      }
      i -= 1;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.RecentTabHaloPresenter.ReadStoryVideoEventReceiver
 * JD-Core Version:    0.7.0.1
 */