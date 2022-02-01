package com.tencent.mobileqq.app.automator.step;

import amst;
import amsx;
import amzf;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import anlk;
import anpq;
import apcx;
import auog;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.microapp.apkg.UsedAppListManager;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class GetApolloContentUpdateStatus
  extends AsyncStep
{
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "[GetApolloContentUpdateStatus]system time" + System.currentTimeMillis() + ",last update time:");
    }
    amsx localamsx = (amsx)this.a.app.getManager(153);
    SharedPreferences localSharedPreferences = this.a.app.getApp().getSharedPreferences("mobileQQ", 0);
    long l = localSharedPreferences.getLong("last_pull_apollo_content_update_time", 0L);
    if (anlk.a(this.a.app.c(), this.a.app) == 0)
    {
      ((VasExtensionHandler)this.a.app.a(71)).a(this.a.app.c(), 1073741824, "cmshow asyncStep");
      QLog.i("QQInitHandler", 1, "sava doStep cmshow asyncStep getUserApolloInfo RECOMMEND_ACTION");
    }
    apcx localapcx = (apcx)this.a.app.a(115);
    if ((System.currentTimeMillis() - l > 21600000L) || (System.currentTimeMillis() < l)) {
      if (localapcx != null)
      {
        localapcx.a(null);
        localSharedPreferences.edit().putLong("last_pull_apollo_content_update_time", System.currentTimeMillis()).commit();
      }
    }
    for (;;)
    {
      amst.b();
      ((amst)this.a.app.getManager(211)).e();
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "get game list on login.");
      }
      if (localamsx.j()) {
        ((UsedAppListManager)this.a.app.getManager(288)).getUsedAppList();
      }
      anpq.a("login");
      amsx.a = this.a.app.getCurrentAccountUin();
      amzf.a(this.a.app);
      if (localamsx.c(this.a.app.getCurrentAccountUin())) {
        ((VasExtensionHandler)this.a.app.a(71)).b();
      }
      if (amsx.a(this.a.app.getApp())) {
        localamsx.n();
      }
      return 7;
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "system time" + System.currentTimeMillis() + ",last update time:" + l);
      }
      if (amsx.b(this.a.app.getApp())) {
        localamsx.a(false, "login check file", 1);
      } else if (auog.a(ApolloUtil.a)) {
        amsx.a(this.a.app);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetApolloContentUpdateStatus
 * JD-Core Version:    0.7.0.1
 */