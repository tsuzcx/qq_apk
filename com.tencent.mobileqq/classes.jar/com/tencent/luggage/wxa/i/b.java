package com.tencent.luggage.wxa.i;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;

public final class b
{
  public static final b a = new b.a().a();
  public final int b;
  public final int c;
  public final int d;
  private AudioAttributes e;
  
  private b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
  }
  
  @TargetApi(21)
  AudioAttributes a()
  {
    if (this.e == null) {
      this.e = new AudioAttributes.Builder().setContentType(this.b).setFlags(this.c).setUsage(this.d).build();
    }
    return this.e;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (b)paramObject;
      return (this.b == paramObject.b) && (this.c == paramObject.c) && (this.d == paramObject.d);
    }
    return false;
  }
  
  public int hashCode()
  {
    return ((527 + this.b) * 31 + this.c) * 31 + this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.i.b
 * JD-Core Version:    0.7.0.1
 */