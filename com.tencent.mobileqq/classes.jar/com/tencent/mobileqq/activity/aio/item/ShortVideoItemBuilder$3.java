package com.tencent.mobileqq.activity.aio.item;

import afvt;
import afwd;
import alpo;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.MessageForShortVideo;

public class ShortVideoItemBuilder$3
  implements Runnable
{
  public ShortVideoItemBuilder$3(afvt paramafvt, MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean, afwd paramafwd) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Afwd.a.setDrawStatus(1);
      this.jdField_a_of_type_Afwd.a.setAnimProgress(alpo.a(2131714463), str);
      this.jdField_a_of_type_Afwd.a.e = 10;
      this.jdField_a_of_type_Afwd.a.setVideoCompressStatus(true);
      return;
    }
    this.jdField_a_of_type_Afwd.a.a(str, 1.0F);
    this.jdField_a_of_type_Afwd.a.setAnimProgress(10, str);
    this.jdField_a_of_type_Afwd.a.setVideoCompressStatus(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */