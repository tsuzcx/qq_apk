package com.tencent.mobileqq.activity.aio.photo;

import abfq;
import ahrr;
import ahrs;
import ahsd;
import ahtj;

public class AIOGalleryActivity$AIOGalleryManager$1$3
  implements Runnable
{
  public AIOGalleryActivity$AIOGalleryManager$1$3(ahrs paramahrs, AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt) {}
  
  public void run()
  {
    ahtj localahtj;
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData != null)
    {
      localahtj = (ahtj)ahrr.a(this.jdField_a_of_type_Ahrs.a);
      if (!localahtj.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData, this.jdField_a_of_type_Int)) {
        break label92;
      }
      if (ahrr.e(this.jdField_a_of_type_Ahrs.a) != null) {
        ((ahsd)ahrr.f(this.jdField_a_of_type_Ahrs.a)).z();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Ahrs.a.a != null) {
        this.jdField_a_of_type_Ahrs.a.a.e();
      }
      return;
      label92:
      if ((this.jdField_a_of_type_Ahrs.a.a != null) && (this.jdField_a_of_type_Ahrs.a.a() == this.jdField_a_of_type_Ahrs.a.a))
      {
        localahtj.b();
        if (ahrr.g(this.jdField_a_of_type_Ahrs.a) != null) {
          ((ahsd)ahrr.h(this.jdField_a_of_type_Ahrs.a)).z();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity.AIOGalleryManager.1.3
 * JD-Core Version:    0.7.0.1
 */