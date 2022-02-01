package com.tencent.luggage.wxa.ad;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.j.e;

public final class h
  extends e
  implements Comparable<h>
{
  public long d;
  
  public h()
  {
    super(1);
  }
  
  public int a(@NonNull h paramh)
  {
    if (c() != paramh.c())
    {
      if (c()) {
        return 1;
      }
      return -1;
    }
    long l = this.c - paramh.c;
    if (l == 0L) {
      return 0;
    }
    if (l > 0L) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ad.h
 * JD-Core Version:    0.7.0.1
 */