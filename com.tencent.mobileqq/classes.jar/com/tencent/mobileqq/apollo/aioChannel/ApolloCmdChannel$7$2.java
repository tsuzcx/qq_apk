package com.tencent.mobileqq.apollo.aioChannel;

import aivp;
import ajae;
import ajch;
import com.tencent.mobileqq.apollo.IApolloRunnableTask;

public class ApolloCmdChannel$7$2
  extends IApolloRunnableTask
{
  public ApolloCmdChannel$7$2(aivp paramaivp, int paramInt) {}
  
  public String a()
  {
    return "getOpenApiHead";
  }
  
  public void run()
  {
    if ((ajae.a() != null) && (ajae.a().a())) {
      this.jdField_a_of_type_Aivp.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.nativeOpenApiGetHeadCallBack(this.jdField_a_of_type_Aivp.jdField_a_of_type_Long, this.jdField_a_of_type_Aivp.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 0, 0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel.7.2
 * JD-Core Version:    0.7.0.1
 */