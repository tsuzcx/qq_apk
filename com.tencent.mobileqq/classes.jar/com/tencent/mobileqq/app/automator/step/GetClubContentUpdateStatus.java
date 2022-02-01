package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ClubContentUpdateHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.SonicTemplateUpdateManager;
import com.tencent.mobileqq.vas.VipGrayConfigHelper;
import com.tencent.mobileqq.vip.AioVipKeywordHelper;
import com.tencent.mobileqq.webview.WebViewTitleStyleHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class GetClubContentUpdateStatus
  extends AsyncStep
{
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "[GetClubContentUpdateStatus]system time" + System.currentTimeMillis() + ",last update time:");
    }
    ClubContentJsonTask.b(this.a.a);
    VipGrayConfigHelper.a().a(this.a.a);
    WebViewTitleStyleHelper.a().a(this.a.a);
    ClubContentJsonTask.a(this.a.a);
    SharedPreferences localSharedPreferences = this.a.a.getApp().getSharedPreferences("mobileQQ", 0);
    long l = localSharedPreferences.getLong("last_pull_club_content_update_time", 0L);
    if ((System.currentTimeMillis() - l > 43200000L) || (System.currentTimeMillis() < l))
    {
      ClubContentUpdateHandler localClubContentUpdateHandler = (ClubContentUpdateHandler)this.a.a.getBusinessHandler(BusinessHandlerFactory.CLUBCONTENTUPDATE_HANDLER);
      if (localClubContentUpdateHandler != null)
      {
        localClubContentUpdateHandler.a();
        localSharedPreferences.edit().putLong("last_pull_club_content_update_time", System.currentTimeMillis()).commit();
      }
    }
    for (;;)
    {
      AioVipKeywordHelper.a().a(this.a.a.getApplication(), this.a.a.getCurrentAccountUin());
      ((SonicTemplateUpdateManager)this.a.a.getManager(QQManagerFactory.SONIC_FILE_DISCARD_MANAGER)).a();
      return 7;
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "system time" + System.currentTimeMillis() + ",last update time:" + l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetClubContentUpdateStatus
 * JD-Core Version:    0.7.0.1
 */