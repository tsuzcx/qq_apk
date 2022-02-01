package com.tencent.biz.qrcode.activity;

import android.text.TextUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.wxapi.WXShareHelper;

class QRDisplayActivity$23$1
  implements Runnable
{
  QRDisplayActivity$23$1(QRDisplayActivity.23 param23, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$23.this$0.isFinishing()) {
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      QRUtils.a(1, 2131696479);
      if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$23.this$0.jdField_c_of_type_Int == 2)
      {
        String str;
        if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$23.this$0.i == 2) {
          str = "qr_wechat";
        } else {
          str = "qr_circle";
        }
        TroopReportor.a("Grp_share", "grpData_admin", str, 0, 0, new String[] { this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$23.this$0.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$23.this$0.a), "1" });
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$23.this$0.i == 2)
    {
      WXShareHelper.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$23.this$0.b, 0);
      if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$23.this$0.jdField_c_of_type_Int == 2)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$23.this$0.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_wechat", 0, 0, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$23.this$0.jdField_c_of_type_JavaLangString, "", String.valueOf(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$23.this$0.a), "");
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$23.this$0.jdField_c_of_type_Int == 5) {
        ReportController.b(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$23.this$0.app, "CliOper", "", "", "0X8006676", "0X8006676", 0, 0, "", "", "", "");
      }
    }
    else
    {
      WXShareHelper.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$23.this$0.b, 1);
      if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$23.this$0.jdField_c_of_type_Int == 2)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$23.this$0.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_circle", 0, 0, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$23.this$0.jdField_c_of_type_JavaLangString, "", String.valueOf(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$23.this$0.a), "");
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$23.this$0.jdField_c_of_type_Int == 5) {
        ReportController.b(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$23.this$0.app, "CliOper", "", "", "0X8006677", "0X8006677", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.23.1
 * JD-Core Version:    0.7.0.1
 */