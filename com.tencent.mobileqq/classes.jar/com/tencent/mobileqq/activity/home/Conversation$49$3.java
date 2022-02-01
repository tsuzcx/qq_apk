package com.tencent.mobileqq.activity.home;

import android.os.Message;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.activity.recent.bannerprocessor.MultiVideoBannerProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerManager;

class Conversation$49$3
  implements Runnable
{
  Conversation$49$3(Conversation.49 param49, long paramLong) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$49.a.a != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$49.a.a.b(MultiVideoBannerProcessor.a, 2000);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$49.a.a().getAVNotifyCenter().b(this.jdField_a_of_type_Long) == 2)
      {
        Message localMessage = new Message();
        localMessage.obj = Long.valueOf(this.jdField_a_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$49.a.a.a(MultiVideoBannerProcessor.a, localMessage);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$49.a.a.a(-1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.49.3
 * JD-Core Version:    0.7.0.1
 */