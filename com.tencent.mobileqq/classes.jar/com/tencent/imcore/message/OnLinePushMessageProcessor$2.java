package com.tencent.imcore.message;

import abow;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public class OnLinePushMessageProcessor$2
  implements Runnable
{
  public OnLinePushMessageProcessor$2(abow paramabow, int paramInt) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), "Linkstar Push!ChooserAc!! msgType = " + this.a, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.imcore.message.OnLinePushMessageProcessor.2
 * JD-Core Version:    0.7.0.1
 */