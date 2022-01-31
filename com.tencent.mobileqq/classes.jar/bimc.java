import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class bimc
{
  private static final int jdField_a_of_type_Int = new Random().nextInt(1000) + 1;
  private static final ConcurrentHashMap<Integer, bimd> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public static bimd a(int paramInt)
  {
    return (bimd)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5, String... paramVarArgs)
  {
    int i = 0;
    if ((paramInt1 != 0) && (jdField_a_of_type_Int > 1)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1 + "|");
    localStringBuilder.append(paramInt2 + "|");
    localStringBuilder.append(paramInt3 + "|");
    localStringBuilder.append(paramInt4 + "|");
    localStringBuilder.append(paramString + "|");
    localStringBuilder.append(paramInt5);
    paramString = new String[6];
    System.arraycopy(paramVarArgs, 0, paramString, 0, Math.min(6, paramVarArgs.length));
    paramInt1 = i;
    if (paramInt1 < paramString.length)
    {
      if (paramString[paramInt1] == null) {
        localStringBuilder.append("|");
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        localStringBuilder.append("|" + paramString[paramInt1]);
      }
    }
    if ((paramAppRuntime instanceof QQAppInterface)) {}
    for (paramAppRuntime = (QQAppInterface)paramAppRuntime;; paramAppRuntime = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloadReportUtils", 2, "preload: " + localStringBuilder.toString());
      }
      azps.a(paramAppRuntime, "sendtdbank|b_sng_qqvip_qqcomic|preload", localStringBuilder.toString(), true);
      return;
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, String... paramVarArgs)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1 + "|");
    localStringBuilder.append(paramInt2 + "|");
    localStringBuilder.append(paramInt3 + "|");
    localStringBuilder.append(paramInt4 + "|");
    localStringBuilder.append(paramString);
    paramString = new String[6];
    System.arraycopy(paramVarArgs, 0, paramString, 0, Math.min(6, paramVarArgs.length));
    paramInt1 = i;
    if (paramInt1 < paramString.length)
    {
      if (paramString[paramInt1] == null) {
        localStringBuilder.append("|");
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        localStringBuilder.append("|" + paramString[paramInt1]);
      }
    }
    if ((paramAppRuntime instanceof QQAppInterface)) {}
    for (paramAppRuntime = (QQAppInterface)paramAppRuntime;; paramAppRuntime = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloadReportUtils", 2, "hitrate: " + localStringBuilder.toString());
      }
      azps.a(paramAppRuntime, "sendtdbank|b_sng_qqvip_qqcomic|preloadhitrate", localStringBuilder.toString(), true);
      return;
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, int paramInt3, long paramLong, String... paramVarArgs)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1 + "|");
    localStringBuilder.append(paramInt2 + "|");
    localStringBuilder.append(paramInt3 + "|");
    localStringBuilder.append(paramLong);
    String[] arrayOfString = new String[6];
    System.arraycopy(paramVarArgs, 0, arrayOfString, 0, Math.min(6, paramVarArgs.length));
    paramInt1 = i;
    if (paramInt1 < arrayOfString.length)
    {
      if (arrayOfString[paramInt1] == null) {
        localStringBuilder.append("|");
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        localStringBuilder.append("|" + arrayOfString[paramInt1]);
      }
    }
    if ((paramAppRuntime instanceof QQAppInterface)) {}
    for (paramAppRuntime = (QQAppInterface)paramAppRuntime;; paramAppRuntime = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloadReportUtils", 2, "procbekilled: " + localStringBuilder.toString());
      }
      azps.a(paramAppRuntime, "sendtdbank|b_sng_qqvip_qqcomic|procbekilled", localStringBuilder.toString(), true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bimc
 * JD-Core Version:    0.7.0.1
 */