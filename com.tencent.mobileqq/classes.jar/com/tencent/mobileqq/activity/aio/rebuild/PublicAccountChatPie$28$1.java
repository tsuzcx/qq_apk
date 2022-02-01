package com.tencent.mobileqq.activity.aio.rebuild;

import aidp;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;

class PublicAccountChatPie$28$1
  implements Runnable
{
  PublicAccountChatPie$28$1(PublicAccountChatPie.28 param28) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("isNeedFinish", true);
    this.a.this$0.a.setResult(-1, localIntent);
    this.a.this$0.I();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.28.1
 * JD-Core Version:    0.7.0.1
 */