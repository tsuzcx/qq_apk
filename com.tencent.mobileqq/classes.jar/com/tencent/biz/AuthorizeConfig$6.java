package com.tencent.biz;

import java.util.concurrent.atomic.AtomicBoolean;

class AuthorizeConfig$6
  implements Runnable
{
  AuthorizeConfig$6(AuthorizeConfig paramAuthorizeConfig) {}
  
  public void run()
  {
    this.this$0.j();
    if (this.this$0.e == null) {
      this.this$0.f();
    }
    if (AuthorizeConfig.a.compareAndSet(false, true)) {
      this.this$0.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.AuthorizeConfig.6
 * JD-Core Version:    0.7.0.1
 */