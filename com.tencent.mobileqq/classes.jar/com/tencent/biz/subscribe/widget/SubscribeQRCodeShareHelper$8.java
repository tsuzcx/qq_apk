package com.tencent.biz.subscribe.widget;

import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import zlp;

public class SubscribeQRCodeShareHelper$8
  implements Runnable
{
  public SubscribeQRCodeShareHelper$8(zlp paramzlp, int paramInt) {}
  
  public void run()
  {
    zlp.d(this.this$0);
    if ((zlp.a(this.this$0) != null) && (!zlp.a(this.this$0).isFinishing()) && (zlp.a(this.this$0)))
    {
      String str2 = zlp.a(this.this$0, zlp.a(this.this$0));
      Bitmap localBitmap = zlp.b(this.this$0).a();
      zlp.b(this.this$0, String.valueOf(System.currentTimeMillis()));
      QLog.i("SubscribeQRCodeShareHelper", 2, "path : " + str2);
      String str1 = str2;
      if (zlp.b(this.this$0))
      {
        str1 = str2;
        if (zlp.c(this.this$0)) {
          str1 = zlp.a(this.this$0, zlp.a(this.this$0), str2);
        }
      }
      QLog.i("SubscribeQRCodeShareHelper", 2, "fileProviderPath : " + str1);
      WXShareHelper.getInstance().shareImageToWX(str1, localBitmap, ScreenUtil.dip2px(270.0F) / 2, this.a, zlp.c(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.8
 * JD-Core Version:    0.7.0.1
 */