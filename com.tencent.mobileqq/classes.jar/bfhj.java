import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RecentTaskInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Process;
import java.util.Iterator;
import java.util.List;

public class bfhj
{
  public static void a(Activity paramActivity)
  {
    beqb.a().a().onAppDestroy(null);
    a(paramActivity);
    Process.killProcess(Process.myPid());
  }
  
  public static void a(behq parambehq)
  {
    beqb.a().a().onAppDestroy(null);
    a(parambehq.a());
    Process.killProcess(Process.myPid());
  }
  
  private static boolean a(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return false;
    }
    try
    {
      Object localObject = (ActivityManager)paramActivity.getSystemService("activity");
      if (localObject == null) {
        return false;
      }
      localObject = ((ActivityManager)localObject).getAppTasks();
      if (localObject == null) {
        return false;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.AppTask localAppTask = (ActivityManager.AppTask)((Iterator)localObject).next();
        if ((localAppTask != null) && (localAppTask.getTaskInfo() != null) && (localAppTask.getTaskInfo().baseIntent != null) && (localAppTask.getTaskInfo().baseIntent.getComponent() != null))
        {
          betc.d("miniapp", "will finish and remove task: id=" + localAppTask.getTaskInfo().id);
          if ((localAppTask.getTaskInfo().baseIntent.getComponent().getClassName().equals(paramActivity.getClass().getName())) || (localAppTask.getTaskInfo().baseIntent.getComponent().getClassName().equals(paramActivity.getClass().getName()))) {
            localAppTask.finishAndRemoveTask();
          }
        }
      }
      return true;
    }
    catch (Throwable paramActivity)
    {
      betc.d("miniapp", "finishAndRemoveAllTasks exception.");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfhj
 * JD-Core Version:    0.7.0.1
 */