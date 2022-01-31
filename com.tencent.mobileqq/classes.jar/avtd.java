import android.util.SparseIntArray;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil.1;
import com.tencent.mobileqq.shortvideo.dancemachine.BoyDataReport;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.text.SimpleDateFormat;
import java.util.Date;

public class avtd
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
  
  public static axtu a()
  {
    axtu localaxtu = new axtu();
    localaxtu.jdField_a_of_type_JavaLangString = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    localaxtu.jdField_b_of_type_JavaLangString = "";
    localaxtu.jdField_c_of_type_JavaLangString = "";
    localaxtu.jdField_d_of_type_JavaLangString = "";
    localaxtu.jdField_a_of_type_Int = jdField_a_of_type_AndroidUtilSparseIntArray.get(jdField_a_of_type_Int, -1);
    localaxtu.jdField_e_of_type_JavaLangString = "${count_unknown}";
    localaxtu.f = "";
    localaxtu.g = "";
    localaxtu.h = "";
    localaxtu.i = "";
    localaxtu.j = "";
    localaxtu.k = "";
    localaxtu.l = "";
    localaxtu.m = "";
    localaxtu.n = "";
    localaxtu.o = "";
    localaxtu.p = "";
    localaxtu.q = "";
    localaxtu.r = "";
    localaxtu.s = "";
    localaxtu.t = "";
    localaxtu.u = "";
    return localaxtu;
  }
  
  public static void a()
  {
    axtu localaxtu = a();
    localaxtu.jdField_c_of_type_JavaLangString = "0X8008423";
    localaxtu.jdField_d_of_type_JavaLangString = "0X8008423";
    axpt.a(null, localaxtu);
  }
  
  public static void a(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    axtu localaxtu = a();
    localaxtu.jdField_c_of_type_JavaLangString = "0X8008754";
    localaxtu.jdField_d_of_type_JavaLangString = "0X8008754";
    localaxtu.n = String.valueOf(paramInt);
    axpt.a(null, localaxtu);
  }
  
  public static void a(int paramInt, String paramString)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    axtu localaxtu = a();
    localaxtu.jdField_c_of_type_JavaLangString = "0X8008430";
    localaxtu.jdField_d_of_type_JavaLangString = "0X8008430";
    localaxtu.jdField_b_of_type_JavaLangString = paramString;
    if (localaxtu.jdField_a_of_type_Int == 5) {
      localaxtu.g = jdField_a_of_type_JavaLangString;
    }
    localaxtu.h = jdField_b_of_type_JavaLangString;
    localaxtu.i = jdField_c_of_type_JavaLangString;
    localaxtu.j = jdField_d_of_type_JavaLangString;
    localaxtu.k = jdField_e_of_type_JavaLangString;
    localaxtu.l = (paramInt + "");
    localaxtu.n = "";
    paramString = new StringBuilder();
    if (jdField_d_of_type_Boolean) {}
    for (int i = 2;; i = 1)
    {
      localaxtu.m = (i + "");
      axpt.a(null, localaxtu);
      if (jdField_a_of_type_Boolean)
      {
        localaxtu.jdField_c_of_type_JavaLangString = "0X80083B2";
        localaxtu.jdField_d_of_type_JavaLangString = "0X80083B2";
        axpt.a(null, localaxtu);
      }
      QmcfManager.getInstance().reportQmcfFrameConsume(paramInt, jdField_a_of_type_Int, jdField_e_of_type_JavaLangString);
      return;
    }
  }
  
  public static void a(long paramLong, int paramInt)
  {
    if (jdField_b_of_type_Boolean)
    {
      axtu localaxtu = a();
      localaxtu.jdField_c_of_type_JavaLangString = "0X800893A";
      localaxtu.jdField_d_of_type_JavaLangString = "0X800893A";
      localaxtu.h = jdField_b_of_type_JavaLangString;
      localaxtu.i = jdField_c_of_type_JavaLangString;
      localaxtu.f = (paramInt + "");
      if (localaxtu.jdField_a_of_type_Int == 5) {
        localaxtu.g = jdField_a_of_type_JavaLangString;
      }
      localaxtu.o = ((float)paramLong / 1000.0F + "");
      axpt.a(null, localaxtu);
    }
  }
  
  public static void a(bjxn parambjxn)
  {
    if ((parambjxn != null) && (parambjxn.a != null) && (parambjxn.a.jdField_a_of_type_Int == 14)) {
      if (parambjxn.a()) {
        break label57;
      }
    }
    label57:
    for (int i = 1;; i = 2)
    {
      axqy.b(null, "dc00898", "", "", "0X800A55F", "0X800A55F", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void a(bjxn parambjxn, bkmo parambkmo)
  {
    if (parambkmo == null) {}
    while ((parambjxn == null) || (parambjxn.a == null) || (parambjxn.a.jdField_a_of_type_Int != 14)) {
      return;
    }
    if (parambkmo.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      axqy.b(null, "dc00898", "", "", "0X800A55C", "0X800A55C", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void a(bkmo parambkmo)
  {
    c(null, parambkmo);
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
    axtu localaxtu = a();
    localaxtu.jdField_c_of_type_JavaLangString = "0X8008425";
    localaxtu.jdField_d_of_type_JavaLangString = "0X8008425";
    localaxtu.h = paramString;
    axpt.a(null, localaxtu);
  }
  
  public static void a(String paramString, long paramLong)
  {
    axtu localaxtu = a();
    localaxtu.jdField_c_of_type_JavaLangString = "0X8008939";
    localaxtu.jdField_d_of_type_JavaLangString = "0X8008939";
    localaxtu.h = jdField_b_of_type_JavaLangString;
    localaxtu.i = jdField_c_of_type_JavaLangString;
    if (localaxtu.jdField_a_of_type_Int == 5) {
      localaxtu.g = jdField_a_of_type_JavaLangString;
    }
    localaxtu.j = paramString;
    localaxtu.o = ((float)paramLong / 1000.0F + "");
    axpt.a(null, localaxtu);
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
    axtu localaxtu = a();
    localaxtu.jdField_c_of_type_JavaLangString = "0X8008424";
    localaxtu.jdField_d_of_type_JavaLangString = "0X8008424";
    axpt.a(null, localaxtu);
  }
  
  public static void b(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    axtu localaxtu = a();
    localaxtu.jdField_c_of_type_JavaLangString = "0X8008429";
    localaxtu.jdField_d_of_type_JavaLangString = "0X8008429";
    localaxtu.f = (paramInt + "");
    axpt.a(null, localaxtu);
  }
  
  public static void b(int paramInt, String paramString)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    axtu localaxtu = a();
    localaxtu.jdField_c_of_type_JavaLangString = "0X8008433";
    localaxtu.jdField_d_of_type_JavaLangString = "0X8008433";
    localaxtu.jdField_b_of_type_JavaLangString = paramString;
    localaxtu.h = jdField_b_of_type_JavaLangString;
    localaxtu.i = jdField_c_of_type_JavaLangString;
    localaxtu.j = jdField_d_of_type_JavaLangString;
    localaxtu.k = jdField_e_of_type_JavaLangString;
    if (localaxtu.jdField_a_of_type_Int == 5) {
      localaxtu.g = jdField_a_of_type_JavaLangString;
    }
    localaxtu.l = (paramInt + "");
    paramString = new StringBuilder();
    if (jdField_c_of_type_Boolean) {}
    for (int i = 2;; i = 1)
    {
      localaxtu.m = (i + "");
      localaxtu.n = String.valueOf(ahzf.a().c);
      localaxtu.o = (jdField_a_of_type_Long + "");
      axpt.a(null, localaxtu);
      if (jdField_a_of_type_Boolean)
      {
        localaxtu.jdField_c_of_type_JavaLangString = "0X80083B1";
        localaxtu.jdField_d_of_type_JavaLangString = "0X80083B1";
        axpt.a(null, localaxtu);
      }
      QmcfManager.getInstance().reportQmcfFrameConsume(paramInt, jdField_a_of_type_Int, jdField_e_of_type_JavaLangString);
      return;
    }
  }
  
  private static void b(long paramLong1, long paramLong2)
  {
    axtu localaxtu = a();
    localaxtu.jdField_c_of_type_JavaLangString = "0X8008937";
    localaxtu.jdField_d_of_type_JavaLangString = "0X8008937";
    localaxtu.h = jdField_b_of_type_JavaLangString;
    localaxtu.i = jdField_c_of_type_JavaLangString;
    localaxtu.j = ("" + paramLong1);
    if (localaxtu.jdField_a_of_type_Int == 5) {
      localaxtu.g = jdField_a_of_type_JavaLangString;
    }
    localaxtu.o = (paramLong2 / 1000L + "");
    axpt.a(null, localaxtu);
  }
  
  public static void b(bjxn parambjxn)
  {
    if ((parambjxn != null) && (parambjxn.a != null) && (parambjxn.a.jdField_a_of_type_Int == 14)) {
      if (parambjxn.a()) {
        break label59;
      }
    }
    label59:
    for (int i = 1;; i = 2)
    {
      axqy.b(null, "dc00898", "", "", "0X800A55E", "0X800A55E", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void b(bjxn parambjxn, bkmo parambkmo)
  {
    if (parambkmo == null) {}
    while ((parambjxn == null) || (parambjxn.a == null) || (parambjxn.a.jdField_a_of_type_Int != 14)) {
      return;
    }
    if (parambkmo.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      axqy.b(null, "dc00898", "", "", "0X800A55B", "0X800A55B", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void b(String paramString)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    axtu localaxtu = a();
    localaxtu.jdField_c_of_type_JavaLangString = "0X8008427";
    localaxtu.jdField_d_of_type_JavaLangString = "0X8008427";
    localaxtu.j = paramString;
    axpt.a(null, localaxtu);
  }
  
  private static void b(String paramString1, String paramString2, String paramString3)
  {
    axtu localaxtu = a();
    localaxtu.jdField_c_of_type_JavaLangString = "0X8008936";
    localaxtu.jdField_d_of_type_JavaLangString = "0X8008936";
    localaxtu.h = jdField_b_of_type_JavaLangString;
    localaxtu.i = jdField_c_of_type_JavaLangString;
    localaxtu.j = paramString2;
    localaxtu.k = paramString1;
    if (localaxtu.jdField_a_of_type_Int == 5) {
      localaxtu.g = jdField_a_of_type_JavaLangString;
    }
    localaxtu.l = paramString3;
    axpt.a(null, localaxtu);
  }
  
  public static void c()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    axtu localaxtu = a();
    localaxtu.jdField_c_of_type_JavaLangString = "0X8008753";
    localaxtu.jdField_d_of_type_JavaLangString = "0X8008753";
    axpt.a(null, localaxtu);
  }
  
  public static void c(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    axtu localaxtu = a();
    localaxtu.f = (paramInt + "");
    localaxtu.jdField_c_of_type_JavaLangString = "0X800842B";
    localaxtu.jdField_d_of_type_JavaLangString = "0X800842B";
    axpt.a(null, localaxtu);
  }
  
  public static void c(bjxn parambjxn)
  {
    if ((parambjxn != null) && (parambjxn.a != null) && (parambjxn.a.jdField_a_of_type_Int == 14)) {
      axqy.b(null, "dc00898", "", "", "0X800A55D", "0X800A55D", 0, 0, "", "", "", "");
    }
  }
  
  public static void c(bjxn parambjxn, bkmo parambkmo)
  {
    int i = 1;
    if (parambkmo == null) {}
    while ((parambjxn != null) && (parambjxn.a != null) && (parambjxn.a.jdField_a_of_type_Int != 14)) {
      return;
    }
    if (parambkmo.jdField_a_of_type_Int == 1)
    {
      parambjxn = "2";
      if (!parambkmo.jdField_a_of_type_Boolean) {
        break label96;
      }
    }
    for (;;)
    {
      axqy.b(null, "dc00898", "", "", "0X800A55A", "0X800A55A", i, 0, parambjxn, "", "", "");
      return;
      if (parambkmo.jdField_a_of_type_Int == 0)
      {
        parambjxn = "1";
        break;
      }
      parambjxn = "3";
      break;
      label96:
      i = 2;
    }
  }
  
  public static void c(String paramString)
  {
    axtu localaxtu = a();
    localaxtu.jdField_c_of_type_JavaLangString = "0X8008938";
    localaxtu.jdField_d_of_type_JavaLangString = "0X8008938";
    localaxtu.h = jdField_b_of_type_JavaLangString;
    localaxtu.i = jdField_c_of_type_JavaLangString;
    if (localaxtu.jdField_a_of_type_Int == 5) {
      localaxtu.g = jdField_a_of_type_JavaLangString;
    }
    localaxtu.j = paramString;
    axpt.a(null, localaxtu);
  }
  
  public static void d()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    axtu localaxtu = a();
    localaxtu.jdField_c_of_type_JavaLangString = "0X8008426";
    localaxtu.jdField_d_of_type_JavaLangString = "0X8008426";
    axpt.a(null, localaxtu);
  }
  
  public static void d(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    axtu localaxtu = a();
    localaxtu.f = (paramInt + "");
    localaxtu.jdField_c_of_type_JavaLangString = "0X800842C";
    localaxtu.jdField_d_of_type_JavaLangString = "0X800842C";
    axpt.a(null, localaxtu);
  }
  
  public static void d(bjxn parambjxn)
  {
    if ((parambjxn != null) && (parambjxn.a != null) && (parambjxn.a.jdField_a_of_type_Int == 14)) {
      if (parambjxn.a()) {
        break label59;
      }
    }
    label59:
    for (int i = 1;; i = 2)
    {
      axqy.b(null, "dc00898", "", "", "0X800A559", "0X800A559", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void e()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    axtu localaxtu = a();
    localaxtu.jdField_c_of_type_JavaLangString = "0X8008428";
    localaxtu.jdField_d_of_type_JavaLangString = "0X8008428";
    axpt.a(null, localaxtu);
  }
  
  public static void e(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {}
    axtu localaxtu;
    do
    {
      return;
      localaxtu = a();
      localaxtu.jdField_c_of_type_JavaLangString = "0X800842D";
      localaxtu.jdField_d_of_type_JavaLangString = "0X800842D";
      if (localaxtu.jdField_a_of_type_Int == 5) {
        localaxtu.g = jdField_a_of_type_JavaLangString;
      }
      localaxtu.h = jdField_b_of_type_JavaLangString;
      localaxtu.i = jdField_c_of_type_JavaLangString;
      localaxtu.j = jdField_d_of_type_JavaLangString;
      localaxtu.k = jdField_e_of_type_JavaLangString;
      localaxtu.g = jdField_a_of_type_JavaLangString;
      localaxtu.l = (paramInt + "");
      axpt.a(null, localaxtu);
    } while (!jdField_a_of_type_Boolean);
    localaxtu.jdField_c_of_type_JavaLangString = "0X80083AE";
    localaxtu.jdField_d_of_type_JavaLangString = "0X80083AE";
    axpt.a(null, localaxtu);
  }
  
  public static void e(bjxn parambjxn)
  {
    if ((parambjxn != null) && (parambjxn.a != null) && (parambjxn.a.jdField_a_of_type_Int == 14)) {
      axqy.b(null, "dc00898", "", "", "0X800A558", "0X800A558", 0, 0, "", "", "", "");
    }
  }
  
  public static void f()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    axtu localaxtu = a();
    localaxtu.jdField_c_of_type_JavaLangString = "0X800842A";
    localaxtu.jdField_d_of_type_JavaLangString = "0X800842A";
    axpt.a(null, localaxtu);
  }
  
  public static void f(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {}
    axtu localaxtu;
    do
    {
      return;
      localaxtu = a();
      localaxtu.jdField_c_of_type_JavaLangString = "0X800842D";
      localaxtu.jdField_d_of_type_JavaLangString = "0X800842D";
      if (localaxtu.jdField_a_of_type_Int == 5) {
        localaxtu.g = jdField_a_of_type_JavaLangString;
      }
      localaxtu.h = jdField_b_of_type_JavaLangString;
      localaxtu.i = jdField_c_of_type_JavaLangString;
      localaxtu.j = jdField_d_of_type_JavaLangString;
      localaxtu.k = jdField_e_of_type_JavaLangString;
      localaxtu.l = (paramInt + "");
      axpt.a(null, localaxtu);
    } while (!jdField_a_of_type_Boolean);
    localaxtu.jdField_c_of_type_JavaLangString = "0X80083AE";
    localaxtu.jdField_d_of_type_JavaLangString = "0X80083AE";
    axpt.a(null, localaxtu);
  }
  
  public static void f(bjxn parambjxn)
  {
    if ((parambjxn != null) && (parambjxn.a != null) && (parambjxn.a.jdField_a_of_type_Int == 14)) {
      axqy.b(null, "dc00898", "", "", "0X800A557", "0X800A557", 0, 0, "", "", "", "");
    }
  }
  
  public static void g()
  {
    if (jdField_a_of_type_Int == 10002) {
      vei.a("video_edit", "camera_clkdouble", 0, 0, new String[0]);
    }
  }
  
  public static void g(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {}
    axtu localaxtu;
    do
    {
      return;
      localaxtu = a();
      localaxtu.jdField_c_of_type_JavaLangString = "0X800842E";
      localaxtu.jdField_d_of_type_JavaLangString = "0X800842E";
      if (localaxtu.jdField_a_of_type_Int == 5) {
        localaxtu.g = jdField_a_of_type_JavaLangString;
      }
      localaxtu.h = jdField_b_of_type_JavaLangString;
      localaxtu.i = jdField_c_of_type_JavaLangString;
      localaxtu.j = jdField_d_of_type_JavaLangString;
      localaxtu.k = jdField_e_of_type_JavaLangString;
      localaxtu.l = (paramInt + "");
      axpt.a(null, localaxtu);
    } while (!jdField_a_of_type_Boolean);
    localaxtu.jdField_c_of_type_JavaLangString = "0X80083B0";
    localaxtu.jdField_d_of_type_JavaLangString = "0X80083B0";
    axpt.a(null, localaxtu);
  }
  
  public static void g(bjxn parambjxn)
  {
    if ((parambjxn != null) && (parambjxn.a != null) && (parambjxn.a.jdField_a_of_type_Int == 14)) {
      axqy.b(null, "dc00898", "", "", "0X800A556", "0X800A556", 0, 0, "", "", "", "");
    }
  }
  
  public static void h()
  {
    axtu localaxtu = a();
    localaxtu.jdField_c_of_type_JavaLangString = "0X8008F10";
    localaxtu.jdField_d_of_type_JavaLangString = "0X8008F10";
    axpt.a(null, localaxtu);
  }
  
  public static void h(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    axtu localaxtu = a();
    localaxtu.jdField_c_of_type_JavaLangString = "0X800842F";
    localaxtu.jdField_d_of_type_JavaLangString = "0X800842F";
    if (localaxtu.jdField_a_of_type_Int == 5) {
      localaxtu.g = jdField_a_of_type_JavaLangString;
    }
    localaxtu.h = jdField_b_of_type_JavaLangString;
    localaxtu.i = jdField_c_of_type_JavaLangString;
    localaxtu.j = jdField_d_of_type_JavaLangString;
    localaxtu.k = jdField_e_of_type_JavaLangString;
    localaxtu.l = (paramInt + "");
    StringBuilder localStringBuilder = new StringBuilder();
    if (jdField_d_of_type_Boolean) {}
    for (paramInt = 2;; paramInt = 1)
    {
      localaxtu.m = (paramInt + "");
      axpt.a(null, localaxtu);
      return;
    }
  }
  
  public static void h(bjxn parambjxn)
  {
    if ((parambjxn != null) && (parambjxn.a != null) && (parambjxn.a.jdField_a_of_type_Int == 14)) {
      axqy.b(null, "dc00898", "", "", "0X800A555", "0X800A555", 0, 0, "", "", "", "");
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
    axtu localaxtu;
    do
    {
      return;
      localaxtu = a();
      localaxtu.jdField_c_of_type_JavaLangString = "0X8008431";
      localaxtu.jdField_d_of_type_JavaLangString = "0X8008431";
      if (localaxtu.jdField_a_of_type_Int == 5) {
        localaxtu.g = jdField_a_of_type_JavaLangString;
      }
      localaxtu.h = jdField_b_of_type_JavaLangString;
      localaxtu.i = jdField_c_of_type_JavaLangString;
      localaxtu.j = jdField_d_of_type_JavaLangString;
      localaxtu.k = jdField_e_of_type_JavaLangString;
      localaxtu.l = (paramInt + "");
      localaxtu.n = String.valueOf(ahzf.a().c);
      localaxtu.o = (jdField_a_of_type_Long + "");
      axpt.a(null, localaxtu);
    } while (!jdField_a_of_type_Boolean);
    localaxtu.jdField_c_of_type_JavaLangString = "0X80083AF";
    localaxtu.jdField_d_of_type_JavaLangString = "0X80083AF";
    axpt.a(null, localaxtu);
  }
  
  public static void j(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    axtu localaxtu = a();
    localaxtu.jdField_c_of_type_JavaLangString = "0X8008432";
    localaxtu.jdField_d_of_type_JavaLangString = "0X8008432";
    localaxtu.h = jdField_b_of_type_JavaLangString;
    localaxtu.i = jdField_c_of_type_JavaLangString;
    localaxtu.j = jdField_d_of_type_JavaLangString;
    localaxtu.k = jdField_e_of_type_JavaLangString;
    if (localaxtu.jdField_a_of_type_Int == 5) {
      localaxtu.g = jdField_a_of_type_JavaLangString;
    }
    localaxtu.l = (paramInt + "");
    StringBuilder localStringBuilder = new StringBuilder();
    if (jdField_c_of_type_Boolean) {}
    for (paramInt = 2;; paramInt = 1)
    {
      localaxtu.m = (paramInt + "");
      localaxtu.n = String.valueOf(ahzf.a().c);
      localaxtu.o = (jdField_a_of_type_Long + "");
      axpt.a(null, localaxtu);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avtd
 * JD-Core Version:    0.7.0.1
 */