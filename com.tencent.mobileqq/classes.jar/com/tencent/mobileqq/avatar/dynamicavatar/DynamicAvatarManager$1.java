package com.tencent.mobileqq.avatar.dynamicavatar;

import apbm;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import mqq.os.MqqHandler;

public class DynamicAvatarManager$1
  implements Runnable
{
  public DynamicAvatarManager$1(apbm paramapbm) {}
  
  public void run()
  {
    if ((!VideoEnvironment.checkAVCodecLoadIsOK(apbm.a(this.this$0))) && ((apbm.a(this.this$0) instanceof QQAppInterface))) {
      ThreadManager.getSubThreadHandler().post(new DynamicAvatarManager.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.1
 * JD-Core Version:    0.7.0.1
 */