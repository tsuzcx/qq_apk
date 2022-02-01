package com.tencent.biz.subscribe.widget;

import android.graphics.Bitmap;
import bhht;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import java.util.Map;
import zlv;

public class SubscribeShareHelper$4
  implements Runnable
{
  public SubscribeShareHelper$4(zlv paramzlv, Map paramMap, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void run()
  {
    if ((zlv.a(this.this$0) != null) && (zlv.a(this.this$0).isShowing())) {
      zlv.a(this.this$0).dismiss();
    }
    zlv.a(this.this$0, String.valueOf(System.currentTimeMillis()));
    Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilMap.remove("image");
    WXShareHelper localWXShareHelper = WXShareHelper.getInstance();
    String str1 = zlv.a(this.this$0);
    String str2 = this.jdField_a_of_type_JavaLangString;
    String str3 = this.b;
    String str4 = this.c;
    if (this.jdField_a_of_type_Int == 9) {}
    for (int i = 0;; i = 1)
    {
      localWXShareHelper.shareWebPage(str1, str2, localBitmap, str3, str4, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeShareHelper.4
 * JD-Core Version:    0.7.0.1
 */