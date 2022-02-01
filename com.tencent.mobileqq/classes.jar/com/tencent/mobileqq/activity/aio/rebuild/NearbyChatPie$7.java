package com.tencent.mobileqq.activity.aio.rebuild;

import aimx;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;

public class NearbyChatPie$7
  implements Runnable
{
  public NearbyChatPie$7(aimx paramaimx) {}
  
  public void run()
  {
    Intent localIntent = this.this$0.a.getIntent();
    localIntent.putExtra("uintype", 0);
    aimx.a(this.this$0, localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.7
 * JD-Core Version:    0.7.0.1
 */