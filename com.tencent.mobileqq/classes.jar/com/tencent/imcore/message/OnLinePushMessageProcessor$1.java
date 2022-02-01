package com.tencent.imcore.message;

import acwk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public class OnLinePushMessageProcessor$1
  implements Runnable
{
  public OnLinePushMessageProcessor$1(acwk paramacwk, int paramInt) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), "Linkstar Push!ChooserAc!! msgType = " + this.a, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.OnLinePushMessageProcessor.1
 * JD-Core Version:    0.7.0.1
 */