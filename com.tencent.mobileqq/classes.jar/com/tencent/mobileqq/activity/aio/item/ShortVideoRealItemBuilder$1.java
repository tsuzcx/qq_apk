package com.tencent.mobileqq.activity.aio.item;

import adpi;
import com.tencent.mobileqq.data.MessageForShortVideo;

class ShortVideoRealItemBuilder$1
  implements Runnable
{
  ShortVideoRealItemBuilder$1(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder, MessageForShortVideo paramMessageForShortVideo, adpi paramadpi) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.progress <= 0) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.progress = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress;
    }
    this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, this.jdField_a_of_type_Adpi, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.progress);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */