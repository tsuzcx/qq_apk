package com.tencent.mobileqq.activity.aio.item;

import admv;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;

class QQStoryItemBuilder$6
  implements Runnable
{
  QQStoryItemBuilder$6(QQStoryItemBuilder paramQQStoryItemBuilder, admv paramadmv, long paramLong, StoryVideoItem paramStoryVideoItem) {}
  
  public void run()
  {
    Long localLong = (Long)this.jdField_a_of_type_Admv.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.getTag();
    if ((localLong == null) || (localLong.longValue() != this.jdField_a_of_type_Long)) {
      return;
    }
    this.jdField_a_of_type_Admv.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(2);
    this.jdField_a_of_type_Admv.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setVisibility(0);
    QQStoryItemBuilder.a(this.jdField_a_of_type_Admv.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl, this.this$0.c, this.this$0.d, this.this$0.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.6
 * JD-Core Version:    0.7.0.1
 */