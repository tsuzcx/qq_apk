import android.support.annotation.NonNull;
import android.util.Log;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.mobileqq.statistics.CaughtException;
import com.tencent.mobileqq.statistics.CaughtExceptionReport.1;
import com.tencent.mobileqq.statistics.CaughtExceptionReport.2;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;

public final class axps
{
  private static final Set<String> a = new CaughtExceptionReport.1(20);
  private static final Set<Class> b = new CaughtExceptionReport.2(5);
  
  public static void a(@NonNull Throwable paramThrowable)
  {
    a(paramThrowable, "This is CaughtException");
  }
  
  public static void a(@NonNull Throwable paramThrowable, @NonNull String paramString)
  {
    if ((paramThrowable == null) || (paramString == null)) {
      return;
    }
    if (!a(paramThrowable))
    {
      Log.e("CaughtExceptionReport", "this report is not permitted. ", paramThrowable);
      return;
    }
    Object localObject = paramThrowable;
    if (!(paramThrowable instanceof CaughtException)) {
      localObject = new CaughtException("Caught: " + paramThrowable.getMessage(), paramThrowable);
    }
    if (QLog.isColorLevel()) {
      QLog.e("CaughtExceptionReport-eup", 2, "rqd将上报信息到rdm网站，上报不会导致客户端闪退，仅用作数据统计");
    }
    CrashReport.handleCatchException(Thread.currentThread(), (Throwable)localObject, "ExtraMessage: " + paramString, null);
  }
  
  private static boolean a(Throwable paramThrowable)
  {
    if (b.contains(paramThrowable.getClass())) {
      return true;
    }
    paramThrowable = paramThrowable.getStackTrace();
    if ((paramThrowable == null) || (paramThrowable.length < 1)) {
      return false;
    }
    paramThrowable = paramThrowable[0].getClassName();
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      if (paramThrowable.startsWith((String)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     axps
 * JD-Core Version:    0.7.0.1
 */