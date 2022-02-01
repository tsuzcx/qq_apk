package com.tencent.biz.subscribe.widget;

import android.app.Activity;
import android.graphics.Bitmap;

class SubscribeQRCodeShareHelper$2$1
  implements Runnable
{
  SubscribeQRCodeShareHelper$2$1(SubscribeQRCodeShareHelper.2 param2, Bitmap paramBitmap) {}
  
  public void run()
  {
    if ((SubscribeQRCodeShareHelper.c(this.b.this$0) != null) && (!SubscribeQRCodeShareHelper.c(this.b.this$0).isFinishing()))
    {
      SubscribeQRCodeShareHelper.a(this.b.this$0, SubscribeQRCodeShareHelper.d(this.b.this$0));
      if (SubscribeQRCodeShareHelper.e(this.b.this$0) != null) {
        SubscribeQRCodeShareHelper.e(this.b.this$0).a(SubscribeQRCodeShareHelper.f(this.b.this$0), this.a, new SubscribeQRCodeShareHelper.2.1.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.2.1
 * JD-Core Version:    0.7.0.1
 */