import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.app.Foreground;

public class ayql
{
  private AppRuntime a;
  
  public ayql(AppRuntime paramAppRuntime)
  {
    this.a = paramAppRuntime;
  }
  
  private boolean a(AppRuntime paramAppRuntime)
  {
    int j = b();
    int i;
    if (Foreground.sCountResume > 0)
    {
      i = 1;
      if (QLog.isColorLevel()) {
        QLog.d("ActionDetector", 2, "[status][action] isStayingUpLate countResume:" + Foreground.sCountResume + " curHour: " + j + " begin: " + ayqi.D + " end: " + ayqi.E);
      }
      if (ayqi.E <= ayqi.D) {
        break label165;
      }
      if ((j < ayqi.D) || (j >= ayqi.E)) {
        break label237;
      }
      paramAppRuntime = paramAppRuntime.getOnlineStatus();
      if (QLog.isColorLevel()) {
        QLog.d("ActionDetector", 2, "[status][action] isStayingUpLate closeZone curHour: " + j + " status: " + paramAppRuntime);
      }
      if ((paramAppRuntime != AppRuntime.Status.online) || (i == 0)) {
        break label163;
      }
    }
    label163:
    label165:
    do
    {
      return true;
      i = 0;
      break;
      return false;
      if ((j <= ayqi.D) && (j >= ayqi.E)) {
        break label237;
      }
      paramAppRuntime = paramAppRuntime.getOnlineStatus();
      if (QLog.isColorLevel()) {
        QLog.d("ActionDetector", 2, "[status][action] isStayingUpLate openZone curHour: " + j + " status: " + paramAppRuntime);
      }
    } while ((paramAppRuntime == AppRuntime.Status.online) && (i != 0));
    return false;
    label237:
    return false;
  }
  
  public int a()
  {
    if (a(this.a)) {}
    for (int i = 41032;; i = 40001)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActionDetector", 2, "[status][action] getStatus return status: " + i);
      }
      return i;
    }
  }
  
  int b()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
    return localCalendar.get(11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayql
 * JD-Core Version:    0.7.0.1
 */