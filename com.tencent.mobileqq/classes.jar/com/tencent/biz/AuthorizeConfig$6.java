package com.tencent.biz;

import java.util.concurrent.atomic.AtomicBoolean;
import mvs;

public class AuthorizeConfig$6
  implements Runnable
{
  public AuthorizeConfig$6(mvs parammvs) {}
  
  public void run()
  {
    this.this$0.j();
    if (this.this$0.h == null) {
      this.this$0.f();
    }
    if (mvs.a.compareAndSet(false, true)) {
      this.this$0.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.AuthorizeConfig.6
 * JD-Core Version:    0.7.0.1
 */