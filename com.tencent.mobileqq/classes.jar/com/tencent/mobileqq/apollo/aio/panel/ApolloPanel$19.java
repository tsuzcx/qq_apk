package com.tencent.mobileqq.apollo.aio.panel;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;

class ApolloPanel$19
  implements DialogInterface.OnClickListener
{
  ApolloPanel$19(ApolloPanel paramApolloPanel, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel.j();
    if (ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel) != null)
    {
      if (ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel).jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
        return;
      }
      paramDialogInterface = new Intent(ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel).jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      paramDialogInterface.putExtra("url", this.jdField_a_of_type_JavaLangString);
      boolean bool = TextUtils.isEmpty(this.b);
      int j = 1;
      int k = 0;
      QQAppInterface localQQAppInterface;
      StringBuilder localStringBuilder;
      int i;
      if ((!bool) && (this.b.equals("true")))
      {
        if (ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel) != null)
        {
          localQQAppInterface = ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          paramInt = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel).a);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(this.c);
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "activity_alert_view", paramInt, 0, new String[] { localStringBuilder.toString(), "0" });
          localQQAppInterface = ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          paramInt = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel).a);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(this.c);
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "participate", paramInt, 0, new String[] { localStringBuilder.toString() });
        }
        i = 14007;
        paramInt = j;
      }
      else
      {
        paramInt = j;
        i = k;
        if (ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel) != null)
        {
          paramInt = j;
          i = k;
          if (!TextUtils.isEmpty(this.d)) {
            if (this.d.equals(String.valueOf(9)))
            {
              ApolloUtilImpl.jumpToH5PreviewAction(ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel).jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.c, this.e);
              localQQAppInterface = ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              paramInt = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel).a);
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("");
              localStringBuilder.append(this.c);
              VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "vip_alert_view", paramInt, 0, new String[] { localStringBuilder.toString(), "0" });
              paramInt = 0;
              i = k;
            }
            else
            {
              paramInt = j;
              i = k;
              if (this.d.equals(String.valueOf(2)))
              {
                localQQAppInterface = ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                paramInt = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel).a);
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("");
                localStringBuilder.append(this.c);
                VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "debt_alert_clickcharge", paramInt, 0, new String[] { localStringBuilder.toString() });
                i = k;
                paramInt = j;
              }
            }
          }
        }
      }
      if (paramInt != 0) {
        ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel).jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(paramDialogInterface, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.19
 * JD-Core Version:    0.7.0.1
 */