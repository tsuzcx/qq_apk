package com.tencent.luggage.wxa.a;

class h$b
{
  float a;
  float b;
  float c;
  float d;
  
  h$b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }
  
  h$b(b paramb)
  {
    this.a = paramb.a;
    this.b = paramb.b;
    this.c = paramb.c;
    this.d = paramb.d;
  }
  
  static b a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return new b(paramFloat1, paramFloat2, paramFloat3 - paramFloat1, paramFloat4 - paramFloat2);
  }
  
  float a()
  {
    return this.a + this.c;
  }
  
  void a(b paramb)
  {
    float f = paramb.a;
    if (f < this.a) {
      this.a = f;
    }
    f = paramb.b;
    if (f < this.b) {
      this.b = f;
    }
    if (paramb.a() > a()) {
      this.c = (paramb.a() - this.a);
    }
    if (paramb.b() > b()) {
      this.d = (paramb.b() - this.b);
    }
  }
  
  float b()
  {
    return this.b + this.d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.h.b
 * JD-Core Version:    0.7.0.1
 */