package com.tencent.biz.qqcircle.richframework.outbox;

import com.tencent.biz.qqcircle.publish.common.Singleton;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.utils.NetworkState;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class QCircleOutboxTaskManager
{
  private static int a = 5;
  private static final Singleton<QCircleOutboxTaskManager, Void> e = new QCircleOutboxTaskManager.1();
  private CopyOnWriteArrayList<QCircleOutboxTask> b = new CopyOnWriteArrayList();
  private QCircleOutboxTaskCacheManager c = new QCircleOutboxTaskCacheManager("QCircleOutboxTaskCacheManager_outbox_queue");
  private volatile boolean d = false;
  
  public static QCircleOutboxTaskManager a()
  {
    return (QCircleOutboxTaskManager)e.b(null);
  }
  
  private void e(QCircleOutboxTask paramQCircleOutboxTask)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramQCircleOutboxTask.i());
    ((StringBuilder)localObject1).append("");
    localObject1 = QCircleReportHelper.newEntry("ret_code", ((StringBuilder)localObject1).toString());
    FeedCloudCommon.Entry localEntry = QCircleReportHelper.newEntry("url", paramQCircleOutboxTask.j());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramQCircleOutboxTask.n());
    ((StringBuilder)localObject2).append("");
    localObject2 = QCircleReportHelper.newEntry("refer", ((StringBuilder)localObject2).toString());
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(paramQCircleOutboxTask.l());
    ((StringBuilder)localObject3).append("");
    localObject3 = QCircleReportHelper.newEntry("count", ((StringBuilder)localObject3).toString());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramQCircleOutboxTask.a());
    localStringBuilder.append("_");
    localStringBuilder.append(Arrays.toString(paramQCircleOutboxTask.m()));
    localStringBuilder.append("_");
    localStringBuilder.append(paramQCircleOutboxTask.i());
    localStringBuilder.append("_");
    localStringBuilder.append(paramQCircleOutboxTask.j());
    localStringBuilder.append("_state=");
    localStringBuilder.append(paramQCircleOutboxTask.b());
    QCircleQualityReporter.reportQualityEvent("outbox_task_resend_event_final", Arrays.asList(new FeedCloudCommon.Entry[] { localObject1, localEntry, localObject2, localObject3, QCircleReportHelper.newEntry("attach_info", localStringBuilder.toString()) }), false);
  }
  
  public boolean a(QCircleOutboxTask paramQCircleOutboxTask)
  {
    if ((paramQCircleOutboxTask != null) && (!this.b.contains(paramQCircleOutboxTask)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addTask id:");
      localStringBuilder.append(paramQCircleOutboxTask.a());
      QLog.i("QCircleOutboxTaskManager", 1, localStringBuilder.toString());
      this.b.add(paramQCircleOutboxTask);
      this.c.a(paramQCircleOutboxTask);
      return true;
    }
    QLog.w("QCircleOutboxTaskManager", 1, "addTask error");
    return false;
  }
  
  public boolean a(QCircleOutboxTask paramQCircleOutboxTask, boolean paramBoolean)
  {
    if ((paramQCircleOutboxTask != null) && (this.b.contains(paramQCircleOutboxTask)))
    {
      if (paramBoolean)
      {
        paramQCircleOutboxTask.a(3);
        this.b.remove(paramQCircleOutboxTask);
        this.c.c(paramQCircleOutboxTask);
        e(paramQCircleOutboxTask);
      }
      else
      {
        paramQCircleOutboxTask.a(2);
        this.c.b(paramQCircleOutboxTask);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("completeTask id:");
      localStringBuilder.append(paramQCircleOutboxTask.a());
      localStringBuilder.append(", succeed:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", resultCode:");
      localStringBuilder.append(paramQCircleOutboxTask.i());
      localStringBuilder.append(", resultMsg:");
      localStringBuilder.append(paramQCircleOutboxTask.j());
      QLog.i("QCircleOutboxTaskManager", 1, localStringBuilder.toString());
      return true;
    }
    QLog.w("QCircleOutboxTaskManager", 1, "completeTask error");
    return false;
  }
  
  public boolean b()
  {
    int i = g();
    boolean bool2 = NetworkState.isNetSupport();
    boolean bool3 = false;
    boolean bool1 = true;
    if (!bool2)
    {
      if (i <= 0) {
        bool1 = false;
      }
      this.d = bool1;
      return false;
    }
    int k = QCircleConfigHelper.a("qqcircle", "qqcircle_max_parallel_task_count", Integer.valueOf(a)).intValue();
    int j;
    if (i <= k)
    {
      Iterator localIterator = this.b.iterator();
      bool2 = false;
      do
      {
        QCircleOutboxTask localQCircleOutboxTask;
        do
        {
          j = i;
          bool1 = bool2;
          if (!localIterator.hasNext()) {
            break;
          }
          localQCircleOutboxTask = (QCircleOutboxTask)localIterator.next();
        } while (localQCircleOutboxTask == null);
        j = i;
        bool1 = bool2;
        if (localQCircleOutboxTask.b() == 2)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("runTask id:");
          localStringBuilder.append(localQCircleOutboxTask.a());
          QLog.i("QCircleOutboxTaskManager", 1, localStringBuilder.toString());
          j = i + 1;
          localQCircleOutboxTask.a(1);
          localQCircleOutboxTask.p();
          bool1 = true;
        }
        i = j;
        bool2 = bool1;
      } while (j != k);
    }
    else
    {
      bool1 = false;
      j = i;
    }
    bool2 = bool3;
    if (j > 0) {
      bool2 = true;
    }
    this.d = bool2;
    return bool1;
  }
  
  public boolean b(QCircleOutboxTask paramQCircleOutboxTask)
  {
    if ((paramQCircleOutboxTask != null) && (this.b.contains(paramQCircleOutboxTask)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resumeTask id:");
      localStringBuilder.append(paramQCircleOutboxTask.a());
      localStringBuilder.append(", current state:");
      localStringBuilder.append(paramQCircleOutboxTask.b());
      QLog.i("QCircleOutboxTaskManager", 1, localStringBuilder.toString());
      paramQCircleOutboxTask.d();
      return true;
    }
    QLog.w("QCircleOutboxTaskManager", 1, "resumeTask error");
    return false;
  }
  
  public boolean c()
  {
    boolean bool2 = this.b.isEmpty();
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    Object localObject = this.c.a();
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      Iterator localIterator = ((ArrayList)localObject).iterator();
      while (localIterator.hasNext())
      {
        QCircleOutboxTask localQCircleOutboxTask = (QCircleOutboxTask)localIterator.next();
        localQCircleOutboxTask.a("QCircleOutboxTaskManager", "restore");
        if (localQCircleOutboxTask.b() != 1) {
          localQCircleOutboxTask.e();
        }
      }
      this.b.clear();
      this.b.addAll((Collection)localObject);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("restore total size:");
    ((StringBuilder)localObject).append(this.b.size());
    QLog.i("QCircleOutboxTaskManager", 1, ((StringBuilder)localObject).toString());
    if (this.b.size() > 0) {
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean c(QCircleOutboxTask paramQCircleOutboxTask)
  {
    if ((paramQCircleOutboxTask != null) && (this.b.contains(paramQCircleOutboxTask)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeTask id:");
      localStringBuilder.append(paramQCircleOutboxTask.a());
      QLog.i("QCircleOutboxTaskManager", 1, localStringBuilder.toString());
      paramQCircleOutboxTask.a(4);
      paramQCircleOutboxTask.c();
      this.b.remove(paramQCircleOutboxTask);
      this.c.c(paramQCircleOutboxTask);
      return true;
    }
    QLog.w("QCircleOutboxTaskManager", 1, "removeTask error");
    return false;
  }
  
  public void d()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reset total size:");
    ((StringBuilder)localObject).append(this.b.size());
    QLog.i("QCircleOutboxTaskManager", 1, ((StringBuilder)localObject).toString());
    if (this.b.size() > 0)
    {
      localObject = this.b.iterator();
      while (((Iterator)localObject).hasNext())
      {
        QCircleOutboxTask localQCircleOutboxTask = (QCircleOutboxTask)((Iterator)localObject).next();
        if (localQCircleOutboxTask != null) {
          localQCircleOutboxTask.f();
        }
      }
    }
    this.b.clear();
    e.a();
  }
  
  public boolean d(QCircleOutboxTask paramQCircleOutboxTask)
  {
    return this.b.contains(paramQCircleOutboxTask);
  }
  
  public CopyOnWriteArrayList<QCircleOutboxTask> e()
  {
    return (CopyOnWriteArrayList)this.b.clone();
  }
  
  public int f()
  {
    return this.b.size();
  }
  
  public int g()
  {
    boolean bool = this.b.isEmpty();
    int i = 0;
    if (bool) {
      return 0;
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      QCircleOutboxTask localQCircleOutboxTask = (QCircleOutboxTask)localIterator.next();
      if ((localQCircleOutboxTask != null) && (localQCircleOutboxTask.b() == 1)) {
        if (System.currentTimeMillis() - localQCircleOutboxTask.h() < 60000L)
        {
          i += 1;
        }
        else
        {
          localQCircleOutboxTask.a(2);
          localQCircleOutboxTask.a("QCircleOutboxTaskManager", "getRunningTaskCount resend timeout!", true);
        }
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.outbox.QCircleOutboxTaskManager
 * JD-Core Version:    0.7.0.1
 */