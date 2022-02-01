package com.tencent.biz.qqcircle.richframework.util.preloadview;

import android.util.LruCache;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class RFPreloadContextHelper
{
  private WeakReference<RFAsyncLayoutInflater> a;
  private LruCache<Integer, CopyOnWriteArrayList<View>> b;
  private ConcurrentHashMap<Integer, CopyOnWriteArrayList<WeakReference<LayoutPreLoader.RequestPreloadViewListener>>> c;
  
  public RFAsyncLayoutInflater a()
  {
    WeakReference localWeakReference = this.a;
    if (localWeakReference == null) {
      return null;
    }
    return (RFAsyncLayoutInflater)localWeakReference.get();
  }
  
  public void a(LruCache<Integer, CopyOnWriteArrayList<View>> paramLruCache)
  {
    this.b = paramLruCache;
  }
  
  public void a(RFAsyncLayoutInflater paramRFAsyncLayoutInflater)
  {
    this.a = new WeakReference(paramRFAsyncLayoutInflater);
  }
  
  public void a(ConcurrentHashMap<Integer, CopyOnWriteArrayList<WeakReference<LayoutPreLoader.RequestPreloadViewListener>>> paramConcurrentHashMap)
  {
    this.c = paramConcurrentHashMap;
  }
  
  public LruCache<Integer, CopyOnWriteArrayList<View>> b()
  {
    return this.b;
  }
  
  public ConcurrentHashMap<Integer, CopyOnWriteArrayList<WeakReference<LayoutPreLoader.RequestPreloadViewListener>>> c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.util.preloadview.RFPreloadContextHelper
 * JD-Core Version:    0.7.0.1
 */