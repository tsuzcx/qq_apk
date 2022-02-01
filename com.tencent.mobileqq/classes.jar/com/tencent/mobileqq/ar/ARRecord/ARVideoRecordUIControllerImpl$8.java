package com.tencent.mobileqq.ar.ARRecord;

import apgs;
import apgw;
import apgz;

public class ARVideoRecordUIControllerImpl$8
  implements Runnable
{
  public ARVideoRecordUIControllerImpl$8(apgw paramapgw, int paramInt) {}
  
  public void run()
  {
    if (apgw.a(this.this$0) != null) {
      apgw.a(this.this$0).a(0);
    }
    if (this.a == 0) {
      if (apgw.a(this.this$0) != -1) {
        switch (apgw.a(this.this$0))
        {
        case 5: 
        default: 
          apgw.a(this.this$0, -1);
        }
      }
    }
    for (;;)
    {
      apgw.b(this.this$0, false);
      if (!apgw.c(this.this$0)) {
        apgw.a(this.this$0);
      }
      return;
      apgw.a("0X8008A56");
      apgs.a("AR视频已保存", apgw.e);
      break;
      apgs.a(apgw.h, true);
      break;
      apgw.a("0X8008A56");
      apgs.a(apgw.h, true);
      break;
      if (apgw.b(this.this$0) == true)
      {
        apgw.a(this.this$0, false);
      }
      else
      {
        apgw.a("0X8008A56");
        apgs.a(apgw.h, true);
        continue;
        apgw.a("0X8008A56");
        if (this.a == 1) {
          apgs.a("AR视频已保存", apgw.f);
        } else {
          apgs.a("AR视频已保存", apgw.g);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl.8
 * JD-Core Version:    0.7.0.1
 */