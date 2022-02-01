package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.text.TextUtils;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class UiElementFixedCache
{
  private static volatile UiElementFixedCache a;
  private static Object b = new Object();
  private SoftReference<ConcurrentHashMap<Integer, SoftReference<ArrayList<TextCell>>>> c;
  private SoftReference<ConcurrentHashMap<UiElementFixedCache.MeasuredTextInfo, SoftReference<UiElementFixedCache.MeasuredTextResult>>> d;
  
  public static UiElementFixedCache a()
  {
    if (a == null) {
      synchronized (b)
      {
        if (a == null) {
          a = new UiElementFixedCache();
        }
      }
    }
    return a;
  }
  
  private ConcurrentHashMap<UiElementFixedCache.MeasuredTextInfo, SoftReference<UiElementFixedCache.MeasuredTextResult>> b()
  {
    ??? = this.d;
    if (??? != null) {
      ??? = (ConcurrentHashMap)((SoftReference)???).get();
    } else {
      ??? = null;
    }
    if (??? == null) {
      synchronized (b)
      {
        if ((this.d == null) || (this.d.get() == null)) {
          this.d = new SoftReference(new ConcurrentHashMap());
        }
      }
    }
    return (ConcurrentHashMap)this.d.get();
  }
  
  private ConcurrentHashMap<Integer, SoftReference<ArrayList<TextCell>>> c()
  {
    Object localObject1 = this.c;
    if (localObject1 != null) {
      localObject1 = (ConcurrentHashMap)((SoftReference)localObject1).get();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new ConcurrentHashMap();
      this.c = new SoftReference(localObject2);
    }
    return localObject2;
  }
  
  public UiElementFixedCache.MeasuredTextResult a(int paramInt1, int paramInt2, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = new UiElementFixedCache.MeasuredTextInfo(paramInt1, paramInt2, paramString);
    ConcurrentHashMap localConcurrentHashMap = b();
    Object localObject = (SoftReference)localConcurrentHashMap.get(paramString);
    if (localObject != null)
    {
      localObject = (UiElementFixedCache.MeasuredTextResult)((SoftReference)localObject).get();
      if (localObject != null) {
        return ((UiElementFixedCache.MeasuredTextResult)localObject).a();
      }
      localConcurrentHashMap.remove(paramString);
    }
    return null;
  }
  
  public ArrayList<TextCell> a(int paramInt)
  {
    Object localObject = (SoftReference)c().get(Integer.valueOf(paramInt));
    if (localObject != null)
    {
      localObject = (ArrayList)((SoftReference)localObject).get();
      if (localObject == null) {
        c().remove(Integer.valueOf(paramInt));
      }
      return localObject;
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, UiElementFixedCache.MeasuredTextResult paramMeasuredTextResult)
  {
    paramString = new UiElementFixedCache.MeasuredTextInfo(paramInt1, paramInt2, paramString);
    b().put(paramString, new SoftReference(paramMeasuredTextResult));
  }
  
  public void a(int paramInt, ArrayList<TextCell> paramArrayList)
  {
    try
    {
      c().put(Integer.valueOf(paramInt), new SoftReference(paramArrayList));
      return;
    }
    finally
    {
      paramArrayList = finally;
      throw paramArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.UiElementFixedCache
 * JD-Core Version:    0.7.0.1
 */