package com.tencent.biz.pubaccount.readinjoy.activity;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;

class ReadInJoyNewFeedsActivity$15
  implements Runnable
{
  ReadInJoyNewFeedsActivity$15(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity) {}
  
  public void run()
  {
    QQMessageFacade localQQMessageFacade = this.this$0.app.getMessageFacade();
    if (localQQMessageFacade != null)
    {
      int i = localQQMessageFacade.b();
      this.this$0.f(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity.15
 * JD-Core Version:    0.7.0.1
 */