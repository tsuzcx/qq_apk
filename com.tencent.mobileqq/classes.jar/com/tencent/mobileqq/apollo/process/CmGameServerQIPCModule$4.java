package com.tencent.mobileqq.apollo.process;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionHandlerImpl.OnQueryBaseInfoListener;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.List;

class CmGameServerQIPCModule$4
  implements ApolloExtensionHandlerImpl.OnQueryBaseInfoListener
{
  CmGameServerQIPCModule$4(CmGameServerQIPCModule paramCmGameServerQIPCModule, List paramList, ApolloManagerServiceImpl paramApolloManagerServiceImpl, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt) {}
  
  public boolean a(String paramString, ApolloBaseInfo paramApolloBaseInfo)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramString);
    QLog.i("cmgame_process.CmGameServerQIPCModule", 1, "CmShow ACTION_RENDER_VIEW_INIT_CMSHOW_DATA onGetBaseInfo uin:" + ((IApolloUtil)QRoute.api(IApolloUtil.class)).wrapLogUin(paramString));
    if (this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl.getCmShowStatusNoCareSelfStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, true);
      int j = this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl.getCmShowStatusNoCareSelfStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.b, true);
      paramString = new Bundle();
      paramString.putInt("selfUinStatus", i);
      paramString.putInt("friendUinStatus", j);
      paramString = EIPCResult.createSuccessResult(paramString);
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessCmGameServerQIPCModule.callbackResult(this.jdField_a_of_type_Int, paramString);
      return true;
    }
    return false;
  }
  
  public boolean b(String paramString, ApolloBaseInfo paramApolloBaseInfo)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramString);
    QLog.i("cmgame_process.CmGameServerQIPCModule", 1, "CmShow ACTION_RENDER_VIEW_INIT_CMSHOW_DATA onDressUpdated uin:" + ((IApolloUtil)QRoute.api(IApolloUtil.class)).wrapLogUin(paramString));
    if (this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl.getCmShowStatusNoCareSelfStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, true);
      int j = this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl.getCmShowStatusNoCareSelfStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.b, true);
      paramString = new Bundle();
      paramString.putInt("selfUinStatus", i);
      paramString.putInt("friendUinStatus", j);
      paramString = EIPCResult.createSuccessResult(paramString);
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessCmGameServerQIPCModule.callbackResult(this.jdField_a_of_type_Int, paramString);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.CmGameServerQIPCModule.4
 * JD-Core Version:    0.7.0.1
 */