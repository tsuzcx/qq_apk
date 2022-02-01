package com.tencent.mobileqq.activity.aio.photo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class AIOImageListScene$3
  implements DialogInterface.OnClickListener
{
  AIOImageListScene$3(AIOImageListScene paramAIOImageListScene, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      paramInt = this.jdField_a_of_type_Int;
      if (paramInt == 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.a(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) });
      } else if (paramInt == 1) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.a(new Integer[] { Integer.valueOf(0), Integer.valueOf(2) });
      }
      AIOImageListScene.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageListScene.3
 * JD-Core Version:    0.7.0.1
 */