package com.tencent.biz.qqcircle.bizparts;

import android.graphics.Bitmap;
import biau;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import java.util.Map;
import vde;

public class QCircleSharePart$5
  implements Runnable
{
  public QCircleSharePart$5(vde paramvde, Map paramMap, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void run()
  {
    if ((vde.a(this.this$0) != null) && (vde.a(this.this$0).isShowing())) {
      vde.a(this.this$0).dismiss();
    }
    vde.a(this.this$0, String.valueOf(System.currentTimeMillis()));
    Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilMap.remove("image");
    WXShareHelper localWXShareHelper = WXShareHelper.a();
    String str1 = vde.a(this.this$0);
    String str2 = this.jdField_a_of_type_JavaLangString;
    String str3 = this.b;
    String str4 = this.c;
    if (this.jdField_a_of_type_Int == 9) {}
    for (int i = 0;; i = 1)
    {
      localWXShareHelper.d(str1, str2, localBitmap, str3, str4, i);
      QLog.d("QCircleSharePart", 1, "shareToWeChat success");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleSharePart.5
 * JD-Core Version:    0.7.0.1
 */