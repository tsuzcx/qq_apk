package com.tencent.biz.pubaccount.util;

import android.graphics.Bitmap;
import android.os.Message;
import bkgm;
import kotlin.Metadata;
import tce;
import uai;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class ReadInJoyShareHelperV2$doScreenshot$1
  implements Runnable
{
  public ReadInJoyShareHelperV2$doScreenshot$1(uai paramuai, Bitmap paramBitmap) {}
  
  public final void run()
  {
    String str = tce.a(this.a, "ShotCache_");
    Message localMessage = Message.obtain();
    localMessage.what = 101;
    localMessage.obj = str;
    uai.a(this.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadInJoyShareHelperV2.doScreenshot.1
 * JD-Core Version:    0.7.0.1
 */