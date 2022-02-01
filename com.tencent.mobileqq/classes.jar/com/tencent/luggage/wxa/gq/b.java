package com.tencent.luggage.wxa.gq;

import android.os.Process;

public class b
  extends l
{
  private m a;
  private boolean e = false;
  private n f;
  
  public b(m paramm, String paramString, int paramInt)
  {
    super(paramString, paramInt);
    this.a = paramm;
  }
  
  public void a(n paramn)
  {
    this.f = paramn;
    this.d = System.currentTimeMillis();
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  public void b()
  {
    this.e = false;
  }
  
  public void c()
  {
    this.f = null;
  }
  
  public n d()
  {
    return this.f;
  }
  
  public boolean e()
  {
    return this.f == null;
  }
  
  public void run()
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecodeTask", "run task %s", new Object[] { this.b });
    if (this.e) {
      return;
    }
    Process.setThreadPriority(-16);
    this.a.a(this.f);
    this.a.a(this);
    this.e = true;
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecodeTask", "run task %s end", new Object[] { this.b });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gq.b
 * JD-Core Version:    0.7.0.1
 */