package com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout.OnStrokeSelectedListener;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.stroke.HorizontalStroke;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

class DoodleLayout$2
  implements HorizontalSelectColorLayout.OnStrokeSelectedListener
{
  DoodleLayout$2(DoodleLayout paramDoodleLayout) {}
  
  public void a(@NonNull HorizontalStroke paramHorizontalStroke)
  {
    VideoEditReport.b("0X80075CD");
    if ((this.a.a != null) && (this.a.a.a == 3)) {
      LpReportInfo_pf00064.allReport(615, 1, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.2
 * JD-Core Version:    0.7.0.1
 */