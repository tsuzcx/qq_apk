package com.tencent.mobileqq.apollo.api.impl;

import com.tencent.mobileqq.apollo.IApolloRunnableTask;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;

class ApolloCmdChannelImpl$8$1
  extends IApolloRunnableTask
{
  ApolloCmdChannelImpl$8$1(ApolloCmdChannelImpl.8 param8, String paramString) {}
  
  public String a()
  {
    return "getOpenApiNick";
  }
  
  public void run()
  {
    if ((CmGameUtil.a() != null) && (CmGameUtil.a().a())) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloCmdChannelImpl$8.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloCmdChannelImpl.nativeOpenApiGetNickCallBack(this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloCmdChannelImpl$8.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloCmdChannelImpl$8.jdField_a_of_type_JavaLangString, 0, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloCmdChannelImpl.8.1
 * JD-Core Version:    0.7.0.1
 */