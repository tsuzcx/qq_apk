package com.tencent.biz.qqstory.network.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import tki;

public class GetUserInfoHandler$1
  implements Runnable
{
  public GetUserInfoHandler$1(tki paramtki) {}
  
  public void run()
  {
    synchronized (tki.a(this.this$0))
    {
      if (!tki.a(this.this$0).isEmpty())
      {
        this.this$0.a(1, tki.a(this.this$0));
        tki.a(this.this$0, new ArrayList());
      }
      tki.a(this.this$0).set(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.1
 * JD-Core Version:    0.7.0.1
 */