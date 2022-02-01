package com.tencent.biz.subscribe.widget;

import aakt;
import android.app.Activity;
import android.graphics.Bitmap;
import bclx;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;

public class SubscribeQRCodeShareHelper$8
  implements Runnable
{
  public SubscribeQRCodeShareHelper$8(aakt paramaakt, int paramInt) {}
  
  public void run()
  {
    aakt.d(this.this$0);
    if ((aakt.a(this.this$0) != null) && (!aakt.a(this.this$0).isFinishing()) && (aakt.a(this.this$0)))
    {
      String str2 = aakt.a(this.this$0, aakt.a(this.this$0));
      Bitmap localBitmap = aakt.b(this.this$0).a();
      aakt.b(this.this$0, String.valueOf(System.currentTimeMillis()));
      QLog.i("SubscribeQRCodeShareHelper", 2, "path : " + str2);
      String str1 = str2;
      if (aakt.b(this.this$0))
      {
        str1 = str2;
        if (aakt.c(this.this$0)) {
          str1 = aakt.a(this.this$0, aakt.a(this.this$0), str2);
        }
      }
      QLog.i("SubscribeQRCodeShareHelper", 2, "fileProviderPath : " + str1);
      WXShareHelper.a().a(str1, localBitmap, bclx.a(270.0F) / 2, this.a, aakt.c(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.8
 * JD-Core Version:    0.7.0.1
 */