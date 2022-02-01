package com.tencent.mobileqq.activity.aio.item;

import ahen;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.qphone.base.util.QLog;
import wzk;

class QQStoryItemBuilder$7
  implements Runnable
{
  QQStoryItemBuilder$7(QQStoryItemBuilder paramQQStoryItemBuilder, String paramString, ahen paramahen, StoryVideoItem paramStoryVideoItem, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryItemBuilder", 2, "QQStoryItemBuilder handleGetVideo 3: fileName = " + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Ahen.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Ahen.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.b();
    this.jdField_a_of_type_Ahen.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setVisibility(8);
    wzk.a(this.jdField_a_of_type_Ahen.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalMaskPath, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOriginalMaskPicUrl, false, this.this$0.c, this.this$0.d);
    this.this$0.a(this.jdField_a_of_type_Ahen, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoWidth, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoHeight, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl, this.jdField_a_of_type_JavaLangString);
    this.this$0.b(this.jdField_a_of_type_Ahen, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, this.jdField_a_of_type_Boolean);
    this.this$0.c(this.jdField_a_of_type_Ahen, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, this.jdField_a_of_type_Boolean);
    QQStoryItemBuilder.a(this.this$0, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.7
 * JD-Core Version:    0.7.0.1
 */