package com.tencent.mobileqq.app.proxy;

import amns;
import awgf;

public class DataLineMsgProxy$1
  implements Runnable
{
  public DataLineMsgProxy$1(amns paramamns, awgf paramawgf, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_Awgf.b("create index if not exists " + this.jdField_a_of_type_JavaLangString + "_index ON " + this.jdField_a_of_type_JavaLangString + "(groupId, msgId)");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.DataLineMsgProxy.1
 * JD-Core Version:    0.7.0.1
 */