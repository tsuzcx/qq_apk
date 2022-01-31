import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class aufg
{
  public static long a;
  public static String a;
  private static ConcurrentHashMap<String, Long> a;
  public static boolean a;
  public static long b;
  private static ConcurrentHashMap<String, Long> b;
  public static boolean b;
  public static long c;
  private static ConcurrentHashMap<Long, Long> c;
  public static long d;
  public static long e;
  public static long f;
  public static long g;
  public static long h;
  public static long i;
  public static long j;
  public static long k;
  public static long l;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_JavaLangString = "MsgBackup_timeStats";
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(new HashMap(8));
    jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(new HashMap(10));
    jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static void a()
  {
    auff.a();
    auff.a.jdField_a_of_type_Long = d;
    auff.a.p = g;
    String str1;
    String str2;
    if (auey.a().a() == 2)
    {
      auff.a.q = e;
      if (d > 0L) {
        auff.a.jdField_a_of_type_Double = (jdField_c_of_type_Long * 1000.0D / d);
      }
      if (jdField_a_of_type_Boolean)
      {
        str1 = aufh.a(jdField_b_of_type_Long);
        str2 = aufh.a(jdField_a_of_type_Long);
        if (d != 0L) {
          break label120;
        }
        aufh.b(jdField_a_of_type_JavaLangString, "transport speed error", new Object[0]);
      }
    }
    label120:
    do
    {
      return;
      auff.a.q = f;
      break;
      aufh.b(jdField_a_of_type_JavaLangString, "transport speed sSizeCache.size = %d, sLogs.size = %d", new Object[] { Integer.valueOf(jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size()), Integer.valueOf(jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size()) });
      long l1 = jdField_c_of_type_Long * 1000L / d;
      aufh.b(jdField_a_of_type_JavaLangString, "transport speed totalLength = %d B, totalElipse = %d ms", new Object[] { Long.valueOf(jdField_c_of_type_Long), Long.valueOf(d) });
      String str3 = aufh.a(l1);
      aufh.b(jdField_a_of_type_JavaLangString, "transport speed max = %s, min = %s, average = %s", new Object[] { str1, str2, str3 });
    } while (auey.a().a() != 2);
    aufh.b(jdField_a_of_type_JavaLangString, alpo.a(2131707298), new Object[] { Long.valueOf(e) });
  }
  
  public static void a(long paramLong)
  {
    if (jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong)))
    {
      Long localLong = (Long)jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      if (localLong != null)
      {
        aufh.b(jdField_a_of_type_JavaLangString, "transport complete complete = %d", new Object[] { localLong });
        long l1 = jdField_c_of_type_Long;
        jdField_c_of_type_Long = localLong.longValue() + l1;
      }
      jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
    }
  }
  
  public static void a(long paramLong1, long paramLong2)
  {
    jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
  }
  
  public static void a(String paramString)
  {
    jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
  }
  
  public static void a(String paramString1, String paramString2)
  {
    long l1;
    Long localLong;
    if (jdField_a_of_type_Boolean)
    {
      l1 = SystemClock.uptimeMillis();
      if (paramString1 != null)
      {
        localLong = (Long)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString1);
        if (localLong != null)
        {
          if (TextUtils.equals("total_transport_cost", paramString1)) {
            d = l1 - localLong.longValue();
          }
          if (TextUtils.equals("single_uin_cost", paramString1)) {
            e += l1 - localLong.longValue();
          }
          if (TextUtils.equals("total_daoru_cost", paramString1)) {
            f += l1 - localLong.longValue();
          }
          if (TextUtils.equals("cost_connect_total", paramString1)) {
            g += l1 - localLong.longValue();
          }
          if (!QLog.isColorLevel()) {
            break label178;
          }
          QLog.i(jdField_a_of_type_JavaLangString, 2, paramString1 + ", cost=" + (l1 - localLong.longValue()));
        }
      }
    }
    for (;;)
    {
      if (paramString2 != null) {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString2, Long.valueOf(l1));
      }
      return;
      label178:
      Log.i(jdField_a_of_type_JavaLangString, paramString1 + ", cost=" + (l1 - localLong.longValue()));
    }
  }
  
  public static void b()
  {
    aufh.b(jdField_a_of_type_JavaLangString, "transport reset", new Object[0]);
    jdField_b_of_type_Boolean = false;
    jdField_c_of_type_Long = 0L;
    jdField_a_of_type_Long = 0L;
    jdField_b_of_type_Long = 0L;
    jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public static void b(long paramLong1, long paramLong2)
  {
    if (!jdField_b_of_type_Boolean)
    {
      jdField_a_of_type_Long = paramLong2;
      jdField_b_of_type_Boolean = true;
    }
    aufh.b(jdField_a_of_type_JavaLangString, "transport increment = %d sMaxSpeed = %d, sMinSpeed = %d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(jdField_b_of_type_Long), Long.valueOf(jdField_a_of_type_Long) });
    aufh.b(jdField_a_of_type_JavaLangString, "transport storeSpeed increment = %s", new Object[] { aufh.a(paramLong2) });
    if (paramLong2 >= jdField_b_of_type_Long) {
      jdField_b_of_type_Long = paramLong2;
    }
    if (paramLong2 <= jdField_a_of_type_Long) {
      jdField_a_of_type_Long = paramLong2;
    }
  }
  
  public static void c()
  {
    h = 0L;
    i = 0L;
    j = 0L;
    k = 0L;
    l = 0L;
    jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public static void d()
  {
    if ((jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey("statis_qianchums_start")) && (jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey("statis_qianchums_end")))
    {
      long l1 = ((Long)jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get("statis_qianchums_start")).longValue();
      h = ((Long)jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get("statis_qianchums_end")).longValue() - l1;
      aufh.b(jdField_a_of_type_JavaLangString, "pure qianchu time cost = %d,pb_pack cost time = %d ", new Object[] { Long.valueOf(h), Long.valueOf(i) });
    }
  }
  
  public static void e()
  {
    if ((jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey("statis_qianchums_start")) && (jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey("statis_qianchums_end")))
    {
      long l1 = ((Long)jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get("statis_qianchums_start")).longValue();
      l = ((Long)jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get("statis_qianchums_end")).longValue() - l1 + l;
    }
  }
  
  public static void f()
  {
    if ((jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey("statis_qianchums_start")) && (jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey("statis_qianchums_end")))
    {
      long l1 = ((Long)jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get("statis_qianchums_start")).longValue();
      j = ((Long)jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get("statis_qianchums_end")).longValue() - l1;
      aufh.b(jdField_a_of_type_JavaLangString, "pure qianru time cost = %d ", new Object[] { Long.valueOf(l) });
      aufh.b(jdField_a_of_type_JavaLangString, "pure daoru time cost = %d,pb_unpack cost time = %d ", new Object[] { Long.valueOf(j), Long.valueOf(k) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aufg
 * JD-Core Version:    0.7.0.1
 */