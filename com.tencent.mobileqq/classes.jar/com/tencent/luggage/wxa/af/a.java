package com.tencent.luggage.wxa.af;

import com.tencent.luggage.wxa.ao.m;
import java.util.List;

public final class a
  extends com.tencent.luggage.wxa.ad.b
{
  private final b a;
  
  public a(List<byte[]> paramList)
  {
    super("DvbDecoder");
    paramList = new m((byte[])paramList.get(0));
    this.a = new b(paramList.h(), paramList.h());
  }
  
  protected c b(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.a();
    }
    return new c(this.a.a(paramArrayOfByte, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.af.a
 * JD-Core Version:    0.7.0.1
 */