package com.tencent.biz.pubaccount.readinjoy.common;

import bkwm;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import pay;

public final class ReadInJoyUtils$3
  implements Runnable
{
  public ReadInJoyUtils$3(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if ((this.a == null) || (!this.a.isLogin())) {
      return;
    }
    if (NetworkUtil.isWifiEnabled(this.a.getApp()))
    {
      pay.e(this.a);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "handConversationToShow is wifi");
      }
    }
    if (!bkwm.E(this.a))
    {
      pay.b(this.a);
      bkwm.f(this.a);
    }
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.a.getManager(162);
    if (bkwm.z(this.a))
    {
      bkwm.n(this.a, false);
      if (localKandianMergeManager != null) {
        localKandianMergeManager.k();
      }
    }
    for (;;)
    {
      ((KandianSubscribeManager)this.a.getManager(280)).a();
      ((KandianDailyManager)this.a.getManager(296)).a();
      return;
      if (localKandianMergeManager != null) {
        localKandianMergeManager.j();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.3
 * JD-Core Version:    0.7.0.1
 */