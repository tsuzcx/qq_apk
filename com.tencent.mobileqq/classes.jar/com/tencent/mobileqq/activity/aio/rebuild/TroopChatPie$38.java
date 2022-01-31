package com.tencent.mobileqq.activity.aio.rebuild;

import aejb;
import ajtg;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class TroopChatPie$38
  implements Runnable
{
  public TroopChatPie$38(aejb paramaejb) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {}
    do
    {
      return;
      ajtg localajtg = (ajtg)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
      String str = this.this$0.a().jdField_a_of_type_JavaLangString;
      if (!TextUtils.isEmpty(str))
      {
        localajtg.t(str);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i(this.this$0.jdField_a_of_type_JavaLangString, 2, "mGetOnlineMemberTipsRunnable, getSessionInfo().curFriendUin == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.38
 * JD-Core Version:    0.7.0.1
 */