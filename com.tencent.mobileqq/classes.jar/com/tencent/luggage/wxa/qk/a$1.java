package com.tencent.luggage.wxa.qk;

import com.tencent.luggage.wxa.qz.y.a;

class a$1
  implements y.a
{
  a$1(a parama) {}
  
  public void a(int paramInt)
  {
    a locala;
    if (paramInt != 0)
    {
      if ((paramInt != 1) && (paramInt != 2)) {
        return;
      }
      if (this.a.t())
      {
        locala = this.a;
        locala.h = true;
        locala.q();
      }
    }
    else if (this.a.h)
    {
      locala = this.a;
      locala.h = false;
      locala.s();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qk.a.1
 * JD-Core Version:    0.7.0.1
 */