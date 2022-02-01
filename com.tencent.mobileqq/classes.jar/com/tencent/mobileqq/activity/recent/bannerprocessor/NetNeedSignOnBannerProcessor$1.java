package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NetNeedSignOnBannerProcessor$1
  implements View.OnClickListener
{
  NetNeedSignOnBannerProcessor$1(NetNeedSignOnBannerProcessor paramNetNeedSignOnBannerProcessor, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("click move to url:");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("Q.recent.banner", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Intent(NetNeedSignOnBannerProcessor.a(this.b), QQBrowserDelegationActivity.class);
    ((Intent)localObject).putExtra("injectrecommend", true);
    NetNeedSignOnBannerProcessor.b(this.b).startActivity(((Intent)localObject).putExtra("url", this.a));
    ReportController.a(NetNeedSignOnBannerProcessor.c(this.b).getAppRuntime(), "CliOper", "", "", "0X8004029", "0X8004029", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.NetNeedSignOnBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */