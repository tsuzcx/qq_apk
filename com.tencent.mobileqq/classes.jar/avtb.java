import android.util.SparseIntArray;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil.1;
import com.tencent.mobileqq.shortvideo.dancemachine.BoyDataReport;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.text.SimpleDateFormat;
import java.util.Date;

public class avtb
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
  
  public static axts a()
  {
    axts localaxts = new axts();
    localaxts.jdField_a_of_type_JavaLangString = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    localaxts.jdField_b_of_type_JavaLangString = "";
    localaxts.jdField_c_of_type_JavaLangString = "";
    localaxts.jdField_d_of_type_JavaLangString = "";
    localaxts.jdField_a_of_type_Int = jdField_a_of_type_AndroidUtilSparseIntArray.get(jdField_a_of_type_Int, -1);
    localaxts.jdField_e_of_type_JavaLangString = "${count_unknown}";
    localaxts.f = "";
    localaxts.g = "";
    localaxts.h = "";
    localaxts.i = "";
    localaxts.j = "";
    localaxts.k = "";
    localaxts.l = "";
    localaxts.m = "";
    localaxts.n = "";
    localaxts.o = "";
    localaxts.p = "";
    localaxts.q = "";
    localaxts.r = "";
    localaxts.s = "";
    localaxts.t = "";
    localaxts.u = "";
    return localaxts;
  }
  
  public static void a()
  {
    axts localaxts = a();
    localaxts.jdField_c_of_type_JavaLangString = "0X8008423";
    localaxts.jdField_d_of_type_JavaLangString = "0X8008423";
    axpr.a(null, localaxts);
  }
  
  public static void a(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    axts localaxts = a();
    localaxts.jdField_c_of_type_JavaLangString = "0X8008754";
    localaxts.jdField_d_of_type_JavaLangString = "0X8008754";
    localaxts.n = String.valueOf(paramInt);
    axpr.a(null, localaxts);
  }
  
  public static void a(int paramInt, String paramString)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    axts localaxts = a();
    localaxts.jdField_c_of_type_JavaLangString = "0X8008430";
    localaxts.jdField_d_of_type_JavaLangString = "0X8008430";
    localaxts.jdField_b_of_type_JavaLangString = paramString;
    if (localaxts.jdField_a_of_type_Int == 5) {
      localaxts.g = jdField_a_of_type_JavaLangString;
    }
    localaxts.h = jdField_b_of_type_JavaLangString;
    localaxts.i = jdField_c_of_type_JavaLangString;
    localaxts.j = jdField_d_of_type_JavaLangString;
    localaxts.k = jdField_e_of_type_JavaLangString;
    localaxts.l = (paramInt + "");
    localaxts.n = "";
    paramString = new StringBuilder();
    if (jdField_d_of_type_Boolean) {}
    for (int i = 2;; i = 1)
    {
      localaxts.m = (i + "");
      axpr.a(null, localaxts);
      if (jdField_a_of_type_Boolean)
      {
        localaxts.jdField_c_of_type_JavaLangString = "0X80083B2";
        localaxts.jdField_d_of_type_JavaLangString = "0X80083B2";
        axpr.a(null, localaxts);
      }
      QmcfManager.getInstance().reportQmcfFrameConsume(paramInt, jdField_a_of_type_Int, jdField_e_of_type_JavaLangString);
      return;
    }
  }
  
  public static void a(long paramLong, int paramInt)
  {
    if (jdField_b_of_type_Boolean)
    {
      axts localaxts = a();
      localaxts.jdField_c_of_type_JavaLangString = "0X800893A";
      localaxts.jdField_d_of_type_JavaLangString = "0X800893A";
      localaxts.h = jdField_b_of_type_JavaLangString;
      localaxts.i = jdField_c_of_type_JavaLangString;
      localaxts.f = (paramInt + "");
      if (localaxts.jdField_a_of_type_Int == 5) {
        localaxts.g = jdField_a_of_type_JavaLangString;
      }
      localaxts.o = ((float)paramLong / 1000.0F + "");
      axpr.a(null, localaxts);
    }
  }
  
  public static void a(bjww parambjww)
  {
    if ((parambjww != null) && (parambjww.a != null) && (parambjww.a.jdField_a_of_type_Int == 14)) {
      if (parambjww.a()) {
        break label57;
      }
    }
    label57:
    for (int i = 1;; i = 2)
    {
      axqw.b(null, "dc00898", "", "", "0X800A55F", "0X800A55F", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void a(bjww parambjww, bklx parambklx)
  {
    if (parambklx == null) {}
    while ((parambjww == null) || (parambjww.a == null) || (parambjww.a.jdField_a_of_type_Int != 14)) {
      return;
    }
    if (parambklx.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      axqw.b(null, "dc00898", "", "", "0X800A55C", "0X800A55C", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void a(bklx parambklx)
  {
    c(null, parambklx);
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
    axts localaxts = a();
    localaxts.jdField_c_of_type_JavaLangString = "0X8008425";
    localaxts.jdField_d_of_type_JavaLangString = "0X8008425";
    localaxts.h = paramString;
    axpr.a(null, localaxts);
  }
  
  public static void a(String paramString, long paramLong)
  {
    axts localaxts = a();
    localaxts.jdField_c_of_type_JavaLangString = "0X8008939";
    localaxts.jdField_d_of_type_JavaLangString = "0X8008939";
    localaxts.h = jdField_b_of_type_JavaLangString;
    localaxts.i = jdField_c_of_type_JavaLangString;
    if (localaxts.jdField_a_of_type_Int == 5) {
      localaxts.g = jdField_a_of_type_JavaLangString;
    }
    localaxts.j = paramString;
    localaxts.o = ((float)paramLong / 1000.0F + "");
    axpr.a(null, localaxts);
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
    axts localaxts = a();
    localaxts.jdField_c_of_type_JavaLangString = "0X8008424";
    localaxts.jdField_d_of_type_JavaLangString = "0X8008424";
    axpr.a(null, localaxts);
  }
  
  public static void b(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    axts localaxts = a();
    localaxts.jdField_c_of_type_JavaLangString = "0X8008429";
    localaxts.jdField_d_of_type_JavaLangString = "0X8008429";
    localaxts.f = (paramInt + "");
    axpr.a(null, localaxts);
  }
  
  public static void b(int paramInt, String paramString)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    axts localaxts = a();
    localaxts.jdField_c_of_type_JavaLangString = "0X8008433";
    localaxts.jdField_d_of_type_JavaLangString = "0X8008433";
    localaxts.jdField_b_of_type_JavaLangString = paramString;
    localaxts.h = jdField_b_of_type_JavaLangString;
    localaxts.i = jdField_c_of_type_JavaLangString;
    localaxts.j = jdField_d_of_type_JavaLangString;
    localaxts.k = jdField_e_of_type_JavaLangString;
    if (localaxts.jdField_a_of_type_Int == 5) {
      localaxts.g = jdField_a_of_type_JavaLangString;
    }
    localaxts.l = (paramInt + "");
    paramString = new StringBuilder();
    if (jdField_c_of_type_Boolean) {}
    for (int i = 2;; i = 1)
    {
      localaxts.m = (i + "");
      localaxts.n = String.valueOf(ahzh.a().c);
      localaxts.o = (jdField_a_of_type_Long + "");
      axpr.a(null, localaxts);
      if (jdField_a_of_type_Boolean)
      {
        localaxts.jdField_c_of_type_JavaLangString = "0X80083B1";
        localaxts.jdField_d_of_type_JavaLangString = "0X80083B1";
        axpr.a(null, localaxts);
      }
      QmcfManager.getInstance().reportQmcfFrameConsume(paramInt, jdField_a_of_type_Int, jdField_e_of_type_JavaLangString);
      return;
    }
  }
  
  private static void b(long paramLong1, long paramLong2)
  {
    axts localaxts = a();
    localaxts.jdField_c_of_type_JavaLangString = "0X8008937";
    localaxts.jdField_d_of_type_JavaLangString = "0X8008937";
    localaxts.h = jdField_b_of_type_JavaLangString;
    localaxts.i = jdField_c_of_type_JavaLangString;
    localaxts.j = ("" + paramLong1);
    if (localaxts.jdField_a_of_type_Int == 5) {
      localaxts.g = jdField_a_of_type_JavaLangString;
    }
    localaxts.o = (paramLong2 / 1000L + "");
    axpr.a(null, localaxts);
  }
  
  public static void b(bjww parambjww)
  {
    if ((parambjww != null) && (parambjww.a != null) && (parambjww.a.jdField_a_of_type_Int == 14)) {
      if (parambjww.a()) {
        break label59;
      }
    }
    label59:
    for (int i = 1;; i = 2)
    {
      axqw.b(null, "dc00898", "", "", "0X800A55E", "0X800A55E", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void b(bjww parambjww, bklx parambklx)
  {
    if (parambklx == null) {}
    while ((parambjww == null) || (parambjww.a == null) || (parambjww.a.jdField_a_of_type_Int != 14)) {
      return;
    }
    if (parambklx.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      axqw.b(null, "dc00898", "", "", "0X800A55B", "0X800A55B", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void b(String paramString)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    axts localaxts = a();
    localaxts.jdField_c_of_type_JavaLangString = "0X8008427";
    localaxts.jdField_d_of_type_JavaLangString = "0X8008427";
    localaxts.j = paramString;
    axpr.a(null, localaxts);
  }
  
  private static void b(String paramString1, String paramString2, String paramString3)
  {
    axts localaxts = a();
    localaxts.jdField_c_of_type_JavaLangString = "0X8008936";
    localaxts.jdField_d_of_type_JavaLangString = "0X8008936";
    localaxts.h = jdField_b_of_type_JavaLangString;
    localaxts.i = jdField_c_of_type_JavaLangString;
    localaxts.j = paramString2;
    localaxts.k = paramString1;
    if (localaxts.jdField_a_of_type_Int == 5) {
      localaxts.g = jdField_a_of_type_JavaLangString;
    }
    localaxts.l = paramString3;
    axpr.a(null, localaxts);
  }
  
  public static void c()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    axts localaxts = a();
    localaxts.jdField_c_of_type_JavaLangString = "0X8008753";
    localaxts.jdField_d_of_type_JavaLangString = "0X8008753";
    axpr.a(null, localaxts);
  }
  
  public static void c(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    axts localaxts = a();
    localaxts.f = (paramInt + "");
    localaxts.jdField_c_of_type_JavaLangString = "0X800842B";
    localaxts.jdField_d_of_type_JavaLangString = "0X800842B";
    axpr.a(null, localaxts);
  }
  
  public static void c(bjww parambjww)
  {
    if ((parambjww != null) && (parambjww.a != null) && (parambjww.a.jdField_a_of_type_Int == 14)) {
      axqw.b(null, "dc00898", "", "", "0X800A55D", "0X800A55D", 0, 0, "", "", "", "");
    }
  }
  
  public static void c(bjww parambjww, bklx parambklx)
  {
    int i = 1;
    if (parambklx == null) {}
    while ((parambjww != null) && (parambjww.a != null) && (parambjww.a.jdField_a_of_type_Int != 14)) {
      return;
    }
    if (parambklx.jdField_a_of_type_Int == 1)
    {
      parambjww = "2";
      if (!parambklx.jdField_a_of_type_Boolean) {
        break label96;
      }
    }
    for (;;)
    {
      axqw.b(null, "dc00898", "", "", "0X800A55A", "0X800A55A", i, 0, parambjww, "", "", "");
      return;
      if (parambklx.jdField_a_of_type_Int == 0)
      {
        parambjww = "1";
        break;
      }
      parambjww = "3";
      break;
      label96:
      i = 2;
    }
  }
  
  public static void c(String paramString)
  {
    axts localaxts = a();
    localaxts.jdField_c_of_type_JavaLangString = "0X8008938";
    localaxts.jdField_d_of_type_JavaLangString = "0X8008938";
    localaxts.h = jdField_b_of_type_JavaLangString;
    localaxts.i = jdField_c_of_type_JavaLangString;
    if (localaxts.jdField_a_of_type_Int == 5) {
      localaxts.g = jdField_a_of_type_JavaLangString;
    }
    localaxts.j = paramString;
    axpr.a(null, localaxts);
  }
  
  public static void d()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    axts localaxts = a();
    localaxts.jdField_c_of_type_JavaLangString = "0X8008426";
    localaxts.jdField_d_of_type_JavaLangString = "0X8008426";
    axpr.a(null, localaxts);
  }
  
  public static void d(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    axts localaxts = a();
    localaxts.f = (paramInt + "");
    localaxts.jdField_c_of_type_JavaLangString = "0X800842C";
    localaxts.jdField_d_of_type_JavaLangString = "0X800842C";
    axpr.a(null, localaxts);
  }
  
  public static void d(bjww parambjww)
  {
    if ((parambjww != null) && (parambjww.a != null) && (parambjww.a.jdField_a_of_type_Int == 14)) {
      if (parambjww.a()) {
        break label59;
      }
    }
    label59:
    for (int i = 1;; i = 2)
    {
      axqw.b(null, "dc00898", "", "", "0X800A559", "0X800A559", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void e()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    axts localaxts = a();
    localaxts.jdField_c_of_type_JavaLangString = "0X8008428";
    localaxts.jdField_d_of_type_JavaLangString = "0X8008428";
    axpr.a(null, localaxts);
  }
  
  public static void e(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {}
    axts localaxts;
    do
    {
      return;
      localaxts = a();
      localaxts.jdField_c_of_type_JavaLangString = "0X800842D";
      localaxts.jdField_d_of_type_JavaLangString = "0X800842D";
      if (localaxts.jdField_a_of_type_Int == 5) {
        localaxts.g = jdField_a_of_type_JavaLangString;
      }
      localaxts.h = jdField_b_of_type_JavaLangString;
      localaxts.i = jdField_c_of_type_JavaLangString;
      localaxts.j = jdField_d_of_type_JavaLangString;
      localaxts.k = jdField_e_of_type_JavaLangString;
      localaxts.g = jdField_a_of_type_JavaLangString;
      localaxts.l = (paramInt + "");
      axpr.a(null, localaxts);
    } while (!jdField_a_of_type_Boolean);
    localaxts.jdField_c_of_type_JavaLangString = "0X80083AE";
    localaxts.jdField_d_of_type_JavaLangString = "0X80083AE";
    axpr.a(null, localaxts);
  }
  
  public static void e(bjww parambjww)
  {
    if ((parambjww != null) && (parambjww.a != null) && (parambjww.a.jdField_a_of_type_Int == 14)) {
      axqw.b(null, "dc00898", "", "", "0X800A558", "0X800A558", 0, 0, "", "", "", "");
    }
  }
  
  public static void f()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    axts localaxts = a();
    localaxts.jdField_c_of_type_JavaLangString = "0X800842A";
    localaxts.jdField_d_of_type_JavaLangString = "0X800842A";
    axpr.a(null, localaxts);
  }
  
  public static void f(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {}
    axts localaxts;
    do
    {
      return;
      localaxts = a();
      localaxts.jdField_c_of_type_JavaLangString = "0X800842D";
      localaxts.jdField_d_of_type_JavaLangString = "0X800842D";
      if (localaxts.jdField_a_of_type_Int == 5) {
        localaxts.g = jdField_a_of_type_JavaLangString;
      }
      localaxts.h = jdField_b_of_type_JavaLangString;
      localaxts.i = jdField_c_of_type_JavaLangString;
      localaxts.j = jdField_d_of_type_JavaLangString;
      localaxts.k = jdField_e_of_type_JavaLangString;
      localaxts.l = (paramInt + "");
      axpr.a(null, localaxts);
    } while (!jdField_a_of_type_Boolean);
    localaxts.jdField_c_of_type_JavaLangString = "0X80083AE";
    localaxts.jdField_d_of_type_JavaLangString = "0X80083AE";
    axpr.a(null, localaxts);
  }
  
  public static void f(bjww parambjww)
  {
    if ((parambjww != null) && (parambjww.a != null) && (parambjww.a.jdField_a_of_type_Int == 14)) {
      axqw.b(null, "dc00898", "", "", "0X800A557", "0X800A557", 0, 0, "", "", "", "");
    }
  }
  
  public static void g()
  {
    if (jdField_a_of_type_Int == 10002) {
      vel.a("video_edit", "camera_clkdouble", 0, 0, new String[0]);
    }
  }
  
  public static void g(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {}
    axts localaxts;
    do
    {
      return;
      localaxts = a();
      localaxts.jdField_c_of_type_JavaLangString = "0X800842E";
      localaxts.jdField_d_of_type_JavaLangString = "0X800842E";
      if (localaxts.jdField_a_of_type_Int == 5) {
        localaxts.g = jdField_a_of_type_JavaLangString;
      }
      localaxts.h = jdField_b_of_type_JavaLangString;
      localaxts.i = jdField_c_of_type_JavaLangString;
      localaxts.j = jdField_d_of_type_JavaLangString;
      localaxts.k = jdField_e_of_type_JavaLangString;
      localaxts.l = (paramInt + "");
      axpr.a(null, localaxts);
    } while (!jdField_a_of_type_Boolean);
    localaxts.jdField_c_of_type_JavaLangString = "0X80083B0";
    localaxts.jdField_d_of_type_JavaLangString = "0X80083B0";
    axpr.a(null, localaxts);
  }
  
  public static void g(bjww parambjww)
  {
    if ((parambjww != null) && (parambjww.a != null) && (parambjww.a.jdField_a_of_type_Int == 14)) {
      axqw.b(null, "dc00898", "", "", "0X800A556", "0X800A556", 0, 0, "", "", "", "");
    }
  }
  
  public static void h()
  {
    axts localaxts = a();
    localaxts.jdField_c_of_type_JavaLangString = "0X8008F10";
    localaxts.jdField_d_of_type_JavaLangString = "0X8008F10";
    axpr.a(null, localaxts);
  }
  
  public static void h(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    axts localaxts = a();
    localaxts.jdField_c_of_type_JavaLangString = "0X800842F";
    localaxts.jdField_d_of_type_JavaLangString = "0X800842F";
    if (localaxts.jdField_a_of_type_Int == 5) {
      localaxts.g = jdField_a_of_type_JavaLangString;
    }
    localaxts.h = jdField_b_of_type_JavaLangString;
    localaxts.i = jdField_c_of_type_JavaLangString;
    localaxts.j = jdField_d_of_type_JavaLangString;
    localaxts.k = jdField_e_of_type_JavaLangString;
    localaxts.l = (paramInt + "");
    StringBuilder localStringBuilder = new StringBuilder();
    if (jdField_d_of_type_Boolean) {}
    for (paramInt = 2;; paramInt = 1)
    {
      localaxts.m = (paramInt + "");
      axpr.a(null, localaxts);
      return;
    }
  }
  
  public static void h(bjww parambjww)
  {
    if ((parambjww != null) && (parambjww.a != null) && (parambjww.a.jdField_a_of_type_Int == 14)) {
      axqw.b(null, "dc00898", "", "", "0X800A555", "0X800A555", 0, 0, "", "", "", "");
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
    axts localaxts;
    do
    {
      return;
      localaxts = a();
      localaxts.jdField_c_of_type_JavaLangString = "0X8008431";
      localaxts.jdField_d_of_type_JavaLangString = "0X8008431";
      if (localaxts.jdField_a_of_type_Int == 5) {
        localaxts.g = jdField_a_of_type_JavaLangString;
      }
      localaxts.h = jdField_b_of_type_JavaLangString;
      localaxts.i = jdField_c_of_type_JavaLangString;
      localaxts.j = jdField_d_of_type_JavaLangString;
      localaxts.k = jdField_e_of_type_JavaLangString;
      localaxts.l = (paramInt + "");
      localaxts.n = String.valueOf(ahzh.a().c);
      localaxts.o = (jdField_a_of_type_Long + "");
      axpr.a(null, localaxts);
    } while (!jdField_a_of_type_Boolean);
    localaxts.jdField_c_of_type_JavaLangString = "0X80083AF";
    localaxts.jdField_d_of_type_JavaLangString = "0X80083AF";
    axpr.a(null, localaxts);
  }
  
  public static void j(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    axts localaxts = a();
    localaxts.jdField_c_of_type_JavaLangString = "0X8008432";
    localaxts.jdField_d_of_type_JavaLangString = "0X8008432";
    localaxts.h = jdField_b_of_type_JavaLangString;
    localaxts.i = jdField_c_of_type_JavaLangString;
    localaxts.j = jdField_d_of_type_JavaLangString;
    localaxts.k = jdField_e_of_type_JavaLangString;
    if (localaxts.jdField_a_of_type_Int == 5) {
      localaxts.g = jdField_a_of_type_JavaLangString;
    }
    localaxts.l = (paramInt + "");
    StringBuilder localStringBuilder = new StringBuilder();
    if (jdField_c_of_type_Boolean) {}
    for (paramInt = 2;; paramInt = 1)
    {
      localaxts.m = (paramInt + "");
      localaxts.n = String.valueOf(ahzh.a().c);
      localaxts.o = (jdField_a_of_type_Long + "");
      axpr.a(null, localaxts);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avtb
 * JD-Core Version:    0.7.0.1
 */