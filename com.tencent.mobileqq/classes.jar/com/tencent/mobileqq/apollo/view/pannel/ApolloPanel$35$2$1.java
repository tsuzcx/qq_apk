package com.tencent.mobileqq.apollo.view.pannel;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;

class ApolloPanel$35$2$1
  implements Runnable
{
  ApolloPanel$35$2$1(ApolloPanel.35.2 param2, boolean paramBoolean) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel$35$2.a.a.getContext(), 1, "开启厘米秀失败！", 0).b(0);
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel$35$2.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel$35$2.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
      {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel$35$2.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a, "cmshow", "Apollo", "openshow_tips_fail", this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel$35$2.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel$35$2.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b()), 0, new String[] { "", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
        ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel$35$2.a.a, "panel_tips", "fail");
      }
    }
    do
    {
      return;
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel$35$2.a.a.getContext(), 2, "开启厘米秀成功！", 0).b(0);
      ApolloPanel.d(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel$35$2.a.a);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel$35$2.a.a.k();
    } while ((this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel$35$2.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel$35$2.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null));
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel$35$2.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a, "cmshow", "Apollo", "openshow_tips_suc", this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel$35$2.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel$35$2.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b()), 0, new String[] { "", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
    ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel$35$2.a.a, "panel_tips", "success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.35.2.1
 * JD-Core Version:    0.7.0.1
 */