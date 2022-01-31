package com.tencent.mobileqq.activity.aio.item;

import agai;
import agas;
import alud;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.MessageForShortVideo;

public class ShortVideoItemBuilder$3
  implements Runnable
{
  public ShortVideoItemBuilder$3(agai paramagai, MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean, agas paramagas) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Agas.a.setDrawStatus(1);
      this.jdField_a_of_type_Agas.a.setAnimProgress(alud.a(2131714475), str);
      this.jdField_a_of_type_Agas.a.e = 10;
      this.jdField_a_of_type_Agas.a.setVideoCompressStatus(true);
      return;
    }
    this.jdField_a_of_type_Agas.a.a(str, 1.0F);
    this.jdField_a_of_type_Agas.a.setAnimProgress(10, str);
    this.jdField_a_of_type_Agas.a.setVideoCompressStatus(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */