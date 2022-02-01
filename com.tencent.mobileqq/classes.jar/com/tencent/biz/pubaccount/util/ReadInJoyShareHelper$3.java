package com.tencent.biz.pubaccount.util;

import android.os.Message;
import blhq;
import sta;
import uag;

public class ReadInJoyShareHelper$3
  implements Runnable
{
  public void run()
  {
    String str = sta.a(this.a, "ShotCache_");
    Message localMessage = Message.obtain();
    localMessage.what = 101;
    localMessage.obj = str;
    uag.a(this.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadInJoyShareHelper.3
 * JD-Core Version:    0.7.0.1
 */