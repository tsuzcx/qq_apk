package com.tencent.mobileqq.avatar.dynamicavatar;

import com.tencent.image.AbstractVideoImage;
import com.tencent.mobileqq.app.face.DynamicFaceDrawable;

class DynamicAvatarManager$8$1
  implements Runnable
{
  DynamicAvatarManager$8$1(DynamicAvatarManager.8 param8) {}
  
  public void run()
  {
    if (!DynamicFaceDrawable.b) {
      AbstractVideoImage.resumeAll();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.8.1
 * JD-Core Version:    0.7.0.1
 */