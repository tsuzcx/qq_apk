package com.tencent.biz.pubaccount.readinjoy.handlers;

import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.biz.pubaccount.readinjoyAd.ad.handlers.AdHandler;
import com.tencent.qphone.base.util.QLog;

public class HandlerFactory
{
  public static final int[] a = { 0, 1, 2, 3, 4 };
  
  public static SparseArray<BaseHandler> a(ReadInJoyBaseListViewGroup paramReadInJoyBaseListViewGroup)
  {
    SparseArray localSparseArray = new SparseArray();
    int i = 0;
    if (i < a.length)
    {
      int j = a[i];
      BaseHandler localBaseHandler = a(j);
      if (localBaseHandler == null) {
        QLog.d("HandlerFactory", 2, new Object[] { "create handler fail, id : ", Integer.valueOf(j) });
      }
      for (;;)
      {
        i += 1;
        break;
        localBaseHandler.a(paramReadInJoyBaseListViewGroup);
        localSparseArray.put(j, localBaseHandler);
      }
    }
    return localSparseArray;
  }
  
  public static BaseHandler a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new AdHandler();
    case 2: 
      return new FrameworkHandler();
    case 0: 
      return new VideoHandler();
    case 3: 
      return new DailyHandler();
    }
    return new ViolaHandler();
  }
  
  public static Object a(SparseArray<BaseHandler> paramSparseArray, HandlerTask paramHandlerTask)
  {
    if (paramHandlerTask == null) {
      return null;
    }
    int i = 0;
    Object localObject2;
    for (Object localObject1 = null; i < paramSparseArray.size(); localObject1 = localObject2)
    {
      SystemClock.currentThreadTimeMillis();
      paramHandlerTask.a((BaseHandler)paramSparseArray.valueAt(i));
      localObject2 = localObject1;
      if (paramHandlerTask.a != null)
      {
        if (localObject1 != null) {
          break;
        }
        localObject2 = paramHandlerTask.a;
        ((BaseHandler)paramSparseArray.valueAt(i)).a();
        paramHandlerTask.a = null;
      }
      SystemClock.currentThreadTimeMillis();
      i += 1;
    }
    return localObject1;
  }
  
  public static void a(SparseArray<BaseHandler> paramSparseArray, HandlerTask paramHandlerTask)
  {
    if (paramHandlerTask == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramSparseArray.size())
      {
        SystemClock.currentThreadTimeMillis();
        paramHandlerTask.a((BaseHandler)paramSparseArray.valueAt(i));
        SystemClock.currentThreadTimeMillis();
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.HandlerFactory
 * JD-Core Version:    0.7.0.1
 */