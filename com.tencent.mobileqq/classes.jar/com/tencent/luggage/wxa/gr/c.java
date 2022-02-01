package com.tencent.luggage.wxa.gr;

import android.os.Process;
import com.tencent.luggage.wxa.gq.l;
import com.tencent.luggage.wxa.gw.b;

public class c
  extends l
{
  private g a;
  private boolean e = false;
  private com.tencent.luggage.wxa.gv.c f;
  
  public c(g paramg, String paramString, int paramInt)
  {
    super(paramString, paramInt);
    this.a = paramg;
  }
  
  public void a()
  {
    this.f = null;
  }
  
  public void a(com.tencent.luggage.wxa.gv.c paramc)
  {
    this.f = paramc;
    this.d = System.currentTimeMillis();
  }
  
  public void b()
  {
    this.e = false;
  }
  
  public void run()
  {
    b.b("MicroMsg.Mix.AudioDownloadTask", "run task %s", new Object[] { this.b });
    if (this.e)
    {
      this.a.a(this);
      return;
    }
    Process.setThreadPriority(10);
    this.a.a(this.f);
    this.a.a(this);
    this.e = true;
    b.b("MicroMsg.Mix.AudioDownloadTask", "run task %s end", new Object[] { this.b });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gr.c
 * JD-Core Version:    0.7.0.1
 */