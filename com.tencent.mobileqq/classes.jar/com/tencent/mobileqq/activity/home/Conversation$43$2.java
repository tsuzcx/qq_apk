package com.tencent.mobileqq.activity.home;

import ajci;
import akho;
import android.os.Message;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.app.QQAppInterface;

public class Conversation$43$2
  implements Runnable
{
  public Conversation$43$2(ajci paramajci, long paramLong) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Ajci.a.jdField_a_of_type_Akho != null)
    {
      this.jdField_a_of_type_Ajci.a.jdField_a_of_type_Akho.c();
      if (this.jdField_a_of_type_Ajci.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().b(this.jdField_a_of_type_Long) == 2)
      {
        Message localMessage = new Message();
        localMessage.obj = Long.valueOf(this.jdField_a_of_type_Long);
        this.jdField_a_of_type_Ajci.a.jdField_a_of_type_Akho.a(42, localMessage);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Ajci.a.jdField_a_of_type_Akho.a(-1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.43.2
 * JD-Core Version:    0.7.0.1
 */