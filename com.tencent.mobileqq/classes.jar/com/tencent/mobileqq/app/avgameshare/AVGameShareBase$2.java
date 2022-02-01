package com.tencent.mobileqq.app.avgameshare;

import android.graphics.Bitmap;
import android.text.TextUtils;
import aoaw;
import bcst;
import biau;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class AVGameShareBase$2
  implements Runnable
{
  public AVGameShareBase$2(aoaw paramaoaw, Map paramMap, int paramInt, String paramString) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_Biau != null) && (this.this$0.jdField_a_of_type_Biau.isShowing())) {
      this.this$0.jdField_a_of_type_Biau.dismiss();
    }
    this.this$0.jdField_a_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
    Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilMap.remove("image");
    String str1 = this.this$0.c();
    String str2;
    if (TextUtils.isEmpty(str1))
    {
      str1 = "派对已开始，你在等什么";
      str2 = "快来QQ，加入我的派对";
      if (this.jdField_a_of_type_Int != 9) {
        break label252;
      }
      str2 = "QQ一起派对";
    }
    label252:
    for (int i = 0;; i = 1)
    {
      WXShareHelper.a().b(this.this$0.jdField_a_of_type_JavaLangString, str2, localBitmap, str1, this.jdField_a_of_type_JavaLangString, i);
      QLog.d("AVGameShareBase", 1, "shareLinkToWeChat success");
      if (this.this$0.a() == 0)
      {
        if (this.jdField_a_of_type_Int == 9) {}
        for (str1 = "3";; str1 = "4")
        {
          bcst.b(null, "dc00898", "", "", "0X800B068", "0X800B068", 0, 0, str1, "", "", "");
          return;
          str1 = str1 + "的派对已开始，你在等什么";
          break;
        }
      }
      i = this.this$0.a();
      if (this.jdField_a_of_type_Int == 9) {}
      for (str1 = "3";; str1 = "4")
      {
        bcst.b(null, "dc00898", "", "", "0X800B064", "0X800B064", i, 0, str1, "", "", "");
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.avgameshare.AVGameShareBase.2
 * JD-Core Version:    0.7.0.1
 */