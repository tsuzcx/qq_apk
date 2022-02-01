package com.tencent.mobileqq.apollo.process.chanel;

import anbz;
import anlu;
import com.tencent.qphone.base.util.QLog;

public class CmGameAvHandler$1
  implements Runnable
{
  public CmGameAvHandler$1(anbz paramanbz, String paramString, long paramLong, int paramInt) {}
  
  public void run()
  {
    anlu.a().b(anbz.a(this.this$0));
    anlu.a().b(this.jdField_a_of_type_JavaLangString);
    anlu.a().a(this.jdField_a_of_type_Long);
    anlu.a().a(0);
    anlu.a().b("" + this.jdField_a_of_type_Int, true, true);
    if (QLog.isColorLevel()) {
      QLog.d("CmGameAvHandler", 2, "avHandler enterRoom=" + this.jdField_a_of_type_Int);
    }
    anbz.a(this.this$0, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.1
 * JD-Core Version:    0.7.0.1
 */