package com.tencent.biz.qqstory.network.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import wwv;

public class GetUserInfoHandler$1
  implements Runnable
{
  public GetUserInfoHandler$1(wwv paramwwv) {}
  
  public void run()
  {
    synchronized (wwv.a(this.this$0))
    {
      if (!wwv.a(this.this$0).isEmpty())
      {
        this.this$0.a(1, wwv.a(this.this$0));
        wwv.a(this.this$0, new ArrayList());
      }
      wwv.a(this.this$0).set(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.1
 * JD-Core Version:    0.7.0.1
 */