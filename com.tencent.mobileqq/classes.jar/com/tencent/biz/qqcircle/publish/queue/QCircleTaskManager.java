package com.tencent.biz.qqcircle.publish.queue;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.publish.common.QCircleBusinessLooper;
import com.tencent.biz.qqcircle.publish.common.Singleton;
import com.tencent.biz.qqcircle.publish.task.IQueueTask;
import com.tencent.biz.qqcircle.publish.task.QCircleTask;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.NetworkState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class QCircleTaskManager
{
  private static int a = 5;
  private static final Singleton<QCircleTaskManager, Void> e = new QCircleTaskManager.1();
  private CopyOnWriteArrayList<IQueueTask> b = new CopyOnWriteArrayList();
  private QCircleTaskCacheManager c = new QCircleTaskCacheManager("QCircleTaskManager_publish_queue");
  private volatile boolean d = false;
  
  public static QCircleTaskManager a()
  {
    return (QCircleTaskManager)e.b(null);
  }
  
  public IQueueTask a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    Iterator localIterator = this.b.iterator();
    Object localObject1;
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (IQueueTask)localIterator.next();
    } while (!paramString.equals(((IQueueTask)localObject1).i()));
    return localObject1;
  }
  
  public boolean a(IQueueTask paramIQueueTask)
  {
    if ((paramIQueueTask != null) && (!this.b.contains(paramIQueueTask)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addTask id:");
      localStringBuilder.append(paramIQueueTask.c());
      QLog.i("[upload2_QCircleTaskManager]", 1, localStringBuilder.toString());
      this.b.add(paramIQueueTask);
      this.c.a(paramIQueueTask);
      return true;
    }
    QLog.w("[upload2_QCircleTaskManager]", 1, "addTask error");
    return false;
  }
  
  public boolean a(IQueueTask paramIQueueTask, boolean paramBoolean)
  {
    if ((paramIQueueTask != null) && (this.b.contains(paramIQueueTask)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("completeTask id:");
      localStringBuilder.append(paramIQueueTask.c());
      localStringBuilder.append(", succeed:");
      localStringBuilder.append(paramBoolean);
      QLog.i("[upload2_QCircleTaskManager]", 1, localStringBuilder.toString());
      if (paramBoolean)
      {
        paramIQueueTask.b(3);
        this.b.remove(paramIQueueTask);
        this.c.c(paramIQueueTask);
        return true;
      }
      paramIQueueTask.b(2);
      this.c.b(paramIQueueTask);
      return true;
    }
    QLog.w("[upload2_QCircleTaskManager]", 1, "completeTask error");
    return false;
  }
  
  public boolean b()
  {
    int i = h();
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
    int k = QCircleConfigHelper.a("QZoneSetting", "MaxParallelTaskCount", Integer.valueOf(a)).intValue();
    int j;
    if (i <= k)
    {
      Iterator localIterator = this.b.iterator();
      bool2 = false;
      do
      {
        IQueueTask localIQueueTask;
        do
        {
          do
          {
            j = i;
            bool1 = bool2;
            if (!localIterator.hasNext()) {
              break;
            }
            localIQueueTask = (IQueueTask)localIterator.next();
          } while (localIQueueTask == null);
          if (localIQueueTask.bn_() != 0)
          {
            j = i;
            bool1 = bool2;
            if (localIQueueTask.bn_() != 6) {
              break;
            }
          }
        } while ((localIQueueTask.n()) && (f() > 0));
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("runTask id:");
        localStringBuilder.append(localIQueueTask.c());
        QLog.i("[upload2_QCircleTaskManager]", 1, localStringBuilder.toString());
        j = i + 1;
        localIQueueTask.b(1);
        QCircleBusinessLooper.a().a((QCircleTask)localIQueueTask);
        bool1 = true;
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
  
  public boolean b(IQueueTask paramIQueueTask)
  {
    if ((paramIQueueTask != null) && (this.b.contains(paramIQueueTask)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateTask id:");
      localStringBuilder.append(paramIQueueTask.c());
      QLog.i("[upload2_QCircleTaskManager]", 1, localStringBuilder.toString());
      this.c.b(paramIQueueTask);
      return true;
    }
    QLog.w("[upload2_QCircleTaskManager]", 1, "updateTask error");
    return false;
  }
  
  public boolean b(IQueueTask paramIQueueTask, boolean paramBoolean)
  {
    if ((paramIQueueTask != null) && (this.b.contains(paramIQueueTask)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("finishTask id:");
      localStringBuilder.append(paramIQueueTask.c());
      localStringBuilder.append(", succeed:");
      localStringBuilder.append(paramBoolean);
      QLog.i("[upload2_QCircleTaskManager]", 1, localStringBuilder.toString());
      if (paramBoolean) {
        paramIQueueTask.b(3);
      } else {
        paramIQueueTask.b(2);
      }
      this.c.b(paramIQueueTask);
      return true;
    }
    QLog.w("[upload2_QCircleTaskManager]", 1, "finishTask error");
    return false;
  }
  
  public boolean c()
  {
    QLog.d("[upload2_QCircleTaskManager]", 1, "restore...");
    Object localObject1 = new ArrayList();
    Object localObject2 = this.b.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (IQueueTask)((Iterator)localObject2).next();
      if (((IQueueTask)localObject3).bn_() == 3) {
        ((ArrayList)localObject1).add(localObject3);
      }
    }
    this.b.removeAll((Collection)localObject1);
    if (!this.b.isEmpty())
    {
      localObject1 = this.b.iterator();
      boolean bool = false;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (IQueueTask)((Iterator)localObject1).next();
        if (localObject2 == null)
        {
          QLog.w("[upload2_QCircleTaskManager]", 1, "restore... task is null");
        }
        else
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("restore... task state:");
          ((StringBuilder)localObject3).append(((IQueueTask)localObject2).bn_());
          QLog.d("[upload2_QCircleTaskManager]", 1, ((StringBuilder)localObject3).toString());
          if (((IQueueTask)localObject2).bn_() == 2) {
            bool = true;
          }
        }
      }
      QLog.d("[upload2_QCircleTaskManager]", 1, new Object[] { "restore... isNeedRestore:", Boolean.valueOf(bool) });
      return bool;
    }
    localObject1 = this.c.a();
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
    {
      localObject2 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (IQueueTask)((Iterator)localObject2).next();
        if ((localObject3 != null) && (((IQueueTask)localObject3).bn_() != 1))
        {
          ((IQueueTask)localObject3).f();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("restore task id:");
          localStringBuilder.append(((IQueueTask)localObject3).c());
          localStringBuilder.append(" state:");
          localStringBuilder.append(((IQueueTask)localObject3).bn_());
          QLog.i("[upload2_QCircleTaskManager]", 1, localStringBuilder.toString());
        }
      }
      this.b.clear();
      this.b.addAll((Collection)localObject1);
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("restore total size:");
    ((StringBuilder)localObject1).append(this.b.size());
    QLog.i("[upload2_QCircleTaskManager]", 1, ((StringBuilder)localObject1).toString());
    return this.b.size() > 0;
  }
  
  public boolean c(IQueueTask paramIQueueTask)
  {
    if ((paramIQueueTask != null) && (this.b.contains(paramIQueueTask)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pauseTask id:");
      localStringBuilder.append(paramIQueueTask.c());
      QLog.i("[upload2_QCircleTaskManager]", 1, localStringBuilder.toString());
      paramIQueueTask.g();
      paramIQueueTask.b(2);
      b(paramIQueueTask);
      return true;
    }
    QLog.w("[upload2_QCircleTaskManager]", 1, "pauseTask error");
    return false;
  }
  
  public void d()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reset total size:");
    ((StringBuilder)localObject).append(this.b.size());
    QLog.i("[upload2_QCircleTaskManager]", 1, ((StringBuilder)localObject).toString());
    if (this.b.size() > 0)
    {
      localObject = this.b.iterator();
      while (((Iterator)localObject).hasNext())
      {
        IQueueTask localIQueueTask = (IQueueTask)((Iterator)localObject).next();
        if ((localIQueueTask != null) && (!localIQueueTask.g())) {
          localIQueueTask.h();
        }
      }
    }
    this.b.clear();
  }
  
  public boolean d(IQueueTask paramIQueueTask)
  {
    if ((paramIQueueTask != null) && (this.b.contains(paramIQueueTask)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resumeTask id:");
      localStringBuilder.append(paramIQueueTask.c());
      localStringBuilder.append(", current state:");
      localStringBuilder.append(paramIQueueTask.bn_());
      QLog.i("[upload2_QCircleTaskManager]", 1, localStringBuilder.toString());
      int i = paramIQueueTask.bn_();
      if (i != 0)
      {
        if ((i != 2) && (i != 5)) {
          return true;
        }
        paramIQueueTask.e();
        if (NetworkState.isNetSupport()) {
          paramIQueueTask.b(0);
        } else {
          paramIQueueTask.b(6);
        }
        b(paramIQueueTask);
      }
      return true;
    }
    QLog.w("[upload2_QCircleTaskManager]", 1, "resumeTask error");
    return false;
  }
  
  public CopyOnWriteArrayList<IQueueTask> e()
  {
    return (CopyOnWriteArrayList)this.b.clone();
  }
  
  public boolean e(IQueueTask paramIQueueTask)
  {
    if ((paramIQueueTask != null) && (this.b.contains(paramIQueueTask)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeTask id:");
      localStringBuilder.append(paramIQueueTask.c());
      QLog.i("[upload2_QCircleTaskManager]", 1, localStringBuilder.toString());
      paramIQueueTask.b(5);
      paramIQueueTask.d();
      this.b.remove(paramIQueueTask);
      this.c.c(paramIQueueTask);
      return true;
    }
    QLog.w("[upload2_QCircleTaskManager]", 1, "removeTask error");
    return false;
  }
  
  public int f()
  {
    Object localObject = this.b;
    int k = 0;
    int i = 0;
    int j = k;
    if (localObject != null)
    {
      j = k;
      if (((CopyOnWriteArrayList)localObject).size() > 0)
      {
        localObject = this.b.iterator();
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          IQueueTask localIQueueTask = (IQueueTask)((Iterator)localObject).next();
          if ((localIQueueTask != null) && (localIQueueTask.n()) && ((localIQueueTask.bn_() == 1) || (localIQueueTask.bn_() == 4))) {
            i += 1;
          }
        }
      }
    }
    return j;
  }
  
  public boolean f(IQueueTask paramIQueueTask)
  {
    return this.b.contains(paramIQueueTask);
  }
  
  public int g()
  {
    return this.b.size();
  }
  
  public int h()
  {
    boolean bool = this.b.isEmpty();
    int i = 0;
    if (bool) {
      return 0;
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      IQueueTask localIQueueTask = (IQueueTask)localIterator.next();
      if ((localIQueueTask != null) && ((localIQueueTask.bn_() == 1) || (localIQueueTask.bn_() == 4))) {
        if (System.currentTimeMillis() - localIQueueTask.l() < 1800000L) {
          i += 1;
        } else {
          localIQueueTask.b(2);
        }
      }
    }
    return i;
  }
  
  public boolean i()
  {
    return this.d;
  }
  
  public boolean j()
  {
    int i = 0;
    try
    {
      while (i < this.b.size())
      {
        int j = ((IQueueTask)this.b.get(i)).bn_();
        if (j == 3) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception localException)
    {
      QLog.w("[upload2_QCircleTaskManager]", 1, localException.getMessage());
    }
  }
  
  public boolean k()
  {
    int i = 0;
    try
    {
      while (i < this.b.size())
      {
        int j = ((IQueueTask)this.b.get(i)).bn_();
        if (j == 6) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception localException)
    {
      QLog.w("[upload2_QCircleTaskManager]", 1, localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.queue.QCircleTaskManager
 * JD-Core Version:    0.7.0.1
 */