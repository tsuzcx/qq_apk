package com.tencent.mobileqq.apollo.api.web.impl;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.api.model.ApolloGameData;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.DefaultGameCheckListener;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.ICmGameConfirmListener;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

class ApolloJsPluginImpl$13
  extends CmGameStartChecker.DefaultGameCheckListener
{
  ApolloJsPluginImpl$13(ApolloJsPluginImpl paramApolloJsPluginImpl, AppInterface paramAppInterface, boolean paramBoolean, String paramString)
  {
    super(paramAppInterface, paramBoolean);
  }
  
  public void a(long paramLong, CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams) {}
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl.callbackError(this.jdField_a_of_type_JavaLangString, HardCodeUtil.a(2131700502));
    ApolloJsPluginImpl.access$900(this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl, -1);
  }
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam, int paramInt)
  {
    super.a(paramStartCheckParam, paramInt);
    int i = paramInt;
    if (paramInt >= 99) {
      i = 99;
    }
    ApolloJsPluginImpl.access$900(this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl, i);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloJsPlugin", 2, new Object[] { "IPC_APOLLO_DOWNLOAD_GAME onDownloadGameResProgress percent:", Integer.valueOf(i) });
    }
  }
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameStartChecker.ICmGameConfirmListener paramICmGameConfirmListener, long paramLong)
  {
    String str = String.format(HardCodeUtil.a(2131700536), new Object[] { Float.valueOf((float)paramLong * 1.0F / 1024.0F / 1024.0F) });
    Activity localActivity = ApolloJsPluginImpl.access$000(this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl);
    if (localActivity == null) {
      return;
    }
    DialogUtil.a(localActivity, 0, null, str, 2131694615, 2131690800, new ApolloJsPluginImpl.13.1(this), new ApolloJsPluginImpl.13.2(this, paramICmGameConfirmListener, paramStartCheckParam)).show();
    VipUtils.a(null, "cmshow", "Apollo", "download_confirm_toast", 0, 3, new String[] { String.valueOf(paramStartCheckParam.game.gameId) });
  }
  
  public void b(long paramLong, CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams)
  {
    if (paramLong == 0L)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl.callbackOk(this.jdField_a_of_type_JavaLangString);
      ApolloJsPluginImpl.access$900(this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl, 100);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJsPlugin", 2, new Object[] { "IPC_APOLLO_DOWNLOAD_GAME onVerifyGameFinish resultCode:", Long.valueOf(paramLong) });
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl.callbackError(this.jdField_a_of_type_JavaLangString, HardCodeUtil.a(2131700498));
      ApolloJsPluginImpl.access$900(this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl, -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.web.impl.ApolloJsPluginImpl.13
 * JD-Core Version:    0.7.0.1
 */