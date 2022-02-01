import android.util.SparseIntArray;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil.1;
import com.tencent.mobileqq.shortvideo.dancemachine.BoyDataReport;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.text.SimpleDateFormat;
import java.util.Date;

public class banm
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
  
  public static bcuw a()
  {
    bcuw localbcuw = new bcuw();
    localbcuw.jdField_a_of_type_JavaLangString = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    localbcuw.jdField_b_of_type_JavaLangString = "";
    localbcuw.jdField_c_of_type_JavaLangString = "";
    localbcuw.jdField_d_of_type_JavaLangString = "";
    localbcuw.jdField_a_of_type_Int = jdField_a_of_type_AndroidUtilSparseIntArray.get(jdField_a_of_type_Int, -1);
    localbcuw.jdField_e_of_type_JavaLangString = "${count_unknown}";
    localbcuw.f = "";
    localbcuw.g = "";
    localbcuw.h = "";
    localbcuw.i = "";
    localbcuw.j = "";
    localbcuw.k = "";
    localbcuw.l = "";
    localbcuw.m = "";
    localbcuw.n = "";
    localbcuw.o = "";
    localbcuw.p = "";
    localbcuw.q = "";
    localbcuw.r = "";
    localbcuw.s = "";
    localbcuw.t = "";
    localbcuw.u = "";
    return localbcuw;
  }
  
  public static void a()
  {
    bcuw localbcuw = a();
    localbcuw.jdField_c_of_type_JavaLangString = "0X8008423";
    localbcuw.jdField_d_of_type_JavaLangString = "0X8008423";
    bcro.a(null, localbcuw);
  }
  
  public static void a(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bcuw localbcuw = a();
    localbcuw.jdField_c_of_type_JavaLangString = "0X8008754";
    localbcuw.jdField_d_of_type_JavaLangString = "0X8008754";
    localbcuw.n = String.valueOf(paramInt);
    bcro.a(null, localbcuw);
  }
  
  public static void a(int paramInt, String paramString)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bcuw localbcuw = a();
    localbcuw.jdField_c_of_type_JavaLangString = "0X8008430";
    localbcuw.jdField_d_of_type_JavaLangString = "0X8008430";
    localbcuw.jdField_b_of_type_JavaLangString = paramString;
    if (localbcuw.jdField_a_of_type_Int == 5) {
      localbcuw.g = jdField_a_of_type_JavaLangString;
    }
    localbcuw.h = jdField_b_of_type_JavaLangString;
    localbcuw.i = jdField_c_of_type_JavaLangString;
    localbcuw.j = jdField_d_of_type_JavaLangString;
    localbcuw.k = jdField_e_of_type_JavaLangString;
    localbcuw.l = (paramInt + "");
    localbcuw.n = "";
    paramString = new StringBuilder();
    if (jdField_d_of_type_Boolean) {}
    for (int i = 2;; i = 1)
    {
      localbcuw.m = (i + "");
      bcro.a(null, localbcuw);
      if (jdField_a_of_type_Boolean)
      {
        localbcuw.jdField_c_of_type_JavaLangString = "0X80083B2";
        localbcuw.jdField_d_of_type_JavaLangString = "0X80083B2";
        bcro.a(null, localbcuw);
      }
      QmcfManager.getInstance().reportQmcfFrameConsume(paramInt, jdField_a_of_type_Int, jdField_e_of_type_JavaLangString);
      return;
    }
  }
  
  public static void a(long paramLong, int paramInt)
  {
    if (jdField_b_of_type_Boolean)
    {
      bcuw localbcuw = a();
      localbcuw.jdField_c_of_type_JavaLangString = "0X800893A";
      localbcuw.jdField_d_of_type_JavaLangString = "0X800893A";
      localbcuw.h = jdField_b_of_type_JavaLangString;
      localbcuw.i = jdField_c_of_type_JavaLangString;
      localbcuw.f = (paramInt + "");
      if (localbcuw.jdField_a_of_type_Int == 5) {
        localbcuw.g = jdField_a_of_type_JavaLangString;
      }
      localbcuw.o = ((float)paramLong / 1000.0F + "");
      bcro.a(null, localbcuw);
    }
  }
  
  public static void a(bpep parambpep)
  {
    if ((parambpep != null) && (parambpep.a != null) && (parambpep.a.jdField_a_of_type_Int == 14)) {
      if (parambpep.a()) {
        break label57;
      }
    }
    label57:
    for (int i = 1;; i = 2)
    {
      bcst.b(null, "dc00898", "", "", "0X800A55F", "0X800A55F", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void a(bpep parambpep, bptq parambptq)
  {
    if (parambptq == null) {}
    while ((parambpep == null) || (parambpep.a == null) || (parambpep.a.jdField_a_of_type_Int != 14)) {
      return;
    }
    if (parambptq.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      bcst.b(null, "dc00898", "", "", "0X800A55C", "0X800A55C", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void a(bptq parambptq)
  {
    c(null, parambptq);
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
    bcuw localbcuw = a();
    localbcuw.jdField_c_of_type_JavaLangString = "0X8008425";
    localbcuw.jdField_d_of_type_JavaLangString = "0X8008425";
    localbcuw.h = paramString;
    bcro.a(null, localbcuw);
  }
  
  public static void a(String paramString, long paramLong)
  {
    bcuw localbcuw = a();
    localbcuw.jdField_c_of_type_JavaLangString = "0X8008939";
    localbcuw.jdField_d_of_type_JavaLangString = "0X8008939";
    localbcuw.h = jdField_b_of_type_JavaLangString;
    localbcuw.i = jdField_c_of_type_JavaLangString;
    if (localbcuw.jdField_a_of_type_Int == 5) {
      localbcuw.g = jdField_a_of_type_JavaLangString;
    }
    localbcuw.j = paramString;
    localbcuw.o = ((float)paramLong / 1000.0F + "");
    bcro.a(null, localbcuw);
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
    bcuw localbcuw = a();
    localbcuw.jdField_c_of_type_JavaLangString = "0X8008424";
    localbcuw.jdField_d_of_type_JavaLangString = "0X8008424";
    bcro.a(null, localbcuw);
  }
  
  public static void b(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bcuw localbcuw = a();
    localbcuw.jdField_c_of_type_JavaLangString = "0X8008429";
    localbcuw.jdField_d_of_type_JavaLangString = "0X8008429";
    localbcuw.f = (paramInt + "");
    bcro.a(null, localbcuw);
  }
  
  public static void b(int paramInt, String paramString)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bcuw localbcuw = a();
    localbcuw.jdField_c_of_type_JavaLangString = "0X8008433";
    localbcuw.jdField_d_of_type_JavaLangString = "0X8008433";
    localbcuw.jdField_b_of_type_JavaLangString = paramString;
    localbcuw.h = jdField_b_of_type_JavaLangString;
    localbcuw.i = jdField_c_of_type_JavaLangString;
    localbcuw.j = jdField_d_of_type_JavaLangString;
    localbcuw.k = jdField_e_of_type_JavaLangString;
    if (localbcuw.jdField_a_of_type_Int == 5) {
      localbcuw.g = jdField_a_of_type_JavaLangString;
    }
    localbcuw.l = (paramInt + "");
    paramString = new StringBuilder();
    if (jdField_c_of_type_Boolean) {}
    for (int i = 2;; i = 1)
    {
      localbcuw.m = (i + "");
      localbcuw.n = String.valueOf(alnu.a().c);
      localbcuw.o = (jdField_a_of_type_Long + "");
      bcro.a(null, localbcuw);
      if (jdField_a_of_type_Boolean)
      {
        localbcuw.jdField_c_of_type_JavaLangString = "0X80083B1";
        localbcuw.jdField_d_of_type_JavaLangString = "0X80083B1";
        bcro.a(null, localbcuw);
      }
      QmcfManager.getInstance().reportQmcfFrameConsume(paramInt, jdField_a_of_type_Int, jdField_e_of_type_JavaLangString);
      return;
    }
  }
  
  private static void b(long paramLong1, long paramLong2)
  {
    bcuw localbcuw = a();
    localbcuw.jdField_c_of_type_JavaLangString = "0X8008937";
    localbcuw.jdField_d_of_type_JavaLangString = "0X8008937";
    localbcuw.h = jdField_b_of_type_JavaLangString;
    localbcuw.i = jdField_c_of_type_JavaLangString;
    localbcuw.j = ("" + paramLong1);
    if (localbcuw.jdField_a_of_type_Int == 5) {
      localbcuw.g = jdField_a_of_type_JavaLangString;
    }
    localbcuw.o = (paramLong2 / 1000L + "");
    bcro.a(null, localbcuw);
  }
  
  public static void b(bpep parambpep)
  {
    if ((parambpep != null) && (parambpep.a != null) && (parambpep.a.jdField_a_of_type_Int == 14)) {
      if (parambpep.a()) {
        break label59;
      }
    }
    label59:
    for (int i = 1;; i = 2)
    {
      bcst.b(null, "dc00898", "", "", "0X800A55E", "0X800A55E", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void b(bpep parambpep, bptq parambptq)
  {
    if (parambptq == null) {}
    while ((parambpep == null) || (parambpep.a == null) || (parambpep.a.jdField_a_of_type_Int != 14)) {
      return;
    }
    if (parambptq.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      bcst.b(null, "dc00898", "", "", "0X800A55B", "0X800A55B", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void b(String paramString)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bcuw localbcuw = a();
    localbcuw.jdField_c_of_type_JavaLangString = "0X8008427";
    localbcuw.jdField_d_of_type_JavaLangString = "0X8008427";
    localbcuw.j = paramString;
    bcro.a(null, localbcuw);
  }
  
  private static void b(String paramString1, String paramString2, String paramString3)
  {
    bcuw localbcuw = a();
    localbcuw.jdField_c_of_type_JavaLangString = "0X8008936";
    localbcuw.jdField_d_of_type_JavaLangString = "0X8008936";
    localbcuw.h = jdField_b_of_type_JavaLangString;
    localbcuw.i = jdField_c_of_type_JavaLangString;
    localbcuw.j = paramString2;
    localbcuw.k = paramString1;
    if (localbcuw.jdField_a_of_type_Int == 5) {
      localbcuw.g = jdField_a_of_type_JavaLangString;
    }
    localbcuw.l = paramString3;
    bcro.a(null, localbcuw);
  }
  
  public static void c()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bcuw localbcuw = a();
    localbcuw.jdField_c_of_type_JavaLangString = "0X8008753";
    localbcuw.jdField_d_of_type_JavaLangString = "0X8008753";
    bcro.a(null, localbcuw);
  }
  
  public static void c(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bcuw localbcuw = a();
    localbcuw.f = (paramInt + "");
    localbcuw.jdField_c_of_type_JavaLangString = "0X800842B";
    localbcuw.jdField_d_of_type_JavaLangString = "0X800842B";
    bcro.a(null, localbcuw);
  }
  
  public static void c(bpep parambpep)
  {
    if ((parambpep != null) && (parambpep.a != null) && (parambpep.a.jdField_a_of_type_Int == 14)) {
      bcst.b(null, "dc00898", "", "", "0X800A55D", "0X800A55D", 0, 0, "", "", "", "");
    }
  }
  
  public static void c(bpep parambpep, bptq parambptq)
  {
    int i = 1;
    if (parambptq == null) {}
    while ((parambpep != null) && (parambpep.a != null) && (parambpep.a.jdField_a_of_type_Int != 14)) {
      return;
    }
    if (parambptq.jdField_a_of_type_Int == 1)
    {
      parambpep = "2";
      if (!parambptq.jdField_a_of_type_Boolean) {
        break label96;
      }
    }
    for (;;)
    {
      bcst.b(null, "dc00898", "", "", "0X800A55A", "0X800A55A", i, 0, parambpep, "", "", "");
      return;
      if (parambptq.jdField_a_of_type_Int == 0)
      {
        parambpep = "1";
        break;
      }
      parambpep = "3";
      break;
      label96:
      i = 2;
    }
  }
  
  public static void c(String paramString)
  {
    bcuw localbcuw = a();
    localbcuw.jdField_c_of_type_JavaLangString = "0X8008938";
    localbcuw.jdField_d_of_type_JavaLangString = "0X8008938";
    localbcuw.h = jdField_b_of_type_JavaLangString;
    localbcuw.i = jdField_c_of_type_JavaLangString;
    if (localbcuw.jdField_a_of_type_Int == 5) {
      localbcuw.g = jdField_a_of_type_JavaLangString;
    }
    localbcuw.j = paramString;
    bcro.a(null, localbcuw);
  }
  
  public static void d()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bcuw localbcuw = a();
    localbcuw.jdField_c_of_type_JavaLangString = "0X8008426";
    localbcuw.jdField_d_of_type_JavaLangString = "0X8008426";
    bcro.a(null, localbcuw);
  }
  
  public static void d(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bcuw localbcuw = a();
    localbcuw.f = (paramInt + "");
    localbcuw.jdField_c_of_type_JavaLangString = "0X800842C";
    localbcuw.jdField_d_of_type_JavaLangString = "0X800842C";
    bcro.a(null, localbcuw);
  }
  
  public static void d(bpep parambpep)
  {
    if ((parambpep != null) && (parambpep.a != null) && (parambpep.a.jdField_a_of_type_Int == 14)) {
      if (parambpep.a()) {
        break label59;
      }
    }
    label59:
    for (int i = 1;; i = 2)
    {
      bcst.b(null, "dc00898", "", "", "0X800A559", "0X800A559", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void e()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bcuw localbcuw = a();
    localbcuw.jdField_c_of_type_JavaLangString = "0X8008428";
    localbcuw.jdField_d_of_type_JavaLangString = "0X8008428";
    bcro.a(null, localbcuw);
  }
  
  public static void e(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {}
    bcuw localbcuw;
    do
    {
      return;
      localbcuw = a();
      localbcuw.jdField_c_of_type_JavaLangString = "0X800842D";
      localbcuw.jdField_d_of_type_JavaLangString = "0X800842D";
      if (localbcuw.jdField_a_of_type_Int == 5) {
        localbcuw.g = jdField_a_of_type_JavaLangString;
      }
      localbcuw.h = jdField_b_of_type_JavaLangString;
      localbcuw.i = jdField_c_of_type_JavaLangString;
      localbcuw.j = jdField_d_of_type_JavaLangString;
      localbcuw.k = jdField_e_of_type_JavaLangString;
      localbcuw.g = jdField_a_of_type_JavaLangString;
      localbcuw.l = (paramInt + "");
      bcro.a(null, localbcuw);
    } while (!jdField_a_of_type_Boolean);
    localbcuw.jdField_c_of_type_JavaLangString = "0X80083AE";
    localbcuw.jdField_d_of_type_JavaLangString = "0X80083AE";
    bcro.a(null, localbcuw);
  }
  
  public static void e(bpep parambpep)
  {
    if ((parambpep != null) && (parambpep.a != null) && (parambpep.a.jdField_a_of_type_Int == 14)) {
      bcst.b(null, "dc00898", "", "", "0X800A558", "0X800A558", 0, 0, "", "", "", "");
    }
  }
  
  public static void f()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bcuw localbcuw = a();
    localbcuw.jdField_c_of_type_JavaLangString = "0X800842A";
    localbcuw.jdField_d_of_type_JavaLangString = "0X800842A";
    bcro.a(null, localbcuw);
  }
  
  public static void f(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {}
    bcuw localbcuw;
    do
    {
      return;
      localbcuw = a();
      localbcuw.jdField_c_of_type_JavaLangString = "0X800842D";
      localbcuw.jdField_d_of_type_JavaLangString = "0X800842D";
      if (localbcuw.jdField_a_of_type_Int == 5) {
        localbcuw.g = jdField_a_of_type_JavaLangString;
      }
      localbcuw.h = jdField_b_of_type_JavaLangString;
      localbcuw.i = jdField_c_of_type_JavaLangString;
      localbcuw.j = jdField_d_of_type_JavaLangString;
      localbcuw.k = jdField_e_of_type_JavaLangString;
      localbcuw.l = (paramInt + "");
      bcro.a(null, localbcuw);
    } while (!jdField_a_of_type_Boolean);
    localbcuw.jdField_c_of_type_JavaLangString = "0X80083AE";
    localbcuw.jdField_d_of_type_JavaLangString = "0X80083AE";
    bcro.a(null, localbcuw);
  }
  
  public static void f(bpep parambpep)
  {
    if ((parambpep != null) && (parambpep.a != null) && (parambpep.a.jdField_a_of_type_Int == 14)) {
      bcst.b(null, "dc00898", "", "", "0X800A557", "0X800A557", 0, 0, "", "", "", "");
    }
  }
  
  public static void g()
  {
    if (jdField_a_of_type_Int == 10002) {
      yqu.a("video_edit", "camera_clkdouble", 0, 0, new String[0]);
    }
  }
  
  public static void g(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {}
    bcuw localbcuw;
    do
    {
      return;
      localbcuw = a();
      localbcuw.jdField_c_of_type_JavaLangString = "0X800842E";
      localbcuw.jdField_d_of_type_JavaLangString = "0X800842E";
      if (localbcuw.jdField_a_of_type_Int == 5) {
        localbcuw.g = jdField_a_of_type_JavaLangString;
      }
      localbcuw.h = jdField_b_of_type_JavaLangString;
      localbcuw.i = jdField_c_of_type_JavaLangString;
      localbcuw.j = jdField_d_of_type_JavaLangString;
      localbcuw.k = jdField_e_of_type_JavaLangString;
      localbcuw.l = (paramInt + "");
      bcro.a(null, localbcuw);
    } while (!jdField_a_of_type_Boolean);
    localbcuw.jdField_c_of_type_JavaLangString = "0X80083B0";
    localbcuw.jdField_d_of_type_JavaLangString = "0X80083B0";
    bcro.a(null, localbcuw);
  }
  
  public static void g(bpep parambpep)
  {
    if ((parambpep != null) && (parambpep.a != null) && (parambpep.a.jdField_a_of_type_Int == 14)) {
      bcst.b(null, "dc00898", "", "", "0X800A556", "0X800A556", 0, 0, "", "", "", "");
    }
  }
  
  public static void h()
  {
    bcuw localbcuw = a();
    localbcuw.jdField_c_of_type_JavaLangString = "0X8008F10";
    localbcuw.jdField_d_of_type_JavaLangString = "0X8008F10";
    bcro.a(null, localbcuw);
  }
  
  public static void h(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bcuw localbcuw = a();
    localbcuw.jdField_c_of_type_JavaLangString = "0X800842F";
    localbcuw.jdField_d_of_type_JavaLangString = "0X800842F";
    if (localbcuw.jdField_a_of_type_Int == 5) {
      localbcuw.g = jdField_a_of_type_JavaLangString;
    }
    localbcuw.h = jdField_b_of_type_JavaLangString;
    localbcuw.i = jdField_c_of_type_JavaLangString;
    localbcuw.j = jdField_d_of_type_JavaLangString;
    localbcuw.k = jdField_e_of_type_JavaLangString;
    localbcuw.l = (paramInt + "");
    StringBuilder localStringBuilder = new StringBuilder();
    if (jdField_d_of_type_Boolean) {}
    for (paramInt = 2;; paramInt = 1)
    {
      localbcuw.m = (paramInt + "");
      bcro.a(null, localbcuw);
      return;
    }
  }
  
  public static void h(bpep parambpep)
  {
    if ((parambpep != null) && (parambpep.a != null) && (parambpep.a.jdField_a_of_type_Int == 14)) {
      bcst.b(null, "dc00898", "", "", "0X800A555", "0X800A555", 0, 0, "", "", "", "");
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
    bcuw localbcuw;
    do
    {
      return;
      localbcuw = a();
      localbcuw.jdField_c_of_type_JavaLangString = "0X8008431";
      localbcuw.jdField_d_of_type_JavaLangString = "0X8008431";
      if (localbcuw.jdField_a_of_type_Int == 5) {
        localbcuw.g = jdField_a_of_type_JavaLangString;
      }
      localbcuw.h = jdField_b_of_type_JavaLangString;
      localbcuw.i = jdField_c_of_type_JavaLangString;
      localbcuw.j = jdField_d_of_type_JavaLangString;
      localbcuw.k = jdField_e_of_type_JavaLangString;
      localbcuw.l = (paramInt + "");
      localbcuw.n = String.valueOf(alnu.a().c);
      localbcuw.o = (jdField_a_of_type_Long + "");
      bcro.a(null, localbcuw);
    } while (!jdField_a_of_type_Boolean);
    localbcuw.jdField_c_of_type_JavaLangString = "0X80083AF";
    localbcuw.jdField_d_of_type_JavaLangString = "0X80083AF";
    bcro.a(null, localbcuw);
  }
  
  public static void j(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    bcuw localbcuw = a();
    localbcuw.jdField_c_of_type_JavaLangString = "0X8008432";
    localbcuw.jdField_d_of_type_JavaLangString = "0X8008432";
    localbcuw.h = jdField_b_of_type_JavaLangString;
    localbcuw.i = jdField_c_of_type_JavaLangString;
    localbcuw.j = jdField_d_of_type_JavaLangString;
    localbcuw.k = jdField_e_of_type_JavaLangString;
    if (localbcuw.jdField_a_of_type_Int == 5) {
      localbcuw.g = jdField_a_of_type_JavaLangString;
    }
    localbcuw.l = (paramInt + "");
    StringBuilder localStringBuilder = new StringBuilder();
    if (jdField_c_of_type_Boolean) {}
    for (paramInt = 2;; paramInt = 1)
    {
      localbcuw.m = (paramInt + "");
      localbcuw.n = String.valueOf(alnu.a().c);
      localbcuw.o = (jdField_a_of_type_Long + "");
      bcro.a(null, localbcuw);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     banm
 * JD-Core Version:    0.7.0.1
 */