package com.tencent.biz.pubaccount.readinjoy.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;

class ReadInJoyNewFeedsActivity$14
  implements Runnable
{
  ReadInJoyNewFeedsActivity$14(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity) {}
  
  public void run()
  {
    QQMessageFacade localQQMessageFacade = this.this$0.app.a();
    if (localQQMessageFacade != null)
    {
      int i = localQQMessageFacade.b();
      this.this$0.f(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity.14
 * JD-Core Version:    0.7.0.1
 */