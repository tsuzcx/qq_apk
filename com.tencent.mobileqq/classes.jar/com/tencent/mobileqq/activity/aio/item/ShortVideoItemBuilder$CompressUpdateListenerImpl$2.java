package com.tencent.mobileqq.activity.aio.item;

import ahfz;
import ahgj;
import ahgk;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.MessageForShortVideo;

public class ShortVideoItemBuilder$CompressUpdateListenerImpl$2
  implements Runnable
{
  public ShortVideoItemBuilder$CompressUpdateListenerImpl$2(ahgj paramahgj, MessageForShortVideo paramMessageForShortVideo, int paramInt) {}
  
  public void run()
  {
    ahgk localahgk = ahfz.a(this.jdField_a_of_type_Ahgj.a, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
    String str;
    if (localahgk != null)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq;
      if (this.jdField_a_of_type_Int == 1)
      {
        localahgk.a.a(str, 1.0F);
        localahgk.a.setAnimProgress(10, str);
        localahgk.a.setVideoCompressStatus(false);
      }
    }
    else
    {
      return;
    }
    localahgk.a.setVideoCompressPercent(str, 0.0F);
    localahgk.a.setVideoCompressStatus(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.CompressUpdateListenerImpl.2
 * JD-Core Version:    0.7.0.1
 */