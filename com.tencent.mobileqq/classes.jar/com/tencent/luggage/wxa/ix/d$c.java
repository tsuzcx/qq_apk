package com.tencent.luggage.wxa.ix;

import android.os.Message;

final class d$c
  extends f
{
  d$c(d paramd, g paramg)
  {
    super(paramg);
  }
  
  public boolean a(Message paramMessage)
  {
    if (d.7.b[d.a.a(paramMessage.what).ordinal()] != 4) {
      return super.a(paramMessage);
    }
    paramMessage = this.a;
    d.a(paramMessage, d.d(paramMessage));
    return true;
  }
  
  public String c()
  {
    return "|BackgroundKeepNoChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ix.d.c
 * JD-Core Version:    0.7.0.1
 */