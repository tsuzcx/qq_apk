package com.tencent.av.utils;

class PerfReporter$CalResult
{
  public int a = -1;
  public int b = -1;
  public int c = -1;
  public double d = -1.0D;
  public int e = 0;
  
  public void a(CalResult paramCalResult)
  {
    int i = paramCalResult.a;
    if ((i >= 0) && (paramCalResult.b >= 0) && (paramCalResult.c >= 0))
    {
      if (paramCalResult.d < 0.0D) {
        return;
      }
      int k = this.e;
      int m = paramCalResult.e;
      int j = k + m;
      double d1 = k;
      Double.isNaN(d1);
      double d2 = j;
      Double.isNaN(d2);
      d1 = d1 * 1.0D / d2;
      double d3 = m;
      Double.isNaN(d3);
      Double.isNaN(d2);
      d2 = d3 * 1.0D / d2;
      k = this.a;
      if (k >= 0) {
        i = Math.max(k, i);
      }
      this.a = i;
      i = this.b;
      if (i < 0) {
        i = paramCalResult.b;
      } else {
        i = Math.min(i, paramCalResult.b);
      }
      this.b = i;
      i = this.c;
      if (i < 0)
      {
        i = paramCalResult.c;
      }
      else
      {
        d3 = i;
        Double.isNaN(d3);
        double d4 = paramCalResult.c;
        Double.isNaN(d4);
        i = (int)(d3 * d1 + d4 * d2);
      }
      this.c = i;
      d3 = this.d;
      if (d3 < 0.0D) {
        d1 = paramCalResult.d;
      } else {
        d1 = d3 * d1 + paramCalResult.d * d2;
      }
      this.d = d1;
      this.e = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.PerfReporter.CalResult
 * JD-Core Version:    0.7.0.1
 */