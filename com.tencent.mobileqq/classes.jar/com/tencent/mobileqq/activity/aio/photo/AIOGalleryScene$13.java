package com.tencent.mobileqq.activity.aio.photo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class AIOGalleryScene$13
  implements DialogInterface.OnClickListener
{
  AIOGalleryScene$13(AIOGalleryScene paramAIOGalleryScene, int paramInt, Object paramObject, AIORichMediaInfo paramAIORichMediaInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (this.jdField_a_of_type_Int)
    {
    case 2: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "showSaveFileTips type = " + this.jdField_a_of_type_Int);
      }
      break;
    }
    do
    {
      do
      {
        return;
      } while (!(this.jdField_a_of_type_JavaLangObject instanceof AIOImageData));
      AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, (AIOImageData)this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.u();
      return;
    } while (!(this.jdField_a_of_type_JavaLangObject instanceof AIOShortVideoData));
    AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, (AIOShortVideoData)this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.a.a = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.u();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.13
 * JD-Core Version:    0.7.0.1
 */