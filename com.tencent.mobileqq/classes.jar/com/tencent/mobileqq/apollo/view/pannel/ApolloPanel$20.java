package com.tencent.mobileqq.apollo.view.pannel;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;

class ApolloPanel$20
  implements DialogInterface.OnClickListener
{
  ApolloPanel$20(ApolloPanel paramApolloPanel, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    int i = 0;
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.l();
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null)) {}
    for (;;)
    {
      return;
      paramDialogInterface = new Intent(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, QQBrowserActivity.class);
      paramDialogInterface.putExtra("url", this.jdField_a_of_type_JavaLangString);
      if ((!TextUtils.isEmpty(this.b)) && (this.b.equals("true")))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
          break label500;
        }
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "activity_alert_view", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), 0, new String[] { "" + this.c, "0" });
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "participate", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), 0, new String[] { "" + this.c });
        i = 9999;
        paramInt = 1;
      }
      while (paramInt != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(paramDialogInterface, i);
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!TextUtils.isEmpty(this.d)))
        {
          if (this.d.equals(String.valueOf(9)))
          {
            ApolloUtilImpl.jumpToH5PreviewAction(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.c, this.e);
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "vip_alert_view", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), 0, new String[] { "" + this.c, "0" });
            paramInt = 0;
            continue;
          }
          if (this.d.equals(String.valueOf(2))) {
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "debt_alert_clickcharge", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), 0, new String[] { "" + this.c });
          }
        }
        paramInt = 1;
        continue;
        label500:
        i = 9999;
        paramInt = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.20
 * JD-Core Version:    0.7.0.1
 */