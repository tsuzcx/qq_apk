package com.tencent.mobileqq.apollo.aio.panel;

import android.content.res.Resources;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

class ApolloPanel$29
  implements ApolloPanelGuideView.ClickCallback
{
  ApolloPanel$29(ApolloPanel paramApolloPanel) {}
  
  public void a(ApolloPanelGuideView paramApolloPanelGuideView)
  {
    if (paramApolloPanelGuideView.getGuideType() == 0)
    {
      ApolloPanel.O(this.a);
      if (!ApolloPanel.a(this.a, "sp_key_apollo_show_guide_tip"))
      {
        ApolloPanel.b(this.a, "sp_key_apollo_show_guide_tip");
        ApolloPanel.P(this.a).a(ApolloPanel.d(this.a), 49, this.a.getResources().getString(2131886718), 5, null);
      }
    }
    else
    {
      if (ApolloPanel.g(this.a) != null) {
        ApolloPanel.g(this.a).aQ();
      }
      if ((ApolloPanel.g(this.a) != null) && (ApolloPanel.o(this.a) != null))
      {
        VipUtils.a(ApolloPanel.g(this.a).d, "cmshow", "Apollo", "clk_panelnewuser_close", ApolloPanel.o(this.a).b, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(ApolloPanel.g(this.a).F()), 0, new String[] { "", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
        ApolloPanel.a(this.a, "new_user_panel", "close");
      }
    }
    QLog.i("[cmshow]ApolloPanel", 1, "mGuideClickCallback onClose");
  }
  
  public void b(ApolloPanelGuideView paramApolloPanelGuideView)
  {
    if (paramApolloPanelGuideView.getGuideType() == 0)
    {
      ApolloPanel.O(this.a);
      ((ApolloExtensionHandler)ApolloPanel.g(this.a).d.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a("guide_page", 1, new ApolloPanel.29.1(this));
      return;
    }
    paramApolloPanelGuideView = ApolloPanel.g(this.a).d;
    String str = ApolloPanel.o(this.a).b;
    int j = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(ApolloPanel.g(this.a).F());
    int k = ApolloPanel.d;
    int i = 0;
    VipUtils.a(paramApolloPanelGuideView, "cmshow", "Apollo", "exp_panelnewuser_open", str, j, k, new String[] { "", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
    ApolloPanel.a(this.a, "new_user_panel", "open");
    paramApolloPanelGuideView = (ApolloExtensionHandler)ApolloPanel.g(this.a).d.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
    if (ApolloPanel.d != 0) {
      i = 1;
    }
    paramApolloPanelGuideView.a("guide_open_cmshow", i, new ApolloPanel.29.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.29
 * JD-Core Version:    0.7.0.1
 */