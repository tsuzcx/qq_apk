import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class bedj
{
  public int a;
  public long a;
  public String a;
  private ArrayList<String> a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  private boolean b;
  public int c;
  public String c;
  public int d;
  public String d;
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  public String j = "";
  public String k = "";
  public String l = "";
  public String m;
  
  public bedj()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
  }
  
  private HashMap<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("isSuccess", String.valueOf(this.jdField_b_of_type_Boolean));
    localHashMap.put("server_ip", this.jdField_a_of_type_JavaLangString);
    localHashMap.put("server_port", this.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_FailCode", this.jdField_c_of_type_JavaLangString);
    localHashMap.put("param_reason", this.jdField_d_of_type_JavaLangString);
    localHashMap.put("param_errorDesc", this.e);
    localHashMap.put("chatType", this.f);
    localHashMap.put("chatUin", this.g);
    localHashMap.put("file_url", this.h);
    localHashMap.put("http_errorCode", this.i);
    localHashMap.put("md5", this.j);
    localHashMap.put("uuid", this.k);
    localHashMap.put("business_type", this.l);
    localHashMap.put("param_time_cost", String.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("filesize", String.valueOf(this.jdField_b_of_type_Long));
    localHashMap.put("param_Ipv6Policy", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("msfConnIPType", String.valueOf(this.jdField_c_of_type_Int));
    localHashMap.put("ipStackType", String.valueOf(this.jdField_b_of_type_Int));
    localHashMap.put("param_ipType", String.valueOf(this.jdField_d_of_type_Int));
    if (this.jdField_a_of_type_Boolean) {}
    for (int n = 1;; n = 0)
    {
      localHashMap.put("param_isHttps", String.valueOf(n));
      localHashMap.put("param_Ip_ConnCost", this.m);
      return localHashMap;
    }
  }
  
  private void a()
  {
    this.jdField_b_of_type_Int = NetConnInfoCenter.getActiveNetIpFamily(true);
    this.jdField_c_of_type_Int = MsfServiceSdk.get().getConnectedIPFamily();
    this.jdField_d_of_type_Int = a(this.jdField_a_of_type_JavaLangString);
  }
  
  private void a(String paramString, HashMap<String, String> paramHashMap)
  {
    bctj.a(BaseApplication.getContext()).a(null, paramString, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, paramHashMap, "");
    String str;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("report , reportName = ").append(paramString).append(", mServerIp = ");
      if (this.jdField_a_of_type_JavaLangString == null)
      {
        str = "null";
        QLog.d("RMServMonitorReport", 2, str + " , mTimeCost = " + this.jdField_a_of_type_Long);
      }
    }
    else if (this.jdField_d_of_type_Int == 2)
    {
      bctj.a(BaseApplication.getContext()).a(null, paramString + "_ipv6", this.jdField_b_of_type_Boolean, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, paramHashMap, "");
      if (QLog.isColorLevel())
      {
        paramHashMap = new StringBuilder().append("report , reportName = ").append(paramString).append("_ipv6, mServerIp = ");
        if (this.jdField_a_of_type_JavaLangString != null) {
          break label217;
        }
      }
    }
    label217:
    for (paramString = "null";; paramString = this.jdField_a_of_type_JavaLangString)
    {
      QLog.d("RMServMonitorReport", 2, paramString + " , mTimeCost = " + this.jdField_a_of_type_Long);
      return;
      str = this.jdField_a_of_type_JavaLangString;
      break;
    }
  }
  
  protected int a(String paramString)
  {
    int i1 = 3;
    int n = i1;
    if (paramString != null)
    {
      paramString = paramString.replaceAll("[\\[\\]]", "");
      n = i1;
      if (paramString != null)
      {
        if (!bdvy.b(paramString)) {
          break label34;
        }
        n = 2;
      }
    }
    label34:
    do
    {
      return n;
      n = i1;
    } while (!bdvy.a(paramString));
    return 1;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.jdField_a_of_type_JavaLangString != null))
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_a_of_type_JavaLangString)) {
        return;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
    a();
    a(paramString, a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bedj
 * JD-Core Version:    0.7.0.1
 */