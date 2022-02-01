package com.tencent.mobileqq.apollo.process;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.api.res.impl.ApolloResDownloaderImpl.ApolloLoadResTask;
import com.tencent.mobileqq.apollo.api.res.impl.ApolloResDownloaderImpl.OnApolloDownLoadListenerForTaskList;
import com.tencent.mobileqq.apollo.api.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.api.sdk.PlayActionConfig;
import com.tencent.mobileqq.apollo.sdk.CmShowSpriteRscBuilder;
import com.tencent.mobileqq.apollo.sdk.IPCSpriteContext;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.List;

class CmGameServerQIPCModule$5$1
  implements ApolloResDownloaderImpl.OnApolloDownLoadListenerForTaskList
{
  CmGameServerQIPCModule$5$1(CmGameServerQIPCModule.5 param5) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramBoolean) {}
    for (paramInt1 = 0;; paramInt1 = -1)
    {
      paramString = EIPCResult.createResult(paramInt1, null);
      this.a.this$0.callbackResult(this.a.c, paramString);
      QLog.i("cmgame_process.CmGameServerQIPCModule", 2, "onDownLoadFinish onDownLoadFinish sucess:" + paramBoolean);
      return;
    }
  }
  
  public void a(boolean paramBoolean, String paramString, List<ApolloResDownloaderImpl.ApolloLoadResTask> paramList)
  {
    int i = 1;
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam.g = 6;
      this.a.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam.jdField_a_of_type_Boolean = true;
      this.a.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentMobileqqApolloSdkIPCSpriteContext.b;
      if (this.a.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam.jdField_e_of_type_Int >= 1) {
        this.a.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam.b = this.a.jdField_a_of_type_ComTencentMobileqqApolloSdkIPCSpriteContext.jdField_a_of_type_JavaLangString;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam.jdField_a_of_type_Int = this.a.b;
      this.a.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam.m = this.a.jdField_a_of_type_ComTencentMobileqqApolloApiSdkPlayActionConfig.c;
      paramString = CmShowSpriteRscBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam, this.a.jdField_a_of_type_ComTencentMobileqqApolloSdkIPCSpriteContext, this.a.jdField_a_of_type_ComTencentMobileqqApolloApiSdkPlayActionConfig);
      this.a.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam.jdField_e_of_type_JavaLangString = paramString;
      paramString = this.a.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam;
      if (this.a.jdField_a_of_type_ComTencentMobileqqApolloApiSdkPlayActionConfig.jdField_a_of_type_Boolean)
      {
        paramString.n = i;
        paramString = new Bundle();
        paramString.putParcelable("IPCSpriteContext", this.a.jdField_a_of_type_ComTencentMobileqqApolloSdkIPCSpriteContext);
        paramString.putParcelable("SpriteTaskParam", this.a.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam);
        paramString = EIPCResult.createSuccessResult(paramString);
        this.a.this$0.callbackResult(this.a.c, paramString);
      }
    }
    for (;;)
    {
      QLog.i("cmgame_process.CmGameServerQIPCModule", 2, "onDownLoadFinish onDownLoadFinish sucess:" + paramBoolean);
      return;
      i = 0;
      break;
      paramString = EIPCResult.createResult(-1, null);
      this.a.this$0.callbackResult(this.a.c, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.CmGameServerQIPCModule.5.1
 * JD-Core Version:    0.7.0.1
 */