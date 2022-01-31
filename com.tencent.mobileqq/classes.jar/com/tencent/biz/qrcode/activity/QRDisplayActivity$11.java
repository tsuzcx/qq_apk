package com.tencent.biz.qrcode.activity;

import bdaj;
import xxb;

class QRDisplayActivity$11
  implements Runnable
{
  QRDisplayActivity$11(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void run()
  {
    String str = "temp_qrcode_share_" + this.this$0.jdField_c_of_type_JavaLangString + ".png";
    try
    {
      str = xxb.a(this.this$0.getApplicationContext(), str, this.this$0.b);
      this.this$0.runOnUiThread(new QRDisplayActivity.11.2(this, str));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (this.this$0.jdField_c_of_type_Int == 2) {
        bdaj.a("Grp_share", "grpData_admin", "qr_qzone", 0, 0, new String[] { this.this$0.jdField_c_of_type_JavaLangString, String.valueOf(this.this$0.a), "1" });
      }
      this.this$0.runOnUiThread(new QRDisplayActivity.11.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.11
 * JD-Core Version:    0.7.0.1
 */