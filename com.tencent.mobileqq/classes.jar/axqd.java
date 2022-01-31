import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class axqd
{
  private static volatile int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  private static HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static volatile boolean jdField_a_of_type_Boolean;
  private static volatile int jdField_b_of_type_Int;
  private static boolean jdField_b_of_type_Boolean;
  private static volatile int jdField_c_of_type_Int;
  private static boolean jdField_c_of_type_Boolean = true;
  private static volatile int d;
  private static volatile int e;
  private static volatile int f;
  private static volatile int g;
  private static volatile int h;
  private static volatile int i;
  private static volatile int j;
  private static volatile int k;
  private static volatile int l;
  
  private static long a(int paramInt1, String paramString, int paramInt2, long paramLong)
  {
    paramString = a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramInt1, paramString, paramInt2);
    if (jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
      paramLong = ((Long)jdField_a_of_type_JavaUtilHashMap.get(paramString)).longValue();
    }
    return paramLong;
  }
  
  private static String a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    return String.format("%d_%s_%d_%s", new Object[] { Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt2), paramString1 });
  }
  
  public static void a()
  {
    if (!jdField_a_of_type_Boolean) {
      c();
    }
    if (!jdField_b_of_type_Boolean) {}
    while (System.currentTimeMillis() - jdField_a_of_type_Long <= 86400000L) {
      return;
    }
    if (jdField_c_of_type_Boolean) {
      QLog.d("FightMsgReporter", 1, "report.value:" + String.format("%b_%d_%d_%d_%d_%d_%d_%d_%d", new Object[] { Boolean.valueOf(jdField_b_of_type_Boolean), Integer.valueOf(jdField_b_of_type_Int), Integer.valueOf(jdField_a_of_type_Int), Integer.valueOf(e), Integer.valueOf(d), Integer.valueOf(h), Integer.valueOf(g), Integer.valueOf(k), Integer.valueOf(j) }));
    }
    axqw.a(null, "dc00898", "", "", "0X800A95A", "0X800A95A", 0, jdField_b_of_type_Int, "", "", "", "");
    axqw.a(null, "dc00898", "", "", "0X800A95A", "0X800A95A", 0, jdField_a_of_type_Int, "", "", "", "");
    axqw.a(null, "dc00898", "", "", "0X800A95A", "0X800A95B", 0, h, "" + k, "", "", "");
    axqw.a(null, "dc00898", "", "", "0X800A95A", "0X800A95B", 0, g, "" + j, "", "", "");
    jdField_b_of_type_Int = 0;
    jdField_a_of_type_Int = 0;
    jdField_c_of_type_Int = 0;
    e = 0;
    d = 0;
    f = 0;
    h = 0;
    g = 0;
    i = 0;
    k = 0;
    j = 0;
    l = 0;
    b();
  }
  
  private static void a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 0: 
      jdField_b_of_type_Int += paramInt2;
      return;
    case 1: 
      jdField_a_of_type_Int += paramInt2;
      return;
    }
    jdField_c_of_type_Int += paramInt2;
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((!jdField_b_of_type_Boolean) || (!jdField_a_of_type_Boolean)) {
      return;
    }
    int m;
    switch (paramInt3)
    {
    default: 
      m = 2;
      label39:
      if (paramInt1 == 0)
      {
        if (paramInt2 == 0) {
          b(m, paramInt4);
        }
      }
      else {
        label53:
        if (paramInt1 == 1)
        {
          if (paramInt2 != 0) {
            break label135;
          }
          d(m, paramInt4);
        }
      }
      break;
    }
    while (jdField_c_of_type_Boolean)
    {
      QLog.d("FightMsgReporter", 1, "add count = " + paramInt4 + ",uinType = " + paramInt3);
      return;
      m = 0;
      break label39;
      m = 1;
      break label39;
      if (paramInt2 != 1) {
        break label53;
      }
      a(m, paramInt4);
      break label53;
      label135:
      if (paramInt2 == 1) {
        c(m, paramInt4);
      }
    }
  }
  
  private static void a(int paramInt1, String paramString, int paramInt2, long paramLong)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    paramString = a(str, paramInt1, paramString, paramInt2);
    jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(paramLong));
    bbjn.a(localBaseApplication, "f_msg_report_preference", str, false, paramString, Long.valueOf(paramLong));
  }
  
  public static void a(String paramString, long paramLong1, long paramLong2)
  {
    if (!jdField_b_of_type_Boolean) {}
    long l1;
    int m;
    do
    {
      return;
      if (!jdField_a_of_type_Boolean) {
        c();
      }
      l1 = a(0, paramString, 1, paramLong2);
      m = (int)(paramLong1 - Math.max(l1, paramLong2));
      a(0, 1, 1, m);
      a(0, paramString, 1, paramLong1);
    } while (!jdField_c_of_type_Boolean);
    QLog.d("FightMsgReporter", 1, "computeTroopMsgNew.value:" + String.format("%s_%d_%d_%d_%d", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(l1), Integer.valueOf(m) }));
  }
  
  public static void b()
  {
    if ((!jdField_b_of_type_Boolean) || (!jdField_a_of_type_Boolean)) {}
    do
    {
      return;
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      bbjn.a(localBaseApplication, "f_msg_report_preference", str, false, "key_msg_funnel_report_new_friend", Integer.valueOf(jdField_b_of_type_Int));
      bbjn.a(localBaseApplication, "f_msg_report_preference", str, false, "key_msg_funnel_report_new_troop", Integer.valueOf(jdField_a_of_type_Int));
      bbjn.a(localBaseApplication, "f_msg_report_preference", str, false, "key_msg_funnel_report_new_other", Integer.valueOf(jdField_c_of_type_Int));
      bbjn.a(localBaseApplication, "f_msg_report_preference", str, false, "key_msg_funnel_report_new_friend_aio", Integer.valueOf(e));
      bbjn.a(localBaseApplication, "f_msg_report_preference", str, false, "key_msg_funnel_report_new_troop_aio", Integer.valueOf(d));
      bbjn.a(localBaseApplication, "f_msg_report_preference", str, false, "key_msg_funnel_report_new_other_aio", Integer.valueOf(f));
      bbjn.a(localBaseApplication, "f_msg_report_preference", str, false, "key_msg_funnel_report_readed_friend", Integer.valueOf(h));
      bbjn.a(localBaseApplication, "f_msg_report_preference", str, false, "key_msg_funnel_report_readed_troop", Integer.valueOf(g));
      bbjn.a(localBaseApplication, "f_msg_report_preference", str, false, "key_msg_funnel_report_readed_other", Integer.valueOf(i));
      bbjn.a(localBaseApplication, "f_msg_report_preference", str, false, "key_msg_funnel_report_readed_friend_aio", Integer.valueOf(k));
      bbjn.a(localBaseApplication, "f_msg_report_preference", str, false, "key_msg_funnel_report_readed_troop_aio", Integer.valueOf(j));
      bbjn.a(localBaseApplication, "f_msg_report_preference", str, false, "key_msg_funnel_report_readed_other_aio", Integer.valueOf(l));
    } while (!jdField_c_of_type_Boolean);
    QLog.d("FightMsgReporter", 1, "saveToSp.value:" + String.format("%b_%d_%d_%d_%d_%d_%d_%d_%d", new Object[] { Boolean.valueOf(jdField_b_of_type_Boolean), Integer.valueOf(jdField_b_of_type_Int), Integer.valueOf(jdField_a_of_type_Int), Integer.valueOf(e), Integer.valueOf(d), Integer.valueOf(h), Integer.valueOf(g), Integer.valueOf(k), Integer.valueOf(j) }));
  }
  
  private static void b(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 0: 
      e += paramInt2;
      return;
    case 1: 
      d += paramInt2;
      return;
    }
    f += paramInt2;
  }
  
  private static void c()
  {
    axqn localaxqn = (axqn)ampm.a().a(577);
    if (localaxqn != null) {
      jdField_b_of_type_Boolean = localaxqn.jdField_a_of_type_Boolean;
    }
    jdField_b_of_type_Int = ((Integer)bbjn.a("key_msg_funnel_report_new_friend", Integer.valueOf(0))).intValue();
    jdField_a_of_type_Int = ((Integer)bbjn.a("key_msg_funnel_report_new_troop", Integer.valueOf(0))).intValue();
    jdField_c_of_type_Int = ((Integer)bbjn.a("key_msg_funnel_report_new_other", Integer.valueOf(0))).intValue();
    e = ((Integer)bbjn.a("key_msg_funnel_report_new_friend_aio", Integer.valueOf(0))).intValue();
    d = ((Integer)bbjn.a("key_msg_funnel_report_new_troop_aio", Integer.valueOf(0))).intValue();
    f = ((Integer)bbjn.a("key_msg_funnel_report_new_other_aio", Integer.valueOf(0))).intValue();
    h = ((Integer)bbjn.a("key_msg_funnel_report_readed_friend", Integer.valueOf(0))).intValue();
    g = ((Integer)bbjn.a("key_msg_funnel_report_readed_troop", Integer.valueOf(0))).intValue();
    i = ((Integer)bbjn.a("key_msg_funnel_report_readed_other", Integer.valueOf(0))).intValue();
    k = ((Integer)bbjn.a("key_msg_funnel_report_readed_friend_aio", Integer.valueOf(0))).intValue();
    j = ((Integer)bbjn.a("key_msg_funnel_report_readed_troop_aio", Integer.valueOf(0))).intValue();
    l = ((Integer)bbjn.a("key_msg_funnel_report_readed_other_aio", Integer.valueOf(0))).intValue();
    jdField_a_of_type_Long = ((Long)bbjn.a("key_msg_report_time", Long.valueOf(System.currentTimeMillis()))).longValue();
    if (jdField_c_of_type_Boolean) {
      QLog.d("FightMsgReporter", 1, "init.value:" + String.format("%b_%d_%d_%d_%d_%d_%d_%d_%d", new Object[] { Boolean.valueOf(jdField_b_of_type_Boolean), Integer.valueOf(jdField_b_of_type_Int), Integer.valueOf(jdField_a_of_type_Int), Integer.valueOf(e), Integer.valueOf(d), Integer.valueOf(h), Integer.valueOf(g), Integer.valueOf(k), Integer.valueOf(j) }));
    }
    jdField_a_of_type_Boolean = true;
  }
  
  private static void c(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 0: 
      h += paramInt2;
      return;
    case 1: 
      g += paramInt2;
      return;
    }
    i += paramInt2;
  }
  
  private static void d(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 0: 
      k += paramInt2;
      return;
    case 1: 
      j += paramInt2;
      return;
    }
    l += paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axqd
 * JD-Core Version:    0.7.0.1
 */