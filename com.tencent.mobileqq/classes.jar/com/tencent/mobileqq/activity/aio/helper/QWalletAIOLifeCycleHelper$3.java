package com.tencent.mobileqq.activity.aio.helper;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class QWalletAIOLifeCycleHelper$3
  implements View.OnClickListener
{
  QWalletAIOLifeCycleHelper$3(QWalletAIOLifeCycleHelper paramQWalletAIOLifeCycleHelper) {}
  
  public void onClick(View paramView)
  {
    try
    {
      ReportController.b(QWalletAIOLifeCycleHelper.b(this.a), "P_CliOper", "Vip_pay_mywallet", "", "500", "idiom.tips.click", 0, 0, "", "", "", "");
      QWalletAIOLifeCycleHelper.c(this.a).j().postDelayed(new QWalletAIOLifeCycleHelper.3.1(this), 200L);
      this.a.a();
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onclick  IdiomRedBagTips throw an exception: ");
      localStringBuilder.append(localThrowable);
      QLog.e("QWalletAIOLifeCycleHelper", 1, localStringBuilder.toString());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QWalletAIOLifeCycleHelper.3
 * JD-Core Version:    0.7.0.1
 */