package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.activity.ChatAVHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class MultiVideoBannerProcessor$1
  implements View.OnClickListener
{
  MultiVideoBannerProcessor$1(MultiVideoBannerProcessor paramMultiVideoBannerProcessor) {}
  
  public void onClick(View paramView)
  {
    if (MultiVideoBannerProcessor.a(this.a) != null) {}
    for (AppRuntime localAppRuntime = MultiVideoBannerProcessor.b(this.a).getAppRuntime(); localAppRuntime == null; localAppRuntime = null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoBar", 2, "app is null");
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    int j = ((QQAppInterface)localAppRuntime).getAVNotifyCenter().e();
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "initMultiVideoBar-->SessionType");
    }
    int i;
    if ((j == 1) || (j == 2))
    {
      i = 1;
      label93:
      if (i == 0) {
        break label157;
      }
      ChatAVHelper.a((QQAppInterface)localAppRuntime, j, (BaseActivity)MultiVideoBannerProcessor.c(this.a));
    }
    for (;;)
    {
      ReportController.a(MultiVideoBannerProcessor.e(this.a).getAppRuntime(), "dc00898", "", "", "0X8009EE5", "0X8009EE5", 1, 0, "", "", "", "");
      break;
      i = 0;
      break label93;
      label157:
      ChatAVHelper.b((QQAppInterface)localAppRuntime, j, (BaseActivity)MultiVideoBannerProcessor.d(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.MultiVideoBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */