package com.tencent.mobileqq.app.avgameshare;

import android.graphics.Bitmap;
import angy;
import bcef;
import bhht;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class AVGameShareResultPic$2
  implements Runnable
{
  public AVGameShareResultPic$2(angy paramangy, Map paramMap, int paramInt) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_Bhht != null) && (this.this$0.jdField_a_of_type_Bhht.isShowing())) {
      this.this$0.jdField_a_of_type_Bhht.dismiss();
    }
    this.this$0.jdField_a_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
    Object localObject = (Bitmap)this.jdField_a_of_type_JavaUtilMap.remove("image");
    WXShareHelper localWXShareHelper = WXShareHelper.getInstance();
    String str = angy.a(this.this$0);
    int i;
    if (this.jdField_a_of_type_Int == 9)
    {
      i = 0;
      localWXShareHelper.shareImageToWX(str, (Bitmap)localObject, i, false, this.this$0.jdField_a_of_type_JavaLangString);
      QLog.d("AVGameShareResultPic", 1, "shareToWeChat success");
      if (this.jdField_a_of_type_Int != 9) {
        break label150;
      }
    }
    label150:
    for (localObject = "3";; localObject = "4")
    {
      bcef.b(null, "dc00898", "", "", "0X800B064", "0X800B064", 0, 0, (String)localObject, "", "", "");
      return;
      i = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.avgameshare.AVGameShareResultPic.2
 * JD-Core Version:    0.7.0.1
 */