package com.tencent.luggage.wxa.qz;

import android.os.Looper;
import android.os.Message;
import com.tencent.luggage.wxa.sk.a;

public class v
  extends s
{
  private static int a;
  private final int b;
  private final boolean c;
  private long d = 0L;
  private boolean e = false;
  private final v.a f;
  
  public v(Looper paramLooper, v.a parama, boolean paramBoolean)
  {
    super(paramLooper);
    this.f = parama;
    this.b = e();
    this.c = paramBoolean;
    if ((Thread.currentThread().getName().equals("initThread")) || ("initThread".equals(a.c()))) {
      o.b("MicroMsg.MTimerHandler", "MTimerHandler can not init handler with initThread, stack %s", new Object[] { af.c() });
    }
  }
  
  public v(v.a parama, boolean paramBoolean)
  {
    this.f = parama;
    this.b = e();
    this.c = paramBoolean;
    if ((Thread.currentThread().getName().equals("initThread")) || ("initThread".equals(a.c()))) {
      o.b("MicroMsg.MTimerHandler", "MTimerHandler can not init handler with initThread, stack %s", new Object[] { af.c() });
    }
  }
  
  public v(String paramString, v.a parama, boolean paramBoolean)
  {
    super(paramString);
    this.f = parama;
    this.b = e();
    this.c = paramBoolean;
  }
  
  private static int e()
  {
    if (a >= 8192) {
      a = 0;
    }
    int i = a + 1;
    a = i;
    return i;
  }
  
  public void a(long paramLong)
  {
    a(paramLong, paramLong);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.d = paramLong2;
    c();
    this.e = false;
    a(this.b, paramLong1);
  }
  
  public void a(Message paramMessage)
  {
    if (paramMessage.what == this.b)
    {
      paramMessage = this.f;
      if (paramMessage == null) {
        return;
      }
      if (!paramMessage.p_()) {
        return;
      }
      if ((this.c) && (!this.e)) {
        a(this.b, this.d);
      }
    }
  }
  
  public void c()
  {
    b(this.b);
    this.e = true;
  }
  
  public boolean d()
  {
    return (this.e) || (!c(this.b));
  }
  
  protected void finalize()
  {
    c();
    super.finalize();
  }
  
  public String toString()
  {
    if (this.f == null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("MTimerHandler(");
      localStringBuilder.append(getClass().getName());
      localStringBuilder.append("){mCallBack = null}");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MTimerHandler(");
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append("){mCallBack = ");
    localStringBuilder.append(this.f.getClass().getName());
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.v
 * JD-Core Version:    0.7.0.1
 */