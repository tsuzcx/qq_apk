package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShakeWindow;

class AIOShakeHelper$3
  implements Runnable
{
  AIOShakeHelper$3(AIOShakeHelper paramAIOShakeHelper, MessageForShakeWindow paramMessageForShakeWindow) {}
  
  public void run()
  {
    this.this$0.a();
    AIOShakeHelper.c(this.this$0).vibratorAndAudioForShake(this.a.frienduin, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOShakeHelper.3
 * JD-Core Version:    0.7.0.1
 */