package com.tencent.luggage.wxa.co;

import com.tencent.luggage.wxa.nt.a;
import com.tencent.luggage.wxa.nt.b;
import com.tencent.luggage.wxa.nt.d;
import com.tencent.luggage.wxa.nt.e;
import com.tencent.luggage.wxa.nt.f;
import com.tencent.luggage.wxa.nt.g;

final class a$1
  extends b
{
  public d a(String paramString)
  {
    if ("aac".equalsIgnoreCase(paramString)) {
      return new a();
    }
    if ("mp3".equalsIgnoreCase(paramString)) {
      return new e();
    }
    if ("wav".equalsIgnoreCase(paramString)) {
      return new g();
    }
    if ("pcm".equalsIgnoreCase(paramString)) {
      return new f();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.co.a.1
 * JD-Core Version:    0.7.0.1
 */