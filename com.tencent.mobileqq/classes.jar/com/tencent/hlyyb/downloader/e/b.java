package com.tencent.hlyyb.downloader.e;

import android.os.SystemClock;
import com.tencent.hlyyb.downloader.a.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class b
{
  private long a = 0L;
  private long b = 0L;
  private int c = 0;
  private List<c> d = new LinkedList();
  
  public final int a()
  {
    return this.c;
  }
  
  public final void a(int paramInt)
  {
    int k = 0;
    int m = 1;
    int i;
    if (paramInt <= 0) {
      i = 1;
    } else {
      i = 0;
    }
    long l2 = SystemClock.elapsedRealtime();
    int j = (int)(l2 - this.a);
    this.a = l2;
    Iterator localIterator;
    c localc;
    if (this.d.size() == 0)
    {
      j = m;
      if (i == 0)
      {
        this.d.add(new c(paramInt));
        j = m;
      }
    }
    else
    {
      localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        localc = (c)localIterator.next();
        localc.b += j;
        if ((i == 0) && (localc.b > 2000))
        {
          localc.b = 0;
          localc.a = paramInt;
          i = 1;
        }
      }
      if ((i == 0) && (this.d.size() <= 2000 / a.d + 1)) {
        this.d.add(new c(paramInt));
      }
      if (l2 - this.b > 200L) {
        j = m;
      } else {
        j = 0;
      }
    }
    if (j != 0)
    {
      if (this.d.size() == 0)
      {
        paramInt = k;
      }
      else
      {
        long l1 = 0L;
        localIterator = this.d.iterator();
        while (localIterator.hasNext())
        {
          localc = (c)localIterator.next();
          if (localc.b <= 2000) {
            l1 += localc.a;
          }
        }
        paramInt = (int)(l1 * 1000L / 2000L);
      }
      this.c = paramInt;
      this.b = l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.e.b
 * JD-Core Version:    0.7.0.1
 */