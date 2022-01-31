package com.tencent.mobileqq.activity;

import aawi;
import com.tencent.qphone.base.util.QLog;
import thy;

public class Conversation$27$1
  implements Runnable
{
  public Conversation$27$1(aawi paramaawi) {}
  
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
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.27.1
 * JD-Core Version:    0.7.0.1
 */