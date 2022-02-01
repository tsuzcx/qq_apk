package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.graphics.Bitmap;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import java.util.Map;
import tjz;

public class QShareUtils$1
  implements Runnable
{
  public QShareUtils$1(tjz paramtjz, Map paramMap, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, String paramString7) {}
  
  public void run()
  {
    int i = 0;
    tjz.a(this.this$0, String.valueOf(System.currentTimeMillis()));
    Object localObject1 = (Bitmap)this.jdField_a_of_type_JavaUtilMap.remove("image");
    if (this.jdField_a_of_type_Boolean)
    {
      WxShareHelperFromReadInjoy.a().a(tjz.a(this.this$0), this.jdField_a_of_type_JavaLangString, (Bitmap)localObject1, this.b, this.c, this.d, this.e);
      return;
    }
    if (((this.jdField_a_of_type_Int == 9) && (this.f.contains("wx_friend"))) || ((this.jdField_a_of_type_Int == 10) && (this.f.contains("wx_line"))))
    {
      localObject1 = WXShareHelper.getInstance();
      localObject2 = this.g;
      if (this.jdField_a_of_type_Int == 9) {}
      for (i = 0;; i = 1)
      {
        ((WXShareHelper)localObject1).shareText((String)localObject2, i, tjz.a(this.this$0));
        return;
      }
    }
    Object localObject2 = WXShareHelper.getInstance();
    String str1 = tjz.a(this.this$0);
    String str2 = this.jdField_a_of_type_JavaLangString;
    String str3 = this.b;
    String str4 = this.c;
    if (this.jdField_a_of_type_Int == 9) {}
    for (;;)
    {
      ((WXShareHelper)localObject2).shareWebPage(str1, str2, (Bitmap)localObject1, str3, str4, i);
      return;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.QShareUtils.1
 * JD-Core Version:    0.7.0.1
 */