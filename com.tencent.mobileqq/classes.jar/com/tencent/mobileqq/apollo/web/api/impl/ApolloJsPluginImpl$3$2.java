package com.tencent.mobileqq.apollo.web.api.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.apollo.game.CmGameStartChecker.ICmGameConfirmListener;
import com.tencent.mobileqq.apollo.model.ApolloGameData;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.utils.VipUtils;

class ApolloJsPluginImpl$3$2
  implements DialogInterface.OnClickListener
{
  ApolloJsPluginImpl$3$2(ApolloJsPluginImpl.3 param3, CmGameStartChecker.ICmGameConfirmListener paramICmGameConfirmListener, StartCheckParam paramStartCheckParam) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameStartChecker$ICmGameConfirmListener;
    if (paramDialogInterface != null) {
      paramDialogInterface.a(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam);
    }
    VipUtils.a(null, "cmshow", "Apollo", "download_confirm", 0, 3, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.game.gameId) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.api.impl.ApolloJsPluginImpl.3.2
 * JD-Core Version:    0.7.0.1
 */