package com.tencent.mobileqq.apollo.process.chanel;

import amqf;
import anaa;
import com.tencent.qphone.base.util.QLog;

public class CmGameAvHandler$1
  implements Runnable
{
  public CmGameAvHandler$1(amqf paramamqf, String paramString, long paramLong, int paramInt) {}
  
  public void run()
  {
    anaa.a().b(amqf.a(this.this$0));
    anaa.a().b(this.jdField_a_of_type_JavaLangString);
    anaa.a().a(this.jdField_a_of_type_Long);
    anaa.a().a(0);
    anaa.a().b("" + this.jdField_a_of_type_Int, true, true);
    if (QLog.isColorLevel()) {
      QLog.d("CmGameAvHandler", 2, "avHandler enterRoom=" + this.jdField_a_of_type_Int);
    }
    amqf.a(this.this$0, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.1
 * JD-Core Version:    0.7.0.1
 */