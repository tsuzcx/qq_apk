import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class bisl
{
  public int a;
  public long a;
  public String a;
  private AtomicInteger a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public boolean d;
  public int e;
  public String e;
  public int f;
  public String f;
  public String g = "";
  public String h = "";
  public String i = "";
  public String j = "html";
  public String k = NetworkState.getAPN();
  public String l = "QQ";
  public String m = bmsw.a();
  public String n = "Android";
  
  public bisl()
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_f_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  public JSONObject a()
  {
    label423:
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("uin", this.jdField_a_of_type_Long);
        String str = this.jdField_a_of_type_JavaLangString;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          int i2 = this.jdField_a_of_type_JavaLangString.indexOf('?');
          i1 = i2;
          if (i2 < 0) {
            i1 = this.jdField_a_of_type_JavaLangString.length();
          }
          str = this.jdField_a_of_type_JavaLangString.substring(0, i1);
        }
        localJSONObject.put("url", this.jdField_a_of_type_JavaLangString);
        localJSONObject.put("path", str);
        localJSONObject.put("errordomain", this.jdField_b_of_type_JavaLangString);
        localJSONObject.put("errorcode", this.jdField_c_of_type_JavaLangString);
        localJSONObject.put("httpstatus", this.jdField_d_of_type_JavaLangString);
        localJSONObject.put("userip", this.jdField_e_of_type_JavaLangString);
        localJSONObject.put("serverip", this.jdField_f_of_type_JavaLangString);
        localJSONObject.put("port", this.g);
        localJSONObject.put("dnsresult", this.h);
        localJSONObject.put("apn", this.k);
        localJSONObject.put("timecost", this.jdField_a_of_type_Int / 1000.0F);
        localJSONObject.put("app", this.l);
        localJSONObject.put("appversion", this.m);
        localJSONObject.put("platform", this.n);
        localJSONObject.put("sampling", this.jdField_f_of_type_Int);
        localJSONObject.put("usewns", this.jdField_a_of_type_Boolean);
        int i1 = this.jdField_b_of_type_Int;
        if (i1 != 1000) {
          if (i1 == 0)
          {
            break label423;
            localJSONObject.put("wnscode", i1);
            localJSONObject.put("detail", this.i);
            localJSONObject.put("usecache", this.jdField_b_of_type_Boolean);
            localJSONObject.put("cachehasdata", this.jdField_c_of_type_Boolean);
            localJSONObject.put("cacheupdatepolicy", this.jdField_c_of_type_Int);
            localJSONObject.put("cacheupdatetimecost", this.jdField_d_of_type_Int / 1000.0F);
            localJSONObject.put("serviceversion", this.jdField_e_of_type_Int);
            localJSONObject.put("webso3_type", this.j);
            localJSONObject.put("datasize", this.jdField_b_of_type_Long);
            return localJSONObject;
          }
          else
          {
            i1 = this.jdField_b_of_type_Int;
            i1 += 300000;
            continue;
          }
        }
        i1 = 0;
      }
      catch (Exception localException)
      {
        QLog.e("HybridWebReporter", 1, localException, new Object[0]);
        return null;
      }
    }
  }
  
  public void a()
  {
    this.jdField_e_of_type_Int = 0;
    this.j = "html";
    this.jdField_b_of_type_Long = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bisl
 * JD-Core Version:    0.7.0.1
 */