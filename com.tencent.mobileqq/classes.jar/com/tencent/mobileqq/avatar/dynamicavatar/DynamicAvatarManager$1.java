package com.tencent.mobileqq.avatar.dynamicavatar;

import anpx;
import ayzp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

public class DynamicAvatarManager$1
  implements Runnable
{
  public DynamicAvatarManager$1(anpx paramanpx) {}
  
  public void run()
  {
    if ((!VideoEnvironment.e(anpx.a(this.this$0))) && ((anpx.a(this.this$0) instanceof QQAppInterface))) {
      ayzp.a((QQAppInterface)anpx.a(this.this$0), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.1
 * JD-Core Version:    0.7.0.1
 */