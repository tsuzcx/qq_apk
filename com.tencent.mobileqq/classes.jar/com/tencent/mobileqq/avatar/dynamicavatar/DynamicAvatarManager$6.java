package com.tencent.mobileqq.avatar.dynamicavatar;

import com.tencent.mobileqq.app.face.DynamicFaceDrawable;
import com.tencent.mobileqq.data.DynamicAvatar;

class DynamicAvatarManager$6
  implements Runnable
{
  DynamicAvatarManager$6(DynamicAvatarManager paramDynamicAvatarManager, DynamicFaceDrawable paramDynamicFaceDrawable, long paramLong) {}
  
  public void run()
  {
    DynamicAvatar localDynamicAvatar = this.this$0.a(this.a.l, this.a.j);
    if (localDynamicAvatar != null)
    {
      localDynamicAvatar.playTimeStamp = this.b;
      this.this$0.a(localDynamicAvatar);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.6
 * JD-Core Version:    0.7.0.1
 */