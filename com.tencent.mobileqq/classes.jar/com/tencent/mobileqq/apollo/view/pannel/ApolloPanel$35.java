package com.tencent.mobileqq.apollo.view.pannel;

import android.content.res.Resources;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionHandlerImpl;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

class ApolloPanel$35
  implements ApolloPanelGuideView.ClickCallback
{
  ApolloPanel$35(ApolloPanel paramApolloPanel) {}
  
  public void a(ApolloPanelGuideView paramApolloPanelGuideView)
  {
    if (paramApolloPanelGuideView.a() == 0)
    {
      ApolloPanel.d(this.a);
      if (!ApolloPanel.a(this.a, "sp_key_apollo_show_guide_tip"))
      {
        ApolloPanel.a(this.a, "sp_key_apollo_show_guide_tip");
        ApolloPanel.a(this.a, ApolloPanel.a(this.a), 49, this.a.getResources().getString(2131690150), 5, null);
      }
    }
    for (;;)
    {
      QLog.i("ApolloPanel", 1, "mGuideClickCallback onClose");
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.aF();
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
      {
        VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a, "cmshow", "Apollo", "clk_panelnewuser_close", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b()), 0, new String[] { "", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
        ApolloPanel.a(this.a, "new_user_panel", "close");
      }
    }
  }
  
  public void b(ApolloPanelGuideView paramApolloPanelGuideView)
  {
    if (paramApolloPanelGuideView.a() == 0)
    {
      ApolloPanel.d(this.a);
      ((ApolloExtensionHandlerImpl)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a("guide_page", 1, new ApolloPanel.35.1(this));
      return;
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null))
    {
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a, "cmshow", "Apollo", "exp_panelnewuser_open", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b()), ApolloPanel.c, new String[] { "", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      ApolloPanel.a(this.a, "new_user_panel", "open");
    }
    paramApolloPanelGuideView = (ApolloExtensionHandlerImpl)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
    if (ApolloPanel.c == 0) {}
    for (int i = 0;; i = 1)
    {
      paramApolloPanelGuideView.a("guide_open_cmshow", i, new ApolloPanel.35.2(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.35
 * JD-Core Version:    0.7.0.1
 */