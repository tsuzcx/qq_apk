package com.tencent.mobileqq.ar.ARRecord;

import apdk;
import apdn;
import com.tencent.qphone.base.util.QLog;

public class ARVideoRecordUIControllerImpl$1
  implements Runnable
{
  public ARVideoRecordUIControllerImpl$1(apdk paramapdk) {}
  
  public void run()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("showVideoRecordButton inner run +");
      if (apdk.a(this.this$0) == null) {
        break label81;
      }
    }
    label81:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("ARVideoRecordUIControllerImpl", 2, bool);
      if (apdk.a(this.this$0) != null)
      {
        apdk.a(this.this$0).a();
        apdk.a(this.this$0).a(0);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl.1
 * JD-Core Version:    0.7.0.1
 */