package com.tencent.mobileqq.app.automator;

import android.util.Log;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.asyncdb.CacheManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;

public class InitBeforeSyncMsg
  extends AsyncStep
{
  protected int a()
  {
    long l1 = System.currentTimeMillis();
    Object localObject;
    if (this.b == 14)
    {
      this.a.a.initConfig(this.a.a.getCurrentAccountUin());
      this.a.a.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      this.a.a.getProxyManager().start();
      this.a.a.getCacheManager().init();
      localObject = (EcshopReportHandler)this.a.a.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
      this.a.a.addObserver(((EcshopReportHandler)localObject).a, true);
      localObject = this.a.a.getMsgHandler();
      if (this.b != 15) {
        break label234;
      }
    }
    label234:
    for (int i = 2;; i = 1)
    {
      ((MessageHandler)localObject).a(i);
      if (this.b != 15)
      {
        this.a.a.getMsgHandler().a();
        this.a.a.getMsgHandler().c = false;
      }
      long l2 = System.currentTimeMillis();
      Log.i("AutoMonitor", "STEP_DOSOMETHING, cost=" + (l2 - l1));
      return 7;
      if (this.b != 15) {
        break;
      }
      this.a.a.getMsgHandler().e();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.InitBeforeSyncMsg
 * JD-Core Version:    0.7.0.1
 */