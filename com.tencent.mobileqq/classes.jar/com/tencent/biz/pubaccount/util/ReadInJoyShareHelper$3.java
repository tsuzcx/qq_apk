package com.tencent.biz.pubaccount.util;

import android.graphics.Bitmap;
import android.os.Message;
import befq;
import rbb;
import rug;

public class ReadInJoyShareHelper$3
  implements Runnable
{
  public ReadInJoyShareHelper$3(rug paramrug, Bitmap paramBitmap) {}
  
  public void run()
  {
    String str = rbb.a(this.a, "ShotCache_");
    Message localMessage = Message.obtain();
    localMessage.what = 101;
    localMessage.obj = str;
    rug.a(this.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadInJoyShareHelper.3
 * JD-Core Version:    0.7.0.1
 */