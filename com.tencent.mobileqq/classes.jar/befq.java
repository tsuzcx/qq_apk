import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebAccelerator;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class befq
{
  public static long a;
  static final AtomicBoolean a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public static boolean b()
  {
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      long l = System.currentTimeMillis();
      HashMap localHashMap = new HashMap();
      localHashMap.put("use_speedy_classloader", Boolean.valueOf(true));
      localHashMap.put("use_dexloader_service", Boolean.valueOf(false));
      QbSdk.initTbsSettings(localHashMap);
      WebAccelerator.initTbsEnvironment(BaseApplicationImpl.sApplication.getApplicationContext(), 2);
      beep.D = SystemClock.elapsedRealtime();
      jdField_a_of_type_Long = System.currentTimeMillis() - l;
      QLog.d("WebLog_SwiftWebAccelerator", 1, "WebAccelerator.initTbsEnvironment, cost=" + (System.currentTimeMillis() - l));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     befq
 * JD-Core Version:    0.7.0.1
 */