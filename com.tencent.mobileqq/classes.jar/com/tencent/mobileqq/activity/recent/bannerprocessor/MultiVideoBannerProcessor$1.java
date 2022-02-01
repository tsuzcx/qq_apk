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

class MultiVideoBannerProcessor$1
  implements View.OnClickListener
{
  MultiVideoBannerProcessor$1(MultiVideoBannerProcessor paramMultiVideoBannerProcessor) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (MultiVideoBannerProcessor.a(this.a) != null) {
      localObject = MultiVideoBannerProcessor.b(this.a).getAppRuntime();
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoBar", 2, "app is null");
      }
    }
    else
    {
      localObject = (QQAppInterface)localObject;
      int k = ((QQAppInterface)localObject).getAVNotifyCenter().t();
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "initMultiVideoBar-->SessionType");
      }
      int j = 1;
      int i = j;
      if (k != 1) {
        if (k == 2) {
          i = j;
        } else {
          i = 0;
        }
      }
      if (i != 0) {
        ChatAVHelper.a((QQAppInterface)localObject, k, (BaseActivity)MultiVideoBannerProcessor.c(this.a));
      } else {
        ChatAVHelper.b((QQAppInterface)localObject, k, (BaseActivity)MultiVideoBannerProcessor.d(this.a));
      }
      ReportController.a(MultiVideoBannerProcessor.e(this.a).getAppRuntime(), "dc00898", "", "", "0X8009EE5", "0X8009EE5", 1, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.MultiVideoBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */