package com.tencent.biz.qrcode.activity;

import android.text.TextUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.ContactUtils;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;

class QRDisplayActivity$15$2
  implements Runnable
{
  QRDisplayActivity$15$2(QRDisplayActivity.15 param15, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$15.this$0.isFinishing()) {
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$15.this$0.jdField_c_of_type_Int == 2) {
        TroopReportor.a("Grp_share", "grpData_admin", "qr_qzone", 0, 0, new String[] { this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$15.this$0.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$15.this$0.jdField_a_of_type_Int), "1" });
      }
      QRUtils.a(1, 2131696460);
      return;
    }
    String str;
    if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$15.this$0.jdField_c_of_type_Int == 2) {
      if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$15.this$0.jdField_c_of_type_Boolean) {
        str = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$15.this$0.getString(2131692178, new Object[] { this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$15.this$0.jdField_a_of_type_JavaLangString });
      }
    }
    for (;;)
    {
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
      localUserInfo.qzone_uin = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$15.this$0.app.getAccount();
      localUserInfo.nickname = ContactUtils.h(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$15.this$0.app, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$15.this$0.app.getAccount());
      QZoneHelper.forwardToPublishMood(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$15.this$0, localUserInfo, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$15.this$0.getString(2131692179), str, 1);
      return;
      str = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$15.this$0.getString(2131692177, new Object[] { this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$15.this$0.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$15.this$0.jdField_c_of_type_JavaLangString });
      continue;
      if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$15.this$0.jdField_c_of_type_Int == 5) {
        str = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$15.this$0.getString(2131692176, new Object[] { this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$15.this$0.jdField_a_of_type_JavaLangString });
      } else if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$15.this$0.jdField_c_of_type_Int == 11) {
        str = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$15.this$0.getString(2131693151);
      } else {
        str = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$15.this$0.getString(2131692180);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.15.2
 * JD-Core Version:    0.7.0.1
 */