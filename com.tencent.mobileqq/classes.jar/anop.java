import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanel;
import com.tencent.mobileqq.utils.VipUtils;

public class anop
  implements DialogInterface.OnClickListener
{
  public anop(ApolloPanel paramApolloPanel, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    int i = 0;
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.n();
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity == null)) {}
    for (;;)
    {
      return;
      paramDialogInterface = new Intent(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity, QQBrowserActivity.class);
      paramDialogInterface.putExtra("url", this.jdField_a_of_type_JavaLangString);
      if ((!TextUtils.isEmpty(this.b)) && (this.b.equals("true")))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
          break label460;
        }
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "cmshow", "Apollo", "activity_alert_view", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType), 0, new String[] { "" + this.c, "0" });
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "cmshow", "Apollo", "participate", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType), 0, new String[] { "" + this.c });
        i = 9999;
        paramInt = 1;
      }
      while (paramInt != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity.startActivityForResult(paramDialogInterface, i);
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!TextUtils.isEmpty(this.d)))
        {
          if (this.d.equals(String.valueOf(9)))
          {
            ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity, this.c, this.e);
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "cmshow", "Apollo", "vip_alert_view", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType), 0, new String[] { "" + this.c, "0" });
            paramInt = 0;
            continue;
          }
          if (this.d.equals(String.valueOf(2))) {
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "cmshow", "Apollo", "debt_alert_clickcharge", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType), 0, new String[] { "" + this.c });
          }
        }
        paramInt = 1;
        continue;
        label460:
        i = 9999;
        paramInt = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anop
 * JD-Core Version:    0.7.0.1
 */