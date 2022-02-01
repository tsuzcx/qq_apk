package com.tencent.mobileqq.activity;

import aeib;
import com.tencent.qphone.base.util.QLog;
import wyd;

public class Conversation$29$1
  implements Runnable
{
  public Conversation$29$1(aeib paramaeib) {}
  
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
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.29.1
 * JD-Core Version:    0.7.0.1
 */