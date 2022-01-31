package com.tencent.mobileqq.apollo.process.chanel;

import akwd;
import akxb;
import algt;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;

public class CmGameAvHandler$10
  implements Runnable
{
  public CmGameAvHandler$10(akxb paramakxb, String paramString, long paramLong) {}
  
  public void run()
  {
    algt.a().b(this.jdField_a_of_type_JavaLangString);
    akwd.a().callbackFromRequest(this.jdField_a_of_type_Long, 0, "cs.audioRoom_change_qav_role.local", "{}");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.10
 * JD-Core Version:    0.7.0.1
 */