package com.tencent.luggage.wxa.am;

import android.net.Uri;
import com.tencent.luggage.wxa.ao.a;
import java.util.Arrays;

public final class j
{
  public final Uri a;
  public final byte[] b;
  public final long c;
  public final long d;
  public final long e;
  public final String f;
  public final int g;
  
  public j(Uri paramUri, int paramInt)
  {
    this(paramUri, 0L, -1L, null, paramInt);
  }
  
  public j(Uri paramUri, long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt)
  {
    this(paramUri, null, paramLong1, paramLong2, paramLong3, paramString, paramInt);
  }
  
  public j(Uri paramUri, long paramLong1, long paramLong2, String paramString)
  {
    this(paramUri, paramLong1, paramLong1, paramLong2, paramString, 0);
  }
  
  public j(Uri paramUri, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this(paramUri, paramLong1, paramLong1, paramLong2, paramString, paramInt);
  }
  
  public j(Uri paramUri, byte[] paramArrayOfByte, long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt)
  {
    boolean bool2 = true;
    if (paramLong1 >= 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    a.a(bool1);
    if (paramLong2 >= 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    a.a(bool1);
    boolean bool1 = bool2;
    if (paramLong3 <= 0L) {
      if (paramLong3 == -1L) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    a.a(bool1);
    this.a = paramUri;
    this.b = paramArrayOfByte;
    this.c = paramLong1;
    this.d = paramLong2;
    this.e = paramLong3;
    this.f = paramString;
    this.g = paramInt;
  }
  
  public j a(long paramLong)
  {
    long l2 = this.e;
    long l1 = -1L;
    if (l2 != -1L) {
      l1 = l2 - paramLong;
    }
    return a(paramLong, l1);
  }
  
  public j a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) && (this.e == paramLong2)) {
      return this;
    }
    return new j(this.a, this.b, this.c + paramLong1, this.d + paramLong1, paramLong2, this.f, this.g);
  }
  
  public boolean a(int paramInt)
  {
    return (this.g & paramInt) == paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataSpec[");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append(Arrays.toString(this.b));
    localStringBuilder.append(", ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.g);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.am.j
 * JD-Core Version:    0.7.0.1
 */