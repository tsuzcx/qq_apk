package com.tencent.mobileqq.ar.ARRecord;

import akkv;
import akkz;
import aklc;

public class ARVideoRecordUIControllerImpl$8
  implements Runnable
{
  public ARVideoRecordUIControllerImpl$8(akkz paramakkz, int paramInt) {}
  
  public void run()
  {
    if (akkz.a(this.this$0) != null) {
      akkz.a(this.this$0).a(0);
    }
    if (this.a == 0) {
      if (akkz.a(this.this$0) != -1) {
        switch (akkz.a(this.this$0))
        {
        case 5: 
        default: 
          akkz.a(this.this$0, -1);
        }
      }
    }
    for (;;)
    {
      akkz.b(this.this$0, false);
      if (!akkz.c(this.this$0)) {
        akkz.a(this.this$0);
      }
      return;
      akkz.a("0X8008A56");
      akkv.a("AR视频已保存", akkz.e);
      break;
      akkv.a(akkz.h, true);
      break;
      akkz.a("0X8008A56");
      akkv.a(akkz.h, true);
      break;
      if (akkz.b(this.this$0) == true)
      {
        akkz.a(this.this$0, false);
      }
      else
      {
        akkz.a("0X8008A56");
        akkv.a(akkz.h, true);
        continue;
        akkz.a("0X8008A56");
        if (this.a == 1) {
          akkv.a("AR视频已保存", akkz.f);
        } else {
          akkv.a("AR视频已保存", akkz.g);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl.8
 * JD-Core Version:    0.7.0.1
 */