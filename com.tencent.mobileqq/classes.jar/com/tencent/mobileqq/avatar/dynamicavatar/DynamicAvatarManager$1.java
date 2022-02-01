package com.tencent.mobileqq.avatar.dynamicavatar;

import apul;
import bcew;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

public class DynamicAvatarManager$1
  implements Runnable
{
  public DynamicAvatarManager$1(apul paramapul) {}
  
  public void run()
  {
    if ((!VideoEnvironment.e(apul.a(this.this$0))) && ((apul.a(this.this$0) instanceof QQAppInterface))) {
      bcew.a((QQAppInterface)apul.a(this.this$0), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.1
 * JD-Core Version:    0.7.0.1
 */