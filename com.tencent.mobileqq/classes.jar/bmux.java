import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMShortVideoUtils.1;
import java.util.Iterator;
import java.util.List;

public class bmux
{
  public static void a(Context paramContext)
  {
    a(paramContext, null);
  }
  
  public static void a(Context paramContext, Runnable paramRunnable, String paramString)
  {
    ThreadManager.excute(new QIMShortVideoUtils.1(paramContext, paramString, paramRunnable), 64, null, false);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    a(paramContext, null, paramString);
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        boolean bool = "com.tencent.mobileqq:peak".equals(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName);
        if (bool) {
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QIMShortVideoUtils", 2, "get process info fail.");
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmux
 * JD-Core Version:    0.7.0.1
 */