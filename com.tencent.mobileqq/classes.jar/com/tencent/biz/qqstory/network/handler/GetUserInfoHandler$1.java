package com.tencent.biz.qqstory.network.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import xaq;

public class GetUserInfoHandler$1
  implements Runnable
{
  public GetUserInfoHandler$1(xaq paramxaq) {}
  
  public void run()
  {
    synchronized (xaq.a(this.this$0))
    {
      if (!xaq.a(this.this$0).isEmpty())
      {
        this.this$0.a(1, xaq.a(this.this$0));
        xaq.a(this.this$0, new ArrayList());
      }
      xaq.a(this.this$0).set(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.1
 * JD-Core Version:    0.7.0.1
 */