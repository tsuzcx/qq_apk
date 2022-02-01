package com.tencent.mobileqq.activity.history;

import android.app.Dialog;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class ChatHistoryTroopMemberFragment$34
  extends Handler
{
  ChatHistoryTroopMemberFragment$34(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.getBaseActivity() != null)
    {
      if (this.a.getBaseActivity().isFinishing()) {
        return;
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("handleMessage,msg.what:");
        ((StringBuilder)???).append(paramMessage.what);
        QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)???).toString());
      }
      int i = paramMessage.what;
      boolean bool2 = true;
      double d1;
      double d2;
      int j;
      boolean bool1;
      switch (i)
      {
      case 3: 
      case 4: 
      case 10: 
      default: 
      case 15: 
        if ((this.a.jdField_c_of_type_AndroidAppDialog != null) && (this.a.jdField_c_of_type_AndroidAppDialog.isShowing()))
        {
          this.a.jdField_c_of_type_AndroidAppDialog.dismiss();
          return;
        }
        break;
      case 14: 
        this.a.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        return;
      case 13: 
        paramMessage = this.a;
        paramMessage.jdField_a_of_type_Double += ChatHistoryTroopMemberFragment.jdField_b_of_type_Double;
        if ((this.a.jdField_a_of_type_Double > this.a.jdField_a_of_type_AndroidWidgetProgressBar.getProgress()) && (this.a.jdField_a_of_type_Double < 90.0D) && (ChatHistoryTroopMemberFragment.a(this.a) > 0))
        {
          i = (int)this.a.jdField_a_of_type_Double;
          d1 = ChatHistoryTroopMemberFragment.a(this.a);
          d2 = this.a.jdField_a_of_type_Double;
          Double.isNaN(d1);
          j = (int)(d1 * d2 / 100.0D);
          paramMessage = this.a;
          ChatHistoryTroopMemberFragment.a(paramMessage, j, ChatHistoryTroopMemberFragment.a(paramMessage), i);
          this.a.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(this.a.jdField_b_of_type_AndroidOsHandler.obtainMessage(13), 800L);
          return;
        }
        break;
      case 12: 
        synchronized (this.a)
        {
          ChatHistoryTroopMemberFragment.b(this.a);
          Object localObject2 = (List)paramMessage.obj;
          if ((localObject2 == null) && (this.a.jdField_d_of_type_Int != 14)) {
            return;
          }
          if (this.a.jdField_d_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)
          {
            this.a.jdField_b_of_type_AndroidOsHandler.removeMessages(13);
            i = paramMessage.arg1;
            d1 = i;
            Double.isNaN(d1);
            i = ChatHistoryTroopMemberFragment.a(this.a);
            d2 = i;
            Double.isNaN(d2);
            d1 = d1 * 1.0D / d2;
            d1 = Math.min(d1 + 0.9D, 1.0D);
            i = (int)(100.0D * d1);
            if (i > this.a.jdField_a_of_type_AndroidWidgetProgressBar.getProgress())
            {
              j = ChatHistoryTroopMemberFragment.a(this.a);
              d2 = j;
              Double.isNaN(d2);
              j = (int)(d2 * d1);
              ChatHistoryTroopMemberFragment.a(this.a, j, ChatHistoryTroopMemberFragment.a(this.a), i);
            }
          }
          if (localObject2 != null) {
            this.a.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject2);
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("handleMessage, mJobCount left:");
            ((StringBuilder)localObject2).append(ChatHistoryTroopMemberFragment.c(this.a));
            ((StringBuilder)localObject2).append("mATroopMemberList.size():");
            ((StringBuilder)localObject2).append(this.a.jdField_a_of_type_JavaUtilList.size());
            QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject2).toString());
          }
          if (ChatHistoryTroopMemberFragment.c(this.a) <= 0) {
            ChatHistoryTroopMemberFragment.b(this.a, true);
          }
          if ((ChatHistoryTroopMemberFragment.b(this.a)) && (ChatHistoryTroopMemberFragment.d(this.a)))
          {
            if (this.a.jdField_a_of_type_JavaUtilList.isEmpty()) {
              return;
            }
            this.a.z();
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("handleMessage real totalTime:");
              ((StringBuilder)localObject2).append(System.currentTimeMillis() - ChatHistoryTroopMemberFragment.a(this.a));
              ((StringBuilder)localObject2).append("start refreshUI");
              QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject2).toString());
            }
            if (this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager() != null) {
              this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().notifyRefreshTroopMember();
            }
            paramMessage.obj = this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.a();
            ChatHistoryTroopMemberFragment.a(this.a, paramMessage);
          }
          return;
        }
      case 11: 
        paramMessage = (TroopInfo)paramMessage.obj;
        if (paramMessage.troopowneruin != null) {
          this.a.f = paramMessage.troopowneruin;
        }
        if (paramMessage.Administrator != null) {
          this.a.g = paramMessage.Administrator;
        }
        ??? = this.a;
        bool1 = bool2;
        if (!((ChatHistoryTroopMemberFragment)???).jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramMessage.troopowneruin)) {
          if ((this.a.g != null) && (this.a.g.contains(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
        }
        ((ChatHistoryTroopMemberFragment)???).jdField_d_of_type_Boolean = bool1;
        if ((this.a.f != null) && (this.a.f.equals(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
          this.a.o = "0";
        } else if ((this.a.g != null) && (this.a.g.contains(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
          this.a.o = "1";
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter != null)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.a();
          return;
        }
        break;
      case 9: 
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter != null)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.a();
          return;
        }
        break;
      case 8: 
        paramMessage = (Object[])paramMessage.obj;
        bool1 = ((Boolean)paramMessage[0]).booleanValue();
        paramMessage = (ArrayList)paramMessage[1];
        ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).inviteMember(this.a.getActivity(), this.a.jdField_c_of_type_JavaLangString, bool1, paramMessage, 1);
        return;
      case 7: 
        if ((this.a.jdField_c_of_type_AndroidAppDialog != null) && (this.a.jdField_c_of_type_AndroidAppDialog.isShowing())) {
          this.a.jdField_c_of_type_AndroidAppDialog.dismiss();
        }
        QQToast.a(this.a.getBaseActivity(), this.a.getString(2131691473), 0).b(this.a.jdField_b_of_type_AndroidViewView.getHeight());
        return;
      case 6: 
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter != null)
        {
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.b != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.b.clear();
          }
          this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.a();
        }
        if ((this.a.jdField_c_of_type_AndroidAppDialog != null) && (this.a.jdField_c_of_type_AndroidAppDialog.isShowing())) {
          this.a.jdField_c_of_type_AndroidAppDialog.dismiss();
        }
        QQToast.a(this.a.getBaseActivity(), this.a.getString(2131691474), 0).b(this.a.jdField_b_of_type_AndroidViewView.getHeight());
        ChatHistoryTroopMemberFragment.a(this.a);
        return;
      case 5: 
        this.a.z();
        return;
      case 2: 
        this.a.z();
      case 1: 
        ChatHistoryTroopMemberFragment.a(this.a, paramMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.34
 * JD-Core Version:    0.7.0.1
 */