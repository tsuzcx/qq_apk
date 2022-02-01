package com.tencent.mobileqq.apollo.process;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.res.impl.ApolloResDownloaderImpl;
import com.tencent.mobileqq.apollo.api.res.impl.ApolloResDownloaderImpl.ApolloLoadResTask;
import com.tencent.mobileqq.apollo.api.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.api.sdk.PlayActionConfig;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.sdk.CmShowSpriteRscBuilder;
import com.tencent.mobileqq.apollo.sdk.IPCSpriteContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.List;

class CmGameServerQIPCModule$5
  implements Runnable
{
  CmGameServerQIPCModule$5(CmGameServerQIPCModule paramCmGameServerQIPCModule, QQAppInterface paramQQAppInterface, int paramInt1, SpriteTaskParam paramSpriteTaskParam, IPCSpriteContext paramIPCSpriteContext, int paramInt2, PlayActionConfig paramPlayActionConfig, long paramLong, int paramInt3) {}
  
  public void run()
  {
    int i = 0;
    Object localObject = SpriteUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int);
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam.c = ((ApolloActionData)localObject).actionType;
      this.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam.jdField_e_of_type_Int = ((ApolloActionData)localObject).personNum;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam.jdField_e_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam.h = 0;
      }
    }
    while ((ApolloUtilImpl.isActionResDone(this.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam.f, this.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam.c)) || (ApolloUtilImpl.isQzoneActionRscDone(this.jdField_a_of_type_Int)))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam.g = 6;
      this.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqApolloSdkIPCSpriteContext.b;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam.jdField_e_of_type_Int >= 1) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam.b = this.jdField_a_of_type_ComTencentMobileqqApolloSdkIPCSpriteContext.jdField_a_of_type_JavaLangString;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam.jdField_a_of_type_Int = this.b;
      this.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam.m = this.jdField_a_of_type_ComTencentMobileqqApolloApiSdkPlayActionConfig.c;
      localObject = this.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApiSdkPlayActionConfig.jdField_a_of_type_Boolean) {
        i = 1;
      }
      ((SpriteTaskParam)localObject).n = i;
      localObject = CmShowSpriteRscBuilder.a(this.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam, this.jdField_a_of_type_ComTencentMobileqqApolloSdkIPCSpriteContext, this.jdField_a_of_type_ComTencentMobileqqApolloApiSdkPlayActionConfig);
      this.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam.jdField_e_of_type_JavaLangString = ((String)localObject);
      QLog.i("cmgame_process.CmGameServerQIPCModule", 1, "CmShow ACTION_RENDER_VIEW_PLAY_ACTION use:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
      localObject = new Bundle();
      ((Bundle)localObject).putParcelable("IPCSpriteContext", this.jdField_a_of_type_ComTencentMobileqqApolloSdkIPCSpriteContext);
      ((Bundle)localObject).putParcelable("SpriteTaskParam", this.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam);
      localObject = EIPCResult.createSuccessResult((Bundle)localObject);
      this.this$0.callbackResult(this.c, (EIPCResult)localObject);
      return;
      this.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam.h = 1;
      continue;
      this.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam.jdField_e_of_type_Int = 1;
      QLog.e("cmgame_process.CmGameServerQIPCModule", 1, "CmShow ACTION_RENDER_VIEW_PLAY_ACTION actionData==null");
      ApolloUtilImpl.showDebugTipsToast("测试版本提示：无此动作配置信息");
      this.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam.h = 0;
    }
    localObject = new ArrayList();
    ApolloResDownloaderImpl.ApolloLoadResTask localApolloLoadResTask = new ApolloResDownloaderImpl.ApolloLoadResTask(3, this.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam.f);
    localApolloLoadResTask.c = this.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam.c;
    ((List)localObject).add(localApolloLoadResTask);
    ApolloResDownloaderImpl.downloadApolloResInner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", new CmGameServerQIPCModule.5.1(this), (List)localObject, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.CmGameServerQIPCModule.5
 * JD-Core Version:    0.7.0.1
 */