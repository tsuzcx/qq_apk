package com.tencent.mobileqq.ark.vipreport;

import anrx;
import anry;
import anrz;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class ArkVipReporter$1
  implements Runnable
{
  public ArkVipReporter$1(String paramString, anrz paramanrz) {}
  
  public void run()
  {
    synchronized ()
    {
      anrx localanrx = (anrx)anry.a().get(this.jdField_a_of_type_JavaLangString);
      if ((localanrx != null) && (Math.abs(System.currentTimeMillis() - localanrx.a) >= this.jdField_a_of_type_Anrz.a))
      {
        QLog.i("ArkVipReporter", 1, "startSceneByEvent() find timeout scene and report:" + this.jdField_a_of_type_JavaLangString);
        anry.a(this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.vipreport.ArkVipReporter.1
 * JD-Core Version:    0.7.0.1
 */