package com.tencent.mobileqq.app.automator;

import android.util.Log;
import aohg;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import ook;

public class InitBeforeSyncMsg
  extends AsyncStep
{
  protected int a()
  {
    long l1 = System.currentTimeMillis();
    Object localObject;
    if (this.b == 14)
    {
      this.a.app.initConfig(this.a.app.getCurrentAccountUin());
      this.a.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      this.a.app.getProxyManager().start();
      this.a.app.getCacheManager().init();
      localObject = (ook)this.a.app.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
      this.a.app.addObserver(((ook)localObject).a, true);
      localObject = this.a.app.getMsgHandler();
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
        this.a.app.getMsgHandler().a();
        this.a.app.getMsgHandler().c = false;
      }
      long l2 = System.currentTimeMillis();
      Log.i("AutoMonitor", "STEP_DOSOMETHING, cost=" + (l2 - l1));
      return 7;
      if (this.b != 15) {
        break;
      }
      this.a.app.getMsgHandler().e();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.InitBeforeSyncMsg
 * JD-Core Version:    0.7.0.1
 */