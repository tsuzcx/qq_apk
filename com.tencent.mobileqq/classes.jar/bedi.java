import com.tencent.qphone.base.util.BaseApplication;
import java.net.URL;
import java.util.HashMap;

public class bedi
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  boolean b;
  public int c;
  public long c;
  public String c;
  boolean c;
  public int d;
  private boolean d;
  
  public bedi(bdvs parambdvs, bdwt parambdwt)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    boolean bool;
    if (parambdwt.jdField_a_of_type_Int == 0) {
      bool = true;
    }
    for (;;)
    {
      this.jdField_d_of_type_Boolean = bool;
      this.jdField_a_of_type_Long = parambdwt.g;
      this.jdField_b_of_type_Long = parambdwt.h;
      this.jdField_a_of_type_JavaLangString = parambdvs.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_JavaLangString != null) {}
      try
      {
        this.jdField_b_of_type_JavaLangString = new URL(this.jdField_a_of_type_JavaLangString).getHost();
        label79:
        this.jdField_a_of_type_Boolean = parambdvs.f;
        this.jdField_a_of_type_Int = parambdvs.jdField_a_of_type_Int;
        this.jdField_b_of_type_Int = parambdwt.jdField_b_of_type_Int;
        this.jdField_c_of_type_JavaLangString = parambdwt.jdField_a_of_type_JavaLangString;
        this.jdField_c_of_type_Int = parambdwt.jdField_c_of_type_Int;
        this.jdField_d_of_type_Int = parambdwt.jdField_d_of_type_Int;
        this.jdField_c_of_type_Long = parambdwt.jdField_b_of_type_Long;
        this.jdField_b_of_type_Boolean = parambdvs.i;
        this.jdField_c_of_type_Boolean = parambdvs.jdField_b_of_type_Boolean;
        return;
        bool = false;
      }
      catch (Exception localException)
      {
        break label79;
      }
    }
  }
  
  private HashMap<String, String> a()
  {
    int j = 1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("isSuccess", String.valueOf(this.jdField_d_of_type_Boolean));
    localHashMap.put("param_time_cost", String.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("param_inQueueCost", "" + this.jdField_b_of_type_Long);
    localHashMap.put("param_url", this.jdField_a_of_type_JavaLangString);
    localHashMap.put("param_Host", this.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean)
    {
      i = 1;
      localHashMap.put("param_isHttps", String.valueOf(i));
      localHashMap.put("param_method", String.valueOf(this.jdField_a_of_type_Int));
      localHashMap.put("param_FailCode", String.valueOf(this.jdField_b_of_type_Int));
      localHashMap.put("param_errorDesc", this.jdField_c_of_type_JavaLangString);
      localHashMap.put("param_HttpCode", String.valueOf(this.jdField_c_of_type_Int));
      localHashMap.put("param_tryTimes", String.valueOf(this.jdField_d_of_type_Int));
      localHashMap.put("param_fileTransSize", String.valueOf(this.jdField_c_of_type_Long));
      if (!this.jdField_b_of_type_Boolean) {
        break label237;
      }
      i = 1;
      label199:
      localHashMap.put("param_IsSync", String.valueOf(i));
      if (!this.jdField_c_of_type_Boolean) {
        break label242;
      }
    }
    label237:
    label242:
    for (int i = j;; i = 0)
    {
      localHashMap.put("param_IsInnerDns", String.valueOf(i));
      return localHashMap;
      i = 0;
      break;
      i = 0;
      break label199;
    }
  }
  
  public void a()
  {
    HashMap localHashMap = a();
    bctj.a(BaseApplication.getContext()).a(null, "actHttpEngineTrans", this.jdField_d_of_type_Boolean, this.jdField_a_of_type_Long, this.jdField_c_of_type_Long, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bedi
 * JD-Core Version:    0.7.0.1
 */