package com.tencent.biz.qrcode.activity;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.forward.ForwardBaseOption;

class QRDisplayActivity$31$1
  implements Runnable
{
  QRDisplayActivity$31$1(QRDisplayActivity.31 param31, String paramString) {}
  
  public void run()
  {
    if (this.b.this$0.isFinishing()) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    localBundle.putString("forward_filepath", this.a);
    localBundle.putString("forward_thumb", this.a);
    localBundle.putString("forward_urldrawable_big_url", this.a);
    localBundle.putString("forward_extra", this.a);
    localBundle.putInt("key_req", 1);
    localBundle.putInt("key_direct_show_uin_type", this.b.b);
    localBundle.putString("key_direct_show_uin", this.b.c);
    if ((6000 == this.b.b) && (AppConstants.DATALINE_PC_UIN == this.b.c)) {
      localBundle.putBoolean("filepath_copy", true);
    }
    Intent localIntent = new Intent();
    localIntent.putExtras(localBundle);
    ForwardBaseOption.a(this.b.this$0, localIntent, ForwardRecentTranslucentActivity.class, 21, 100500, "biz_src_jc_gxl_ctcshare");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.31.1
 * JD-Core Version:    0.7.0.1
 */