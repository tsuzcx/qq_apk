package com.tencent.mobileqq.apollo.api.impl;

import com.tencent.mobileqq.apollo.aioChannel.ApolloRenderRunner;
import com.tencent.mobileqq.apollo.api.render.IRenderRunner;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;

class ApolloCmdChannelImpl$8
  implements ApolloCmdChannelImpl.openApiNickCallback
{
  ApolloCmdChannelImpl$8(ApolloCmdChannelImpl paramApolloCmdChannelImpl, long paramLong, String paramString) {}
  
  public void a(String paramString)
  {
    if ((CmGameUtil.a() != null) && (ApolloCmdChannelImpl.access$400(this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloCmdChannelImpl) != null) && (ApolloCmdChannelImpl.access$400(this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloCmdChannelImpl).a(CmGameUtil.a().a()) != null)) {
      ApolloCmdChannelImpl.access$400(this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloCmdChannelImpl).a(CmGameUtil.a().a()).runRenderTask(new ApolloCmdChannelImpl.8.1(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloCmdChannelImpl.8
 * JD-Core Version:    0.7.0.1
 */