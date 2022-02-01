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

public class avcw
{
  private static Map<String, Long> a = new HashMap();
  
  static
  {
    aqfu localaqfu = new aqfu();
    localaqfu.jdField_a_of_type_JavaLangString = "OpenShare";
    localaqfu.b = "KEY_STAGE_1_TOTAL";
    localaqfu.c = "KEY_STAGE_2_TOTAL";
    localaqfu.jdField_a_of_type_Long = 30000L;
    localaqfu.jdField_a_of_type_JavaUtilSet = new ForwardStatisticsReporter.1();
    aqft.a("OpenShare", localaqfu);
    localaqfu = new aqfu();
    localaqfu.jdField_a_of_type_JavaLangString = "OpenLogin";
    localaqfu.b = "KEY_LOGIN_STAGE_1_TOTAL";
    localaqfu.c = "KEY_AUTHORITY_TOTAL";
    localaqfu.jdField_a_of_type_Long = 30000L;
    localaqfu.jdField_a_of_type_JavaUtilSet = new ForwardStatisticsReporter.2();
    aqft.a("OpenLogin", localaqfu);
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
      aqft.a(paramString, l);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public static void a(String paramString, long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 91	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   6: invokevirtual 95	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   9: checkcast 97	com/tencent/common/app/AppInterface
    //   12: astore_3
    //   13: aload_3
    //   14: ifnonnull +32 -> 46
    //   17: ldc 99
    //   19: iconst_1
    //   20: new 101	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   27: ldc 104
    //   29: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_0
    //   33: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: ldc 2
    //   44: monitorexit
    //   45: return
    //   46: aload_3
    //   47: invokevirtual 121	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   50: astore_3
    //   51: ldc 99
    //   53: iconst_1
    //   54: iconst_5
    //   55: anewarray 4	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: aload_0
    //   61: aastore
    //   62: dup
    //   63: iconst_1
    //   64: ldc 123
    //   66: aastore
    //   67: dup
    //   68: iconst_2
    //   69: lload_1
    //   70: invokestatic 78	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   73: aastore
    //   74: dup
    //   75: iconst_3
    //   76: ldc 125
    //   78: aastore
    //   79: dup
    //   80: iconst_4
    //   81: aload_3
    //   82: invokestatic 130	bjqq:a	(Ljava/lang/String;)Ljava/lang/String;
    //   85: aastore
    //   86: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   89: invokestatic 137	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   92: invokestatic 142	bdmc:a	(Landroid/content/Context;)Lbdmc;
    //   95: aload_3
    //   96: aload_0
    //   97: iconst_1
    //   98: lload_1
    //   99: lconst_0
    //   100: aconst_null
    //   101: ldc 144
    //   103: iconst_0
    //   104: invokevirtual 147	bdmc:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   107: aload_0
    //   108: iconst_1
    //   109: lload_1
    //   110: aconst_null
    //   111: invokestatic 150	aqft:a	(Ljava/lang/String;ZJLjava/util/HashMap;)V
    //   114: goto -72 -> 42
    //   117: astore_0
    //   118: ldc 2
    //   120: monitorexit
    //   121: aload_0
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramString	String
    //   0	123	1	paramLong	long
    //   12	84	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	13	117	finally
    //   17	42	117	finally
    //   46	114	117	finally
  }
  
  public static void a(String paramString, long paramLong, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    String str = ((AppInterface)BaseApplicationImpl.sApplication.getRuntime()).getCurrentAccountUin();
    QLog.d("ForwardStatisticsReporter", 1, new Object[] { "reportSaveImage key=", paramString, ",duration=", Long.valueOf(paramLong), ", uin=", bjqq.a(str) });
    bdmc.a(BaseApplicationImpl.getApplication()).a(str, paramString, paramBoolean, paramLong, 0L, paramHashMap, "", false);
    aqft.a(paramString, true, paramLong, paramHashMap);
  }
  
  public static void a(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_ERROR_CODE", Integer.toString(paramBundle.getInt("code")));
    localHashMap.put("param_error_ret", Integer.toString(paramBundle.getInt("ret")));
    a(paramString, localHashMap, paramBoolean);
  }
  
  public static void a(String paramString, bjzb parambjzb)
  {
    try
    {
      a(paramString, parambjzb, true);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void a(String paramString, bjzb parambjzb, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    if (parambjzb == null) {}
    for (parambjzb = "";; parambjzb = parambjzb.jdField_a_of_type_JavaLangString)
    {
      a(paramString, parambjzb, paramHashMap, paramBoolean);
      return;
    }
  }
  
  public static void a(String paramString, bjzb parambjzb, boolean paramBoolean)
  {
    try
    {
      a(paramString, parambjzb, null, paramBoolean);
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
          QLog.d("ForwardStatisticsReporter", 1, new Object[] { paramString1, "=", Long.valueOf(paramLong), ", uin=", bjqq.a(paramString2) });
          bdmc.a(BaseApplicationImpl.getApplication()).a(paramString2, paramString1, paramBoolean, paramLong, 0L, paramHashMap, "", false);
          aqft.a(paramString1, paramBoolean, paramLong, paramHashMap);
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
      QLog.d("ForwardStatisticsReporter", 1, new Object[] { paramString1, "=", Long.valueOf(paramLong), ", uin=", bjqq.a(paramString2), ", params[", ((StringBuilder)localObject).toString(), "]" });
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
 * Qualified Name:     avcw
 * JD-Core Version:    0.7.0.1
 */