package com.tencent.biz.qrcode.activity;

import android.text.TextUtils;
import bgjt;
import bglf;
import blsb;
import blsi;
import com.tencent.mobileqq.app.QQAppInterface;
import zvc;

class QRDisplayActivity$12$2
  implements Runnable
{
  QRDisplayActivity$12$2(QRDisplayActivity.12 param12, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$12.this$0.isFinishing()) {
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$12.this$0.jdField_c_of_type_Int == 2) {
        bgjt.a("Grp_share", "grpData_admin", "qr_qzone", 0, 0, new String[] { this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$12.this$0.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$12.this$0.jdField_a_of_type_Int), "1" });
      }
      zvc.a(1, 2131695773);
      return;
    }
    String str;
    if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$12.this$0.jdField_c_of_type_Int == 2) {
      if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$12.this$0.jdField_c_of_type_Boolean) {
        str = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$12.this$0.getString(2131691907, new Object[] { this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$12.this$0.jdField_a_of_type_JavaLangString });
      }
    }
    for (;;)
    {
      blsi localblsi = blsi.a();
      localblsi.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$12.this$0.app.getAccount();
      localblsi.b = bglf.h(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$12.this$0.app, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$12.this$0.app.getAccount());
      blsb.a(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$12.this$0, localblsi, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$12.this$0.getString(2131691908), str, 1);
      return;
      str = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$12.this$0.getString(2131691906, new Object[] { this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$12.this$0.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$12.this$0.jdField_c_of_type_JavaLangString });
      continue;
      if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$12.this$0.jdField_c_of_type_Int == 5) {
        str = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$12.this$0.getString(2131691905, new Object[] { this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$12.this$0.jdField_a_of_type_JavaLangString });
      } else if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$12.this$0.jdField_c_of_type_Int == 11) {
        str = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$12.this$0.getString(2131692841);
      } else {
        str = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$12.this$0.getString(2131691909);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.12.2
 * JD-Core Version:    0.7.0.1
 */