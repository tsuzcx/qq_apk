package com.tencent.biz.pubaccount.subscript;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;

class SubscriptFeedsActivity$2
  implements Runnable
{
  SubscriptFeedsActivity$2(SubscriptFeedsActivity paramSubscriptFeedsActivity) {}
  
  public void run()
  {
    WebProcessManager localWebProcessManager = (WebProcessManager)this.this$0.app.getManager(13);
    if (localWebProcessManager != null) {
      localWebProcessManager.a(1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SubscriptFeedsActivity", 2, "enter folder preload web process");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.2
 * JD-Core Version:    0.7.0.1
 */