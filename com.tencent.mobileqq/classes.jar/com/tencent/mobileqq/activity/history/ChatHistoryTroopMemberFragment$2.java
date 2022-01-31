package com.tencent.mobileqq.activity.history;

import ajjj;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import babl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ChatHistoryTroopMemberFragment$2
  implements Runnable
{
  ChatHistoryTroopMemberFragment$2(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment, Intent paramIntent, ajjj paramajjj, TroopManager paramTroopManager) {}
  
  public void run()
  {
    boolean bool2 = false;
    ??? = "";
    int i;
    if (this.jdField_a_of_type_AndroidContentIntent != null)
    {
      i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("memberOperationFlag", 0);
      ??? = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("memberOperateUin");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "onActivityResult, REQUEST_CODE_SHOW_MEMBER_CARD, optFlg=" + i + ", optUin=" + (String)???);
      }
      if ((i & 0x1) != 0)
      {
        this.this$0.a((String)???);
        if (((i & 0x4) != 0) && (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null))
        {
          this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(this.this$0.c);
          ??? = this.this$0;
          if ((this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) || (!this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isHomeworkTroop())) {
            break label514;
          }
        }
      }
      label514:
      for (boolean bool1 = true;; bool1 = false) {
        for (;;)
        {
          ((ChatHistoryTroopMemberFragment)???).e = bool1;
          if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
          {
            if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin != null) {
              this.this$0.f = this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin;
            }
            if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator != null) {
              this.this$0.g = this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator;
            }
            ??? = this.this$0;
            if ((this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin == null) || (!this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin.equals(this.this$0.getActivity().app.getCurrentAccountUin())))
            {
              bool1 = bool2;
              if (this.this$0.g != null)
              {
                bool1 = bool2;
                if (!this.this$0.g.contains(this.this$0.getActivity().app.getCurrentAccountUin())) {}
              }
            }
            else
            {
              bool1 = true;
            }
            ((ChatHistoryTroopMemberFragment)???).d = bool1;
            if (QLog.isColorLevel()) {
              QLog.d("Q.history.BaseFragment", 2, "onActivityResult, REQUEST_CODE_SHOW_MEMBER_CARD, admins:" + this.this$0.g + " owner:" + this.this$0.f);
            }
          }
          if ((i != 0) && (this.this$0.jdField_a_of_type_Afow != null)) {
            this.this$0.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(9);
          }
          return;
          if ((i & 0x2) == 0) {
            break;
          }
          Object localObject2 = babl.a().a(this.this$0.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.c, (String)???);
          if ((localObject2 == null) || (this.jdField_a_of_type_Ajjj == null)) {
            break;
          }
          this.this$0.a((String)???);
          synchronized (this.this$0)
          {
            localObject2 = this.this$0.a((TroopMemberInfo)localObject2, this.jdField_a_of_type_Ajjj);
            this.this$0.jdField_a_of_type_JavaUtilList.add(localObject2);
          }
        }
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.2
 * JD-Core Version:    0.7.0.1
 */