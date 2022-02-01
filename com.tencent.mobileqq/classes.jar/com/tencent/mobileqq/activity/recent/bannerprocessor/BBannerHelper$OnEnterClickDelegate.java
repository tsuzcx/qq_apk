package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class BBannerHelper$OnEnterClickDelegate
  implements View.OnClickListener
{
  private BBannerHelper.MessageToShowBanner a;
  private MqqHandler b;
  
  public BBannerHelper$OnEnterClickDelegate(BBannerHelper.MessageToShowBanner paramMessageToShowBanner, MqqHandler paramMqqHandler)
  {
    this.b = paramMqqHandler;
    this.a = paramMessageToShowBanner;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.b);
      localStringBuilder.append(" on enter");
      QLog.d("Q.recent.banner", 2, localStringBuilder.toString());
    }
    this.a.e.onEnter();
    ReportController.a(null, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 1, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.BBannerHelper.OnEnterClickDelegate
 * JD-Core Version:    0.7.0.1
 */