package com.tencent.biz.pubaccount.readinjoy.common;

import badq;
import bgmq;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import obz;

public final class ReadInJoyUtils$3
  implements Runnable
{
  public ReadInJoyUtils$3(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if ((this.a == null) || (!this.a.isLogin())) {
      return;
    }
    if (badq.a(this.a.getApp()))
    {
      obz.e(this.a);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "handConversationToShow is wifi");
      }
    }
    if (!bgmq.A(this.a))
    {
      obz.b(this.a);
      bgmq.f(this.a);
    }
    if (bgmq.v(this.a))
    {
      bgmq.m(this.a, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.3
 * JD-Core Version:    0.7.0.1
 */