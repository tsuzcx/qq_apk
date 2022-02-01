package com.tencent.mobileqq.apollo.aio.panel;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;

class ApolloPanel$34$2$1
  implements Runnable
{
  ApolloPanel$34$2$1(ApolloPanel.34.2 param2, boolean paramBoolean) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel$34$2.a.a.getContext(), 1, "开启厘米秀失败！", 0).b(0);
      if ((ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel$34$2.a.a) != null) && (ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel$34$2.a.a) != null))
      {
        VipUtils.a(ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel$34$2.a.a).a, "cmshow", "Apollo", "openshow_tips_fail", ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel$34$2.a.a).a, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel$34$2.a.a).b()), 0, new String[] { "", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
        ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel$34$2.a.a, "panel_tips", "fail");
      }
    }
    else
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel$34$2.a.a.getContext(), 2, "开启厘米秀成功！", 0).b(0);
      ApolloPanel.e(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel$34$2.a.a);
      this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel$34$2.a.a.i();
      if ((ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel$34$2.a.a) != null) && (ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel$34$2.a.a) != null))
      {
        VipUtils.a(ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel$34$2.a.a).a, "cmshow", "Apollo", "openshow_tips_suc", ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel$34$2.a.a).a, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel$34$2.a.a).b()), 0, new String[] { "", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
        ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel$34$2.a.a, "panel_tips", "success");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.34.2.1
 * JD-Core Version:    0.7.0.1
 */