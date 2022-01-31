package com.tencent.biz.qrcode.activity;

import android.text.TextUtils;
import bbbp;
import bbcz;
import bgyp;
import bgyw;
import com.tencent.mobileqq.app.QQAppInterface;
import wij;

class QRDisplayActivity$11$2
  implements Runnable
{
  QRDisplayActivity$11$2(QRDisplayActivity.11 param11, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.isFinishing()) {
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.jdField_c_of_type_Int == 2) {
        bbbp.a("Grp_share", "grpData_admin", "qr_qzone", 0, 0, new String[] { this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.jdField_a_of_type_Int), "1" });
      }
      wij.a(1, 2131696769);
      return;
    }
    String str;
    if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.jdField_c_of_type_Int == 2) {
      if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.jdField_c_of_type_Boolean) {
        str = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.getString(2131692225, new Object[] { this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.jdField_a_of_type_JavaLangString });
      }
    }
    for (;;)
    {
      bgyw localbgyw = bgyw.a();
      localbgyw.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.app.getAccount();
      localbgyw.b = bbcz.h(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.app, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.app.getAccount());
      bgyp.a(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0, localbgyw, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.getString(2131692226), str, 1);
      return;
      str = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.getString(2131692224, new Object[] { this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.jdField_c_of_type_JavaLangString });
      continue;
      if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.jdField_c_of_type_Int == 5) {
        str = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.getString(2131692223, new Object[] { this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.jdField_a_of_type_JavaLangString });
      } else if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.jdField_c_of_type_Int == 11) {
        str = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.getString(2131693246);
      } else {
        str = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.getString(2131692227);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.11.2
 * JD-Core Version:    0.7.0.1
 */