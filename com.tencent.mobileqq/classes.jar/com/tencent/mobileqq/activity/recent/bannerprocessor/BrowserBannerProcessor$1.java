package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BrowserBannerProcessor$1
  implements View.OnClickListener
{
  BrowserBannerProcessor$1(BrowserBannerProcessor paramBrowserBannerProcessor, Bundle paramBundle) {}
  
  public void onClick(View paramView)
  {
    BannerManager.a().a(34, 0, null);
    Object localObject1 = (String)this.jdField_a_of_type_AndroidOsBundle.getCharSequence("activity");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    try
    {
      localObject1 = Class.forName((String)localObject1);
      if (localObject1 != null)
      {
        localObject1 = new Intent(BrowserBannerProcessor.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBrowserBannerProcessor).getApplicationContext(), (Class)localObject1);
        String str = (String)this.jdField_a_of_type_AndroidOsBundle.getCharSequence("action");
        if (!TextUtils.isEmpty(str)) {
          ((Intent)localObject1).setAction(str);
        }
        str = (String)this.jdField_a_of_type_AndroidOsBundle.getCharSequence("category");
        if (!TextUtils.isEmpty(str)) {
          ((Intent)localObject1).addCategory(str);
        }
        ((Intent)localObject1).setFlags(this.jdField_a_of_type_AndroidOsBundle.getInt("flags", 0));
        BrowserBannerProcessor.b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBrowserBannerProcessor).startActivity((Intent)localObject1);
      }
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
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.BrowserBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */