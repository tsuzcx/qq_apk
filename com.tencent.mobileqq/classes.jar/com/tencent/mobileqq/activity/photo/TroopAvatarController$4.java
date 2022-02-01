package com.tencent.mobileqq.activity.photo;

import com.tencent.mobileqq.troop.utils.TroopUploadingThread.UploadState;

class TroopAvatarController$4
  implements Runnable
{
  TroopAvatarController$4(TroopAvatarController paramTroopAvatarController, TroopUploadingThread.UploadState paramUploadState, AvatarInfo paramAvatarInfo, int paramInt) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopUploadingThread$UploadState.c;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAvatarInfo.a = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAvatarInfo.b = 1;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAvatarInfo.jdField_c_of_type_Boolean = false;
    this.this$0.initVerifyFlag(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAvatarInfo);
    i &= 0x7FFFFFFF;
    if ((i < 0) || (i > 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAvatarInfo.jdField_c_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAvatarInfo.b = 1;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAvatarInfo.a = false;
      if (this.this$0.update2DB(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAvatarInfo)) {
        TroopAvatarController.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAvatarInfo);
      }
    }
    TroopAvatarController.a(this.this$0, null);
    TroopAvatarController.b(this.this$0, null);
    this.this$0.notifyUpdate(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAvatarInfo, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopUploadingThread$UploadState);
    this.this$0.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.TroopAvatarController.4
 * JD-Core Version:    0.7.0.1
 */