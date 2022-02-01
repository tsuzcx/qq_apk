package com.tencent.biz;

import java.util.concurrent.atomic.AtomicBoolean;

class AuthorizeConfig$8
  implements Runnable
{
  AuthorizeConfig$8(AuthorizeConfig paramAuthorizeConfig) {}
  
  public void run()
  {
    this.this$0.r();
    if (this.this$0.q == null) {
      this.this$0.m();
    }
    if (AuthorizeConfig.z.compareAndSet(false, true)) {
      this.this$0.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.AuthorizeConfig.8
 * JD-Core Version:    0.7.0.1
 */