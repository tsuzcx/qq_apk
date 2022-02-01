package com.tencent.mobileqq.apollo.process.chanel;

import com.tencent.mobileqq.apollo.api.IApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.tmg_opensdk.AVEngineWalper;

class CmGameAvHandler$10
  implements Runnable
{
  CmGameAvHandler$10(CmGameAvHandler paramCmGameAvHandler, String paramString, long paramLong) {}
  
  public void run()
  {
    AVEngineWalper.a().b(this.jdField_a_of_type_JavaLangString);
    CmGameUtil.a().callbackFromRequest(this.jdField_a_of_type_Long, 0, "cs.audioRoom_change_qav_role.local", "{}");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.10
 * JD-Core Version:    0.7.0.1
 */