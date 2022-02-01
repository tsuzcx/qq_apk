package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;

class PublicAccountChatPie$29$1
  implements Runnable
{
  PublicAccountChatPie$29$1(PublicAccountChatPie.29 param29) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("isNeedFinish", true);
    this.a.this$0.a.setResult(-1, localIntent);
    this.a.this$0.K();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.29.1
 * JD-Core Version:    0.7.0.1
 */