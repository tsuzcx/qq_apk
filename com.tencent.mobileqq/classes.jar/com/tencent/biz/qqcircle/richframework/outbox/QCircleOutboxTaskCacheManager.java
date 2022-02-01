package com.tencent.biz.qqcircle.richframework.outbox;

import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneHelper;
import com.tencent.biz.qqcircle.publish.account.LoginData;
import com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class QCircleOutboxTaskCacheManager
{
  private String a = "sender_queue";
  private final QCircleOutboxTaskCacheManager.CacheHolder b = new QCircleOutboxTaskCacheManager.CacheHolder();
  
  public QCircleOutboxTaskCacheManager()
  {
    this("sender_queue");
  }
  
  public QCircleOutboxTaskCacheManager(String paramString)
  {
    this.a = paramString;
  }
  
  private void a(QCircleOutboxTaskCacheManager.CacheHolder paramCacheHolder)
  {
    if (paramCacheHolder == null) {
      return;
    }
    long l = LoginData.a().b();
    if ((l != paramCacheHolder.a) || (paramCacheHolder.b == null) || (paramCacheHolder.b.isClosed()))
    {
      paramCacheHolder.a = l;
      paramCacheHolder.b = QCircleHostQzoneHelper.getCacheManager(QCircleOutboxCacheData.class, l, this.a);
      paramCacheHolder.b.addCloseListener(paramCacheHolder.c);
    }
  }
  
  public ArrayList<QCircleOutboxTask> a()
  {
    try
    {
      a(this.b);
      ArrayList localArrayList1 = new ArrayList();
      try
      {
        ArrayList localArrayList2 = this.b.b.queryData();
        Object localObject2;
        if (localArrayList2 != null)
        {
          int j = localArrayList2.size();
          int i = 0;
          while (i < j)
          {
            Object localObject3 = (QCircleOutboxCacheData)localArrayList2.get(i);
            if ((localObject3 != null) && (((QCircleOutboxCacheData)localObject3).getQueueTask() != null))
            {
              localObject2 = ((QCircleOutboxCacheData)localObject3).getQueueTask();
              if (!((QCircleOutboxTask)localObject2).k())
              {
                ((QCircleOutboxTask)localObject2).a("QCircleOutboxTaskCacheManager", "restoreTask");
                ((QCircleOutboxTask)localObject2).a(2);
                localArrayList1.add(((QCircleOutboxCacheData)localObject3).getQueueTask());
              }
              else
              {
                c((QCircleOutboxTask)localObject2);
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("remove null task, id:");
                ((StringBuilder)localObject3).append(((QCircleOutboxTask)localObject2).a());
                QLog.w("QCircleOutboxTaskCacheManager", 1, ((StringBuilder)localObject3).toString());
              }
            }
            i += 1;
          }
        }
        localObject1 = finally;
      }
      catch (Exception localException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("restoreTasks exception :");
        ((StringBuilder)localObject2).append(localException.toString());
        QLog.e("QCircleOutboxTaskCacheManager", 1, ((StringBuilder)localObject2).toString());
        return localArrayList1;
      }
      throw localObject1;
    }
    finally {}
    for (;;) {}
  }
  
  public void a(QCircleOutboxTask paramQCircleOutboxTask)
  {
    try
    {
      if (!paramQCircleOutboxTask.k())
      {
        a(this.b);
        this.b.b.saveData(new QCircleOutboxCacheData(paramQCircleOutboxTask), 1);
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("save null task, id:");
        localStringBuilder.append(paramQCircleOutboxTask.a());
        QLog.w("QCircleOutboxTaskCacheManager", 1, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  public void b(QCircleOutboxTask paramQCircleOutboxTask)
  {
    try
    {
      a(this.b);
      this.b.b.updateData(new QCircleOutboxCacheData(paramQCircleOutboxTask), "cache_key=?", new String[] { paramQCircleOutboxTask.g() });
      return;
    }
    finally {}
  }
  
  public void c(QCircleOutboxTask paramQCircleOutboxTask)
  {
    try
    {
      a(this.b);
      this.b.b.deleteData("cache_key=?", new String[] { paramQCircleOutboxTask.g() });
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.outbox.QCircleOutboxTaskCacheManager
 * JD-Core Version:    0.7.0.1
 */