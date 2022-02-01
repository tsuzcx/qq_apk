package com.tencent.luggage.wxa.od;

import com.tencent.luggage.wxa.oe.c;
import com.tencent.luggage.wxa.sj.g;

class b$1
  implements g
{
  b$1(b paramb, int paramInt, com.tencent.luggage.wxa.oe.b paramb1, String paramString) {}
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MicroMsg.NodeJavaBroker~CMD~");
    localStringBuilder.append(this.b.a());
    return localStringBuilder.toString();
  }
  
  public void run()
  {
    c localc = new c(b.a(this.d), this.a, this.d);
    this.b.a(this.c, localc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.od.b.1
 * JD-Core Version:    0.7.0.1
 */