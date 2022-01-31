package com.tencent.mobileqq.ar.ARRecord;

import amul;
import amup;
import amus;

public class ARVideoRecordUIControllerImpl$8
  implements Runnable
{
  public ARVideoRecordUIControllerImpl$8(amup paramamup, int paramInt) {}
  
  public void run()
  {
    if (amup.a(this.this$0) != null) {
      amup.a(this.this$0).a(0);
    }
    if (this.a == 0) {
      if (amup.a(this.this$0) != -1) {
        switch (amup.a(this.this$0))
        {
        case 5: 
        default: 
          amup.a(this.this$0, -1);
        }
      }
    }
    for (;;)
    {
      amup.b(this.this$0, false);
      if (!amup.c(this.this$0)) {
        amup.a(this.this$0);
      }
      return;
      amup.a("0X8008A56");
      amul.a("AR视频已保存", amup.e);
      break;
      amul.a(amup.h, true);
      break;
      amup.a("0X8008A56");
      amul.a(amup.h, true);
      break;
      if (amup.b(this.this$0) == true)
      {
        amup.a(this.this$0, false);
      }
      else
      {
        amup.a("0X8008A56");
        amul.a(amup.h, true);
        continue;
        amup.a("0X8008A56");
        if (this.a == 1) {
          amul.a("AR视频已保存", amup.f);
        } else {
          amul.a("AR视频已保存", amup.g);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl.8
 * JD-Core Version:    0.7.0.1
 */