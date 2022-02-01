package com.tencent.mobileqq.activity.aio.item;

import ahhm;
import ahhw;
import ahhx;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.MessageForShortVideo;

public class ShortVideoItemBuilder$CompressUpdateListenerImpl$2
  implements Runnable
{
  public ShortVideoItemBuilder$CompressUpdateListenerImpl$2(ahhw paramahhw, MessageForShortVideo paramMessageForShortVideo, int paramInt) {}
  
  public void run()
  {
    ahhx localahhx = ahhm.a(this.jdField_a_of_type_Ahhw.a, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
    String str;
    if (localahhx != null)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq;
      if (this.jdField_a_of_type_Int == 1)
      {
        localahhx.a.a(str, 1.0F);
        localahhx.a.setAnimProgress(10, str);
        localahhx.a.setVideoCompressStatus(false);
      }
    }
    else
    {
      return;
    }
    localahhx.a.setVideoCompressPercent(str, 0.0F);
    localahhx.a.setVideoCompressStatus(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.CompressUpdateListenerImpl.2
 * JD-Core Version:    0.7.0.1
 */