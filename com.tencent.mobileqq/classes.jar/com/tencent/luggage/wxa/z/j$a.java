package com.tencent.luggage.wxa.z;

import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.am.a;

final class j$a
{
  public final long a;
  public final long b;
  public boolean c;
  @Nullable
  public a d;
  @Nullable
  public a e;
  
  public j$a(long paramLong, int paramInt)
  {
    this.a = paramLong;
    this.b = (paramLong + paramInt);
  }
  
  public int a(long paramLong)
  {
    return (int)(paramLong - this.a) + this.d.b;
  }
  
  public a a()
  {
    this.d = null;
    a locala = this.e;
    this.e = null;
    return locala;
  }
  
  public void a(a parama, a parama1)
  {
    this.d = parama;
    this.e = parama1;
    this.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.z.j.a
 * JD-Core Version:    0.7.0.1
 */