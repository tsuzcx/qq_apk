package com.tencent.mobileqq.activity.home;

import ajbw;
import com.tencent.qphone.base.util.QLog;
import vzt;

public class Conversation$30$1
  implements Runnable
{
  public Conversation$30$1(ajbw paramajbw) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.30.1
 * JD-Core Version:    0.7.0.1
 */