import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.util.LocationReportUtil.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Random;
import mqq.app.AppRuntime;

public class ardg
{
  private static int jdField_a_of_type_Int = 0;
  private static long jdField_a_of_type_Long;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static Runnable jdField_a_of_type_JavaLangRunnable;
  private static boolean jdField_a_of_type_Boolean = true;
  private static long jdField_b_of_type_Long;
  private static volatile boolean jdField_b_of_type_Boolean;
  private static boolean c;
  
  static
  {
    jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  public static int a(QQAppInterface paramQQAppInterface, aqyw paramaqyw)
  {
    if (paramaqyw == null) {}
    do
    {
      do
      {
        return 0;
        paramQQAppInterface = aqzc.a(paramQQAppInterface).a(paramaqyw);
      } while (paramQQAppInterface == null);
      if (paramQQAppInterface.a() == null) {
        return 1;
      }
      if (paramQQAppInterface.a() == -1) {
        return 2;
      }
    } while (paramQQAppInterface.a() == -1);
    return 3;
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationReportUtil", 2, "onAppForeground: invoked. ");
    }
    f();
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Int = baig.H(localBaseApplicationImpl);
      c = baig.e(localBaseApplicationImpl);
      if (QLog.isColorLevel()) {
        QLog.d("LocationReportUtil", 2, new Object[] { "onAppForeground: invoked. ", " sProcBgAliveTimeSecond: ", Integer.valueOf(jdField_a_of_type_Int), " sProcBgLocationIsReporting: ", Boolean.valueOf(c) });
      }
    }
    baig.a(localBaseApplicationImpl, false, 0);
  }
  
  public static boolean a(int paramInt)
  {
    return new Random(System.currentTimeMillis()).nextInt(paramInt) == 0;
  }
  
  public static void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationReportUtil", 2, "onAppBackground: invoked. ");
    }
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_Long = System.currentTimeMillis() / 1000L;
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      boolean bool = aqzc.a((QQAppInterface)localAppRuntime).a.a();
      if (jdField_a_of_type_JavaLangRunnable == null) {
        jdField_a_of_type_JavaLangRunnable = new LocationReportUtil.1(bool);
      }
      jdField_b_of_type_Boolean = false;
      jdField_a_of_type_AndroidOsHandler.post(jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public static void c()
  {
    if ((jdField_a_of_type_Boolean) && (jdField_a_of_type_Int != 0))
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localQQAppInterface = (QQAppInterface)localObject;
        localHashMap = new HashMap();
        if (!c) {
          break label131;
        }
        localObject = "1";
        localHashMap.put("sProcBgLocationIsReporting", localObject);
        if (!c) {
          break label137;
        }
        awrn.a(BaseApplication.getContext()).a(localQQAppInterface.getCurrentAccountUin(), "actLocationBgReportSampling", true, jdField_a_of_type_Int, 0L, localHashMap, "");
        if (QLog.isColorLevel()) {
          QLog.d("LocationReportUtil", 2, new Object[] { "reportWhenFirstTimeOnAppForeground: invoked. ", " map: ", localHashMap, " sProcBgAliveTimeSecond: ", Integer.valueOf(jdField_a_of_type_Int) });
        }
      }
    }
    label131:
    label137:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        QQAppInterface localQQAppInterface;
        HashMap localHashMap;
        return;
        Object localObject = "0";
        continue;
        if (a(1000)) {
          awrn.a(BaseApplication.getContext()).a(localQQAppInterface.getCurrentAccountUin(), "actLocationBgReportSampling", true, jdField_a_of_type_Int, 0L, localHashMap, "");
        }
      }
    }
    QLog.d("LocationReportUtil", 2, new Object[] { "report: invoked. no need report", " isFirstTimeOnAppForeground: ", Boolean.valueOf(jdField_a_of_type_Boolean), " sProcBgAliveTimeSecond: ", Integer.valueOf(jdField_a_of_type_Int) });
  }
  
  public static void d()
  {
    jdField_b_of_type_Long = System.currentTimeMillis();
  }
  
  public static void e()
  {
    long l = (System.currentTimeMillis() - jdField_b_of_type_Long) / 1000L;
    if (QLog.isColorLevel()) {
      QLog.d("LocationReportUtil", 2, new Object[] { "reportFloatWindowLastExposeDuration: invoked. ", " second: ", Long.valueOf(l) });
    }
    awqx.b(null, "CliOper", "", "", "0X800A976", "0X800A976", 0, 0, String.valueOf(l), "0", "0", "");
  }
  
  private static void f()
  {
    jdField_a_of_type_AndroidOsHandler.removeCallbacks(jdField_a_of_type_JavaLangRunnable);
    jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    jdField_a_of_type_JavaLangRunnable = null;
    jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("LocationReportUtil", 2, new Object[] { "stopHandler: invoked. ", " updateLocationBgReportSpRunnable: ", jdField_a_of_type_JavaLangRunnable });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ardg
 * JD-Core Version:    0.7.0.1
 */