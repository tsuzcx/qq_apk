package com.tencent.biz.qrcode.activity;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;

class QRDisplayActivity$8
  implements Runnable
{
  QRDisplayActivity$8(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void run()
  {
    int i = this.this$0.c.getHeight();
    if (this.this$0.b.getHeight() < i)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.this$0.b.getLayoutParams();
      localLayoutParams.gravity = 17;
      this.this$0.b.setLayoutParams(localLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.8
 * JD-Core Version:    0.7.0.1
 */