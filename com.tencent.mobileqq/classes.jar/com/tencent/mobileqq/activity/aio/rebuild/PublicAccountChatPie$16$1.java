package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.widget.RelativeLayout;

class PublicAccountChatPie$16$1
  implements Runnable
{
  PublicAccountChatPie$16$1(PublicAccountChatPie.16 param16) {}
  
  public void run()
  {
    if (this.a.a.g != null) {
      this.a.a.g.clearAnimation();
    }
    PublicAccountChatPie.b(this.a.a).removeView(this.a.a.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.16.1
 * JD-Core Version:    0.7.0.1
 */