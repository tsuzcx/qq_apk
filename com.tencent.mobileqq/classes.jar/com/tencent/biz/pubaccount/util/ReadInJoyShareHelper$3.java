package com.tencent.biz.pubaccount.util;

import android.os.Message;
import bkys;
import tkl;
import uus;

public class ReadInJoyShareHelper$3
  implements Runnable
{
  public void run()
  {
    String str = tkl.a(this.a, "ShotCache_");
    Message localMessage = Message.obtain();
    localMessage.what = 101;
    localMessage.obj = str;
    uus.a(this.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadInJoyShareHelper.3
 * JD-Core Version:    0.7.0.1
 */