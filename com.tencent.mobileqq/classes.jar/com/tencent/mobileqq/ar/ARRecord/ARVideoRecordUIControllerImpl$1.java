package com.tencent.mobileqq.ar.ARRecord;

import akzk;
import akzn;
import com.tencent.qphone.base.util.QLog;

public class ARVideoRecordUIControllerImpl$1
  implements Runnable
{
  public ARVideoRecordUIControllerImpl$1(akzk paramakzk) {}
  
  public void run()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("showVideoRecordButton inner run +");
      if (akzk.a(this.this$0) == null) {
        break label81;
      }
    }
    label81:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("ARVideoRecordUIControllerImpl", 2, bool);
      if (akzk.a(this.this$0) != null)
      {
        akzk.a(this.this$0).a();
        akzk.a(this.this$0).a(0);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl.1
 * JD-Core Version:    0.7.0.1
 */