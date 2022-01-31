package com.tencent.mobileqq.activity.aio.rebuild;

import akhp;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class TroopChatPie$37
  implements Runnable
{
  TroopChatPie$37(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {}
    do
    {
      return;
      akhp localakhp = (akhp)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
      String str = this.this$0.a().jdField_a_of_type_JavaLangString;
      if (!TextUtils.isEmpty(str))
      {
        localakhp.t(str);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i(this.this$0.jdField_a_of_type_JavaLangString, 2, "mGetOnlineMemberTipsRunnable, getSessionInfo().curFriendUin == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.37
 * JD-Core Version:    0.7.0.1
 */