package com.tencent.mobileqq.activity.aio.item;

import agnj;
import agnt;
import agnu;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.MessageForShortVideo;

public class ShortVideoItemBuilder$CompressUpdateListenerImpl$2
  implements Runnable
{
  public ShortVideoItemBuilder$CompressUpdateListenerImpl$2(agnt paramagnt, MessageForShortVideo paramMessageForShortVideo, int paramInt) {}
  
  public void run()
  {
    agnu localagnu = agnj.a(this.jdField_a_of_type_Agnt.a, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
    String str;
    if (localagnu != null)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq;
      if (this.jdField_a_of_type_Int == 1)
      {
        localagnu.a.a(str, 1.0F);
        localagnu.a.setAnimProgress(10, str);
        localagnu.a.setVideoCompressStatus(false);
      }
    }
    else
    {
      return;
    }
    localagnu.a.setVideoCompressPercent(str, 0.0F);
    localagnu.a.setVideoCompressStatus(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.CompressUpdateListenerImpl.2
 * JD-Core Version:    0.7.0.1
 */