package com.tencent.mobileqq.ar.ARRecord;

import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class ARVideoRecordViewProxy$6
  implements Runnable
{
  ARVideoRecordViewProxy$6(ARVideoRecordViewProxy paramARVideoRecordViewProxy, int paramInt) {}
  
  public void run()
  {
    int i = this.a;
    if (i == 0)
    {
      ARVideoRecordViewProxy.b(this.this$0).setShowState(2);
      ARVideoRecordViewProxy.f(this.this$0);
      ARVideoRecordViewProxy.a(this.this$0, 0);
      if (QLog.isColorLevel()) {
        QLog.i("ARVideoRecordViewProxy", 2, "switchUIdisplayMode run RECORD_NORMAL_MODE");
      }
    }
    else if (i == 1)
    {
      ARVideoRecordViewProxy.b(this.this$0).setShowState(3);
      ARVideoRecordViewProxy.g(this.this$0).setVisibility(0);
      ARVideoRecordViewProxy.h(this.this$0).setVisibility(0);
      ARVideoRecordViewProxy.a(this.this$0, 1);
      if (QLog.isColorLevel()) {
        QLog.i("ARVideoRecordViewProxy", 2, "switchUIdisplayMode run RECORD_PROGRESS_MODE");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewProxy.6
 * JD-Core Version:    0.7.0.1
 */