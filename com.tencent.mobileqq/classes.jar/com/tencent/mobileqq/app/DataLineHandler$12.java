package com.tencent.mobileqq.app;

import amqd;
import com.tencent.litetransfersdk.Session;

public class DataLineHandler$12
  implements Runnable
{
  public DataLineHandler$12(amqd paramamqd, long paramLong) {}
  
  public void run()
  {
    Session localSession = this.this$0.a(this.a);
    amqd.a(this.this$0, localSession, null, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.DataLineHandler.12
 * JD-Core Version:    0.7.0.1
 */