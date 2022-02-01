package com.tencent.mobileqq.activity.weather;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.app.message.messageclean.MessageCleanManager;
import com.tencent.mobileqq.statistics.ReportController;

class SessionClearFragment$6$1
  implements DialogInterface.OnClickListener
{
  SessionClearFragment$6$1(SessionClearFragment.6 param6) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", "0X800A0C7", "0X800A0C7", 0, 0, String.valueOf(SessionClearFragment.g(this.a.a)), String.valueOf(SessionClearFragment.h(this.a.a)), "", "");
    SessionClearFragment.i(this.a.a);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("extra_delete_total_file_size", SessionClearFragment.j(this.a.a).c());
    Activity localActivity = SessionClearFragment.c(this.a.a);
    SessionClearFragment.c(this.a.a);
    localActivity.setResult(-1, paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.SessionClearFragment.6.1
 * JD-Core Version:    0.7.0.1
 */