import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RecentTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Process;
import java.util.Iterator;
import java.util.List;

public class bdzc
{
  public static void a(bdcz parambdcz)
  {
    bdle.a().a().onAppDestroy(null);
    a(parambdcz);
    Process.killProcess(Process.myPid());
  }
  
  private static boolean a(bdcz parambdcz)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return false;
    }
    try
    {
      Object localObject = (ActivityManager)parambdcz.a().getSystemService("activity");
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
          bdnw.d("miniapp", "will finish and remove task: id=" + localAppTask.getTaskInfo().id);
          if ((localAppTask.getTaskInfo().baseIntent.getComponent().getClassName().equals(parambdcz.a().getClass().getName())) || (localAppTask.getTaskInfo().baseIntent.getComponent().getClassName().equals(parambdcz.a().getClass().getName()))) {
            localAppTask.finishAndRemoveTask();
          }
        }
      }
      return true;
    }
    catch (Throwable parambdcz)
    {
      bdnw.d("miniapp", "finishAndRemoveAllTasks exception.");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdzc
 * JD-Core Version:    0.7.0.1
 */