package com.tencent.mobileqq.activity;

import aams;
import com.tencent.qphone.base.util.QLog;
import svc;

public class Conversation$28$1
  implements Runnable
{
  public Conversation$28$1(aams paramaams) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.28.1
 * JD-Core Version:    0.7.0.1
 */