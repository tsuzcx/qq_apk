package com.tencent.mobileqq.activity;

import adgl;
import auwc;
import auwz;
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
      localWebProcessManager.a(202, new adgl(this));
    }
    this.a.this$0.n();
    if (auwz.b()) {
      auwz.a("Q.lebatab.", new Object[] { "preload nearby process/tool process" });
    }
    auwc.a(this.a.this$0.a.getAccount(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.5.1
 * JD-Core Version:    0.7.0.1
 */