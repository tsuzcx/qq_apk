package com.dataline.util;

import android.widget.BaseAdapter;
import java.util.HashMap;
import java.util.Map;

public abstract class TimeAdapter
  extends BaseAdapter
{
  private Map<Long, Long> a = new HashMap();
  long g = 0L;
  
  public boolean a(long paramLong)
  {
    return this.a.containsKey(Long.valueOf(paramLong));
  }
  
  public abstract long b(int paramInt);
  
  public abstract int c();
  
  public abstract long c(int paramInt);
  
  public void d()
  {
    this.g = 0L;
    this.a.clear();
    int j = c();
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        long l = b(i);
        if (l > this.g + 180L)
        {
          this.g = l;
          this.a.put(Long.valueOf(c(i)), Long.valueOf(this.g));
        }
        i += 1;
      }
    }
  }
  
  public void e()
  {
    int i = c();
    if (i == 0) {
      return;
    }
    i -= 1;
    long l = b(i);
    if (l > this.g + 180L)
    {
      this.g = l;
      this.a.put(Long.valueOf(c(i)), Long.valueOf(this.g));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.util.TimeAdapter
 * JD-Core Version:    0.7.0.1
 */