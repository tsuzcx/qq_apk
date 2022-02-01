package com.tencent.biz.qqstory.network;

import com.tencent.biz.qqstory.support.logging.SLog;

public abstract class BatchNetHandler
{
  protected int a = 0;
  protected BatchHandlerListPuller b;
  
  public abstract void a();
  
  public void a(BatchHandlerListPuller paramBatchHandlerListPuller)
  {
    this.b = paramBatchHandlerListPuller;
  }
  
  public boolean b()
  {
    int i = this.a;
    if (i < 1)
    {
      this.a = (i + 1);
      SLog.d("Q.qqstory.net:BatchNetHandler", String.format("retry request , retry count = %d", new Object[] { Integer.valueOf(this.a) }));
      a();
      return true;
    }
    return false;
  }
  
  public void c()
  {
    BatchHandlerListPuller localBatchHandlerListPuller = this.b;
    if (localBatchHandlerListPuller != null) {
      localBatchHandlerListPuller.a(this);
    }
  }
  
  public void d()
  {
    BatchHandlerListPuller localBatchHandlerListPuller = this.b;
    if (localBatchHandlerListPuller != null) {
      localBatchHandlerListPuller.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.BatchNetHandler
 * JD-Core Version:    0.7.0.1
 */