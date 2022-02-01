package com.tencent.mobileqq.ar.ARRecord;

class ARVideoRecordUIControllerImpl$8
  implements Runnable
{
  ARVideoRecordUIControllerImpl$8(ARVideoRecordUIControllerImpl paramARVideoRecordUIControllerImpl, int paramInt) {}
  
  public void run()
  {
    if (ARVideoRecordUIControllerImpl.a(this.this$0) != null) {
      ARVideoRecordUIControllerImpl.a(this.this$0).a(0);
    }
    if (this.a == 0)
    {
      if (ARVideoRecordUIControllerImpl.a(this.this$0) != -1)
      {
        switch (ARVideoRecordUIControllerImpl.a(this.this$0))
        {
        default: 
          break;
        case 7: 
          ARRecordUtils.a(ARVideoRecordUIControllerImpl.h, true);
          break;
        case 2: 
        case 3: 
        case 4: 
        case 6: 
          ARVideoRecordUIControllerImpl.a("0X8008A56");
          ARRecordUtils.a(ARVideoRecordUIControllerImpl.h, true);
          break;
        case 1: 
          ARVideoRecordUIControllerImpl.a("0X8008A56");
          ARRecordUtils.a("AR视频已保存", ARVideoRecordUIControllerImpl.e);
        }
        ARVideoRecordUIControllerImpl.a(this.this$0, -1);
      }
      else if (ARVideoRecordUIControllerImpl.b(this.this$0) == true)
      {
        ARVideoRecordUIControllerImpl.a(this.this$0, false);
      }
      else
      {
        ARVideoRecordUIControllerImpl.a("0X8008A56");
        ARRecordUtils.a(ARVideoRecordUIControllerImpl.h, true);
      }
    }
    else
    {
      ARVideoRecordUIControllerImpl.a("0X8008A56");
      if (this.a == 1) {
        ARRecordUtils.a("AR视频已保存", ARVideoRecordUIControllerImpl.f);
      } else {
        ARRecordUtils.a("AR视频已保存", ARVideoRecordUIControllerImpl.g);
      }
    }
    ARVideoRecordUIControllerImpl.b(this.this$0, false);
    if (!ARVideoRecordUIControllerImpl.c(this.this$0)) {
      ARVideoRecordUIControllerImpl.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl.8
 * JD-Core Version:    0.7.0.1
 */