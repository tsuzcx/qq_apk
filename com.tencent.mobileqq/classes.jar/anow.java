import android.content.res.Resources;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanel;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanelGuideView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.QLog;

public class anow
  implements anpj
{
  public anow(ApolloPanel paramApolloPanel) {}
  
  public void a(ApolloPanelGuideView paramApolloPanelGuideView)
  {
    if (paramApolloPanelGuideView.a() == 0)
    {
      ApolloPanel.e(this.a);
      if (!ApolloPanel.a(this.a, "sp_key_apollo_show_guide_tip"))
      {
        ApolloPanel.a(this.a, "sp_key_apollo_show_guide_tip");
        ApolloPanel.a(this.a, ApolloPanel.b(this.a), 49, this.a.getResources().getString(2131690096), 5, null);
      }
    }
    for (;;)
    {
      QLog.i("ApolloPanel", 1, "mGuideClickCallback onClose");
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hideAllPanels();
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)) {
        VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "cmshow", "Apollo", "clk_panelnewuser_close", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, ApolloUtil.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurType()), 0, new String[] { "", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      }
    }
  }
  
  public void b(ApolloPanelGuideView paramApolloPanelGuideView)
  {
    if (paramApolloPanelGuideView.a() == 0)
    {
      ApolloPanel.e(this.a);
      ((VasExtensionHandler)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER)).a("guide_page", 1, new anox(this));
      return;
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)) {
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "cmshow", "Apollo", "exp_panelnewuser_open", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, ApolloUtil.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurType()), ApolloPanel.b, new String[] { "", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
    }
    paramApolloPanelGuideView = (VasExtensionHandler)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER);
    if (ApolloPanel.b == 0) {}
    for (int i = 0;; i = 1)
    {
      paramApolloPanelGuideView.a("guide_open_cmshow", i, new anoy(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anow
 * JD-Core Version:    0.7.0.1
 */