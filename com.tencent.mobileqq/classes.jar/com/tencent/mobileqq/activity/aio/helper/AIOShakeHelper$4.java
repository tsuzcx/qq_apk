package com.tencent.mobileqq.activity.aio.helper;

import afpo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShakeWindow;

public class AIOShakeHelper$4
  implements Runnable
{
  public AIOShakeHelper$4(afpo paramafpo, MessageForShakeWindow paramMessageForShakeWindow) {}
  
  public void run()
  {
    this.this$0.a();
    afpo.a(this.this$0).vibratorAndAudioForShake(this.a.frienduin, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOShakeHelper.4
 * JD-Core Version:    0.7.0.1
 */