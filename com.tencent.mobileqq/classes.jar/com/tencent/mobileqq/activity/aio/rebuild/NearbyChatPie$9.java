package com.tencent.mobileqq.activity.aio.rebuild;

import ahik;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import axhv;
import bcef;

public class NearbyChatPie$9
  implements Runnable
{
  public NearbyChatPie$9(ahik paramahik) {}
  
  public void run()
  {
    String[] arrayOfString = axhv.a(this.this$0.app);
    String str = this.this$0.mActivity.getIntent().getStringExtra("uin");
    bcef.b(this.this$0.app, "CliOper", "", "", "0X80055FE", "0X80055FE", 0, 0, arrayOfString[0], str, "", "");
    this.this$0.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.9
 * JD-Core Version:    0.7.0.1
 */