package com.tencent.biz.qrcode.activity;

import android.text.TextUtils;
import bdaj;
import bdbt;
import bizm;
import bizt;
import com.tencent.mobileqq.app.QQAppInterface;
import xxb;

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
        bdaj.a("Grp_share", "grpData_admin", "qr_qzone", 0, 0, new String[] { this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.jdField_a_of_type_Int), "1" });
      }
      xxb.a(1, 2131696944);
      return;
    }
    String str;
    if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.jdField_c_of_type_Int == 2) {
      if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.jdField_c_of_type_Boolean) {
        str = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.getString(2131692301, new Object[] { this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.jdField_a_of_type_JavaLangString });
      }
    }
    for (;;)
    {
      bizt localbizt = bizt.a();
      localbizt.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.app.getAccount();
      localbizt.b = bdbt.h(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.app, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.app.getAccount());
      bizm.a(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0, localbizt, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.getString(2131692302), str, 1);
      return;
      str = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.getString(2131692300, new Object[] { this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.jdField_c_of_type_JavaLangString });
      continue;
      if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.jdField_c_of_type_Int == 5) {
        str = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.getString(2131692299, new Object[] { this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.jdField_a_of_type_JavaLangString });
      } else if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.jdField_c_of_type_Int == 11) {
        str = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.getString(2131693347);
      } else {
        str = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$11.this$0.getString(2131692303);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.11.2
 * JD-Core Version:    0.7.0.1
 */