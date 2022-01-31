import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class bawi
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
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  
  public bawi()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.jdField_a_of_type_JavaLangString != null)) {
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_a_of_type_JavaLangString)) {}
    }
    HashMap localHashMap;
    label501:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaLangString);
        this.jdField_b_of_type_Boolean = paramBoolean;
        this.jdField_b_of_type_Int = NetConnInfoCenter.getActiveNetIpFamily(true);
        this.jdField_c_of_type_Int = MsfServiceSdk.get().getConnectedIPFamily();
        if (this.jdField_a_of_type_JavaLangString != null)
        {
          localObject = this.jdField_a_of_type_JavaLangString.replaceAll("[\\[\\]]", "");
          if (localObject != null) {
            this.jdField_a_of_type_Boolean = baui.a((String)localObject);
          }
        }
        localHashMap = new HashMap();
        localHashMap.put("isSuccess", String.valueOf(this.jdField_b_of_type_Boolean));
        if (this.jdField_a_of_type_JavaLangString != null) {
          localHashMap.put("server_ip", this.jdField_a_of_type_JavaLangString);
        }
        if (this.jdField_b_of_type_JavaLangString != null) {
          localHashMap.put("server_port", this.jdField_b_of_type_JavaLangString);
        }
        if (this.jdField_c_of_type_JavaLangString != null) {
          localHashMap.put("param_FailCode", this.jdField_c_of_type_JavaLangString);
        }
        if (this.d != null) {
          localHashMap.put("param_reason", this.d);
        }
        if (this.e != null) {
          localHashMap.put("param_errorDesc", this.e);
        }
        if (this.f != null) {
          localHashMap.put("chatType", this.f);
        }
        if (this.g != null) {
          localHashMap.put("chatUin", this.g);
        }
        if (this.h != null) {
          localHashMap.put("file_url", this.h);
        }
        if (this.i != null) {
          localHashMap.put("http_errorCode", this.i);
        }
        if (this.j != null) {
          localHashMap.put("md5", this.j);
        }
        if (this.k != null) {
          localHashMap.put("uuid", this.k);
        }
        if (this.l != null) {
          localHashMap.put("business_type", this.l);
        }
        localHashMap.put("param_time_cost", String.valueOf(this.jdField_a_of_type_Long));
        localHashMap.put("filesize", String.valueOf(this.jdField_b_of_type_Long));
        localHashMap.put("param_Ipv6Policy", String.valueOf(this.jdField_a_of_type_Int));
        localHashMap.put("ipStackType", String.valueOf(this.jdField_b_of_type_Int));
        localHashMap.put("msfConnIPType", String.valueOf(this.jdField_c_of_type_Int));
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        localHashMap.put("param_is_ipv6", String.valueOf(1));
        azri.a(BaseApplication.getContext()).a(null, paramString, paramBoolean, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, localHashMap, "");
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("report , reportName = ").append(paramString).append(", mServerIp = ");
          if (this.jdField_a_of_type_JavaLangString != null) {
            break label657;
          }
          localObject = "null";
          QLog.d("RMServMonitorReport", 2, (String)localObject + " , mTimeCost = " + this.jdField_a_of_type_Long);
        }
      } while (!this.jdField_a_of_type_Boolean);
      azri.a(BaseApplication.getContext()).a(null, paramString + "_ipv6", paramBoolean, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, localHashMap, "");
    } while (!QLog.isColorLevel());
    Object localObject = new StringBuilder().append("report , reportName = ").append(paramString).append("_ipv6, mServerIp = ");
    if (this.jdField_a_of_type_JavaLangString == null) {}
    for (paramString = "null";; paramString = this.jdField_a_of_type_JavaLangString)
    {
      QLog.d("RMServMonitorReport", 2, paramString + " , mTimeCost = " + this.jdField_a_of_type_Long);
      return;
      localHashMap.put("param_is_ipv6", String.valueOf(0));
      break;
      label657:
      localObject = this.jdField_a_of_type_JavaLangString;
      break label501;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bawi
 * JD-Core Version:    0.7.0.1
 */