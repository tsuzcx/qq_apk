package com.tencent.mobileqq.activity.aio.photo;

import aegg;
import aegh;
import aegs;
import aeic;
import xpk;

public class AIOGalleryActivity$AIOGalleryManager$1$3
  implements Runnable
{
  public AIOGalleryActivity$AIOGalleryManager$1$3(aegh paramaegh, AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt) {}
  
  public void run()
  {
    aeic localaeic;
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData != null)
    {
      localaeic = (aeic)aegg.a(this.jdField_a_of_type_Aegh.a);
      if (!localaeic.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData, this.jdField_a_of_type_Int)) {
        break label92;
      }
      if (aegg.e(this.jdField_a_of_type_Aegh.a) != null) {
        ((aegs)aegg.f(this.jdField_a_of_type_Aegh.a)).z();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aegh.a.a != null) {
        this.jdField_a_of_type_Aegh.a.a.h();
      }
      return;
      label92:
      if ((this.jdField_a_of_type_Aegh.a.a != null) && (this.jdField_a_of_type_Aegh.a.a() == this.jdField_a_of_type_Aegh.a.a))
      {
        localaeic.a();
        if (aegg.g(this.jdField_a_of_type_Aegh.a) != null) {
          ((aegs)aegg.h(this.jdField_a_of_type_Aegh.a)).z();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity.AIOGalleryManager.1.3
 * JD-Core Version:    0.7.0.1
 */