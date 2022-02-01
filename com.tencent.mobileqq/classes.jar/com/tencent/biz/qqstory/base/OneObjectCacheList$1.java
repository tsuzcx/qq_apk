package com.tencent.biz.qqstory.base;

import android.support.v4.util.LruCache;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

class OneObjectCacheList$1
  extends LruCache<KEY, VALUE>
{
  OneObjectCacheList$1(OneObjectCacheList paramOneObjectCacheList, int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, KEY paramKEY, VALUE paramVALUE1, VALUE paramVALUE2)
  {
    this.a.b.put(paramKEY, new WeakReference(paramVALUE1));
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.OneObjectCacheList.1
 * JD-Core Version:    0.7.0.1
 */