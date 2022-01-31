import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.now.NowDataReporter.1;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONObject;

public class asyp
{
  public static long a;
  protected int a;
  String jdField_a_of_type_JavaLangString;
  HashMap<Long, JSONObject> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  protected boolean a;
  protected int b;
  String b;
  protected boolean b;
  protected int c;
  String c;
  protected int d;
  protected String d;
  protected int e;
  protected String e;
  protected int f;
  protected String f;
  protected String g = "";
  protected String h = "";
  protected String i = "";
  protected String j = "";
  protected String k = "";
  protected String l;
  protected String m = Build.VERSION.RELEASE;
  protected String n = Build.MODEL;
  protected String o;
  String p;
  
  public asyp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_e_of_type_Int = 2;
    a("now_plugin");
  }
  
  private void a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, int paramInt1, int paramInt2, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean2)
  {
    if (paramLong == 0L) {
      return;
    }
    JSONObject localJSONObject;
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong)))
    {
      localJSONObject = new JSONObject();
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), localJSONObject);
    }
    for (;;)
    {
      try
      {
        if (localJSONObject.optBoolean("noneedadd")) {
          break label223;
        }
        localJSONObject.put("opname", paramString4);
        localJSONObject.put("roomid", paramString2);
        localJSONObject.put("roomtype", paramString3);
        localJSONObject.put("source", paramString1);
        localJSONObject.put("d1", paramString5);
        localJSONObject.put("d2", paramString6);
        localJSONObject.put("d3", paramString7);
        localJSONObject.put("d4", paramString8);
        localJSONObject.put("op_in", paramInt1);
        localJSONObject.put("op_result", paramInt2);
        localJSONObject.put("noneedadd", paramBoolean1);
        localJSONObject.put("timelong", paramString9);
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), localJSONObject);
        if (!paramBoolean2) {
          break;
        }
        a(paramLong);
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      localJSONObject = (JSONObject)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      continue;
      label223:
      QLog.i("NowDataReporter", 1, "本次opname不影响上报");
    }
  }
  
  private void c()
  {
    jdField_a_of_type_Long = 0L;
    this.jdField_f_of_type_JavaLangString = "";
    this.g = "";
    this.h = "";
    this.i = "";
    this.j = "";
    this.k = "";
    this.jdField_a_of_type_Int = 11;
    this.jdField_d_of_type_Int = 0;
    this.l = "";
    this.jdField_f_of_type_Int = 0;
  }
  
  public asyp a(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
    return this;
  }
  
  public void a()
  {
    for (;;)
    {
      try
      {
        asyp localasyp = b("show_loading");
        if (!this.jdField_a_of_type_Boolean) {
          continue;
        }
        str = "1";
        localasyp.c(str).b();
      }
      catch (Exception localException)
      {
        String str;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("NowDataReporter", 2, "reportJumpPlugin Exception");
        continue;
      }
      a(jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "show_loading", false, this.jdField_f_of_type_Int, this.jdField_d_of_type_Int, this.h, this.i, this.j, this.k, "", false);
      return;
      str = "0";
    }
  }
  
  public void a(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    try
    {
      b("get_record_res").c(String.valueOf(paramInt1)).d(paramString).e(String.valueOf(paramInt2)).i(String.valueOf(paramLong)).b();
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("NowDataReporter", 2, "reportRecordCgi Exception");
    }
  }
  
  public void a(long paramLong)
  {
    JSONObject localJSONObject = (JSONObject)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if ((localJSONObject != null) && (localJSONObject.has("opname")))
    {
      a("last_op_name", localJSONObject);
      this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramLong));
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    for (;;)
    {
      try
      {
        this.jdField_f_of_type_JavaLangString = paramBundle.getString("op_name");
        if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
          break;
        }
        bool2 = false;
        int i2 = 1;
        bool4 = false;
        this.jdField_f_of_type_Int = paramBundle.getInt("op_in");
        this.jdField_d_of_type_Int = paramBundle.getInt("op_result");
        this.l = paramBundle.getString("timeconsume");
        String str = paramBundle.getString("sdkversion");
        if ((!TextUtils.isEmpty(str)) && (!str.equals("0"))) {
          this.p = paramBundle.getString("sdkversion");
        }
        this.h = paramBundle.getString("d1");
        this.i = paramBundle.getString("d2");
        this.j = paramBundle.getString("d3");
        this.k = paramBundle.getString("d4");
        if (this.jdField_f_of_type_JavaLangString.equals("enter_shadow"))
        {
          this.jdField_b_of_type_Int = Integer.parseInt(paramBundle.getString("status1", "0"));
          this.jdField_a_of_type_Int = paramBundle.getInt("frameVersion");
        }
        b();
        if ((this.jdField_f_of_type_JavaLangString.equals("check_version_complete")) && (this.j.equals("1")))
        {
          this.jdField_a_of_type_Boolean = false;
          this.jdField_b_of_type_Int = 0;
        }
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(jdField_a_of_type_Long))) {
          break;
        }
        if ((this.jdField_f_of_type_JavaLangString.equals("cancel_run")) || (this.jdField_f_of_type_JavaLangString.equals("cancel_in_plugin")) || (this.jdField_f_of_type_JavaLangString.equals("download_fail")) || (this.jdField_f_of_type_JavaLangString.equals("boot_fail")) || (this.jdField_f_of_type_JavaLangString.equals("login_fail")) || (this.jdField_f_of_type_JavaLangString.equals("enter_fail")) || (this.jdField_f_of_type_JavaLangString.equals("user_cancel_in_plugin")) || (this.jdField_f_of_type_JavaLangString.equals("enter_room")) || (this.jdField_f_of_type_JavaLangString.equals("jump_h5")) || (this.jdField_f_of_type_JavaLangString.equals("jump_app"))) {
          break label715;
        }
        boolean bool3 = bool2;
        boolean bool1 = bool4;
        if (this.jdField_f_of_type_JavaLangString.equals("download_biz_plugin"))
        {
          bool3 = bool2;
          bool1 = bool4;
          if (this.h.equals("fail"))
          {
            bool3 = true;
            bool1 = true;
          }
        }
        bool4 = bool3;
        bool2 = bool1;
        if (this.jdField_f_of_type_JavaLangString.equals("unzip_biz_plugin"))
        {
          bool4 = bool3;
          bool2 = bool1;
          if (this.h.equals("fail"))
          {
            bool4 = true;
            bool2 = true;
          }
        }
        int i1 = i2;
        if (this.jdField_f_of_type_JavaLangString.equals("download_start"))
        {
          i1 = i2;
          if (this.h.equals("2")) {
            i1 = 0;
          }
        }
        i2 = i1;
        if (this.jdField_f_of_type_JavaLangString.equals("download_complete"))
        {
          i2 = i1;
          if (this.h.equals("2")) {
            i2 = 0;
          }
        }
        i1 = i2;
        if (this.jdField_f_of_type_JavaLangString.equals("download_fail"))
        {
          i1 = i2;
          if (this.h.equals("2")) {
            i1 = 0;
          }
        }
        i2 = i1;
        if (this.jdField_f_of_type_JavaLangString.equals("install_start"))
        {
          i2 = i1;
          if (this.jdField_f_of_type_Int != 1) {
            i2 = 0;
          }
        }
        i1 = i2;
        if (this.jdField_f_of_type_JavaLangString.equals("install_complete"))
        {
          i1 = i2;
          if (this.jdField_f_of_type_Int != 1) {
            i1 = 0;
          }
        }
        i2 = i1;
        if (this.jdField_f_of_type_JavaLangString.equals("install_fail"))
        {
          i2 = i1;
          if (this.jdField_f_of_type_Int != 1) {
            i2 = 0;
          }
        }
        if (i2 == 0) {
          break;
        }
        a(jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, bool4, this.jdField_f_of_type_Int, this.jdField_d_of_type_Int, this.h, this.i, this.j, this.k, this.l, bool2);
        return;
      }
      catch (Exception paramBundle) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("NowDataReporter", 2, "onReportFromXProxy Exception");
      return;
      label715:
      boolean bool2 = true;
      boolean bool4 = true;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      h(paramString1).f(paramString2).b("jump_h5").c(paramString3).d(paramString4).b();
      a(jdField_a_of_type_Long, paramString1, paramString2, this.jdField_c_of_type_JavaLangString, "jump_h5", true, this.jdField_f_of_type_Int, this.jdField_d_of_type_Int, this.h, this.i, this.j, this.k, "", true);
      return;
    }
    catch (Exception paramString3)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NowDataReporter", 2, "reportJumpH5 Exception");
        }
      }
    }
  }
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("opname");
    int i1 = paramJSONObject.optInt("op_in");
    int i2 = paramJSONObject.optInt("op_result");
    String str2 = paramJSONObject.optString("d1");
    String str3 = paramJSONObject.optString("d2");
    String str4 = paramJSONObject.optString("d3");
    String str5 = paramJSONObject.optString("d4");
    String str6 = paramJSONObject.optString("source");
    String str7 = paramJSONObject.optString("roomid");
    paramJSONObject = paramJSONObject.optString("roomtype");
    String str8 = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
    String str9 = String.valueOf(aowf.a(BaseApplicationImpl.getContext()));
    this.jdField_d_of_type_JavaLangString = (ndd.a() + "");
    QLog.i("NowDataReporter", 2, "nowDatareportlastop: source = " + str6 + " roomid = " + str7 + " roomType = " + paramJSONObject + " op_name = " + paramString + " op_in = " + i1 + " d1= " + str2 + " d2=" + str3 + " d3=" + str4 + " d4=" + str5 + " timelong=" + this.l + " op_result = " + i2 + " qq_version = " + str9 + "  optime = " + str8 + " lastOpName = " + str1 + " pluginstatus =" + this.jdField_b_of_type_Int + " preloadStatus =" + this.jdField_c_of_type_Int + " sdkversion = " + this.p + " useShadow =" + this.jdField_b_of_type_Boolean);
    azmj.b(null, "dc02882", "grp_lbs", this.g, this.jdField_e_of_type_JavaLangString, paramString, i1, 1, i2, str2, str3, str4, str5 + "|" + this.l + "|" + str7 + "|" + paramJSONObject + "|" + str6 + "|" + this.jdField_d_of_type_JavaLangString + "|" + this.jdField_e_of_type_Int + "|" + this.n + "|" + this.m + "|" + this.jdField_a_of_type_Int + "|" + this.p + "|" + str9 + "|" + str8 + "|" + str1 + "|" + this.jdField_b_of_type_Int + "|" + this.jdField_c_of_type_Int + "|" + this.jdField_b_of_type_Boolean);
  }
  
  public void a(boolean paramBoolean1, String paramString1, String paramString2, String paramString3, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    c();
    long l1 = System.currentTimeMillis();
    jdField_a_of_type_Long = l1;
    this.jdField_b_of_type_Boolean = paramBoolean4;
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_Int = 11;
    }
    this.jdField_a_of_type_Boolean = paramBoolean1;
    try
    {
      localasyp = h(paramString1).f(paramString2).g(paramString3).b("nowentry");
      if (!paramBoolean1) {
        break label175;
      }
      str1 = "1";
      localasyp = localasyp.c(str1);
      if (!paramBoolean2) {
        break label209;
      }
      str1 = "1";
    }
    catch (Exception localException)
    {
      for (;;)
      {
        asyp localasyp;
        String str1;
        if (QLog.isColorLevel())
        {
          QLog.d("NowDataReporter", 2, "reportNowEntry Exception");
          continue;
          String str2 = "0";
        }
      }
    }
    localasyp = localasyp.d(str1);
    if (paramBoolean3) {}
    for (str1 = "1";; str1 = "0")
    {
      localasyp.e(str1).b();
      a(jdField_a_of_type_Long, paramString1, paramString2, paramString3, "now_entry", false, 0, 0, this.h, this.i, this.j, this.k, "", false);
      new Handler().postDelayed(new NowDataReporter.1(this, l1), 90000L);
      return;
      label175:
      str1 = "0";
      break;
    }
  }
  
  public asyp b(String paramString)
  {
    this.jdField_f_of_type_JavaLangString = paramString;
    return this;
  }
  
  public void b()
  {
    String str1 = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
    String str2 = String.valueOf(aowf.a(BaseApplicationImpl.getContext()));
    this.jdField_d_of_type_JavaLangString = (ndd.a() + "");
    QLog.i("NowDataReporter", 1, "nowDatareport: source = " + this.jdField_a_of_type_JavaLangString + " roomid = " + this.jdField_b_of_type_JavaLangString + " roomType = " + this.jdField_c_of_type_JavaLangString + " op_name = " + this.jdField_f_of_type_JavaLangString + " op_in = " + this.jdField_f_of_type_Int + " d1= " + this.h + " d2=" + this.i + " d3=" + this.j + " d4=" + this.k + " timelong=" + this.l + " op_result = " + this.jdField_d_of_type_Int + " qq_version = " + str2 + "  optime = " + str1 + " lastOpName = " + this.o + " pluginstatus =" + this.jdField_b_of_type_Int + " preloadStatus =" + this.jdField_c_of_type_Int + " sdkversion = " + this.p + "useShadow =" + this.jdField_b_of_type_Boolean);
    azmj.b(null, "dc02882", "grp_lbs", this.g, this.jdField_e_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, this.jdField_f_of_type_Int, 1, this.jdField_d_of_type_Int, this.h, this.i, this.j, this.k + "|" + this.l + "|" + this.jdField_b_of_type_JavaLangString + "|" + this.jdField_c_of_type_JavaLangString + "|" + this.jdField_a_of_type_JavaLangString + "|" + this.jdField_d_of_type_JavaLangString + "|" + this.jdField_e_of_type_Int + "|" + this.n + "|" + this.m + "|" + this.jdField_a_of_type_Int + "|" + this.p + "|" + str2 + "|" + str1 + "|" + this.o + "|" + this.jdField_b_of_type_Int + "|" + this.jdField_c_of_type_Int + "|" + this.jdField_b_of_type_Boolean);
  }
  
  public asyp c(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public asyp d(String paramString)
  {
    this.i = paramString;
    return this;
  }
  
  public asyp e(String paramString)
  {
    this.j = paramString;
    return this;
  }
  
  public asyp f(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public asyp g(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    return this;
  }
  
  public asyp h(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public asyp i(String paramString)
  {
    this.l = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asyp
 * JD-Core Version:    0.7.0.1
 */