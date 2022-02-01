package com.tencent.mobileqq.apollo.process.chanel;

import anbd;
import anbz;
import anlu;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;

public class CmGameAvHandler$10
  implements Runnable
{
  public CmGameAvHandler$10(anbz paramanbz, String paramString, long paramLong) {}
  
  public void run()
  {
    anlu.a().b(this.jdField_a_of_type_JavaLangString);
    anbd.a().callbackFromRequest(this.jdField_a_of_type_Long, 0, "cs.audioRoom_change_qav_role.local", "{}");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.10
 * JD-Core Version:    0.7.0.1
 */