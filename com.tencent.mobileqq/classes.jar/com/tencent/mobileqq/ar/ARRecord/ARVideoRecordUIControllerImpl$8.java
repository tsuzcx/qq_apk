package com.tencent.mobileqq.ar.ARRecord;

import aoae;
import aoai;
import aoal;

public class ARVideoRecordUIControllerImpl$8
  implements Runnable
{
  public ARVideoRecordUIControllerImpl$8(aoai paramaoai, int paramInt) {}
  
  public void run()
  {
    if (aoai.a(this.this$0) != null) {
      aoai.a(this.this$0).a(0);
    }
    if (this.a == 0) {
      if (aoai.a(this.this$0) != -1) {
        switch (aoai.a(this.this$0))
        {
        case 5: 
        default: 
          aoai.a(this.this$0, -1);
        }
      }
    }
    for (;;)
    {
      aoai.b(this.this$0, false);
      if (!aoai.c(this.this$0)) {
        aoai.a(this.this$0);
      }
      return;
      aoai.a("0X8008A56");
      aoae.a("AR视频已保存", aoai.e);
      break;
      aoae.a(aoai.h, true);
      break;
      aoai.a("0X8008A56");
      aoae.a(aoai.h, true);
      break;
      if (aoai.b(this.this$0) == true)
      {
        aoai.a(this.this$0, false);
      }
      else
      {
        aoai.a("0X8008A56");
        aoae.a(aoai.h, true);
        continue;
        aoai.a("0X8008A56");
        if (this.a == 1) {
          aoae.a("AR视频已保存", aoai.f);
        } else {
          aoae.a("AR视频已保存", aoai.g);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl.8
 * JD-Core Version:    0.7.0.1
 */