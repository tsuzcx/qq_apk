package com.tencent.mobileqq.apollo.sdk;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.api.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.api.sdk.PlayActionConfig;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class CmShowSpriteDrawerInfoBridge$1
  implements EIPCResultCallback
{
  CmShowSpriteDrawerInfoBridge$1(CmShowSpriteDrawerInfoBridge paramCmShowSpriteDrawerInfoBridge, long paramLong, PlayActionConfig paramPlayActionConfig) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    try
    {
      if ((paramEIPCResult.code != 0) || (paramEIPCResult.data == null))
      {
        QLog.e("CmShow_SpriteDrawerInfoBridge", 1, "playAction onCallback result.code:" + paramEIPCResult.code);
        ApolloUtilImpl.showDebugTipsToast("播放动作失败");
        return;
      }
      paramEIPCResult.data.setClassLoader(SpriteTaskParam.class.getClassLoader());
      paramEIPCResult = (SpriteTaskParam)paramEIPCResult.data.getParcelable("SpriteTaskParam");
      QLog.i("CmShow_SpriteDrawerInfoBridge", 1, "use:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + "playAction CmShow_ spriteTaskParam:" + paramEIPCResult);
      if (paramEIPCResult != null)
      {
        paramEIPCResult.jdField_a_of_type_ComTencentMobileqqApolloApiScriptISpriteBridge = this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteDrawerInfoBridge;
        paramEIPCResult.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_ComTencentMobileqqApolloApiSdkPlayActionConfig.jdField_a_of_type_AndroidOsBundle;
        this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteDrawerInfoBridge.b(paramEIPCResult);
        ThreadManager.executeOnSubThread(new CmShowSpriteDrawerInfoBridge.1.1(this, paramEIPCResult));
        return;
      }
    }
    catch (Exception paramEIPCResult)
    {
      QLog.i("CmShow_SpriteDrawerInfoBridge", 1, "playAction onCallback e:", paramEIPCResult);
      return;
    }
    QLog.i("CmShow_SpriteDrawerInfoBridge", 1, "playAction onCallback spriteTaskParam==null ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.CmShowSpriteDrawerInfoBridge.1
 * JD-Core Version:    0.7.0.1
 */