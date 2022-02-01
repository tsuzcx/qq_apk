package com.tencent.mobileqq.activity.aio.item;

import android.widget.TextView;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.MessageProgressView;

class ShortVideoRealItemBuilder$10$1
  implements Runnable
{
  ShortVideoRealItemBuilder$10$1(ShortVideoRealItemBuilder.10 param10) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.progress <= 0) {
      this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.progress = this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress;
    }
    if ((ShortVideoUtils.getDisplayProgress(this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress, 10) > 60) || (this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.progress > 60))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(60, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin + this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$Holder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.a.this$0.a(this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$Holder, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.progress);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.10.1
 * JD-Core Version:    0.7.0.1
 */