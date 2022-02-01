package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import anrv;
import bhln;
import bhnl;
import bhom;
import bhpw;
import bhyi;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.webview.WebViewTitleStyleHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class GetClubContentUpdateStatus
  extends AsyncStep
{
  public int a()
  {
    Object localObject = (VasQuickUpdateManager)this.a.app.getManager(QQManagerFactory.VAS_QUICKUPDATE_MANAGER);
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "[GetClubContentUpdateStatus]system time" + System.currentTimeMillis() + ",last update time:");
    }
    bhln.b(this.a.app);
    bhpw.a().a(this.a.app);
    WebViewTitleStyleHelper.getsInstance().parseJson(this.a.app);
    bhln.a(this.a.app);
    localObject = this.a.app.getApp().getSharedPreferences("mobileQQ", 0);
    long l = ((SharedPreferences)localObject).getLong("last_pull_club_content_update_time", 0L);
    if ((System.currentTimeMillis() - l > 43200000L) || (System.currentTimeMillis() < l))
    {
      anrv localanrv = (anrv)this.a.app.getBusinessHandler(BusinessHandlerFactory.CLUBCONTENTUPDATE_HANDLER);
      if (localanrv != null)
      {
        localanrv.a();
        ((SharedPreferences)localObject).edit().putLong("last_pull_club_content_update_time", System.currentTimeMillis()).commit();
      }
    }
    for (;;)
    {
      bhyi.a().a(this.a.app.getApplication(), this.a.app.getCurrentAccountUin());
      localObject = (bhnl)this.a.app.getManager(QQManagerFactory.INDIVIDUATION_ABTEST_MANAGER);
      if (!((bhnl)localObject).b) {
        ((bhnl)localObject).a(this.a.app.getCurrentAccountUin());
      }
      ((bhom)this.a.app.getManager(QQManagerFactory.SONIC_FILE_DISCARD_MANAGER)).a();
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