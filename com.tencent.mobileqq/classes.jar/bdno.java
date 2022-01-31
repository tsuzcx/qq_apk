import android.content.res.Resources;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.SyncLoadTask.1;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class bdno
{
  public final String TAG;
  int mTaskStatus = 1;
  
  public bdno(String paramString)
  {
    this.TAG = (paramString + "_" + AudioHelper.b());
  }
  
  public static void requestSyncTask(Resources paramResources, ArrayList<bdno> paramArrayList, bdnp parambdnp)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      bdno localbdno = (bdno)localIterator.next();
      if (localbdno.isNeedRunTask()) {
        localArrayList.add(localbdno);
      }
    }
    localIterator = localArrayList.iterator();
    while (localIterator.hasNext()) {
      ((bdno)localIterator.next()).setRunning();
    }
    ThreadManager.post(new SyncLoadTask.1(localArrayList, paramResources, parambdnp, paramArrayList), 8, null, true);
  }
  
  public final void clean()
  {
    this.mTaskStatus = 1;
    innerClean();
  }
  
  public abstract void innerClean();
  
  public final boolean isNeedRunTask()
  {
    return (this.mTaskStatus != 20) && (this.mTaskStatus != 2);
  }
  
  final boolean isRunning()
  {
    return (this.mTaskStatus & 0x2) == 2;
  }
  
  final boolean isSuc()
  {
    return (this.mTaskStatus & 0x14) == 20;
  }
  
  public abstract boolean runOnSubThread(Resources paramResources);
  
  public final void setComplete(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mTaskStatus = 20;
      return;
    }
    this.mTaskStatus = 36;
  }
  
  final void setRunning()
  {
    this.mTaskStatus = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdno
 * JD-Core Version:    0.7.0.1
 */