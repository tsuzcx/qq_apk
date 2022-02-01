package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import android.support.v4.app.FragmentActivity;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

class DefaultHeadMsgRefresher$1
  implements Runnable
{
  DefaultHeadMsgRefresher$1(DefaultHeadMsgRefresher paramDefaultHeadMsgRefresher, AIOContext paramAIOContext, long paramLong1, int paramInt1, long paramLong2, int paramInt2, Runnable paramRunnable) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new DefaultHeadMsgRefresher.1.1(this, localMessageRecord));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.DefaultHeadMsgRefresher.1
 * JD-Core Version:    0.7.0.1
 */