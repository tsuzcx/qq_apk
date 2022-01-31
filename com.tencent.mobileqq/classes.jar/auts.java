import android.util.SparseIntArray;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil.1;
import com.tencent.mobileqq.shortvideo.dancemachine.BoyDataReport;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.text.SimpleDateFormat;
import java.util.Date;

public class auts
{
  public static int a;
  public static long a;
  public static final SparseIntArray a;
  public static String a;
  public static boolean a;
  public static String b;
  public static boolean b;
  public static String c;
  public static boolean c;
  public static String d;
  public static boolean d;
  public static String e;
  public static boolean e;
  
  static
  {
    jdField_a_of_type_Int = -1;
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_JavaLangString = "";
    jdField_c_of_type_JavaLangString = "";
    jdField_d_of_type_JavaLangString = "";
    jdField_e_of_type_JavaLangString = "";
    jdField_a_of_type_Long = -1L;
    jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
    jdField_a_of_type_AndroidUtilSparseIntArray.put(10000, 1);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(10004, 2);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(10001, 3);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(10002, 4);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(10007, 5);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(10003, 6);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(10012, 7);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(10013, 8);
  }
  
  public static awtr a()
  {
    awtr localawtr = new awtr();
    localawtr.jdField_a_of_type_JavaLangString = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    localawtr.jdField_b_of_type_JavaLangString = "";
    localawtr.jdField_c_of_type_JavaLangString = "";
    localawtr.jdField_d_of_type_JavaLangString = "";
    localawtr.jdField_a_of_type_Int = jdField_a_of_type_AndroidUtilSparseIntArray.get(jdField_a_of_type_Int, -1);
    localawtr.jdField_e_of_type_JavaLangString = "${count_unknown}";
    localawtr.f = "";
    localawtr.g = "";
    localawtr.h = "";
    localawtr.i = "";
    localawtr.j = "";
    localawtr.k = "";
    localawtr.l = "";
    localawtr.m = "";
    localawtr.n = "";
    localawtr.o = "";
    localawtr.p = "";
    localawtr.q = "";
    localawtr.r = "";
    localawtr.s = "";
    localawtr.t = "";
    localawtr.u = "";
    return localawtr;
  }
  
  public static void a()
  {
    awtr localawtr = a();
    localawtr.jdField_c_of_type_JavaLangString = "0X8008423";
    localawtr.jdField_d_of_type_JavaLangString = "0X8008423";
    awpt.a(null, localawtr);
  }
  
  public static void a(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    awtr localawtr = a();
    localawtr.jdField_c_of_type_JavaLangString = "0X8008754";
    localawtr.jdField_d_of_type_JavaLangString = "0X8008754";
    localawtr.n = String.valueOf(paramInt);
    awpt.a(null, localawtr);
  }
  
  public static void a(int paramInt, String paramString)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    awtr localawtr = a();
    localawtr.jdField_c_of_type_JavaLangString = "0X8008430";
    localawtr.jdField_d_of_type_JavaLangString = "0X8008430";
    localawtr.jdField_b_of_type_JavaLangString = paramString;
    if (localawtr.jdField_a_of_type_Int == 5) {
      localawtr.g = jdField_a_of_type_JavaLangString;
    }
    localawtr.h = jdField_b_of_type_JavaLangString;
    localawtr.i = jdField_c_of_type_JavaLangString;
    localawtr.j = jdField_d_of_type_JavaLangString;
    localawtr.k = jdField_e_of_type_JavaLangString;
    localawtr.l = (paramInt + "");
    localawtr.n = "";
    paramString = new StringBuilder();
    if (jdField_d_of_type_Boolean) {}
    for (int i = 2;; i = 1)
    {
      localawtr.m = (i + "");
      awpt.a(null, localawtr);
      if (jdField_a_of_type_Boolean)
      {
        localawtr.jdField_c_of_type_JavaLangString = "0X80083B2";
        localawtr.jdField_d_of_type_JavaLangString = "0X80083B2";
        awpt.a(null, localawtr);
      }
      QmcfManager.getInstance().reportQmcfFrameConsume(paramInt, jdField_a_of_type_Int, jdField_e_of_type_JavaLangString);
      return;
    }
  }
  
  public static void a(long paramLong, int paramInt)
  {
    if (jdField_b_of_type_Boolean)
    {
      awtr localawtr = a();
      localawtr.jdField_c_of_type_JavaLangString = "0X800893A";
      localawtr.jdField_d_of_type_JavaLangString = "0X800893A";
      localawtr.h = jdField_b_of_type_JavaLangString;
      localawtr.i = jdField_c_of_type_JavaLangString;
      localawtr.f = (paramInt + "");
      if (localawtr.jdField_a_of_type_Int == 5) {
        localawtr.g = jdField_a_of_type_JavaLangString;
      }
      localawtr.o = ((float)paramLong / 1000.0F + "");
      awpt.a(null, localawtr);
    }
  }
  
  public static void a(bigb parambigb)
  {
    if ((parambigb != null) && (parambigb.a != null) && (parambigb.a.jdField_a_of_type_Int == 14)) {
      if (parambigb.a()) {
        break label57;
      }
    }
    label57:
    for (int i = 1;; i = 2)
    {
      awqx.b(null, "dc00898", "", "", "0X800A55F", "0X800A55F", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void a(bigb parambigb, bivl parambivl)
  {
    if (parambivl == null) {}
    while ((parambigb == null) || (parambigb.a == null) || (parambigb.a.jdField_a_of_type_Int != 14)) {
      return;
    }
    if (parambivl.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      awqx.b(null, "dc00898", "", "", "0X800A55C", "0X800A55C", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void a(bivl parambivl)
  {
    c(null, parambivl);
  }
  
  public static void a(BoyDataReport paramBoyDataReport)
  {
    if (paramBoyDataReport != null) {
      ThreadManager.post(new CaptureReportUtil.1(paramBoyDataReport), 5, null, false);
    }
  }
  
  public static void a(String paramString)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    awtr localawtr = a();
    localawtr.jdField_c_of_type_JavaLangString = "0X8008425";
    localawtr.jdField_d_of_type_JavaLangString = "0X8008425";
    localawtr.h = paramString;
    awpt.a(null, localawtr);
  }
  
  public static void a(String paramString, long paramLong)
  {
    awtr localawtr = a();
    localawtr.jdField_c_of_type_JavaLangString = "0X8008939";
    localawtr.jdField_d_of_type_JavaLangString = "0X8008939";
    localawtr.h = jdField_b_of_type_JavaLangString;
    localawtr.i = jdField_c_of_type_JavaLangString;
    if (localawtr.jdField_a_of_type_Int == 5) {
      localawtr.g = jdField_a_of_type_JavaLangString;
    }
    localawtr.j = paramString;
    localawtr.o = ((float)paramLong / 1000.0F + "");
    awpt.a(null, localawtr);
  }
  
  private static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknown";
    case 0: 
      return "miss";
    case 1: 
      return "good";
    case 2: 
      return "great";
    }
    return "perfect";
  }
  
  public static void b()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    awtr localawtr = a();
    localawtr.jdField_c_of_type_JavaLangString = "0X8008424";
    localawtr.jdField_d_of_type_JavaLangString = "0X8008424";
    awpt.a(null, localawtr);
  }
  
  public static void b(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    awtr localawtr = a();
    localawtr.jdField_c_of_type_JavaLangString = "0X8008429";
    localawtr.jdField_d_of_type_JavaLangString = "0X8008429";
    localawtr.f = (paramInt + "");
    awpt.a(null, localawtr);
  }
  
  public static void b(int paramInt, String paramString)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    awtr localawtr = a();
    localawtr.jdField_c_of_type_JavaLangString = "0X8008433";
    localawtr.jdField_d_of_type_JavaLangString = "0X8008433";
    localawtr.jdField_b_of_type_JavaLangString = paramString;
    localawtr.h = jdField_b_of_type_JavaLangString;
    localawtr.i = jdField_c_of_type_JavaLangString;
    localawtr.j = jdField_d_of_type_JavaLangString;
    localawtr.k = jdField_e_of_type_JavaLangString;
    if (localawtr.jdField_a_of_type_Int == 5) {
      localawtr.g = jdField_a_of_type_JavaLangString;
    }
    localawtr.l = (paramInt + "");
    paramString = new StringBuilder();
    if (jdField_c_of_type_Boolean) {}
    for (int i = 2;; i = 1)
    {
      localawtr.m = (i + "");
      localawtr.n = String.valueOf(ahmp.a().c);
      localawtr.o = (jdField_a_of_type_Long + "");
      awpt.a(null, localawtr);
      if (jdField_a_of_type_Boolean)
      {
        localawtr.jdField_c_of_type_JavaLangString = "0X80083B1";
        localawtr.jdField_d_of_type_JavaLangString = "0X80083B1";
        awpt.a(null, localawtr);
      }
      QmcfManager.getInstance().reportQmcfFrameConsume(paramInt, jdField_a_of_type_Int, jdField_e_of_type_JavaLangString);
      return;
    }
  }
  
  private static void b(long paramLong1, long paramLong2)
  {
    awtr localawtr = a();
    localawtr.jdField_c_of_type_JavaLangString = "0X8008937";
    localawtr.jdField_d_of_type_JavaLangString = "0X8008937";
    localawtr.h = jdField_b_of_type_JavaLangString;
    localawtr.i = jdField_c_of_type_JavaLangString;
    localawtr.j = ("" + paramLong1);
    if (localawtr.jdField_a_of_type_Int == 5) {
      localawtr.g = jdField_a_of_type_JavaLangString;
    }
    localawtr.o = (paramLong2 / 1000L + "");
    awpt.a(null, localawtr);
  }
  
  public static void b(bigb parambigb)
  {
    if ((parambigb != null) && (parambigb.a != null) && (parambigb.a.jdField_a_of_type_Int == 14)) {
      if (parambigb.a()) {
        break label59;
      }
    }
    label59:
    for (int i = 1;; i = 2)
    {
      awqx.b(null, "dc00898", "", "", "0X800A55E", "0X800A55E", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void b(bigb parambigb, bivl parambivl)
  {
    if (parambivl == null) {}
    while ((parambigb == null) || (parambigb.a == null) || (parambigb.a.jdField_a_of_type_Int != 14)) {
      return;
    }
    if (parambivl.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      awqx.b(null, "dc00898", "", "", "0X800A55B", "0X800A55B", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void b(String paramString)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    awtr localawtr = a();
    localawtr.jdField_c_of_type_JavaLangString = "0X8008427";
    localawtr.jdField_d_of_type_JavaLangString = "0X8008427";
    localawtr.j = paramString;
    awpt.a(null, localawtr);
  }
  
  private static void b(String paramString1, String paramString2, String paramString3)
  {
    awtr localawtr = a();
    localawtr.jdField_c_of_type_JavaLangString = "0X8008936";
    localawtr.jdField_d_of_type_JavaLangString = "0X8008936";
    localawtr.h = jdField_b_of_type_JavaLangString;
    localawtr.i = jdField_c_of_type_JavaLangString;
    localawtr.j = paramString2;
    localawtr.k = paramString1;
    if (localawtr.jdField_a_of_type_Int == 5) {
      localawtr.g = jdField_a_of_type_JavaLangString;
    }
    localawtr.l = paramString3;
    awpt.a(null, localawtr);
  }
  
  public static void c()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    awtr localawtr = a();
    localawtr.jdField_c_of_type_JavaLangString = "0X8008753";
    localawtr.jdField_d_of_type_JavaLangString = "0X8008753";
    awpt.a(null, localawtr);
  }
  
  public static void c(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    awtr localawtr = a();
    localawtr.f = (paramInt + "");
    localawtr.jdField_c_of_type_JavaLangString = "0X800842B";
    localawtr.jdField_d_of_type_JavaLangString = "0X800842B";
    awpt.a(null, localawtr);
  }
  
  public static void c(bigb parambigb)
  {
    if ((parambigb != null) && (parambigb.a != null) && (parambigb.a.jdField_a_of_type_Int == 14)) {
      awqx.b(null, "dc00898", "", "", "0X800A55D", "0X800A55D", 0, 0, "", "", "", "");
    }
  }
  
  public static void c(bigb parambigb, bivl parambivl)
  {
    int i = 1;
    if (parambivl == null) {}
    while ((parambigb != null) && (parambigb.a != null) && (parambigb.a.jdField_a_of_type_Int != 14)) {
      return;
    }
    if (parambivl.jdField_a_of_type_Int == 1)
    {
      parambigb = "2";
      if (!parambivl.jdField_a_of_type_Boolean) {
        break label96;
      }
    }
    for (;;)
    {
      awqx.b(null, "dc00898", "", "", "0X800A55A", "0X800A55A", i, 0, parambigb, "", "", "");
      return;
      if (parambivl.jdField_a_of_type_Int == 0)
      {
        parambigb = "1";
        break;
      }
      parambigb = "3";
      break;
      label96:
      i = 2;
    }
  }
  
  public static void c(String paramString)
  {
    awtr localawtr = a();
    localawtr.jdField_c_of_type_JavaLangString = "0X8008938";
    localawtr.jdField_d_of_type_JavaLangString = "0X8008938";
    localawtr.h = jdField_b_of_type_JavaLangString;
    localawtr.i = jdField_c_of_type_JavaLangString;
    if (localawtr.jdField_a_of_type_Int == 5) {
      localawtr.g = jdField_a_of_type_JavaLangString;
    }
    localawtr.j = paramString;
    awpt.a(null, localawtr);
  }
  
  public static void d()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    awtr localawtr = a();
    localawtr.jdField_c_of_type_JavaLangString = "0X8008426";
    localawtr.jdField_d_of_type_JavaLangString = "0X8008426";
    awpt.a(null, localawtr);
  }
  
  public static void d(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    awtr localawtr = a();
    localawtr.f = (paramInt + "");
    localawtr.jdField_c_of_type_JavaLangString = "0X800842C";
    localawtr.jdField_d_of_type_JavaLangString = "0X800842C";
    awpt.a(null, localawtr);
  }
  
  public static void d(bigb parambigb)
  {
    if ((parambigb != null) && (parambigb.a != null) && (parambigb.a.jdField_a_of_type_Int == 14)) {
      if (parambigb.a()) {
        break label59;
      }
    }
    label59:
    for (int i = 1;; i = 2)
    {
      awqx.b(null, "dc00898", "", "", "0X800A559", "0X800A559", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void e()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    awtr localawtr = a();
    localawtr.jdField_c_of_type_JavaLangString = "0X8008428";
    localawtr.jdField_d_of_type_JavaLangString = "0X8008428";
    awpt.a(null, localawtr);
  }
  
  public static void e(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {}
    awtr localawtr;
    do
    {
      return;
      localawtr = a();
      localawtr.jdField_c_of_type_JavaLangString = "0X800842D";
      localawtr.jdField_d_of_type_JavaLangString = "0X800842D";
      if (localawtr.jdField_a_of_type_Int == 5) {
        localawtr.g = jdField_a_of_type_JavaLangString;
      }
      localawtr.h = jdField_b_of_type_JavaLangString;
      localawtr.i = jdField_c_of_type_JavaLangString;
      localawtr.j = jdField_d_of_type_JavaLangString;
      localawtr.k = jdField_e_of_type_JavaLangString;
      localawtr.g = jdField_a_of_type_JavaLangString;
      localawtr.l = (paramInt + "");
      awpt.a(null, localawtr);
    } while (!jdField_a_of_type_Boolean);
    localawtr.jdField_c_of_type_JavaLangString = "0X80083AE";
    localawtr.jdField_d_of_type_JavaLangString = "0X80083AE";
    awpt.a(null, localawtr);
  }
  
  public static void e(bigb parambigb)
  {
    if ((parambigb != null) && (parambigb.a != null) && (parambigb.a.jdField_a_of_type_Int == 14)) {
      awqx.b(null, "dc00898", "", "", "0X800A558", "0X800A558", 0, 0, "", "", "", "");
    }
  }
  
  public static void f()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    awtr localawtr = a();
    localawtr.jdField_c_of_type_JavaLangString = "0X800842A";
    localawtr.jdField_d_of_type_JavaLangString = "0X800842A";
    awpt.a(null, localawtr);
  }
  
  public static void f(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {}
    awtr localawtr;
    do
    {
      return;
      localawtr = a();
      localawtr.jdField_c_of_type_JavaLangString = "0X800842D";
      localawtr.jdField_d_of_type_JavaLangString = "0X800842D";
      if (localawtr.jdField_a_of_type_Int == 5) {
        localawtr.g = jdField_a_of_type_JavaLangString;
      }
      localawtr.h = jdField_b_of_type_JavaLangString;
      localawtr.i = jdField_c_of_type_JavaLangString;
      localawtr.j = jdField_d_of_type_JavaLangString;
      localawtr.k = jdField_e_of_type_JavaLangString;
      localawtr.l = (paramInt + "");
      awpt.a(null, localawtr);
    } while (!jdField_a_of_type_Boolean);
    localawtr.jdField_c_of_type_JavaLangString = "0X80083AE";
    localawtr.jdField_d_of_type_JavaLangString = "0X80083AE";
    awpt.a(null, localawtr);
  }
  
  public static void f(bigb parambigb)
  {
    if ((parambigb != null) && (parambigb.a != null) && (parambigb.a.jdField_a_of_type_Int == 14)) {
      awqx.b(null, "dc00898", "", "", "0X800A557", "0X800A557", 0, 0, "", "", "", "");
    }
  }
  
  public static void g()
  {
    if (jdField_a_of_type_Int == 10002) {
      urp.a("video_edit", "camera_clkdouble", 0, 0, new String[0]);
    }
  }
  
  public static void g(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {}
    awtr localawtr;
    do
    {
      return;
      localawtr = a();
      localawtr.jdField_c_of_type_JavaLangString = "0X800842E";
      localawtr.jdField_d_of_type_JavaLangString = "0X800842E";
      if (localawtr.jdField_a_of_type_Int == 5) {
        localawtr.g = jdField_a_of_type_JavaLangString;
      }
      localawtr.h = jdField_b_of_type_JavaLangString;
      localawtr.i = jdField_c_of_type_JavaLangString;
      localawtr.j = jdField_d_of_type_JavaLangString;
      localawtr.k = jdField_e_of_type_JavaLangString;
      localawtr.l = (paramInt + "");
      awpt.a(null, localawtr);
    } while (!jdField_a_of_type_Boolean);
    localawtr.jdField_c_of_type_JavaLangString = "0X80083B0";
    localawtr.jdField_d_of_type_JavaLangString = "0X80083B0";
    awpt.a(null, localawtr);
  }
  
  public static void g(bigb parambigb)
  {
    if ((parambigb != null) && (parambigb.a != null) && (parambigb.a.jdField_a_of_type_Int == 14)) {
      awqx.b(null, "dc00898", "", "", "0X800A556", "0X800A556", 0, 0, "", "", "", "");
    }
  }
  
  public static void h()
  {
    awtr localawtr = a();
    localawtr.jdField_c_of_type_JavaLangString = "0X8008F10";
    localawtr.jdField_d_of_type_JavaLangString = "0X8008F10";
    awpt.a(null, localawtr);
  }
  
  public static void h(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    awtr localawtr = a();
    localawtr.jdField_c_of_type_JavaLangString = "0X800842F";
    localawtr.jdField_d_of_type_JavaLangString = "0X800842F";
    if (localawtr.jdField_a_of_type_Int == 5) {
      localawtr.g = jdField_a_of_type_JavaLangString;
    }
    localawtr.h = jdField_b_of_type_JavaLangString;
    localawtr.i = jdField_c_of_type_JavaLangString;
    localawtr.j = jdField_d_of_type_JavaLangString;
    localawtr.k = jdField_e_of_type_JavaLangString;
    localawtr.l = (paramInt + "");
    StringBuilder localStringBuilder = new StringBuilder();
    if (jdField_d_of_type_Boolean) {}
    for (paramInt = 2;; paramInt = 1)
    {
      localawtr.m = (paramInt + "");
      awpt.a(null, localawtr);
      return;
    }
  }
  
  public static void h(bigb parambigb)
  {
    if ((parambigb != null) && (parambigb.a != null) && (parambigb.a.jdField_a_of_type_Int == 14)) {
      awqx.b(null, "dc00898", "", "", "0X800A555", "0X800A555", 0, 0, "", "", "", "");
    }
  }
  
  public static void i()
  {
    jdField_a_of_type_Int = -1;
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_JavaLangString = "";
    jdField_c_of_type_JavaLangString = "";
    jdField_d_of_type_JavaLangString = "";
    jdField_e_of_type_JavaLangString = "";
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    jdField_a_of_type_Long = -1L;
    jdField_d_of_type_Boolean = false;
    jdField_c_of_type_Boolean = false;
    jdField_e_of_type_Boolean = false;
  }
  
  public static void i(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {}
    awtr localawtr;
    do
    {
      return;
      localawtr = a();
      localawtr.jdField_c_of_type_JavaLangString = "0X8008431";
      localawtr.jdField_d_of_type_JavaLangString = "0X8008431";
      if (localawtr.jdField_a_of_type_Int == 5) {
        localawtr.g = jdField_a_of_type_JavaLangString;
      }
      localawtr.h = jdField_b_of_type_JavaLangString;
      localawtr.i = jdField_c_of_type_JavaLangString;
      localawtr.j = jdField_d_of_type_JavaLangString;
      localawtr.k = jdField_e_of_type_JavaLangString;
      localawtr.l = (paramInt + "");
      localawtr.n = String.valueOf(ahmp.a().c);
      localawtr.o = (jdField_a_of_type_Long + "");
      awpt.a(null, localawtr);
    } while (!jdField_a_of_type_Boolean);
    localawtr.jdField_c_of_type_JavaLangString = "0X80083AF";
    localawtr.jdField_d_of_type_JavaLangString = "0X80083AF";
    awpt.a(null, localawtr);
  }
  
  public static void j(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    awtr localawtr = a();
    localawtr.jdField_c_of_type_JavaLangString = "0X8008432";
    localawtr.jdField_d_of_type_JavaLangString = "0X8008432";
    localawtr.h = jdField_b_of_type_JavaLangString;
    localawtr.i = jdField_c_of_type_JavaLangString;
    localawtr.j = jdField_d_of_type_JavaLangString;
    localawtr.k = jdField_e_of_type_JavaLangString;
    if (localawtr.jdField_a_of_type_Int == 5) {
      localawtr.g = jdField_a_of_type_JavaLangString;
    }
    localawtr.l = (paramInt + "");
    StringBuilder localStringBuilder = new StringBuilder();
    if (jdField_c_of_type_Boolean) {}
    for (paramInt = 2;; paramInt = 1)
    {
      localawtr.m = (paramInt + "");
      localawtr.n = String.valueOf(ahmp.a().c);
      localawtr.o = (jdField_a_of_type_Long + "");
      awpt.a(null, localawtr);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     auts
 * JD-Core Version:    0.7.0.1
 */