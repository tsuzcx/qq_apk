package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.util.Pair;

class AccountManageActivity$30$1
  implements DialogInterface.OnClickListener
{
  AccountManageActivity$30$1(AccountManageActivity.30 param30, ISubAccountControlService paramISubAccountControlService, Pair paramPair) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.cancelHintDialog((String)this.b.first, ((Integer)this.b.second).intValue(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.30.1
 * JD-Core Version:    0.7.0.1
 */