package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.grayversion.ShareAppLogActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AboutActivity$2
  implements View.OnClickListener
{
  AboutActivity$2(AboutActivity paramAboutActivity) {}
  
  public void onClick(View paramView)
  {
    AboutActivity localAboutActivity = this.a;
    localAboutActivity.startActivity(ShareAppLogActivity.buildIntent(localAboutActivity));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AboutActivity.2
 * JD-Core Version:    0.7.0.1
 */