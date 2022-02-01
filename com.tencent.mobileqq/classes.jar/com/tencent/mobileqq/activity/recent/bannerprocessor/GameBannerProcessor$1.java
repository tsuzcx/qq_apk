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
    Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("activity");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    try
    {
      localObject1 = Class.forName((String)localObject1);
      if (localObject1 != null)
      {
        localObject1 = new Intent(GameBannerProcessor.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorGameBannerProcessor).getApplicationContext(), (Class)localObject1);
        String str = this.jdField_a_of_type_AndroidOsBundle.getString("action");
        if (!TextUtils.isEmpty(str)) {
          ((Intent)localObject1).setAction(str);
        }
        str = this.jdField_a_of_type_AndroidOsBundle.getString("category");
        if (!TextUtils.isEmpty(str)) {
          ((Intent)localObject1).addCategory(str);
        }
        str = this.jdField_a_of_type_AndroidOsBundle.getString("url");
        if (!TextUtils.isEmpty(str)) {
          ((Intent)localObject1).putExtra("url", str);
        }
        ((Intent)localObject1).setFlags(this.jdField_a_of_type_AndroidOsBundle.getInt("flags", 0));
        ((Intent)localObject1).putExtra("force_no_reload", true);
        GameBannerProcessor.b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorGameBannerProcessor).startActivity((Intent)localObject1);
      }
      ReportController.a(GameBannerProcessor.c(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorGameBannerProcessor).getAppRuntime(), "dc00898", "", "", "0X8009EE3", "0X8009EE3", 4, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.GameBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */