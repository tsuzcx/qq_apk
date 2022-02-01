package com.tencent.av.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.utils.QAVGroupConfig.Report;

class MultiIncomingCallsActivity$7
  implements DialogInterface.OnCancelListener
{
  MultiIncomingCallsActivity$7(MultiIncomingCallsActivity paramMultiIncomingCallsActivity, long paramLong) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.b.a(this.a, "onClickCancel", true, null, -1);
    this.b.b("onClickCancel");
    QAVGroupConfig.Report.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallsActivity.7
 * JD-Core Version:    0.7.0.1
 */