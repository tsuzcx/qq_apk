package com.tencent.mobileqq.ar.ARRecord;

import com.tencent.qphone.base.util.QLog;

class ARVideoRecordUIControllerImpl$1
  implements Runnable
{
  ARVideoRecordUIControllerImpl$1(ARVideoRecordUIControllerImpl paramARVideoRecordUIControllerImpl) {}
  
  public void run()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("showVideoRecordButton inner run +");
      if (ARVideoRecordUIControllerImpl.a(this.this$0) == null) {
        break label81;
      }
    }
    label81:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("ARVideoRecordUIControllerImpl", 2, bool);
      if (ARVideoRecordUIControllerImpl.a(this.this$0) != null)
      {
        ARVideoRecordUIControllerImpl.a(this.this$0).a();
        ARVideoRecordUIControllerImpl.a(this.this$0).a(0);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl.1
 * JD-Core Version:    0.7.0.1
 */