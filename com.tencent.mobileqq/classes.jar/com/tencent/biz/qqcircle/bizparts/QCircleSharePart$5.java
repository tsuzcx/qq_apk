package com.tencent.biz.qqcircle.bizparts;

import android.graphics.Bitmap;
import bjbs;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import java.util.Map;
import vfi;

public class QCircleSharePart$5
  implements Runnable
{
  public QCircleSharePart$5(vfi paramvfi, Map paramMap, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void run()
  {
    if ((vfi.a(this.this$0) != null) && (vfi.a(this.this$0).isShowing())) {
      vfi.a(this.this$0).dismiss();
    }
    vfi.a(this.this$0, String.valueOf(System.currentTimeMillis()));
    Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilMap.remove("image");
    WXShareHelper localWXShareHelper = WXShareHelper.a();
    String str1 = vfi.a(this.this$0);
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