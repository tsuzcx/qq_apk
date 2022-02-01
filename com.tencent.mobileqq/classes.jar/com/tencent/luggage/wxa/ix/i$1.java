package com.tencent.luggage.wxa.ix;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;

class i$1
  implements Runnable
{
  i$1(i parami) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("task run manualFinish = ");
    ((StringBuilder)localObject).append(i.a(this.a));
    o.d("MicroMsg.SDK.SyncTask", ((StringBuilder)localObject).toString());
    if (i.a(this.a))
    {
      this.a.b();
    }
    else
    {
      localObject = this.a;
      ((i)localObject).a(((i)localObject).b());
    }
    localObject = this.a;
    i.a((i)localObject, af.c(i.b((i)localObject)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ix.i.1
 * JD-Core Version:    0.7.0.1
 */