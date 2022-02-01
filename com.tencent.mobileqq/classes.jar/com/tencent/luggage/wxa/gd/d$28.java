package com.tencent.luggage.wxa.gd;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.fy.b;

class d$28
  extends b<f>
{
  private f b = null;
  
  d$28(d paramd) {}
  
  @NonNull
  protected String a()
  {
    return d.b(this.a);
  }
  
  protected int b()
  {
    return this.a.B();
  }
  
  @NonNull
  protected String c()
  {
    return this.a.p();
  }
  
  @NonNull
  protected f e()
  {
    if (this.b == null) {
      this.b = new f(this.a);
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gd.d.28
 * JD-Core Version:    0.7.0.1
 */