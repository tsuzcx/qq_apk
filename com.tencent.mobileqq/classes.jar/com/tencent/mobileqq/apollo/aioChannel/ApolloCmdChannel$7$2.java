package com.tencent.mobileqq.apollo.aioChannel;

import aivn;
import ajac;
import ajcf;
import com.tencent.mobileqq.apollo.IApolloRunnableTask;

public class ApolloCmdChannel$7$2
  extends IApolloRunnableTask
{
  public ApolloCmdChannel$7$2(aivn paramaivn, int paramInt) {}
  
  public String a()
  {
    return "getOpenApiHead";
  }
  
  public void run()
  {
    if ((ajac.a() != null) && (ajac.a().a())) {
      this.jdField_a_of_type_Aivn.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.nativeOpenApiGetHeadCallBack(this.jdField_a_of_type_Aivn.jdField_a_of_type_Long, this.jdField_a_of_type_Aivn.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 0, 0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel.7.2
 * JD-Core Version:    0.7.0.1
 */