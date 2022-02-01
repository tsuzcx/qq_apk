package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;

class DialogActivity$8
  implements DialogInterface.OnClickListener
{
  DialogActivity$8(DialogActivity paramDialogActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).gotoTeamWorkListWebH5(this.a.app, this.a);
    this.a.finish();
    ReportController.b(this.a.app, "dc00898", "", "", "0X800906A", "0X800906A", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DialogActivity.8
 * JD-Core Version:    0.7.0.1
 */