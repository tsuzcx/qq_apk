package com.tencent.mobileqq.ark.vipreport;

import aqfs;
import aqft;
import aqfu;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class ArkVipReporter$1
  implements Runnable
{
  public ArkVipReporter$1(String paramString, aqfu paramaqfu) {}
  
  public void run()
  {
    synchronized ()
    {
      aqfs localaqfs = (aqfs)aqft.a().get(this.jdField_a_of_type_JavaLangString);
      if ((localaqfs != null) && (Math.abs(System.currentTimeMillis() - localaqfs.a) >= this.jdField_a_of_type_Aqfu.a))
      {
        QLog.i("ArkVipReporter", 1, "startSceneByEvent() find timeout scene and report:" + this.jdField_a_of_type_JavaLangString);
        aqft.a(this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.vipreport.ArkVipReporter.1
 * JD-Core Version:    0.7.0.1
 */