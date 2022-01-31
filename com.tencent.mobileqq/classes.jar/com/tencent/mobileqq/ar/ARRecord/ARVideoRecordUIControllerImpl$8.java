package com.tencent.mobileqq.ar.ARRecord;

import akzh;
import akzl;
import akzo;

public class ARVideoRecordUIControllerImpl$8
  implements Runnable
{
  public ARVideoRecordUIControllerImpl$8(akzl paramakzl, int paramInt) {}
  
  public void run()
  {
    if (akzl.a(this.this$0) != null) {
      akzl.a(this.this$0).a(0);
    }
    if (this.a == 0) {
      if (akzl.a(this.this$0) != -1) {
        switch (akzl.a(this.this$0))
        {
        case 5: 
        default: 
          akzl.a(this.this$0, -1);
        }
      }
    }
    for (;;)
    {
      akzl.b(this.this$0, false);
      if (!akzl.c(this.this$0)) {
        akzl.a(this.this$0);
      }
      return;
      akzl.a("0X8008A56");
      akzh.a("AR视频已保存", akzl.e);
      break;
      akzh.a(akzl.h, true);
      break;
      akzl.a("0X8008A56");
      akzh.a(akzl.h, true);
      break;
      if (akzl.b(this.this$0) == true)
      {
        akzl.a(this.this$0, false);
      }
      else
      {
        akzl.a("0X8008A56");
        akzh.a(akzl.h, true);
        continue;
        akzl.a("0X8008A56");
        if (this.a == 1) {
          akzh.a("AR视频已保存", akzl.f);
        } else {
          akzh.a("AR视频已保存", akzl.g);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl.8
 * JD-Core Version:    0.7.0.1
 */