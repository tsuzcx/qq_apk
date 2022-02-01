package com.tencent.luggage.wxa.ny;

import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class b
{
  private volatile int a;
  private final LinkedList<Runnable> b = new LinkedList();
  
  b(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(@Nullable Runnable paramRunnable)
  {
    if (paramRunnable != null) {}
    try
    {
      this.b.addLast(paramRunnable);
      int i = this.a - 1;
      this.a = i;
      if ((i > 0) || (this.b.size() <= 0)) {
        break label120;
      }
      paramRunnable = new LinkedList();
      paramRunnable.addAll(this.b);
      this.b.clear();
    }
    finally
    {
      for (;;)
      {
        for (;;)
        {
          throw paramRunnable;
        }
        paramRunnable = null;
      }
    }
    if (paramRunnable != null)
    {
      paramRunnable = paramRunnable.iterator();
      while (paramRunnable.hasNext()) {
        ((Runnable)paramRunnable.next()).run();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ny.b
 * JD-Core Version:    0.7.0.1
 */