package com.tencent.biz.qqstory.base;

import android.support.v4.util.LruCache;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class OneObjectCacheList<KEY, VALUE extends Copyable>
{
  public int a;
  public LruCache<KEY, VALUE> a;
  public ConcurrentHashMap<KEY, WeakReference<VALUE>> a;
  
  public OneObjectCacheList(int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(50);
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new OneObjectCacheList.1(this, paramInt);
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
  
  public VALUE a(KEY paramKEY)
  {
    Copyable localCopyable2 = (Copyable)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramKEY);
    Copyable localCopyable1 = localCopyable2;
    if (localCopyable2 == null)
    {
      WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramKEY);
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
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramKEY, paramVALUE);
      return paramVALUE;
    }
    localCopyable.copy(paramVALUE);
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
  
  public void a(KEY paramKEY)
  {
    Copyable localCopyable = (Copyable)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(paramKEY);
    if (localCopyable != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramKEY, new WeakReference(localCopyable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.OneObjectCacheList
 * JD-Core Version:    0.7.0.1
 */