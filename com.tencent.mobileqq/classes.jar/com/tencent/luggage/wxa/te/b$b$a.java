package com.tencent.luggage.wxa.te;

import com.tencent.luggage.wxa.tf.b;

class b$b$a
{
  short[] a = new short[768];
  
  b$b$a(b.b paramb) {}
  
  public byte a(b paramb)
  {
    int i = 1;
    int j;
    do
    {
      j = paramb.a(this.a, i) | i << 1;
      i = j;
    } while (j < 256);
    return (byte)j;
  }
  
  public byte a(b paramb, byte paramByte)
  {
    int i = 1;
    int j = paramByte;
    do
    {
      int k = j >> 7 & 0x1;
      j = (byte)(j << 1);
      int m = paramb.a(this.a, (k + 1 << 8) + i);
      paramByte = i << 1 | m;
      if (k != m) {
        for (;;)
        {
          i = paramByte;
          if (paramByte >= 256) {
            break;
          }
          paramByte = paramByte << 1 | paramb.a(this.a, paramByte);
        }
      }
      i = paramByte;
    } while (paramByte < 256);
    i = paramByte;
    return (byte)i;
  }
  
  public void a()
  {
    b.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.te.b.b.a
 * JD-Core Version:    0.7.0.1
 */