package com.tencent.biz.qrcode.activity;

import bftc;
import yyi;

class QRDisplayActivity$13
  implements Runnable
{
  QRDisplayActivity$13(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void run()
  {
    String str = "temp_qrcode_share_" + this.this$0.jdField_c_of_type_JavaLangString + ".png";
    try
    {
      str = yyi.a(this.this$0.getApplicationContext(), str, this.this$0.b);
      this.this$0.runOnUiThread(new QRDisplayActivity.13.2(this, str));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (this.this$0.jdField_c_of_type_Int == 2) {
        bftc.a("Grp_share", "grpData_admin", "qr_qzone", 0, 0, new String[] { this.this$0.jdField_c_of_type_JavaLangString, String.valueOf(this.this$0.a), "1" });
      }
      this.this$0.runOnUiThread(new QRDisplayActivity.13.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.13
 * JD-Core Version:    0.7.0.1
 */