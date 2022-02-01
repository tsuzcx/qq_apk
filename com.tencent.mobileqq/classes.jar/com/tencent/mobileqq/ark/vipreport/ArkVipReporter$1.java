package com.tencent.mobileqq.ark.vipreport;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class ArkVipReporter$1
  implements Runnable
{
  ArkVipReporter$1(String paramString, ArkVipSceneConfig paramArkVipSceneConfig) {}
  
  public void run()
  {
    synchronized ()
    {
      ArkVipReportScene localArkVipReportScene = (ArkVipReportScene)ArkVipReporter.a().get(this.jdField_a_of_type_JavaLangString);
      if ((localArkVipReportScene != null) && (Math.abs(System.currentTimeMillis() - localArkVipReportScene.a) >= this.jdField_a_of_type_ComTencentMobileqqArkVipreportArkVipSceneConfig.a))
      {
        QLog.i("ArkVipReporter", 1, "startSceneByEvent() find timeout scene and report:" + this.jdField_a_of_type_JavaLangString);
        ArkVipReporter.a(this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.vipreport.ArkVipReporter.1
 * JD-Core Version:    0.7.0.1
 */