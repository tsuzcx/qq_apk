package com.tencent.luggage.wxa.gk;

import com.tencent.luggage.wxa.gi.c.c;

class d$1
  implements Runnable
{
  d$1(d paramd) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("task run manualFinish = ");
    ((StringBuilder)localObject).append(d.a(this.a));
    c.c.b("MicroMsg.SDK.SyncTask", ((StringBuilder)localObject).toString(), new Object[0]);
    if (d.a(this.a))
    {
      this.a.b();
    }
    else
    {
      localObject = this.a;
      ((d)localObject).a(((d)localObject).b());
    }
    localObject = this.a;
    d.a((d)localObject, h.a(d.b((d)localObject)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gk.d.1
 * JD-Core Version:    0.7.0.1
 */