package com.tencent.biz.subscribe.widget;

import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;

class SubscribeQRCodeShareHelper$8
  implements Runnable
{
  SubscribeQRCodeShareHelper$8(SubscribeQRCodeShareHelper paramSubscribeQRCodeShareHelper, int paramInt) {}
  
  public void run()
  {
    SubscribeQRCodeShareHelper.d(this.this$0);
    if ((SubscribeQRCodeShareHelper.a(this.this$0) != null) && (!SubscribeQRCodeShareHelper.a(this.this$0).isFinishing()) && (SubscribeQRCodeShareHelper.a(this.this$0)))
    {
      Object localObject1 = this.this$0;
      Object localObject2 = SubscribeQRCodeShareHelper.a((SubscribeQRCodeShareHelper)localObject1, SubscribeQRCodeShareHelper.a((SubscribeQRCodeShareHelper)localObject1));
      Bitmap localBitmap = SubscribeQRCodeShareHelper.b(this.this$0).a();
      SubscribeQRCodeShareHelper.b(this.this$0, String.valueOf(System.currentTimeMillis()));
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("path : ");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.i("SubscribeQRCodeShareHelper", 2, ((StringBuilder)localObject1).toString());
      localObject1 = localObject2;
      if (SubscribeQRCodeShareHelper.b(this.this$0))
      {
        localObject1 = localObject2;
        if (SubscribeQRCodeShareHelper.c(this.this$0))
        {
          localObject1 = this.this$0;
          localObject1 = SubscribeQRCodeShareHelper.a((SubscribeQRCodeShareHelper)localObject1, SubscribeQRCodeShareHelper.a((SubscribeQRCodeShareHelper)localObject1), (String)localObject2);
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("fileProviderPath : ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("SubscribeQRCodeShareHelper", 2, ((StringBuilder)localObject2).toString());
      WXShareHelper.a().a((String)localObject1, localBitmap, ScreenUtil.dip2px(270.0F) / 2, this.a, SubscribeQRCodeShareHelper.c(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.8
 * JD-Core Version:    0.7.0.1
 */