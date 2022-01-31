import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.task.TaskFlowEngine.1;
import com.tencent.qqmini.sdk.task.TaskFlowEngine.2;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bhhq
  implements Handler.Callback, bhho
{
  public static final int MSG_WHAT_BASE = 100;
  public static final int MSG_WHAT_TASK_DONE = 101;
  public static final String TAG = "TaskFlow";
  protected List<bhhn> mAllTasks = new ArrayList();
  private final List<bhhr> mFlows = new ArrayList();
  private bhhs mTaskThreadPool;
  private bhhn[] mTasks;
  
  public bhhq()
  {
    try
    {
      int j = DeviceInfoUtil.getNumberOfCPUCores();
      QMLog.w("TaskFlow", "create thread pool, cpuCores=" + j);
      if (j > 0) {
        i = j + 1;
      }
      this.mTaskThreadPool = new bhhs("TaskFlowEngine", 2, i);
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("TaskFlow", "create thread pool error!", localException);
    }
  }
  
  private void initCallback(bhhn parambhhn)
  {
    if (parambhhn == null) {}
    for (;;)
    {
      return;
      parambhhn.a(this);
      if (!this.mAllTasks.contains(parambhhn)) {
        this.mAllTasks.add(parambhhn);
      }
      parambhhn = parambhhn.a();
      if ((parambhhn != null) && (parambhhn.size() > 0))
      {
        parambhhn = parambhhn.iterator();
        while (parambhhn.hasNext()) {
          initCallback((bhhn)parambhhn.next());
        }
      }
    }
  }
  
  public void executeTask(bhhn arg1)
  {
    if (??? == null) {
      return;
    }
    List localList = ???.a();
    if ((localList == null) || (localList.size() <= 0))
    {
      ???.g();
      return;
    }
    Object localObject2 = this.mFlows.iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
    } while (((bhhr)((Iterator)localObject2).next()).a != ???);
    for (int i = 1;; i = 0) {
      for (;;)
      {
        if (i == 0) {
          localObject2 = new bhhr(this, ???, localList);
        }
        synchronized (this.mFlows)
        {
          this.mFlows.add(localObject2);
          ??? = localList.iterator();
          if (!???.hasNext()) {
            break;
          }
          executeTask((bhhn)???.next());
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public final void initTasks(bhhn[] paramArrayOfbhhn)
  {
    this.mAllTasks.clear();
    this.mTasks = paramArrayOfbhhn;
    if (this.mTasks == null) {}
    for (;;)
    {
      return;
      paramArrayOfbhhn = this.mTasks;
      int j = paramArrayOfbhhn.length;
      int i = 0;
      while (i < j)
      {
        initCallback(paramArrayOfbhhn[i]);
        i += 1;
      }
    }
  }
  
  public void onTaskBegin(bhhn parambhhn) {}
  
  public void onTaskDone(bhhn parambhhn)
  {
    if (parambhhn == null) {}
    while (!parambhhn.d()) {
      return;
    }
    this.mTaskThreadPool.a(new TaskFlowEngine.2(this, parambhhn));
  }
  
  protected void resetTaskAndDepends(bhhn parambhhn)
  {
    if (parambhhn == null) {}
    for (;;)
    {
      return;
      parambhhn.b();
      Iterator localIterator = this.mAllTasks.iterator();
      while (localIterator.hasNext())
      {
        bhhn localbhhn = (bhhn)localIterator.next();
        if (localbhhn.a(parambhhn)) {
          localbhhn.b();
        }
      }
    }
  }
  
  public void start()
  {
    if ((this.mTasks == null) || (this.mTasks.length <= 0)) {
      return;
    }
    this.mTaskThreadPool.a(new TaskFlowEngine.1(this));
  }
  
  public void updateFlow(bhhn parambhhn)
  {
    synchronized (this.mFlows)
    {
      Iterator localIterator = this.mFlows.iterator();
      while (localIterator.hasNext())
      {
        bhhr localbhhr = (bhhr)localIterator.next();
        if (localbhhr.a(parambhhn)) {
          localbhhr.a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhhq
 * JD-Core Version:    0.7.0.1
 */