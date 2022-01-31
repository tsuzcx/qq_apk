package com.tencent.mobileqq.activity.aio.item;

import adoi;
import ados;
import ajjy;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.MessageForShortVideo;

public class ShortVideoItemBuilder$3
  implements Runnable
{
  public ShortVideoItemBuilder$3(adoi paramadoi, MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean, ados paramados) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Ados.a.setDrawStatus(1);
      this.jdField_a_of_type_Ados.a.setAnimProgress(ajjy.a(2131648292), str);
      this.jdField_a_of_type_Ados.a.e = 10;
      this.jdField_a_of_type_Ados.a.setVideoCompressStatus(true);
      return;
    }
    this.jdField_a_of_type_Ados.a.a(str, 1.0F);
    this.jdField_a_of_type_Ados.a.setAnimProgress(10, str);
    this.jdField_a_of_type_Ados.a.setVideoCompressStatus(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */