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
    if ((SubscribeShareHelper.a(this.this$0) != null) && (SubscribeShareHelper.a(this.this$0).isShowing())) {
      SubscribeShareHelper.a(this.this$0).dismiss();
    }
    SubscribeShareHelper.a(this.this$0, String.valueOf(System.currentTimeMillis()));
    Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilMap.remove("image");
    WXShareHelper localWXShareHelper = WXShareHelper.a();
    String str1 = SubscribeShareHelper.a(this.this$0);
    String str2 = this.jdField_a_of_type_JavaLangString;
    String str3 = this.b;
    String str4 = this.c;
    if (this.jdField_a_of_type_Int == 9) {}
    for (int i = 0;; i = 1)
    {
      localWXShareHelper.b(str1, str2, localBitmap, str3, str4, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeShareHelper.4
 * JD-Core Version:    0.7.0.1
 */