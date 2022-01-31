package com.tencent.mobileqq.avatar.dynamicavatar;

import anpx;
import bcwi;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class DynamicAvatarManager$8
  implements Runnable
{
  public DynamicAvatarManager$8(anpx paramanpx) {}
  
  public void run()
  {
    synchronized (bcwi.a)
    {
      bcwi.b = false;
      ThreadManager.getUIHandler().post(new DynamicAvatarManager.8.1(this));
      this.this$0.c();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.8
 * JD-Core Version:    0.7.0.1
 */