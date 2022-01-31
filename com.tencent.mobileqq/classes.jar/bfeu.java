import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qqmini.sdk.task.TaskFlowEngine.1;
import com.tencent.qqmini.sdk.task.TaskFlowEngine.2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bfeu
  implements Handler.Callback, bfes
{
  public static final int MSG_WHAT_BASE = 100;
  public static final int MSG_WHAT_TASK_DONE = 101;
  public static final String TAG = "TaskFlow";
  private List<bfer> mAllTasks = new ArrayList();
  private final List<bfev> mFlows = new ArrayList();
  private bfew mTaskThreadPool;
  private bfer[] mTasks;
  
  public bfeu()
  {
    try
    {
      int j = bffs.a();
      besl.c("TaskFlow", "create thread pool, cpuCores=" + j);
      if (j > 0) {
        i = j + 1;
      }
      this.mTaskThreadPool = new bfew("TaskFlowEngine", 2, i);
      return;
    }
    catch (Exception localException)
    {
      besl.d("TaskFlow", "create thread pool error!", localException);
    }
  }
  
  private void executeTask(bfer arg1)
  {
    if (??? == null) {
      return;
    }
    List localList = ???.a();
    if ((localList == null) || (localList.size() <= 0))
    {
      ???.e();
      return;
    }
    Object localObject2 = this.mFlows.iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
    } while (((bfev)((Iterator)localObject2).next()).a != ???);
    for (int i = 1;; i = 0) {
      for (;;)
      {
        if (i == 0) {
          localObject2 = new bfev(this, ???, localList);
        }
        synchronized (this.mFlows)
        {
          this.mFlows.add(localObject2);
          ??? = localList.iterator();
          if (!???.hasNext()) {
            break;
          }
          executeTask((bfer)???.next());
        }
      }
    }
  }
  
  private void initCallback(bfer parambfer)
  {
    if (parambfer == null) {}
    for (;;)
    {
      return;
      parambfer.a(this);
      if (!this.mAllTasks.contains(parambfer)) {
        this.mAllTasks.add(parambfer);
      }
      parambfer = parambfer.a();
      if ((parambfer != null) && (parambfer.size() > 0))
      {
        parambfer = parambfer.iterator();
        while (parambfer.hasNext()) {
          initCallback((bfer)parambfer.next());
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public final void initTasks(bfer[] paramArrayOfbfer)
  {
    this.mAllTasks.clear();
    this.mTasks = paramArrayOfbfer;
    if (this.mTasks == null) {}
    for (;;)
    {
      return;
      paramArrayOfbfer = this.mTasks;
      int j = paramArrayOfbfer.length;
      int i = 0;
      while (i < j)
      {
        initCallback(paramArrayOfbfer[i]);
        i += 1;
      }
    }
  }
  
  public void onTaskBegin(bfer parambfer) {}
  
  public void onTaskDone(bfer parambfer)
  {
    if (parambfer == null) {}
    while (!parambfer.d()) {
      return;
    }
    this.mTaskThreadPool.a(new TaskFlowEngine.2(this, parambfer));
  }
  
  protected void resetTaskAndDepends(bfer parambfer)
  {
    if (parambfer == null) {}
    for (;;)
    {
      return;
      parambfer.b();
      Iterator localIterator = this.mAllTasks.iterator();
      while (localIterator.hasNext())
      {
        bfer localbfer = (bfer)localIterator.next();
        if (localbfer.a(parambfer)) {
          localbfer.b();
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
  
  public void updateFlow(bfer parambfer)
  {
    synchronized (this.mFlows)
    {
      Iterator localIterator = this.mFlows.iterator();
      while (localIterator.hasNext())
      {
        bfev localbfev = (bfev)localIterator.next();
        if (localbfev.a(parambfer)) {
          localbfev.a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfeu
 * JD-Core Version:    0.7.0.1
 */