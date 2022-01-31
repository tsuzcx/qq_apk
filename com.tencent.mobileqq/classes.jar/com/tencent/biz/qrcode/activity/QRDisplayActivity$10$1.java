package com.tencent.biz.qrcode.activity;

import android.content.Intent;
import android.net.Uri;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import xxb;

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
      QQToast.a(BaseApplicationImpl.getContext(), 2, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$10.this$0.getString(2131717619, new Object[] { this.jdField_a_of_type_JavaLangString }), 1).b(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$10.this$0.getTitleBarHeight());
      return;
    }
    xxb.a(1, 2131717618);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.10.1
 * JD-Core Version:    0.7.0.1
 */