package com.tencent.mobileqq.activity.aio.photo;

import aavp;
import ahqw;
import ahqx;
import ahri;
import ahsn;

public class AIOGalleryActivity$AIOGalleryManager$1$3
  implements Runnable
{
  public AIOGalleryActivity$AIOGalleryManager$1$3(ahqx paramahqx, AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt) {}
  
  public void run()
  {
    ahsn localahsn;
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData != null)
    {
      localahsn = (ahsn)ahqw.a(this.jdField_a_of_type_Ahqx.a);
      if (!localahsn.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData, this.jdField_a_of_type_Int)) {
        break label92;
      }
      if (ahqw.e(this.jdField_a_of_type_Ahqx.a) != null) {
        ((ahri)ahqw.f(this.jdField_a_of_type_Ahqx.a)).z();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Ahqx.a.a != null) {
        this.jdField_a_of_type_Ahqx.a.a.e();
      }
      return;
      label92:
      if ((this.jdField_a_of_type_Ahqx.a.a != null) && (this.jdField_a_of_type_Ahqx.a.a() == this.jdField_a_of_type_Ahqx.a.a))
      {
        localahsn.b();
        if (ahqw.g(this.jdField_a_of_type_Ahqx.a) != null) {
          ((ahri)ahqw.h(this.jdField_a_of_type_Ahqx.a)).z();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity.AIOGalleryManager.1.3
 * JD-Core Version:    0.7.0.1
 */