package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;

class LimitChatPie$25
  implements DialogInterface.OnClickListener
{
  LimitChatPie$25(LimitChatPie paramLimitChatPie) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.q = true;
    PlusPanelUtils.a(this.a.d, this.a.f, this.a.ah, true, null, null);
    ReportController.b(this.a.d, "dc00898", "", "", "0X800ADC9", "0X800ADC9", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.25
 * JD-Core Version:    0.7.0.1
 */