package com.tencent.mobileqq.ar.ARRecord;

import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class ARVideoRecordViewProxy$6
  implements Runnable
{
  ARVideoRecordViewProxy$6(ARVideoRecordViewProxy paramARVideoRecordViewProxy, int paramInt) {}
  
  public void run()
  {
    if (this.a == 0)
    {
      ARVideoRecordViewProxy.a(this.this$0).setShowState(2);
      ARVideoRecordViewProxy.a(this.this$0);
      ARVideoRecordViewProxy.a(this.this$0, 0);
      if (QLog.isColorLevel()) {
        QLog.i("ARVideoRecordViewProxy", 2, "switchUIdisplayMode run RECORD_NORMAL_MODE");
      }
    }
    do
    {
      do
      {
        return;
      } while (this.a != 1);
      ARVideoRecordViewProxy.a(this.this$0).setShowState(3);
      ARVideoRecordViewProxy.a(this.this$0).setVisibility(0);
      ARVideoRecordViewProxy.b(this.this$0).setVisibility(0);
      ARVideoRecordViewProxy.a(this.this$0, 1);
    } while (!QLog.isColorLevel());
    QLog.i("ARVideoRecordViewProxy", 2, "switchUIdisplayMode run RECORD_PROGRESS_MODE");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewProxy.6
 * JD-Core Version:    0.7.0.1
 */