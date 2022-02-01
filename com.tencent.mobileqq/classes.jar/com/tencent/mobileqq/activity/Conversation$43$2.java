package com.tencent.mobileqq.activity;

import adzo;
import akyh;
import android.os.Message;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.app.QQAppInterface;

public class Conversation$43$2
  implements Runnable
{
  public Conversation$43$2(adzo paramadzo, long paramLong) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Adzo.a.jdField_a_of_type_Akyh != null)
    {
      this.jdField_a_of_type_Adzo.a.jdField_a_of_type_Akyh.b();
      if (this.jdField_a_of_type_Adzo.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Long) == 2)
      {
        Message localMessage = new Message();
        localMessage.obj = Long.valueOf(this.jdField_a_of_type_Long);
        this.jdField_a_of_type_Adzo.a.jdField_a_of_type_Akyh.a(39, localMessage);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Adzo.a.jdField_a_of_type_Akyh.a(-1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.43.2
 * JD-Core Version:    0.7.0.1
 */