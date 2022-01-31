package com.tencent.mobileqq.avatar.dynamicavatar;

import alkl;
import awez;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

public class DynamicAvatarManager$1
  implements Runnable
{
  public DynamicAvatarManager$1(alkl paramalkl) {}
  
  public void run()
  {
    if ((!VideoEnvironment.e(alkl.a(this.this$0))) && ((alkl.a(this.this$0) instanceof QQAppInterface))) {
      awez.a((QQAppInterface)alkl.a(this.this$0), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.1
 * JD-Core Version:    0.7.0.1
 */