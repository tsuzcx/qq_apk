package com.tencent.mobileqq.activity.aio.item;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils.VideoInfoObserver;
import com.tencent.qphone.base.util.QLog;

class QQStoryItemBuilder$9
  extends PlayModeUtils.VideoInfoObserver
{
  QQStoryItemBuilder$9(QQStoryItemBuilder paramQQStoryItemBuilder, QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, long paramLong, boolean paramBoolean) {}
  
  public void a(int paramInt, String paramString, StoryVideoItem paramStoryVideoItem)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("QQStoryItemBuilder requestVideoInfo: errorCode = ");
      paramString.append(paramInt);
      paramString.append(", storyVideoItem = ");
      paramString.append(paramStoryVideoItem);
      QLog.d("Q.qqstory.share", 2, paramString.toString());
    }
    if ((paramInt == 0) && (paramStoryVideoItem != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$QQStoryMsgHolder, this.jdField_b_of_type_Long, paramStoryVideoItem, this.jdField_b_of_type_Boolean);
      return;
    }
    if (paramInt == 10100)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QQStoryItemBuilder", 2, "onGetVideo video has deleted");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$QQStoryMsgHolder, this.jdField_b_of_type_Long);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("QQStoryItemBuilder", 2, "onGetVideo video error");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$QQStoryMsgHolder, this.jdField_b_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.9
 * JD-Core Version:    0.7.0.1
 */