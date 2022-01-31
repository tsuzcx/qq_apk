package com.tencent.biz.qrcode.activity;

import android.content.Intent;
import android.net.Uri;
import bcpw;
import com.tencent.common.app.BaseApplicationImpl;
import wim;

class QRDisplayActivity$10$1
  implements Runnable
{
  QRDisplayActivity$10$1(QRDisplayActivity.10 param10, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      localIntent.setData(Uri.parse("file://" + this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$10.this$0.sendBroadcast(localIntent);
      bcpw.a(BaseApplicationImpl.getContext(), 2, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$10.this$0.getString(2131717236, new Object[] { this.jdField_a_of_type_JavaLangString }), 1).b(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$10.this$0.getTitleBarHeight());
      return;
    }
    wim.a(1, 2131717235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.10.1
 * JD-Core Version:    0.7.0.1
 */