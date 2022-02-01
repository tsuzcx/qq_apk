package com.tencent.luggage.wxa.mp;

import com.tencent.luggage.wxa.gy.a.a;
import com.tencent.luggage.wxa.qz.o;

class c$2
  implements a.a
{
  c$2(c paramc) {}
  
  public void a(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    o.f("MicroMsg.DefaultLuggageRecorder", "onFrameRecorded buffSize:%d isLastFrame:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    byte[] arrayOfByte = new byte[paramInt];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramInt);
    this.a.a(arrayOfByte, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mp.c.2
 * JD-Core Version:    0.7.0.1
 */