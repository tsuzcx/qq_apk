package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;

class NotifyPCActiveActivity$1
  implements DialogInterface.OnClickListener
{
  NotifyPCActiveActivity$1(NotifyPCActiveActivity paramNotifyPCActiveActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    BaseApplicationImpl.getApplication().setPCActiveNotice(null, null, null, null);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPCActiveActivity.1
 * JD-Core Version:    0.7.0.1
 */