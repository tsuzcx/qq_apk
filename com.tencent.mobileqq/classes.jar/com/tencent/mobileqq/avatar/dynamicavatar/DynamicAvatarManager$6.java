package com.tencent.mobileqq.avatar.dynamicavatar;

import anpx;
import bcwi;
import com.tencent.mobileqq.data.DynamicAvatar;

public class DynamicAvatarManager$6
  implements Runnable
{
  public DynamicAvatarManager$6(anpx paramanpx, bcwi parambcwi, long paramLong) {}
  
  public void run()
  {
    DynamicAvatar localDynamicAvatar = this.this$0.a(this.jdField_a_of_type_Bcwi.c, this.jdField_a_of_type_Bcwi.a);
    if (localDynamicAvatar != null)
    {
      localDynamicAvatar.playTimeStamp = this.jdField_a_of_type_Long;
      this.this$0.a(localDynamicAvatar);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.6
 * JD-Core Version:    0.7.0.1
 */