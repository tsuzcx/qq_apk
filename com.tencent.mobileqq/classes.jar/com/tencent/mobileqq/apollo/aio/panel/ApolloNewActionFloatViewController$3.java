package com.tencent.mobileqq.apollo.aio.panel;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.statistics.ApolloTianshuReportUtil;

class ApolloNewActionFloatViewController$3
  implements View.OnClickListener
{
  ApolloNewActionFloatViewController$3(ApolloNewActionFloatViewController paramApolloNewActionFloatViewController, ApolloActionData paramApolloActionData, Bundle paramBundle, int paramInt, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    paramView = new ApolloInfo();
    paramView.mAction = this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionData;
    paramView.mPackageId = this.jdField_a_of_type_AndroidOsBundle.getInt("pkgId");
    if (ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloNewActionFloatViewController) != null) {
      ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloNewActionFloatViewController).a(ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloNewActionFloatViewController), paramView);
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloNewActionFloatViewController.a();
    ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloNewActionFloatViewController, this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionData, "action_flame_clickgain");
    ApolloTianshuReportUtil.a(125, String.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloNewActionFloatViewController.3
 * JD-Core Version:    0.7.0.1
 */