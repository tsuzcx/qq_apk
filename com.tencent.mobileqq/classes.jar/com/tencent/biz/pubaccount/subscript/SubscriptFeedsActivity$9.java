package com.tencent.biz.pubaccount.subscript;

import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;

class SubscriptFeedsActivity$9
  implements Runnable
{
  SubscriptFeedsActivity$9(SubscriptFeedsActivity paramSubscriptFeedsActivity) {}
  
  public void run()
  {
    QQMessageFacade localQQMessageFacade = this.this$0.app.getMessageFacade();
    if (localQQMessageFacade != null)
    {
      int i = localQQMessageFacade.w();
      this.this$0.leftView.post(new SubscriptFeedsActivity.9.1(this, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.9
 * JD-Core Version:    0.7.0.1
 */