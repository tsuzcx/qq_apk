package com.tencent.mobileqq.ar.model;

import apos;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;

public class QQARSession$19
  implements Runnable
{
  public void run()
  {
    if ((apos.a(this.this$0) != null) && (!apos.a(this.this$0).d()))
    {
      if (apos.a(this.this$0).j()) {
        apos.c(this.this$0);
      }
      if (apos.a(this.this$0) != 1L) {
        break label78;
      }
      this.this$0.b(1L);
      apos.b(this.this$0);
    }
    for (;;)
    {
      this.this$0.m();
      return;
      label78:
      if (apos.a(this.this$0) == 2L) {
        this.this$0.o();
      } else if (apos.a(this.this$0) == 2048L) {
        this.this$0.q();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.19
 * JD-Core Version:    0.7.0.1
 */