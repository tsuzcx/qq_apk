package com.tencent.mobileqq.apollo.process.chanel;

import akxb;
import algt;
import com.tencent.qphone.base.util.QLog;

public class CmGameAvHandler$1
  implements Runnable
{
  public CmGameAvHandler$1(akxb paramakxb, String paramString, long paramLong, int paramInt) {}
  
  public void run()
  {
    algt.a().b(akxb.a(this.this$0));
    algt.a().b(this.jdField_a_of_type_JavaLangString);
    algt.a().a(this.jdField_a_of_type_Long);
    algt.a().a(0);
    algt.a().b("" + this.jdField_a_of_type_Int, true, true);
    if (QLog.isColorLevel()) {
      QLog.d("CmGameAvHandler", 2, "avHandler enterRoom=" + this.jdField_a_of_type_Int);
    }
    akxb.a(this.this$0, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.1
 * JD-Core Version:    0.7.0.1
 */