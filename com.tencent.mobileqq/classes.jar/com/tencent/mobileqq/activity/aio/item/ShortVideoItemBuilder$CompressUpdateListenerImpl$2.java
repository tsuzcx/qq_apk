package com.tencent.mobileqq.activity.aio.item;

import ahqw;
import ahrg;
import ahrh;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.MessageForShortVideo;

public class ShortVideoItemBuilder$CompressUpdateListenerImpl$2
  implements Runnable
{
  public ShortVideoItemBuilder$CompressUpdateListenerImpl$2(ahrg paramahrg, MessageForShortVideo paramMessageForShortVideo, int paramInt) {}
  
  public void run()
  {
    ahrh localahrh = ahqw.a(this.jdField_a_of_type_Ahrg.a, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
    String str;
    if (localahrh != null)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq;
      if (this.jdField_a_of_type_Int == 1)
      {
        localahrh.a.a(str, 1.0F);
        localahrh.a.setAnimProgress(10, str);
        localahrh.a.setVideoCompressStatus(false);
      }
    }
    else
    {
      return;
    }
    localahrh.a.setVideoCompressPercent(str, 0.0F);
    localahrh.a.setVideoCompressStatus(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.CompressUpdateListenerImpl.2
 * JD-Core Version:    0.7.0.1
 */