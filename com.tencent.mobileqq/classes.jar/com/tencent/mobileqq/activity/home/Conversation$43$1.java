package com.tencent.mobileqq.activity.home;

import ajxx;
import aldh;
import android.os.Message;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.app.QQAppInterface;

public class Conversation$43$1
  implements Runnable
{
  public Conversation$43$1(ajxx paramajxx, long paramLong) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Ajxx.a.jdField_a_of_type_Aldh != null)
    {
      this.jdField_a_of_type_Ajxx.a.jdField_a_of_type_Aldh.c();
      if (this.jdField_a_of_type_Ajxx.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().b(this.jdField_a_of_type_Long) == 2)
      {
        Message localMessage = new Message();
        localMessage.obj = Long.valueOf(this.jdField_a_of_type_Long);
        this.jdField_a_of_type_Ajxx.a.jdField_a_of_type_Aldh.a(43, localMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.43.1
 * JD-Core Version:    0.7.0.1
 */