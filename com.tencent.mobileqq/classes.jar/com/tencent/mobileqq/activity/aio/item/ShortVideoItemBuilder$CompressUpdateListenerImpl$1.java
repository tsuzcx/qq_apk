package com.tencent.mobileqq.activity.aio.item;

import ahhw;
import ahhx;
import anni;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.MessageForShortVideo;

public class ShortVideoItemBuilder$CompressUpdateListenerImpl$1
  implements Runnable
{
  public ShortVideoItemBuilder$CompressUpdateListenerImpl$1(ahhw paramahhw, MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean, ahhx paramahhx) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Ahhx.a.setDrawStatus(1);
      this.jdField_a_of_type_Ahhx.a.setAnimProgress(anni.a(2131712845), str);
      this.jdField_a_of_type_Ahhx.a.e = 10;
      this.jdField_a_of_type_Ahhx.a.setVideoCompressStatus(true);
      return;
    }
    this.jdField_a_of_type_Ahhx.a.a(str, 1.0F);
    this.jdField_a_of_type_Ahhx.a.setAnimProgress(10, str);
    this.jdField_a_of_type_Ahhx.a.setVideoCompressStatus(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.CompressUpdateListenerImpl.1
 * JD-Core Version:    0.7.0.1
 */