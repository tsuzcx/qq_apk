package com.tencent.biz.qqstory.storyHome;

import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.MessageNotifySegment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.observer.GetRedPointExObserver;
import com.tencent.qphone.base.util.QLog;

class QQStoryMainController$7
  extends GetRedPointExObserver
{
  QQStoryMainController$7(QQStoryMainController paramQQStoryMainController) {}
  
  protected void a(Object paramObject)
  {
    if (this.a.d == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryMainController", 2, "refresh red point if needed");
    }
    paramObject = ((TroopRedTouchManager)this.a.d.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).e(52);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("更新小黑条红点:");
      ((StringBuilder)localObject).append(TroopRedTouchManager.b(paramObject));
      QLog.i("storyRedDotDebug", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (MessageNotifySegment)this.a.b.b("MessageNotifySegment");
    if (localObject != null)
    {
      ((MessageNotifySegment)localObject).a(paramObject);
      this.a.b.q();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryMainController.7
 * JD-Core Version:    0.7.0.1
 */