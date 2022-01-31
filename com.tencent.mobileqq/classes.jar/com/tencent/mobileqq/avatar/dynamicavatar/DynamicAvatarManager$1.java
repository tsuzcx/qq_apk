package com.tencent.mobileqq.avatar.dynamicavatar;

import anug;
import azdy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

public class DynamicAvatarManager$1
  implements Runnable
{
  public DynamicAvatarManager$1(anug paramanug) {}
  
  public void run()
  {
    if ((!VideoEnvironment.e(anug.a(this.this$0))) && ((anug.a(this.this$0) instanceof QQAppInterface))) {
      azdy.a((QQAppInterface)anug.a(this.this$0), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.1
 * JD-Core Version:    0.7.0.1
 */