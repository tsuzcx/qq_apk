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
    if (this.a == 0) {
      if (ARVideoRecordUIControllerImpl.a(this.this$0) != -1) {
        switch (ARVideoRecordUIControllerImpl.a(this.this$0))
        {
        case 5: 
        default: 
          ARVideoRecordUIControllerImpl.a(this.this$0, -1);
        }
      }
    }
    for (;;)
    {
      ARVideoRecordUIControllerImpl.b(this.this$0, false);
      if (!ARVideoRecordUIControllerImpl.c(this.this$0)) {
        ARVideoRecordUIControllerImpl.a(this.this$0);
      }
      return;
      ARVideoRecordUIControllerImpl.a("0X8008A56");
      ARRecordUtils.a("AR视频已保存", ARVideoRecordUIControllerImpl.e);
      break;
      ARRecordUtils.a(ARVideoRecordUIControllerImpl.h, true);
      break;
      ARVideoRecordUIControllerImpl.a("0X8008A56");
      ARRecordUtils.a(ARVideoRecordUIControllerImpl.h, true);
      break;
      if (ARVideoRecordUIControllerImpl.b(this.this$0) == true)
      {
        ARVideoRecordUIControllerImpl.a(this.this$0, false);
      }
      else
      {
        ARVideoRecordUIControllerImpl.a("0X8008A56");
        ARRecordUtils.a(ARVideoRecordUIControllerImpl.h, true);
        continue;
        ARVideoRecordUIControllerImpl.a("0X8008A56");
        if (this.a == 1) {
          ARRecordUtils.a("AR视频已保存", ARVideoRecordUIControllerImpl.f);
        } else {
          ARRecordUtils.a("AR视频已保存", ARVideoRecordUIControllerImpl.g);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl.8
 * JD-Core Version:    0.7.0.1
 */