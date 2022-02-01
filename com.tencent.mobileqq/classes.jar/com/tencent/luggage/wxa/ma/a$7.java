package com.tencent.luggage.wxa.ma;

import com.tencent.luggage.wxa.mg.b;
import com.tencent.luggage.wxa.qz.v.a;

class a$7
  implements v.a
{
  a$7(a parama) {}
  
  public boolean p_()
  {
    int j = this.a.getCacheTimeSec();
    int i = this.a.getDuration();
    if (i != 0)
    {
      j = (int)(j * 100.0F / i);
      if (j != a.L(this.a))
      {
        a.a(this.a, j);
        if (a.d(this.a) != null) {
          a.d(this.a).a(j, i);
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ma.a.7
 * JD-Core Version:    0.7.0.1
 */