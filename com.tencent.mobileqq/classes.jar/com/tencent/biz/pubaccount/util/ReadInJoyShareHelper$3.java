package com.tencent.biz.pubaccount.util;

import android.graphics.Bitmap;
import android.os.Message;
import bfob;
import rnq;
import sgv;

public class ReadInJoyShareHelper$3
  implements Runnable
{
  public ReadInJoyShareHelper$3(sgv paramsgv, Bitmap paramBitmap) {}
  
  public void run()
  {
    String str = rnq.a(this.a, "ShotCache_");
    Message localMessage = Message.obtain();
    localMessage.what = 101;
    localMessage.obj = str;
    sgv.a(this.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadInJoyShareHelper.3
 * JD-Core Version:    0.7.0.1
 */