import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.task.TaskFlowEngine.1;
import com.tencent.qqmini.sdk.task.TaskFlowEngine.2;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bhlx
  implements Handler.Callback, bhlv
{
  public static final int MSG_WHAT_BASE = 100;
  public static final int MSG_WHAT_TASK_DONE = 101;
  public static final String TAG = "TaskFlow";
  protected List<bhlu> mAllTasks = new ArrayList();
  private final List<bhly> mFlows = new ArrayList();
  private bhlz mTaskThreadPool;
  private bhlu[] mTasks;
  
  public bhlx()
  {
    try
    {
      int j = DeviceInfoUtil.getNumberOfCPUCores();
      QMLog.w("TaskFlow", "create thread pool, cpuCores=" + j);
      if (j > 0) {
        i = j + 1;
      }
      this.mTaskThreadPool = new bhlz("TaskFlowEngine", 2, i);
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("TaskFlow", "create thread pool error!", localException);
    }
  }
  
  private void initCallback(bhlu parambhlu)
  {
    if (parambhlu == null) {}
    for (;;)
    {
      return;
      parambhlu.a(this);
      if (!this.mAllTasks.contains(parambhlu)) {
        this.mAllTasks.add(parambhlu);
      }
      parambhlu = parambhlu.a();
      if ((parambhlu != null) && (parambhlu.size() > 0))
      {
        parambhlu = parambhlu.iterator();
        while (parambhlu.hasNext()) {
          initCallback((bhlu)parambhlu.next());
        }
      }
    }
  }
  
  public void executeTask(bhlu arg1)
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
    } while (((bhly)((Iterator)localObject2).next()).a != ???);
    for (int i = 1;; i = 0) {
      for (;;)
      {
        if (i == 0) {
          localObject2 = new bhly(this, ???, localList);
        }
        synchronized (this.mFlows)
        {
          this.mFlows.add(localObject2);
          ??? = localList.iterator();
          if (!???.hasNext()) {
            break;
          }
          executeTask((bhlu)???.next());
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public final void initTasks(bhlu[] paramArrayOfbhlu)
  {
    this.mAllTasks.clear();
    this.mTasks = paramArrayOfbhlu;
    if (this.mTasks == null) {}
    for (;;)
    {
      return;
      paramArrayOfbhlu = this.mTasks;
      int j = paramArrayOfbhlu.length;
      int i = 0;
      while (i < j)
      {
        initCallback(paramArrayOfbhlu[i]);
        i += 1;
      }
    }
  }
  
  public void onTaskBegin(bhlu parambhlu) {}
  
  public void onTaskDone(bhlu parambhlu)
  {
    if (parambhlu == null) {}
    while (!parambhlu.d()) {
      return;
    }
    this.mTaskThreadPool.a(new TaskFlowEngine.2(this, parambhlu));
  }
  
  protected void resetTaskAndDepends(bhlu parambhlu)
  {
    if (parambhlu == null) {}
    for (;;)
    {
      return;
      parambhlu.b();
      Iterator localIterator = this.mAllTasks.iterator();
      while (localIterator.hasNext())
      {
        bhlu localbhlu = (bhlu)localIterator.next();
        if (localbhlu.a(parambhlu)) {
          localbhlu.b();
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
  
  public void updateFlow(bhlu parambhlu)
  {
    synchronized (this.mFlows)
    {
      Iterator localIterator = this.mFlows.iterator();
      while (localIterator.hasNext())
      {
        bhly localbhly = (bhly)localIterator.next();
        if (localbhly.a(parambhlu)) {
          localbhly.a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhlx
 * JD-Core Version:    0.7.0.1
 */