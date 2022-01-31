package com.tencent.mobileqq.ar.ARRecord;

import akzg;
import akzk;
import akzn;

public class ARVideoRecordUIControllerImpl$8
  implements Runnable
{
  public ARVideoRecordUIControllerImpl$8(akzk paramakzk, int paramInt) {}
  
  public void run()
  {
    if (akzk.a(this.this$0) != null) {
      akzk.a(this.this$0).a(0);
    }
    if (this.a == 0) {
      if (akzk.a(this.this$0) != -1) {
        switch (akzk.a(this.this$0))
        {
        case 5: 
        default: 
          akzk.a(this.this$0, -1);
        }
      }
    }
    for (;;)
    {
      akzk.b(this.this$0, false);
      if (!akzk.c(this.this$0)) {
        akzk.a(this.this$0);
      }
      return;
      akzk.a("0X8008A56");
      akzg.a("AR视频已保存", akzk.e);
      break;
      akzg.a(akzk.h, true);
      break;
      akzk.a("0X8008A56");
      akzg.a(akzk.h, true);
      break;
      if (akzk.b(this.this$0) == true)
      {
        akzk.a(this.this$0, false);
      }
      else
      {
        akzk.a("0X8008A56");
        akzg.a(akzk.h, true);
        continue;
        akzk.a("0X8008A56");
        if (this.a == 1) {
          akzg.a("AR视频已保存", akzk.f);
        } else {
          akzg.a("AR视频已保存", akzk.g);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl.8
 * JD-Core Version:    0.7.0.1
 */