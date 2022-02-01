package com.tencent.biz.qrcode.activity;

import android.content.Intent;
import android.os.Bundle;
import atky;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.app.AppConstants;

class QRDisplayActivity$29$1
  implements Runnable
{
  QRDisplayActivity$29$1(QRDisplayActivity.29 param29, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$29.this$0.isFinishing()) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    localBundle.putString("forward_filepath", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("forward_thumb", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("forward_urldrawable_big_url", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("forward_extra", this.jdField_a_of_type_JavaLangString);
    localBundle.putInt("key_req", ForwardRecentActivity.f);
    localBundle.putInt("key_direct_show_uin_type", this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$29.a);
    localBundle.putString("key_direct_show_uin", this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$29.b);
    if ((6000 == this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$29.a) && (AppConstants.DATALINE_PC_UIN == this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$29.b)) {
      localBundle.putBoolean("filepath_copy", true);
    }
    Intent localIntent = new Intent();
    localIntent.putExtras(localBundle);
    atky.a(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$29.this$0, localIntent, ForwardRecentTranslucentActivity.class, 21, 100500, "biz_src_jc_gxl_ctcshare");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.29.1
 * JD-Core Version:    0.7.0.1
 */