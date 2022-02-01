package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.fragments.person.control.QCirclePersonHeaderPymkControl;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo;
import com.tencent.biz.qqcircle.widgets.QCircleFollowView.FollowReportListener;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;

class QFSPersonalInfoWidget$7
  implements QCircleFollowView.FollowReportListener
{
  final QCircleLpReportDc05504.DataBuilder a = new QCircleLpReportDc05504.DataBuilder().setActionType(11).setSubActionType(3).setExt2(String.valueOf(2)).setPageId(QFSPersonalInfoWidget.d(this.b));
  
  QFSPersonalInfoWidget$7(QFSPersonalInfoWidget paramQFSPersonalInfoWidget) {}
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((QFSPersonalInfoWidget.f(this.b) != null) && (!TextUtils.isEmpty(QFSPersonalInfoWidget.g(this.b))))
    {
      if (QFSPersonalInfoWidget.h(this.b) == null) {
        return;
      }
      QCircleLpReportDc05504.report(this.a.setToUin(QFSPersonalInfoWidget.f(this.b).c).setThrActionType(paramInt1).setExt1(String.valueOf(paramInt2)).setExt9(QFSPersonalInfoWidget.g(this.b)).setFeedReportInfo(QFSPersonalInfoWidget.h(this.b)));
    }
  }
  
  public void a()
  {
    a(3, 1);
  }
  
  public void a(int paramInt)
  {
    a(1, paramInt);
  }
  
  public void b(int paramInt)
  {
    a(2, paramInt);
    if ((paramInt == 0) || (paramInt == 2)) {
      QFSPersonalInfoWidget.e(this.b).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalInfoWidget.7
 * JD-Core Version:    0.7.0.1
 */