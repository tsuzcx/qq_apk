package com.tencent.mobileqq.avatar.dynamicavatar;

import aqib;
import bcxo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

public class DynamicAvatarManager$1
  implements Runnable
{
  public DynamicAvatarManager$1(aqib paramaqib) {}
  
  public void run()
  {
    if ((!VideoEnvironment.e(aqib.a(this.this$0))) && ((aqib.a(this.this$0) instanceof QQAppInterface))) {
      bcxo.a((QQAppInterface)aqib.a(this.this$0), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.1
 * JD-Core Version:    0.7.0.1
 */