package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;

class PublicAccountChatPie$30$1
  implements Runnable
{
  PublicAccountChatPie$30$1(PublicAccountChatPie.30 param30) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("isNeedFinish", true);
    this.a.this$0.f.setResult(-1, localIntent);
    this.a.this$0.L();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.30.1
 * JD-Core Version:    0.7.0.1
 */