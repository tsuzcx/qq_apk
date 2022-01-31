package com.tencent.mobileqq.activity.phone;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.EditText;

class BindVerifyActivity$7
  implements Runnable
{
  BindVerifyActivity$7(BindVerifyActivity paramBindVerifyActivity) {}
  
  public void run()
  {
    if (!this.this$0.isFinishing())
    {
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 0, 0.0F, 0.0F, 0);
      BindVerifyActivity.a(this.this$0).dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
      localMotionEvent = MotionEvent.obtain(l, l, 1, 0.0F, 0.0F, 0);
      BindVerifyActivity.a(this.this$0).dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
      BindVerifyActivity.a(this.this$0).setSelection(this.this$0.b().length());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindVerifyActivity.7
 * JD-Core Version:    0.7.0.1
 */