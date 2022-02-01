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
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.d("Q.recent.banner", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Intent(NetNeedSignOnBannerProcessor.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorNetNeedSignOnBannerProcessor), QQBrowserDelegationActivity.class);
    ((Intent)localObject).putExtra("injectrecommend", true);
    NetNeedSignOnBannerProcessor.b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorNetNeedSignOnBannerProcessor).startActivity(((Intent)localObject).putExtra("url", this.jdField_a_of_type_JavaLangString));
    ReportController.a(NetNeedSignOnBannerProcessor.c(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorNetNeedSignOnBannerProcessor).getAppRuntime(), "CliOper", "", "", "0X8004029", "0X8004029", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.NetNeedSignOnBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */