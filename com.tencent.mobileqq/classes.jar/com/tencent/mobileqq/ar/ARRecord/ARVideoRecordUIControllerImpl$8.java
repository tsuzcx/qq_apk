package com.tencent.mobileqq.ar.ARRecord;

import aotc;
import aotg;
import aotj;

public class ARVideoRecordUIControllerImpl$8
  implements Runnable
{
  public ARVideoRecordUIControllerImpl$8(aotg paramaotg, int paramInt) {}
  
  public void run()
  {
    if (aotg.a(this.this$0) != null) {
      aotg.a(this.this$0).a(0);
    }
    if (this.a == 0) {
      if (aotg.a(this.this$0) != -1) {
        switch (aotg.a(this.this$0))
        {
        case 5: 
        default: 
          aotg.a(this.this$0, -1);
        }
      }
    }
    for (;;)
    {
      aotg.b(this.this$0, false);
      if (!aotg.c(this.this$0)) {
        aotg.a(this.this$0);
      }
      return;
      aotg.a("0X8008A56");
      aotc.a("AR视频已保存", aotg.e);
      break;
      aotc.a(aotg.h, true);
      break;
      aotg.a("0X8008A56");
      aotc.a(aotg.h, true);
      break;
      if (aotg.b(this.this$0) == true)
      {
        aotg.a(this.this$0, false);
      }
      else
      {
        aotg.a("0X8008A56");
        aotc.a(aotg.h, true);
        continue;
        aotg.a("0X8008A56");
        if (this.a == 1) {
          aotc.a("AR视频已保存", aotg.f);
        } else {
          aotc.a("AR视频已保存", aotg.g);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl.8
 * JD-Core Version:    0.7.0.1
 */