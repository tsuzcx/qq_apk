package com.tencent.biz.qrcode.activity;

import android.view.View;
import com.tencent.biz.qrcode.CustomAccessibilityDelegate;
import com.tencent.mobileqq.util.AccessibilityUtil;

class QRDisplayActivity$25
  implements Runnable
{
  QRDisplayActivity$25(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void run()
  {
    CustomAccessibilityDelegate localCustomAccessibilityDelegate = new CustomAccessibilityDelegate(this.this$0.I, this.this$0);
    this.this$0.I.setAccessibilityDelegate(localCustomAccessibilityDelegate);
    AccessibilityUtil.a(this.this$0.d, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.25
 * JD-Core Version:    0.7.0.1
 */