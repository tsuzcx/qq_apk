package com.tencent.mobileqq.activity.home;

import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.qphone.base.util.QLog;

class Conversation$32$1
  implements Runnable
{
  Conversation$32$1(Conversation.32 param32) {}
  
  public void run()
  {
    if (this.a.a.w != null)
    {
      this.a.a.w.d();
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "Conversation onUpdateFriendList");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.32.1
 * JD-Core Version:    0.7.0.1
 */