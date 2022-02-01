package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsGetMsgListRsp;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;

class ReminderListFragment$9
  implements BusinessObserver
{
  ReminderListFragment$9(ReminderListFragment paramReminderListFragment, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 2000)
    {
      if (paramBoolean)
      {
        paramBundle = (AcsGetMsgListRsp)paramBundle.getSerializable("rsp");
        Object localObject1;
        Object localObject2;
        if (paramBundle != null)
        {
          localObject1 = paramBundle.data_list;
          localObject2 = new ArrayList();
          if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
          {
            ReminderListFragment localReminderListFragment = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment;
            ReminderListFragment.a(localReminderListFragment, ReminderListFragment.a(localReminderListFragment) + ((ArrayList)localObject1).size());
            paramInt = ReminderListFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment);
            int i = paramBundle.total;
            paramBoolean = false;
            if (paramInt >= i)
            {
              ReminderListFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment, false);
            }
            else
            {
              ReminderListFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment, true);
              ReminderListFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment);
            }
            localReminderListFragment = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment;
            if (this.jdField_a_of_type_Int == 0) {
              paramBoolean = true;
            }
            ReminderListFragment.a(localReminderListFragment, (ArrayList)localObject1, (ArrayList)localObject2, paramBoolean);
          }
          else
          {
            ReminderListFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment);
          }
        }
        else
        {
          ReminderListFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment);
        }
        if (QLog.isColorLevel())
        {
          localObject1 = ReminderListFragment.a();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("acsGetMsgListRsp: ");
          ((StringBuilder)localObject2).append(paramBundle);
          ((StringBuilder)localObject2).append(" ");
          QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
      }
      else
      {
        ReminderListFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment, HardCodeUtil.a(2131713312));
      }
      ReminderListFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment).post(new ReminderListFragment.9.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.9
 * JD-Core Version:    0.7.0.1
 */