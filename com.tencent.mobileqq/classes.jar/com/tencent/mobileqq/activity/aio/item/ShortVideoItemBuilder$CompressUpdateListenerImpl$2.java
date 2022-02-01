package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.MessageForShortVideo;

class ShortVideoItemBuilder$CompressUpdateListenerImpl$2
  implements Runnable
{
  ShortVideoItemBuilder$CompressUpdateListenerImpl$2(ShortVideoItemBuilder.CompressUpdateListenerImpl paramCompressUpdateListenerImpl, MessageForShortVideo paramMessageForShortVideo, int paramInt) {}
  
  public void run()
  {
    ShortVideoItemBuilder.Holder localHolder = ShortVideoItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$CompressUpdateListenerImpl.a, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
    String str;
    if (localHolder != null)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq;
      if (this.jdField_a_of_type_Int == 1)
      {
        localHolder.a.a(str, 1.0F);
        localHolder.a.setAnimProgress(10, str);
        localHolder.a.setVideoCompressStatus(false);
      }
    }
    else
    {
      return;
    }
    localHolder.a.setVideoCompressPercent(str, 0.0F);
    localHolder.a.setVideoCompressStatus(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.CompressUpdateListenerImpl.2
 * JD-Core Version:    0.7.0.1
 */