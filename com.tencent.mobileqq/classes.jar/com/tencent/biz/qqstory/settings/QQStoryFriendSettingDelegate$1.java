package com.tencent.biz.qqstory.settings;

import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class QQStoryFriendSettingDelegate$1
  extends QQStoryObserver
{
  QQStoryFriendSettingDelegate$1(QQStoryFriendSettingDelegate paramQQStoryFriendSettingDelegate) {}
  
  public void c(boolean paramBoolean)
  {
    QQStoryManager localQQStoryManager = (QQStoryManager)this.a.a.app.getManager(QQManagerFactory.QQSTORY_MANAGER);
    this.a.a(2, localQQStoryManager.a());
    this.a.a(3, localQQStoryManager.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryFriendSettingDelegate.1
 * JD-Core Version:    0.7.0.1
 */