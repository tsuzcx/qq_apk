package com.tencent.mobileqq.ar.ARRecord;

import apdg;
import apdk;
import apdn;

public class ARVideoRecordUIControllerImpl$8
  implements Runnable
{
  public ARVideoRecordUIControllerImpl$8(apdk paramapdk, int paramInt) {}
  
  public void run()
  {
    if (apdk.a(this.this$0) != null) {
      apdk.a(this.this$0).a(0);
    }
    if (this.a == 0) {
      if (apdk.a(this.this$0) != -1) {
        switch (apdk.a(this.this$0))
        {
        case 5: 
        default: 
          apdk.a(this.this$0, -1);
        }
      }
    }
    for (;;)
    {
      apdk.b(this.this$0, false);
      if (!apdk.c(this.this$0)) {
        apdk.a(this.this$0);
      }
      return;
      apdk.a("0X8008A56");
      apdg.a("AR视频已保存", apdk.e);
      break;
      apdg.a(apdk.h, true);
      break;
      apdk.a("0X8008A56");
      apdg.a(apdk.h, true);
      break;
      if (apdk.b(this.this$0) == true)
      {
        apdk.a(this.this$0, false);
      }
      else
      {
        apdk.a("0X8008A56");
        apdg.a(apdk.h, true);
        continue;
        apdk.a("0X8008A56");
        if (this.a == 1) {
          apdg.a("AR视频已保存", apdk.f);
        } else {
          apdg.a("AR视频已保存", apdk.g);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl.8
 * JD-Core Version:    0.7.0.1
 */