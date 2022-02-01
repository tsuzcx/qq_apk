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
    Logger.a(SendPhotoActivity.a, "queueIdle", "start");
    this.a.h.removeMessages(3);
    SendPhotoActivity localSendPhotoActivity = this.a;
    localSendPhotoActivity.c = new SendPhotoTask(localSendPhotoActivity, null, localSendPhotoActivity.h);
    ThreadManager.post(this.a.c, 8, null, false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SendPhotoActivity.1
 * JD-Core Version:    0.7.0.1
 */