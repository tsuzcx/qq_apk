package com.tencent.mobileqq.apollo.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatCenterManager;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class HotChatCenterFragment$8
  implements DialogInterface.OnClickListener
{
  HotChatCenterFragment$8(HotChatCenterFragment paramHotChatCenterFragment, HotChatInfo paramHotChatInfo, String paramString1, RecentBaseData paramRecentBaseData, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isWifiHotChat)
    {
      paramInt = 1;
      ReportController.b(HotChatCenterFragment.a(this.jdField_a_of_type_ComTencentMobileqqApolloActivityHotChatCenterFragment), "CliOper", "", "", "0X8004D2C", "0X8004D2C", paramInt, 0, "", "", "", "");
      if ((!this.jdField_a_of_type_ComTencentMobileqqApolloActivityHotChatCenterFragment.isAdded()) || (NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqApolloActivityHotChatCenterFragment.getActivity().getApplicationContext()))) {
        break label98;
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqApolloActivityHotChatCenterFragment.getActivity().getApplicationContext(), HardCodeUtil.a(2131705568), 0).b(0);
    }
    label98:
    do
    {
      return;
      paramInt = 2;
      break;
      ((HotChatHandler)HotChatCenterFragment.a(this.jdField_a_of_type_ComTencentMobileqqApolloActivityHotChatCenterFragment).getBusinessHandler(BusinessHandlerFactory.HOT_CHAT_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL);
      if (HotChatCenterFragment.a(this.jdField_a_of_type_ComTencentMobileqqApolloActivityHotChatCenterFragment).get() != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HotchatActivity", 2, "remove");
        }
        ((HotChatCenterManager)HotChatCenterFragment.a(this.jdField_a_of_type_ComTencentMobileqqApolloActivityHotChatCenterFragment).get()).b(this.jdField_a_of_type_JavaLangString);
      }
    } while (HotChatCenterFragment.a(this.jdField_a_of_type_ComTencentMobileqqApolloActivityHotChatCenterFragment) == null);
    ((HotChatCenterFragment.HotCenterAdapter)HotChatCenterFragment.a(this.jdField_a_of_type_ComTencentMobileqqApolloActivityHotChatCenterFragment)).b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.activity.HotChatCenterFragment.8
 * JD-Core Version:    0.7.0.1
 */