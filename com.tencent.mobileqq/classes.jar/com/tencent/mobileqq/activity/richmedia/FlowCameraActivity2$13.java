package com.tencent.mobileqq.activity.richmedia;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.qphone.base.util.QLog;

class FlowCameraActivity2$13
  implements View.OnTouchListener
{
  FlowCameraActivity2$13(FlowCameraActivity2 paramFlowCameraActivity2) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.a.l) {}
    while (((!this.a.f) && (!this.a.c)) || (paramView.getId() != 2131367155)) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return false;
    case 0: 
      if (QLog.isColorLevel()) {
        QLog.d("FlowCameraActivity", 2, "[@]onTouch ACTION_DOWN, event = " + paramMotionEvent);
      }
      if (!this.a.b.isLongClickable()) {
        this.a.a.e();
      }
      this.a.b.setText(null);
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "[@]onTouch ACTION_UP, event = " + paramMotionEvent);
    }
    if (this.a.a != null) {
      this.a.a.e();
    }
    if (this.a.b != null) {
      this.a.b.setText(2131692573);
    }
    FlowCameraActivity2.a(this.a, SystemClock.uptimeMillis());
    FlowCameraActivity2.a(this.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2.13
 * JD-Core Version:    0.7.0.1
 */