package com.tencent.mobileqq.ar.ARRecord;

import amuu;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public class ARVideoRecordViewProxy$6
  implements Runnable
{
  public ARVideoRecordViewProxy$6(amuu paramamuu, int paramInt) {}
  
  public void run()
  {
    if (this.a == 0)
    {
      amuu.a(this.this$0).setShowState(2);
      amuu.a(this.this$0);
      amuu.a(this.this$0, 0);
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
      amuu.a(this.this$0).setShowState(3);
      amuu.a(this.this$0).setVisibility(0);
      amuu.b(this.this$0).setVisibility(0);
      amuu.a(this.this$0, 1);
    } while (!QLog.isColorLevel());
    QLog.i("ARVideoRecordViewProxy", 2, "switchUIdisplayMode run RECORD_PROGRESS_MODE");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewProxy.6
 * JD-Core Version:    0.7.0.1
 */