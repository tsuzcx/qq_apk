package com.tencent.biz.subscribe.widget;

import android.app.Activity;
import android.graphics.Bitmap;
import awmc;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import wfw;

public class SubscribeQRCodeShareHelper$7
  implements Runnable
{
  public SubscribeQRCodeShareHelper$7(wfw paramwfw, int paramInt) {}
  
  public void run()
  {
    wfw.d(this.this$0);
    if ((wfw.a(this.this$0) != null) && (!wfw.a(this.this$0).isFinishing()) && (wfw.a(this.this$0)))
    {
      String str = wfw.b(this.this$0);
      Bitmap localBitmap = wfw.a(this.this$0).a();
      wfw.a(this.this$0, String.valueOf(System.currentTimeMillis()));
      WXShareHelper.a().a(str, localBitmap, awmc.a(270.0F) / 2, this.a, wfw.c(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.7
 * JD-Core Version:    0.7.0.1
 */