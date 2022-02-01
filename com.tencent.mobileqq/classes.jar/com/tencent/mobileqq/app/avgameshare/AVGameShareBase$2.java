package com.tencent.mobileqq.app.avgameshare;

import android.graphics.Bitmap;
import android.text.TextUtils;
import angs;
import bcef;
import bhht;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class AVGameShareBase$2
  implements Runnable
{
  public AVGameShareBase$2(angs paramangs, Map paramMap, int paramInt, String paramString) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_Bhht != null) && (this.this$0.jdField_a_of_type_Bhht.isShowing())) {
      this.this$0.jdField_a_of_type_Bhht.dismiss();
    }
    this.this$0.jdField_a_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
    Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilMap.remove("image");
    Object localObject1 = this.this$0.c();
    Object localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = "派对已开始，你在等什么";
      localObject2 = "快来QQ，加入我的派对";
      if (this.jdField_a_of_type_Int != 9) {
        break label297;
      }
      localObject2 = "QQ一起派对";
    }
    label297:
    for (int i = 0;; i = 1)
    {
      if (this.this$0.a())
      {
        localObject2 = this.this$0.b(this.jdField_a_of_type_Int);
        localObject1 = this.this$0.a(this.jdField_a_of_type_Int);
      }
      for (;;)
      {
        WXShareHelper.getInstance().shareWebPage(this.this$0.jdField_a_of_type_JavaLangString, (String)localObject1, localBitmap, (String)localObject2, this.jdField_a_of_type_JavaLangString, i);
        QLog.d("AVGameShareBase", 1, "shareLinkToWeChat success");
        if (this.this$0.a() == 0)
        {
          if (this.jdField_a_of_type_Int == 9) {}
          for (localObject1 = "3";; localObject1 = "4")
          {
            bcef.b(null, "dc00898", "", "", "0X800B068", "0X800B068", 0, 0, (String)localObject1, "", "", "");
            return;
            localObject1 = (String)localObject1 + "的派对已开始，你在等什么";
            break;
          }
        }
        i = this.this$0.a();
        if (this.jdField_a_of_type_Int == 9) {}
        for (localObject1 = "3";; localObject1 = "4")
        {
          bcef.b(null, "dc00898", "", "", "0X800B064", "0X800B064", i, 0, (String)localObject1, "", "", "");
          return;
        }
        Object localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.avgameshare.AVGameShareBase.2
 * JD-Core Version:    0.7.0.1
 */