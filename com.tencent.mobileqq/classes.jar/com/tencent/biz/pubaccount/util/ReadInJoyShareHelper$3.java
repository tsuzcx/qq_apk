package com.tencent.biz.pubaccount.util;

import android.graphics.Bitmap;
import android.os.Message;
import bhtd;
import sdp;
import syq;

public class ReadInJoyShareHelper$3
  implements Runnable
{
  public ReadInJoyShareHelper$3(syq paramsyq, Bitmap paramBitmap) {}
  
  public void run()
  {
    String str = sdp.a(this.a, "ShotCache_");
    Message localMessage = Message.obtain();
    localMessage.what = 101;
    localMessage.obj = str;
    syq.a(this.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadInJoyShareHelper.3
 * JD-Core Version:    0.7.0.1
 */