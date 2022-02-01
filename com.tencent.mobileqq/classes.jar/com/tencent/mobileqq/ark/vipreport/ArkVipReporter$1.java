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
      Object localObject2 = (ArkVipReportScene)ArkVipReporter.a(this.this$0).get(this.jdField_a_of_type_JavaLangString);
      if ((localObject2 != null) && (Math.abs(System.currentTimeMillis() - ((ArkVipReportScene)localObject2).a) >= this.jdField_a_of_type_ComTencentMobileqqArkVipreportArkVipSceneConfig.a))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("startSceneByEvent() find timeout scene and report:");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
        QLog.i("ArkVipReporter", 1, ((StringBuilder)localObject2).toString());
        this.this$0.a(this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.vipreport.ArkVipReporter.1
 * JD-Core Version:    0.7.0.1
 */