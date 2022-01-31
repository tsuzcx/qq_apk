package com.tencent.mobileqq.activity.aio.rebuild;

import aert;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;

class PublicAccountChatPie$25$1
  implements Runnable
{
  PublicAccountChatPie$25$1(PublicAccountChatPie.25 param25) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("isNeedFinish", true);
    this.a.this$0.a.setResult(-1, localIntent);
    this.a.this$0.H();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.25.1
 * JD-Core Version:    0.7.0.1
 */