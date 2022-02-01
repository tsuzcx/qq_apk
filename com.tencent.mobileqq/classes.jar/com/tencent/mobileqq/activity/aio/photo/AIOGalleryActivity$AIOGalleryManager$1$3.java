package com.tencent.mobileqq.activity.aio.photo;

import abju;
import aibf;
import aibg;
import aibr;
import aicx;

public class AIOGalleryActivity$AIOGalleryManager$1$3
  implements Runnable
{
  public AIOGalleryActivity$AIOGalleryManager$1$3(aibg paramaibg, AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt) {}
  
  public void run()
  {
    aicx localaicx;
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData != null)
    {
      localaicx = (aicx)aibf.a(this.jdField_a_of_type_Aibg.a);
      if (!localaicx.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData, this.jdField_a_of_type_Int)) {
        break label92;
      }
      if (aibf.e(this.jdField_a_of_type_Aibg.a) != null) {
        ((aibr)aibf.f(this.jdField_a_of_type_Aibg.a)).z();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aibg.a.a != null) {
        this.jdField_a_of_type_Aibg.a.a.e();
      }
      return;
      label92:
      if ((this.jdField_a_of_type_Aibg.a.a != null) && (this.jdField_a_of_type_Aibg.a.a() == this.jdField_a_of_type_Aibg.a.a))
      {
        localaicx.b();
        if (aibf.g(this.jdField_a_of_type_Aibg.a) != null) {
          ((aibr)aibf.h(this.jdField_a_of_type_Aibg.a)).z();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity.AIOGalleryManager.1.3
 * JD-Core Version:    0.7.0.1
 */