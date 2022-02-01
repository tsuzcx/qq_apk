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
    boolean bool = true;
    if (paramInt == 2000)
    {
      if (!paramBoolean) {
        break label228;
      }
      paramBundle = (AcsGetMsgListRsp)paramBundle.getSerializable("rsp");
      if (paramBundle == null) {
        break label218;
      }
      ArrayList localArrayList1 = paramBundle.data_list;
      ArrayList localArrayList2 = new ArrayList();
      if ((localArrayList1 == null) || (localArrayList1.isEmpty())) {
        break label208;
      }
      ReminderListFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment, ReminderListFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment) + localArrayList1.size());
      if (ReminderListFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment) < paramBundle.total) {
        break label183;
      }
      ReminderListFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment, false);
      ReminderListFragment localReminderListFragment = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment;
      if (this.jdField_a_of_type_Int != 0) {
        break label203;
      }
      paramBoolean = bool;
      label116:
      ReminderListFragment.a(localReminderListFragment, localArrayList1, localArrayList2, paramBoolean);
      label126:
      if (QLog.isColorLevel()) {
        QLog.i(ReminderListFragment.a(), 2, "acsGetMsgListRsp: " + paramBundle + " ");
      }
    }
    for (;;)
    {
      ReminderListFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment).post(new ReminderListFragment.9.1(this));
      return;
      label183:
      ReminderListFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment, true);
      ReminderListFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment);
      break;
      label203:
      paramBoolean = false;
      break label116;
      label208:
      ReminderListFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment);
      break label126;
      label218:
      ReminderListFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment);
      break label126;
      label228:
      ReminderListFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment, HardCodeUtil.a(2131713344));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.9
 * JD-Core Version:    0.7.0.1
 */