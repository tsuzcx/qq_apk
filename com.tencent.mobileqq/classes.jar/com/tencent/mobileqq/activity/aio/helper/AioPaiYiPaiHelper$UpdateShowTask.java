package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;

class AioPaiYiPaiHelper$UpdateShowTask
  implements Runnable
{
  private AioPaiYiPaiHelper a;
  private MessageForUniteGrayTip b;
  
  AioPaiYiPaiHelper$UpdateShowTask(AioPaiYiPaiHelper paramAioPaiYiPaiHelper, MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    this.a = paramAioPaiYiPaiHelper;
    this.b = paramMessageForUniteGrayTip;
  }
  
  public void run()
  {
    AioPaiYiPaiHelper.a(this.a).i().getMessageFacade().a(this.b.frienduin, this.b.istroop, this.b.uniseq, "extStr", this.b.extStr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AioPaiYiPaiHelper.UpdateShowTask
 * JD-Core Version:    0.7.0.1
 */