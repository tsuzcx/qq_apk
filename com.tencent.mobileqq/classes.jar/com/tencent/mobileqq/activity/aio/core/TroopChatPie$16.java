package com.tencent.mobileqq.activity.aio.core;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.statistics.ReportTask;

class TroopChatPie$16
  implements DialogInterface.OnClickListener
{
  TroopChatPie$16(TroopChatPie paramTroopChatPie) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    new ReportTask(this.a.d).a("dc00899").b("Grp_banned").c("Grp_AIO").d("clk_cancel").a(new String[] { this.a.ah.b }).a();
    this.a.L();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.16
 * JD-Core Version:    0.7.0.1
 */