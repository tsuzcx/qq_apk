package com.tencent.luggage.wxa.ad;

import com.tencent.luggage.wxa.j.g;
import java.nio.ByteBuffer;

public abstract class b
  extends g<h, i, f>
  implements e
{
  private final String a;
  
  protected b(String paramString)
  {
    super(new h[2], new i[2]);
    this.a = paramString;
    a(1024);
  }
  
  protected abstract d a(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean);
  
  protected final f a(h paramh, i parami, boolean paramBoolean)
  {
    try
    {
      Object localObject = paramh.b;
      localObject = a(((ByteBuffer)localObject).array(), ((ByteBuffer)localObject).limit(), paramBoolean);
      parami.a(paramh.c, (d)localObject, paramh.d);
      parami.c(-2147483648);
      return null;
    }
    catch (f paramh) {}
    return paramh;
  }
  
  public void a(long paramLong) {}
  
  protected final void a(i parami)
  {
    super.a(parami);
  }
  
  protected final h i()
  {
    return new h();
  }
  
  protected final i j()
  {
    return new c(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ad.b
 * JD-Core Version:    0.7.0.1
 */