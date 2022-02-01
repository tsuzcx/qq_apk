package com.tencent.mobileqq.activity.aio.photo;

import aagd;
import agxv;
import agxw;
import agyh;
import agzn;

public class AIOGalleryActivity$AIOGalleryManager$1$3
  implements Runnable
{
  public AIOGalleryActivity$AIOGalleryManager$1$3(agxw paramagxw, AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt) {}
  
  public void run()
  {
    agzn localagzn;
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData != null)
    {
      localagzn = (agzn)agxv.a(this.jdField_a_of_type_Agxw.a);
      if (!localagzn.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData, this.jdField_a_of_type_Int)) {
        break label92;
      }
      if (agxv.e(this.jdField_a_of_type_Agxw.a) != null) {
        ((agyh)agxv.f(this.jdField_a_of_type_Agxw.a)).z();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Agxw.a.a != null) {
        this.jdField_a_of_type_Agxw.a.a.e();
      }
      return;
      label92:
      if ((this.jdField_a_of_type_Agxw.a.a != null) && (this.jdField_a_of_type_Agxw.a.a() == this.jdField_a_of_type_Agxw.a.a))
      {
        localagzn.b();
        if (agxv.g(this.jdField_a_of_type_Agxw.a) != null) {
          ((agyh)agxv.h(this.jdField_a_of_type_Agxw.a)).z();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity.AIOGalleryManager.1.3
 * JD-Core Version:    0.7.0.1
 */