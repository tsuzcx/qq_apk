import android.os.HandlerThread;
import android.os.Looper;
import android.util.Printer;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qphone.base.util.QLog;
import mqq.util.AbstractUnifiedMonitor.ThreadMonitorCallback;

public class aobg
{
  private static AbstractUnifiedMonitor.ThreadMonitorCallback a = new aobh();
  
  public static void a()
  {
    if (!UnifiedMonitor.a().whetherReportDuringThisStartup(4)) {
      return;
    }
    int i = UnifiedMonitor.a().getThreshold(4);
    UnifiedMonitor.a().setMonitoredThread(4, ThreadManager.getSubThread(), a);
    aoih localaoih = new aoih(4, "SubLooper");
    localaoih.a(i, false);
    ThreadManager.getSubThreadLooper().setMessageLogging(localaoih);
  }
  
  public static void b()
  {
    if (!UnifiedMonitor.a().whetherReportDuringThisStartup(18)) {
      return;
    }
    Object localObject1 = MsfCore.sCore;
    if (localObject1 == null)
    {
      QLog.e("MagnifierSDK.QAPM", 1, "msf core hasnot init");
      return;
    }
    Object localObject2 = ((MsfCore)localObject1).getNetworkHandlerThread();
    if (localObject2 == null)
    {
      QLog.e("MagnifierSDK.QAPM", 1, "network thread hasnot init");
      return;
    }
    localObject1 = ((HandlerThread)localObject2).getLooper();
    if (localObject1 == null)
    {
      QLog.e("MagnifierSDK.QAPM", 1, "network thread has not start");
      return;
    }
    int i = UnifiedMonitor.a().getThreshold(18);
    UnifiedMonitor.a().setMonitoredThread(18, (Thread)localObject2, a);
    localObject2 = new aoih(18, "msf-network");
    ((aoih)localObject2).a(i, false);
    ((Looper)localObject1).setMessageLogging((Printer)localObject2);
  }
  
  public static void c()
  {
    if (!UnifiedMonitor.a().whetherReportDuringThisStartup(13)) {
      return;
    }
    int i = UnifiedMonitor.a().getThreshold(13);
    UnifiedMonitor.a().setMonitoredThread(13, ThreadManager.getRecentThread(), a);
    aoih localaoih = new aoih(13, "RecentLooper");
    localaoih.a(i, false);
    ThreadManager.getRecentThreadLooper().setMessageLogging(localaoih);
  }
  
  public static void d()
  {
    if (!UnifiedMonitor.a().whetherReportDuringThisStartup(5)) {
      return;
    }
    int i = UnifiedMonitor.a().getThreshold(5);
    UnifiedMonitor.a().setMonitoredThread(5, ThreadManager.getFileThread(), a);
    aoih localaoih = new aoih(5, "FileLooper");
    localaoih.a(i, false);
    ThreadManager.getFileThreadLooper().setMessageLogging(localaoih);
  }
  
  public static void e()
  {
    if (!UnifiedMonitor.a().whetherReportDuringThisStartup(6))
    {
      com.tencent.mobileqq.app.ThreadExcutor.sLooperMonitorSwitch = false;
      return;
    }
    com.tencent.mobileqq.app.ThreadExcutor.sLooperMonitorSwitch = true;
    com.tencent.mobileqq.app.ThreadExcutor.sThreshTime = UnifiedMonitor.a().getThreshold(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aobg
 * JD-Core Version:    0.7.0.1
 */