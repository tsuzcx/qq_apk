package com.tencent.mobileqq.activity.aio.item;

import agnt;
import agnu;
import amtj;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.MessageForShortVideo;

public class ShortVideoItemBuilder$CompressUpdateListenerImpl$1
  implements Runnable
{
  public ShortVideoItemBuilder$CompressUpdateListenerImpl$1(agnt paramagnt, MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean, agnu paramagnu) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Agnu.a.setDrawStatus(1);
      this.jdField_a_of_type_Agnu.a.setAnimProgress(amtj.a(2131713186), str);
      this.jdField_a_of_type_Agnu.a.e = 10;
      this.jdField_a_of_type_Agnu.a.setVideoCompressStatus(true);
      return;
    }
    this.jdField_a_of_type_Agnu.a.a(str, 1.0F);
    this.jdField_a_of_type_Agnu.a.setAnimProgress(10, str);
    this.jdField_a_of_type_Agnu.a.setVideoCompressStatus(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.CompressUpdateListenerImpl.1
 * JD-Core Version:    0.7.0.1
 */