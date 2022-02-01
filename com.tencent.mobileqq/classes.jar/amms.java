import android.content.res.Resources;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.apollo.view.ApolloPanelGuideView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.QLog;

public class amms
  implements amnc
{
  public amms(ApolloPanel paramApolloPanel) {}
  
  public void a(ApolloPanelGuideView paramApolloPanelGuideView)
  {
    if (paramApolloPanelGuideView.a() == 0)
    {
      ApolloPanel.f(this.a);
      if (!ApolloPanel.a(this.a, "sp_key_apollo_show_guide_tip"))
      {
        ApolloPanel.a(this.a, "sp_key_apollo_show_guide_tip");
        ApolloPanel.a(this.a, ApolloPanel.a(this.a), 49, this.a.getResources().getString(2131690062), 5, null);
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
      ApolloPanel.f(this.a);
      paramApolloPanelGuideView = (VasExtensionHandler)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getBusinessHandler(71);
      paramApolloPanelGuideView.a(new ammt(this, paramApolloPanelGuideView));
      paramApolloPanelGuideView.b("guide_page", 1);
      return;
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)) {
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "cmshow", "Apollo", "exp_panelnewuser_open", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, ApolloUtil.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurType()), ApolloPanel.b, new String[] { "", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
    }
    paramApolloPanelGuideView = (VasExtensionHandler)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getBusinessHandler(71);
    paramApolloPanelGuideView.a(new ammu(this, paramApolloPanelGuideView));
    if (ApolloPanel.b == 0) {}
    for (int i = 0;; i = 1)
    {
      paramApolloPanelGuideView.b("guide_open_cmshow", i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amms
 * JD-Core Version:    0.7.0.1
 */