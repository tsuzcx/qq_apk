package com.tencent.luggage.wxa.ix;

import android.os.Message;

final class d$b
  extends e
{
  d$b(d paramd, g paramg, com.tencent.luggage.wxa.iu.d paramd1)
  {
    super(paramg, paramd1);
  }
  
  public void a()
  {
    super.a();
  }
  
  public boolean a(Message paramMessage)
  {
    int i = d.7.b[d.a.a(paramMessage.what).ordinal()];
    if (i != 4)
    {
      if (i != 5) {
        return super.a(paramMessage);
      }
      e();
      return true;
    }
    paramMessage = this.a;
    d.a(paramMessage, d.d(paramMessage));
    return true;
  }
  
  public void b()
  {
    super.b();
  }
  
  public String c()
  {
    return "|Background";
  }
  
  void d()
  {
    if (d.l(this.a) == this)
    {
      d locald = this.a;
      d.a(locald, d.a(locald));
      this.a.a(d.a.l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ix.d.b
 * JD-Core Version:    0.7.0.1
 */