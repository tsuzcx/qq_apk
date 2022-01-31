package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.graphics.Bitmap;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import java.util.Map;
import rlv;

public class QShareUtils$1
  implements Runnable
{
  public QShareUtils$1(rlv paramrlv, Map paramMap, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt) {}
  
  public void run()
  {
    rlv.a(this.this$0, String.valueOf(System.currentTimeMillis()));
    Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilMap.remove("image");
    if (this.jdField_a_of_type_Boolean)
    {
      WxShareHelperFromReadInjoy.a().a(rlv.a(this.this$0), this.jdField_a_of_type_JavaLangString, localBitmap, this.b, this.c, this.d, this.e);
      return;
    }
    WXShareHelper localWXShareHelper = WXShareHelper.a();
    String str1 = rlv.a(this.this$0);
    String str2 = this.jdField_a_of_type_JavaLangString;
    String str3 = this.b;
    String str4 = this.c;
    if (this.jdField_a_of_type_Int == 4) {}
    for (int i = 0;; i = 1)
    {
      localWXShareHelper.b(str1, str2, localBitmap, str3, str4, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.QShareUtils.1
 * JD-Core Version:    0.7.0.1
 */