package com.tencent.luggage.wxa.oe;

import androidx.collection.ArraySet;
import com.tencent.luggage.wxa.iu.h;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class e
{
  protected final h a;
  private final e.a b;
  private final Set<Integer> c = new ArraySet();
  
  public e(e.a parama, h paramh)
  {
    this.b = parama;
    this.a = paramh;
  }
  
  protected abstract void a();
  
  public void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (!this.c.isEmpty())
        {
          i = 1;
          this.c.add(Integer.valueOf(paramInt));
          if (i != 0) {
            return;
          }
          a();
          return;
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  public void a(Map<String, Object> paramMap)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      this.b.a(i, paramMap);
    }
  }
  
  protected abstract void b();
  
  public void b(int paramInt)
  {
    try
    {
      if (this.c.contains(Integer.valueOf(paramInt))) {
        this.c.remove(Integer.valueOf(paramInt));
      }
      if (!this.c.isEmpty()) {
        return;
      }
      b();
      return;
    }
    finally {}
  }
  
  public abstract int c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oe.e
 * JD-Core Version:    0.7.0.1
 */