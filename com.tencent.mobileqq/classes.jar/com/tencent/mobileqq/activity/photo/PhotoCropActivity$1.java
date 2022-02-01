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
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      this.a.b();
      this.a.a.sendMessageDelayed(Message.obtain(this.a.a, 1003), 10000L);
      return;
    } while (this.a.isFinishing());
    if (QLog.isColorLevel()) {
      QLog.d("PhotoCropActivity", 2, "LOADING_TIMEOUT");
    }
    PhotoCropActivity.a(this.a, 2131717172);
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoCropActivity.1
 * JD-Core Version:    0.7.0.1
 */