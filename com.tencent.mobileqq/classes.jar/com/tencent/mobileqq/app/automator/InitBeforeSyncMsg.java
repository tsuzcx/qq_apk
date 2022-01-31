package com.tencent.mobileqq.app.automator;

import android.util.Log;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
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
      this.a.b.a(this.a.b.getCurrentAccountUin());
      this.a.b.getManager(59);
      this.a.b.a().b();
      this.a.b.a().a();
      localObject = (EcshopReportHandler)this.a.b.a(88);
      this.a.b.addObserver(((EcshopReportHandler)localObject).a, true);
      localObject = this.a.b.a();
      if (this.b != 15) {
        break label232;
      }
    }
    label232:
    for (int i = 2;; i = 1)
    {
      ((MessageHandler)localObject).a(i);
      if (this.b != 15)
      {
        this.a.b.a().b();
        this.a.b.a().c = false;
      }
      long l2 = System.currentTimeMillis();
      Log.i("AutoMonitor", "STEP_DOSOMETHING, cost=" + (l2 - l1));
      return 7;
      if (this.b != 15) {
        break;
      }
      this.a.b.a().f();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.InitBeforeSyncMsg
 * JD-Core Version:    0.7.0.1
 */