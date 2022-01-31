package com.tencent.biz.subscribe.widget;

import android.app.Activity;
import android.graphics.Bitmap;
import axlk;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import wur;

public class SubscribeQRCodeShareHelper$8
  implements Runnable
{
  public SubscribeQRCodeShareHelper$8(wur paramwur, int paramInt) {}
  
  public void run()
  {
    wur.d(this.this$0);
    if ((wur.a(this.this$0) != null) && (!wur.a(this.this$0).isFinishing()) && (wur.a(this.this$0)))
    {
      String str = wur.a(this.this$0, wur.a(this.this$0));
      Bitmap localBitmap = wur.b(this.this$0).a();
      wur.b(this.this$0, String.valueOf(System.currentTimeMillis()));
      WXShareHelper.a().a(str, localBitmap, axlk.a(270.0F) / 2, this.a, wur.c(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.8
 * JD-Core Version:    0.7.0.1
 */