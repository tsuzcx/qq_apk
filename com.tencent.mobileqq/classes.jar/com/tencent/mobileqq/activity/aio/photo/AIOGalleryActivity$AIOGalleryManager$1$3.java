package com.tencent.mobileqq.activity.aio.photo;

import aegi;
import aegj;
import aegu;
import aeie;
import xpn;

public class AIOGalleryActivity$AIOGalleryManager$1$3
  implements Runnable
{
  public AIOGalleryActivity$AIOGalleryManager$1$3(aegj paramaegj, AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt) {}
  
  public void run()
  {
    aeie localaeie;
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData != null)
    {
      localaeie = (aeie)aegi.a(this.jdField_a_of_type_Aegj.a);
      if (!localaeie.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData, this.jdField_a_of_type_Int)) {
        break label92;
      }
      if (aegi.e(this.jdField_a_of_type_Aegj.a) != null) {
        ((aegu)aegi.f(this.jdField_a_of_type_Aegj.a)).z();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aegj.a.a != null) {
        this.jdField_a_of_type_Aegj.a.a.h();
      }
      return;
      label92:
      if ((this.jdField_a_of_type_Aegj.a.a != null) && (this.jdField_a_of_type_Aegj.a.a() == this.jdField_a_of_type_Aegj.a.a))
      {
        localaeie.a();
        if (aegi.g(this.jdField_a_of_type_Aegj.a) != null) {
          ((aegu)aegi.h(this.jdField_a_of_type_Aegj.a)).z();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity.AIOGalleryManager.1.3
 * JD-Core Version:    0.7.0.1
 */