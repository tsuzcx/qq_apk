package com.tencent.mobileqq.ar.model;

import alky;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;

public class QQARSession$19
  implements Runnable
{
  public void run()
  {
    if ((alky.a(this.this$0) != null) && (!alky.a(this.this$0).d()))
    {
      if (alky.a(this.this$0).j()) {
        alky.c(this.this$0);
      }
      if (alky.a(this.this$0) != 1L) {
        break label78;
      }
      this.this$0.b(1L);
      alky.b(this.this$0);
    }
    for (;;)
    {
      this.this$0.k();
      return;
      label78:
      if (alky.a(this.this$0) == 2L) {
        this.this$0.m();
      } else if (alky.a(this.this$0) == 2048L) {
        this.this$0.o();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.19
 * JD-Core Version:    0.7.0.1
 */