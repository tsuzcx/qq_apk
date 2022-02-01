package com.tencent.biz.qrcode.activity;

import android.content.Intent;
import android.os.Bundle;
import anhk;
import aufz;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;

class QRDisplayActivity$28$1
  implements Runnable
{
  QRDisplayActivity$28$1(QRDisplayActivity.28 param28, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$28.this$0.isFinishing()) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    localBundle.putString("forward_filepath", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("forward_thumb", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("forward_urldrawable_big_url", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("forward_extra", this.jdField_a_of_type_JavaLangString);
    localBundle.putInt("key_req", ForwardRecentActivity.f);
    localBundle.putInt("key_direct_show_uin_type", this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$28.a);
    localBundle.putString("key_direct_show_uin", this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$28.b);
    if ((6000 == this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$28.a) && (anhk.z == this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$28.b)) {
      localBundle.putBoolean("filepath_copy", true);
    }
    Intent localIntent = new Intent();
    localIntent.putExtras(localBundle);
    aufz.a(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$28.this$0, localIntent, ForwardRecentTranslucentActivity.class, 21, 100500, "biz_src_jc_gxl_ctcshare");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.28.1
 * JD-Core Version:    0.7.0.1
 */