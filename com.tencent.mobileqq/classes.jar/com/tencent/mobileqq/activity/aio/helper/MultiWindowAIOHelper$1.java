package com.tencent.mobileqq.activity.aio.helper;

import affl;
import aulb;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;

public class MultiWindowAIOHelper$1
  implements Runnable
{
  public MultiWindowAIOHelper$1(affl paramaffl) {}
  
  public void run()
  {
    AIOLongShotHelper localAIOLongShotHelper = (AIOLongShotHelper)affl.a(this.this$0).a(15);
    if ((!BaseChatItemLayout.a) && (!localAIOLongShotHelper.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiWindowAIOHelper", 2, "AIO start multi window!");
      }
      aulb.a(affl.a(this.this$0).jdField_a_of_type_AndroidSupportV4AppFragmentActivity, affl.a(this.this$0).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, affl.a(this.this$0).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, affl.a(this.this$0).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, "open_from_aio");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.MultiWindowAIOHelper.1
 * JD-Core Version:    0.7.0.1
 */