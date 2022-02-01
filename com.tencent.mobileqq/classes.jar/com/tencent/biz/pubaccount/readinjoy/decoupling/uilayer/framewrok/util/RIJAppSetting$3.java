package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util;

import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJUserDeviceInfoReport;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;

final class RIJAppSetting$3
  implements Runnable
{
  RIJAppSetting$3(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if ((this.a == null) || (!this.a.isLogin())) {
      return;
    }
    if (NetworkUtil.a(this.a.getApp()))
    {
      RIJAppSetting.b(this.a);
      if (QLog.isColorLevel()) {
        QLog.d("RIJAppSetting", 2, "handConversationToShow is wifi");
      }
    }
    if (!ReadInJoyHelper.E(this.a))
    {
      RIJUserDeviceInfoReport.a(this.a);
      ReadInJoyHelper.f(this.a);
    }
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.a.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    if (ReadInJoyHelper.A(this.a))
    {
      ReadInJoyHelper.o(this.a, false);
      if (localKandianMergeManager != null) {
        localKandianMergeManager.k();
      }
    }
    for (;;)
    {
      ((KandianSubscribeManager)this.a.getManager(QQManagerFactory.KANDIAN_SUBSCRIBE_MANAGER)).a();
      ((KandianDailyManager)this.a.getManager(QQManagerFactory.KANDIAN_DAILY_MANAGER)).a();
      return;
      if (localKandianMergeManager != null) {
        localKandianMergeManager.j();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting.3
 * JD-Core Version:    0.7.0.1
 */