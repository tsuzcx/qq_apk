package com.tencent.mobileqq.apollo.api.web.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.apollo.api.model.ApolloGameMsgInfo;
import com.tencent.mobileqq.apollo.utils.ApolloGameBasicEventUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;

class ApolloJsPluginImpl$11
  implements DialogInterface.OnClickListener
{
  ApolloJsPluginImpl$11(ApolloJsPluginImpl paramApolloJsPluginImpl, int paramInt1, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new ApolloGameMsgInfo();
    paramDialogInterface.gameId = this.jdField_a_of_type_Int;
    paramDialogInterface.gameMode = this.b;
    ApolloGameBasicEventUtil.a(paramDialogInterface, this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl.mRuntime.a(), 2);
    paramDialogInterface = ApolloJsPluginImpl.access$000(this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl);
    if ((paramDialogInterface instanceof BaseActivity)) {
      VipUtils.a(((BaseActivity)paramDialogInterface).getAppInterface(), "cmshow", "Apollo", "game_alert_join", 3, 0, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.web.impl.ApolloJsPluginImpl.11
 * JD-Core Version:    0.7.0.1
 */