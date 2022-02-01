package com.tencent.mobileqq.ark.vipreport;

import aqch;
import aqci;
import aqcj;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class ArkVipReporter$1
  implements Runnable
{
  public ArkVipReporter$1(String paramString, aqcj paramaqcj) {}
  
  public void run()
  {
    synchronized ()
    {
      aqch localaqch = (aqch)aqci.a().get(this.jdField_a_of_type_JavaLangString);
      if ((localaqch != null) && (Math.abs(System.currentTimeMillis() - localaqch.a) >= this.jdField_a_of_type_Aqcj.a))
      {
        QLog.i("ArkVipReporter", 1, "startSceneByEvent() find timeout scene and report:" + this.jdField_a_of_type_JavaLangString);
        aqci.a(this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.vipreport.ArkVipReporter.1
 * JD-Core Version:    0.7.0.1
 */