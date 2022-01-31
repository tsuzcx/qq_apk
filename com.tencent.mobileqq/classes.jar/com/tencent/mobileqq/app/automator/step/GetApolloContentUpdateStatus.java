package com.tencent.mobileqq.app.automator.step;

import aifc;
import aifg;
import ailn;
import ajam;
import akgx;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import apdh;
import baot;
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
    aifg localaifg = (aifg)this.a.app.getManager(153);
    SharedPreferences localSharedPreferences = this.a.app.getApp().getSharedPreferences("mobileQQ", 0);
    long l = localSharedPreferences.getLong("last_pull_apollo_content_update_time", 0L);
    akgx localakgx = (akgx)this.a.app.a(115);
    if ((System.currentTimeMillis() - l > 21600000L) || (System.currentTimeMillis() < l)) {
      if (localakgx != null)
      {
        localakgx.a(null);
        localSharedPreferences.edit().putLong("last_pull_apollo_content_update_time", System.currentTimeMillis()).commit();
      }
    }
    for (;;)
    {
      aifc.b();
      ((aifc)this.a.app.getManager(211)).e();
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "get game list on login.");
      }
      if (localaifg.i()) {
        ((UsedAppListManager)this.a.app.getManager(288)).getUsedAppList();
      }
      ajam.a("login");
      aifg.a = this.a.app.getCurrentAccountUin();
      ailn.a(this.a.app);
      if (localaifg.b(this.a.app.getCurrentAccountUin())) {
        ((baot)this.a.app.a(71)).b();
      }
      return 7;
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "system time" + System.currentTimeMillis() + ",last update time:" + l);
      }
      if (aifg.a(this.a.app.getApp())) {
        localaifg.a(false, "login check file", 1);
      } else if (apdh.a(ApolloUtil.a)) {
        aifg.a(this.a.app);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetApolloContentUpdateStatus
 * JD-Core Version:    0.7.0.1
 */