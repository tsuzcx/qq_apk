package com.tencent.mobileqq.activity;

import acnb;
import com.tencent.qphone.base.util.QLog;
import uwn;

public class Conversation$26$1
  implements Runnable
{
  public Conversation$26$1(acnb paramacnb) {}
  
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
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.26.1
 * JD-Core Version:    0.7.0.1
 */