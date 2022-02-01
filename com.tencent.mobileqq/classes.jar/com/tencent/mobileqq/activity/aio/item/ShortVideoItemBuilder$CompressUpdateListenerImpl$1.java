package com.tencent.mobileqq.activity.aio.item;

import ahrg;
import ahrh;
import anzj;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.MessageForShortVideo;

public class ShortVideoItemBuilder$CompressUpdateListenerImpl$1
  implements Runnable
{
  public ShortVideoItemBuilder$CompressUpdateListenerImpl$1(ahrg paramahrg, MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean, ahrh paramahrh) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Ahrh.a.setDrawStatus(1);
      this.jdField_a_of_type_Ahrh.a.setAnimProgress(anzj.a(2131712954), str);
      this.jdField_a_of_type_Ahrh.a.e = 10;
      this.jdField_a_of_type_Ahrh.a.setVideoCompressStatus(true);
      return;
    }
    this.jdField_a_of_type_Ahrh.a.a(str, 1.0F);
    this.jdField_a_of_type_Ahrh.a.setAnimProgress(10, str);
    this.jdField_a_of_type_Ahrh.a.setVideoCompressStatus(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.CompressUpdateListenerImpl.1
 * JD-Core Version:    0.7.0.1
 */