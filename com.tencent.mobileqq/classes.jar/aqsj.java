import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.mobileqq.jsp.QQApiPlugin.3;
import com.tencent.mobileqq.wxapi.WXShareHelper;

public class aqsj
  implements wiu
{
  public aqsj(QQApiPlugin.3 param3, Bitmap paramBitmap) {}
  
  public void a(Bundle paramBundle)
  {
    int j = 0;
    int i = 0;
    if (paramBundle.getInt("readinjoy_to_wx_config") == 0)
    {
      paramBundle = WxShareHelperFromReadInjoy.a();
      str1 = this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin$3.this$0.c;
      str2 = this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin$3.d;
      localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
      str3 = this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin$3.e;
      str4 = this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin$3.b;
      if ("2".equals(this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin$3.a)) {}
      for (;;)
      {
        paramBundle.a(str1, str2, localBitmap, str3, str4, i);
        return;
        i = 1;
      }
    }
    paramBundle = WXShareHelper.a();
    String str1 = this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin$3.this$0.c;
    String str2 = this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin$3.d;
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    String str3 = this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin$3.e;
    String str4 = this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin$3.b;
    if ("2".equals(this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin$3.a)) {}
    for (i = j;; i = 1)
    {
      paramBundle.b(str1, str2, localBitmap, str3, str4, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqsj
 * JD-Core Version:    0.7.0.1
 */