package com.tencent.biz.qrcode.activity;

import android.text.TextUtils;
import bcst;
import bgjt;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import zvc;

class QRDisplayActivity$20$1
  implements Runnable
{
  QRDisplayActivity$20$1(QRDisplayActivity.20 param20, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$20.this$0.isFinishing()) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
            break;
          }
          zvc.a(1, 2131695773);
        } while (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$20.this$0.jdField_c_of_type_Int != 2);
        if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$20.this$0.i == 2) {}
        for (String str = "qr_wechat";; str = "qr_circle")
        {
          bgjt.a("Grp_share", "grpData_admin", str, 0, 0, new String[] { this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$20.this$0.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$20.this$0.a), "1" });
          return;
        }
        if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$20.this$0.i != 2) {
          break;
        }
        WXShareHelper.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$20.this$0.b, 0);
        if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$20.this$0.jdField_c_of_type_Int == 2)
        {
          bcst.b(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$20.this$0.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_wechat", 0, 0, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$20.this$0.jdField_c_of_type_JavaLangString, "", String.valueOf(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$20.this$0.a), "");
          return;
        }
      } while (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$20.this$0.jdField_c_of_type_Int != 5);
      bcst.b(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$20.this$0.app, "CliOper", "", "", "0X8006676", "0X8006676", 0, 0, "", "", "", "");
      return;
      WXShareHelper.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$20.this$0.b, 1);
      if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$20.this$0.jdField_c_of_type_Int == 2)
      {
        bcst.b(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$20.this$0.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_circle", 0, 0, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$20.this$0.jdField_c_of_type_JavaLangString, "", String.valueOf(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$20.this$0.a), "");
        return;
      }
    } while (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$20.this$0.jdField_c_of_type_Int != 5);
    bcst.b(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$20.this$0.app, "CliOper", "", "", "0X8006677", "0X8006677", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.20.1
 * JD-Core Version:    0.7.0.1
 */