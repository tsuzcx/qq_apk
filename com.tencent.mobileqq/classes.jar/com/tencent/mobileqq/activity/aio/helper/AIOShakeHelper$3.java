package com.tencent.mobileqq.activity.aio.helper;

import aggs;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShakeWindow;

public class AIOShakeHelper$3
  implements Runnable
{
  public AIOShakeHelper$3(aggs paramaggs, MessageForShakeWindow paramMessageForShakeWindow) {}
  
  public void run()
  {
    this.this$0.a();
    aggs.a(this.this$0).vibratorAndAudioForShake(this.a.frienduin, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOShakeHelper.3
 * JD-Core Version:    0.7.0.1
 */