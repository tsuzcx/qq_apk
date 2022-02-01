package com.tencent.mobileqq.apollo.process.chanel;

import com.tencent.mobileqq.apollo.tmg_opensdk.AVEngineWalper;
import com.tencent.qphone.base.util.QLog;

class CmGameAvHandler$1
  implements Runnable
{
  CmGameAvHandler$1(CmGameAvHandler paramCmGameAvHandler, String paramString, long paramLong, int paramInt) {}
  
  public void run()
  {
    AVEngineWalper.a().b(CmGameAvHandler.a(this.this$0));
    AVEngineWalper.a().b(this.jdField_a_of_type_JavaLangString);
    AVEngineWalper.a().a(this.jdField_a_of_type_Long);
    AVEngineWalper.a().a(0);
    AVEngineWalper.a().b("" + this.jdField_a_of_type_Int, true, true);
    if (QLog.isColorLevel()) {
      QLog.d("CmGameAvHandler", 2, "avHandler enterRoom=" + this.jdField_a_of_type_Int);
    }
    CmGameAvHandler.a(this.this$0, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.1
 * JD-Core Version:    0.7.0.1
 */