package com.tencent.mobileqq.activity.home;

import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.qphone.base.util.QLog;

class Conversation$31$1
  implements Runnable
{
  Conversation$31$1(Conversation.31 param31) {}
  
  public void run()
  {
    if (this.a.a.a != null)
    {
      this.a.a.a.d();
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "Conversation onUpdateFriendList");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.31.1
 * JD-Core Version:    0.7.0.1
 */