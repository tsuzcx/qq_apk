package com.tencent.mobileqq.apollo.aio.panel;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.statistics.ApolloTianshuReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.vip.manager.QZoneVipInfoManager;

class ApolloNewActionFloatViewController$4
  implements View.OnClickListener
{
  ApolloNewActionFloatViewController$4(ApolloNewActionFloatViewController paramApolloNewActionFloatViewController, ApolloActionData paramApolloActionData, int paramInt, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    QZoneVipInfoManager.a(ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloNewActionFloatViewController).jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloNewActionFloatViewController).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "lmx_actchat");
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloNewActionFloatViewController.a();
    ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloNewActionFloatViewController, this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionData, "action_flame_clickgain");
    ApolloTianshuReportUtil.a(125, String.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloNewActionFloatViewController.4
 * JD-Core Version:    0.7.0.1
 */