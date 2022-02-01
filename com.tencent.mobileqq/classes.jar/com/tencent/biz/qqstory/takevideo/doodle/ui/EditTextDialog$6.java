package com.tencent.biz.qqstory.takevideo.doodle.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

class EditTextDialog$6
  implements View.OnClickListener
{
  EditTextDialog$6(EditTextDialog paramEditTextDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    if ((this.a.a != null) && (this.a.a.a == 3)) {
      LpReportInfo_pf00064.allReport(615, 3, 4);
    }
    VideoEditReport.a("0X80076C6");
    VideoEditReport.b("0X80075DA");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog.6
 * JD-Core Version:    0.7.0.1
 */