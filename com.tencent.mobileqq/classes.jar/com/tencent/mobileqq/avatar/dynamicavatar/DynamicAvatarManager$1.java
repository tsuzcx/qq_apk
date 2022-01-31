package com.tencent.mobileqq.avatar.dynamicavatar;

import alyy;
import axej;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

public class DynamicAvatarManager$1
  implements Runnable
{
  public DynamicAvatarManager$1(alyy paramalyy) {}
  
  public void run()
  {
    if ((!VideoEnvironment.e(alyy.a(this.this$0))) && ((alyy.a(this.this$0) instanceof QQAppInterface))) {
      axej.a((QQAppInterface)alyy.a(this.this$0), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.1
 * JD-Core Version:    0.7.0.1
 */