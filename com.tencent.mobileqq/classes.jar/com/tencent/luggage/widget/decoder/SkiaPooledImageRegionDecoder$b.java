package com.tencent.luggage.widget.decoder;

import android.graphics.BitmapRegionDecoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

class SkiaPooledImageRegionDecoder$b
{
  private final Semaphore a = new Semaphore(0, true);
  private final Map<BitmapRegionDecoder, Boolean> b = new ConcurrentHashMap();
  
  private void a(BitmapRegionDecoder paramBitmapRegionDecoder)
  {
    if (c(paramBitmapRegionDecoder)) {
      this.a.release();
    }
  }
  
  private boolean a()
  {
    try
    {
      boolean bool = this.b.isEmpty();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private int b()
  {
    try
    {
      int i = this.b.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void b(BitmapRegionDecoder paramBitmapRegionDecoder)
  {
    try
    {
      this.b.put(paramBitmapRegionDecoder, Boolean.valueOf(false));
      this.a.release();
      return;
    }
    finally
    {
      paramBitmapRegionDecoder = finally;
      throw paramBitmapRegionDecoder;
    }
  }
  
  private BitmapRegionDecoder c()
  {
    this.a.acquireUninterruptibly();
    return e();
  }
  
  private boolean c(BitmapRegionDecoder paramBitmapRegionDecoder)
  {
    try
    {
      Iterator localIterator = this.b.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (paramBitmapRegionDecoder == localEntry.getKey())
        {
          if (((Boolean)localEntry.getValue()).booleanValue())
          {
            localEntry.setValue(Boolean.valueOf(false));
            return true;
          }
          return false;
        }
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw paramBitmapRegionDecoder;
    }
  }
  
  private void d()
  {
    try
    {
      while (!this.b.isEmpty())
      {
        BitmapRegionDecoder localBitmapRegionDecoder = c();
        localBitmapRegionDecoder.recycle();
        this.b.remove(localBitmapRegionDecoder);
      }
      return;
    }
    finally
    {
      localObject = finally;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  private BitmapRegionDecoder e()
  {
    try
    {
      Object localObject1 = this.b.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
        if (!((Boolean)localEntry.getValue()).booleanValue())
        {
          localEntry.setValue(Boolean.valueOf(true));
          localObject1 = (BitmapRegionDecoder)localEntry.getKey();
          return localObject1;
        }
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.widget.decoder.SkiaPooledImageRegionDecoder.b
 * JD-Core Version:    0.7.0.1
 */