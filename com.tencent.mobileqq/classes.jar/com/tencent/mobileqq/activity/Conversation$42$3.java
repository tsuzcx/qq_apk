package com.tencent.mobileqq.activity;

import aein;
import aljw;
import android.os.Message;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.app.QQAppInterface;

public class Conversation$42$3
  implements Runnable
{
  public Conversation$42$3(aein paramaein, long paramLong) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Aein.a.jdField_a_of_type_Aljw != null)
    {
      this.jdField_a_of_type_Aein.a.jdField_a_of_type_Aljw.b();
      if (this.jdField_a_of_type_Aein.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Long) == 2)
      {
        Message localMessage = new Message();
        localMessage.obj = Long.valueOf(this.jdField_a_of_type_Long);
        this.jdField_a_of_type_Aein.a.jdField_a_of_type_Aljw.a(40, localMessage);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Aein.a.jdField_a_of_type_Aljw.a(-1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.42.3
 * JD-Core Version:    0.7.0.1
 */