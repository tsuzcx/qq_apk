package com.tencent.biz.qqstory.base;

import android.support.v4.util.LruCache;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import ndf;

public class OneObjectCacheList
{
  public int a;
  public LruCache a;
  public ConcurrentHashMap a;
  
  public OneObjectCacheList(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(50);
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new ndf(this, paramInt);
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
  }
  
  private void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      if ((localWeakReference != null) && (localWeakReference.get() == null))
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localObject);
        SLog.b("OneObjectCacheList", String.format("key :%s had been remove by jvm", new Object[] { localObject }));
      }
    }
  }
  
  public Copyable a(Object paramObject)
  {
    Copyable localCopyable2 = (Copyable)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramObject);
    Copyable localCopyable1 = localCopyable2;
    if (localCopyable2 == null)
    {
      WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramObject);
      localCopyable1 = localCopyable2;
      if (localWeakReference != null)
      {
        localCopyable2 = (Copyable)localWeakReference.get();
        localCopyable1 = localCopyable2;
        if (localCopyable2 != null)
        {
          SLog.b("OneObjectCacheList", String.format("revert key %s from second cache", new Object[] { paramObject }));
          a(paramObject, localCopyable2);
          localCopyable1 = localCopyable2;
        }
      }
    }
    return localCopyable1;
  }
  
  public Copyable a(Object paramObject, Copyable paramCopyable)
  {
    Copyable localCopyable = a(paramObject);
    if (localCopyable == null)
    {
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramObject, paramCopyable);
      return paramCopyable;
    }
    localCopyable.copy(paramCopyable);
    return localCopyable;
  }
  
  public void a()
  {
    int i = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size();
    if (i - this.jdField_a_of_type_Int > 50)
    {
      b();
      this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size();
      SLog.a("OneObjectCacheList", "evict second cache data count:%d", Integer.valueOf(i - this.jdField_a_of_type_Int));
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.trimToSize(paramInt);
  }
  
  public void a(Object paramObject)
  {
    Copyable localCopyable = (Copyable)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(paramObject);
    if (localCopyable != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramObject, new WeakReference(localCopyable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.OneObjectCacheList
 * JD-Core Version:    0.7.0.1
 */