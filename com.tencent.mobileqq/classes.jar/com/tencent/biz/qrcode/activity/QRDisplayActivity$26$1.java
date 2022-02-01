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
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i != 1) && (i != 3)) {
        return true;
      }
      if (QRDisplayActivity.d(this.a.this$0) != null) {
        QRDisplayActivity.d(this.a.this$0).cancel();
      }
      if ((!QRDisplayActivity.e(this.a.this$0)) && (paramMotionEvent.getAction() == 1))
      {
        AccessibilityUtil.c(this.a.this$0.I);
        this.a.this$0.onClick(this.a.this$0.I);
        return true;
      }
    }
    else if (QRDisplayActivity.d(this.a.this$0) != null)
    {
      QRDisplayActivity.a(this.a.this$0, false);
      QRDisplayActivity.d(this.a.this$0).start();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.26.1
 * JD-Core Version:    0.7.0.1
 */