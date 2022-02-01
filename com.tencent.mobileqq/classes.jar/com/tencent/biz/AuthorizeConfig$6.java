package com.tencent.biz;

import java.util.concurrent.atomic.AtomicBoolean;
import niz;

public class AuthorizeConfig$6
  implements Runnable
{
  public AuthorizeConfig$6(niz paramniz) {}
  
  public void run()
  {
    this.this$0.j();
    if (this.this$0.h == null) {
      this.this$0.f();
    }
    if (niz.a.compareAndSet(false, true)) {
      this.this$0.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.AuthorizeConfig.6
 * JD-Core Version:    0.7.0.1
 */