package com.tencent.luggage.wxa.do;

import com.tencent.luggage.wxa.qz.af;

final class f$1
  implements f
{
  public String a(c paramc)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SessionId@");
    localStringBuilder.append(paramc.hashCode());
    localStringBuilder.append("#");
    localStringBuilder.append(af.d());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.do.f.1
 * JD-Core Version:    0.7.0.1
 */