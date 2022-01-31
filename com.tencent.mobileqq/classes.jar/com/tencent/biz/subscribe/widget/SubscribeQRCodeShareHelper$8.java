package com.tencent.biz.subscribe.widget;

import android.app.Activity;
import android.graphics.Bitmap;
import azkz;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import ynx;

public class SubscribeQRCodeShareHelper$8
  implements Runnable
{
  public SubscribeQRCodeShareHelper$8(ynx paramynx, int paramInt) {}
  
  public void run()
  {
    ynx.d(this.this$0);
    if ((ynx.a(this.this$0) != null) && (!ynx.a(this.this$0).isFinishing()) && (ynx.a(this.this$0)))
    {
      String str2 = ynx.a(this.this$0, ynx.a(this.this$0));
      Bitmap localBitmap = ynx.b(this.this$0).a();
      ynx.b(this.this$0, String.valueOf(System.currentTimeMillis()));
      QLog.i("SubscribeQRCodeShareHelper", 2, "path : " + str2);
      String str1 = str2;
      if (ynx.b(this.this$0))
      {
        str1 = str2;
        if (ynx.c(this.this$0)) {
          str1 = ynx.a(this.this$0, ynx.a(this.this$0), str2);
        }
      }
      QLog.i("SubscribeQRCodeShareHelper", 2, "fileProviderPath : " + str1);
      WXShareHelper.a().a(str1, localBitmap, azkz.a(270.0F) / 2, this.a, ynx.c(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.8
 * JD-Core Version:    0.7.0.1
 */