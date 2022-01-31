package com.tencent.mobileqq.activity.aio.photo;

import agcw;
import agcx;
import agdi;
import ages;
import zed;

public class AIOGalleryActivity$AIOGalleryManager$1$3
  implements Runnable
{
  public AIOGalleryActivity$AIOGalleryManager$1$3(agcx paramagcx, AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt) {}
  
  public void run()
  {
    ages localages;
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData != null)
    {
      localages = (ages)agcw.a(this.jdField_a_of_type_Agcx.a);
      if (!localages.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData, this.jdField_a_of_type_Int)) {
        break label92;
      }
      if (agcw.e(this.jdField_a_of_type_Agcx.a) != null) {
        ((agdi)agcw.f(this.jdField_a_of_type_Agcx.a)).z();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Agcx.a.a != null) {
        this.jdField_a_of_type_Agcx.a.a.h();
      }
      return;
      label92:
      if ((this.jdField_a_of_type_Agcx.a.a != null) && (this.jdField_a_of_type_Agcx.a.a() == this.jdField_a_of_type_Agcx.a.a))
      {
        localages.b();
        if (agcw.g(this.jdField_a_of_type_Agcx.a) != null) {
          ((agdi)agcw.h(this.jdField_a_of_type_Agcx.a)).z();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity.AIOGalleryManager.1.3
 * JD-Core Version:    0.7.0.1
 */