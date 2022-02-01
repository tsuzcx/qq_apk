package com.tencent.luggage.wxa.or;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.oq.e.a;
import com.tencent.luggage.wxa.oq.e.b;

class f$b
{
  private e.b a;
  private e.a b;
  
  private f$b(e.b paramb, e.a parama)
  {
    this.a = paramb;
    this.b = parama;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Req{");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.or.f.b
 * JD-Core Version:    0.7.0.1
 */