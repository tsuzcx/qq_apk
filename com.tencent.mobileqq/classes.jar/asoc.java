import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendBaseFragment;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import java.util.HashMap;

public class asoc
  implements bkzq
{
  public asoc(ExtendFriendBaseFragment paramExtendFriendBaseFragment, asnq paramasnq, boolean paramBoolean1, boolean paramBoolean2, RecyclerView.ViewHolder paramViewHolder) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      aaqo.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendBaseFragment.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Asnq.mUin, aaqo.b(this.jdField_a_of_type_Asnq.mUin, aaqo.b(2)), null, null, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendBaseFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 20005, null, null);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendBaseFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009C8F", "0X8009C8F", 0, 0, "", "", "", "");
      paramView = new HashMap();
      paramView.put("frompage", "3");
      paramView.put("to_uid", this.jdField_a_of_type_Asnq.mUin);
      UserAction.onUserActionToTunnel("0AND0Y11VZ3PFHQD", "click#complaint_page#complaint", true, -1L, -1L, paramView, true, true);
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendBaseFragment.jdField_a_of_type_Aslm != null) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendBaseFragment.jdField_a_of_type_Aslm.a(this.jdField_a_of_type_Asnq.mUin);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendBaseFragment.jdField_a_of_type_Bkzi != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendBaseFragment.jdField_a_of_type_Bkzi.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendBaseFragment.jdField_a_of_type_Bkzi = null;
      }
      return;
    }
    if ((this.jdField_a_of_type_Boolean) && (!this.b)) {
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendBaseFragment.a(false, true, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
        VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_actionsheet", "", 0, "", "1");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendBaseFragment.jdField_a_of_type_Bkzi.cancel();
      VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_actionsheet", "", 0, "", "4");
      return;
      if ((!this.jdField_a_of_type_Boolean) && (this.b))
      {
        if (paramInt == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendBaseFragment.a(true, false, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
          VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_actionsheet", "", 0, "", "2");
        }
      }
      else if ((this.b) && (this.jdField_a_of_type_Boolean))
      {
        if (paramInt == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendBaseFragment.a(false, true, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
          VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_actionsheet", "", 0, "", "1");
        }
        else if (paramInt == 2)
        {
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendBaseFragment.a(true, false, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
          VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_actionsheet", "", 0, "", "2");
        }
      }
      else if ((!this.jdField_a_of_type_Boolean) && (!this.b) && (paramInt == 1))
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendBaseFragment.a(false, false, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
        VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_actionsheet", "", 0, "", "3");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asoc
 * JD-Core Version:    0.7.0.1
 */