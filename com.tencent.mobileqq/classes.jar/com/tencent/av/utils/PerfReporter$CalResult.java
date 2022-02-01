package com.tencent.av.utils;

class PerfReporter$CalResult
{
  public double a;
  public int a;
  public int b = -1;
  public int c = -1;
  public int d = 0;
  
  private PerfReporter$CalResult()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Double = -1.0D;
  }
  
  public void a(CalResult paramCalResult)
  {
    int i = paramCalResult.jdField_a_of_type_Int;
    if ((i >= 0) && (paramCalResult.b >= 0) && (paramCalResult.c >= 0))
    {
      if (paramCalResult.jdField_a_of_type_Double < 0.0D) {
        return;
      }
      int k = this.d;
      int m = paramCalResult.d;
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
      k = this.jdField_a_of_type_Int;
      if (k >= 0) {
        i = Math.max(k, i);
      }
      this.jdField_a_of_type_Int = i;
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
      d3 = this.jdField_a_of_type_Double;
      if (d3 < 0.0D) {
        d1 = paramCalResult.jdField_a_of_type_Double;
      } else {
        d1 = d3 * d1 + paramCalResult.jdField_a_of_type_Double * d2;
      }
      this.jdField_a_of_type_Double = d1;
      this.d = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.PerfReporter.CalResult
 * JD-Core Version:    0.7.0.1
 */