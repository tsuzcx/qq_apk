package com.tencent.luggage.wxa.a;

class i$b
{
  float a;
  float b;
  float c = 0.0F;
  float d = 0.0F;
  boolean e = false;
  
  i$b(i parami, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    double d1 = Math.sqrt(paramFloat3 * paramFloat3 + paramFloat4 * paramFloat4);
    if (d1 != 0.0D)
    {
      double d2 = paramFloat3;
      Double.isNaN(d2);
      this.c = ((float)(d2 / d1));
      d2 = paramFloat4;
      Double.isNaN(d2);
      this.d = ((float)(d2 / d1));
    }
  }
  
  void a(float paramFloat1, float paramFloat2)
  {
    float f1 = paramFloat1 - this.a;
    float f2 = paramFloat2 - this.b;
    double d1 = Math.sqrt(f1 * f1 + f2 * f2);
    paramFloat2 = f1;
    paramFloat1 = f2;
    if (d1 != 0.0D)
    {
      double d2 = f1;
      Double.isNaN(d2);
      paramFloat2 = (float)(d2 / d1);
      d2 = f2;
      Double.isNaN(d2);
      paramFloat1 = (float)(d2 / d1);
    }
    if ((paramFloat2 == -this.c) && (paramFloat1 == -this.d))
    {
      this.e = true;
      this.c = (-paramFloat1);
      this.d = paramFloat2;
      return;
    }
    this.c += paramFloat2;
    this.d += paramFloat1;
  }
  
  void a(b paramb)
  {
    if (paramb.c == -this.c)
    {
      float f1 = paramb.d;
      if (f1 == -this.d)
      {
        this.e = true;
        this.c = (-f1);
        this.d = paramb.c;
        return;
      }
    }
    this.c += paramb.c;
    this.d += paramb.d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",");
    localStringBuilder.append(this.d);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.i.b
 * JD-Core Version:    0.7.0.1
 */