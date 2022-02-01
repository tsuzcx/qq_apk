package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;

class AboutActivity$7
  extends ConfigObserver
{
  AboutActivity$7(AboutActivity paramAboutActivity) {}
  
  protected void a(boolean paramBoolean, UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    AboutActivity.a(this.a, paramUpgradeDetailWrapper);
    paramUpgradeDetailWrapper = this.a.app.getAboutConfig();
    AboutActivity.a(this.a, paramUpgradeDetailWrapper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AboutActivity.7
 * JD-Core Version:    0.7.0.1
 */