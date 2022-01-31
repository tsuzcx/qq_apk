package com.tencent.mobileqq.ark.vipreport;

import anno;
import annp;
import annq;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class ArkVipReporter$1
  implements Runnable
{
  public ArkVipReporter$1(String paramString, annq paramannq) {}
  
  public void run()
  {
    synchronized ()
    {
      anno localanno = (anno)annp.a().get(this.jdField_a_of_type_JavaLangString);
      if ((localanno != null) && (Math.abs(System.currentTimeMillis() - localanno.a) >= this.jdField_a_of_type_Annq.a))
      {
        QLog.i("ArkVipReporter", 1, "startSceneByEvent() find timeout scene and report:" + this.jdField_a_of_type_JavaLangString);
        annp.a(this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.vipreport.ArkVipReporter.1
 * JD-Core Version:    0.7.0.1
 */