package com.tencent.mobileqq.apollo.view.pannel;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.statistics.ApolloTianshuReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneVipInfoManager;

class ApolloNewActionFloatViewController$4
  implements View.OnClickListener
{
  ApolloNewActionFloatViewController$4(ApolloNewActionFloatViewController paramApolloNewActionFloatViewController, ApolloActionData paramApolloActionData, int paramInt, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    QZoneVipInfoManager.cmJumpToYellowPlayDialog(ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloNewActionFloatViewController).jdField_a_of_type_AndroidSupportV4AppFragmentActivity, ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloNewActionFloatViewController).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "lmx_actchat");
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloNewActionFloatViewController.a();
    ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloNewActionFloatViewController, this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloActionData, "action_flame_clickgain");
    ApolloTianshuReportUtil.a(125, String.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString, this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloNewActionFloatViewController.4
 * JD-Core Version:    0.7.0.1
 */