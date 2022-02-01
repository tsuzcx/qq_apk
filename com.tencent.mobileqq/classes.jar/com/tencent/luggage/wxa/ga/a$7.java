package com.tencent.luggage.wxa.ga;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.fy.b;

class a$7
  extends b<d>
{
  private d b = null;
  
  a$7(a parama) {}
  
  @NonNull
  protected String a()
  {
    return a.b(this.a);
  }
  
  protected int b()
  {
    return this.a.B();
  }
  
  @NonNull
  protected String c()
  {
    return this.a.f();
  }
  
  @NonNull
  protected d e()
  {
    if (this.b == null) {
      this.b = new d(this.a);
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ga.a.7
 * JD-Core Version:    0.7.0.1
 */