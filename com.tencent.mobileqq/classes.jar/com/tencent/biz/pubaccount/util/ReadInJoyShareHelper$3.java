package com.tencent.biz.pubaccount.util;

import android.os.Message;
import bjng;
import sxa;
import ugv;

public class ReadInJoyShareHelper$3
  implements Runnable
{
  public void run()
  {
    String str = sxa.a(this.a, "ShotCache_");
    Message localMessage = Message.obtain();
    localMessage.what = 101;
    localMessage.obj = str;
    ugv.a(this.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadInJoyShareHelper.3
 * JD-Core Version:    0.7.0.1
 */