package com.tencent.mobileqq.activity;

import aegp;
import aeic;
import aeis;
import aeiy;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;

class ChatHistoryImageView$1
  implements Runnable
{
  ChatHistoryImageView$1(ChatHistoryImageView paramChatHistoryImageView, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.h) {}
    do
    {
      return;
      Object localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.b(this.a);
      if ((localObject != null) && (QLog.isColorLevel())) {
        QLog.i("ChatHistoryImageView", 2, "onRevokeMsg, seq:" + ((ChatMessage)localObject).uniseq);
      }
      localObject = this.this$0.jdField_a_of_type_Aeic.a(this.a);
      if (localObject != null)
      {
        this.this$0.jdField_a_of_type_Aeic.b((aeiy)localObject);
        this.this$0.jdField_a_of_type_Aeis.notifyDataSetChanged();
      }
    } while ((!this.this$0.g) || (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData == null) || (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.f != this.a));
    aegp.a(this.this$0.jdField_a_of_type_AndroidAppActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryImageView.1
 * JD-Core Version:    0.7.0.1
 */