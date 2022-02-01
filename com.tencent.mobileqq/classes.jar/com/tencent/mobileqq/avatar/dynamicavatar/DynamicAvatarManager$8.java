package com.tencent.mobileqq.avatar.dynamicavatar;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.DynamicFaceDrawable;
import mqq.os.MqqHandler;

class DynamicAvatarManager$8
  implements Runnable
{
  DynamicAvatarManager$8(DynamicAvatarManager paramDynamicAvatarManager) {}
  
  public void run()
  {
    synchronized (DynamicFaceDrawable.a)
    {
      DynamicFaceDrawable.b = false;
      ThreadManager.getUIHandler().post(new DynamicAvatarManager.8.1(this));
      this.this$0.c();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.8
 * JD-Core Version:    0.7.0.1
 */