package c.t.m.g;

final class ap$a
{
  long a;
  long b;
  long c;
  long d;
  long e;
  long f;
  long g = -1L;
  long h = -1L;
  long i = -1L;
  long j = -1L;
  long k = -1L;
  
  public final void a()
  {
    long l2 = -1L;
    this.g = (this.b - this.a);
    this.h = (this.c - this.b);
    this.i = (this.d - this.c);
    this.j = (this.e - this.d);
    this.k = (this.f - this.e);
    long l1 = this.g;
    if (l1 >= 0L)
    {
      this.g = l1;
      l1 = this.h;
      if (l1 < 0L) {
        break label164;
      }
      label96:
      this.h = l1;
      l1 = this.i;
      if (l1 < 0L) {
        break label171;
      }
      label112:
      this.i = l1;
      l1 = this.j;
      if (l1 < 0L) {
        break label178;
      }
    }
    for (;;)
    {
      this.j = l1;
      long l3 = this.k;
      l1 = l2;
      if (l3 >= 0L) {
        l1 = l3;
      }
      this.k = l1;
      return;
      l1 = -1L;
      break;
      label164:
      l1 = -1L;
      break label96;
      label171:
      l1 = -1L;
      break label112;
      label178:
      l1 = -1L;
    }
  }
  
  public final String toString()
  {
    return "Stat{startToTryConnect=" + this.g + ", connectCost=" + this.h + ", connectToPost=" + this.i + ", postToRsp=" + this.j + ", rspToRead=" + this.k + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.ap.a
 * JD-Core Version:    0.7.0.1
 */