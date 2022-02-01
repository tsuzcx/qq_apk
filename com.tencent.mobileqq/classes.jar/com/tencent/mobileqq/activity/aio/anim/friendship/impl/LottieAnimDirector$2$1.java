package com.tencent.mobileqq.activity.aio.anim.friendship.impl;

import com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.IDirector.OnDirectorPrepared;
import com.tencent.mobileqq.app.QQAppInterface;

class LottieAnimDirector$2$1
  implements Runnable
{
  LottieAnimDirector$2$1(LottieAnimDirector.2 param2, boolean paramBoolean) {}
  
  public void run()
  {
    if (!LottieAnimDirector.b(this.b.b))
    {
      if (LottieAnimDirector.a(this.b.b)) {
        return;
      }
      if (this.a)
      {
        QQAppInterface localQQAppInterface = LottieAnimDirector.c(this.b.b);
        if (localQQAppInterface != null) {
          LottieAnimDirector.a(this.b.b, localQQAppInterface);
        }
      }
      if (this.b.a != null) {
        this.b.a.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.LottieAnimDirector.2.1
 * JD-Core Version:    0.7.0.1
 */