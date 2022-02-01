package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.multiaio.MultiAIOStarter;
import com.tencent.qphone.base.util.QLog;

class MultiWindowAIOHelper$1
  implements Runnable
{
  MultiWindowAIOHelper$1(MultiWindowAIOHelper paramMultiWindowAIOHelper) {}
  
  public void run()
  {
    AIOLongShotHelper localAIOLongShotHelper = (AIOLongShotHelper)MultiWindowAIOHelper.a(this.this$0).a(15);
    if ((!BaseChatItemLayout.a) && (!localAIOLongShotHelper.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiWindowAIOHelper", 2, "AIO start multi window!");
      }
      MultiAIOStarter.a(MultiWindowAIOHelper.a(this.this$0).jdField_a_of_type_AndroidSupportV4AppFragmentActivity, MultiWindowAIOHelper.a(this.this$0).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, MultiWindowAIOHelper.a(this.this$0).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, MultiWindowAIOHelper.a(this.this$0).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, "open_from_aio");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.MultiWindowAIOHelper.1
 * JD-Core Version:    0.7.0.1
 */