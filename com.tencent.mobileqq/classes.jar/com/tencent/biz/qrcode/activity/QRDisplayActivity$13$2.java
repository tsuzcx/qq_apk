package com.tencent.biz.qrcode.activity;

import android.text.TextUtils;
import bhju;
import bhlg;
import bmtd;
import bmtk;
import com.tencent.mobileqq.app.QQAppInterface;
import zyx;

class QRDisplayActivity$13$2
  implements Runnable
{
  QRDisplayActivity$13$2(QRDisplayActivity.13 param13, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$13.this$0.isFinishing()) {
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$13.this$0.jdField_c_of_type_Int == 2) {
        bhju.a("Grp_share", "grpData_admin", "qr_qzone", 0, 0, new String[] { this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$13.this$0.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$13.this$0.jdField_a_of_type_Int), "1" });
      }
      zyx.a(1, 2131695816);
      return;
    }
    String str;
    if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$13.this$0.jdField_c_of_type_Int == 2) {
      if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$13.this$0.jdField_c_of_type_Boolean) {
        str = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$13.this$0.getString(2131691911, new Object[] { this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$13.this$0.jdField_a_of_type_JavaLangString });
      }
    }
    for (;;)
    {
      bmtk localbmtk = bmtk.a();
      localbmtk.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$13.this$0.app.getAccount();
      localbmtk.b = bhlg.h(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$13.this$0.app, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$13.this$0.app.getAccount());
      bmtd.a(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$13.this$0, localbmtk, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$13.this$0.getString(2131691912), str, 1);
      return;
      str = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$13.this$0.getString(2131691910, new Object[] { this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$13.this$0.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$13.this$0.jdField_c_of_type_JavaLangString });
      continue;
      if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$13.this$0.jdField_c_of_type_Int == 5) {
        str = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$13.this$0.getString(2131691909, new Object[] { this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$13.this$0.jdField_a_of_type_JavaLangString });
      } else if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$13.this$0.jdField_c_of_type_Int == 11) {
        str = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$13.this$0.getString(2131692849);
      } else {
        str = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$13.this$0.getString(2131691913);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.13.2
 * JD-Core Version:    0.7.0.1
 */