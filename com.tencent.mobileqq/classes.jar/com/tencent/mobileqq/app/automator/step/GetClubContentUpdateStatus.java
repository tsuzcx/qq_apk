package com.tencent.mobileqq.app.automator.step;

import ampi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bgcw;
import bger;
import bgfr;
import bghc;
import bgny;
import com.tencent.mobileqq.app.QQAppInterface;
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
    Object localObject = (VasQuickUpdateManager)this.a.app.getManager(184);
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "[GetClubContentUpdateStatus]system time" + System.currentTimeMillis() + ",last update time:");
    }
    bgcw.b(this.a.app);
    bghc.a().a(this.a.app);
    WebViewTitleStyleHelper.getsInstance().parseJson(this.a.app);
    bgcw.a(this.a.app);
    localObject = this.a.app.getApp().getSharedPreferences("mobileQQ", 0);
    long l = ((SharedPreferences)localObject).getLong("last_pull_club_content_update_time", 0L);
    if ((System.currentTimeMillis() - l > 43200000L) || (System.currentTimeMillis() < l))
    {
      ampi localampi = (ampi)this.a.app.getBusinessHandler(16);
      if (localampi != null)
      {
        localampi.a();
        ((SharedPreferences)localObject).edit().putLong("last_pull_club_content_update_time", System.currentTimeMillis()).commit();
      }
    }
    for (;;)
    {
      bgny.a().a(this.a.app.getApplication(), this.a.app.getCurrentAccountUin());
      localObject = (bger)this.a.app.getManager(177);
      if (!((bger)localObject).b) {
        ((bger)localObject).a(this.a.app.getCurrentAccountUin());
      }
      ((bgfr)this.a.app.getManager(192)).a();
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