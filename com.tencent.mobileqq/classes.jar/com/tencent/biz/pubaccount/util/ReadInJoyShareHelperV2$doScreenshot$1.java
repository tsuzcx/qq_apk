package com.tencent.biz.pubaccount.util;

import android.graphics.Bitmap;
import android.os.Message;
import bjng;
import kotlin.Metadata;
import sxa;
import ugz;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class ReadInJoyShareHelperV2$doScreenshot$1
  implements Runnable
{
  public ReadInJoyShareHelperV2$doScreenshot$1(ugz paramugz, Bitmap paramBitmap) {}
  
  public final void run()
  {
    String str = sxa.a(this.a, "ShotCache_");
    Message localMessage = Message.obtain();
    localMessage.what = 101;
    localMessage.obj = str;
    ugz.a(this.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadInJoyShareHelperV2.doScreenshot.1
 * JD-Core Version:    0.7.0.1
 */