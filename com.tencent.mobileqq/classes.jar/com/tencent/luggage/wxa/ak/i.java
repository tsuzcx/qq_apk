package com.tencent.luggage.wxa.ak;

import android.text.SpannableStringBuilder;
import com.tencent.luggage.wxa.ad.d;
import com.tencent.luggage.wxa.ao.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class i
  implements d
{
  private final List<e> a;
  private final int b;
  private final long[] c;
  private final long[] d;
  
  public i(List<e> paramList)
  {
    this.a = paramList;
    this.b = paramList.size();
    this.c = new long[this.b * 2];
    int i = 0;
    while (i < this.b)
    {
      e locale = (e)paramList.get(i);
      int j = i * 2;
      this.c[j] = locale.m;
      this.c[(j + 1)] = locale.n;
      i += 1;
    }
    paramList = this.c;
    this.d = Arrays.copyOf(paramList, paramList.length);
    Arrays.sort(this.d);
  }
  
  public int a(long paramLong)
  {
    int i = x.b(this.d, paramLong, false, false);
    if (i < this.d.length) {
      return i;
    }
    return -1;
  }
  
  public long a(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramInt >= 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    com.tencent.luggage.wxa.ao.a.a(bool1);
    if (paramInt < this.d.length) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    com.tencent.luggage.wxa.ao.a.a(bool1);
    return this.d[paramInt];
  }
  
  public int b()
  {
    return this.d.length;
  }
  
  public List<com.tencent.luggage.wxa.ad.a> b(long paramLong)
  {
    Object localObject4 = null;
    int i = 0;
    Object localObject3 = null;
    Object localObject2;
    for (Object localObject1 = localObject3; i < this.b; localObject1 = localObject2)
    {
      long[] arrayOfLong = this.c;
      int j = i * 2;
      Object localObject5 = localObject4;
      Object localObject6 = localObject3;
      localObject2 = localObject1;
      if (arrayOfLong[j] <= paramLong)
      {
        localObject5 = localObject4;
        localObject6 = localObject3;
        localObject2 = localObject1;
        if (paramLong < arrayOfLong[(j + 1)])
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList();
          }
          localObject6 = (e)this.a.get(i);
          if (((e)localObject6).a())
          {
            if (localObject3 == null)
            {
              localObject5 = localObject4;
            }
            else if (localObject4 == null)
            {
              localObject5 = new SpannableStringBuilder();
              ((SpannableStringBuilder)localObject5).append(localObject3.a).append("\n").append(((e)localObject6).a);
              localObject6 = localObject3;
            }
            else
            {
              localObject4.append("\n").append(((e)localObject6).a);
              localObject5 = localObject4;
              localObject6 = localObject3;
            }
          }
          else
          {
            ((ArrayList)localObject2).add(localObject6);
            localObject6 = localObject3;
            localObject5 = localObject4;
          }
        }
      }
      i += 1;
      localObject4 = localObject5;
      localObject3 = localObject6;
    }
    if (localObject4 != null) {
      localObject1.add(new e(localObject4));
    } else if (localObject3 != null) {
      localObject1.add(localObject3);
    }
    if (localObject1 != null) {
      return localObject1;
    }
    return Collections.emptyList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ak.i
 * JD-Core Version:    0.7.0.1
 */