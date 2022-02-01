package com.tencent.mobileqq.apollo.aio.panel;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.statistics.ApolloTianshuReportUtil;

class ApolloNewActionFloatViewController$5
  implements View.OnClickListener
{
  ApolloNewActionFloatViewController$5(ApolloNewActionFloatViewController paramApolloNewActionFloatViewController, ApolloActionData paramApolloActionData, int paramInt1, int paramInt2, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    if (ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloNewActionFloatViewController) != null)
    {
      paramView = new ApolloInfo();
      paramView.mAction = this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionData;
      ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloNewActionFloatViewController).b(ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloNewActionFloatViewController), paramView);
    }
    if (this.jdField_a_of_type_Int == ApolloNewActionFloatViewController.a()) {
      ApolloTianshuReportUtil.a(124, String.valueOf(this.jdField_b_of_type_Int), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloNewActionFloatViewController.5
 * JD-Core Version:    0.7.0.1
 */