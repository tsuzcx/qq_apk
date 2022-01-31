package com.tencent.mobileqq.activity.aio.item;

import adzf;
import adzp;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.MessageForShortVideo;

public class ShortVideoItemBuilder$4
  implements Runnable
{
  public ShortVideoItemBuilder$4(adzf paramadzf, MessageForShortVideo paramMessageForShortVideo, int paramInt) {}
  
  public void run()
  {
    adzp localadzp = adzf.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
    String str;
    if (localadzp != null)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq;
      if (this.jdField_a_of_type_Int == 1)
      {
        localadzp.a.a(str, 1.0F);
        localadzp.a.setAnimProgress(10, str);
        localadzp.a.setVideoCompressStatus(false);
      }
    }
    else
    {
      return;
    }
    localadzp.a.setVideoCompressPercent(str, 0.0F);
    localadzp.a.setVideoCompressStatus(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */