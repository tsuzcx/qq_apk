package com.tencent.mobileqq.activity.aio.photo;

import advj;
import advk;
import advv;
import adxf;
import xgn;

public class AIOGalleryActivity$AIOGalleryManager$1$3
  implements Runnable
{
  public AIOGalleryActivity$AIOGalleryManager$1$3(advk paramadvk, AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt) {}
  
  public void run()
  {
    adxf localadxf;
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData != null)
    {
      localadxf = (adxf)advj.a(this.jdField_a_of_type_Advk.a);
      if (!localadxf.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData, this.jdField_a_of_type_Int)) {
        break label92;
      }
      if (advj.e(this.jdField_a_of_type_Advk.a) != null) {
        ((advv)advj.f(this.jdField_a_of_type_Advk.a)).z();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Advk.a.a != null) {
        this.jdField_a_of_type_Advk.a.a.h();
      }
      return;
      label92:
      if ((this.jdField_a_of_type_Advk.a.a != null) && (this.jdField_a_of_type_Advk.a.a() == this.jdField_a_of_type_Advk.a.a))
      {
        localadxf.a();
        if (advj.g(this.jdField_a_of_type_Advk.a) != null) {
          ((advv)advj.h(this.jdField_a_of_type_Advk.a)).z();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity.AIOGalleryManager.1.3
 * JD-Core Version:    0.7.0.1
 */