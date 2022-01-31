package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.ReportWatchVideoEntry;
import com.tencent.biz.qqstory.network.handler.WatchVideoBatchHandler;
import com.tencent.biz.qqstory.network.request.WatchVideoBatchRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ReportWatchVideoManager
  implements IManager
{
  private final LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  private void e()
  {
    Object localObject = QQStoryContext.a().a().createEntityManager().a(ReportWatchVideoEntry.class, ReportWatchVideoEntry.class.getSimpleName(), false, null, null, null, null, null, null);
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ReportWatchVideoEntry localReportWatchVideoEntry = (ReportWatchVideoEntry)((Iterator)localObject).next();
        ReportWatchVideoManager.InnerVideoItem localInnerVideoItem = new ReportWatchVideoManager.InnerVideoItem();
        localInnerVideoItem.a(localReportWatchVideoEntry);
        this.jdField_a_of_type_JavaUtilLinkedList.add(localInnerVideoItem);
      }
    }
  }
  
  private void f()
  {
    ArrayList localArrayList = new ArrayList();
    long l = System.currentTimeMillis();
    Object localObject = new ArrayList(this.jdField_a_of_type_JavaUtilLinkedList.size());
    ((ArrayList)localObject).addAll(this.jdField_a_of_type_JavaUtilLinkedList);
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ReportWatchVideoManager.InnerVideoItem localInnerVideoItem = (ReportWatchVideoManager.InnerVideoItem)((Iterator)localObject).next();
      if (localInnerVideoItem.jdField_a_of_type_Long < l - 86400000L)
      {
        this.jdField_a_of_type_JavaUtilLinkedList.remove(localInnerVideoItem);
        localArrayList.add(localInnerVideoItem);
      }
    }
    a(localArrayList);
  }
  
  private void g()
  {
    Object localObject = new ArrayList(WatchVideoBatchHandler.a);
    int i = 0;
    while ((this.jdField_a_of_type_JavaUtilLinkedList.size() > 0) && (i < WatchVideoBatchHandler.a))
    {
      ((ArrayList)localObject).add(this.jdField_a_of_type_JavaUtilLinkedList.removeFirst());
      i += 1;
    }
    if (((ArrayList)localObject).size() > 0)
    {
      localObject = new WatchVideoBatchHandler().a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet(), (ArrayList)localObject);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(((WatchVideoBatchRequest)localObject).c), localObject);
    }
  }
  
  public void a() {}
  
  public void a(ReportWatchVideoManager.InnerVideoItem paramInnerVideoItem, boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(paramInnerVideoItem))
      {
        this.jdField_a_of_type_JavaUtilLinkedList.add(paramInnerVideoItem);
        SLog.d("Q.qqstory:ReportWatchVideoManager", String.format("saveWatchVid vid=%s, videoUid=%s, list size=%d", new Object[] { paramInnerVideoItem.jdField_a_of_type_JavaLangString, paramInnerVideoItem.b, Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedList.size()) }));
      }
      if (paramBoolean) {
        QQStoryContext.a().a().createEntityManager().b(paramInnerVideoItem.a());
      }
      return;
    }
  }
  
  public void a(@NonNull WatchVideoBatchRequest paramWatchVideoBatchRequest)
  {
    try
    {
      SLog.d("Q.qqstory:ReportWatchVideoManager", "handleResponse. requestHashMap.size()=" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramWatchVideoBatchRequest.c));
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
        {
          paramWatchVideoBatchRequest = new ReportWatchVideoManager.WatchVideoBatchFinishEvent();
          Dispatchers.get().dispatch(paramWatchVideoBatchRequest);
        }
      }
      return;
    }
    finally
    {
      paramWatchVideoBatchRequest = finally;
      throw paramWatchVideoBatchRequest;
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    a(new ReportWatchVideoManager.InnerVideoItem(paramString1, paramString2, paramBoolean1, paramLong, paramInt1, paramInt2), paramBoolean2);
  }
  
  public boolean a(List paramList)
  {
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    EntityTransaction localEntityTransaction = localEntityManager.a();
    try
    {
      localEntityTransaction.a();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ReportWatchVideoManager.InnerVideoItem localInnerVideoItem = (ReportWatchVideoManager.InnerVideoItem)paramList.next();
        ReportWatchVideoEntry localReportWatchVideoEntry = new ReportWatchVideoEntry();
        localReportWatchVideoEntry.setStatus(1001);
        localEntityManager.a(localReportWatchVideoEntry, "vid=?", new String[] { localInnerVideoItem.jdField_a_of_type_JavaLangString });
      }
    }
    finally
    {
      localEntityTransaction.b();
    }
    localEntityTransaction.b();
    return false;
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      return;
    }
  }
  
  public void c()
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
      {
        e();
        SLog.d("Q.qqstory:ReportWatchVideoManager", String.format("init. reportWatchVideoList.size=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedList.size()) }));
      }
      f();
      SLog.d("Q.qqstory:ReportWatchVideoManager", String.format("startSendRequests. data size=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedList.size()) }));
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() <= 0)
      {
        ReportWatchVideoManager.WatchVideoBatchFinishEvent localWatchVideoBatchFinishEvent = new ReportWatchVideoManager.WatchVideoBatchFinishEvent();
        Dispatchers.get().dispatch(localWatchVideoBatchFinishEvent);
        return;
      }
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0) {
        g();
      }
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.ReportWatchVideoManager
 * JD-Core Version:    0.7.0.1
 */