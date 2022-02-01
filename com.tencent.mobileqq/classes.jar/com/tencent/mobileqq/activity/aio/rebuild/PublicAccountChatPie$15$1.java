package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.widget.RelativeLayout;

class PublicAccountChatPie$15$1
  implements Runnable
{
  PublicAccountChatPie$15$1(PublicAccountChatPie.15 param15) {}
  
  public void run()
  {
    if (this.a.a.m != null) {
      this.a.a.m.clearAnimation();
    }
    PublicAccountChatPie.b(this.a.a).removeView(this.a.a.m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.15.1
 * JD-Core Version:    0.7.0.1
 */