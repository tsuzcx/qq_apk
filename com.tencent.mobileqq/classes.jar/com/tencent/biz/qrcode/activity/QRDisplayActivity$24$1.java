package com.tencent.biz.qrcode.activity;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.forward.ForwardBaseOption;

class QRDisplayActivity$24$1
  implements Runnable
{
  QRDisplayActivity$24$1(QRDisplayActivity.24 param24, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$24.this$0.isFinishing()) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    localBundle.putString("forward_filepath", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("forward_thumb", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("forward_urldrawable_big_url", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("forward_extra", this.jdField_a_of_type_JavaLangString);
    Intent localIntent = new Intent();
    localIntent.putExtras(localBundle);
    if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$24.this$0.c == 1)
    {
      ForwardBaseOption.a(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$24.this$0, localIntent, 21, 100500, "biz_src_jc_gxl_ctcshare");
      return;
    }
    ForwardBaseOption.a(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$24.this$0, localIntent, 21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.24.1
 * JD-Core Version:    0.7.0.1
 */