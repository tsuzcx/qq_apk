package com.tencent.mobileqq.activity;

import abai;
import abbb;
import aseo;
import asfl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;

public class Leba$5$1
  implements Runnable
{
  Leba$5$1(Leba.5 param5) {}
  
  public void run()
  {
    WebProcessManager localWebProcessManager = (WebProcessManager)this.a.this$0.a.getManager(13);
    if ((localWebProcessManager != null) && (localWebProcessManager.d())) {
      localWebProcessManager.a(202, new abbb(this));
    }
    this.a.this$0.n();
    if (asfl.b()) {
      asfl.a("Q.lebatab.", new Object[] { "preload nearby process/tool process" });
    }
    aseo.a(this.a.this$0.a.getAccount(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.5.1
 * JD-Core Version:    0.7.0.1
 */