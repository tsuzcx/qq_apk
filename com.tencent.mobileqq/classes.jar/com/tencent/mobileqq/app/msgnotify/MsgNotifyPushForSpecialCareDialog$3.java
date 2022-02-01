package com.tencent.mobileqq.app.msgnotify;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MsgNotifyPushForSpecialCareDialog$3
  implements View.OnClickListener
{
  MsgNotifyPushForSpecialCareDialog$3(MsgNotifyPushForSpecialCareDialog paramMsgNotifyPushForSpecialCareDialog) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(null, "dc00898", "", "", "0X8009ACD", "0X8009ACD", 0, 0, "", "", "", "");
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.msgnotify.MsgNotifyPushForSpecialCareDialog.3
 * JD-Core Version:    0.7.0.1
 */