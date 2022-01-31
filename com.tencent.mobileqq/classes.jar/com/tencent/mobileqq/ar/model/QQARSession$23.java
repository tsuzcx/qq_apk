package com.tencent.mobileqq.ar.model;

import akmy;
import akso;
import akwn;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;

public class QQARSession$23
  implements Runnable
{
  public QQARSession$23(akwn paramakwn, int paramInt) {}
  
  public void run()
  {
    if (!akwn.a(this.this$0).d())
    {
      if (akwn.a(this.this$0).j()) {
        akwn.c(this.this$0);
      }
      if (akwn.a(this.this$0) != 1L) {
        break label132;
      }
      this.this$0.b(1L);
      akwn.b(this.this$0);
    }
    for (;;)
    {
      this.this$0.k();
      if ((akwn.b(this.this$0)) && (this.this$0.a == 2) && (akwn.a(this.this$0) != null))
      {
        akmy localakmy = new akmy(akwn.a(this.this$0));
        akwn.a(this.this$0).a(2, localakmy, this.a);
      }
      return;
      label132:
      if (akwn.a(this.this$0) == 2L) {
        this.this$0.m();
      } else if (akwn.a(this.this$0) == 2048L) {
        this.this$0.o();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.23
 * JD-Core Version:    0.7.0.1
 */