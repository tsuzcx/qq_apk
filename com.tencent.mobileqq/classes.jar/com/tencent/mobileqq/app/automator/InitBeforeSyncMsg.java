package com.tencent.mobileqq.app.automator;

import android.util.Log;
import anyv;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import odu;

public class InitBeforeSyncMsg
  extends AsyncStep
{
  protected int a()
  {
    long l1 = System.currentTimeMillis();
    Object localObject;
    if (this.b == 14)
    {
      this.a.app.a(this.a.app.getCurrentAccountUin());
      this.a.app.getManager(60);
      this.a.app.a().start();
      this.a.app.a().init();
      localObject = (odu)this.a.app.a(88);
      this.a.app.addObserver(((odu)localObject).a, true);
      localObject = this.a.app.a();
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
        this.a.app.a().a();
        this.a.app.a().c = false;
      }
      long l2 = System.currentTimeMillis();
      Log.i("AutoMonitor", "STEP_DOSOMETHING, cost=" + (l2 - l1));
      return 7;
      if (this.b != 15) {
        break;
      }
      this.a.app.a().e();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.InitBeforeSyncMsg
 * JD-Core Version:    0.7.0.1
 */