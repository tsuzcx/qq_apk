package com.tencent.luggage.wxa.iu;

class d$9
  implements Runnable
{
  d$9(d paramd, Object paramObject) {}
  
  public void run()
  {
    if ((this.b.aw()) && (!this.b.au()))
    {
      if (d.l(this.b) == null)
      {
        this.b.ay();
        return;
      }
      d.l(this.b).a(this.b, this.a);
      return;
    }
    if (d.l(this.b) == null)
    {
      this.b.aC();
      return;
    }
    d.l(this.b).c(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.d.9
 * JD-Core Version:    0.7.0.1
 */