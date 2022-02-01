package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;

class NearbyChatPie$8
  implements Runnable
{
  NearbyChatPie$8(NearbyChatPie paramNearbyChatPie) {}
  
  public void run()
  {
    Intent localIntent = this.this$0.a.getIntent();
    localIntent.putExtra("uintype", 0);
    NearbyChatPie.a(this.this$0, localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.8
 * JD-Core Version:    0.7.0.1
 */