package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;

class TroopMemberListActivity$31
  implements DialogInterface.OnDismissListener
{
  TroopMemberListActivity$31(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.mHandler.postDelayed(new TroopMemberListActivity.SearchDialogDismissRunnable(this.a), 150L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.31
 * JD-Core Version:    0.7.0.1
 */