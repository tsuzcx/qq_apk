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

class ApolloPanel$34
  implements ApolloPanelGuideView.ClickCallback
{
  ApolloPanel$34(ApolloPanel paramApolloPanel) {}
  
  public void a(ApolloPanelGuideView paramApolloPanelGuideView)
  {
    if (paramApolloPanelGuideView.a() == 0)
    {
      ApolloPanel.e(this.a);
      if (!ApolloPanel.a(this.a, "sp_key_apollo_show_guide_tip"))
      {
        ApolloPanel.a(this.a, "sp_key_apollo_show_guide_tip");
        ApolloPanel.a(this.a).a(ApolloPanel.a(this.a), 49, this.a.getResources().getString(2131690067), 5, null);
      }
    }
    else
    {
      if (ApolloPanel.a(this.a) != null) {
        ApolloPanel.a(this.a).ad();
      }
      if ((ApolloPanel.a(this.a) != null) && (ApolloPanel.a(this.a) != null))
      {
        VipUtils.a(ApolloPanel.a(this.a).a, "cmshow", "Apollo", "clk_panelnewuser_close", ApolloPanel.a(this.a).a, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(ApolloPanel.a(this.a).b()), 0, new String[] { "", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
        ApolloPanel.a(this.a, "new_user_panel", "close");
      }
    }
    QLog.i("[cmshow]ApolloPanel", 1, "mGuideClickCallback onClose");
  }
  
  public void b(ApolloPanelGuideView paramApolloPanelGuideView)
  {
    if (paramApolloPanelGuideView.a() == 0)
    {
      ApolloPanel.e(this.a);
      ((ApolloExtensionHandler)ApolloPanel.a(this.a).a.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a("guide_page", 1, new ApolloPanel.34.1(this));
      return;
    }
    paramApolloPanelGuideView = ApolloPanel.a(this.a).a;
    String str = ApolloPanel.a(this.a).a;
    int j = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(ApolloPanel.a(this.a).b());
    int k = ApolloPanel.c;
    int i = 0;
    VipUtils.a(paramApolloPanelGuideView, "cmshow", "Apollo", "exp_panelnewuser_open", str, j, k, new String[] { "", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
    ApolloPanel.a(this.a, "new_user_panel", "open");
    paramApolloPanelGuideView = (ApolloExtensionHandler)ApolloPanel.a(this.a).a.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
    if (ApolloPanel.c != 0) {
      i = 1;
    }
    paramApolloPanelGuideView.a("guide_open_cmshow", i, new ApolloPanel.34.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.34
 * JD-Core Version:    0.7.0.1
 */