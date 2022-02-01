package com.tencent.comic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class VipComicJumpActivity$LaunchCompletedObserver
  extends BroadcastReceiver
{
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  VipComicJumpActivity$LaunchCompletedObserver(VipComicJumpActivity paramVipComicJumpActivity) {}
  
  private void a(Intent paramIntent)
  {
    this.b = paramIntent.getStringExtra("pluginsdk_extraInfo");
    paramIntent = this.b;
    if ((paramIntent != null) && ("success".equals(paramIntent)))
    {
      paramIntent = this.jdField_a_of_type_ComTencentComicVipComicJumpActivity;
      paramIntent.enterComicReport644(paramIntent.mParam, 0);
    }
    else
    {
      paramIntent = this.jdField_a_of_type_ComTencentComicVipComicJumpActivity;
      paramIntent.enterComicReport644(paramIntent.mParam, -2);
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("LaunchCompletedObserver.onReceive mExtraInfo: ");
        paramIntent.append(this.b);
        QLog.d("VipComicJumpActivity", 2, paramIntent.toString());
      }
    }
    this.jdField_a_of_type_ComTencentComicVipComicJumpActivity.finish();
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "launch activity finish, leave jump activity.");
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("pluginsdk_pluginLocation");
    paramContext = paramIntent.getStringExtra("pluginsdk_launchReceiver");
    String str = paramIntent.getAction();
    if (((!TextUtils.isEmpty(str)) && ("com.tencent.mobileqq.PreLoadComicProcess".equals(str))) || ((paramContext != null) && (paramContext.equals("com.qqcomic.app.VipPreloadComicProcess"))))
    {
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("onReceive getExtras:");
        paramContext.append(paramIntent.getExtras());
        QLog.d("VipComicJumpActivity", 2, paramContext.toString());
      }
      VipComicJumpActivity.access$200(this.jdField_a_of_type_ComTencentComicVipComicJumpActivity, paramIntent);
      return;
    }
    paramContext = this.jdField_a_of_type_JavaLangString;
    if ((paramContext != null) && (paramContext.equalsIgnoreCase("comic_plugin.apk")))
    {
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("LaunchCompletedObserver.onReceive: ");
        paramContext.append(this.jdField_a_of_type_JavaLangString);
        QLog.d("VipComicJumpActivity", 2, paramContext.toString());
      }
      a(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.VipComicJumpActivity.LaunchCompletedObserver
 * JD-Core Version:    0.7.0.1
 */