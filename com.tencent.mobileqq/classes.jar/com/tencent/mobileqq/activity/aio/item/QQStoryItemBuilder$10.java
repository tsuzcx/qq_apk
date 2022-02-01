package com.tencent.mobileqq.activity.aio.item;

import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.qphone.base.util.QLog;

class QQStoryItemBuilder$10
  implements Runnable
{
  QQStoryItemBuilder$10(QQStoryItemBuilder paramQQStoryItemBuilder, QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, long paramLong) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.share", 2, "showPlayIcon");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$QQStoryMsgHolder == null) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.share", 2, "showPlayIcon: holder == null");
      }
    }
    Long localLong;
    do
    {
      return;
      localLong = (Long)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$QQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.getTag();
    } while ((localLong == null) || (localLong.longValue() != this.jdField_a_of_type_Long));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$QQStoryMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(2);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$QQStoryMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.10
 * JD-Core Version:    0.7.0.1
 */