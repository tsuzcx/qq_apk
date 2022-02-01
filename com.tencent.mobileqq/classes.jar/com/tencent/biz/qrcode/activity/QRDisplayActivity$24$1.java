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
    if (this.b.this$0.isFinishing()) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    localBundle.putString("forward_filepath", this.a);
    localBundle.putString("forward_thumb", this.a);
    localBundle.putString("forward_urldrawable_big_url", this.a);
    localBundle.putString("forward_extra", this.a);
    Intent localIntent = new Intent();
    localIntent.putExtras(localBundle);
    if (this.b.this$0.t == 1)
    {
      ForwardBaseOption.a(this.b.this$0, localIntent, 21, 100500, "biz_src_jc_gxl_ctcshare");
      return;
    }
    ForwardBaseOption.a(this.b.this$0, localIntent, 21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.24.1
 * JD-Core Version:    0.7.0.1
 */