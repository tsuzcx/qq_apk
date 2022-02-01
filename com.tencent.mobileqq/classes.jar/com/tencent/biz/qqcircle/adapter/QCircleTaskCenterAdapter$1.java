package com.tencent.biz.qqcircle.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.manager.QCircleFuelAnimationManager;
import com.tencent.biz.qqcircle.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;

class QCircleTaskCenterAdapter$1
  implements View.OnClickListener
{
  QCircleTaskCenterAdapter$1(QCircleTaskCenterAdapter paramQCircleTaskCenterAdapter) {}
  
  public void onClick(View paramView)
  {
    if (QCircleTaskCenterAdapter.a(this.a) != null)
    {
      if (StringUtil.a(QCircleTaskCenterAdapter.a(this.a))) {
        QLog.w("QCircleTaskCenterAdapter", 1, "task center url is empty");
      }
      QCircleHostLauncher.doJumpAction(QCircleTaskCenterAdapter.b(this.a), QCircleTaskCenterAdapter.a(this.a));
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(HostDataTransUtils.getAccount()).setActionType(8).setSubActionType(2).setThrActionType(0).setPageId(this.a.getPageId()).setfPageId(this.a.getParentPageId()));
      QCircleFuelAnimationManager.a().b(false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleTaskCenterAdapter.1
 * JD-Core Version:    0.7.0.1
 */