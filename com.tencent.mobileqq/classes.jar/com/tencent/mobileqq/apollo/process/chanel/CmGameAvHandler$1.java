package com.tencent.mobileqq.apollo.process.chanel;

import ajba;
import ajks;
import com.tencent.qphone.base.util.QLog;

public class CmGameAvHandler$1
  implements Runnable
{
  public CmGameAvHandler$1(ajba paramajba, String paramString, long paramLong, int paramInt) {}
  
  public void run()
  {
    ajks.a().b(ajba.a(this.this$0));
    ajks.a().b(this.jdField_a_of_type_JavaLangString);
    ajks.a().a(this.jdField_a_of_type_Long);
    ajks.a().a(0);
    ajks.a().b("" + this.jdField_a_of_type_Int, true, true);
    if (QLog.isColorLevel()) {
      QLog.d("CmGameAvHandler", 2, "avHandler enterRoom=" + this.jdField_a_of_type_Int);
    }
    ajba.a(this.this$0, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.1
 * JD-Core Version:    0.7.0.1
 */