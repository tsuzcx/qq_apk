import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class anrt
  implements View.OnClickListener
{
  public anrt(ApolloPanel paramApolloPanel, ApolloActionData paramApolloActionData, Bundle paramBundle, int paramInt, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    anra localanra = new anra();
    localanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData = this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData;
    localanra.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("pkgId");
    if (ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel) != null) {
      ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel).a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localanra);
    }
    ApolloPanel.b(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, "cmshow", "Apollo", "action_flame_clickgain", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId) });
    }
    amsx.a(125, String.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString, this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anrt
 * JD-Core Version:    0.7.0.1
 */