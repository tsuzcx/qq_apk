package com.tencent.biz.qqcircle.publish.queue;

import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneHelper;
import com.tencent.biz.qqcircle.publish.account.LoginData;
import com.tencent.biz.qqcircle.publish.db.queue.QueueTaskCacheData;
import com.tencent.biz.qqcircle.publish.task.IQueueTask;
import com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class QCircleTaskCacheManager
{
  private String a = "publish_queue";
  private final QCircleTaskCacheManager.CacheHolder b = new QCircleTaskCacheManager.CacheHolder();
  
  public QCircleTaskCacheManager()
  {
    this("publish_queue");
  }
  
  public QCircleTaskCacheManager(String paramString)
  {
    this.a = paramString;
  }
  
  private void a(QCircleTaskCacheManager.CacheHolder paramCacheHolder)
  {
    if (paramCacheHolder == null) {
      return;
    }
    long l = LoginData.a().b();
    if ((l != paramCacheHolder.a) || (paramCacheHolder.b == null) || (paramCacheHolder.b.isClosed()))
    {
      paramCacheHolder.a = l;
      paramCacheHolder.b = QCircleHostQzoneHelper.getCacheManager(QueueTaskCacheData.class, l, this.a);
      paramCacheHolder.b.addCloseListener(paramCacheHolder.c);
    }
  }
  
  public ArrayList<IQueueTask> a()
  {
    a(this.b);
    ArrayList localArrayList2 = this.b.b.queryData();
    if (localArrayList2 != null)
    {
      ArrayList localArrayList1 = new ArrayList();
      int j = localArrayList2.size();
      int i = 0;
      for (;;)
      {
        localObject1 = localArrayList1;
        if (i >= j) {
          break;
        }
        Object localObject2 = (QueueTaskCacheData)localArrayList2.get(i);
        if ((localObject2 != null) && (((QueueTaskCacheData)localObject2).getQueueTask() != null))
        {
          localObject1 = ((QueueTaskCacheData)localObject2).getQueueTask();
          if (!((IQueueTask)localObject1).t())
          {
            if (((IQueueTask)localObject1).bn_() != 3)
            {
              if (((IQueueTask)localObject1).bn_() != 6) {
                ((IQueueTask)localObject1).b(2);
              }
              localArrayList1.add(((QueueTaskCacheData)localObject2).getQueueTask());
            }
            else
            {
              c((IQueueTask)localObject1);
            }
          }
          else
          {
            c((IQueueTask)localObject1);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("remove null task, id:");
            ((StringBuilder)localObject2).append(((IQueueTask)localObject1).c());
            QLog.w("[upload2_QzoneTaskCacheManager]", 1, ((StringBuilder)localObject2).toString());
          }
        }
        i += 1;
      }
    }
    Object localObject1 = null;
    return localObject1;
  }
  
  public void a(IQueueTask paramIQueueTask)
  {
    if (!paramIQueueTask.t())
    {
      a(this.b);
      this.b.b.saveData(new QueueTaskCacheData(paramIQueueTask), 1);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("save null task, id:");
    localStringBuilder.append(paramIQueueTask.c());
    QLog.w("[upload2_QzoneTaskCacheManager]", 1, localStringBuilder.toString());
  }
  
  public void b(IQueueTask paramIQueueTask)
  {
    a(this.b);
    this.b.b.updateData(new QueueTaskCacheData(paramIQueueTask), "client_key=?", new String[] { paramIQueueTask.i() });
  }
  
  public void c(IQueueTask paramIQueueTask)
  {
    a(this.b);
    this.b.b.deleteData("client_key=?", new String[] { paramIQueueTask.i() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.queue.QCircleTaskCacheManager
 * JD-Core Version:    0.7.0.1
 */