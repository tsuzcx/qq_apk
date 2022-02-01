package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.common.galleryactivity.AbstractImageListScene;

class AIOGalleryActivity$AIOGalleryManager$1$3
  implements Runnable
{
  AIOGalleryActivity$AIOGalleryManager$1$3(AIOGalleryActivity.AIOGalleryManager.1 param1, AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData != null)
    {
      AIOImageListModel localAIOImageListModel = (AIOImageListModel)AIOGalleryActivity.AIOGalleryManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity$AIOGalleryManager$1.a);
      if (localAIOImageListModel.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData, this.jdField_a_of_type_Int))
      {
        if (AIOGalleryActivity.AIOGalleryManager.e(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity$AIOGalleryManager$1.a) != null) {
          ((AIOGalleryScene)AIOGalleryActivity.AIOGalleryManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity$AIOGalleryManager$1.a)).z();
        }
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity$AIOGalleryManager$1.a.a != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity$AIOGalleryManager$1.a.a() == this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity$AIOGalleryManager$1.a.a))
      {
        localAIOImageListModel.b();
        if (AIOGalleryActivity.AIOGalleryManager.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity$AIOGalleryManager$1.a) != null) {
          ((AIOGalleryScene)AIOGalleryActivity.AIOGalleryManager.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity$AIOGalleryManager$1.a)).z();
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity$AIOGalleryManager$1.a.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity$AIOGalleryManager$1.a.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity.AIOGalleryManager.1.3
 * JD-Core Version:    0.7.0.1
 */