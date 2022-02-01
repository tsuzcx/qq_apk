package com.tencent.mobileqq.apollo.api.impl;

import com.tencent.mobileqq.apollo.IApolloRunnableTask;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;

class ApolloCmdChannelImpl$7$2
  extends IApolloRunnableTask
{
  ApolloCmdChannelImpl$7$2(ApolloCmdChannelImpl.7 param7, int paramInt) {}
  
  public String a()
  {
    return "getOpenApiHead";
  }
  
  public void run()
  {
    if ((CmGameUtil.a() != null) && (CmGameUtil.a().a())) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloCmdChannelImpl$7.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloCmdChannelImpl.nativeOpenApiGetHeadCallBack(this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloCmdChannelImpl$7.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloCmdChannelImpl$7.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 0, 0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloCmdChannelImpl.7.2
 * JD-Core Version:    0.7.0.1
 */