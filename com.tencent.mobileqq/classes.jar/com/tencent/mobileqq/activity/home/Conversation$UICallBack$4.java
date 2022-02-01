package com.tencent.mobileqq.activity.home;

import ajza;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import wmr;
import wms;

public class Conversation$UICallBack$4
  implements Runnable
{
  public Conversation$UICallBack$4(ajza paramajza) {}
  
  public void run()
  {
    if (((wms)this.a.a.a.getManager(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER)).a)
    {
      ((wmr)this.a.a.a.getManager(QQManagerFactory.MSG_TAB_STORY_MANAGER)).a();
      this.a.a.b(new Conversation.UICallBack.4.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.UICallBack.4
 * JD-Core Version:    0.7.0.1
 */