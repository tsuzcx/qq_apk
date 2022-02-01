import android.util.SparseIntArray;
import com.tencent.mobileqq.qmcf.QmcfManager;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.text.SimpleDateFormat;
import java.util.Date;

public class babc
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
  
  public static bcga a()
  {
    bcga localbcga = new bcga();
    localbcga.jdField_a_of_type_JavaLangString = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    localbcga.jdField_b_of_type_JavaLangString = "";
    localbcga.jdField_c_of_type_JavaLangString = "";
    localbcga.jdField_d_of_type_JavaLangString = "";
    localbcga.jdField_a_of_type_Int = jdField_a_of_type_AndroidUtilSparseIntArray.get(jdField_a_of_type_Int, -1);
    localbcga.jdField_e_of_type_JavaLangString = "${count_unknown}";
    localbcga.f = "";
    localbcga.g = "";
    localbcga.h = "";
    localbcga.i = "";
    localbcga.j = "";
    localbcga.k = "";
    localbcga.l = "";
    localbcga.m = "";
    localbcga.n = "";
    localbcga.o = "";
    localbcga.p = "";
    localbcga.q = "";
    localbcga.r = "";
    localbcga.s = "";
    localbcga.t = "";
    localbcga.u = "";
    return localbcga;
  }
  
  public static void a()
  {
    bcga localbcga = a();
    localbcga.jdField_c_of_type_JavaLangString = "0X8008423";
    localbcga.jdField_d_of_type_JavaLangString = "0X8008423";
    bcda.a(null, localbcga);
  }
  
  public static void a(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bcga localbcga = a();
    localbcga.f = (paramInt + "");
    localbcga.jdField_c_of_type_JavaLangString = "0X800842B";
    localbcga.jdField_d_of_type_JavaLangString = "0X800842B";
    bcda.a(null, localbcga);
  }
  
  public static void a(int paramInt, String paramString)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bcga localbcga = a();
    localbcga.jdField_c_of_type_JavaLangString = "0X8008430";
    localbcga.jdField_d_of_type_JavaLangString = "0X8008430";
    localbcga.jdField_b_of_type_JavaLangString = paramString;
    if (localbcga.jdField_a_of_type_Int == 5) {
      localbcga.g = jdField_a_of_type_JavaLangString;
    }
    localbcga.h = jdField_b_of_type_JavaLangString;
    localbcga.i = jdField_c_of_type_JavaLangString;
    localbcga.j = jdField_d_of_type_JavaLangString;
    localbcga.k = jdField_e_of_type_JavaLangString;
    localbcga.l = (paramInt + "");
    localbcga.n = "";
    paramString = new StringBuilder();
    if (jdField_d_of_type_Boolean) {}
    for (int i = 2;; i = 1)
    {
      localbcga.m = (i + "");
      bcda.a(null, localbcga);
      if (jdField_a_of_type_Boolean)
      {
        localbcga.jdField_c_of_type_JavaLangString = "0X80083B2";
        localbcga.jdField_d_of_type_JavaLangString = "0X80083B2";
        bcda.a(null, localbcga);
      }
      QmcfManager.getInstance().reportQmcfFrameConsume(paramInt, jdField_a_of_type_Int, jdField_e_of_type_JavaLangString);
      return;
    }
  }
  
  public static void a(bnee parambnee)
  {
    if ((parambnee != null) && (parambnee.a != null) && (parambnee.a.jdField_a_of_type_Int == 14)) {
      if (parambnee.a()) {
        break label57;
      }
    }
    label57:
    for (int i = 1;; i = 2)
    {
      bcef.b(null, "dc00898", "", "", "0X800A55F", "0X800A55F", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void a(bnee parambnee, bnpz parambnpz)
  {
    if (parambnpz == null) {}
    while ((parambnee == null) || (parambnee.a == null) || (parambnee.a.jdField_a_of_type_Int != 14)) {
      return;
    }
    if (parambnpz.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      bcef.b(null, "dc00898", "", "", "0X800A55C", "0X800A55C", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void a(bnpz parambnpz)
  {
    c(null, parambnpz);
  }
  
  public static void a(String paramString)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bcga localbcga = a();
    localbcga.jdField_c_of_type_JavaLangString = "0X8008425";
    localbcga.jdField_d_of_type_JavaLangString = "0X8008425";
    localbcga.h = paramString;
    bcda.a(null, localbcga);
  }
  
  public static void a(String paramString, long paramLong)
  {
    bcga localbcga = a();
    localbcga.jdField_c_of_type_JavaLangString = "0X8008939";
    localbcga.jdField_d_of_type_JavaLangString = "0X8008939";
    localbcga.h = jdField_b_of_type_JavaLangString;
    localbcga.i = jdField_c_of_type_JavaLangString;
    if (localbcga.jdField_a_of_type_Int == 5) {
      localbcga.g = jdField_a_of_type_JavaLangString;
    }
    localbcga.j = paramString;
    localbcga.o = ((float)paramLong / 1000.0F + "");
    bcda.a(null, localbcga);
  }
  
  public static void b()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bcga localbcga = a();
    localbcga.jdField_c_of_type_JavaLangString = "0X800842A";
    localbcga.jdField_d_of_type_JavaLangString = "0X800842A";
    bcda.a(null, localbcga);
  }
  
  public static void b(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bcga localbcga = a();
    localbcga.f = (paramInt + "");
    localbcga.jdField_c_of_type_JavaLangString = "0X800842C";
    localbcga.jdField_d_of_type_JavaLangString = "0X800842C";
    bcda.a(null, localbcga);
  }
  
  public static void b(int paramInt, String paramString)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bcga localbcga = a();
    localbcga.jdField_c_of_type_JavaLangString = "0X8008433";
    localbcga.jdField_d_of_type_JavaLangString = "0X8008433";
    localbcga.jdField_b_of_type_JavaLangString = paramString;
    localbcga.h = jdField_b_of_type_JavaLangString;
    localbcga.i = jdField_c_of_type_JavaLangString;
    localbcga.j = jdField_d_of_type_JavaLangString;
    localbcga.k = jdField_e_of_type_JavaLangString;
    if (localbcga.jdField_a_of_type_Int == 5) {
      localbcga.g = jdField_a_of_type_JavaLangString;
    }
    localbcga.l = (paramInt + "");
    paramString = new StringBuilder();
    if (jdField_c_of_type_Boolean) {}
    for (int i = 2;; i = 1)
    {
      localbcga.m = (i + "");
      localbcga.o = (jdField_a_of_type_Long + "");
      bcda.a(null, localbcga);
      if (jdField_a_of_type_Boolean)
      {
        localbcga.jdField_c_of_type_JavaLangString = "0X80083B1";
        localbcga.jdField_d_of_type_JavaLangString = "0X80083B1";
        bcda.a(null, localbcga);
      }
      QmcfManager.getInstance().reportQmcfFrameConsume(paramInt, jdField_a_of_type_Int, jdField_e_of_type_JavaLangString);
      return;
    }
  }
  
  public static void b(bnee parambnee)
  {
    if ((parambnee != null) && (parambnee.a != null) && (parambnee.a.jdField_a_of_type_Int == 14)) {
      if (parambnee.a()) {
        break label57;
      }
    }
    label57:
    for (int i = 1;; i = 2)
    {
      bcef.b(null, "dc00898", "", "", "0X800A55E", "0X800A55E", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void b(bnee parambnee, bnpz parambnpz)
  {
    if (parambnpz == null) {}
    while ((parambnee == null) || (parambnee.a == null) || (parambnee.a.jdField_a_of_type_Int != 14)) {
      return;
    }
    if (parambnpz.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      bcef.b(null, "dc00898", "", "", "0X800A55B", "0X800A55B", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void b(String paramString)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bcga localbcga = a();
    localbcga.jdField_c_of_type_JavaLangString = "0X8008427";
    localbcga.jdField_d_of_type_JavaLangString = "0X8008427";
    localbcga.j = paramString;
    bcda.a(null, localbcga);
  }
  
  public static void c()
  {
    if (jdField_a_of_type_Int == 10002) {
      xwa.a("video_edit", "camera_clkdouble", 0, 0, new String[0]);
    }
  }
  
  public static void c(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {}
    bcga localbcga;
    do
    {
      return;
      localbcga = a();
      localbcga.jdField_c_of_type_JavaLangString = "0X800842D";
      localbcga.jdField_d_of_type_JavaLangString = "0X800842D";
      if (localbcga.jdField_a_of_type_Int == 5) {
        localbcga.g = jdField_a_of_type_JavaLangString;
      }
      localbcga.h = jdField_b_of_type_JavaLangString;
      localbcga.i = jdField_c_of_type_JavaLangString;
      localbcga.j = jdField_d_of_type_JavaLangString;
      localbcga.k = jdField_e_of_type_JavaLangString;
      localbcga.g = jdField_a_of_type_JavaLangString;
      localbcga.l = (paramInt + "");
      bcda.a(null, localbcga);
    } while (!jdField_a_of_type_Boolean);
    localbcga.jdField_c_of_type_JavaLangString = "0X80083AE";
    localbcga.jdField_d_of_type_JavaLangString = "0X80083AE";
    bcda.a(null, localbcga);
  }
  
  public static void c(bnee parambnee)
  {
    if ((parambnee != null) && (parambnee.a != null) && (parambnee.a.jdField_a_of_type_Int == 14)) {
      bcef.b(null, "dc00898", "", "", "0X800A55D", "0X800A55D", 0, 0, "", "", "", "");
    }
  }
  
  public static void c(bnee parambnee, bnpz parambnpz)
  {
    int i = 1;
    if (parambnpz == null) {}
    while ((parambnee != null) && (parambnee.a != null) && (parambnee.a.jdField_a_of_type_Int != 14)) {
      return;
    }
    if (parambnpz.jdField_a_of_type_Int == 1)
    {
      parambnee = "2";
      if (!parambnpz.jdField_a_of_type_Boolean) {
        break label91;
      }
    }
    for (;;)
    {
      bcef.b(null, "dc00898", "", "", "0X800A55A", "0X800A55A", i, 0, parambnee, "", "", "");
      return;
      if (parambnpz.jdField_a_of_type_Int == 0)
      {
        parambnee = "1";
        break;
      }
      parambnee = "3";
      break;
      label91:
      i = 2;
    }
  }
  
  public static void c(String paramString)
  {
    bcga localbcga = a();
    localbcga.jdField_c_of_type_JavaLangString = "0X8008938";
    localbcga.jdField_d_of_type_JavaLangString = "0X8008938";
    localbcga.h = jdField_b_of_type_JavaLangString;
    localbcga.i = jdField_c_of_type_JavaLangString;
    if (localbcga.jdField_a_of_type_Int == 5) {
      localbcga.g = jdField_a_of_type_JavaLangString;
    }
    localbcga.j = paramString;
    bcda.a(null, localbcga);
  }
  
  public static void d()
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
  
  public static void d(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {}
    bcga localbcga;
    do
    {
      return;
      localbcga = a();
      localbcga.jdField_c_of_type_JavaLangString = "0X800842D";
      localbcga.jdField_d_of_type_JavaLangString = "0X800842D";
      if (localbcga.jdField_a_of_type_Int == 5) {
        localbcga.g = jdField_a_of_type_JavaLangString;
      }
      localbcga.h = jdField_b_of_type_JavaLangString;
      localbcga.i = jdField_c_of_type_JavaLangString;
      localbcga.j = jdField_d_of_type_JavaLangString;
      localbcga.k = jdField_e_of_type_JavaLangString;
      localbcga.l = (paramInt + "");
      bcda.a(null, localbcga);
    } while (!jdField_a_of_type_Boolean);
    localbcga.jdField_c_of_type_JavaLangString = "0X80083AE";
    localbcga.jdField_d_of_type_JavaLangString = "0X80083AE";
    bcda.a(null, localbcga);
  }
  
  public static void d(bnee parambnee)
  {
    if ((parambnee != null) && (parambnee.a != null) && (parambnee.a.jdField_a_of_type_Int == 14)) {
      if (parambnee.a()) {
        break label59;
      }
    }
    label59:
    for (int i = 1;; i = 2)
    {
      bcef.b(null, "dc00898", "", "", "0X800A559", "0X800A559", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void e(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {}
    bcga localbcga;
    do
    {
      return;
      localbcga = a();
      localbcga.jdField_c_of_type_JavaLangString = "0X800842E";
      localbcga.jdField_d_of_type_JavaLangString = "0X800842E";
      if (localbcga.jdField_a_of_type_Int == 5) {
        localbcga.g = jdField_a_of_type_JavaLangString;
      }
      localbcga.h = jdField_b_of_type_JavaLangString;
      localbcga.i = jdField_c_of_type_JavaLangString;
      localbcga.j = jdField_d_of_type_JavaLangString;
      localbcga.k = jdField_e_of_type_JavaLangString;
      localbcga.l = (paramInt + "");
      bcda.a(null, localbcga);
    } while (!jdField_a_of_type_Boolean);
    localbcga.jdField_c_of_type_JavaLangString = "0X80083B0";
    localbcga.jdField_d_of_type_JavaLangString = "0X80083B0";
    bcda.a(null, localbcga);
  }
  
  public static void e(bnee parambnee)
  {
    if ((parambnee != null) && (parambnee.a != null) && (parambnee.a.jdField_a_of_type_Int == 14)) {
      bcef.b(null, "dc00898", "", "", "0X800A558", "0X800A558", 0, 0, "", "", "", "");
    }
  }
  
  public static void f(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bcga localbcga = a();
    localbcga.jdField_c_of_type_JavaLangString = "0X800842F";
    localbcga.jdField_d_of_type_JavaLangString = "0X800842F";
    if (localbcga.jdField_a_of_type_Int == 5) {
      localbcga.g = jdField_a_of_type_JavaLangString;
    }
    localbcga.h = jdField_b_of_type_JavaLangString;
    localbcga.i = jdField_c_of_type_JavaLangString;
    localbcga.j = jdField_d_of_type_JavaLangString;
    localbcga.k = jdField_e_of_type_JavaLangString;
    localbcga.l = (paramInt + "");
    StringBuilder localStringBuilder = new StringBuilder();
    if (jdField_d_of_type_Boolean) {}
    for (paramInt = 2;; paramInt = 1)
    {
      localbcga.m = (paramInt + "");
      bcda.a(null, localbcga);
      return;
    }
  }
  
  public static void f(bnee parambnee)
  {
    if ((parambnee != null) && (parambnee.a != null) && (parambnee.a.jdField_a_of_type_Int == 14)) {
      bcef.b(null, "dc00898", "", "", "0X800A557", "0X800A557", 0, 0, "", "", "", "");
    }
  }
  
  public static void g(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {}
    bcga localbcga;
    do
    {
      return;
      localbcga = a();
      localbcga.jdField_c_of_type_JavaLangString = "0X8008431";
      localbcga.jdField_d_of_type_JavaLangString = "0X8008431";
      if (localbcga.jdField_a_of_type_Int == 5) {
        localbcga.g = jdField_a_of_type_JavaLangString;
      }
      localbcga.h = jdField_b_of_type_JavaLangString;
      localbcga.i = jdField_c_of_type_JavaLangString;
      localbcga.j = jdField_d_of_type_JavaLangString;
      localbcga.k = jdField_e_of_type_JavaLangString;
      localbcga.l = (paramInt + "");
      localbcga.o = (jdField_a_of_type_Long + "");
      bcda.a(null, localbcga);
    } while (!jdField_a_of_type_Boolean);
    localbcga.jdField_c_of_type_JavaLangString = "0X80083AF";
    localbcga.jdField_d_of_type_JavaLangString = "0X80083AF";
    bcda.a(null, localbcga);
  }
  
  public static void g(bnee parambnee)
  {
    if ((parambnee != null) && (parambnee.a != null) && (parambnee.a.jdField_a_of_type_Int == 14)) {
      bcef.b(null, "dc00898", "", "", "0X800A556", "0X800A556", 0, 0, "", "", "", "");
    }
  }
  
  public static void h(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bcga localbcga = a();
    localbcga.jdField_c_of_type_JavaLangString = "0X8008432";
    localbcga.jdField_d_of_type_JavaLangString = "0X8008432";
    localbcga.h = jdField_b_of_type_JavaLangString;
    localbcga.i = jdField_c_of_type_JavaLangString;
    localbcga.j = jdField_d_of_type_JavaLangString;
    localbcga.k = jdField_e_of_type_JavaLangString;
    if (localbcga.jdField_a_of_type_Int == 5) {
      localbcga.g = jdField_a_of_type_JavaLangString;
    }
    localbcga.l = (paramInt + "");
    StringBuilder localStringBuilder = new StringBuilder();
    if (jdField_c_of_type_Boolean) {}
    for (paramInt = 2;; paramInt = 1)
    {
      localbcga.m = (paramInt + "");
      localbcga.o = (jdField_a_of_type_Long + "");
      bcda.a(null, localbcga);
      return;
    }
  }
  
  public static void h(bnee parambnee)
  {
    if ((parambnee != null) && (parambnee.a != null) && (parambnee.a.jdField_a_of_type_Int == 14)) {
      bcef.b(null, "dc00898", "", "", "0X800A555", "0X800A555", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     babc
 * JD-Core Version:    0.7.0.1
 */