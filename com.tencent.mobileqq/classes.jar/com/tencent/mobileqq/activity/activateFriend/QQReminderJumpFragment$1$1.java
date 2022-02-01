package com.tencent.mobileqq.activity.activateFriend;

import android.app.Activity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.reminder.biz.entity.CalendarEntity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class QQReminderJumpFragment$1$1
  implements Runnable
{
  QQReminderJumpFragment$1$1(QQReminderJumpFragment.1 param1, List paramList) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQReminderJumpFragment$1.this$0.getQBaseActivity();
      List localList = this.jdField_a_of_type_JavaUtilList;
      QQNotifyUtils.a((Activity)localObject, (CalendarEntity)localList.get(localList.size() - 1));
    }
    else
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQReminderJumpFragment$1.this$0.getQBaseActivity(), 1, HardCodeUtil.a(2131699838), 0).a();
      QLog.e("QQReminderJumpFragment", 1, new Object[] { "get msgid: ", this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQReminderJumpFragment$1.a, " res is null" });
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQReminderJumpFragment$1.this$0.getQBaseActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQReminderJumpFragment.1.1
 * JD-Core Version:    0.7.0.1
 */