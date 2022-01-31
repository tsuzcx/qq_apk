package com.tencent.mobileqq.activity;

import acog;
import agjh;
import agjx;
import android.os.SystemClock;
import android.view.View;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.qphone.base.util.QLog;

class ChatHistoryImageView$2
  implements Runnable
{
  ChatHistoryImageView$2(ChatHistoryImageView paramChatHistoryImageView, AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt) {}
  
  public void run()
  {
    Object localObject;
    long l;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("[onImageListLoad]: ");
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData == null)
      {
        localObject = "null";
        QLog.d("ChatHistoryImageView", 2, localObject);
      }
    }
    else
    {
      l = SystemClock.uptimeMillis();
      if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (!this.this$0.jdField_a_of_type_Agjh.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData, this.jdField_a_of_type_Int))) {
        this.this$0.jdField_a_of_type_Agjh.b();
      }
      if (this.this$0.jdField_a_of_type_Agjh.a() != 0) {
        break label231;
      }
      this.this$0.b.setVisibility(0);
    }
    for (;;)
    {
      if (!this.this$0.jdField_a_of_type_Agjx.a(false)) {
        this.this$0.jdField_a_of_type_Agjx.notifyDataSetChanged();
      }
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) {
        this.this$0.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, false);
      }
      if (this.this$0.jdField_a_of_type_Acog != null) {
        this.this$0.jdField_a_of_type_Acog.a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryImageView", 2, "[onImageListLoad] cost: " + (SystemClock.uptimeMillis() - l));
      }
      return;
      localObject = Integer.valueOf(this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData.length);
      break;
      label231:
      this.this$0.b.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryImageView.2
 * JD-Core Version:    0.7.0.1
 */