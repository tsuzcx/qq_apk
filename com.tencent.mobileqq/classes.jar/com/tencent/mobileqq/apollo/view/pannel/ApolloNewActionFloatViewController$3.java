package com.tencent.mobileqq.apollo.view.pannel;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.ApolloPanelManager;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloInfo;
import com.tencent.mobileqq.apollo.statistics.ApolloTianshuReportUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ApolloNewActionFloatViewController$3
  implements View.OnClickListener
{
  ApolloNewActionFloatViewController$3(ApolloNewActionFloatViewController paramApolloNewActionFloatViewController, ApolloActionData paramApolloActionData, Bundle paramBundle, int paramInt, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    ApolloInfo localApolloInfo = new ApolloInfo();
    localApolloInfo.mAction = this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloActionData;
    localApolloInfo.mPackageId = this.jdField_a_of_type_AndroidOsBundle.getInt("pkgId");
    if (ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloNewActionFloatViewController) != null) {
      ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloNewActionFloatViewController).a(ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloNewActionFloatViewController), localApolloInfo);
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloNewActionFloatViewController.a();
    ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloNewActionFloatViewController, this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloActionData, "action_flame_clickgain");
    ApolloTianshuReportUtil.a(125, String.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString, this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloNewActionFloatViewController.3
 * JD-Core Version:    0.7.0.1
 */