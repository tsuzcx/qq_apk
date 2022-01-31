package com.tencent.mobileqq.ar.ARRecord;

import ampw;
import amqa;
import amqd;

public class ARVideoRecordUIControllerImpl$8
  implements Runnable
{
  public ARVideoRecordUIControllerImpl$8(amqa paramamqa, int paramInt) {}
  
  public void run()
  {
    if (amqa.a(this.this$0) != null) {
      amqa.a(this.this$0).a(0);
    }
    if (this.a == 0) {
      if (amqa.a(this.this$0) != -1) {
        switch (amqa.a(this.this$0))
        {
        case 5: 
        default: 
          amqa.a(this.this$0, -1);
        }
      }
    }
    for (;;)
    {
      amqa.b(this.this$0, false);
      if (!amqa.c(this.this$0)) {
        amqa.a(this.this$0);
      }
      return;
      amqa.a("0X8008A56");
      ampw.a("AR视频已保存", amqa.e);
      break;
      ampw.a(amqa.h, true);
      break;
      amqa.a("0X8008A56");
      ampw.a(amqa.h, true);
      break;
      if (amqa.b(this.this$0) == true)
      {
        amqa.a(this.this$0, false);
      }
      else
      {
        amqa.a("0X8008A56");
        ampw.a(amqa.h, true);
        continue;
        amqa.a("0X8008A56");
        if (this.a == 1) {
          ampw.a("AR视频已保存", amqa.f);
        } else {
          ampw.a("AR视频已保存", amqa.g);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl.8
 * JD-Core Version:    0.7.0.1
 */