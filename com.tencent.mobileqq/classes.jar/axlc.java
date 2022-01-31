import android.util.SparseIntArray;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil.1;
import com.tencent.mobileqq.shortvideo.dancemachine.BoyDataReport;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.text.SimpleDateFormat;
import java.util.Date;

public class axlc
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
  
  public static azpn a()
  {
    azpn localazpn = new azpn();
    localazpn.jdField_a_of_type_JavaLangString = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    localazpn.jdField_b_of_type_JavaLangString = "";
    localazpn.jdField_c_of_type_JavaLangString = "";
    localazpn.jdField_d_of_type_JavaLangString = "";
    localazpn.jdField_a_of_type_Int = jdField_a_of_type_AndroidUtilSparseIntArray.get(jdField_a_of_type_Int, -1);
    localazpn.jdField_e_of_type_JavaLangString = "${count_unknown}";
    localazpn.f = "";
    localazpn.g = "";
    localazpn.h = "";
    localazpn.i = "";
    localazpn.j = "";
    localazpn.k = "";
    localazpn.l = "";
    localazpn.m = "";
    localazpn.n = "";
    localazpn.o = "";
    localazpn.p = "";
    localazpn.q = "";
    localazpn.r = "";
    localazpn.s = "";
    localazpn.t = "";
    localazpn.u = "";
    return localazpn;
  }
  
  public static void a()
  {
    azpn localazpn = a();
    localazpn.jdField_c_of_type_JavaLangString = "0X8008423";
    localazpn.jdField_d_of_type_JavaLangString = "0X8008423";
    azle.a(null, localazpn);
  }
  
  public static void a(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    azpn localazpn = a();
    localazpn.jdField_c_of_type_JavaLangString = "0X8008754";
    localazpn.jdField_d_of_type_JavaLangString = "0X8008754";
    localazpn.n = String.valueOf(paramInt);
    azle.a(null, localazpn);
  }
  
  public static void a(int paramInt, String paramString)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    azpn localazpn = a();
    localazpn.jdField_c_of_type_JavaLangString = "0X8008430";
    localazpn.jdField_d_of_type_JavaLangString = "0X8008430";
    localazpn.jdField_b_of_type_JavaLangString = paramString;
    if (localazpn.jdField_a_of_type_Int == 5) {
      localazpn.g = jdField_a_of_type_JavaLangString;
    }
    localazpn.h = jdField_b_of_type_JavaLangString;
    localazpn.i = jdField_c_of_type_JavaLangString;
    localazpn.j = jdField_d_of_type_JavaLangString;
    localazpn.k = jdField_e_of_type_JavaLangString;
    localazpn.l = (paramInt + "");
    localazpn.n = "";
    paramString = new StringBuilder();
    if (jdField_d_of_type_Boolean) {}
    for (int i = 2;; i = 1)
    {
      localazpn.m = (i + "");
      azle.a(null, localazpn);
      if (jdField_a_of_type_Boolean)
      {
        localazpn.jdField_c_of_type_JavaLangString = "0X80083B2";
        localazpn.jdField_d_of_type_JavaLangString = "0X80083B2";
        azle.a(null, localazpn);
      }
      QmcfManager.getInstance().reportQmcfFrameConsume(paramInt, jdField_a_of_type_Int, jdField_e_of_type_JavaLangString);
      return;
    }
  }
  
  public static void a(long paramLong, int paramInt)
  {
    if (jdField_b_of_type_Boolean)
    {
      azpn localazpn = a();
      localazpn.jdField_c_of_type_JavaLangString = "0X800893A";
      localazpn.jdField_d_of_type_JavaLangString = "0X800893A";
      localazpn.h = jdField_b_of_type_JavaLangString;
      localazpn.i = jdField_c_of_type_JavaLangString;
      localazpn.f = (paramInt + "");
      if (localazpn.jdField_a_of_type_Int == 5) {
        localazpn.g = jdField_a_of_type_JavaLangString;
      }
      localazpn.o = ((float)paramLong / 1000.0F + "");
      azle.a(null, localazpn);
    }
  }
  
  public static void a(bmix parambmix)
  {
    if ((parambmix != null) && (parambmix.a != null) && (parambmix.a.jdField_a_of_type_Int == 14)) {
      if (parambmix.a()) {
        break label57;
      }
    }
    label57:
    for (int i = 1;; i = 2)
    {
      azmj.b(null, "dc00898", "", "", "0X800A55F", "0X800A55F", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void a(bmix parambmix, bmxy parambmxy)
  {
    if (parambmxy == null) {}
    while ((parambmix == null) || (parambmix.a == null) || (parambmix.a.jdField_a_of_type_Int != 14)) {
      return;
    }
    if (parambmxy.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      azmj.b(null, "dc00898", "", "", "0X800A55C", "0X800A55C", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void a(bmxy parambmxy)
  {
    c(null, parambmxy);
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
    azpn localazpn = a();
    localazpn.jdField_c_of_type_JavaLangString = "0X8008425";
    localazpn.jdField_d_of_type_JavaLangString = "0X8008425";
    localazpn.h = paramString;
    azle.a(null, localazpn);
  }
  
  public static void a(String paramString, long paramLong)
  {
    azpn localazpn = a();
    localazpn.jdField_c_of_type_JavaLangString = "0X8008939";
    localazpn.jdField_d_of_type_JavaLangString = "0X8008939";
    localazpn.h = jdField_b_of_type_JavaLangString;
    localazpn.i = jdField_c_of_type_JavaLangString;
    if (localazpn.jdField_a_of_type_Int == 5) {
      localazpn.g = jdField_a_of_type_JavaLangString;
    }
    localazpn.j = paramString;
    localazpn.o = ((float)paramLong / 1000.0F + "");
    azle.a(null, localazpn);
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
    azpn localazpn = a();
    localazpn.jdField_c_of_type_JavaLangString = "0X8008424";
    localazpn.jdField_d_of_type_JavaLangString = "0X8008424";
    azle.a(null, localazpn);
  }
  
  public static void b(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    azpn localazpn = a();
    localazpn.jdField_c_of_type_JavaLangString = "0X8008429";
    localazpn.jdField_d_of_type_JavaLangString = "0X8008429";
    localazpn.f = (paramInt + "");
    azle.a(null, localazpn);
  }
  
  public static void b(int paramInt, String paramString)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    azpn localazpn = a();
    localazpn.jdField_c_of_type_JavaLangString = "0X8008433";
    localazpn.jdField_d_of_type_JavaLangString = "0X8008433";
    localazpn.jdField_b_of_type_JavaLangString = paramString;
    localazpn.h = jdField_b_of_type_JavaLangString;
    localazpn.i = jdField_c_of_type_JavaLangString;
    localazpn.j = jdField_d_of_type_JavaLangString;
    localazpn.k = jdField_e_of_type_JavaLangString;
    if (localazpn.jdField_a_of_type_Int == 5) {
      localazpn.g = jdField_a_of_type_JavaLangString;
    }
    localazpn.l = (paramInt + "");
    paramString = new StringBuilder();
    if (jdField_c_of_type_Boolean) {}
    for (int i = 2;; i = 1)
    {
      localazpn.m = (i + "");
      localazpn.n = String.valueOf(ajqp.a().c);
      localazpn.o = (jdField_a_of_type_Long + "");
      azle.a(null, localazpn);
      if (jdField_a_of_type_Boolean)
      {
        localazpn.jdField_c_of_type_JavaLangString = "0X80083B1";
        localazpn.jdField_d_of_type_JavaLangString = "0X80083B1";
        azle.a(null, localazpn);
      }
      QmcfManager.getInstance().reportQmcfFrameConsume(paramInt, jdField_a_of_type_Int, jdField_e_of_type_JavaLangString);
      return;
    }
  }
  
  private static void b(long paramLong1, long paramLong2)
  {
    azpn localazpn = a();
    localazpn.jdField_c_of_type_JavaLangString = "0X8008937";
    localazpn.jdField_d_of_type_JavaLangString = "0X8008937";
    localazpn.h = jdField_b_of_type_JavaLangString;
    localazpn.i = jdField_c_of_type_JavaLangString;
    localazpn.j = ("" + paramLong1);
    if (localazpn.jdField_a_of_type_Int == 5) {
      localazpn.g = jdField_a_of_type_JavaLangString;
    }
    localazpn.o = (paramLong2 / 1000L + "");
    azle.a(null, localazpn);
  }
  
  public static void b(bmix parambmix)
  {
    if ((parambmix != null) && (parambmix.a != null) && (parambmix.a.jdField_a_of_type_Int == 14)) {
      if (parambmix.a()) {
        break label59;
      }
    }
    label59:
    for (int i = 1;; i = 2)
    {
      azmj.b(null, "dc00898", "", "", "0X800A55E", "0X800A55E", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void b(bmix parambmix, bmxy parambmxy)
  {
    if (parambmxy == null) {}
    while ((parambmix == null) || (parambmix.a == null) || (parambmix.a.jdField_a_of_type_Int != 14)) {
      return;
    }
    if (parambmxy.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      azmj.b(null, "dc00898", "", "", "0X800A55B", "0X800A55B", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void b(String paramString)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    azpn localazpn = a();
    localazpn.jdField_c_of_type_JavaLangString = "0X8008427";
    localazpn.jdField_d_of_type_JavaLangString = "0X8008427";
    localazpn.j = paramString;
    azle.a(null, localazpn);
  }
  
  private static void b(String paramString1, String paramString2, String paramString3)
  {
    azpn localazpn = a();
    localazpn.jdField_c_of_type_JavaLangString = "0X8008936";
    localazpn.jdField_d_of_type_JavaLangString = "0X8008936";
    localazpn.h = jdField_b_of_type_JavaLangString;
    localazpn.i = jdField_c_of_type_JavaLangString;
    localazpn.j = paramString2;
    localazpn.k = paramString1;
    if (localazpn.jdField_a_of_type_Int == 5) {
      localazpn.g = jdField_a_of_type_JavaLangString;
    }
    localazpn.l = paramString3;
    azle.a(null, localazpn);
  }
  
  public static void c()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    azpn localazpn = a();
    localazpn.jdField_c_of_type_JavaLangString = "0X8008753";
    localazpn.jdField_d_of_type_JavaLangString = "0X8008753";
    azle.a(null, localazpn);
  }
  
  public static void c(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    azpn localazpn = a();
    localazpn.f = (paramInt + "");
    localazpn.jdField_c_of_type_JavaLangString = "0X800842B";
    localazpn.jdField_d_of_type_JavaLangString = "0X800842B";
    azle.a(null, localazpn);
  }
  
  public static void c(bmix parambmix)
  {
    if ((parambmix != null) && (parambmix.a != null) && (parambmix.a.jdField_a_of_type_Int == 14)) {
      azmj.b(null, "dc00898", "", "", "0X800A55D", "0X800A55D", 0, 0, "", "", "", "");
    }
  }
  
  public static void c(bmix parambmix, bmxy parambmxy)
  {
    int i = 1;
    if (parambmxy == null) {}
    while ((parambmix != null) && (parambmix.a != null) && (parambmix.a.jdField_a_of_type_Int != 14)) {
      return;
    }
    if (parambmxy.jdField_a_of_type_Int == 1)
    {
      parambmix = "2";
      if (!parambmxy.jdField_a_of_type_Boolean) {
        break label96;
      }
    }
    for (;;)
    {
      azmj.b(null, "dc00898", "", "", "0X800A55A", "0X800A55A", i, 0, parambmix, "", "", "");
      return;
      if (parambmxy.jdField_a_of_type_Int == 0)
      {
        parambmix = "1";
        break;
      }
      parambmix = "3";
      break;
      label96:
      i = 2;
    }
  }
  
  public static void c(String paramString)
  {
    azpn localazpn = a();
    localazpn.jdField_c_of_type_JavaLangString = "0X8008938";
    localazpn.jdField_d_of_type_JavaLangString = "0X8008938";
    localazpn.h = jdField_b_of_type_JavaLangString;
    localazpn.i = jdField_c_of_type_JavaLangString;
    if (localazpn.jdField_a_of_type_Int == 5) {
      localazpn.g = jdField_a_of_type_JavaLangString;
    }
    localazpn.j = paramString;
    azle.a(null, localazpn);
  }
  
  public static void d()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    azpn localazpn = a();
    localazpn.jdField_c_of_type_JavaLangString = "0X8008426";
    localazpn.jdField_d_of_type_JavaLangString = "0X8008426";
    azle.a(null, localazpn);
  }
  
  public static void d(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    azpn localazpn = a();
    localazpn.f = (paramInt + "");
    localazpn.jdField_c_of_type_JavaLangString = "0X800842C";
    localazpn.jdField_d_of_type_JavaLangString = "0X800842C";
    azle.a(null, localazpn);
  }
  
  public static void d(bmix parambmix)
  {
    if ((parambmix != null) && (parambmix.a != null) && (parambmix.a.jdField_a_of_type_Int == 14)) {
      if (parambmix.a()) {
        break label59;
      }
    }
    label59:
    for (int i = 1;; i = 2)
    {
      azmj.b(null, "dc00898", "", "", "0X800A559", "0X800A559", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void e()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    azpn localazpn = a();
    localazpn.jdField_c_of_type_JavaLangString = "0X8008428";
    localazpn.jdField_d_of_type_JavaLangString = "0X8008428";
    azle.a(null, localazpn);
  }
  
  public static void e(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {}
    azpn localazpn;
    do
    {
      return;
      localazpn = a();
      localazpn.jdField_c_of_type_JavaLangString = "0X800842D";
      localazpn.jdField_d_of_type_JavaLangString = "0X800842D";
      if (localazpn.jdField_a_of_type_Int == 5) {
        localazpn.g = jdField_a_of_type_JavaLangString;
      }
      localazpn.h = jdField_b_of_type_JavaLangString;
      localazpn.i = jdField_c_of_type_JavaLangString;
      localazpn.j = jdField_d_of_type_JavaLangString;
      localazpn.k = jdField_e_of_type_JavaLangString;
      localazpn.g = jdField_a_of_type_JavaLangString;
      localazpn.l = (paramInt + "");
      azle.a(null, localazpn);
    } while (!jdField_a_of_type_Boolean);
    localazpn.jdField_c_of_type_JavaLangString = "0X80083AE";
    localazpn.jdField_d_of_type_JavaLangString = "0X80083AE";
    azle.a(null, localazpn);
  }
  
  public static void e(bmix parambmix)
  {
    if ((parambmix != null) && (parambmix.a != null) && (parambmix.a.jdField_a_of_type_Int == 14)) {
      azmj.b(null, "dc00898", "", "", "0X800A558", "0X800A558", 0, 0, "", "", "", "");
    }
  }
  
  public static void f()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    azpn localazpn = a();
    localazpn.jdField_c_of_type_JavaLangString = "0X800842A";
    localazpn.jdField_d_of_type_JavaLangString = "0X800842A";
    azle.a(null, localazpn);
  }
  
  public static void f(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {}
    azpn localazpn;
    do
    {
      return;
      localazpn = a();
      localazpn.jdField_c_of_type_JavaLangString = "0X800842D";
      localazpn.jdField_d_of_type_JavaLangString = "0X800842D";
      if (localazpn.jdField_a_of_type_Int == 5) {
        localazpn.g = jdField_a_of_type_JavaLangString;
      }
      localazpn.h = jdField_b_of_type_JavaLangString;
      localazpn.i = jdField_c_of_type_JavaLangString;
      localazpn.j = jdField_d_of_type_JavaLangString;
      localazpn.k = jdField_e_of_type_JavaLangString;
      localazpn.l = (paramInt + "");
      azle.a(null, localazpn);
    } while (!jdField_a_of_type_Boolean);
    localazpn.jdField_c_of_type_JavaLangString = "0X80083AE";
    localazpn.jdField_d_of_type_JavaLangString = "0X80083AE";
    azle.a(null, localazpn);
  }
  
  public static void f(bmix parambmix)
  {
    if ((parambmix != null) && (parambmix.a != null) && (parambmix.a.jdField_a_of_type_Int == 14)) {
      azmj.b(null, "dc00898", "", "", "0X800A557", "0X800A557", 0, 0, "", "", "", "");
    }
  }
  
  public static void g()
  {
    if (jdField_a_of_type_Int == 10002) {
      wta.a("video_edit", "camera_clkdouble", 0, 0, new String[0]);
    }
  }
  
  public static void g(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {}
    azpn localazpn;
    do
    {
      return;
      localazpn = a();
      localazpn.jdField_c_of_type_JavaLangString = "0X800842E";
      localazpn.jdField_d_of_type_JavaLangString = "0X800842E";
      if (localazpn.jdField_a_of_type_Int == 5) {
        localazpn.g = jdField_a_of_type_JavaLangString;
      }
      localazpn.h = jdField_b_of_type_JavaLangString;
      localazpn.i = jdField_c_of_type_JavaLangString;
      localazpn.j = jdField_d_of_type_JavaLangString;
      localazpn.k = jdField_e_of_type_JavaLangString;
      localazpn.l = (paramInt + "");
      azle.a(null, localazpn);
    } while (!jdField_a_of_type_Boolean);
    localazpn.jdField_c_of_type_JavaLangString = "0X80083B0";
    localazpn.jdField_d_of_type_JavaLangString = "0X80083B0";
    azle.a(null, localazpn);
  }
  
  public static void g(bmix parambmix)
  {
    if ((parambmix != null) && (parambmix.a != null) && (parambmix.a.jdField_a_of_type_Int == 14)) {
      azmj.b(null, "dc00898", "", "", "0X800A556", "0X800A556", 0, 0, "", "", "", "");
    }
  }
  
  public static void h()
  {
    azpn localazpn = a();
    localazpn.jdField_c_of_type_JavaLangString = "0X8008F10";
    localazpn.jdField_d_of_type_JavaLangString = "0X8008F10";
    azle.a(null, localazpn);
  }
  
  public static void h(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    azpn localazpn = a();
    localazpn.jdField_c_of_type_JavaLangString = "0X800842F";
    localazpn.jdField_d_of_type_JavaLangString = "0X800842F";
    if (localazpn.jdField_a_of_type_Int == 5) {
      localazpn.g = jdField_a_of_type_JavaLangString;
    }
    localazpn.h = jdField_b_of_type_JavaLangString;
    localazpn.i = jdField_c_of_type_JavaLangString;
    localazpn.j = jdField_d_of_type_JavaLangString;
    localazpn.k = jdField_e_of_type_JavaLangString;
    localazpn.l = (paramInt + "");
    StringBuilder localStringBuilder = new StringBuilder();
    if (jdField_d_of_type_Boolean) {}
    for (paramInt = 2;; paramInt = 1)
    {
      localazpn.m = (paramInt + "");
      azle.a(null, localazpn);
      return;
    }
  }
  
  public static void h(bmix parambmix)
  {
    if ((parambmix != null) && (parambmix.a != null) && (parambmix.a.jdField_a_of_type_Int == 14)) {
      azmj.b(null, "dc00898", "", "", "0X800A555", "0X800A555", 0, 0, "", "", "", "");
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
    azpn localazpn;
    do
    {
      return;
      localazpn = a();
      localazpn.jdField_c_of_type_JavaLangString = "0X8008431";
      localazpn.jdField_d_of_type_JavaLangString = "0X8008431";
      if (localazpn.jdField_a_of_type_Int == 5) {
        localazpn.g = jdField_a_of_type_JavaLangString;
      }
      localazpn.h = jdField_b_of_type_JavaLangString;
      localazpn.i = jdField_c_of_type_JavaLangString;
      localazpn.j = jdField_d_of_type_JavaLangString;
      localazpn.k = jdField_e_of_type_JavaLangString;
      localazpn.l = (paramInt + "");
      localazpn.n = String.valueOf(ajqp.a().c);
      localazpn.o = (jdField_a_of_type_Long + "");
      azle.a(null, localazpn);
    } while (!jdField_a_of_type_Boolean);
    localazpn.jdField_c_of_type_JavaLangString = "0X80083AF";
    localazpn.jdField_d_of_type_JavaLangString = "0X80083AF";
    azle.a(null, localazpn);
  }
  
  public static void j(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    azpn localazpn = a();
    localazpn.jdField_c_of_type_JavaLangString = "0X8008432";
    localazpn.jdField_d_of_type_JavaLangString = "0X8008432";
    localazpn.h = jdField_b_of_type_JavaLangString;
    localazpn.i = jdField_c_of_type_JavaLangString;
    localazpn.j = jdField_d_of_type_JavaLangString;
    localazpn.k = jdField_e_of_type_JavaLangString;
    if (localazpn.jdField_a_of_type_Int == 5) {
      localazpn.g = jdField_a_of_type_JavaLangString;
    }
    localazpn.l = (paramInt + "");
    StringBuilder localStringBuilder = new StringBuilder();
    if (jdField_c_of_type_Boolean) {}
    for (paramInt = 2;; paramInt = 1)
    {
      localazpn.m = (paramInt + "");
      localazpn.n = String.valueOf(ajqp.a().c);
      localazpn.o = (jdField_a_of_type_Long + "");
      azle.a(null, localazpn);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axlc
 * JD-Core Version:    0.7.0.1
 */