package com.tencent.mobileqq.apollo.view.pannel;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.ApolloPanelManager;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloMainInfo;
import com.tencent.mobileqq.apollo.statistics.ApolloTianshuReportUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ApolloNewActionFloatViewController$1
  implements View.OnClickListener
{
  ApolloNewActionFloatViewController$1(ApolloNewActionFloatViewController paramApolloNewActionFloatViewController, ApolloMainInfo paramApolloMainInfo, ApolloActionData paramApolloActionData, int paramInt, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    if ((ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloNewActionFloatViewController) != null) && (ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloNewActionFloatViewController).a != null) && (ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloNewActionFloatViewController) != null)) {
      ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloNewActionFloatViewController).b(ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloNewActionFloatViewController), this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloMainInfo);
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloNewActionFloatViewController.a();
    ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloNewActionFloatViewController, this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloActionData, "action_flame_clicksend");
    ApolloTianshuReportUtil.a(102, String.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString, this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloNewActionFloatViewController.1
 * JD-Core Version:    0.7.0.1
 */