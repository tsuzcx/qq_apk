package com.tencent.mobileqq.apollo.web.api.impl;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.game.CmGameStartChecker.DefaultGameCheckListener;
import com.tencent.mobileqq.apollo.game.CmGameStartChecker.ICmGameConfirmListener;
import com.tencent.mobileqq.apollo.game.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.model.ApolloGameData;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

class ApolloJsPluginImpl$3
  extends CmGameStartChecker.DefaultGameCheckListener
{
  ApolloJsPluginImpl$3(ApolloJsPluginImpl paramApolloJsPluginImpl, AppInterface paramAppInterface, boolean paramBoolean, String paramString)
  {
    super(paramAppInterface, paramBoolean);
  }
  
  public void a(long paramLong, StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams) {}
  
  public void a(StartCheckParam paramStartCheckParam, int paramInt)
  {
    super.a(paramStartCheckParam, paramInt);
    int i = 99;
    if (paramInt >= 99) {
      paramInt = i;
    }
    ApolloJsPluginImpl.access$200(this.jdField_a_of_type_ComTencentMobileqqApolloWebApiImplApolloJsPluginImpl, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloJsPlugin", 2, new Object[] { "IPC_APOLLO_DOWNLOAD_GAME onDownloadGameResProgress percent:", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(StartCheckParam paramStartCheckParam, CmGameStartChecker.ICmGameConfirmListener paramICmGameConfirmListener, long paramLong)
  {
    String str = String.format(HardCodeUtil.a(2131700677), new Object[] { Float.valueOf((float)paramLong * 1.0F / 1024.0F / 1024.0F) });
    Activity localActivity = ApolloJsPluginImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqApolloWebApiImplApolloJsPluginImpl);
    if (localActivity == null) {
      return;
    }
    DialogUtil.a(localActivity, 0, null, str, 2131694583, 2131690728, new ApolloJsPluginImpl.3.1(this), new ApolloJsPluginImpl.3.2(this, paramICmGameConfirmListener, paramStartCheckParam)).show();
    VipUtils.a(null, "cmshow", "Apollo", "download_confirm_toast", 0, 3, new String[] { String.valueOf(paramStartCheckParam.game.gameId) });
  }
  
  public void b(long paramLong, StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams)
  {
    if (paramLong == 0L)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloWebApiImplApolloJsPluginImpl.callbackOk(this.jdField_a_of_type_JavaLangString);
      ApolloJsPluginImpl.access$200(this.jdField_a_of_type_ComTencentMobileqqApolloWebApiImplApolloJsPluginImpl, 100);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloWebApiImplApolloJsPluginImpl.callbackError(this.jdField_a_of_type_JavaLangString, HardCodeUtil.a(2131700639));
      ApolloJsPluginImpl.access$200(this.jdField_a_of_type_ComTencentMobileqqApolloWebApiImplApolloJsPluginImpl, -1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloJsPlugin", 2, new Object[] { "IPC_APOLLO_DOWNLOAD_GAME onVerifyGameFinish resultCode:", Long.valueOf(paramLong) });
    }
  }
  
  public void b(StartCheckParam paramStartCheckParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloWebApiImplApolloJsPluginImpl.callbackError(this.jdField_a_of_type_JavaLangString, HardCodeUtil.a(2131700643));
    ApolloJsPluginImpl.access$200(this.jdField_a_of_type_ComTencentMobileqqApolloWebApiImplApolloJsPluginImpl, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.api.impl.ApolloJsPluginImpl.3
 * JD-Core Version:    0.7.0.1
 */