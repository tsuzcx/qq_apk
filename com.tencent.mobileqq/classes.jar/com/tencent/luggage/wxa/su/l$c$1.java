package com.tencent.luggage.wxa.su;

import android.os.AsyncTask;

class l$c$1
  extends AsyncTask<Void, Void, Integer>
{
  l$c$1(l.c paramc) {}
  
  protected Integer a(Void... paramVarArgs)
  {
    if ((l.c.a(this.a) == null) && (l.c.b(this.a) == null)) {
      return Integer.valueOf(-1);
    }
    return Integer.valueOf(l.c.a(this.a).a(l.c.b(this.a)));
  }
  
  protected void a(Integer paramInteger)
  {
    if (paramInteger.intValue() == 0)
    {
      l.c.c(this.a).b(l.c.a(this.a).a(), 0);
      return;
    }
    l.c.c(this.a).b(l.c.a(this.a).a(), -2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.su.l.c.1
 * JD-Core Version:    0.7.0.1
 */