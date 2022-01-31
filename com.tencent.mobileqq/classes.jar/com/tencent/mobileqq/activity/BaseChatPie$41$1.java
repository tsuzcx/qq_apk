package com.tencent.mobileqq.activity;

import aelz;
import bblx;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$41$1
  implements Runnable
{
  BaseChatPie$41$1(BaseChatPie.41 param41, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie$41.this$0.a().isFinishing()) {}
    int i;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie$41.jdField_a_of_type_Int > 200));
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie$41.this$0.jdField_a_of_type_JavaLangString + ".troop.special_msg", 2, "refreshHeadMessage==>fistseq:" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie$41.jdField_b_of_type_Long + ", mr.shmsgseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq);
      }
      if ((int)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie$41.jdField_b_of_type_Long >= this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq + 1L)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie$41.this$0.jdField_a_of_type_Bblx != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie$41.this$0.jdField_a_of_type_Bblx.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie$41.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq, false);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie$41.jdField_b_of_type_Int == 5) {
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie$41.this$0.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie$41.this$0.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie$41.jdField_b_of_type_Int, 0, -1, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie$41.jdField_a_of_type_JavaLangRunnable, 6);
        return;
      }
      i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie$41.this$0.jdField_a_of_type_Aelz.a((ChatMessage)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    } while (i == -1);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie$41.this$0.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie$41.jdField_b_of_type_Int, i, i, null, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.41.1
 * JD-Core Version:    0.7.0.1
 */