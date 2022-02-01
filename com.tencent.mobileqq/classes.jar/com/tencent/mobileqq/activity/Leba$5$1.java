package com.tencent.mobileqq.activity;

import aegi;
import axpo;
import axql;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.webprocess.WebProcessManager;

public class Leba$5$1
  implements Runnable
{
  Leba$5$1(Leba.5 param5) {}
  
  public void run()
  {
    WebProcessManager localWebProcessManager = (WebProcessManager)this.a.this$0.a.getManager(QQManagerFactory.WEBPROCESS_MANAGER);
    if ((localWebProcessManager != null) && (localWebProcessManager.d())) {
      localWebProcessManager.a(202, new aegi(this));
    }
    this.a.this$0.l();
    if (axql.b()) {
      axql.a("Q.lebatab.", new Object[] { "preload nearby process/tool process" });
    }
    axpo.a(this.a.this$0.a.getAccount(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.5.1
 * JD-Core Version:    0.7.0.1
 */