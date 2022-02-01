package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter;

class LimitChatPie$10
  implements DialogInterface.OnDismissListener
{
  LimitChatPie$10(LimitChatPie paramLimitChatPie) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    ArkAppNotifyCenter.setNotify("com.tencent.mobileqq.expand.aiosafe", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.10
 * JD-Core Version:    0.7.0.1
 */