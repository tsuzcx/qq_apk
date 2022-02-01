package com.huawei.updatesdk.service.d.a;

import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;

public class b
{
  private static List<AsyncTask> a = new CopyOnWriteArrayList();
  
  public static com.huawei.updatesdk.a.b.d.b a(com.huawei.updatesdk.service.a.c paramc, com.huawei.updatesdk.a.b.d.a.a parama)
  {
    parama = new com.huawei.updatesdk.a.b.d.b(paramc, parama);
    a(parama, paramc);
    return parama;
  }
  
  public static List<AsyncTask> a()
  {
    return a;
  }
  
  public static void a(AsyncTask paramAsyncTask)
  {
    if (paramAsyncTask == null) {
      return;
    }
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      AsyncTask localAsyncTask = (AsyncTask)localIterator.next();
      if ((localAsyncTask != null) && ((localAsyncTask.getStatus() == AsyncTask.Status.FINISHED) || (localAsyncTask.isCancelled()))) {
        a.remove(paramAsyncTask);
      }
    }
    a.add(paramAsyncTask);
  }
  
  private static void a(com.huawei.updatesdk.a.b.d.b paramb, com.huawei.updatesdk.service.a.c paramc)
  {
    com.huawei.updatesdk.a.a.b.a.a.a.a("StoreAgent", "executeTask, ActiveCount:" + c.a.getActiveCount() + ", TaskCount:" + c.a.getTaskCount());
    paramb.a(c.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.service.d.a.b
 * JD-Core Version:    0.7.0.1
 */