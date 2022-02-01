package com.tencent.luggage.wxa.bu;

class a$4
  implements Runnable
{
  a$4(a parama, long paramLong) {}
  
  public void run()
  {
    if (this.a <= 0L) {
      return;
    }
    synchronized (a.f(this.b))
    {
      if (this.a < 5120L)
      {
        if (a.f(this.b).a(0)) {
          a.f(this.b).put(0, a.f(this.b).get(0) + 1);
        } else {
          a.f(this.b).put(0, 1);
        }
      }
      else if (this.a < 10240L)
      {
        if (a.f(this.b).a(1)) {
          a.f(this.b).put(1, a.f(this.b).get(1) + 1);
        } else {
          a.f(this.b).put(1, 1);
        }
      }
      else if (this.a < 20480L)
      {
        if (a.f(this.b).a(2)) {
          a.f(this.b).put(2, a.f(this.b).get(2) + 1);
        } else {
          a.f(this.b).put(2, 1);
        }
      }
      else if (this.a < 51200L)
      {
        if (a.f(this.b).a(3)) {
          a.f(this.b).put(3, a.f(this.b).get(3) + 1);
        } else {
          a.f(this.b).put(3, 1);
        }
      }
      else if (this.a < 102400L)
      {
        if (a.f(this.b).a(4)) {
          a.f(this.b).put(4, a.f(this.b).get(4) + 1);
        } else {
          a.f(this.b).put(4, 1);
        }
      }
      else if (this.a < 153600L)
      {
        if (a.f(this.b).a(5)) {
          a.f(this.b).put(5, a.f(this.b).get(5) + 1);
        } else {
          a.f(this.b).put(5, 1);
        }
      }
      else if (this.a < 204800L)
      {
        if (a.f(this.b).a(6)) {
          a.f(this.b).put(6, a.f(this.b).get(6) + 1);
        } else {
          a.f(this.b).put(6, 1);
        }
      }
      else if (this.a < 512000L)
      {
        if (a.f(this.b).a(7)) {
          a.f(this.b).put(7, a.f(this.b).get(7) + 1);
        } else {
          a.f(this.b).put(7, 1);
        }
      }
      else if (this.a < 1048576L)
      {
        if (a.f(this.b).a(8)) {
          a.f(this.b).put(8, a.f(this.b).get(8) + 1);
        } else {
          a.f(this.b).put(8, 1);
        }
      }
      else if (this.a < 2097152L)
      {
        if (a.f(this.b).a(9)) {
          a.f(this.b).put(9, a.f(this.b).get(9) + 1);
        } else {
          a.f(this.b).put(9, 1);
        }
      }
      else if (this.a < 3145728L)
      {
        if (a.f(this.b).a(10)) {
          a.f(this.b).put(10, a.f(this.b).get(10) + 1);
        } else {
          a.f(this.b).put(10, 1);
        }
      }
      else if (a.f(this.b).a(11)) {
        a.f(this.b).put(11, a.f(this.b).get(11) + 1);
      } else {
        a.f(this.b).put(11, 1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bu.a.4
 * JD-Core Version:    0.7.0.1
 */