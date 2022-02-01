package com.tencent.mobileqq.activity.qwallet;

import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.utils.ContactUtils;

class TransactionActivity$11
  extends FriendListObserver
{
  TransactionActivity$11(TransactionActivity paramTransactionActivity) {}
  
  public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (paramString == null)) {
      return;
    }
    TransactionActivity.c(this.a, ContactUtils.d(this.a.app, TransactionActivity.c(this.a), false));
    paramString = QWalletTools.a(TransactionActivity.a(this.a), TransactionActivity.d(this.a), AIOUtils.a(TransactionActivity.c(this.a), TransactionActivity.a(this.a).getResources()), TransactionActivity.c(this.a).getPaint());
    TransactionActivity.c(this.a).setText(paramString + "(" + TransactionActivity.c(this.a) + ")");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.TransactionActivity.11
 * JD-Core Version:    0.7.0.1
 */