package com.tencent.mobileqq.app.automator;

import android.util.Log;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.asyncdb.CacheManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;

public class InitBeforeSyncMsg
  extends AsyncStep
{
  protected int doStep()
  {
    long l1 = System.currentTimeMillis();
    if (this.mStepId == 14)
    {
      this.mAutomator.k.initConfig(this.mAutomator.k.getCurrentAccountUin());
      this.mAutomator.k.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      this.mAutomator.k.getProxyManager().start();
      this.mAutomator.k.getCacheManager().init();
    }
    else if (this.mStepId == 15)
    {
      this.mAutomator.k.getMsgHandler().r();
    }
    Object localObject2 = (EcshopReportHandler)this.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
    Object localObject1 = this.mAutomator.k;
    localObject2 = ((EcshopReportHandler)localObject2).c;
    int i = 1;
    ((QQAppInterface)localObject1).addObserver((BusinessObserver)localObject2, true);
    localObject1 = this.mAutomator.k.getMsgHandler();
    if (this.mStepId == 15) {
      i = 2;
    }
    ((MessageHandler)localObject1).h(i);
    if (this.mStepId != 15)
    {
      this.mAutomator.k.getMsgHandler().m();
      this.mAutomator.k.getMsgHandler().e.m = false;
    }
    long l2 = System.currentTimeMillis();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("STEP_DOSOMETHING, cost=");
    ((StringBuilder)localObject1).append(l2 - l1);
    Log.i("AutoMonitor", ((StringBuilder)localObject1).toString());
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.InitBeforeSyncMsg
 * JD-Core Version:    0.7.0.1
 */