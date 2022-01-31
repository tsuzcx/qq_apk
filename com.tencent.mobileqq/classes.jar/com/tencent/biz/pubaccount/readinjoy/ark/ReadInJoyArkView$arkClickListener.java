package com.tencent.biz.pubaccount.readinjoy.ark;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;

public class ReadInJoyArkView$arkClickListener
  implements OnLongClickAndTouchListener
{
  public boolean onLongClick(View paramView)
  {
    MotionEvent localMotionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0F, 0.0F, 0);
    paramView.dispatchTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ark.ReadInJoyArkView.arkClickListener
 * JD-Core Version:    0.7.0.1
 */