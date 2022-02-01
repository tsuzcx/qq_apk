package com.tencent.mobileqq.ar.ARRecord;

import aotg;
import aotj;
import com.tencent.qphone.base.util.QLog;

public class ARVideoRecordUIControllerImpl$7
  implements Runnable
{
  public ARVideoRecordUIControllerImpl$7(aotg paramaotg, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    QLog.d("ARVideoRecordUIControllerImpl", 2, String.format("onRecordUpdate progress=%s", new Object[] { Integer.valueOf(1) }));
    if (aotg.a(this.this$0)) {
      aotg.a(this.this$0).a(this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl.7
 * JD-Core Version:    0.7.0.1
 */