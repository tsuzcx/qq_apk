package com.tencent.mobileqq.apollo.process.chanel;

import aksm;
import alce;
import com.tencent.qphone.base.util.QLog;

public class CmGameAvHandler$1
  implements Runnable
{
  public CmGameAvHandler$1(aksm paramaksm, String paramString, long paramLong, int paramInt) {}
  
  public void run()
  {
    alce.a().b(aksm.a(this.this$0));
    alce.a().b(this.jdField_a_of_type_JavaLangString);
    alce.a().a(this.jdField_a_of_type_Long);
    alce.a().a(0);
    alce.a().b("" + this.jdField_a_of_type_Int, true, true);
    if (QLog.isColorLevel()) {
      QLog.d("CmGameAvHandler", 2, "avHandler enterRoom=" + this.jdField_a_of_type_Int);
    }
    aksm.a(this.this$0, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.1
 * JD-Core Version:    0.7.0.1
 */