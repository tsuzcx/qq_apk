package com.tencent.biz.pubaccount.util;

import android.graphics.Bitmap;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ScreenShotImageUtil;
import com.tencent.util.WeakReferenceHandler;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ReadInJoyShareHelperV2$doScreenshot$1
  implements Runnable
{
  ReadInJoyShareHelperV2$doScreenshot$1(ReadInJoyShareHelperV2 paramReadInJoyShareHelperV2, Bitmap paramBitmap) {}
  
  public final void run()
  {
    String str = ScreenShotImageUtil.a(this.a, "ShotCache_");
    Message localMessage = Message.obtain();
    localMessage.what = 101;
    localMessage.obj = str;
    ReadInJoyShareHelperV2.a(this.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadInJoyShareHelperV2.doScreenshot.1
 * JD-Core Version:    0.7.0.1
 */