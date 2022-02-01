package com.tencent.av.business.manager.pendant;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import lhr;
import npo;

public class EffectPendantTools$1
  implements Runnable
{
  public EffectPendantTools$1(lhr paramlhr, File paramFile, PendantItem paramPendantItem) {}
  
  public void run()
  {
    try
    {
      npo.a(this.jdField_a_of_type_JavaIoFile, this.this$0.b(this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.EffectPendantTools.1
 * JD-Core Version:    0.7.0.1
 */