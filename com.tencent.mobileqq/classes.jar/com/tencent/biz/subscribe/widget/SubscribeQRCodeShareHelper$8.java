package com.tencent.biz.subscribe.widget;

import aaau;
import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;

public class SubscribeQRCodeShareHelper$8
  implements Runnable
{
  public SubscribeQRCodeShareHelper$8(aaau paramaaau, int paramInt) {}
  
  public void run()
  {
    aaau.d(this.this$0);
    if ((aaau.a(this.this$0) != null) && (!aaau.a(this.this$0).isFinishing()) && (aaau.a(this.this$0)))
    {
      String str2 = aaau.a(this.this$0, aaau.a(this.this$0));
      Bitmap localBitmap = aaau.b(this.this$0).a();
      aaau.b(this.this$0, String.valueOf(System.currentTimeMillis()));
      QLog.i("SubscribeQRCodeShareHelper", 2, "path : " + str2);
      String str1 = str2;
      if (aaau.b(this.this$0))
      {
        str1 = str2;
        if (aaau.c(this.this$0)) {
          str1 = aaau.a(this.this$0, aaau.a(this.this$0), str2);
        }
      }
      QLog.i("SubscribeQRCodeShareHelper", 2, "fileProviderPath : " + str1);
      WXShareHelper.a().a(str1, localBitmap, ScreenUtil.dip2px(270.0F) / 2, this.a, aaau.c(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.8
 * JD-Core Version:    0.7.0.1
 */