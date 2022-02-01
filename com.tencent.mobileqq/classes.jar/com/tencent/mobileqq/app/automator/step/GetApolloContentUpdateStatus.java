package com.tencent.mobileqq.app.automator.step;

import amgz;
import amhd;
import amnl;
import amzq;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import andw;
import aoph;
import atwl;
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
    amhd localamhd = (amhd)this.a.app.getManager(153);
    SharedPreferences localSharedPreferences = this.a.app.getApp().getSharedPreferences("mobileQQ", 0);
    long l = localSharedPreferences.getLong("last_pull_apollo_content_update_time", 0L);
    if (amzq.a(this.a.app.c(), this.a.app) == 0)
    {
      ((VasExtensionHandler)this.a.app.a(71)).a(this.a.app.c(), 1073741824, "cmshow asyncStep");
      QLog.i("QQInitHandler", 1, "sava doStep cmshow asyncStep getUserApolloInfo RECOMMEND_ACTION");
    }
    aoph localaoph = (aoph)this.a.app.a(115);
    if ((System.currentTimeMillis() - l > 21600000L) || (System.currentTimeMillis() < l)) {
      if (localaoph != null)
      {
        localaoph.a(null);
        localSharedPreferences.edit().putLong("last_pull_apollo_content_update_time", System.currentTimeMillis()).commit();
      }
    }
    for (;;)
    {
      amgz.b();
      ((amgz)this.a.app.getManager(211)).e();
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "get game list on login.");
      }
      if (localamhd.j()) {
        ((UsedAppListManager)this.a.app.getManager(288)).getUsedAppList();
      }
      andw.a("login");
      amhd.a = this.a.app.getCurrentAccountUin();
      amnl.a(this.a.app);
      if (localamhd.c(this.a.app.getCurrentAccountUin())) {
        ((VasExtensionHandler)this.a.app.a(71)).b();
      }
      if (amhd.a(this.a.app.getApp())) {
        localamhd.n();
      }
      return 7;
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "system time" + System.currentTimeMillis() + ",last update time:" + l);
      }
      if (amhd.b(this.a.app.getApp())) {
        localamhd.a(false, "login check file", 1);
      } else if (atwl.a(ApolloUtil.a)) {
        amhd.a(this.a.app);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetApolloContentUpdateStatus
 * JD-Core Version:    0.7.0.1
 */