package com.tencent.mobileqq.activity.photo;

import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class PhotoCropActivity$1
  extends Handler
{
  PhotoCropActivity$1(PhotoCropActivity paramPhotoCropActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1002)
    {
      if (i != 1003) {
        return;
      }
      if (!this.a.isFinishing())
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoCropActivity", 2, "LOADING_TIMEOUT");
        }
        PhotoCropActivity.a(this.a, 2131914303);
        this.a.d();
      }
    }
    else
    {
      this.a.c();
      this.a.D.sendMessageDelayed(Message.obtain(this.a.D, 1003), 10000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoCropActivity.1
 * JD-Core Version:    0.7.0.1
 */