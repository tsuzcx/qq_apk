package com.tencent.mobileqq.apollo.process.chanel;

import alwt;
import amgo;
import com.tencent.qphone.base.util.QLog;

public class CmGameAvHandler$1
  implements Runnable
{
  public CmGameAvHandler$1(alwt paramalwt, String paramString, long paramLong, int paramInt) {}
  
  public void run()
  {
    amgo.a().b(alwt.a(this.this$0));
    amgo.a().b(this.jdField_a_of_type_JavaLangString);
    amgo.a().a(this.jdField_a_of_type_Long);
    amgo.a().a(0);
    amgo.a().b("" + this.jdField_a_of_type_Int, true, true);
    if (QLog.isColorLevel()) {
      QLog.d("CmGameAvHandler", 2, "avHandler enterRoom=" + this.jdField_a_of_type_Int);
    }
    alwt.a(this.this$0, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.1
 * JD-Core Version:    0.7.0.1
 */