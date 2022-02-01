package com.tencent.mobileqq.app.automator.step;

import alnn;
import alnr;
import altz;
import amge;
import amkk;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import anwk;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.filemanager.util.FileUtil;
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
    alnr localalnr = (alnr)this.a.app.getManager(153);
    SharedPreferences localSharedPreferences = this.a.app.getApp().getSharedPreferences("mobileQQ", 0);
    long l = localSharedPreferences.getLong("last_pull_apollo_content_update_time", 0L);
    if (amge.a(this.a.app.getCurrentUin(), this.a.app) == 0)
    {
      ((VasExtensionHandler)this.a.app.getBusinessHandler(71)).a(this.a.app.getCurrentUin(), 1073741824, "cmshow asyncStep");
      QLog.i("QQInitHandler", 1, "sava doStep cmshow asyncStep getUserApolloInfo RECOMMEND_ACTION");
    }
    anwk localanwk = (anwk)this.a.app.getBusinessHandler(115);
    if ((System.currentTimeMillis() - l > 21600000L) || (System.currentTimeMillis() < l)) {
      if (localanwk != null)
      {
        localanwk.a(null);
        localSharedPreferences.edit().putLong("last_pull_apollo_content_update_time", System.currentTimeMillis()).commit();
      }
    }
    for (;;)
    {
      alnn.b();
      ((alnn)this.a.app.getManager(211)).e();
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "get game list on login.");
      }
      if (localalnr.j()) {
        ((UsedAppListManager)this.a.app.getManager(288)).getUsedAppList();
      }
      amkk.a("login");
      alnr.a = this.a.app.getCurrentAccountUin();
      altz.a(this.a.app);
      if (localalnr.c(this.a.app.getCurrentAccountUin())) {
        ((VasExtensionHandler)this.a.app.getBusinessHandler(71)).b();
      }
      if (alnr.a(this.a.app.getApp())) {
        localalnr.n();
      }
      return 7;
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "system time" + System.currentTimeMillis() + ",last update time:" + l);
      }
      if (alnr.b(this.a.app.getApp())) {
        localalnr.a(false, "login check file", 1);
      } else if (FileUtil.isFileExists(ApolloUtil.a)) {
        alnr.a(this.a.app);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetApolloContentUpdateStatus
 * JD-Core Version:    0.7.0.1
 */