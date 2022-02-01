package com.tencent.mobileqq.activity.contact.newfriend;

import android.view.View;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AddRequestSuspiciousMsgFragment$2
  implements ActionSheet.OnButtonClickListener
{
  AddRequestSuspiciousMsgFragment$2(AddRequestSuspiciousMsgFragment paramAddRequestSuspiciousMsgFragment, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendAddRequestSuspiciousMsgFragment.getActivity())) {
        NewReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendAddRequestSuspiciousMsgFragment.getActivity(), AddRequestSuspiciousMsgFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendAddRequestSuspiciousMsgFragment).uin + "", null, AddRequestSuspiciousMsgFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendAddRequestSuspiciousMsgFragment).getCurrentAccountUin(), 20010, null);
      } else {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendAddRequestSuspiciousMsgFragment.getActivity(), 2131694459, 0).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.AddRequestSuspiciousMsgFragment.2
 * JD-Core Version:    0.7.0.1
 */