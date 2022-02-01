package com.tencent.mobileqq.activity.qwallet;

import cooperation.qwallet.plugin.QWalletHelper;
import org.json.JSONObject;

class TransactionActivity$3
  implements Runnable
{
  TransactionActivity$3(TransactionActivity paramTransactionActivity) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = QWalletHelper.loadUnifiedConfig(TransactionActivity.a(this.this$0));
      if (localJSONObject != null)
      {
        localJSONObject = localJSONObject.optJSONObject("qpayment");
        if (localJSONObject != null)
        {
          TransactionActivity.a(this.this$0, localJSONObject.optInt("large_transfer_remind_fee"));
          TransactionActivity.a(this.this$0, localJSONObject.optString("large_transfer_remind_msg"));
          TransactionActivity.b(this.this$0, localJSONObject.optInt("min_transfer_stranger_fee"));
          TransactionActivity.b(this.this$0, localJSONObject.optString("min_transfer_stranger_msg"));
          TransactionActivity.a(this.this$0);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.TransactionActivity.3
 * JD-Core Version:    0.7.0.1
 */