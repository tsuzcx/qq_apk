package com.tencent.mobileqq.ar.ARRecord;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.qphone.base.util.QLog;

class ARVideoRecordViewProxy$2
  implements View.OnTouchListener
{
  ARVideoRecordViewProxy$2(ARVideoRecordViewProxy paramARVideoRecordViewProxy) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i != 1) && (i != 3)) {
        return true;
      }
      ARVideoRecordViewProxy.b(this.a).setAlpha(1.0F);
      if (!ARVideoRecordViewProxy.c(this.a))
      {
        ARRecordUtils.a(true);
        ARVideoRecordViewProxy.a(this.a, true);
      }
      ARVideoRecordViewProxy.a(this.a).setVisibility(8);
      ARVideoRecordViewProxy.a(this.a).clearAnimation();
      if (ARVideoRecordViewProxy.d(this.a) != null)
      {
        ARVideoRecordViewProxy.d(this.a).k();
        if (QLog.isColorLevel())
        {
          QLog.i("ARVideoRecordViewProxy", 2, "onMonitorUserOperation");
          return true;
        }
      }
    }
    else
    {
      ARVideoRecordViewProxy.b(this.a).setAlpha(0.5F);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewProxy.2
 * JD-Core Version:    0.7.0.1
 */