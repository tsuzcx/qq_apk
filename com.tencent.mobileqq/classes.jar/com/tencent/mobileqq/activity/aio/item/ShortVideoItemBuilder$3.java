package com.tencent.mobileqq.activity.aio.item;

import adzh;
import adzr;
import ajyc;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.MessageForShortVideo;

public class ShortVideoItemBuilder$3
  implements Runnable
{
  public ShortVideoItemBuilder$3(adzh paramadzh, MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean, adzr paramadzr) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Adzr.a.setDrawStatus(1);
      this.jdField_a_of_type_Adzr.a.setAnimProgress(ajyc.a(2131714080), str);
      this.jdField_a_of_type_Adzr.a.e = 10;
      this.jdField_a_of_type_Adzr.a.setVideoCompressStatus(true);
      return;
    }
    this.jdField_a_of_type_Adzr.a.a(str, 1.0F);
    this.jdField_a_of_type_Adzr.a.setAnimProgress(10, str);
    this.jdField_a_of_type_Adzr.a.setVideoCompressStatus(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */