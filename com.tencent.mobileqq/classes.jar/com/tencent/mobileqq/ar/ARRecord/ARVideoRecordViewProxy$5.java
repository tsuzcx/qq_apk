package com.tencent.mobileqq.ar.ARRecord;

import android.widget.TextView;

class ARVideoRecordViewProxy$5
  implements Runnable
{
  ARVideoRecordViewProxy$5(ARVideoRecordViewProxy paramARVideoRecordViewProxy, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    ARVideoRecordViewProxy.a(this.this$0).setText(ARRecordUtils.a(this.a / 1000));
    ARVideoRecordViewProxy.b(this.this$0).setText(ARRecordUtils.b(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewProxy.5
 * JD-Core Version:    0.7.0.1
 */