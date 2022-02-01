package com.tencent.mobileqq.activity.aio.item;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.qphone.base.util.QLog;

class QQStoryItemBuilder$4
  extends QQStoryItemBuilder.AIOStoryDownloadListener
{
  QQStoryItemBuilder$4(QQStoryItemBuilder paramQQStoryItemBuilder) {}
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryItemBuilder", 2, "get video download finish,vid=" + paramString1);
    }
    if (!paramString1.equals(this.jdField_a_of_type_JavaLangString)) {}
    do
    {
      return;
      paramString1 = ((StoryManager)SuperManager.a(5)).a(paramString1);
      if (paramString1 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("QQStoryItemBuilder", 2, "get video download finish, storyVideoItem == null");
    return;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$QQStoryMsgHolder, this.jdField_a_of_type_Long, paramString1, false);
  }
  
  public void a(String paramString1, String paramString2, ErrorMessage paramErrorMessage, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQStoryItemBuilder", 2, "Download video failed,vid=" + paramString1);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$QQStoryMsgHolder, this.jdField_a_of_type_Long);
  }
  
  public void b(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQStoryItemBuilder", 2, "Download video onPause,vid=" + paramString1);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$QQStoryMsgHolder, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */