package com.tencent.biz.qrcode.activity;

import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.util.AccessibilityUtil;

class QRDisplayActivity$26$1
  implements View.OnTouchListener
{
  QRDisplayActivity$26$1(QRDisplayActivity.26 param26) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        return true;
      } while (QRDisplayActivity.a(this.a.this$0) == null);
      QRDisplayActivity.a(this.a.this$0, false);
      QRDisplayActivity.a(this.a.this$0).start();
      return true;
      if (QRDisplayActivity.a(this.a.this$0) != null) {
        QRDisplayActivity.a(this.a.this$0).cancel();
      }
    } while ((QRDisplayActivity.a(this.a.this$0)) || (paramMotionEvent.getAction() != 1));
    AccessibilityUtil.c(this.a.this$0.d);
    this.a.this$0.onClick(this.a.this$0.d);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.26.1
 * JD-Core Version:    0.7.0.1
 */