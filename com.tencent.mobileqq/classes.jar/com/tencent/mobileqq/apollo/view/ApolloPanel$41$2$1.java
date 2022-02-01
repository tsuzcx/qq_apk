package com.tencent.mobileqq.apollo.view;

import angg;
import angi;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.widget.QQToast;

public class ApolloPanel$41$2$1
  implements Runnable
{
  public ApolloPanel$41$2$1(angi paramangi, boolean paramBoolean) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      QQToast.a(this.jdField_a_of_type_Angi.jdField_a_of_type_Angg.a.getContext(), 1, "开启厘米秀失败！", 0).b(0);
      if ((this.jdField_a_of_type_Angi.jdField_a_of_type_Angg.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_Angi.jdField_a_of_type_Angg.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)) {
        VipUtils.a(this.jdField_a_of_type_Angi.jdField_a_of_type_Angg.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, "cmshow", "Apollo", "openshow_tips_fail", this.jdField_a_of_type_Angi.jdField_a_of_type_Angg.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, ApolloUtil.b(this.jdField_a_of_type_Angi.jdField_a_of_type_Angg.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b()), 0, new String[] { "", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Angi.jdField_a_of_type_ComTencentMobileqqVasVasExtensionHandler.a(null);
      return;
      QQToast.a(this.jdField_a_of_type_Angi.jdField_a_of_type_Angg.a.getContext(), 2, "开启厘米秀成功！", 0).b(0);
      ApolloPanel.f(this.jdField_a_of_type_Angi.jdField_a_of_type_Angg.a);
      this.jdField_a_of_type_Angi.jdField_a_of_type_Angg.a.k();
      if ((this.jdField_a_of_type_Angi.jdField_a_of_type_Angg.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_Angi.jdField_a_of_type_Angg.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)) {
        VipUtils.a(this.jdField_a_of_type_Angi.jdField_a_of_type_Angg.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, "cmshow", "Apollo", "openshow_tips_suc", this.jdField_a_of_type_Angi.jdField_a_of_type_Angg.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, ApolloUtil.b(this.jdField_a_of_type_Angi.jdField_a_of_type_Angg.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b()), 0, new String[] { "", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.41.2.1
 * JD-Core Version:    0.7.0.1
 */