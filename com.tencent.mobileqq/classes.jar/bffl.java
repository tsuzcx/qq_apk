import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qqmini.sdk.task.TaskFlowEngine.1;
import com.tencent.qqmini.sdk.task.TaskFlowEngine.2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bffl
  implements Handler.Callback, bffj
{
  public static final int MSG_WHAT_BASE = 100;
  public static final int MSG_WHAT_TASK_DONE = 101;
  public static final String TAG = "TaskFlow";
  private List<bffi> mAllTasks = new ArrayList();
  private final List<bffm> mFlows = new ArrayList();
  private bffn mTaskThreadPool;
  private bffi[] mTasks;
  
  public bffl()
  {
    try
    {
      int j = bfgj.a();
      betc.c("TaskFlow", "create thread pool, cpuCores=" + j);
      if (j > 0) {
        i = j + 1;
      }
      this.mTaskThreadPool = new bffn("TaskFlowEngine", 2, i);
      return;
    }
    catch (Exception localException)
    {
      betc.d("TaskFlow", "create thread pool error!", localException);
    }
  }
  
  private void executeTask(bffi arg1)
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
    } while (((bffm)((Iterator)localObject2).next()).a != ???);
    for (int i = 1;; i = 0) {
      for (;;)
      {
        if (i == 0) {
          localObject2 = new bffm(this, ???, localList);
        }
        synchronized (this.mFlows)
        {
          this.mFlows.add(localObject2);
          ??? = localList.iterator();
          if (!???.hasNext()) {
            break;
          }
          executeTask((bffi)???.next());
        }
      }
    }
  }
  
  private void initCallback(bffi parambffi)
  {
    if (parambffi == null) {}
    for (;;)
    {
      return;
      parambffi.a(this);
      if (!this.mAllTasks.contains(parambffi)) {
        this.mAllTasks.add(parambffi);
      }
      parambffi = parambffi.a();
      if ((parambffi != null) && (parambffi.size() > 0))
      {
        parambffi = parambffi.iterator();
        while (parambffi.hasNext()) {
          initCallback((bffi)parambffi.next());
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public final void initTasks(bffi[] paramArrayOfbffi)
  {
    this.mAllTasks.clear();
    this.mTasks = paramArrayOfbffi;
    if (this.mTasks == null) {}
    for (;;)
    {
      return;
      paramArrayOfbffi = this.mTasks;
      int j = paramArrayOfbffi.length;
      int i = 0;
      while (i < j)
      {
        initCallback(paramArrayOfbffi[i]);
        i += 1;
      }
    }
  }
  
  public void onTaskBegin(bffi parambffi) {}
  
  public void onTaskDone(bffi parambffi)
  {
    if (parambffi == null) {}
    while (!parambffi.d()) {
      return;
    }
    this.mTaskThreadPool.a(new TaskFlowEngine.2(this, parambffi));
  }
  
  protected void resetTaskAndDepends(bffi parambffi)
  {
    if (parambffi == null) {}
    for (;;)
    {
      return;
      parambffi.b();
      Iterator localIterator = this.mAllTasks.iterator();
      while (localIterator.hasNext())
      {
        bffi localbffi = (bffi)localIterator.next();
        if (localbffi.a(parambffi)) {
          localbffi.b();
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
  
  public void updateFlow(bffi parambffi)
  {
    synchronized (this.mFlows)
    {
      Iterator localIterator = this.mFlows.iterator();
      while (localIterator.hasNext())
      {
        bffm localbffm = (bffm)localIterator.next();
        if (localbffm.a(parambffi)) {
          localbffm.a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bffl
 * JD-Core Version:    0.7.0.1
 */