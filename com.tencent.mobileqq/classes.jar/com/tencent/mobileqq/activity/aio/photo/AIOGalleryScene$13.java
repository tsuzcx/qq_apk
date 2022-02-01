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
    paramInt = this.jdField_a_of_type_Int;
    if (paramInt != 1)
    {
      if (paramInt != 3)
      {
        if (QLog.isColorLevel())
        {
          paramDialogInterface = new StringBuilder();
          paramDialogInterface.append("showSaveFileTips type = ");
          paramDialogInterface.append(this.jdField_a_of_type_Int);
          QLog.d("AIOGalleryScene", 2, paramDialogInterface.toString());
        }
      }
      else
      {
        paramDialogInterface = this.jdField_a_of_type_JavaLangObject;
        if ((paramDialogInterface instanceof AIOShortVideoData))
        {
          AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, (AIOShortVideoData)paramDialogInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.a.a = true;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.u();
        }
      }
    }
    else
    {
      paramDialogInterface = this.jdField_a_of_type_JavaLangObject;
      if ((paramDialogInterface instanceof AIOImageData))
      {
        AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, (AIOImageData)paramDialogInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.u();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.13
 * JD-Core Version:    0.7.0.1
 */