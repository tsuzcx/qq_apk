package com.tencent.mobileqq.activity;

import acsc;
import ajgb;
import android.os.Message;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.app.QQAppInterface;

public class Conversation$39$2
  implements Runnable
{
  public Conversation$39$2(acsc paramacsc, long paramLong) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Acsc.a.jdField_a_of_type_Ajgb != null)
    {
      this.jdField_a_of_type_Acsc.a.jdField_a_of_type_Ajgb.b();
      if (this.jdField_a_of_type_Acsc.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Long) == 2)
      {
        Message localMessage = new Message();
        localMessage.obj = Long.valueOf(this.jdField_a_of_type_Long);
        this.jdField_a_of_type_Acsc.a.jdField_a_of_type_Ajgb.a(37, localMessage);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Acsc.a.jdField_a_of_type_Ajgb.a(-1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.39.2
 * JD-Core Version:    0.7.0.1
 */