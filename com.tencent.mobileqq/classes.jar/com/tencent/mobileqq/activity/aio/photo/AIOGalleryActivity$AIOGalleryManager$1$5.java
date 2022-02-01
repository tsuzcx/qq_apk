package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;

class AIOGalleryActivity$AIOGalleryManager$1$5
  implements Runnable
{
  AIOGalleryActivity$AIOGalleryManager$1$5(AIOGalleryActivity.AIOGalleryManager.1 param1, long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3) {}
  
  public void run()
  {
    if (AIOGalleryActivity.AIOGalleryManager.l(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity$AIOGalleryManager$1.a) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IAIOImageProviderCallBack", 2, "[carverW]IAIOImageProviderCallBack.notifyVideoUrl ");
      }
      ((AIOGalleryScene)AIOGalleryActivity.AIOGalleryManager.m(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity$AIOGalleryManager$1.a)).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity.AIOGalleryManager.1.5
 * JD-Core Version:    0.7.0.1
 */