package com.tencent.av.business.manager.pendant;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import lhy;
import nwp;

public class EffectPendantBase$1
  implements Runnable
{
  public EffectPendantBase$1(lhy paramlhy, File paramFile, String paramString) {}
  
  public void run()
  {
    try
    {
      nwp.a(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i(this.this$0.jdField_a_of_type_JavaLangString, 2, "isTemplateUsable unzip error", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.EffectPendantBase.1
 * JD-Core Version:    0.7.0.1
 */