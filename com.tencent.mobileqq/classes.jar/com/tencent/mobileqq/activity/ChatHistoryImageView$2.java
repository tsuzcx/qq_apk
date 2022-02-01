package com.tencent.mobileqq.activity;

import android.os.SystemClock;
import android.view.View;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListModel;
import com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.qphone.base.util.QLog;

class ChatHistoryImageView$2
  implements Runnable
{
  ChatHistoryImageView$2(ChatHistoryImageView paramChatHistoryImageView, AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt) {}
  
  public void run()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onImageListLoad]: ");
      localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if (localObject == null) {
        localObject = "null";
      } else {
        localObject = Integer.valueOf(localObject.length);
      }
      localStringBuilder.append(localObject);
      QLog.d("ChatHistoryImageView", 2, localStringBuilder.toString());
    }
    long l = SystemClock.uptimeMillis();
    if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (!this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData, this.jdField_a_of_type_Int))) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
    }
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a() == 0) {
      this.this$0.b.setVisibility(0);
    } else {
      this.this$0.b.setVisibility(4);
    }
    if (!this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.a(false)) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.notifyDataSetChanged();
    }
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null)
    {
      localObject = this.this$0;
      ((ChatHistoryImageView)localObject).a(((ChatHistoryImageView)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, false);
    }
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$OperCallBack != null) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$OperCallBack.a();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onImageListLoad] cost: ");
      ((StringBuilder)localObject).append(SystemClock.uptimeMillis() - l);
      QLog.d("ChatHistoryImageView", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryImageView.2
 * JD-Core Version:    0.7.0.1
 */