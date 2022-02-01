package com.tencent.luggage.wxa.sk;

import android.os.Handler;
import android.os.Message;
import com.tencent.luggage.wxa.sj.e;
import com.tencent.luggage.wxa.sj.h;
import java.util.Objects;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

class c$a
  implements e, h
{
  Object a;
  private Future<?> c;
  private Message d;
  private String e;
  
  c$a(c paramc, Message paramMessage)
  {
    if (paramMessage != null)
    {
      this.d = paramMessage;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(c.b(paramc));
      localStringBuilder.append("#");
      localStringBuilder.append(paramc.d(paramMessage));
      this.e = localStringBuilder.toString();
      this.a = paramc;
      return;
    }
    throw new NullPointerException("msg is null");
  }
  
  public String a()
  {
    return this.e;
  }
  
  public void a(Future paramFuture)
  {
    this.c = paramFuture;
  }
  
  public boolean b()
  {
    c.a(this.b, this.d);
    return this.c.cancel(false);
  }
  
  public boolean c()
  {
    return c.d(this.b);
  }
  
  public void run()
  {
    if (c.c(this.b).get())
    {
      this.c.cancel(false);
      com.tencent.luggage.wxa.rz.c.c.b("SerialHandler", String.format("this handler has quit! %s", new Object[] { this.e }), new Object[0]);
      return;
    }
    if ((this.d.getTarget() == null) && (this.d.obj == null) && (this.d.what == 0))
    {
      this.c.cancel(false);
      com.tencent.luggage.wxa.rz.c.c.b("SerialHandler", String.format("maybe it's removed before! %s", new Object[] { this.e }), new Object[0]);
      return;
    }
    ((Handler)Objects.requireNonNull(this.d.getTarget(), "target is null!")).dispatchMessage(this.d);
    c.a(this.b, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sk.c.a
 * JD-Core Version:    0.7.0.1
 */