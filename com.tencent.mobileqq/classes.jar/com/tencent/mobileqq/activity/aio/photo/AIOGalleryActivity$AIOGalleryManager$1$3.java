package com.tencent.mobileqq.activity.aio.photo;

import aghl;
import aghm;
import aghx;
import agjh;
import zis;

public class AIOGalleryActivity$AIOGalleryManager$1$3
  implements Runnable
{
  public AIOGalleryActivity$AIOGalleryManager$1$3(aghm paramaghm, AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt) {}
  
  public void run()
  {
    agjh localagjh;
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData != null)
    {
      localagjh = (agjh)aghl.a(this.jdField_a_of_type_Aghm.a);
      if (!localagjh.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData, this.jdField_a_of_type_Int)) {
        break label92;
      }
      if (aghl.e(this.jdField_a_of_type_Aghm.a) != null) {
        ((aghx)aghl.f(this.jdField_a_of_type_Aghm.a)).z();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aghm.a.a != null) {
        this.jdField_a_of_type_Aghm.a.a.h();
      }
      return;
      label92:
      if ((this.jdField_a_of_type_Aghm.a.a != null) && (this.jdField_a_of_type_Aghm.a.a() == this.jdField_a_of_type_Aghm.a.a))
      {
        localagjh.b();
        if (aghl.g(this.jdField_a_of_type_Aghm.a) != null) {
          ((aghx)aghl.h(this.jdField_a_of_type_Aghm.a)).z();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity.AIOGalleryManager.1.3
 * JD-Core Version:    0.7.0.1
 */