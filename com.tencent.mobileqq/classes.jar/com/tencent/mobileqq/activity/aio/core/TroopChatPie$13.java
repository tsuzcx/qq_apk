package com.tencent.mobileqq.activity.aio.core;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.TroopLowCreditLevelNotifyActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class TroopChatPie$13
  implements DialogInterface.OnClickListener
{
  TroopChatPie$13(TroopChatPie paramTroopChatPie) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.a.e, TroopLowCreditLevelNotifyActivity.class);
    paramDialogInterface.putExtra("troopUin", this.a.ah.b);
    this.a.e.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.13
 * JD-Core Version:    0.7.0.1
 */