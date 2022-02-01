package com.tencent.mobileqq.apollo.view.pannel;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionHandlerImpl;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class ApolloPanel$19
  implements DialogInterface.OnClickListener
{
  ApolloPanel$19(ApolloPanel paramApolloPanel, String paramString1, String paramString2, String paramString3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.l();
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a != null))
    {
      paramDialogInterface = (ApolloExtensionHandlerImpl)this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
      if (!this.jdField_a_of_type_JavaLangString.equals(String.valueOf(2))) {}
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a, "cmshow", "Apollo", "icon_alert_clickbuy", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), 0, new String[] { "" + this.b });
      }
      String str = new JSONObject(this.c).getString("packageId");
      paramDialogInterface.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.getCurrentAccountUin(), Integer.parseInt(this.b), Integer.parseInt(str));
      return;
    }
    catch (JSONException paramDialogInterface)
    {
      QLog.e("ApolloPanel", 1, "[showAioDialog] Exception:", paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.19
 * JD-Core Version:    0.7.0.1
 */