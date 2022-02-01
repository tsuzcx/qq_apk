package com.tencent.mobileqq.apollo.res.api.impl;

import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.cmshow.engine.util.CMGetResPathUtil;
import com.tencent.mobileqq.utils.FileUtils;

class ApolloResManagerImpl$10$1
  implements Runnable
{
  ApolloResManagerImpl$10$1(ApolloResManagerImpl.10 param10, ApolloActionData paramApolloActionData) {}
  
  public void run()
  {
    if (ApolloResManagerImpl.access$1100(this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplApolloResManagerImpl$10.a, this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionData))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(CMGetResPathUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionData, 6));
      ((StringBuilder)localObject).append("action");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(CMGetResPathUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionData, 6));
      localStringBuilder.append("panelAction/action/");
      FileUtils.copyDirectory((String)localObject, localStringBuilder.toString(), false, false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.ApolloResManagerImpl.10.1
 * JD-Core Version:    0.7.0.1
 */