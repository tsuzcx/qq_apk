package com.tencent.mobileqq.app.automator.step;

import amma;
import amme;
import amta;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import anhm;
import anmb;
import aozm;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
    amme localamme = (amme)this.a.app.getManager(QQManagerFactory.APOLLO_MANAGER);
    SharedPreferences localSharedPreferences = this.a.app.getApp().getSharedPreferences("mobileQQ", 0);
    long l = localSharedPreferences.getLong("last_pull_apollo_content_update_time", 0L);
    if (anhm.a(this.a.app.getCurrentUin(), this.a.app) == 0)
    {
      ((VasExtensionHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER)).a(this.a.app.getCurrentUin(), 1073741824, "cmshow asyncStep");
      QLog.i("QQInitHandler", 1, "sava doStep cmshow asyncStep getUserApolloInfo RECOMMEND_ACTION");
    }
    aozm localaozm = (aozm)this.a.app.getBusinessHandler(BusinessHandlerFactory.APOLLO_CONTENT_UPDATE_HANDLER);
    if ((System.currentTimeMillis() - l > 21600000L) || (System.currentTimeMillis() < l)) {
      if (localaozm != null)
      {
        localaozm.a(null);
        localSharedPreferences.edit().putLong("last_pull_apollo_content_update_time", System.currentTimeMillis()).commit();
      }
    }
    for (;;)
    {
      amma.b();
      ((amma)this.a.app.getManager(QQManagerFactory.APOLLO_GAME_MANAGER)).e();
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "get game list on login.");
      }
      if (localamme.j()) {
        ((UsedAppListManager)this.a.app.getManager(QQManagerFactory.USED_APP_LIST_MANAGER)).getUsedAppList();
      }
      anmb.a("login");
      amme.a = this.a.app.getCurrentAccountUin();
      amta.a(this.a.app);
      if (localamme.c(this.a.app.getCurrentAccountUin())) {
        ((VasExtensionHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER)).b();
      }
      if (amme.a(this.a.app.getApp())) {
        localamme.n();
      }
      return 7;
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "system time" + System.currentTimeMillis() + ",last update time:" + l);
      }
      if (amme.b(this.a.app.getApp())) {
        localamme.a(false, "login check file", 1);
      } else if (FileUtil.isFileExists("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/action_v730.json")) {
        amme.a(this.a.app);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetApolloContentUpdateStatus
 * JD-Core Version:    0.7.0.1
 */