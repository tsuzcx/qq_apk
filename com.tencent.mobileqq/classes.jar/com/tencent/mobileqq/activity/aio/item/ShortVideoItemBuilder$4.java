package com.tencent.mobileqq.activity.aio.item;

import agai;
import agas;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.MessageForShortVideo;

public class ShortVideoItemBuilder$4
  implements Runnable
{
  public ShortVideoItemBuilder$4(agai paramagai, MessageForShortVideo paramMessageForShortVideo, int paramInt) {}
  
  public void run()
  {
    agas localagas = agai.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
    String str;
    if (localagas != null)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq;
      if (this.jdField_a_of_type_Int == 1)
      {
        localagas.a.a(str, 1.0F);
        localagas.a.setAnimProgress(10, str);
        localagas.a.setVideoCompressStatus(false);
      }
    }
    else
    {
      return;
    }
    localagas.a.setVideoCompressPercent(str, 0.0F);
    localagas.a.setVideoCompressStatus(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */