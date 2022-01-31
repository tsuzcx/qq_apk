package com.tencent.mobileqq.ark;

import alth;
import amqk;
import amqp;
import amqq;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class ArkAppPreDownloadMgr$1
  implements Runnable
{
  public ArkAppPreDownloadMgr$1(alth paramalth) {}
  
  public void run()
  {
    amqp localamqp = amqq.b(380).a();
    if ((localamqp == null) && (QLog.isColorLevel())) {
      QLog.e("ArkApp.ArkAppPreDownloadMgr", 2, "profiling get preload config from default");
    }
    alth.a(this.this$0).clear();
    this.this$0.a(localamqp);
    alth.a(this.this$0);
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppPreDownloadMgr.1
 * JD-Core Version:    0.7.0.1
 */