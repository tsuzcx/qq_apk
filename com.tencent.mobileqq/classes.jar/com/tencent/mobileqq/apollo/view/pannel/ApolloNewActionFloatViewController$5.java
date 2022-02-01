package com.tencent.mobileqq.apollo.view.pannel;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.ApolloPanelManager;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloInfo;
import com.tencent.mobileqq.apollo.statistics.ApolloTianshuReportUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ApolloNewActionFloatViewController$5
  implements View.OnClickListener
{
  ApolloNewActionFloatViewController$5(ApolloNewActionFloatViewController paramApolloNewActionFloatViewController, ApolloActionData paramApolloActionData, int paramInt1, int paramInt2, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    if (ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloNewActionFloatViewController) != null)
    {
      ApolloInfo localApolloInfo = new ApolloInfo();
      localApolloInfo.mAction = this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloActionData;
      ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloNewActionFloatViewController).c(ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloNewActionFloatViewController), localApolloInfo);
    }
    if (this.jdField_a_of_type_Int == ApolloNewActionFloatViewController.a()) {
      ApolloTianshuReportUtil.a(124, String.valueOf(this.jdField_b_of_type_Int), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloNewActionFloatViewController.5
 * JD-Core Version:    0.7.0.1
 */