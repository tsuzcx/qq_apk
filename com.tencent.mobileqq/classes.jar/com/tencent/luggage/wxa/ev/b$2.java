package com.tencent.luggage.wxa.ev;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.xweb.ab;

final class b$2
  extends ab
{
  final String a = "XWebIdkey";
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("callback: idkeyForPair:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramInt5);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramInt4);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramInt6);
    o.f("XWebIdkey", localStringBuilder.toString());
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, String paramString2)
  {
    paramString2 = new StringBuilder();
    paramString2.append("callback: kvStat:");
    paramString2.append(paramInt1);
    paramString2.append(", ");
    paramString2.append(paramInt2);
    paramString2.append(",");
    paramString2.append(paramInt3);
    paramString2.append(",");
    paramString2.append(paramInt4);
    paramString2.append(",");
    paramString2.append(paramString1);
    paramString2.append(",");
    paramString2.append(paramInt6);
    paramString2.append(",");
    paramString2.append(paramInt7);
    paramString2.append(",");
    paramString2.append(paramInt8);
    paramString2.append(",");
    paramString2.append(paramInt9);
    paramString2.append(",");
    paramString2.append(paramInt10);
    o.f("XWebIdkey", paramString2.toString());
  }
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("callback: kvStat:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramString);
    o.f("XWebIdkey", localStringBuilder.toString());
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("callback: idkeyStat:");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramLong3);
    o.f("XWebIdkey", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ev.b.2
 * JD-Core Version:    0.7.0.1
 */