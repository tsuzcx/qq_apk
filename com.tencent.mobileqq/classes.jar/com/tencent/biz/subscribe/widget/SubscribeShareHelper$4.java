package com.tencent.biz.subscribe.widget;

import android.graphics.Bitmap;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import java.util.Map;

class SubscribeShareHelper$4
  implements Runnable
{
  SubscribeShareHelper$4(SubscribeShareHelper paramSubscribeShareHelper, Map paramMap, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void run()
  {
    if ((SubscribeShareHelper.i(this.this$0) != null) && (SubscribeShareHelper.i(this.this$0).isShowing())) {
      SubscribeShareHelper.i(this.this$0).dismiss();
    }
    SubscribeShareHelper.a(this.this$0, String.valueOf(System.currentTimeMillis()));
    Bitmap localBitmap = (Bitmap)this.a.remove("image");
    WXShareHelper localWXShareHelper = WXShareHelper.a();
    String str1 = SubscribeShareHelper.j(this.this$0);
    String str2 = this.b;
    String str3 = this.c;
    String str4 = this.d;
    int i;
    if (this.e == 9) {
      i = 0;
    } else {
      i = 1;
    }
    localWXShareHelper.a(str1, str2, localBitmap, str3, str4, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeShareHelper.4
 * JD-Core Version:    0.7.0.1
 */