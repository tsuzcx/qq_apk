package com.tencent.mobileqq.activity.home;

import android.os.Message;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerManager;

class Conversation$47$2
  implements Runnable
{
  Conversation$47$2(Conversation.47 param47, long paramLong) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$47.a.a != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$47.a.a.b(42, 2000);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$47.a.a().getAVNotifyCenter().b(this.jdField_a_of_type_Long) == 2)
      {
        Message localMessage = new Message();
        localMessage.obj = Long.valueOf(this.jdField_a_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$47.a.a.a(42, localMessage);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$47.a.a.a(-1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.47.2
 * JD-Core Version:    0.7.0.1
 */