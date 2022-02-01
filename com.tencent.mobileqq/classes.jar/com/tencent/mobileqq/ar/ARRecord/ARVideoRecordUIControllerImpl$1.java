package com.tencent.mobileqq.ar.ARRecord;

import com.tencent.qphone.base.util.QLog;

class ARVideoRecordUIControllerImpl$1
  implements Runnable
{
  ARVideoRecordUIControllerImpl$1(ARVideoRecordUIControllerImpl paramARVideoRecordUIControllerImpl) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showVideoRecordButton inner run +");
      boolean bool;
      if (ARVideoRecordUIControllerImpl.a(this.this$0) != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.i("ARVideoRecordUIControllerImpl", 2, localStringBuilder.toString());
    }
    if (ARVideoRecordUIControllerImpl.a(this.this$0) != null)
    {
      ARVideoRecordUIControllerImpl.a(this.this$0).a();
      ARVideoRecordUIControllerImpl.a(this.this$0).a(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl.1
 * JD-Core Version:    0.7.0.1
 */