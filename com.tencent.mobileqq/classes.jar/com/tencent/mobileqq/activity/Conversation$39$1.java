package com.tencent.mobileqq.activity;

import aawt;
import ahkf;
import android.os.Message;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.app.QQAppInterface;

public class Conversation$39$1
  implements Runnable
{
  public Conversation$39$1(aawt paramaawt, long paramLong) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Aawt.a.jdField_a_of_type_Ahkf != null)
    {
      this.jdField_a_of_type_Aawt.a.jdField_a_of_type_Ahkf.b();
      if (this.jdField_a_of_type_Aawt.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Long) == 2)
      {
        Message localMessage = new Message();
        localMessage.obj = Long.valueOf(this.jdField_a_of_type_Long);
        this.jdField_a_of_type_Aawt.a.jdField_a_of_type_Ahkf.a(37, localMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.39.1
 * JD-Core Version:    0.7.0.1
 */