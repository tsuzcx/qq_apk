package com.tencent.mobileqq.avatar.dynamicavatar;

import com.tencent.mobileqq.app.ThreadManager;

class DynamicAvatarManager$4
  implements Runnable
{
  DynamicAvatarManager$4(DynamicAvatarManager paramDynamicAvatarManager, Runnable paramRunnable) {}
  
  public void run()
  {
    ThreadManager.excute(this.a, 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.4
 * JD-Core Version:    0.7.0.1
 */