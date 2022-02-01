package com.b.a;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class u$a
{
  public static final boolean a = u.a;
  private final List<u.a.a> b = new ArrayList();
  private boolean c = false;
  
  public final void a(String paramString)
  {
    try
    {
      this.c = true;
      if (this.b.size() == 0)
      {
        l1 = 0L;
      }
      else
      {
        l1 = ((u.a.a)this.b.get(0)).c;
        l2 = ((u.a.a)this.b.get(this.b.size() - 1)).c;
        l1 = l2 - l1;
      }
      if (l1 <= 0L) {
        return;
      }
      long l2 = ((u.a.a)this.b.get(0)).c;
      u.b("(%-4d ms) %s", new Object[] { Long.valueOf(l1), paramString });
      paramString = this.b.iterator();
      for (long l1 = l2; paramString.hasNext(); l1 = l2)
      {
        u.a.a locala = (u.a.a)paramString.next();
        l2 = locala.c;
        u.b("(+%-4d) [%2d] %s", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(locala.b), locala.a });
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public final void a(String paramString, long paramLong)
  {
    try
    {
      if (!this.c)
      {
        this.b.add(new u.a.a(paramString, paramLong, SystemClock.elapsedRealtime()));
        return;
      }
      throw new IllegalStateException("Marker added to finished log");
    }
    finally {}
  }
  
  protected final void finalize()
  {
    if (!this.c)
    {
      a("Request on the loose");
      u.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.b.a.u.a
 * JD-Core Version:    0.7.0.1
 */