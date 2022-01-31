import android.util.SparseIntArray;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil.1;
import com.tencent.mobileqq.shortvideo.dancemachine.BoyDataReport;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.text.SimpleDateFormat;
import java.util.Date;

public class axpl
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
  
  public static aztw a()
  {
    aztw localaztw = new aztw();
    localaztw.jdField_a_of_type_JavaLangString = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    localaztw.jdField_b_of_type_JavaLangString = "";
    localaztw.jdField_c_of_type_JavaLangString = "";
    localaztw.jdField_d_of_type_JavaLangString = "";
    localaztw.jdField_a_of_type_Int = jdField_a_of_type_AndroidUtilSparseIntArray.get(jdField_a_of_type_Int, -1);
    localaztw.jdField_e_of_type_JavaLangString = "${count_unknown}";
    localaztw.f = "";
    localaztw.g = "";
    localaztw.h = "";
    localaztw.i = "";
    localaztw.j = "";
    localaztw.k = "";
    localaztw.l = "";
    localaztw.m = "";
    localaztw.n = "";
    localaztw.o = "";
    localaztw.p = "";
    localaztw.q = "";
    localaztw.r = "";
    localaztw.s = "";
    localaztw.t = "";
    localaztw.u = "";
    return localaztw;
  }
  
  public static void a()
  {
    aztw localaztw = a();
    localaztw.jdField_c_of_type_JavaLangString = "0X8008423";
    localaztw.jdField_d_of_type_JavaLangString = "0X8008423";
    azpn.a(null, localaztw);
  }
  
  public static void a(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    aztw localaztw = a();
    localaztw.jdField_c_of_type_JavaLangString = "0X8008754";
    localaztw.jdField_d_of_type_JavaLangString = "0X8008754";
    localaztw.n = String.valueOf(paramInt);
    azpn.a(null, localaztw);
  }
  
  public static void a(int paramInt, String paramString)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    aztw localaztw = a();
    localaztw.jdField_c_of_type_JavaLangString = "0X8008430";
    localaztw.jdField_d_of_type_JavaLangString = "0X8008430";
    localaztw.jdField_b_of_type_JavaLangString = paramString;
    if (localaztw.jdField_a_of_type_Int == 5) {
      localaztw.g = jdField_a_of_type_JavaLangString;
    }
    localaztw.h = jdField_b_of_type_JavaLangString;
    localaztw.i = jdField_c_of_type_JavaLangString;
    localaztw.j = jdField_d_of_type_JavaLangString;
    localaztw.k = jdField_e_of_type_JavaLangString;
    localaztw.l = (paramInt + "");
    localaztw.n = "";
    paramString = new StringBuilder();
    if (jdField_d_of_type_Boolean) {}
    for (int i = 2;; i = 1)
    {
      localaztw.m = (i + "");
      azpn.a(null, localaztw);
      if (jdField_a_of_type_Boolean)
      {
        localaztw.jdField_c_of_type_JavaLangString = "0X80083B2";
        localaztw.jdField_d_of_type_JavaLangString = "0X80083B2";
        azpn.a(null, localaztw);
      }
      QmcfManager.getInstance().reportQmcfFrameConsume(paramInt, jdField_a_of_type_Int, jdField_e_of_type_JavaLangString);
      return;
    }
  }
  
  public static void a(long paramLong, int paramInt)
  {
    if (jdField_b_of_type_Boolean)
    {
      aztw localaztw = a();
      localaztw.jdField_c_of_type_JavaLangString = "0X800893A";
      localaztw.jdField_d_of_type_JavaLangString = "0X800893A";
      localaztw.h = jdField_b_of_type_JavaLangString;
      localaztw.i = jdField_c_of_type_JavaLangString;
      localaztw.f = (paramInt + "");
      if (localaztw.jdField_a_of_type_Int == 5) {
        localaztw.g = jdField_a_of_type_JavaLangString;
      }
      localaztw.o = ((float)paramLong / 1000.0F + "");
      azpn.a(null, localaztw);
    }
  }
  
  public static void a(bmnj parambmnj)
  {
    if ((parambmnj != null) && (parambmnj.a != null) && (parambmnj.a.jdField_a_of_type_Int == 14)) {
      if (parambmnj.a()) {
        break label57;
      }
    }
    label57:
    for (int i = 1;; i = 2)
    {
      azqs.b(null, "dc00898", "", "", "0X800A55F", "0X800A55F", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void a(bmnj parambmnj, bnck parambnck)
  {
    if (parambnck == null) {}
    while ((parambmnj == null) || (parambmnj.a == null) || (parambmnj.a.jdField_a_of_type_Int != 14)) {
      return;
    }
    if (parambnck.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      azqs.b(null, "dc00898", "", "", "0X800A55C", "0X800A55C", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void a(bnck parambnck)
  {
    c(null, parambnck);
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
    aztw localaztw = a();
    localaztw.jdField_c_of_type_JavaLangString = "0X8008425";
    localaztw.jdField_d_of_type_JavaLangString = "0X8008425";
    localaztw.h = paramString;
    azpn.a(null, localaztw);
  }
  
  public static void a(String paramString, long paramLong)
  {
    aztw localaztw = a();
    localaztw.jdField_c_of_type_JavaLangString = "0X8008939";
    localaztw.jdField_d_of_type_JavaLangString = "0X8008939";
    localaztw.h = jdField_b_of_type_JavaLangString;
    localaztw.i = jdField_c_of_type_JavaLangString;
    if (localaztw.jdField_a_of_type_Int == 5) {
      localaztw.g = jdField_a_of_type_JavaLangString;
    }
    localaztw.j = paramString;
    localaztw.o = ((float)paramLong / 1000.0F + "");
    azpn.a(null, localaztw);
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
    aztw localaztw = a();
    localaztw.jdField_c_of_type_JavaLangString = "0X8008424";
    localaztw.jdField_d_of_type_JavaLangString = "0X8008424";
    azpn.a(null, localaztw);
  }
  
  public static void b(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    aztw localaztw = a();
    localaztw.jdField_c_of_type_JavaLangString = "0X8008429";
    localaztw.jdField_d_of_type_JavaLangString = "0X8008429";
    localaztw.f = (paramInt + "");
    azpn.a(null, localaztw);
  }
  
  public static void b(int paramInt, String paramString)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    aztw localaztw = a();
    localaztw.jdField_c_of_type_JavaLangString = "0X8008433";
    localaztw.jdField_d_of_type_JavaLangString = "0X8008433";
    localaztw.jdField_b_of_type_JavaLangString = paramString;
    localaztw.h = jdField_b_of_type_JavaLangString;
    localaztw.i = jdField_c_of_type_JavaLangString;
    localaztw.j = jdField_d_of_type_JavaLangString;
    localaztw.k = jdField_e_of_type_JavaLangString;
    if (localaztw.jdField_a_of_type_Int == 5) {
      localaztw.g = jdField_a_of_type_JavaLangString;
    }
    localaztw.l = (paramInt + "");
    paramString = new StringBuilder();
    if (jdField_c_of_type_Boolean) {}
    for (int i = 2;; i = 1)
    {
      localaztw.m = (i + "");
      localaztw.n = String.valueOf(ajve.a().c);
      localaztw.o = (jdField_a_of_type_Long + "");
      azpn.a(null, localaztw);
      if (jdField_a_of_type_Boolean)
      {
        localaztw.jdField_c_of_type_JavaLangString = "0X80083B1";
        localaztw.jdField_d_of_type_JavaLangString = "0X80083B1";
        azpn.a(null, localaztw);
      }
      QmcfManager.getInstance().reportQmcfFrameConsume(paramInt, jdField_a_of_type_Int, jdField_e_of_type_JavaLangString);
      return;
    }
  }
  
  private static void b(long paramLong1, long paramLong2)
  {
    aztw localaztw = a();
    localaztw.jdField_c_of_type_JavaLangString = "0X8008937";
    localaztw.jdField_d_of_type_JavaLangString = "0X8008937";
    localaztw.h = jdField_b_of_type_JavaLangString;
    localaztw.i = jdField_c_of_type_JavaLangString;
    localaztw.j = ("" + paramLong1);
    if (localaztw.jdField_a_of_type_Int == 5) {
      localaztw.g = jdField_a_of_type_JavaLangString;
    }
    localaztw.o = (paramLong2 / 1000L + "");
    azpn.a(null, localaztw);
  }
  
  public static void b(bmnj parambmnj)
  {
    if ((parambmnj != null) && (parambmnj.a != null) && (parambmnj.a.jdField_a_of_type_Int == 14)) {
      if (parambmnj.a()) {
        break label59;
      }
    }
    label59:
    for (int i = 1;; i = 2)
    {
      azqs.b(null, "dc00898", "", "", "0X800A55E", "0X800A55E", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void b(bmnj parambmnj, bnck parambnck)
  {
    if (parambnck == null) {}
    while ((parambmnj == null) || (parambmnj.a == null) || (parambmnj.a.jdField_a_of_type_Int != 14)) {
      return;
    }
    if (parambnck.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      azqs.b(null, "dc00898", "", "", "0X800A55B", "0X800A55B", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void b(String paramString)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    aztw localaztw = a();
    localaztw.jdField_c_of_type_JavaLangString = "0X8008427";
    localaztw.jdField_d_of_type_JavaLangString = "0X8008427";
    localaztw.j = paramString;
    azpn.a(null, localaztw);
  }
  
  private static void b(String paramString1, String paramString2, String paramString3)
  {
    aztw localaztw = a();
    localaztw.jdField_c_of_type_JavaLangString = "0X8008936";
    localaztw.jdField_d_of_type_JavaLangString = "0X8008936";
    localaztw.h = jdField_b_of_type_JavaLangString;
    localaztw.i = jdField_c_of_type_JavaLangString;
    localaztw.j = paramString2;
    localaztw.k = paramString1;
    if (localaztw.jdField_a_of_type_Int == 5) {
      localaztw.g = jdField_a_of_type_JavaLangString;
    }
    localaztw.l = paramString3;
    azpn.a(null, localaztw);
  }
  
  public static void c()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    aztw localaztw = a();
    localaztw.jdField_c_of_type_JavaLangString = "0X8008753";
    localaztw.jdField_d_of_type_JavaLangString = "0X8008753";
    azpn.a(null, localaztw);
  }
  
  public static void c(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    aztw localaztw = a();
    localaztw.f = (paramInt + "");
    localaztw.jdField_c_of_type_JavaLangString = "0X800842B";
    localaztw.jdField_d_of_type_JavaLangString = "0X800842B";
    azpn.a(null, localaztw);
  }
  
  public static void c(bmnj parambmnj)
  {
    if ((parambmnj != null) && (parambmnj.a != null) && (parambmnj.a.jdField_a_of_type_Int == 14)) {
      azqs.b(null, "dc00898", "", "", "0X800A55D", "0X800A55D", 0, 0, "", "", "", "");
    }
  }
  
  public static void c(bmnj parambmnj, bnck parambnck)
  {
    int i = 1;
    if (parambnck == null) {}
    while ((parambmnj != null) && (parambmnj.a != null) && (parambmnj.a.jdField_a_of_type_Int != 14)) {
      return;
    }
    if (parambnck.jdField_a_of_type_Int == 1)
    {
      parambmnj = "2";
      if (!parambnck.jdField_a_of_type_Boolean) {
        break label96;
      }
    }
    for (;;)
    {
      azqs.b(null, "dc00898", "", "", "0X800A55A", "0X800A55A", i, 0, parambmnj, "", "", "");
      return;
      if (parambnck.jdField_a_of_type_Int == 0)
      {
        parambmnj = "1";
        break;
      }
      parambmnj = "3";
      break;
      label96:
      i = 2;
    }
  }
  
  public static void c(String paramString)
  {
    aztw localaztw = a();
    localaztw.jdField_c_of_type_JavaLangString = "0X8008938";
    localaztw.jdField_d_of_type_JavaLangString = "0X8008938";
    localaztw.h = jdField_b_of_type_JavaLangString;
    localaztw.i = jdField_c_of_type_JavaLangString;
    if (localaztw.jdField_a_of_type_Int == 5) {
      localaztw.g = jdField_a_of_type_JavaLangString;
    }
    localaztw.j = paramString;
    azpn.a(null, localaztw);
  }
  
  public static void d()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    aztw localaztw = a();
    localaztw.jdField_c_of_type_JavaLangString = "0X8008426";
    localaztw.jdField_d_of_type_JavaLangString = "0X8008426";
    azpn.a(null, localaztw);
  }
  
  public static void d(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    aztw localaztw = a();
    localaztw.f = (paramInt + "");
    localaztw.jdField_c_of_type_JavaLangString = "0X800842C";
    localaztw.jdField_d_of_type_JavaLangString = "0X800842C";
    azpn.a(null, localaztw);
  }
  
  public static void d(bmnj parambmnj)
  {
    if ((parambmnj != null) && (parambmnj.a != null) && (parambmnj.a.jdField_a_of_type_Int == 14)) {
      if (parambmnj.a()) {
        break label59;
      }
    }
    label59:
    for (int i = 1;; i = 2)
    {
      azqs.b(null, "dc00898", "", "", "0X800A559", "0X800A559", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void e()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    aztw localaztw = a();
    localaztw.jdField_c_of_type_JavaLangString = "0X8008428";
    localaztw.jdField_d_of_type_JavaLangString = "0X8008428";
    azpn.a(null, localaztw);
  }
  
  public static void e(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {}
    aztw localaztw;
    do
    {
      return;
      localaztw = a();
      localaztw.jdField_c_of_type_JavaLangString = "0X800842D";
      localaztw.jdField_d_of_type_JavaLangString = "0X800842D";
      if (localaztw.jdField_a_of_type_Int == 5) {
        localaztw.g = jdField_a_of_type_JavaLangString;
      }
      localaztw.h = jdField_b_of_type_JavaLangString;
      localaztw.i = jdField_c_of_type_JavaLangString;
      localaztw.j = jdField_d_of_type_JavaLangString;
      localaztw.k = jdField_e_of_type_JavaLangString;
      localaztw.g = jdField_a_of_type_JavaLangString;
      localaztw.l = (paramInt + "");
      azpn.a(null, localaztw);
    } while (!jdField_a_of_type_Boolean);
    localaztw.jdField_c_of_type_JavaLangString = "0X80083AE";
    localaztw.jdField_d_of_type_JavaLangString = "0X80083AE";
    azpn.a(null, localaztw);
  }
  
  public static void e(bmnj parambmnj)
  {
    if ((parambmnj != null) && (parambmnj.a != null) && (parambmnj.a.jdField_a_of_type_Int == 14)) {
      azqs.b(null, "dc00898", "", "", "0X800A558", "0X800A558", 0, 0, "", "", "", "");
    }
  }
  
  public static void f()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    aztw localaztw = a();
    localaztw.jdField_c_of_type_JavaLangString = "0X800842A";
    localaztw.jdField_d_of_type_JavaLangString = "0X800842A";
    azpn.a(null, localaztw);
  }
  
  public static void f(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {}
    aztw localaztw;
    do
    {
      return;
      localaztw = a();
      localaztw.jdField_c_of_type_JavaLangString = "0X800842D";
      localaztw.jdField_d_of_type_JavaLangString = "0X800842D";
      if (localaztw.jdField_a_of_type_Int == 5) {
        localaztw.g = jdField_a_of_type_JavaLangString;
      }
      localaztw.h = jdField_b_of_type_JavaLangString;
      localaztw.i = jdField_c_of_type_JavaLangString;
      localaztw.j = jdField_d_of_type_JavaLangString;
      localaztw.k = jdField_e_of_type_JavaLangString;
      localaztw.l = (paramInt + "");
      azpn.a(null, localaztw);
    } while (!jdField_a_of_type_Boolean);
    localaztw.jdField_c_of_type_JavaLangString = "0X80083AE";
    localaztw.jdField_d_of_type_JavaLangString = "0X80083AE";
    azpn.a(null, localaztw);
  }
  
  public static void f(bmnj parambmnj)
  {
    if ((parambmnj != null) && (parambmnj.a != null) && (parambmnj.a.jdField_a_of_type_Int == 14)) {
      azqs.b(null, "dc00898", "", "", "0X800A557", "0X800A557", 0, 0, "", "", "", "");
    }
  }
  
  public static void g()
  {
    if (jdField_a_of_type_Int == 10002) {
      wxj.a("video_edit", "camera_clkdouble", 0, 0, new String[0]);
    }
  }
  
  public static void g(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {}
    aztw localaztw;
    do
    {
      return;
      localaztw = a();
      localaztw.jdField_c_of_type_JavaLangString = "0X800842E";
      localaztw.jdField_d_of_type_JavaLangString = "0X800842E";
      if (localaztw.jdField_a_of_type_Int == 5) {
        localaztw.g = jdField_a_of_type_JavaLangString;
      }
      localaztw.h = jdField_b_of_type_JavaLangString;
      localaztw.i = jdField_c_of_type_JavaLangString;
      localaztw.j = jdField_d_of_type_JavaLangString;
      localaztw.k = jdField_e_of_type_JavaLangString;
      localaztw.l = (paramInt + "");
      azpn.a(null, localaztw);
    } while (!jdField_a_of_type_Boolean);
    localaztw.jdField_c_of_type_JavaLangString = "0X80083B0";
    localaztw.jdField_d_of_type_JavaLangString = "0X80083B0";
    azpn.a(null, localaztw);
  }
  
  public static void g(bmnj parambmnj)
  {
    if ((parambmnj != null) && (parambmnj.a != null) && (parambmnj.a.jdField_a_of_type_Int == 14)) {
      azqs.b(null, "dc00898", "", "", "0X800A556", "0X800A556", 0, 0, "", "", "", "");
    }
  }
  
  public static void h()
  {
    aztw localaztw = a();
    localaztw.jdField_c_of_type_JavaLangString = "0X8008F10";
    localaztw.jdField_d_of_type_JavaLangString = "0X8008F10";
    azpn.a(null, localaztw);
  }
  
  public static void h(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    aztw localaztw = a();
    localaztw.jdField_c_of_type_JavaLangString = "0X800842F";
    localaztw.jdField_d_of_type_JavaLangString = "0X800842F";
    if (localaztw.jdField_a_of_type_Int == 5) {
      localaztw.g = jdField_a_of_type_JavaLangString;
    }
    localaztw.h = jdField_b_of_type_JavaLangString;
    localaztw.i = jdField_c_of_type_JavaLangString;
    localaztw.j = jdField_d_of_type_JavaLangString;
    localaztw.k = jdField_e_of_type_JavaLangString;
    localaztw.l = (paramInt + "");
    StringBuilder localStringBuilder = new StringBuilder();
    if (jdField_d_of_type_Boolean) {}
    for (paramInt = 2;; paramInt = 1)
    {
      localaztw.m = (paramInt + "");
      azpn.a(null, localaztw);
      return;
    }
  }
  
  public static void h(bmnj parambmnj)
  {
    if ((parambmnj != null) && (parambmnj.a != null) && (parambmnj.a.jdField_a_of_type_Int == 14)) {
      azqs.b(null, "dc00898", "", "", "0X800A555", "0X800A555", 0, 0, "", "", "", "");
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
    aztw localaztw;
    do
    {
      return;
      localaztw = a();
      localaztw.jdField_c_of_type_JavaLangString = "0X8008431";
      localaztw.jdField_d_of_type_JavaLangString = "0X8008431";
      if (localaztw.jdField_a_of_type_Int == 5) {
        localaztw.g = jdField_a_of_type_JavaLangString;
      }
      localaztw.h = jdField_b_of_type_JavaLangString;
      localaztw.i = jdField_c_of_type_JavaLangString;
      localaztw.j = jdField_d_of_type_JavaLangString;
      localaztw.k = jdField_e_of_type_JavaLangString;
      localaztw.l = (paramInt + "");
      localaztw.n = String.valueOf(ajve.a().c);
      localaztw.o = (jdField_a_of_type_Long + "");
      azpn.a(null, localaztw);
    } while (!jdField_a_of_type_Boolean);
    localaztw.jdField_c_of_type_JavaLangString = "0X80083AF";
    localaztw.jdField_d_of_type_JavaLangString = "0X80083AF";
    azpn.a(null, localaztw);
  }
  
  public static void j(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    aztw localaztw = a();
    localaztw.jdField_c_of_type_JavaLangString = "0X8008432";
    localaztw.jdField_d_of_type_JavaLangString = "0X8008432";
    localaztw.h = jdField_b_of_type_JavaLangString;
    localaztw.i = jdField_c_of_type_JavaLangString;
    localaztw.j = jdField_d_of_type_JavaLangString;
    localaztw.k = jdField_e_of_type_JavaLangString;
    if (localaztw.jdField_a_of_type_Int == 5) {
      localaztw.g = jdField_a_of_type_JavaLangString;
    }
    localaztw.l = (paramInt + "");
    StringBuilder localStringBuilder = new StringBuilder();
    if (jdField_c_of_type_Boolean) {}
    for (paramInt = 2;; paramInt = 1)
    {
      localaztw.m = (paramInt + "");
      localaztw.n = String.valueOf(ajve.a().c);
      localaztw.o = (jdField_a_of_type_Long + "");
      azpn.a(null, localaztw);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axpl
 * JD-Core Version:    0.7.0.1
 */