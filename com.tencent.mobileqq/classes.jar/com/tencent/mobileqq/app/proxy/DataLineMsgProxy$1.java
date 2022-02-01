package com.tencent.mobileqq.app.proxy;

import aonc;
import com.tencent.mobileqq.persistence.EntityManager;

public class DataLineMsgProxy$1
  implements Runnable
{
  public DataLineMsgProxy$1(aonc paramaonc, EntityManager paramEntityManager, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.execSQL("create index if not exists " + this.jdField_a_of_type_JavaLangString + "_index ON " + this.jdField_a_of_type_JavaLangString + "(groupId, msgId)");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.DataLineMsgProxy.1
 * JD-Core Version:    0.7.0.1
 */