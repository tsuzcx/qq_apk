package com.tencent.mobileqq.app.proxy;

import com.tencent.mobileqq.persistence.EntityManager;

class DataLineMsgProxy$1
  implements Runnable
{
  DataLineMsgProxy$1(DataLineMsgProxy paramDataLineMsgProxy, EntityManager paramEntityManager, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.execSQL("create index if not exists " + this.jdField_a_of_type_JavaLangString + "_index ON " + this.jdField_a_of_type_JavaLangString + "(groupId, msgId)");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.DataLineMsgProxy.1
 * JD-Core Version:    0.7.0.1
 */