package com.tencent.mobileqq.apollo.api.web.impl;

import com.tencent.mobileqq.apollo.IAvatarInterface;

class ApolloJsPluginImpl$4
  implements IAvatarInterface
{
  ApolloJsPluginImpl$4(ApolloJsPluginImpl paramApolloJsPluginImpl, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl.callbackOk(this.jdField_a_of_type_JavaLangString, 0, "set avatar succeed");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl.callbackError(this.jdField_a_of_type_JavaLangString, "set avatar fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.web.impl.ApolloJsPluginImpl.4
 * JD-Core Version:    0.7.0.1
 */