package com.tencent.luggage.wxa.qz;

class ac$1
  implements Runnable
{
  ac$1(ac paramac) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("task run manualFinish = ");
    ((StringBuilder)localObject).append(ac.a(this.a));
    o.d("MicroMsg.SDK.SyncTask", ((StringBuilder)localObject).toString());
    if (ac.a(this.a))
    {
      this.a.b();
    }
    else
    {
      localObject = this.a;
      ((ac)localObject).a(((ac)localObject).b());
    }
    localObject = this.a;
    ac.a((ac)localObject, af.c(ac.b((ac)localObject)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.ac.1
 * JD-Core Version:    0.7.0.1
 */