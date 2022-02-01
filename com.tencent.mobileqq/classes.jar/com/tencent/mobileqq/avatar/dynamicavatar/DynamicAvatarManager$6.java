package com.tencent.mobileqq.avatar.dynamicavatar;

import com.tencent.mobileqq.app.face.DynamicFaceDrawable;
import com.tencent.mobileqq.data.DynamicAvatar;

class DynamicAvatarManager$6
  implements Runnable
{
  DynamicAvatarManager$6(DynamicAvatarManager paramDynamicAvatarManager, DynamicFaceDrawable paramDynamicFaceDrawable, long paramLong) {}
  
  public void run()
  {
    DynamicAvatar localDynamicAvatar = this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.c, this.jdField_a_of_type_ComTencentMobileqqAppFaceDynamicFaceDrawable.a);
    if (localDynamicAvatar != null)
    {
      localDynamicAvatar.playTimeStamp = this.jdField_a_of_type_Long;
      this.this$0.a(localDynamicAvatar);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.6
 * JD-Core Version:    0.7.0.1
 */