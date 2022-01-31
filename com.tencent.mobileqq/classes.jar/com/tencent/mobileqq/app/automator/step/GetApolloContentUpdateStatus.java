package com.tencent.mobileqq.app.automator.step;

import akje;
import akji;
import akpq;
import alfz;
import amly;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import arof;
import bdpx;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.microapp.apkg.UsedAppListManager;
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
    akji localakji = (akji)this.a.app.getManager(153);
    SharedPreferences localSharedPreferences = this.a.app.getApp().getSharedPreferences("mobileQQ", 0);
    long l = localSharedPreferences.getLong("last_pull_apollo_content_update_time", 0L);
    amly localamly = (amly)this.a.app.a(115);
    if ((System.currentTimeMillis() - l > 21600000L) || (System.currentTimeMillis() < l)) {
      if (localamly != null)
      {
        localamly.a(null);
        localSharedPreferences.edit().putLong("last_pull_apollo_content_update_time", System.currentTimeMillis()).commit();
      }
    }
    for (;;)
    {
      akje.b();
      ((akje)this.a.app.getManager(211)).e();
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "get game list on login.");
      }
      if (localakji.j()) {
        ((UsedAppListManager)this.a.app.getManager(288)).getUsedAppList();
      }
      alfz.a("login");
      akji.a = this.a.app.getCurrentAccountUin();
      akpq.a(this.a.app);
      if (localakji.c(this.a.app.getCurrentAccountUin())) {
        ((bdpx)this.a.app.a(71)).b();
      }
      if (akji.a(this.a.app.getApp())) {
        localakji.n();
      }
      return 7;
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "system time" + System.currentTimeMillis() + ",last update time:" + l);
      }
      if (akji.a(this.a.app.getApp())) {
        localakji.a(false, "login check file", 1);
      } else if (arof.a(ApolloUtil.a)) {
        akji.a(this.a.app);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetApolloContentUpdateStatus
 * JD-Core Version:    0.7.0.1
 */