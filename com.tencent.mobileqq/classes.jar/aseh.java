import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter.1;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter.2;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class aseh
{
  private static Map<String, Long> a = new HashMap();
  
  static
  {
    anrz localanrz = new anrz();
    localanrz.jdField_a_of_type_JavaLangString = "OpenShare";
    localanrz.b = "KEY_STAGE_1_TOTAL";
    localanrz.c = "KEY_STAGE_2_TOTAL";
    localanrz.jdField_a_of_type_Long = 30000L;
    localanrz.jdField_a_of_type_JavaUtilSet = new ForwardStatisticsReporter.1();
    anry.a("OpenShare", localanrz);
    localanrz = new anrz();
    localanrz.jdField_a_of_type_JavaLangString = "OpenLogin";
    localanrz.b = "KEY_LOGIN_STAGE_1_TOTAL";
    localanrz.c = "KEY_AUTHORITY_TOTAL";
    localanrz.jdField_a_of_type_Long = 30000L;
    localanrz.jdField_a_of_type_JavaUtilSet = new ForwardStatisticsReporter.2();
    anry.a("OpenLogin", localanrz);
  }
  
  public static void a()
  {
    try
    {
      a.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(String paramString)
  {
    try
    {
      long l = System.currentTimeMillis();
      a.put(paramString, Long.valueOf(l));
      anry.a(paramString, l);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void a(String paramString, long paramLong)
  {
    try
    {
      String str = ((AppInterface)BaseApplicationImpl.sApplication.getRuntime()).getCurrentAccountUin();
      QLog.d("ForwardStatisticsReporter", 1, new Object[] { paramString, "=", Long.valueOf(paramLong), ", uin=", bfii.a(str) });
      azri.a(BaseApplicationImpl.getApplication()).a(str, paramString, true, paramLong, 0L, null, "", false);
      anry.a(paramString, true, paramLong, null);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void a(String paramString, long paramLong, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    String str = ((AppInterface)BaseApplicationImpl.sApplication.getRuntime()).getCurrentAccountUin();
    QLog.d("ForwardStatisticsReporter", 1, new Object[] { "reportSaveImage key=", paramString, ",duration=", Long.valueOf(paramLong), ", uin=", bfii.a(str) });
    azri.a(BaseApplicationImpl.getApplication()).a(str, paramString, paramBoolean, paramLong, 0L, paramHashMap, "", false);
    anry.a(paramString, true, paramLong, paramHashMap);
  }
  
  public static void a(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_ERROR_CODE", Integer.toString(paramBundle.getInt("code")));
    localHashMap.put("param_error_ret", Integer.toString(paramBundle.getInt("ret")));
    a(paramString, localHashMap, paramBoolean);
  }
  
  public static void a(String paramString, bfqv parambfqv)
  {
    try
    {
      a(paramString, parambfqv, true);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void a(String paramString, bfqv parambfqv, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    if (parambfqv == null) {}
    for (parambfqv = "";; parambfqv = parambfqv.jdField_a_of_type_JavaLangString)
    {
      a(paramString, parambfqv, paramHashMap, paramBoolean);
      return;
    }
  }
  
  public static void a(String paramString, bfqv parambfqv, boolean paramBoolean)
  {
    try
    {
      a(paramString, parambfqv, null, paramBoolean);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void a(String paramString1, String paramString2, long paramLong, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = (Long)a.get(paramString1);
        if (localObject == null)
        {
          QLog.e("ForwardStatisticsReporter", 1, new Object[] { "report invalid key =", paramString1 });
          return;
        }
        a.remove(paramString1);
        paramLong -= ((Long)localObject).longValue();
        if ((paramHashMap == null) || (paramHashMap.isEmpty()))
        {
          QLog.d("ForwardStatisticsReporter", 1, new Object[] { paramString1, "=", Long.valueOf(paramLong), ", uin=", bfii.a(paramString2) });
          azri.a(BaseApplicationImpl.getApplication()).a(paramString2, paramString1, paramBoolean, paramLong, 0L, paramHashMap, "", false);
          anry.a(paramString1, paramBoolean, paramLong, paramHashMap);
          if (!"KEY_STAGE_2_TOTAL".equals(paramString1)) {
            continue;
          }
          a.clear();
          continue;
        }
        localObject = new StringBuilder();
      }
      finally {}
      Iterator localIterator = paramHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ((StringBuilder)localObject).append((String)localEntry.getKey()).append("=").append((String)localEntry.getValue()).append(" ");
      }
      QLog.d("ForwardStatisticsReporter", 1, new Object[] { paramString1, "=", Long.valueOf(paramLong), ", uin=", bfii.a(paramString2), ", params[", ((StringBuilder)localObject).toString(), "]" });
    }
  }
  
  public static void a(String paramString1, String paramString2, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    try
    {
      a(paramString1, paramString2, System.currentTimeMillis(), paramHashMap, paramBoolean);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      a(paramString1, paramString2, null, paramBoolean);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static void a(String paramString, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    try
    {
      a(paramString, ((AppInterface)BaseApplicationImpl.sApplication.getRuntime()).getCurrentAccountUin(), paramHashMap, paramBoolean);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    try
    {
      a(paramString, ((AppInterface)BaseApplicationImpl.sApplication.getRuntime()).getCurrentAccountUin(), paramBoolean);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void b(String paramString)
  {
    try
    {
      a(paramString, true);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aseh
 * JD-Core Version:    0.7.0.1
 */