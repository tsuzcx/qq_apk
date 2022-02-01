package com.tencent.biz.qqstory.network.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

class GetUserInfoHandler$1
  implements Runnable
{
  GetUserInfoHandler$1(GetUserInfoHandler paramGetUserInfoHandler) {}
  
  public void run()
  {
    synchronized (GetUserInfoHandler.a(this.this$0))
    {
      if (!GetUserInfoHandler.b(this.this$0).isEmpty())
      {
        this.this$0.a(1, GetUserInfoHandler.b(this.this$0));
        GetUserInfoHandler.a(this.this$0, new ArrayList());
      }
      GetUserInfoHandler.c(this.this$0).set(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.1
 * JD-Core Version:    0.7.0.1
 */