package com.tencent.luggage.wxa.lu;

import com.tencent.luggage.wxa.pd.h.a;
import java.util.List;

class i$2
  implements h.a
{
  i$2(i parami) {}
  
  public boolean a(Object... arg1)
  {
    synchronized (i.a(this.a))
    {
      if (i.a(this.a).isEmpty()) {
        return false;
      }
      i.b(this.a).run();
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lu.i.2
 * JD-Core Version:    0.7.0.1
 */