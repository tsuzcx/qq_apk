package com.tencent.mobileqq.activity.aio.item;

import adzh;
import adzr;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.MessageForShortVideo;

public class ShortVideoItemBuilder$4
  implements Runnable
{
  public ShortVideoItemBuilder$4(adzh paramadzh, MessageForShortVideo paramMessageForShortVideo, int paramInt) {}
  
  public void run()
  {
    adzr localadzr = adzh.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
    String str;
    if (localadzr != null)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq;
      if (this.jdField_a_of_type_Int == 1)
      {
        localadzr.a.a(str, 1.0F);
        localadzr.a.setAnimProgress(10, str);
        localadzr.a.setVideoCompressStatus(false);
      }
    }
    else
    {
      return;
    }
    localadzr.a.setVideoCompressPercent(str, 0.0F);
    localadzr.a.setVideoCompressStatus(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */