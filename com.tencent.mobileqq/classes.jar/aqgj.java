import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class aqgj
{
  private static Map<String, Long> a = new HashMap();
  
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
      a.put(paramString, Long.valueOf(System.currentTimeMillis()));
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
      QLog.d("ForwardStatisticsReporter", 1, new Object[] { paramString, "=", Long.valueOf(paramLong), ", uin=", bdfb.a(str) });
      axrn.a(BaseApplicationImpl.getApplication()).a(str, paramString, true, paramLong, 0L, null, "", false);
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
    QLog.d("ForwardStatisticsReporter", 1, new Object[] { "reportSaveImage key=", paramString, ",duration=", Long.valueOf(paramLong), ", uin=", bdfb.a(str) });
    axrn.a(BaseApplicationImpl.getApplication()).a(str, paramString, paramBoolean, paramLong, 0L, paramHashMap, "", false);
  }
  
  public static void a(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_ERROR_CODE", Integer.toString(paramBundle.getInt("code")));
    localHashMap.put("param_error_ret", Integer.toString(paramBundle.getInt("ret")));
    a(paramString, localHashMap, paramBoolean);
  }
  
  public static void a(String paramString, bdnp parambdnp)
  {
    try
    {
      a(paramString, parambdnp, true);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void a(String paramString, bdnp parambdnp, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    if (parambdnp == null) {}
    for (parambdnp = "";; parambdnp = parambdnp.a)
    {
      a(paramString, parambdnp, paramHashMap, paramBoolean);
      return;
    }
  }
  
  public static void a(String paramString, bdnp parambdnp, boolean paramBoolean)
  {
    try
    {
      a(paramString, parambdnp, null, paramBoolean);
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
          QLog.d("ForwardStatisticsReporter", 1, new Object[] { paramString1, "=", Long.valueOf(paramLong), ", uin=", bdfb.a(paramString2) });
          axrn.a(BaseApplicationImpl.getApplication()).a(paramString2, paramString1, paramBoolean, paramLong, 0L, paramHashMap, "", false);
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
      QLog.d("ForwardStatisticsReporter", 1, new Object[] { paramString1, "=", Long.valueOf(paramLong), ", uin=", bdfb.a(paramString2), ", params[", ((StringBuilder)localObject).toString(), "]" });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqgj
 * JD-Core Version:    0.7.0.1
 */