package com.tencent.biz.qrcode.activity;

import android.content.Intent;
import android.net.Uri;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class QRDisplayActivity$14$1
  implements Runnable
{
  QRDisplayActivity$14$1(QRDisplayActivity.14 param14, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      localIntent.setData(Uri.parse("file://" + this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$14.this$0.sendBroadcast(localIntent);
      QQToast.a(BaseApplicationImpl.getContext(), 2, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$14.this$0.getString(2131694923), 1).b(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$14.this$0.getTitleBarHeight());
      return;
    }
    QRUtils.a(1, 2131717053);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.14.1
 * JD-Core Version:    0.7.0.1
 */