package com.tencent.mobileqq.apollo.process.chanel;

import aing;
import aioe;
import aiws;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;

public class CmGameAvHandler$10
  implements Runnable
{
  public CmGameAvHandler$10(aioe paramaioe, String paramString, long paramLong) {}
  
  public void run()
  {
    aiws.a().b(this.jdField_a_of_type_JavaLangString);
    aing.a().callbackFromRequest(this.jdField_a_of_type_Long, 0, "cs.audioRoom_change_qav_role.local", "{}");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.10
 * JD-Core Version:    0.7.0.1
 */