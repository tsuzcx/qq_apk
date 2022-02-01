package com.tencent.mobileqq.apollo.view.pannel;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;

class ApolloPanel$18
  implements DialogInterface.OnClickListener
{
  ApolloPanel$18(ApolloPanel paramApolloPanel, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.l();
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    boolean bool;
    do
    {
      return;
      paramDialogInterface = new Intent(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, QQBrowserActivity.class);
      paramDialogInterface.putExtra("url", ApolloConstant.f + "&actionId=" + this.jdField_a_of_type_JavaLangString + "&_bid=2282");
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(paramDialogInterface, 0);
      bool = ((ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getAVIPStatus(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null);
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int i = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (bool) {}
    for (paramInt = 0;; paramInt = 1)
    {
      VipUtils.a(paramDialogInterface, "cmshow", "Apollo", "level_alert_view", i, paramInt, new String[] { "" + this.jdField_a_of_type_JavaLangString, "0" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.18
 * JD-Core Version:    0.7.0.1
 */