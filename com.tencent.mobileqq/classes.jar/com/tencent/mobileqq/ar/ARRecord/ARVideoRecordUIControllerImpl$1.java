package com.tencent.mobileqq.ar.ARRecord;

import aoai;
import aoal;
import com.tencent.qphone.base.util.QLog;

public class ARVideoRecordUIControllerImpl$1
  implements Runnable
{
  public ARVideoRecordUIControllerImpl$1(aoai paramaoai) {}
  
  public void run()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("showVideoRecordButton inner run +");
      if (aoai.a(this.this$0) == null) {
        break label81;
      }
    }
    label81:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("ARVideoRecordUIControllerImpl", 2, bool);
      if (aoai.a(this.this$0) != null)
      {
        aoai.a(this.this$0).a();
        aoai.a(this.this$0).a(0);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl.1
 * JD-Core Version:    0.7.0.1
 */