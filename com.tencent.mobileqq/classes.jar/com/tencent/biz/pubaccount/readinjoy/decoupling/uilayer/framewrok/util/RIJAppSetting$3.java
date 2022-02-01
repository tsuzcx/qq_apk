package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util;

import bmhv;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import pqh;
import pqu;

public final class RIJAppSetting$3
  implements Runnable
{
  public RIJAppSetting$3(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if ((this.a == null) || (!this.a.isLogin())) {
      return;
    }
    if (NetworkUtil.isWifiEnabled(this.a.getApp()))
    {
      pqu.b(this.a);
      if (QLog.isColorLevel()) {
        QLog.d("RIJAppSetting", 2, "handConversationToShow is wifi");
      }
    }
    if (!bmhv.E(this.a))
    {
      pqh.a(this.a);
      bmhv.f(this.a);
    }
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.a.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    if (bmhv.z(this.a))
    {
      bmhv.n(this.a, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting.3
 * JD-Core Version:    0.7.0.1
 */