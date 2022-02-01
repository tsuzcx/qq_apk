package com.tencent.mobileqq.apollo.api.web.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.apollo.api.model.ApolloGameData;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.ICmGameConfirmListener;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.utils.VipUtils;

class ApolloJsPluginImpl$13$2
  implements DialogInterface.OnClickListener
{
  ApolloJsPluginImpl$13$2(ApolloJsPluginImpl.13 param13, CmGameStartChecker.ICmGameConfirmListener paramICmGameConfirmListener, CmGameStartChecker.StartCheckParam paramStartCheckParam) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$ICmGameConfirmListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$ICmGameConfirmListener.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    }
    VipUtils.a(null, "cmshow", "Apollo", "download_confirm", 0, 3, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.web.impl.ApolloJsPluginImpl.13.2
 * JD-Core Version:    0.7.0.1
 */