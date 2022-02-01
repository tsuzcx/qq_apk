package com.tencent.mobileqq.activity.aio.rebuild;

import aidd;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;

public class NearbyChatPie$8
  implements Runnable
{
  public NearbyChatPie$8(aidd paramaidd) {}
  
  public void run()
  {
    Intent localIntent = this.this$0.mActivity.getIntent();
    localIntent.putExtra("uintype", 0);
    aidd.a(this.this$0, localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.8
 * JD-Core Version:    0.7.0.1
 */