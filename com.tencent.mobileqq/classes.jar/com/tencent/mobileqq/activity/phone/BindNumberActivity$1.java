package com.tencent.mobileqq.activity.phone;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.EditText;

class BindNumberActivity$1
  implements Runnable
{
  BindNumberActivity$1(BindNumberActivity paramBindNumberActivity) {}
  
  public void run()
  {
    if (!this.this$0.isFinishing())
    {
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 0, 0.0F, 0.0F, 0);
      this.this$0.a.dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
      localMotionEvent = MotionEvent.obtain(l, l, 1, 0.0F, 0.0F, 0);
      this.this$0.a.dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
      this.this$0.a.setSelection(this.this$0.a.getText().toString().length());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindNumberActivity.1
 * JD-Core Version:    0.7.0.1
 */