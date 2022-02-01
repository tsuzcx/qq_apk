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
  protected int doStep()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[GetClubContentUpdateStatus]system time");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      ((StringBuilder)localObject).append(",last update time:");
      QLog.d("QQInitHandler", 2, ((StringBuilder)localObject).toString());
    }
    ClubContentJsonTask.b(this.mAutomator.k);
    VipGrayConfigHelper.a().a(this.mAutomator.k);
    WebViewTitleStyleHelper.a().a(this.mAutomator.k);
    ClubContentJsonTask.a(this.mAutomator.k);
    Object localObject = this.mAutomator.k.getApp().getSharedPreferences("mobileQQ", 0);
    long l = ((SharedPreferences)localObject).getLong("last_pull_club_content_update_time", 0L);
    if ((System.currentTimeMillis() - l <= 43200000L) && (System.currentTimeMillis() >= l))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("system time");
        ((StringBuilder)localObject).append(System.currentTimeMillis());
        ((StringBuilder)localObject).append(",last update time:");
        ((StringBuilder)localObject).append(l);
        QLog.d("QQInitHandler", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      ClubContentUpdateHandler localClubContentUpdateHandler = (ClubContentUpdateHandler)this.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.CLUBCONTENTUPDATE_HANDLER);
      if (localClubContentUpdateHandler != null)
      {
        localClubContentUpdateHandler.a();
        ((SharedPreferences)localObject).edit().putLong("last_pull_club_content_update_time", System.currentTimeMillis()).commit();
      }
    }
    AioVipKeywordHelper.a().a(this.mAutomator.k.getApplication(), this.mAutomator.k.getCurrentAccountUin());
    ((SonicTemplateUpdateManager)this.mAutomator.k.getManager(QQManagerFactory.SONIC_FILE_DISCARD_MANAGER)).a();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetClubContentUpdateStatus
 * JD-Core Version:    0.7.0.1
 */