package com.tencent.mobileqq.ark.vipreport;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ArkVipReporter$1
  implements Runnable
{
  ArkVipReporter$1(ArkVipReporter paramArkVipReporter, String paramString, ArkVipSceneConfig paramArkVipSceneConfig) {}
  
  public void run()
  {
    synchronized ()
    {
      Object localObject2 = (ArkVipReportScene)ArkVipReporter.a(this.this$0).get(this.a);
      if ((localObject2 != null) && (Math.abs(System.currentTimeMillis() - ((ArkVipReportScene)localObject2).h) >= this.b.d))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("startSceneByEvent() find timeout scene and report:");
        ((StringBuilder)localObject2).append(this.a);
        QLog.i("ArkVipReporter", 1, ((StringBuilder)localObject2).toString());
        this.this$0.b(this.a);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.vipreport.ArkVipReporter.1
 * JD-Core Version:    0.7.0.1
 */