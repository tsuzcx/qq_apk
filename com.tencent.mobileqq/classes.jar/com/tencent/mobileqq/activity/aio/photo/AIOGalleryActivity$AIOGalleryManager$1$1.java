package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.qphone.base.util.QLog;

class AIOGalleryActivity$AIOGalleryManager$1$1
  implements Runnable
{
  AIOGalleryActivity$AIOGalleryManager$1$1(AIOGalleryActivity.AIOGalleryManager.1 param1, boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void run()
  {
    if (AIOGalleryActivity.AIOGalleryManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity$AIOGalleryManager$1.a) != null)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("IAIOImageProviderCallBack.notifyImageResult():isPart ");
        localStringBuilder.append(this.jdField_a_of_type_Boolean);
        QLog.d("peak_pgjpeg", 4, localStringBuilder.toString());
      }
      ((AIOGalleryScene)AIOGalleryActivity.AIOGalleryManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity$AIOGalleryManager$1.a)).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, this.c, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity$AIOGalleryManager$1.a.a != null) {
      ((AIOImageListScene)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity$AIOGalleryManager$1.a.a).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, this.c, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity.AIOGalleryManager.1.1
 * JD-Core Version:    0.7.0.1
 */