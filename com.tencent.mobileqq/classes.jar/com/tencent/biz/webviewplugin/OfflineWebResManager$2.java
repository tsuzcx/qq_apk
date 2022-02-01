package com.tencent.biz.webviewplugin;

import com.tencent.mobileqq.data.OfflineWebRes;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

class OfflineWebResManager$2
  implements Runnable
{
  OfflineWebResManager$2(OfflineWebResManager paramOfflineWebResManager, int paramInt) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(this.a * 1000);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    Object localObject;
    if (!OfflineWebResManager.e)
    {
      OfflineWebResManager.c();
      if (!OfflineWebResManager.f)
      {
        this.this$0.b.drop(OfflineWebRes.class.getSimpleName());
        return;
      }
      OfflineWebResManager.e = this.this$0.b.tabbleIsExist(OfflineWebRes.class.getSimpleName());
      if (!OfflineWebResManager.e)
      {
        localObject = new OfflineWebRes();
        ((OfflineWebRes)localObject).fileName = "test";
        ((OfflineWebRes)localObject).hashName = "test";
        ((OfflineWebRes)localObject).md5 = "test_md5";
        this.this$0.b.persist((Entity)localObject);
      }
    }
    while (!OfflineWebResManager.c.isEmpty())
    {
      localObject = (String)OfflineWebResManager.c.poll();
      this.this$0.c((String)localObject);
    }
    this.this$0.a();
    this.this$0.g.set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflineWebResManager.2
 * JD-Core Version:    0.7.0.1
 */