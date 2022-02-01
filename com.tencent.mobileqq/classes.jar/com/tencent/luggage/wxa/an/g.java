package com.tencent.luggage.wxa.an;

import androidx.annotation.NonNull;
import java.io.File;

public class g
  implements Comparable<g>
{
  public final String a;
  public final long b;
  public final long c;
  public final boolean d;
  public final File e;
  public final long f;
  
  public g(String paramString, long paramLong1, long paramLong2, long paramLong3, File paramFile)
  {
    this.a = paramString;
    this.b = paramLong1;
    this.c = paramLong2;
    boolean bool;
    if (paramFile != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.d = bool;
    this.e = paramFile;
    this.f = paramLong3;
  }
  
  public int a(@NonNull g paramg)
  {
    if (!this.a.equals(paramg.a)) {
      return this.a.compareTo(paramg.a);
    }
    long l = this.b - paramg.b;
    if (l == 0L) {
      return 0;
    }
    if (l < 0L) {
      return -1;
    }
    return 1;
  }
  
  public boolean a()
  {
    return this.c == -1L;
  }
  
  public boolean b()
  {
    return this.d ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.an.g
 * JD-Core Version:    0.7.0.1
 */