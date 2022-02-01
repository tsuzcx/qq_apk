package com.tencent.biz.qqcircle.widgets;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.events.QCircleTaskCenterEvent;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.manager.QcircleRewardAdManager;
import com.tencent.biz.qqcircle.utils.StringUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import qqcircle.TaskCenterReader.TaskRecord;

class QCircleTaskItemView$1
  implements View.OnClickListener
{
  QCircleTaskItemView$1(QCircleTaskItemView paramQCircleTaskItemView, TaskCenterReader.TaskRecord paramTaskRecord) {}
  
  public void onClick(View paramView)
  {
    try
    {
      if (this.b.getContext() != null) {
        if (StringUtil.a(this.a.jumpUrl.get()))
        {
          QLog.w("QCircleTaskItemView", 1, "task item url is empty");
        }
        else
        {
          if (this.a.jumpUrl.get().startsWith("mqqapi://qcircle/openRewardAd")) {
            QcircleRewardAdManager.a().a(this.b.getContext(), this.a.jumpUrl.get());
          } else {
            QCircleLauncher.a(this.b.getContext(), this.a.jumpUrl.get());
          }
          QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(HostDataTransUtils.getAccount()).setActionType(8).setSubActionType(3).setThrActionType(this.a.taskType.get()).setPageId(this.b.getPageId()));
          SimpleEventBus.getInstance().dispatchEvent(new QCircleTaskCenterEvent(this.b.getContext().hashCode(), false));
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleTaskItemView.1
 * JD-Core Version:    0.7.0.1
 */