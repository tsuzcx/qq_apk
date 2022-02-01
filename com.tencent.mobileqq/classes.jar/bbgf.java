import android.util.SparseIntArray;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil.1;
import com.tencent.mobileqq.shortvideo.dancemachine.BoyDataReport;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.text.SimpleDateFormat;
import java.util.Date;

public class bbgf
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
  
  public static bdnp a()
  {
    bdnp localbdnp = new bdnp();
    localbdnp.jdField_a_of_type_JavaLangString = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    localbdnp.jdField_b_of_type_JavaLangString = "";
    localbdnp.jdField_c_of_type_JavaLangString = "";
    localbdnp.jdField_d_of_type_JavaLangString = "";
    localbdnp.jdField_a_of_type_Int = jdField_a_of_type_AndroidUtilSparseIntArray.get(jdField_a_of_type_Int, -1);
    localbdnp.jdField_e_of_type_JavaLangString = "${count_unknown}";
    localbdnp.f = "";
    localbdnp.g = "";
    localbdnp.h = "";
    localbdnp.i = "";
    localbdnp.j = "";
    localbdnp.k = "";
    localbdnp.l = "";
    localbdnp.m = "";
    localbdnp.n = "";
    localbdnp.o = "";
    localbdnp.p = "";
    localbdnp.q = "";
    localbdnp.r = "";
    localbdnp.s = "";
    localbdnp.t = "";
    localbdnp.u = "";
    return localbdnp;
  }
  
  public static void a()
  {
    bdnp localbdnp = a();
    localbdnp.jdField_c_of_type_JavaLangString = "0X8008423";
    localbdnp.jdField_d_of_type_JavaLangString = "0X8008423";
    bdkg.a(null, localbdnp);
  }
  
  public static void a(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bdnp localbdnp = a();
    localbdnp.jdField_c_of_type_JavaLangString = "0X8008754";
    localbdnp.jdField_d_of_type_JavaLangString = "0X8008754";
    localbdnp.n = String.valueOf(paramInt);
    bdkg.a(null, localbdnp);
  }
  
  public static void a(int paramInt, String paramString)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bdnp localbdnp = a();
    localbdnp.jdField_c_of_type_JavaLangString = "0X8008430";
    localbdnp.jdField_d_of_type_JavaLangString = "0X8008430";
    localbdnp.jdField_b_of_type_JavaLangString = paramString;
    if (localbdnp.jdField_a_of_type_Int == 5) {
      localbdnp.g = jdField_a_of_type_JavaLangString;
    }
    localbdnp.h = jdField_b_of_type_JavaLangString;
    localbdnp.i = jdField_c_of_type_JavaLangString;
    localbdnp.j = jdField_d_of_type_JavaLangString;
    localbdnp.k = jdField_e_of_type_JavaLangString;
    localbdnp.l = (paramInt + "");
    localbdnp.n = "";
    paramString = new StringBuilder();
    if (jdField_d_of_type_Boolean) {}
    for (int i = 2;; i = 1)
    {
      localbdnp.m = (i + "");
      bdkg.a(null, localbdnp);
      if (jdField_a_of_type_Boolean)
      {
        localbdnp.jdField_c_of_type_JavaLangString = "0X80083B2";
        localbdnp.jdField_d_of_type_JavaLangString = "0X80083B2";
        bdkg.a(null, localbdnp);
      }
      QmcfManager.getInstance().reportQmcfFrameConsume(paramInt, jdField_a_of_type_Int, jdField_e_of_type_JavaLangString);
      return;
    }
  }
  
  public static void a(long paramLong, int paramInt)
  {
    if (jdField_b_of_type_Boolean)
    {
      bdnp localbdnp = a();
      localbdnp.jdField_c_of_type_JavaLangString = "0X800893A";
      localbdnp.jdField_d_of_type_JavaLangString = "0X800893A";
      localbdnp.h = jdField_b_of_type_JavaLangString;
      localbdnp.i = jdField_c_of_type_JavaLangString;
      localbdnp.f = (paramInt + "");
      if (localbdnp.jdField_a_of_type_Int == 5) {
        localbdnp.g = jdField_a_of_type_JavaLangString;
      }
      localbdnp.o = ((float)paramLong / 1000.0F + "");
      bdkg.a(null, localbdnp);
    }
  }
  
  public static void a(bqgk parambqgk)
  {
    if ((parambqgk != null) && (parambqgk.a != null) && (parambqgk.a.jdField_a_of_type_Int == 14)) {
      if (parambqgk.a()) {
        break label57;
      }
    }
    label57:
    for (int i = 1;; i = 2)
    {
      bdll.b(null, "dc00898", "", "", "0X800A55F", "0X800A55F", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void a(bqgk parambqgk, bqvl parambqvl)
  {
    if (parambqvl == null) {}
    while ((parambqgk == null) || (parambqgk.a == null) || (parambqgk.a.jdField_a_of_type_Int != 14)) {
      return;
    }
    if (parambqvl.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      bdll.b(null, "dc00898", "", "", "0X800A55C", "0X800A55C", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void a(bqvl parambqvl)
  {
    c(null, parambqvl);
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
    bdnp localbdnp = a();
    localbdnp.jdField_c_of_type_JavaLangString = "0X8008425";
    localbdnp.jdField_d_of_type_JavaLangString = "0X8008425";
    localbdnp.h = paramString;
    bdkg.a(null, localbdnp);
  }
  
  public static void a(String paramString, long paramLong)
  {
    bdnp localbdnp = a();
    localbdnp.jdField_c_of_type_JavaLangString = "0X8008939";
    localbdnp.jdField_d_of_type_JavaLangString = "0X8008939";
    localbdnp.h = jdField_b_of_type_JavaLangString;
    localbdnp.i = jdField_c_of_type_JavaLangString;
    if (localbdnp.jdField_a_of_type_Int == 5) {
      localbdnp.g = jdField_a_of_type_JavaLangString;
    }
    localbdnp.j = paramString;
    localbdnp.o = ((float)paramLong / 1000.0F + "");
    bdkg.a(null, localbdnp);
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
    bdnp localbdnp = a();
    localbdnp.jdField_c_of_type_JavaLangString = "0X8008424";
    localbdnp.jdField_d_of_type_JavaLangString = "0X8008424";
    bdkg.a(null, localbdnp);
  }
  
  public static void b(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bdnp localbdnp = a();
    localbdnp.jdField_c_of_type_JavaLangString = "0X8008429";
    localbdnp.jdField_d_of_type_JavaLangString = "0X8008429";
    localbdnp.f = (paramInt + "");
    bdkg.a(null, localbdnp);
  }
  
  public static void b(int paramInt, String paramString)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bdnp localbdnp = a();
    localbdnp.jdField_c_of_type_JavaLangString = "0X8008433";
    localbdnp.jdField_d_of_type_JavaLangString = "0X8008433";
    localbdnp.jdField_b_of_type_JavaLangString = paramString;
    localbdnp.h = jdField_b_of_type_JavaLangString;
    localbdnp.i = jdField_c_of_type_JavaLangString;
    localbdnp.j = jdField_d_of_type_JavaLangString;
    localbdnp.k = jdField_e_of_type_JavaLangString;
    if (localbdnp.jdField_a_of_type_Int == 5) {
      localbdnp.g = jdField_a_of_type_JavaLangString;
    }
    localbdnp.l = (paramInt + "");
    paramString = new StringBuilder();
    if (jdField_c_of_type_Boolean) {}
    for (int i = 2;; i = 1)
    {
      localbdnp.m = (i + "");
      localbdnp.n = String.valueOf(alzm.a().c);
      localbdnp.o = (jdField_a_of_type_Long + "");
      bdkg.a(null, localbdnp);
      if (jdField_a_of_type_Boolean)
      {
        localbdnp.jdField_c_of_type_JavaLangString = "0X80083B1";
        localbdnp.jdField_d_of_type_JavaLangString = "0X80083B1";
        bdkg.a(null, localbdnp);
      }
      QmcfManager.getInstance().reportQmcfFrameConsume(paramInt, jdField_a_of_type_Int, jdField_e_of_type_JavaLangString);
      return;
    }
  }
  
  private static void b(long paramLong1, long paramLong2)
  {
    bdnp localbdnp = a();
    localbdnp.jdField_c_of_type_JavaLangString = "0X8008937";
    localbdnp.jdField_d_of_type_JavaLangString = "0X8008937";
    localbdnp.h = jdField_b_of_type_JavaLangString;
    localbdnp.i = jdField_c_of_type_JavaLangString;
    localbdnp.j = ("" + paramLong1);
    if (localbdnp.jdField_a_of_type_Int == 5) {
      localbdnp.g = jdField_a_of_type_JavaLangString;
    }
    localbdnp.o = (paramLong2 / 1000L + "");
    bdkg.a(null, localbdnp);
  }
  
  public static void b(bqgk parambqgk)
  {
    if ((parambqgk != null) && (parambqgk.a != null) && (parambqgk.a.jdField_a_of_type_Int == 14)) {
      if (parambqgk.a()) {
        break label59;
      }
    }
    label59:
    for (int i = 1;; i = 2)
    {
      bdll.b(null, "dc00898", "", "", "0X800A55E", "0X800A55E", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void b(bqgk parambqgk, bqvl parambqvl)
  {
    if (parambqvl == null) {}
    while ((parambqgk == null) || (parambqgk.a == null) || (parambqgk.a.jdField_a_of_type_Int != 14)) {
      return;
    }
    if (parambqvl.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      bdll.b(null, "dc00898", "", "", "0X800A55B", "0X800A55B", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void b(String paramString)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bdnp localbdnp = a();
    localbdnp.jdField_c_of_type_JavaLangString = "0X8008427";
    localbdnp.jdField_d_of_type_JavaLangString = "0X8008427";
    localbdnp.j = paramString;
    bdkg.a(null, localbdnp);
  }
  
  private static void b(String paramString1, String paramString2, String paramString3)
  {
    bdnp localbdnp = a();
    localbdnp.jdField_c_of_type_JavaLangString = "0X8008936";
    localbdnp.jdField_d_of_type_JavaLangString = "0X8008936";
    localbdnp.h = jdField_b_of_type_JavaLangString;
    localbdnp.i = jdField_c_of_type_JavaLangString;
    localbdnp.j = paramString2;
    localbdnp.k = paramString1;
    if (localbdnp.jdField_a_of_type_Int == 5) {
      localbdnp.g = jdField_a_of_type_JavaLangString;
    }
    localbdnp.l = paramString3;
    bdkg.a(null, localbdnp);
  }
  
  public static void c()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bdnp localbdnp = a();
    localbdnp.jdField_c_of_type_JavaLangString = "0X8008753";
    localbdnp.jdField_d_of_type_JavaLangString = "0X8008753";
    bdkg.a(null, localbdnp);
  }
  
  public static void c(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bdnp localbdnp = a();
    localbdnp.f = (paramInt + "");
    localbdnp.jdField_c_of_type_JavaLangString = "0X800842B";
    localbdnp.jdField_d_of_type_JavaLangString = "0X800842B";
    bdkg.a(null, localbdnp);
  }
  
  public static void c(bqgk parambqgk)
  {
    if ((parambqgk != null) && (parambqgk.a != null) && (parambqgk.a.jdField_a_of_type_Int == 14)) {
      bdll.b(null, "dc00898", "", "", "0X800A55D", "0X800A55D", 0, 0, "", "", "", "");
    }
  }
  
  public static void c(bqgk parambqgk, bqvl parambqvl)
  {
    int i = 1;
    if (parambqvl == null) {}
    while ((parambqgk != null) && (parambqgk.a != null) && (parambqgk.a.jdField_a_of_type_Int != 14)) {
      return;
    }
    if (parambqvl.jdField_a_of_type_Int == 1)
    {
      parambqgk = "2";
      if (!parambqvl.jdField_a_of_type_Boolean) {
        break label96;
      }
    }
    for (;;)
    {
      bdll.b(null, "dc00898", "", "", "0X800A55A", "0X800A55A", i, 0, parambqgk, "", "", "");
      return;
      if (parambqvl.jdField_a_of_type_Int == 0)
      {
        parambqgk = "1";
        break;
      }
      parambqgk = "3";
      break;
      label96:
      i = 2;
    }
  }
  
  public static void c(String paramString)
  {
    bdnp localbdnp = a();
    localbdnp.jdField_c_of_type_JavaLangString = "0X8008938";
    localbdnp.jdField_d_of_type_JavaLangString = "0X8008938";
    localbdnp.h = jdField_b_of_type_JavaLangString;
    localbdnp.i = jdField_c_of_type_JavaLangString;
    if (localbdnp.jdField_a_of_type_Int == 5) {
      localbdnp.g = jdField_a_of_type_JavaLangString;
    }
    localbdnp.j = paramString;
    bdkg.a(null, localbdnp);
  }
  
  public static void d()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bdnp localbdnp = a();
    localbdnp.jdField_c_of_type_JavaLangString = "0X8008426";
    localbdnp.jdField_d_of_type_JavaLangString = "0X8008426";
    bdkg.a(null, localbdnp);
  }
  
  public static void d(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bdnp localbdnp = a();
    localbdnp.f = (paramInt + "");
    localbdnp.jdField_c_of_type_JavaLangString = "0X800842C";
    localbdnp.jdField_d_of_type_JavaLangString = "0X800842C";
    bdkg.a(null, localbdnp);
  }
  
  public static void d(bqgk parambqgk)
  {
    if ((parambqgk != null) && (parambqgk.a != null) && (parambqgk.a.jdField_a_of_type_Int == 14)) {
      if (parambqgk.a()) {
        break label59;
      }
    }
    label59:
    for (int i = 1;; i = 2)
    {
      bdll.b(null, "dc00898", "", "", "0X800A559", "0X800A559", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void e()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bdnp localbdnp = a();
    localbdnp.jdField_c_of_type_JavaLangString = "0X8008428";
    localbdnp.jdField_d_of_type_JavaLangString = "0X8008428";
    bdkg.a(null, localbdnp);
  }
  
  public static void e(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {}
    bdnp localbdnp;
    do
    {
      return;
      localbdnp = a();
      localbdnp.jdField_c_of_type_JavaLangString = "0X800842D";
      localbdnp.jdField_d_of_type_JavaLangString = "0X800842D";
      if (localbdnp.jdField_a_of_type_Int == 5) {
        localbdnp.g = jdField_a_of_type_JavaLangString;
      }
      localbdnp.h = jdField_b_of_type_JavaLangString;
      localbdnp.i = jdField_c_of_type_JavaLangString;
      localbdnp.j = jdField_d_of_type_JavaLangString;
      localbdnp.k = jdField_e_of_type_JavaLangString;
      localbdnp.g = jdField_a_of_type_JavaLangString;
      localbdnp.l = (paramInt + "");
      bdkg.a(null, localbdnp);
    } while (!jdField_a_of_type_Boolean);
    localbdnp.jdField_c_of_type_JavaLangString = "0X80083AE";
    localbdnp.jdField_d_of_type_JavaLangString = "0X80083AE";
    bdkg.a(null, localbdnp);
  }
  
  public static void e(bqgk parambqgk)
  {
    if ((parambqgk != null) && (parambqgk.a != null) && (parambqgk.a.jdField_a_of_type_Int == 14)) {
      bdll.b(null, "dc00898", "", "", "0X800A558", "0X800A558", 0, 0, "", "", "", "");
    }
  }
  
  public static void f()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bdnp localbdnp = a();
    localbdnp.jdField_c_of_type_JavaLangString = "0X800842A";
    localbdnp.jdField_d_of_type_JavaLangString = "0X800842A";
    bdkg.a(null, localbdnp);
  }
  
  public static void f(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {}
    bdnp localbdnp;
    do
    {
      return;
      localbdnp = a();
      localbdnp.jdField_c_of_type_JavaLangString = "0X800842D";
      localbdnp.jdField_d_of_type_JavaLangString = "0X800842D";
      if (localbdnp.jdField_a_of_type_Int == 5) {
        localbdnp.g = jdField_a_of_type_JavaLangString;
      }
      localbdnp.h = jdField_b_of_type_JavaLangString;
      localbdnp.i = jdField_c_of_type_JavaLangString;
      localbdnp.j = jdField_d_of_type_JavaLangString;
      localbdnp.k = jdField_e_of_type_JavaLangString;
      localbdnp.l = (paramInt + "");
      bdkg.a(null, localbdnp);
    } while (!jdField_a_of_type_Boolean);
    localbdnp.jdField_c_of_type_JavaLangString = "0X80083AE";
    localbdnp.jdField_d_of_type_JavaLangString = "0X80083AE";
    bdkg.a(null, localbdnp);
  }
  
  public static void f(bqgk parambqgk)
  {
    if ((parambqgk != null) && (parambqgk.a != null) && (parambqgk.a.jdField_a_of_type_Int == 14)) {
      bdll.b(null, "dc00898", "", "", "0X800A557", "0X800A557", 0, 0, "", "", "", "");
    }
  }
  
  public static void g()
  {
    if (jdField_a_of_type_Int == 10002) {
      yup.a("video_edit", "camera_clkdouble", 0, 0, new String[0]);
    }
  }
  
  public static void g(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {}
    bdnp localbdnp;
    do
    {
      return;
      localbdnp = a();
      localbdnp.jdField_c_of_type_JavaLangString = "0X800842E";
      localbdnp.jdField_d_of_type_JavaLangString = "0X800842E";
      if (localbdnp.jdField_a_of_type_Int == 5) {
        localbdnp.g = jdField_a_of_type_JavaLangString;
      }
      localbdnp.h = jdField_b_of_type_JavaLangString;
      localbdnp.i = jdField_c_of_type_JavaLangString;
      localbdnp.j = jdField_d_of_type_JavaLangString;
      localbdnp.k = jdField_e_of_type_JavaLangString;
      localbdnp.l = (paramInt + "");
      bdkg.a(null, localbdnp);
    } while (!jdField_a_of_type_Boolean);
    localbdnp.jdField_c_of_type_JavaLangString = "0X80083B0";
    localbdnp.jdField_d_of_type_JavaLangString = "0X80083B0";
    bdkg.a(null, localbdnp);
  }
  
  public static void g(bqgk parambqgk)
  {
    if ((parambqgk != null) && (parambqgk.a != null) && (parambqgk.a.jdField_a_of_type_Int == 14)) {
      bdll.b(null, "dc00898", "", "", "0X800A556", "0X800A556", 0, 0, "", "", "", "");
    }
  }
  
  public static void h()
  {
    bdnp localbdnp = a();
    localbdnp.jdField_c_of_type_JavaLangString = "0X8008F10";
    localbdnp.jdField_d_of_type_JavaLangString = "0X8008F10";
    bdkg.a(null, localbdnp);
  }
  
  public static void h(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bdnp localbdnp = a();
    localbdnp.jdField_c_of_type_JavaLangString = "0X800842F";
    localbdnp.jdField_d_of_type_JavaLangString = "0X800842F";
    if (localbdnp.jdField_a_of_type_Int == 5) {
      localbdnp.g = jdField_a_of_type_JavaLangString;
    }
    localbdnp.h = jdField_b_of_type_JavaLangString;
    localbdnp.i = jdField_c_of_type_JavaLangString;
    localbdnp.j = jdField_d_of_type_JavaLangString;
    localbdnp.k = jdField_e_of_type_JavaLangString;
    localbdnp.l = (paramInt + "");
    StringBuilder localStringBuilder = new StringBuilder();
    if (jdField_d_of_type_Boolean) {}
    for (paramInt = 2;; paramInt = 1)
    {
      localbdnp.m = (paramInt + "");
      bdkg.a(null, localbdnp);
      return;
    }
  }
  
  public static void h(bqgk parambqgk)
  {
    if ((parambqgk != null) && (parambqgk.a != null) && (parambqgk.a.jdField_a_of_type_Int == 14)) {
      bdll.b(null, "dc00898", "", "", "0X800A555", "0X800A555", 0, 0, "", "", "", "");
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
    bdnp localbdnp;
    do
    {
      return;
      localbdnp = a();
      localbdnp.jdField_c_of_type_JavaLangString = "0X8008431";
      localbdnp.jdField_d_of_type_JavaLangString = "0X8008431";
      if (localbdnp.jdField_a_of_type_Int == 5) {
        localbdnp.g = jdField_a_of_type_JavaLangString;
      }
      localbdnp.h = jdField_b_of_type_JavaLangString;
      localbdnp.i = jdField_c_of_type_JavaLangString;
      localbdnp.j = jdField_d_of_type_JavaLangString;
      localbdnp.k = jdField_e_of_type_JavaLangString;
      localbdnp.l = (paramInt + "");
      localbdnp.n = String.valueOf(alzm.a().c);
      localbdnp.o = (jdField_a_of_type_Long + "");
      bdkg.a(null, localbdnp);
    } while (!jdField_a_of_type_Boolean);
    localbdnp.jdField_c_of_type_JavaLangString = "0X80083AF";
    localbdnp.jdField_d_of_type_JavaLangString = "0X80083AF";
    bdkg.a(null, localbdnp);
  }
  
  public static void j(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bdnp localbdnp = a();
    localbdnp.jdField_c_of_type_JavaLangString = "0X8008432";
    localbdnp.jdField_d_of_type_JavaLangString = "0X8008432";
    localbdnp.h = jdField_b_of_type_JavaLangString;
    localbdnp.i = jdField_c_of_type_JavaLangString;
    localbdnp.j = jdField_d_of_type_JavaLangString;
    localbdnp.k = jdField_e_of_type_JavaLangString;
    if (localbdnp.jdField_a_of_type_Int == 5) {
      localbdnp.g = jdField_a_of_type_JavaLangString;
    }
    localbdnp.l = (paramInt + "");
    StringBuilder localStringBuilder = new StringBuilder();
    if (jdField_c_of_type_Boolean) {}
    for (paramInt = 2;; paramInt = 1)
    {
      localbdnp.m = (paramInt + "");
      localbdnp.n = String.valueOf(alzm.a().c);
      localbdnp.o = (jdField_a_of_type_Long + "");
      bdkg.a(null, localbdnp);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbgf
 * JD-Core Version:    0.7.0.1
 */