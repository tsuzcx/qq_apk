package com.tencent.mobileqq.activity.aio.anim.businesseggs;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationRule;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

class BusinessEggsPlayer$1
  implements Runnable
{
  BusinessEggsPlayer$1(BusinessEggsPlayer paramBusinessEggsPlayer, QQAppInterface paramQQAppInterface, AIOAnimationConatiner paramAIOAnimationConatiner, Drawable paramDrawable, AioAnimationRule paramAioAnimationRule, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    AioAnimationDetector.a().a(this.a, this.b, this.c, this.d, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.businesseggs.BusinessEggsPlayer.1
 * JD-Core Version:    0.7.0.1
 */