package com.tencent.biz.subscribe.widget;

import android.app.Activity;
import android.graphics.Bitmap;
import axli;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import wuu;

public class SubscribeQRCodeShareHelper$8
  implements Runnable
{
  public SubscribeQRCodeShareHelper$8(wuu paramwuu, int paramInt) {}
  
  public void run()
  {
    wuu.d(this.this$0);
    if ((wuu.a(this.this$0) != null) && (!wuu.a(this.this$0).isFinishing()) && (wuu.a(this.this$0)))
    {
      String str = wuu.a(this.this$0, wuu.a(this.this$0));
      Bitmap localBitmap = wuu.b(this.this$0).a();
      wuu.b(this.this$0, String.valueOf(System.currentTimeMillis()));
      WXShareHelper.a().a(str, localBitmap, axli.a(270.0F) / 2, this.a, wuu.c(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.8
 * JD-Core Version:    0.7.0.1
 */