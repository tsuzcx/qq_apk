package com.tencent.biz.subscribe.widget;

import aaou;
import android.app.Activity;
import android.graphics.Bitmap;
import bdep;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;

public class SubscribeQRCodeShareHelper$8
  implements Runnable
{
  public SubscribeQRCodeShareHelper$8(aaou paramaaou, int paramInt) {}
  
  public void run()
  {
    aaou.d(this.this$0);
    if ((aaou.a(this.this$0) != null) && (!aaou.a(this.this$0).isFinishing()) && (aaou.a(this.this$0)))
    {
      String str2 = aaou.a(this.this$0, aaou.a(this.this$0));
      Bitmap localBitmap = aaou.b(this.this$0).a();
      aaou.b(this.this$0, String.valueOf(System.currentTimeMillis()));
      QLog.i("SubscribeQRCodeShareHelper", 2, "path : " + str2);
      String str1 = str2;
      if (aaou.b(this.this$0))
      {
        str1 = str2;
        if (aaou.c(this.this$0)) {
          str1 = aaou.a(this.this$0, aaou.a(this.this$0), str2);
        }
      }
      QLog.i("SubscribeQRCodeShareHelper", 2, "fileProviderPath : " + str1);
      WXShareHelper.a().a(str1, localBitmap, bdep.a(270.0F) / 2, this.a, aaou.c(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.8
 * JD-Core Version:    0.7.0.1
 */