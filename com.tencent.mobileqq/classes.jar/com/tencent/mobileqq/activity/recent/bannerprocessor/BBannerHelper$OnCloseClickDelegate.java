package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class BBannerHelper$OnCloseClickDelegate
  implements View.OnClickListener
{
  private BBannerHelper.MessageToShowBanner a;
  private MqqHandler b;
  
  public BBannerHelper$OnCloseClickDelegate(BBannerHelper.MessageToShowBanner paramMessageToShowBanner, MqqHandler paramMqqHandler)
  {
    this.a = paramMessageToShowBanner;
    this.b = paramMqqHandler;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.b);
      ((StringBuilder)localObject).append(" on close");
      QLog.d("Q.recent.banner", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.b.obtainMessage(1000);
    ((Message)localObject).obj = this.a;
    this.b.sendMessage((Message)localObject);
    this.a.e.onClose();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.BBannerHelper.OnCloseClickDelegate
 * JD-Core Version:    0.7.0.1
 */