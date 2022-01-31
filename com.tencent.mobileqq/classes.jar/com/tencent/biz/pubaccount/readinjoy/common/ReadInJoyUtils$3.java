package com.tencent.biz.pubaccount.readinjoy.common;

import bdin;
import bkbq;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import ors;

public final class ReadInJoyUtils$3
  implements Runnable
{
  public ReadInJoyUtils$3(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if ((this.a == null) || (!this.a.isLogin())) {
      return;
    }
    if (bdin.a(this.a.getApp()))
    {
      ors.e(this.a);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "handConversationToShow is wifi");
      }
    }
    if (!bkbq.C(this.a))
    {
      ors.b(this.a);
      bkbq.f(this.a);
    }
    if (bkbq.x(this.a))
    {
      bkbq.m(this.a, false);
      ((KandianMergeManager)this.a.getManager(162)).j();
    }
    for (;;)
    {
      ((KandianSubscribeManager)this.a.getManager(280)).a();
      ((KandianDailyManager)this.a.getManager(296)).a();
      return;
      ((KandianMergeManager)this.a.getManager(162)).i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.3
 * JD-Core Version:    0.7.0.1
 */