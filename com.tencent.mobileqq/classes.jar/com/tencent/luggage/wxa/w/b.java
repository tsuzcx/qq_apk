package com.tencent.luggage.wxa.w;

import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.v.a.a;
import com.tencent.luggage.wxa.v.e;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class b
  implements com.tencent.luggage.wxa.v.b
{
  public com.tencent.luggage.wxa.v.a a(e parame)
  {
    Object localObject = parame.b;
    parame = ((ByteBuffer)localObject).array();
    int i = ((ByteBuffer)localObject).limit();
    localObject = new m(parame, i);
    String str1 = ((m)localObject).x();
    String str2 = ((m)localObject).x();
    long l = ((m)localObject).l();
    ((m)localObject).d(4);
    return new com.tencent.luggage.wxa.v.a(new a.a[] { new a(str1, str2, ((m)localObject).l() * 1000L / l, ((m)localObject).l(), Arrays.copyOfRange(parame, ((m)localObject).d(), i)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.w.b
 * JD-Core Version:    0.7.0.1
 */