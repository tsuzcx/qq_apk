package com.tencent.luggage.wxa.si;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.luggage.wxa.se.d;
import com.tencent.luggage.wxa.sj.i;

public class b
  extends a
  implements Handler.Callback
{
  private final b.a a;
  private final Handler b = d.a("ColdPoolLeader", this);
  
  public b(int paramInt1, int paramInt2)
  {
    this.a = new b.a(this, paramInt1, paramInt2);
  }
  
  protected a.a b()
  {
    return this.a;
  }
  
  public String c()
  {
    return "ColdPool";
  }
  
  public void c(i<?> parami)
  {
    this.b.removeCallbacksAndMessages(parami);
    this.a.remove(parami);
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
 * Qualified Name:     com.tencent.luggage.wxa.si.b
 * JD-Core Version:    0.7.0.1
 */