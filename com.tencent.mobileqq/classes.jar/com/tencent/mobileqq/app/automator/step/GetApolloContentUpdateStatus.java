package com.tencent.mobileqq.app.automator.step;

import airt;
import airx;
import aiye;
import ajom;
import akvi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import apvd;
import bbrd;
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
    airx localairx = (airx)this.a.app.getManager(153);
    SharedPreferences localSharedPreferences = this.a.app.getApp().getSharedPreferences("mobileQQ", 0);
    long l = localSharedPreferences.getLong("last_pull_apollo_content_update_time", 0L);
    akvi localakvi = (akvi)this.a.app.a(115);
    if ((System.currentTimeMillis() - l > 21600000L) || (System.currentTimeMillis() < l)) {
      if (localakvi != null)
      {
        localakvi.a(null);
        localSharedPreferences.edit().putLong("last_pull_apollo_content_update_time", System.currentTimeMillis()).commit();
      }
    }
    for (;;)
    {
      airt.b();
      ((airt)this.a.app.getManager(211)).e();
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "get game list on login.");
      }
      if (localairx.j()) {
        ((UsedAppListManager)this.a.app.getManager(288)).getUsedAppList();
      }
      ajom.a("login");
      airx.a = this.a.app.getCurrentAccountUin();
      aiye.a(this.a.app);
      if (localairx.c(this.a.app.getCurrentAccountUin())) {
        ((bbrd)this.a.app.a(71)).b();
      }
      return 7;
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "system time" + System.currentTimeMillis() + ",last update time:" + l);
      }
      if (airx.a(this.a.app.getApp())) {
        localairx.a(false, "login check file", 1);
      } else if (apvd.a(ApolloUtil.a)) {
        airx.a(this.a.app);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetApolloContentUpdateStatus
 * JD-Core Version:    0.7.0.1
 */