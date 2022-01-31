package com.tencent.mobileqq.activity.qwallet;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.EditText;

class TransactionActivity$8
  implements Runnable
{
  TransactionActivity$8(TransactionActivity paramTransactionActivity) {}
  
  public void run()
  {
    MotionEvent localMotionEvent1 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, 0.0F, 0.0F, 0);
    TransactionActivity.a(this.this$0).dispatchTouchEvent(localMotionEvent1);
    MotionEvent localMotionEvent2 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, 0.0F, 0.0F, 0);
    TransactionActivity.a(this.this$0).dispatchTouchEvent(localMotionEvent2);
    localMotionEvent1.recycle();
    localMotionEvent2.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.TransactionActivity.8
 * JD-Core Version:    0.7.0.1
 */