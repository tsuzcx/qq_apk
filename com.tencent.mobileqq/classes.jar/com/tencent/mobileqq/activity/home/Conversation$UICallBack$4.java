package com.tencent.mobileqq.activity.home;

import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import mqq.app.AppRuntime;

class Conversation$UICallBack$4
  implements Runnable
{
  Conversation$UICallBack$4(Conversation.UICallBack paramUICallBack) {}
  
  public void run()
  {
    if (((MsgTabStoryNodeConfigManager)this.a.a.a.getManager(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER)).a)
    {
      ((MsgTabStoryManager)this.a.a.a.getManager(QQManagerFactory.MSG_TAB_STORY_MANAGER)).a();
      this.a.a.b(new Conversation.UICallBack.4.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.UICallBack.4
 * JD-Core Version:    0.7.0.1
 */