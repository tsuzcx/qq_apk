package com.tencent.biz.qqstory.base;

import android.support.v4.util.LruCache;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class OneObjectCacheList<KEY, VALUE extends Copyable>
{
  public LruCache<KEY, VALUE> a;
  public ConcurrentHashMap<KEY, WeakReference<VALUE>> b = new ConcurrentHashMap(50);
  public int c = 0;
  
  public OneObjectCacheList(int paramInt)
  {
    this.a = new OneObjectCacheList.1(this, paramInt);
    this.a.evictAll();
  }
  
  private void b()
  {
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      WeakReference localWeakReference = (WeakReference)this.b.get(localObject);
      if ((localWeakReference != null) && (localWeakReference.get() == null))
      {
        this.b.remove(localObject);
        SLog.b("OneObjectCacheList", String.format("key :%s had been remove by jvm", new Object[] { localObject }));
      }
    }
  }
  
  public VALUE a(KEY paramKEY)
  {
    Copyable localCopyable2 = (Copyable)this.a.get(paramKEY);
    Copyable localCopyable1 = localCopyable2;
    if (localCopyable2 == null)
    {
      WeakReference localWeakReference = (WeakReference)this.b.remove(paramKEY);
      localCopyable1 = localCopyable2;
      if (localWeakReference != null)
      {
        localCopyable2 = (Copyable)localWeakReference.get();
        localCopyable1 = localCopyable2;
        if (localCopyable2 != null)
        {
          SLog.b("OneObjectCacheList", String.format("revert key %s from second cache", new Object[] { paramKEY }));
          a(paramKEY, localCopyable2);
          localCopyable1 = localCopyable2;
        }
      }
    }
    return localCopyable1;
  }
  
  public VALUE a(KEY paramKEY, VALUE paramVALUE)
  {
    Copyable localCopyable = a(paramKEY);
    if (localCopyable == null)
    {
      this.a.put(paramKEY, paramVALUE);
      return paramVALUE;
    }
    localCopyable.copy(paramVALUE);
    return localCopyable;
  }
  
  public void a()
  {
    int i = this.b.size();
    if (i - this.c > 50)
    {
      b();
      this.c = this.b.size();
      SLog.a("OneObjectCacheList", "evict second cache data count:%d", Integer.valueOf(i - this.c));
    }
  }
  
  public void a(int paramInt)
  {
    this.a.trimToSize(paramInt);
  }
  
  public void b(KEY paramKEY)
  {
    Copyable localCopyable = (Copyable)this.a.remove(paramKEY);
    if (localCopyable != null) {
      this.b.put(paramKEY, new WeakReference(localCopyable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.OneObjectCacheList
 * JD-Core Version:    0.7.0.1
 */