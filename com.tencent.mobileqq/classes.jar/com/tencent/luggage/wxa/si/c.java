package com.tencent.luggage.wxa.si;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.luggage.wxa.se.d;
import com.tencent.luggage.wxa.sj.i;
import java.util.concurrent.BlockingQueue;

public class c
  extends a
  implements Handler.Callback
{
  private final c.a a;
  private final Handler b = d.a("HotPoolLeader", this);
  
  public c(int paramInt)
  {
    this.a = new c.a(this, paramInt);
  }
  
  protected a.a b()
  {
    return this.a;
  }
  
  public String c()
  {
    return "HotPool";
  }
  
  public void c(i<?> parami)
  {
    this.b.removeCallbacksAndMessages(parami);
    this.a.remove(parami);
  }
  
  public boolean d()
  {
    return this.a.getQueue().size() > 0;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    paramMessage = paramMessage.obj;
    if ((paramMessage instanceof i))
    {
      this.a.execute((i)paramMessage);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.si.c
 * JD-Core Version:    0.7.0.1
 */