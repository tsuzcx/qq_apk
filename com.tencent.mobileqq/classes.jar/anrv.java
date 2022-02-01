import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class anrv
  implements View.OnClickListener
{
  public anrv(ApolloPanel paramApolloPanel, ApolloActionData paramApolloActionData, int paramInt, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_Ansf != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_Ansf.a(2);
    }
    for (;;)
    {
      ApolloPanel.b(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, "cmshow", "Apollo", "action_flame_clickgain", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId) });
      }
      amsx.a(125, String.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString, this.b);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.e("ApolloPanel", 1, "realshowNewActionFloatView mAppController null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anrv
 * JD-Core Version:    0.7.0.1
 */