package com.tencent.mobileqq.apollo.aio.panel;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class ApolloPanel$18
  implements DialogInterface.OnClickListener
{
  ApolloPanel$18(ApolloPanel paramApolloPanel, String paramString1, String paramString2, String paramString3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel.j();
    if (ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel) != null)
    {
      if (ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel).a == null) {
        return;
      }
      paramDialogInterface = (ApolloExtensionHandler)ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel).a.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
      if (!this.jdField_a_of_type_JavaLangString.equals(String.valueOf(2)))
      {
        QLog.d("[cmshow]ApolloPanel", 2, "free action item click");
        return;
      }
      try
      {
        if (ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel) != null)
        {
          localObject = ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel).a;
          paramInt = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel).a);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(this.b);
          VipUtils.a((AppInterface)localObject, "cmshow", "Apollo", "icon_alert_clickbuy", paramInt, 0, new String[] { localStringBuilder.toString() });
        }
        Object localObject = new JSONObject(this.c).getString("packageId");
        paramDialogInterface.a(ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel).a.getCurrentAccountUin(), Integer.parseInt(this.b), Integer.parseInt((String)localObject));
        return;
      }
      catch (JSONException paramDialogInterface)
      {
        QLog.e("[cmshow]ApolloPanel", 1, "[showAioDialog] Exception:", paramDialogInterface);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.18
 * JD-Core Version:    0.7.0.1
 */