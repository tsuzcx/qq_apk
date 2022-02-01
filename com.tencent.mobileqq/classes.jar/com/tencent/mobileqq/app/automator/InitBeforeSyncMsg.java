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
      this.mAutomator.a.initConfig(this.mAutomator.a.getCurrentAccountUin());
      this.mAutomator.a.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      this.mAutomator.a.getProxyManager().start();
      this.mAutomator.a.getCacheManager().init();
    }
    else if (this.mStepId == 15)
    {
      this.mAutomator.a.getMsgHandler().m();
    }
    Object localObject2 = (EcshopReportHandler)this.mAutomator.a.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
    Object localObject1 = this.mAutomator.a;
    localObject2 = ((EcshopReportHandler)localObject2).a;
    int i = 1;
    ((QQAppInterface)localObject1).addObserver((BusinessObserver)localObject2, true);
    localObject1 = this.mAutomator.a.getMsgHandler();
    if (this.mStepId == 15) {
      i = 2;
    }
    ((MessageHandler)localObject1).c(i);
    if (this.mStepId != 15)
    {
      this.mAutomator.a.getMsgHandler().h();
      this.mAutomator.a.getMsgHandler().a.d = false;
    }
    long l2 = System.currentTimeMillis();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("STEP_DOSOMETHING, cost=");
    ((StringBuilder)localObject1).append(l2 - l1);
    Log.i("AutoMonitor", ((StringBuilder)localObject1).toString());
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.InitBeforeSyncMsg
 * JD-Core Version:    0.7.0.1
 */