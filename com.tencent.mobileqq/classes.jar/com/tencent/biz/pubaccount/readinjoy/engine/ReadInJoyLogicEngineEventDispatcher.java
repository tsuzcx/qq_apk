package com.tencent.biz.pubaccount.readinjoy.engine;

import android.util.SparseArray;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.KingMomentInfo;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyTabObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadInJoyLogicEngineEventDispatcher
{
  private static ReadInJoyLogicEngineEventDispatcher jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngineEventDispatcher;
  private final ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public static ReadInJoyLogicEngineEventDispatcher a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngineEventDispatcher == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngineEventDispatcher = new ReadInJoyLogicEngineEventDispatcher();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngineEventDispatcher;
    }
    finally {}
  }
  
  public void a()
  {
    ??? = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    ReadInJoyObserver localReadInJoyObserver;
    do
    {
      if (!((Iterator)???).hasNext()) {
        break;
      }
      localReadInJoyObserver = (ReadInJoyObserver)((Iterator)???).next();
    } while (!(localReadInJoyObserver instanceof ReadInJoyTabObserver));
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        if (localReadInJoyObserver != null) {
          this.jdField_a_of_type_JavaUtilArrayList.add(localReadInJoyObserver);
        }
        return;
      }
      Object localObject2 = null;
    }
  }
  
  public void a(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).d(paramInt);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramInt1, paramInt2);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramInt1, paramInt2, paramInt3, paramBoolean);
      }
    }
  }
  
  public void a(int paramInt1, long paramLong, String paramString1, int paramInt2, String paramString2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramInt1, paramLong, paramString1, paramInt2, paramString2);
      }
    }
  }
  
  public void a(int paramInt, KingMomentInfo paramKingMomentInfo)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramInt, paramKingMomentInfo);
      }
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramInt, paramObject);
      }
    }
  }
  
  public void a(int paramInt, List paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramInt, paramList);
      }
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramLong, paramBoolean);
      }
    }
  }
  
  public void a(View paramView)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramView);
      }
    }
  }
  
  public void a(ReadInJoyObserver paramReadInJoyObserver)
  {
    if (paramReadInJoyObserver == null) {}
    while (this.jdField_a_of_type_JavaUtilArrayList.contains(paramReadInJoyObserver)) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramReadInJoyObserver);
      return;
    }
  }
  
  public void a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramString);
      }
    }
  }
  
  public void a(List paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).b(paramList);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, List paramList1, List paramList2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean, paramInt, paramLong, paramList1, paramList2);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, SparseArray paramSparseArray)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean, paramInt, paramSparseArray);
      }
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List paramList, boolean paramBoolean2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean1, paramInt, paramList, paramBoolean2);
      }
    }
  }
  
  public void a(boolean paramBoolean, List paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).c(paramBoolean, paramList);
      }
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).Z_();
      }
    }
  }
  
  public void b(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramInt);
      }
    }
  }
  
  public void b(int paramInt1, long paramLong, String paramString1, int paramInt2, String paramString2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).b(paramInt1, paramLong, paramString1, paramInt2, paramString2);
      }
    }
  }
  
  public void b(int paramInt, List paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).c(paramInt, paramList);
      }
    }
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).b(paramLong, paramBoolean);
      }
    }
  }
  
  public void b(ReadInJoyObserver paramReadInJoyObserver)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramReadInJoyObserver);
      return;
    }
  }
  
  public void b(List paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramList);
      }
    }
  }
  
  public void b(boolean paramBoolean1, int paramInt, List paramList, boolean paramBoolean2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).b(paramBoolean1, paramInt, paramList, paramBoolean2);
      }
    }
  }
  
  public void b(boolean paramBoolean, List paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).d(paramBoolean, paramList);
      }
    }
  }
  
  public void c()
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).c();
      }
    }
  }
  
  public void c(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).c(paramInt);
      }
    }
  }
  
  public void c(int paramInt, List paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).b(paramInt, paramList);
      }
    }
  }
  
  public void c(List paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).c(paramList);
      }
    }
  }
  
  public void c(boolean paramBoolean, List paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).e(paramBoolean, paramList);
      }
    }
  }
  
  public void d(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).b(paramInt);
      }
    }
  }
  
  public void d(boolean paramBoolean, List paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).f(paramBoolean, paramList);
      }
    }
  }
  
  public void e(boolean paramBoolean, List paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean, paramList);
      }
    }
  }
  
  public void f(boolean paramBoolean, List paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).b(paramBoolean, paramList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher
 * JD-Core Version:    0.7.0.1
 */