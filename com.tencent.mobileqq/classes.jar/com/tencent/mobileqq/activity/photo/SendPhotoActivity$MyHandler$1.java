package com.tencent.mobileqq.activity.photo;

import com.tencent.mobileqq.app.QQAppInterface;

class SendPhotoActivity$MyHandler$1
  implements Runnable
{
  SendPhotoActivity$MyHandler$1(SendPhotoActivity.MyHandler paramMyHandler, boolean paramBoolean, String[] paramArrayOfString, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    
    if (this.a) {
      StatisticConstants.e();
    }
    try
    {
      StatisticConstants.a(this.b, this.c, false, false, -1, this.d);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SendPhotoActivity.MyHandler.1
 * JD-Core Version:    0.7.0.1
 */