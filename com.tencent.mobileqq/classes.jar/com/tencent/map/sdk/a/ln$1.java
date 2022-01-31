package com.tencent.map.sdk.a;

final class ln$1
  implements kl.a
{
  ln$1(ln paramln) {}
  
  public final void a(nv paramnv)
  {
    if (paramnv.i != 10000) {
      break label10;
    }
    label10:
    while (!(paramnv instanceof pd)) {
      return;
    }
    paramnv = (pd)paramnv;
    int j;
    if (paramnv.x)
    {
      i = paramnv.y;
      j = paramnv.z;
      this.a.b.az.b(this.a.b.aq / 2 - i, this.a.b.ar / 2 - j);
    }
    if (paramnv.f)
    {
      i = paramnv.r;
      j = paramnv.s;
      this.a.b.az.b(i, j);
    }
    if ((paramnv.u) || (paramnv.t) || (paramnv.v)) {}
    for (int i = 1;; i = 0)
    {
      float f;
      if (i != 0)
      {
        f = (float)paramnv.w;
        pm localpm = this.a.b.az;
        double d = f;
        localpm.b.c.a((float)d);
      }
      if (paramnv.A)
      {
        i = paramnv.H;
        j = paramnv.I;
        this.a.b.az.a(i, j);
        if (paramnv.e) {
          this.a.b.c(i, j);
        }
      }
      if (paramnv.J)
      {
        f = paramnv.N;
        this.a.b.az.b(f);
      }
      if (paramnv.O)
      {
        f = paramnv.S;
        this.a.b.az.a(f);
      }
      if (!paramnv.x) {
        break;
      }
      i = paramnv.y;
      j = paramnv.z;
      this.a.b.az.b(i - this.a.b.aq / 2, j - this.a.b.ar / 2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.ln.1
 * JD-Core Version:    0.7.0.1
 */