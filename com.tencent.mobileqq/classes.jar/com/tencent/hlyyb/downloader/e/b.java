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
    int m = 1;
    int k = 0;
    if (paramInt <= 0) {}
    for (int i = 1;; i = 0)
    {
      long l2 = SystemClock.elapsedRealtime();
      int j = (int)(l2 - this.a);
      this.a = l2;
      Iterator localIterator;
      label114:
      c localc;
      if (this.d.size() == 0)
      {
        j = m;
        if (i == 0)
        {
          this.d.add(new c(paramInt));
          j = m;
        }
        if (j != 0)
        {
          if (this.d.size() != 0) {
            break label245;
          }
          paramInt = k;
          this.c = paramInt;
          this.b = l2;
        }
      }
      else
      {
        localIterator = this.d.iterator();
        if (localIterator.hasNext())
        {
          localc = (c)localIterator.next();
          localc.b += j;
          if ((i != 0) || (localc.b <= 2000)) {
            break label324;
          }
          localc.b = 0;
          localc.a = paramInt;
          i = 1;
        }
      }
      label259:
      label321:
      label324:
      for (;;)
      {
        break label114;
        if ((i == 0) && (this.d.size() <= 2000 / a.d + 1)) {
          this.d.add(new c(paramInt));
        }
        j = m;
        if (l2 - this.b > 200L) {
          break;
        }
        j = 0;
        break;
        label245:
        long l1 = 0L;
        localIterator = this.d.iterator();
        if (localIterator.hasNext())
        {
          localc = (c)localIterator.next();
          if (localc.b > 2000) {
            break label321;
          }
          l1 = localc.a + l1;
        }
        for (;;)
        {
          break label259;
          paramInt = (int)(1000L * l1 / 2000L);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.e.b
 * JD-Core Version:    0.7.0.1
 */