package com.tencent.mobileqq.activity.photo;

import android.os.Handler;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.Logger;

class SendPhotoActivity$1
  implements MessageQueue.IdleHandler
{
  SendPhotoActivity$1(SendPhotoActivity paramSendPhotoActivity) {}
  
  public boolean queueIdle()
  {
    Logger.a(SendPhotoActivity.jdField_a_of_type_JavaLangString, "queueIdle", "start");
    this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoTask = new SendPhotoTask(this.a, null, this.a.jdField_a_of_type_AndroidOsHandler);
    ThreadManager.post(this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoTask, 8, null, false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SendPhotoActivity.1
 * JD-Core Version:    0.7.0.1
 */