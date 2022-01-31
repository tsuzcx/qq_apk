package com.tencent.mobileqq.activity;

import aand;
import agxq;
import android.os.Message;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.app.QQAppInterface;

public class Conversation$40$3
  implements Runnable
{
  public Conversation$40$3(aand paramaand, long paramLong) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Aand.a.jdField_a_of_type_Agxq != null)
    {
      this.jdField_a_of_type_Aand.a.jdField_a_of_type_Agxq.b();
      if (this.jdField_a_of_type_Aand.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Long) == 2)
      {
        Message localMessage = new Message();
        localMessage.obj = Long.valueOf(this.jdField_a_of_type_Long);
        this.jdField_a_of_type_Aand.a.jdField_a_of_type_Agxq.a(36, localMessage);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Aand.a.jdField_a_of_type_Agxq.a(-1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.40.3
 * JD-Core Version:    0.7.0.1
 */