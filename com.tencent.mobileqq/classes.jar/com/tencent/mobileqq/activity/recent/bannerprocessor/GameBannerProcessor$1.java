package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class GameBannerProcessor$1
  implements View.OnClickListener
{
  GameBannerProcessor$1(GameBannerProcessor paramGameBannerProcessor, Bundle paramBundle) {}
  
  public void onClick(View paramView)
  {
    if (GameBannerProcessor.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorGameBannerProcessor) != null) {
      GameBannerProcessor.b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorGameBannerProcessor).sendEmptyMessageDelayed(1000, 2500L);
    }
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("activity");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      localObject = Class.forName((String)localObject);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label52:
      String str;
      break label52;
    }
    localObject = null;
    if (localObject != null)
    {
      localObject = new Intent(GameBannerProcessor.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorGameBannerProcessor).getApplicationContext(), (Class)localObject);
      str = this.jdField_a_of_type_AndroidOsBundle.getString("action");
      if (!TextUtils.isEmpty(str)) {
        ((Intent)localObject).setAction(str);
      }
      str = this.jdField_a_of_type_AndroidOsBundle.getString("category");
      if (!TextUtils.isEmpty(str)) {
        ((Intent)localObject).addCategory(str);
      }
      str = this.jdField_a_of_type_AndroidOsBundle.getString("url");
      if (!TextUtils.isEmpty(str)) {
        ((Intent)localObject).putExtra("url", str);
      }
      ((Intent)localObject).setFlags(this.jdField_a_of_type_AndroidOsBundle.getInt("flags", 0));
      ((Intent)localObject).putExtra("force_no_reload", true);
      GameBannerProcessor.b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorGameBannerProcessor).startActivity((Intent)localObject);
    }
    ReportController.a(GameBannerProcessor.c(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorGameBannerProcessor).getAppRuntime(), "dc00898", "", "", "0X8009EE3", "0X8009EE3", 4, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.GameBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */