package com.tencent.biz.subscribe.widget;

import android.app.Activity;
import android.graphics.Bitmap;
import azgq;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import yjk;

public class SubscribeQRCodeShareHelper$8
  implements Runnable
{
  public SubscribeQRCodeShareHelper$8(yjk paramyjk, int paramInt) {}
  
  public void run()
  {
    yjk.d(this.this$0);
    if ((yjk.a(this.this$0) != null) && (!yjk.a(this.this$0).isFinishing()) && (yjk.a(this.this$0)))
    {
      String str2 = yjk.a(this.this$0, yjk.a(this.this$0));
      Bitmap localBitmap = yjk.b(this.this$0).a();
      yjk.b(this.this$0, String.valueOf(System.currentTimeMillis()));
      QLog.i("SubscribeQRCodeShareHelper", 2, "path : " + str2);
      String str1 = str2;
      if (yjk.b(this.this$0))
      {
        str1 = str2;
        if (yjk.c(this.this$0)) {
          str1 = yjk.a(this.this$0, yjk.a(this.this$0), str2);
        }
      }
      QLog.i("SubscribeQRCodeShareHelper", 2, "fileProviderPath : " + str1);
      WXShareHelper.a().a(str1, localBitmap, azgq.a(270.0F) / 2, this.a, yjk.c(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.8
 * JD-Core Version:    0.7.0.1
 */