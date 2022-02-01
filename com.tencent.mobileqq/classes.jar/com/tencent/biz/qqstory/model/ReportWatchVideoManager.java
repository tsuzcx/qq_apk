package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.database.ReportWatchVideoEntry;
import com.tencent.biz.qqstory.network.handler.WatchVideoBatchHandler;
import com.tencent.biz.qqstory.network.request.WatchVideoBatchRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tribe.async.dispatch.Dispatcher;
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
  private final LinkedList<ReportWatchVideoManager.InnerVideoItem> a = new LinkedList();
  private AtomicInteger b = new AtomicInteger(0);
  private ConcurrentHashMap<Integer, WatchVideoBatchRequest> c = new ConcurrentHashMap();
  private AtomicBoolean d = new AtomicBoolean(false);
  
  private void e()
  {
    Object localObject = QQStoryContext.a().d().createEntityManager().query(ReportWatchVideoEntry.class, ReportWatchVideoEntry.class.getSimpleName(), false, null, null, null, null, null, null);
    if (localObject == null) {
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ReportWatchVideoEntry localReportWatchVideoEntry = (ReportWatchVideoEntry)((Iterator)localObject).next();
      ReportWatchVideoManager.InnerVideoItem localInnerVideoItem = new ReportWatchVideoManager.InnerVideoItem();
      localInnerVideoItem.a(localReportWatchVideoEntry);
      this.a.add(localInnerVideoItem);
    }
  }
  
  private void f()
  {
    ArrayList localArrayList = new ArrayList();
    long l = System.currentTimeMillis();
    Object localObject = new ArrayList(this.a.size());
    ((ArrayList)localObject).addAll(this.a);
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ReportWatchVideoManager.InnerVideoItem localInnerVideoItem = (ReportWatchVideoManager.InnerVideoItem)((Iterator)localObject).next();
      if (localInnerVideoItem.d < l - 86400000L)
      {
        this.a.remove(localInnerVideoItem);
        localArrayList.add(localInnerVideoItem);
      }
    }
    a(localArrayList);
  }
  
  private void g()
  {
    Object localObject = new ArrayList(WatchVideoBatchHandler.g);
    int i = 0;
    while ((this.a.size() > 0) && (i < WatchVideoBatchHandler.g))
    {
      ((ArrayList)localObject).add(this.a.removeFirst());
      i += 1;
    }
    if (((ArrayList)localObject).size() > 0)
    {
      localObject = new WatchVideoBatchHandler().a(this.b.incrementAndGet(), (ArrayList)localObject);
      this.c.put(Integer.valueOf(((WatchVideoBatchRequest)localObject).f), localObject);
    }
  }
  
  public void a() {}
  
  public void a(ReportWatchVideoManager.InnerVideoItem paramInnerVideoItem, boolean paramBoolean)
  {
    synchronized (this.a)
    {
      if (!this.a.contains(paramInnerVideoItem))
      {
        this.a.add(paramInnerVideoItem);
        SLog.d("Q.qqstory:ReportWatchVideoManager", String.format("saveWatchVid vid=%s, videoUid=%s, list size=%d", new Object[] { paramInnerVideoItem.a, paramInnerVideoItem.b, Integer.valueOf(this.a.size()) }));
      }
      if (paramBoolean) {
        QQStoryContext.a().d().createEntityManager().persistOrReplace(paramInnerVideoItem.a());
      }
      return;
    }
  }
  
  public void a(@NonNull WatchVideoBatchRequest paramWatchVideoBatchRequest)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleResponse. requestHashMap.size()=");
      localStringBuilder.append(this.c.size());
      SLog.d("Q.qqstory:ReportWatchVideoManager", localStringBuilder.toString());
      if (this.c.size() > 0)
      {
        this.c.remove(Integer.valueOf(paramWatchVideoBatchRequest.f));
        if (this.c.isEmpty())
        {
          paramWatchVideoBatchRequest = new ReportWatchVideoManager.WatchVideoBatchFinishEvent();
          StoryDispatcher.a().dispatch(paramWatchVideoBatchRequest);
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
  
  public boolean a(List<ReportWatchVideoManager.InnerVideoItem> paramList)
  {
    EntityManager localEntityManager = QQStoryContext.a().d().createEntityManager();
    EntityTransaction localEntityTransaction = localEntityManager.getTransaction();
    try
    {
      localEntityTransaction.begin();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ReportWatchVideoManager.InnerVideoItem localInnerVideoItem = (ReportWatchVideoManager.InnerVideoItem)paramList.next();
        ReportWatchVideoEntry localReportWatchVideoEntry = new ReportWatchVideoEntry();
        localReportWatchVideoEntry.setStatus(1001);
        localEntityManager.remove(localReportWatchVideoEntry, "vid=?", new String[] { localInnerVideoItem.a });
      }
      localEntityTransaction.commit();
      localEntityTransaction.end();
      return false;
    }
    finally
    {
      localEntityTransaction.end();
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void b()
  {
    synchronized (this.a)
    {
      this.a.clear();
      this.c.clear();
      return;
    }
  }
  
  public void c()
  {
    synchronized (this.a)
    {
      if (this.d.compareAndSet(false, true))
      {
        e();
        SLog.d("Q.qqstory:ReportWatchVideoManager", String.format("init. reportWatchVideoList.size=%d", new Object[] { Integer.valueOf(this.a.size()) }));
      }
      f();
      SLog.d("Q.qqstory:ReportWatchVideoManager", String.format("startSendRequests. data size=%d", new Object[] { Integer.valueOf(this.a.size()) }));
      if (this.a.size() <= 0)
      {
        ReportWatchVideoManager.WatchVideoBatchFinishEvent localWatchVideoBatchFinishEvent = new ReportWatchVideoManager.WatchVideoBatchFinishEvent();
        StoryDispatcher.a().dispatch(localWatchVideoBatchFinishEvent);
        return;
      }
      while (this.a.size() > 0) {
        g();
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void d()
  {
    this.c.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.ReportWatchVideoManager
 * JD-Core Version:    0.7.0.1
 */