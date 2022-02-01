package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class DefaultHeadMsgRefresher$1$1
  implements Runnable
{
  DefaultHeadMsgRefresher$1$1(DefaultHeadMsgRefresher.1 param1, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    Scroller localScroller = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildMsglistDefaultHeadMsgRefresher$1.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildMsglistDefaultHeadMsgRefresher$1.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().isFinishing()) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildMsglistDefaultHeadMsgRefresher$1.jdField_a_of_type_Int <= 200))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("refreshHeadMessage==>fistseq:");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildMsglistDefaultHeadMsgRefresher$1.jdField_b_of_type_Long);
        localStringBuilder.append(", mr.shmsgseq:");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq);
        QLog.d("DefaultHeadMsgRefresher.troop.special_msg", 2, localStringBuilder.toString());
      }
      if ((int)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildMsglistDefaultHeadMsgRefresher$1.jdField_b_of_type_Long >= this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq + 1L)
      {
        localScroller.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildMsglistDefaultHeadMsgRefresher$1.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq, false);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildMsglistDefaultHeadMsgRefresher$1.jdField_b_of_type_Int == 5) {
          localScroller.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
        }
        localScroller.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildMsglistDefaultHeadMsgRefresher$1.jdField_b_of_type_Int, 0, -1, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildMsglistDefaultHeadMsgRefresher$1.jdField_a_of_type_JavaLangRunnable, 6);
        return;
      }
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildMsglistDefaultHeadMsgRefresher$1.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a((ChatMessage)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      if (i != -1) {
        localScroller.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildMsglistDefaultHeadMsgRefresher$1.jdField_b_of_type_Int, i, i, null, 6);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.DefaultHeadMsgRefresher.1.1
 * JD-Core Version:    0.7.0.1
 */