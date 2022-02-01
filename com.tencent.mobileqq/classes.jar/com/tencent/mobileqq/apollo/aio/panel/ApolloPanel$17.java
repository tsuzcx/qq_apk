package com.tencent.mobileqq.apollo.aio.panel;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;

class ApolloPanel$17
  implements DialogInterface.OnClickListener
{
  ApolloPanel$17(ApolloPanel paramApolloPanel, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel.j();
    if ((ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel) != null) && (ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel).jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null))
    {
      if (ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        return;
      }
      paramDialogInterface = new Intent(ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel).jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ApolloConstant.k);
      localStringBuilder.append("&actionId=");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("&_bid=2282");
      paramDialogInterface.putExtra("url", localStringBuilder.toString());
      ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel).jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(paramDialogInterface, 0);
      boolean bool = ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel).getAVIPStatus(ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      if (ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel) != null)
      {
        paramDialogInterface = ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        paramInt = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel).a);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        VipUtils.a(paramDialogInterface, "cmshow", "Apollo", "level_alert_view", paramInt, bool ^ true, new String[] { localStringBuilder.toString(), "0" });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.17
 * JD-Core Version:    0.7.0.1
 */