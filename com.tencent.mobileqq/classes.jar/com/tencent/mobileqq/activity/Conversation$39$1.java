package com.tencent.mobileqq.activity;

import acnn;
import ajbm;
import android.os.Message;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.app.QQAppInterface;

public class Conversation$39$1
  implements Runnable
{
  public Conversation$39$1(acnn paramacnn, long paramLong) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Acnn.a.jdField_a_of_type_Ajbm != null)
    {
      this.jdField_a_of_type_Acnn.a.jdField_a_of_type_Ajbm.b();
      if (this.jdField_a_of_type_Acnn.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Long) == 2)
      {
        Message localMessage = new Message();
        localMessage.obj = Long.valueOf(this.jdField_a_of_type_Long);
        this.jdField_a_of_type_Acnn.a.jdField_a_of_type_Ajbm.a(37, localMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.39.1
 * JD-Core Version:    0.7.0.1
 */