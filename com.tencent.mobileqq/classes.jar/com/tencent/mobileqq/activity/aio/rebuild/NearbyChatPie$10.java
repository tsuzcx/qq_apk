package com.tencent.mobileqq.activity.aio.rebuild;

import aidd;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import ayoa;
import bdla;

public class NearbyChatPie$10
  implements Runnable
{
  public NearbyChatPie$10(aidd paramaidd) {}
  
  public void run()
  {
    String[] arrayOfString = ayoa.a(this.this$0.app);
    String str = this.this$0.mActivity.getIntent().getStringExtra("uin");
    bdla.b(this.this$0.app, "CliOper", "", "", "0X80055FE", "0X80055FE", 0, 0, arrayOfString[0], str, "", "");
    this.this$0.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.10
 * JD-Core Version:    0.7.0.1
 */